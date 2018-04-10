package com.patterns.humbleObjectPattern.core;

import com.clients.ServiceClient;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;

@Component
public class HumbleObjectUseCase {

    public void execute(
            HumbleObjectObserver indexResponder,
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
