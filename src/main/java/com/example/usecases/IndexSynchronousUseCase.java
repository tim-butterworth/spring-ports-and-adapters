package com.example.usecases;

import com.example.clients.ServiceClient;
import com.example.usecases.exceptions.SynchronousUseCaseException;

public class IndexSynchronousUseCase {

    private ServiceClient serviceClient;

    public IndexSynchronousUseCase(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public String execute(String value) throws SynchronousUseCaseException {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            return result;
        } else {
            throw new SynchronousUseCaseException(result);
        }
    }
}
