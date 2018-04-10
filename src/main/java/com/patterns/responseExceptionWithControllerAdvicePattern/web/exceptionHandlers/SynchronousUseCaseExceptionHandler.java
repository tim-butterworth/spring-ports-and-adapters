package com.patterns.responseExceptionWithControllerAdvicePattern.web.exceptionHandlers;

import com.patterns.responseExceptionWithControllerAdvicePattern.core.SynchronousUseCaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class SynchronousUseCaseExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(SynchronousUseCaseException.class)
    @ResponseBody public String handleBadRequest(HttpServletRequest request, Exception exception) {
        return exception.getLocalizedMessage();
    }
}
