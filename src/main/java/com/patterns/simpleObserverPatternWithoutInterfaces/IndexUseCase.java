package com.patterns.simpleObserverPatternWithoutInterfaces;

import com.clients.ServiceClient;
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

    public ResponseEntity<String> execute(IndexObserver indexObserver, String value) {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            return indexObserver.successResponse();
        } else {
            return indexObserver.errorResponse();
        }
    }
}
