package com.example.usecases;

import com.example.clients.ServiceClient;
import com.example.responders.IndexStatefulObserver;

public class IndexStatefulUseCase {

    private ServiceClient serviceClient;

    public IndexStatefulUseCase(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public void execute(IndexStatefulObserver indexStatefulObserver, String value) {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            indexStatefulObserver.successResponse();
        } else {
            indexStatefulObserver.errorResponse();
        }
    }
}
