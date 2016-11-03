package com.example.controllers;

import com.example.responders.IndexStatefulObserver;
import com.example.usecases.IndexStatefulUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("withanobserverstatefulcontroller")
public class WithAnStatefulObserverController {

    private final IndexStatefulUseCase indexStatefulUseCase;

    @Autowired
    public WithAnStatefulObserverController(
            IndexStatefulUseCase indexStatefulUseCase
    ) {
        this.indexStatefulUseCase = indexStatefulUseCase;
    }

    @RequestMapping(value = "/index/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> index(@PathVariable String value) {
        IndexStatefulObserver indexStatefulObserver = new IndexStatefulObserver();

        indexStatefulUseCase.execute(indexStatefulObserver, value);

        return indexStatefulObserver.getResponse();
    }

}
