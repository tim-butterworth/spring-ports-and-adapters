package com.example.usecases;

import com.example.clients.ServiceClient;
import com.example.usecases.ObserverInterfaces.IndexAsynchronousObserver;


public class IndexAsynchronousUseCase {

    private ServiceClient serviceClient;

    public IndexAsynchronousUseCase(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    public void execute(String value, IndexAsynchronousObserver observer) {
        String result = serviceClient.getTheData(value);

        if("successResponse".equals(result)) {
            observer.success();
        } else {
            observer.error();
        }
    }

}
