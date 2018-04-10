package com.patterns.statefulObserverPattern.web;

import com.patterns.statefulObserverPattern.core.IndexStatefulObserver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IndexStatefulObserverImpl implements IndexStatefulObserver<ResponseEntity<String>> {

    private ResponseEntity<String> response;

    @Override
    public void successResponse() {
        response = new ResponseEntity<>("successResponse", HttpStatus.OK);
    }

    @Override
    public void errorResponse() {
        response = new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<String> getResponse() {
        return response;
    }
}
