package com.example.responders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class IndexStatefulObserver {

    private ResponseEntity<?> response;

    public void successResponse() {
        response = new ResponseEntity<>("successResponse", HttpStatus.OK);
    }

    public void errorResponse() {
        response = new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<?> getResponse() {
        return response;
    }
}
