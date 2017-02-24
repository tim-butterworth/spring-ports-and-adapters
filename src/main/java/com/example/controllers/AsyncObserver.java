package com.example.controllers;

import com.example.usecases.ObserverInterfaces.IndexAsynchronousObserver;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;


public class AsyncObserver implements IndexAsynchronousObserver {
    private Response deferredResult;

    public AsyncObserver(Response deferredResult) {
        this.deferredResult = deferredResult;
    }

    public void success() {
        complete(ok().body("highfive!"));
    }

    public void error() {
        complete(badRequest().body("wat!"));
    }

    private void complete(ResponseEntity response) {
        this.deferredResult.setResult(response);
    }
}
