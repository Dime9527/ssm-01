package com.smart.wen.utils;

import lombok.Builder;
import lombok.Data;

/*
* 构建者模式
* */
@Data
@Builder
public class ResponseEntity<T> {
    private int status;
    private String message;
    private T data;

    public static <T> ResponseEntity<T> success(T data){
        return (ResponseEntity<T>) ResponseEntity
                .builder()
                .data(data)
                .message(ErrorStatus.SUCCESS.getMessage())
                .status(ErrorStatus.SUCCESS.getStatus())
                .build();

    }

    public static <T> ResponseEntity<T> serviceError(){
        return (ResponseEntity<T>) ResponseEntity
                .builder()
                .message(ErrorStatus.SERVICE_ERROR.getMessage())
                .status(ErrorStatus.SERVICE_ERROR.getStatus())
                .build();

    }

    public static <T> ResponseEntity<T> sysError(){
        return (ResponseEntity<T>) ResponseEntity
                .builder()
                .message(ErrorStatus.SYS_ERROR.getMessage())
                .status(ErrorStatus.SYS_ERROR.getStatus())
                .build();

    }
}
