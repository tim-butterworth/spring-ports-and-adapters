package com.patterns.humbleObjectPattern;

import javax.servlet.http.HttpServletResponse;

public interface HumbleObjectObserver {
    void successResponse(HttpServletResponse response);

    void errorResponse(HttpServletResponse response);
}
