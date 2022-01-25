package com.seeuletter.net;

import com.seeuletter.exception.APIException;
import com.seeuletter.exception.AuthenticationException;
import com.seeuletter.exception.InvalidRequestException;
import com.seeuletter.exception.RateLimitException;

import java.io.IOException;
import java.util.Map;

public abstract class APIResource  {

    private static ResponseGetter responseGetter = new ResponseGetter();

    public static final String CHARSET = "UTF-8";

    public enum RequestMethod {
        GET, POST, PUT, DELETE
    }

    public enum RequestType {
        NORMAL, MULTIPART, JSON
    }

    public static <T> SeeuletterResponse<T> request(APIResource.RequestMethod method, APIResource.RequestType type,
                                  String url, Map<String, Object> params, Class<T> clazz,
                                  RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException {
        return responseGetter.request(method, url, params, clazz, type, options);
    }

}
