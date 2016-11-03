package com.example.controllers;

import com.example.responders.StatelessObserver;
import com.example.usecases.IndexStatelessUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("withastatelessobservercontroller")
public class WithAStatelessObserverController {

    private StatelessObserver<ResponseEntity<?>> statelessObserver;
    private IndexStatelessUseCase indexStatelessUseCase;

    @Autowired
    public WithAStatelessObserverController(
            StatelessObserver<ResponseEntity<?>> statelessObserver,
            IndexStatelessUseCase indexStatelessUseCase
    ){
        this.statelessObserver = statelessObserver;
        this.indexStatelessUseCase = indexStatelessUseCase;
    }

    @RequestMapping("/index/{value}")
    public ResponseEntity<?> index(@PathVariable String value) {
        return indexStatelessUseCase.execute(statelessObserver, value).getData();
    }
}
