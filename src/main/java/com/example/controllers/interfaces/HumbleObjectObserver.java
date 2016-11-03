package com.example.controllers.interfaces;

import javax.servlet.http.HttpServletResponse;

public interface HumbleObjectObserver {
    void successResponse(HttpServletResponse response);

    void errorResponse(HttpServletResponse response);
}
