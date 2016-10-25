package com.example.usecases;

import com.example.clients.ServiceClient;
import com.example.controllers.HumbleObjectController;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class RailsStyleIndexReactor {

    public void execute(
            HumbleObjectController indexResponder,
            ServiceClient serviceClient,
            HttpServletResponse response,
            String value
    ) {
        String theData = serviceClient.getTheData(value);

        if("successResponse".equals(theData)) {
            indexResponder.successResponse(response);
        } else {
            indexResponder.errorResponse(response);
        }
    }
}
