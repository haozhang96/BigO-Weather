package edu.uncg.csc.bigo.weather.models.util;

public class LocationCoordinate {
    private final double x;
    private final double y;

    public LocationCoordinate(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }
}