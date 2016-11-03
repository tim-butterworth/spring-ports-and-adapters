package com.example.responders;

import com.example.usecases.models.UseCaseResponse;

public interface StatelessObserver<T> {
    UseCaseResponse<T> successResponse();
    UseCaseResponse<T> errorResponse();
}
