package com.example.controllers;

import com.example.clients.ServiceClient;
import com.example.usecases.RailsStyleIndexReactor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class HumbleObjectController {

    private final RailsStyleIndexReactor indexReactor;
    private ServiceClient serviceClient;

    @Autowired
    public HumbleObjectController(
            RailsStyleIndexReactor indexReactor,
            ServiceClient serviceClient
    ) {
        this.indexReactor = indexReactor;
        this.serviceClient = serviceClient;
    }

    @RequestMapping(path="/rails/index/{value}")
    public void railsIndex(
            HttpServletResponse response,
            @PathVariable String value
    ) {
        indexReactor.execute(this, serviceClient, response, value);
    }

    public void successResponse(HttpServletResponse response) {
        writeResponse(response, HttpStatus.OK, "We did it!!");
    }

    public void errorResponse(HttpServletResponse response) {
        writeResponse(response, HttpStatus.BAD_REQUEST, "We did not do it!!");
    }

    private void writeResponse(HttpServletResponse response, HttpStatus status, String message) {
        try {
            response.setStatus(status.value());
            response.getWriter().print(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
