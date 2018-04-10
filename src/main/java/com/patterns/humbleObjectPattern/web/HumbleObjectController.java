package com.patterns.humbleObjectPattern.web;

import com.clients.ServiceClient;
import com.patterns.humbleObjectPattern.core.HumbleObjectObserver;
import com.patterns.humbleObjectPattern.core.HumbleObjectUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Thanks Robert Gallaghar for the suggestion to extract an interface to make this pattern significantly nicer
 */

@RestController
@RequestMapping("humbleobjectcontroller")
public class HumbleObjectController implements HumbleObjectObserver {

    private final HumbleObjectUseCase indexReactor;
    private ServiceClient serviceClient;

    @Autowired
    public HumbleObjectController(
            HumbleObjectUseCase indexReactor,
            ServiceClient serviceClient
    ) {
        this.indexReactor = indexReactor;
        this.serviceClient = serviceClient;
    }

    @RequestMapping(path="/index/{value}")
    public void index(
            HttpServletResponse response,
            @PathVariable String value
    ) {
        indexReactor.execute(this, serviceClient, response, value);
    }

    @Override
    public void successResponse(HttpServletResponse response) {
        writeResponse(response, HttpStatus.OK, "We did it!!");
    }

    @Override
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
