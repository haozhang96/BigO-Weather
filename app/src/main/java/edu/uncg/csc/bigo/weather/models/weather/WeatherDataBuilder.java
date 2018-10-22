package com.example.bigo.weatherapp.models.weather;
/**
 * This class builds an immutable WeatherData object. It is basically a syntactic sugar for creating
 *     the WeatherData object since there are many fields, which would make invoking its constructor
 *     ugly and confusing to read.
 * Another benefit of this class is that it allows for optional fields in WeatherData.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


import com.example.bigo.weatherapp.models.metrics.*;
import com.example.bigo.weatherapp.models.util.LocationCoordinate;
import java.util.Date;


public final class WeatherDataBuilder {
    /**
     * All the instance fields of the WeatherData class are replicated here.
     */
    private Temperature apparentTemperature = null;
    private Amount cloudCover = null;
    private Temperature dewPoint = null;
    private Amount humidity = null;
    private LocationCoordinate location = null;
    private Amount moonPhase = null;
    private Distance nearestStormDistance = null;
    private ColumnarDensity ozone = null;
    private Speed precipitationIntensity = null;
    private Amount precipitationProbability = null;
    private Pressure pressure = null;
    private String summary = null;
    private Temperature temperature = null;
    private Date time = null;
    private Integer uvIndex = null;
    private Distance visibility = null;
    private Speed windGust = null;
    private Speed windSpeed = null;


    /**
     * All the builder methods begin here.
     */


    public WeatherDataBuilder setApparentTemperature(Temperature _apparentTemperature) {
        this.apparentTemperature = _apparentTemperature;
        return this;
    }


    public WeatherDataBuilder setCloudCover(Amount _cloudCover) {
        this.cloudCover = _cloudCover;
        return this;
    }


    public WeatherDataBuilder setDewPoint(Temperature _dewPoint) {
        this.dewPoint = _dewPoint;
        return this;
    }


    public WeatherDataBuilder setHumidity(Amount _humidity) {
        this.humidity = _humidity;
        return this;
    }


    public WeatherDataBuilder setLocation(LocationCoordinate _location) {
        this.location = _location;
        return this;
    }


    public WeatherDataBuilder setMoonPhase(Amount _moonPhase) {
        this.moonPhase = _moonPhase;
        return this;
    }


    public WeatherDataBuilder setNearestStormDistance(Distance _nearestStormDistance) {
        this.nearestStormDistance = _nearestStormDistance;
        return this;
    }


    public WeatherDataBuilder setOzone(ColumnarDensity _ozone) {
        this.ozone = _ozone;
        return this;
    }


    public WeatherDataBuilder setPrecipitationIntensity(Speed _precipitationIntensity) {
        this.precipitationIntensity = _precipitationIntensity;
        return this;
    }


    public WeatherDataBuilder setPrecipitationProbability(Amount _precipitationProbability) {
        this.precipitationProbability = _precipitationProbability;
        return this;
    }


    public WeatherDataBuilder setPressure(Pressure _pressure) {
        this.pressure = _pressure;
        return this;
    }


    public WeatherDataBuilder setSummary(String _summary) {
        this.summary = _summary;
        return this;
    }


    public WeatherDataBuilder setTemperature(Temperature _temperature) {
        this.temperature = _temperature;
        return this;
    }


    public WeatherDataBuilder setTime(Date _time) {
        this.time = _time;
        return this;
    }


    public WeatherDataBuilder setUVIndex(int _uvIndex) {
        this.uvIndex = _uvIndex;
        return this;
    }


    public WeatherDataBuilder setVisibility(Distance _visibility) {
        this.visibility = _visibility;
        return this;
    }


    public WeatherDataBuilder setWindGust(Speed _windGust) {
        this.windGust = _windGust;
        return this;
    }


    public WeatherDataBuilder setWindSpeed(Speed _windSpeed) {
        this.windSpeed = _windSpeed;
        return this;
    }


    /**
     * This method builds a WeatherData object based on the currently-set fields.
     * @return A WeatherData object
     * @throws IllegalStateException An error indicating any required field that was not set
     */
    public WeatherData build() throws IllegalStateException {
        // Check all the required values.
        if (this.time == null) {
            throw new IllegalStateException("The \"time\" field has not been set!");
        } else if (this.location == null) {
            throw new IllegalStateException("The \"location\" field has not been set!");
        }

        // Return a new immutable WeatherData object (hopefully now you'll know why this is needed).
        return new WeatherData(
                this.apparentTemperature,
                this.cloudCover,
                this.dewPoint,
                this.humidity,
                this.location,
                this.moonPhase,
                this.nearestStormDistance,
                this.ozone,
                this.precipitationIntensity,
                this.precipitationProbability,
                this.pressure,
                this.summary,
                this.temperature,
                this.time,
                this.uvIndex,
                this.visibility,
                this.windGust,
                this.windSpeed
        );
    }
}
