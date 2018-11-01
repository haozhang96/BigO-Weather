package edu.uncg.csc.bigo.weather.models.api.fallback;

public final class NoWorkingAPIAvailableException extends Exception {
    public NoWorkingAPIAvailableException(String _message) {
        super(_message);
    }
}