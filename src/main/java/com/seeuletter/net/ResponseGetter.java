package com.seeuletter.net;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.seeuletter.Seeuletter;
import com.seeuletter.exception.APIException;
import com.seeuletter.exception.AuthenticationException;
import com.seeuletter.exception.InvalidRequestException;
import com.seeuletter.exception.RateLimitException;
import org.apache.commons.codec.binary.Base64;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static com.seeuletter.net.APIResource.CHARSET;
import static com.seeuletter.net.APIResource.RequestMethod.DELETE;
import static com.seeuletter.net.APIResource.RequestMethod.POST;

public class ResponseGetter implements IResponseGetter {

    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_INSTANT.withZone(ZoneId.of("UTC"));
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .registerModule(new JavaTimeModule())
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    private static final class Parameter {
        public final String key;
        public final Object value;

        public Parameter(String key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    @Override
    public <T> SeeuletterResponse<T> request(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            Class<T> clazz,
            APIResource.RequestType type,
            RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        return _request(method, url, params, clazz, type, options);
    }

    static Map<String, String> getHeaders(RequestOptions options) {
        Map<String, String> headers = new HashMap<String, String>();

        headers.put("Authorization", String.format("Basic %s", Base64.encodeBase64String((options.getApiKey() + ":").getBytes())));
        headers.put("User-Agent", String.format("SeeuletterJava/%s JDK/%s", Seeuletter.VERSION, System.getProperty("java.version")));

        if (options.getSeeuletterVersion() != null) {
            headers.put("Seeuletter-Version", options.getSeeuletterVersion());
        }

        if (options.getIdempotencyKey() != null) {
            headers.put("Idempotency-Key", options.getIdempotencyKey());
        }

        return headers;
    }

    private static java.net.HttpURLConnection createDefaultConnection(String url, RequestOptions options) throws IOException {
        URL seeuletterURL = new URL(url);

        HttpURLConnection conn = (HttpURLConnection) seeuletterURL.openConnection();
        conn.setUseCaches(false);
        for (Map.Entry<String, String> header : getHeaders(options).entrySet()) {
            conn.setRequestProperty(header.getKey(), header.getValue());
        }

        return conn;
    }

    private static java.net.HttpURLConnection createGetConnection(String url, String query, RequestOptions options) throws IOException {
        String getURL = query.isEmpty() ? url : String.format("%s?%s", url, query);
        java.net.HttpURLConnection conn = createDefaultConnection(getURL, options);

        conn.setRequestMethod("GET");

        return conn;
    }

    private static java.net.HttpURLConnection createPostConnection(String url, String query, RequestOptions options) throws IOException {
        java.net.HttpURLConnection conn = createDefaultConnection(url, options);

        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", String.format("application/x-www-form-urlencoded;charset=%s", APIResource.CHARSET));

        try (OutputStream output = conn.getOutputStream()) {
            output.write(query.getBytes(APIResource.CHARSET));
        }
        return conn;
    }

    private static java.net.HttpURLConnection createDeleteConnection(String url, RequestOptions options) throws IOException {
        java.net.HttpURLConnection conn = createDefaultConnection(url, options);

        conn.setRequestMethod("DELETE");

        return conn;
    }

    static String createQuery(Map<String, Object> params) throws UnsupportedEncodingException {
        if (params == null) {
            return "";
        }

        StringBuilder queryStringBuffer = new StringBuilder();
        List<Parameter> flatParams = flattenParams(params);
        Iterator<Parameter> it = flatParams.iterator();

        while (it.hasNext()) {
            if (queryStringBuffer.length() > 0) {
                queryStringBuffer.append("&");
            }
            Parameter param = it.next();
            queryStringBuffer.append(urlEncodePair(param.key, param.value.toString()));
        }

        return queryStringBuffer.toString();
    }

    private static String urlEncodePair(String key, String value) throws UnsupportedEncodingException {
        return String.format("%s=%s", URLEncoder.encode(key, CHARSET), URLEncoder.encode(value, CHARSET));
    }

    private static List<Parameter> flattenParams(Map<String, Object> params) {
        return flattenParamsMap(params, null);
    }

    private static List<Parameter> flattenParamsMap(Map<String, Object> params, String keyPrefix) {
        List<Parameter> flatParams = new LinkedList<Parameter>();
        if (params == null) {
            return flatParams;
        }

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();

            String newPrefix = key;
            if (keyPrefix != null) {
                newPrefix = String.format("%s[%s]", keyPrefix, key);
            }

            flatParams.addAll(flattenParamsValue(value, newPrefix));
        }

        return flatParams;
    }

    @SuppressWarnings("unchecked")
    private static List<Parameter> flattenParamsValue(Object value, String keyPrefix) {
        List<Parameter> flatParams;

        if (value instanceof Map<?, ?>) {
            flatParams = flattenParamsMap((Map<String, Object>) value, keyPrefix);
        } else if (value instanceof List) {
            flatParams = new LinkedList<Parameter>();
            for (Object item : (List<Object>) value) {
                flatParams.add(new Parameter(keyPrefix + "[]", item));
            }
        } else if (value instanceof File) {
            flatParams = new LinkedList<Parameter>();
            flatParams.add(new Parameter(keyPrefix, value));
        } else if (value instanceof ZonedDateTime) {
            flatParams = new LinkedList<Parameter>();
            flatParams.add(new Parameter(keyPrefix, DATE_FORMATTER.format(((ZonedDateTime) value))));
        } else {
            flatParams = new LinkedList<Parameter>();
            flatParams.add(new Parameter(keyPrefix, value.toString()));
        }

        return flatParams;
    }

    private static <T> SeeuletterResponse<T> handleConnectionResponse(HttpURLConnection conn, Class<T> clazz) throws IOException, InvalidRequestException, RateLimitException, APIException {
        int responseCode = conn.getResponseCode();

        if (responseCode >= 200 && responseCode < 300) {
            Map<String, List<String>> headers = conn.getHeaderFields();
            T value = MAPPER.readValue(conn.getInputStream(), clazz);

            return new SeeuletterResponse<T>(responseCode, value, headers);
        } else if (responseCode == 422) {
            throw MAPPER.readValue(conn.getErrorStream(), InvalidRequestException.class);
        } else if (responseCode == 429) {
            throw MAPPER.readValue(conn.getErrorStream(), RateLimitException.class);
        } else {
            throw MAPPER.readValue(conn.getErrorStream(), APIException.class);
        }
    }

    private static <T> SeeuletterResponse<T> makeURLConnectionRequest(APIResource.RequestMethod method, Class<T> clazz, String url, String query, RequestOptions options) throws APIException, RateLimitException, InvalidRequestException, IOException {
        java.net.HttpURLConnection conn = null;
        try {
            if (method == POST) {
                conn = createPostConnection(url, query, options);
            } else if (method == DELETE) {
                conn = createDeleteConnection(url, options);
            } else {
                conn = createGetConnection(url, query, options);
            }

            return handleConnectionResponse(conn, clazz);
        } catch (IOException e) {
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
        }
    }

    private static <T> SeeuletterResponse<T> makeMultipartConnectionRequest(APIResource.RequestMethod method, Class<T> clazz, String url, Map<String, Object> params, RequestOptions options) throws IOException, InvalidRequestException, APIException, RateLimitException {
        java.net.HttpURLConnection conn = createDefaultConnection(url, options);
        String boundary = MultipartProcessor.getBoundary();

        conn.setDoOutput(true);
        conn.setRequestMethod(method.name());
        conn.setRequestProperty("Content-Type", String.format("multipart/form-data; boundary=%s", boundary));

        MultipartProcessor multipartProcessor = null;
        try {
            multipartProcessor = new MultipartProcessor(conn, boundary, APIResource.CHARSET);

            for (Parameter p : flattenParams(params)) {
                if (p.value instanceof File) {
                    File currentFile = (File) p.value;
                    multipartProcessor.addFileField(p.key, currentFile);
                } else {
                    multipartProcessor.addFormField(p.key, p.value.toString());
                }
            }

        } finally {
            if (multipartProcessor != null) {
                multipartProcessor.finish();
            }
        }

        return handleConnectionResponse(conn, clazz);
    }


    private static <T> SeeuletterResponse<T> _request(APIResource.RequestMethod method,
                                  String url, Map<String, Object> params, Class<T> clazz,
                                  APIResource.RequestType type, RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        if (options == null) {
            options = RequestOptions.getDefault();
        }

        String apiKey = options.getApiKey();
        if (apiKey == null || apiKey.trim().length() == 0) {
            throw new AuthenticationException("Missing API Key. Make sure 'Seeuletter.init(<API_KEY>)' is called with a key from your Dashboard.", null);
        }

        String seeuletterURL = String.format("%s%s", Seeuletter.API_BASE_URL, url);

        if (type == APIResource.RequestType.MULTIPART) {
            return makeMultipartConnectionRequest(method, clazz, seeuletterURL, params, options);
        }

        String query = createQuery(params);
        return makeURLConnectionRequest(method, clazz, seeuletterURL, query, options);
    }

}
