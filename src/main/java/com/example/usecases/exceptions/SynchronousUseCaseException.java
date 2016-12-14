package com.example.usecases.exceptions;

import org.springframework.core.NestedRuntimeException;

public class SynchronousUseCaseException extends NestedRuntimeException {
    public SynchronousUseCaseException(String msg) {
        super(msg);
    }
}
