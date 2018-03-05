package com.seeuletter.net;

import com.seeuletter.exception.APIException;
import com.seeuletter.exception.AuthenticationException;
import com.seeuletter.exception.InvalidRequestException;
import com.seeuletter.exception.RateLimitException;

import java.io.IOException;
import java.util.Map;

public interface IResponseGetter {
    <T> SeeuletterResponse<T> request(
            APIResource.RequestMethod method,
            String url,
            Map<String, Object> params,
            Class<T> clazz,
            APIResource.RequestType type,
            RequestOptions options) throws AuthenticationException, APIException, RateLimitException, InvalidRequestException, IOException;
}
