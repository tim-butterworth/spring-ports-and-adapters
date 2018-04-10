package com.patterns.statefulObserverPattern.web;

import com.patterns.statefulObserverPattern.core.IndexStatefulObserver;
import com.patterns.statefulObserverPattern.core.IndexStatefulUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("withanobserverstatefulcontroller")
public class WithAStatefulObserverController {

    private final IndexStatefulUseCase indexStatefulUseCase;

    @Autowired
    public WithAStatefulObserverController(
            IndexStatefulUseCase indexStatefulUseCase
    ) {
        this.indexStatefulUseCase = indexStatefulUseCase;
    }

    @RequestMapping(value = "/index/{value}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> index(@PathVariable String value) {
        IndexStatefulObserver<ResponseEntity<String>> indexStatefulObserver = new IndexStatefulObserverImpl();

        indexStatefulUseCase.execute(indexStatefulObserver, value);

        return indexStatefulObserver.getResponse();
    }

}
