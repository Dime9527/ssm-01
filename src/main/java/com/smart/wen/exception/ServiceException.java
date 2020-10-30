package com.smart.wen.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServiceException extends RuntimeException{
    private int status;

    public ServiceException(String message, int status) {
        super(message);
        this.status = status;
    }
}
