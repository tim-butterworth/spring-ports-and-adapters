package com.example.usecases;

import com.example.clients.ServiceClient;
import com.example.responders.StatelessObserver;
import com.example.usecases.models.UseCaseResponse;

public class IndexStatelessUseCase {

    private ServiceClient serviceClient;

    public IndexStatelessUseCase(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public <T> UseCaseResponse<T> execute(StatelessObserver<T> statelessObserver, String value) {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            return statelessObserver.successResponse();
        } else {
            return statelessObserver.errorResponse();
        }
    }
}
