package com.patterns.humbleObjectPattern.core;

import javax.servlet.http.HttpServletResponse;

public interface HumbleObjectObserver {
    void successResponse(HttpServletResponse response);

    void errorResponse(HttpServletResponse response);
}
