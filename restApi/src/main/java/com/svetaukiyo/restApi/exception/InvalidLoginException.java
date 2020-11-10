package com.svetaukiyo.restApi.exception;

public class InvalidLoginException extends BaseException {

    public InvalidLoginException(String message, int errorCodes) {
        super(message, errorCodes);
    }
}
