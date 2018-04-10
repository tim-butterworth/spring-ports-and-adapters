package com.patterns.statelessObserverPattern.web;

import com.patterns.statelessObserverPattern.core.StatelessObserver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StatelessObserverImpl implements StatelessObserver<ResponseEntity<String>> {

    @Override
    public ResponseEntity<String> successResponse() {
        return new ResponseEntity<>("successResponse", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> errorResponse() {
        return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
    }
}
