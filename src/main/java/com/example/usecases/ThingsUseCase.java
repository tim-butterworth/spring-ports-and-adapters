package com.example.usecases;

import com.example.usecases.models.Thing;

import java.util.HashMap;
import java.util.Map;

public class ThingsUseCase {

    public void doACoolThing(Thing thing, CoolThingObserver observer) {
        observer.thingHappened(thing);
    }

    public void doMoreThings(Thing thing, MoreThingsObserver observer) {
        // TODO: Do some thing to thing

        // Maybe the thing was successful
        observer.thingWasSuccessful(thing);

        // Perhaps it failed
        HashMap<String, String> errors = new HashMap<>();
        errors.put("thing", "some thing went awry");
        errors.put("thing", "Things are getting out of hand");
        errors.put("thing", "We mustn't let this Thing come between us");
        observer.thingFailed(errors);

        // Or, maybe some other thing happened along the way
        observer.somethingElseHappened("This Thing is bigger than both of us");
    }

    public Thing doAnExceptionalThing() {
        if (true) {
            throw new ThingsDidntGoAccordingToPlanException("Things are looking pretty bad");
        }

        return new Thing();
    }

    public interface CoolThingObserver {
        void thingHappened(Thing thing);
    }

    public interface MoreThingsObserver {
        void thingWasSuccessful(Thing thing);
        void thingFailed(Map<String,String> errors);
        void somethingElseHappened(String message);
    }

    public static class ThingsDidntGoAccordingToPlanException extends RuntimeException {
        public ThingsDidntGoAccordingToPlanException(String message) {
            super(message);
        }
    }
}
