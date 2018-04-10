package com.patterns.statelessObserverPattern.core;

import com.clients.ServiceClient;

public class IndexStatelessUseCase {

    private ServiceClient serviceClient;

    public IndexStatelessUseCase(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public <T> T execute(StatelessObserver<T> statelessObserver, String value) {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            return statelessObserver.successResponse();
        } else {
            return statelessObserver.errorResponse();
        }
    }
}
