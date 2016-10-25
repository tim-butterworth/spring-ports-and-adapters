package com.example.clients;

import org.springframework.stereotype.Component;

@Component
public class ServiceClient {
    public String getTheData(String value) {
        if(value.equals("successResponse")) {
            return "successResponse";
        } else {
            return "errorResponse";
        }
    }
}
