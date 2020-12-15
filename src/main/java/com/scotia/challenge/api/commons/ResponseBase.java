package com.scotia.challenge.api.commons;

import static com.scotia.challenge.api.commons.DefaultResponseCode.DEFAULT_ERROR_CODE;
import static com.scotia.challenge.api.commons.DefaultResponseCode.SUCCESS;
import static com.scotia.challenge.api.commons.DefaultResponseCode.SUCCESS_CODE;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseBase {

    private Integer code;
    private String message;
    private Object body;

    public static ResponseBase buildSuccessResponse(Object body) {
        return ResponseBase.builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS)
                .body(body)
                .build();
    }

    public static ResponseBase buildSuccessWithOutBodyResponse() {
        return ResponseBase.builder()
                .code(SUCCESS_CODE)
                .message(SUCCESS)
                .build();
    }

    public static ResponseBase buildErrorResponse(String errorMessage) {
        return ResponseBase.builder()
                .code(DEFAULT_ERROR_CODE)
                .message(errorMessage)
                .build();
    }

}
