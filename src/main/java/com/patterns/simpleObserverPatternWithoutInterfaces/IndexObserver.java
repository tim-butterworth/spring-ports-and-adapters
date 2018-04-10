package com.patterns.simpleObserverPatternWithoutInterfaces;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class IndexObserver {

    public ResponseEntity<String> successResponse() {
        return new ResponseEntity<>("successResponse", HttpStatus.OK);
    }

    public ResponseEntity<String> errorResponse() {
        return new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
    }
}
