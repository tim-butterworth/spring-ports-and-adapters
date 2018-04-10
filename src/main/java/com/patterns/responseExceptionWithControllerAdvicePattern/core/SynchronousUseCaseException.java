package com.patterns.responseExceptionWithControllerAdvicePattern.core;

import org.springframework.core.NestedRuntimeException;

public class SynchronousUseCaseException extends NestedRuntimeException {
    public SynchronousUseCaseException(String msg) {
        super(msg);
    }
}
