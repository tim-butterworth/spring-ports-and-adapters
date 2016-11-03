package com.example.controllers;

import com.example.clients.ServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("standardspringcontroller")
public class StandardSpringController {

    private ServiceClient serviceClient;

    @Autowired
    public StandardSpringController(ServiceClient serviceClient) {
        this.serviceClient = serviceClient;
    }

    @RequestMapping(path = "/index/{value}")
    public ResponseEntity<?> index(@PathVariable String value) {
        String response = serviceClient.getTheData(value);

        if("success".equals(response)) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}
