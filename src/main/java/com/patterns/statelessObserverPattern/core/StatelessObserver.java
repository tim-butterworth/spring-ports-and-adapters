package com.patterns.statelessObserverPattern.core;

public interface StatelessObserver<T> {
    T successResponse();
    T errorResponse();
}
