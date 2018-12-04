package edu.uncg.csc.bigo.weather.models.weather;
/**
 * This class builds an immutable WeatherData object. It is basically a syntactic sugar for creating
 *     the WeatherData object since there are many fields, which would make invoking its constructor
 *     ugly and confusing to read.
 * Another benefit of this class is that it allows for optional fields in WeatherData.
 *
 * @updated 09/25/2018
 * @authors Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.metrics.*;
import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import java.util.Date;

public final class WeatherDataBuilder {
    /**
     * All the instance fields of the WeatherData class are replicated here.
     */
    private Temperature temperatureHigh = null;
    private Temperature temperatureLow = null;
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
    private String icon = null;


    /**
     * Sets the apparent temperature.
     * @param _apparentTemperature
     * @return _apparentTemperature
     */
    public WeatherDataBuilder setApparentTemperature(Temperature _apparentTemperature) {
        this.apparentTemperature = _apparentTemperature;
        return this;
    }


    /**
     * Sets the cloud coverage.
     * @param _cloudCover
     * @return _cloudCover
     */
    public WeatherDataBuilder setCloudCover(Amount _cloudCover) {
        this.cloudCover = _cloudCover;
        return this;
    }


    /**
     * Sets the dew point.
     * @param _dewPoint
     * @return _dewPoint
     */
    public WeatherDataBuilder setDewPoint(Temperature _dewPoint) {
        this.dewPoint = _dewPoint;
        return this;
    }


    /**
     * Sets the humidity.
     * @param _humidity
     * @return _humidity
     */
    public WeatherDataBuilder setHumidity(Amount _humidity) {
        this.humidity = _humidity;
        return this;
    }


    /**
     * Sets the Icon describing the weather conditions.
     * @param _icon
     * @return _icon
     */
    public WeatherDataBuilder setIcon(String _icon) {
        this.icon = _icon;
        return this;
    }


    /**
     * Sets the location.
     * @param _location
     * @return _location
     */
    public WeatherDataBuilder setLocation(LocationCoordinate _location) {
        this.location = _location;
        return this;
    }


    /**
     * Sets the moon phase.
     * @param _moonPhase
     * @return _moonPhase
     */
    public WeatherDataBuilder setMoonPhase(Amount _moonPhase) {
        this.moonPhase = _moonPhase;
        return this;
    }


    /**
     * Sets the distance to the nearest storm.
     * @param _nearestStormDistance
     * @return _nearestStormDistance
     */
    public WeatherDataBuilder setNearestStormDistance(Distance _nearestStormDistance) {
        this.nearestStormDistance = _nearestStormDistance;
        return this;
    }


    /**
     * Sets the ozone.
     * @param _ozone
     * @return _ozone
     */
    public WeatherDataBuilder setOzone(ColumnarDensity _ozone) {
        this.ozone = _ozone;
        return this;
    }


    /**
     * Sets the intensity of precipitation.
     * @param _precipitationIntensity
     * @return _precipitationIntensity
     */
    public WeatherDataBuilder setPrecipitationIntensity(Speed _precipitationIntensity) {
        this.precipitationIntensity = _precipitationIntensity;
        return this;
    }


    /**
     * Sets the precipitation probability.
     * @param _precipitationProbability
     * @return _precipitationProbability
     */
    public WeatherDataBuilder setPrecipitationProbability(Amount _precipitationProbability) {
        this.precipitationProbability = _precipitationProbability;
        return this;
    }


    /**
     * Sets the Pressure.
     * @param _pressure
     * @return _pressure
     */
    public WeatherDataBuilder setPressure(Pressure _pressure) {
        this.pressure = _pressure;
        return this;
    }


    /**
     * Sets the summary describing the weather conditions.
     * @param _summary
     * @return _summary
     */
    public WeatherDataBuilder setSummary(String _summary) {
        this.summary = _summary;
        return this;
    }


    /**
     * Sets the temperature.
     * @param _temperature
     * @return _temperature
     */
    public WeatherDataBuilder setTemperature(Temperature _temperature) {
        this.temperature = _temperature;
        return this;
    }


    /**
     * Sets the temperature high.
     * @param _temperatureHigh
     * @return _temperatureHigh
     */
    public WeatherDataBuilder setTemperatureHigh(Temperature _temperatureHigh){
        this.temperatureHigh = _temperatureHigh;
        return this;
    }


    /**
     * Sets the temperature low.
     * @param _temperatureLow
     * @return _temperatureLow
     */
    public WeatherDataBuilder setTemperatureLow(Temperature _temperatureLow){
        this.temperatureLow = _temperatureLow;
        return this;
    }


    /**
     * Sets the time.
     * @param _time
     * @return _time
     */
    public WeatherDataBuilder setTime(Date _time) {
        this.time = _time;
        return this;
    }


    /**
     * Sets the UV index.
     * @param _uvIndex
     * @return _uvIdex
     */
    public WeatherDataBuilder setUVIndex(int _uvIndex) {
        this.uvIndex = _uvIndex;
        return this;
    }


    /**
     * Sets the visibility.
     * @param _visibility
     * @return _visibility
     */
    public WeatherDataBuilder setVisibility(Distance _visibility) {
        this.visibility = _visibility;
        return this;
    }


    /**
     * Sets the speed of the wind gust.
     * @param _windGust
     * @return _windGust
     */
    public WeatherDataBuilder setWindGust(Speed _windGust) {
        this.windGust = _windGust;
        return this;
    }


    /**
     * Sets the speed of the wind.
     * @param _windSpeed
     * @return _windSpeed
     */
    public WeatherDataBuilder setWindSpeed(Speed _windSpeed) {
        this.windSpeed = _windSpeed;
        return this;
    }


    /**
     * This method builds a WeatherData object based on the currently-set fields.
     * @return A WeatherData object.
     * @throws IllegalStateException An error indicating any required field that was not set.
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
                this.temperatureHigh,
                this.temperatureLow,
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
                this.windSpeed,
                this.icon
        );
    }
}
