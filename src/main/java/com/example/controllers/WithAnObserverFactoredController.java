package com.example.controllers;

import com.example.usecases.IndexUseCase;
import com.example.responders.IndexObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("withanobserverfactoredcontroller")
public class WithAnObserverFactoredController {

    private final IndexUseCase indexUseCase;
    private final IndexObserver indexObserver;

    @Autowired
    public WithAnObserverFactoredController(
            IndexUseCase indexUseCase,
            IndexObserver indexObserver
    ) {
        this.indexUseCase = indexUseCase;
        this.indexObserver = indexObserver;
    }

    @RequestMapping(value = "/index/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> index(@PathVariable String value) {
        return indexUseCase.execute(indexObserver, value);
    }
}
