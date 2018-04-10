package com.patterns.statefulObserverPattern.core;

public interface IndexStatefulObserver<T> {
    void successResponse();

    void errorResponse();

    T getResponse();
}
