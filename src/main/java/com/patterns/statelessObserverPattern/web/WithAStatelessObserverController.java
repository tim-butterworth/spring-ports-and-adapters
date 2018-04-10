package com.patterns.statelessObserverPattern.web;

import com.patterns.statelessObserverPattern.core.IndexStatelessUseCase;
import com.patterns.statelessObserverPattern.core.StatelessObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("withastatelessobservercontroller")
public class WithAStatelessObserverController {

    private StatelessObserver<ResponseEntity<String>> statelessObserver;
    private IndexStatelessUseCase indexStatelessUseCase;

    @Autowired
    public WithAStatelessObserverController(
            StatelessObserver<ResponseEntity<String>> statelessObserver,
            IndexStatelessUseCase indexStatelessUseCase
    ){
        this.statelessObserver = statelessObserver;
        this.indexStatelessUseCase = indexStatelessUseCase;
    }

    @RequestMapping("/index/{value}")
    public ResponseEntity<String> index(@PathVariable String value) {
        return indexStatelessUseCase.execute(statelessObserver, value);
    }
}
