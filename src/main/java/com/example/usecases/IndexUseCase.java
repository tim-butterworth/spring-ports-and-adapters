package com.example.usecases;

import com.example.clients.ServiceClient;
import com.example.responders.IndexObserver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class IndexUseCase {

    private final ServiceClient serviceClient;

    @Autowired
    public IndexUseCase(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public ResponseEntity<?> execute(IndexObserver indexObserver, String value) {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            return indexObserver.successResponse();
        } else {
            return indexObserver.errorResponse();
        }
    }
}
