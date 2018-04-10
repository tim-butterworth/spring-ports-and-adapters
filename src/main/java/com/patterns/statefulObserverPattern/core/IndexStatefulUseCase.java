package com.patterns.statefulObserverPattern.core;

import com.clients.ServiceClient;

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
