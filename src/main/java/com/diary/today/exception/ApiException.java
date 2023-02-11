package com.diary.today.exception;

import com.diary.today.enums.common.ApiExceptionType;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ApiException extends Exception {

    private final ApiExceptionType type;
    private String[] args;

    public ApiException(ApiExceptionType type) {
        this.type = type;
    }

    public ApiException(ApiExceptionType type, String... args) {
        this.type = type;
        this.args = args;
    }

}
