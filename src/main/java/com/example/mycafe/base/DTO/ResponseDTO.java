package com.example.mycafe.base.DTO;

import com.example.mycafe.base.constant.Code;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class ResponseDTO {
    private final Boolean success;
    private final Integer code;
    private final String message;

    public static ResponseDTO of(Boolean success, Code code) {
        return new ResponseDTO(success, code.getCode(), code.getMessage());
    }

    public static ResponseDTO of(Boolean success, Code errorCode, Exception e) {
        return new ResponseDTO(success, errorCode.getCode(), errorCode.getMessage(e));
    }

    public static ResponseDTO of(Boolean success, Code errorCode, String message) {
        return new ResponseDTO(success, errorCode.getCode(), errorCode.getMessage(message));
    }
}
