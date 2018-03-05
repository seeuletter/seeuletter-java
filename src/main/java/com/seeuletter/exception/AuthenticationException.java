package com.seeuletter.exception;

public class AuthenticationException extends SeeuletterException {

    private static final long serialVersionUID = 1L;

    public AuthenticationException(String message, Integer statusCode) {
        super(message, statusCode);
    }

}
