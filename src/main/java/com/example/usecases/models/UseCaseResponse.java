package com.example.usecases.models;

public class UseCaseResponse<T> {

    private T data;

    public UseCaseResponse(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }
}
