package com.clients;

public class ServiceClient {
    public String getTheData(String value) {
        if(value.equals("successResponse")) {
            return "successResponse";
        } else {
            return "errorResponse";
        }
    }
}
