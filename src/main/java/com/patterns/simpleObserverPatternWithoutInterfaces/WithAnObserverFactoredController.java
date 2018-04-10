package com.patterns.simpleObserverPatternWithoutInterfaces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
Because not interfaces are used, there is not real distinction between core and web with this pattern.
Put another way, the observer knows about Spring ResponseEntity.

This captures the basic shape of the usecase observer pattern
 */
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
    public ResponseEntity<String> index(@PathVariable String value) {
        return indexUseCase.execute(indexObserver, value);
    }
}
