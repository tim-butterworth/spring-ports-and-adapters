package com.example.controllers.exceptionHandlers;

import com.example.usecases.exceptions.SynchronousUseCaseException;
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
    @ResponseBody String
    public String handleBadRequest(HttpServletRequest request, Exception exception) {
        return exception.getLocalizedMessage();
    }
}
