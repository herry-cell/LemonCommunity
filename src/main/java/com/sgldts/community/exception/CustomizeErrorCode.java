package com.sgldts.community.exception;

/**
 * @author herry
 * @create 2020-08-12-23:21
 */
public enum CustomizeErrorCode implements ICustomizeErrorCode {
    QUESTION_NOT_FOUND("CustomizeErrorCode");

    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }
}
