package edu.uncg.csc.bigo.weather.models.api;

public final class NoValidAPIAvailableException extends Exception {
    public NoValidAPIAvailableException(String _message) {
        super(_message);
    }
}