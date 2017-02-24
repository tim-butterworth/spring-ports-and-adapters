package com.example.controllers;

import com.example.usecases.IndexAsynchronousUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.function.Consumer;

@RestController
@RequestMapping("withanasynchronousobservercontroller")
public class WithAnAsynchronousObserverUseCaseController {

    private IndexAsynchronousUseCase indexAsynchronousUseCase;

    @Autowired
    public WithAnAsynchronousObserverUseCaseController(IndexAsynchronousUseCase indexAsynchronousUseCase) {
        this.indexAsynchronousUseCase = indexAsynchronousUseCase;
    }

    @RequestMapping(value = "/index/{value}")
    public Response index(@PathVariable String value) {
        Response response = new Response();
        indexAsynchronousUseCase.execute(value, new AsyncObserver(response));
        return response;
    }

}

class Response extends DeferredResult<ResponseEntity> {}