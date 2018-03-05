package com.seeuletter.net;

import java.util.List;
import java.util.Map;

public class SeeuletterResponse<T> {

    int responseCode;
    T responseBody;
    Map<String, List<String>> responseHeaders;

    public SeeuletterResponse(int responseCode, T responseBody) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = null;
    }

    public SeeuletterResponse(int responseCode, T responseBody, Map<String, List<String>> responseHeaders) {
        this.responseCode = responseCode;
        this.responseBody = responseBody;
        this.responseHeaders = responseHeaders;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public T getResponseBody() {
        return responseBody;
    }

    public Map<String, List<String>> getResponseHeaders() {
        return responseHeaders;
    }
}
