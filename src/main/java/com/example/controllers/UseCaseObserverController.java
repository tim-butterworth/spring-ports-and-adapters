package com.example.controllers;

import com.example.usecases.ThingsUseCase;
import com.example.usecases.ThingsUseCase.MoreThingsObserver;
import com.example.usecases.ThingsUseCase.ThingsDidntGoAccordingToPlanException;
import com.example.usecases.models.Thing;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

@RestController
public class UseCaseObserverController {

    private final ThingsUseCase useCase;

    public UseCaseObserverController(ThingsUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/things/1")
    public Thing one() {
        useCase.doACoolThing(new Thing(), thing -> {
            return;
        });

        return null;
    }

    @GetMapping("/things")
    public ResponseEntity<Thing> two() {
        DoMoreThingsObserver observer = new DoMoreThingsObserver();

        useCase.doMoreThings(new Thing(), observer);

        return observer.response();
    }

    @GetMapping("/things/1")
    public Thing oneMoreThing() {
        return useCase.doAnExceptionalThing();
    }

    private static class DoMoreThingsObserver implements MoreThingsObserver {
        private ResponseEntity<Thing> response;

        @Override
        public void thingWasSuccessful(Thing thing) {
            response = new ResponseEntity<>(thing, OK);
        }

        @Override
        public void thingFailed(Map<String, String> errors) {
            response = new ResponseEntity<>(UNPROCESSABLE_ENTITY);
        }

        @Override
        public void somethingElseHappened(String message) {
            response = new ResponseEntity<>(I_AM_A_TEAPOT);
        }

        public ResponseEntity<Thing> response() {
            return response;
        }
    }

    @ExceptionHandler(ThingsDidntGoAccordingToPlanException.class)
    public ResponseEntity<Map<String,String>> thingHappened(Exception exception) {
        Map<String,String> errors = new HashMap<>();
        errors.put("thing", exception.getMessage());

        return new ResponseEntity<>(errors, IM_USED);
    }
}
