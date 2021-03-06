package com.patterns.asynchronousObserverPattern.web;

import com.patterns.asynchronousObserverPattern.core.IndexAsynchronousObserver;
import org.springframework.http.ResponseEntity;

import static org.springframework.http.MediaType.TEXT_PLAIN;
import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;


public class AsyncObserver implements IndexAsynchronousObserver {
    private Response deferredResult;

    public AsyncObserver(Response deferredResult) {
        this.deferredResult = deferredResult;
    }

    public void success() {
        complete(
            ok().contentType(TEXT_PLAIN).body("highfive!")
        );
    }

    public void error() {
        complete(badRequest().contentType(TEXT_PLAIN).body("wat!"));
    }

    private void complete(ResponseEntity response) {
        this.deferredResult.setResult(response);
    }
}
