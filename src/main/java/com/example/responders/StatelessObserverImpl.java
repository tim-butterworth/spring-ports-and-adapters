package com.example.responders;

import com.example.usecases.models.UseCaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class StatelessObserverImpl implements StatelessObserver<ResponseEntity<String>> {

    @Override
    public UseCaseResponse<ResponseEntity<String>> successResponse() {
        return new UseCaseResponse<>(new ResponseEntity<>("successResponse", HttpStatus.OK));
    }

    @Override
    public UseCaseResponse<ResponseEntity<String>> errorResponse() {
        return new UseCaseResponse<>(new ResponseEntity<>("failure", HttpStatus.BAD_REQUEST));
    }
}
