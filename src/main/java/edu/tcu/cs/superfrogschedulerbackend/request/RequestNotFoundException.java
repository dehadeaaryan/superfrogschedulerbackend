package edu.tcu.cs.superfrogschedulerbackend.request;

public class RequestNotFoundException extends RuntimeException {
    public RequestNotFoundException(String id) {
        super(String.format("Could not find request with id %s", id));
    }
}
