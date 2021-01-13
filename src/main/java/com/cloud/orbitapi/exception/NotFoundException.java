package com.cloud.orbitapi.exception;

import lombok.Getter;

/**
 * This is a common runtime exception class for Not Found Errors (400)
 * Accepts error code and error message
 *
 */
@Getter
public class NotFoundException extends RuntimeException {
    private final String code;

    public NotFoundException(String msg, String code) {
        super(msg);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}