package com.example.responders;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class IndexObserver {

    public ResponseEntity<?> successResponse() {
        return new ResponseEntity<Object>("successResponse", HttpStatus.OK);
    }

    public ResponseEntity<?> errorResponse() {
        return new ResponseEntity<Object>("failure", HttpStatus.BAD_REQUEST);
    }
}
