package edu.uncg.csc.bigo.weather.models.weather;
/**
 * This class builds an immutable WeatherData object. It is basically a syntactic sugar for creating
 *     the WeatherData object since there are many fields, which would make invoking its constructor
 *     ugly and confusing to read.
 * Another benefit of this class is that it allows for optional fields in WeatherData.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import java.util.Date;


public final class WeatherDataBuilder {
    /**
     * All the instance fields of the WeatherData class are replicated here.
     */
    private Double apparentTemperature = null;
    private Double cloudCover = null;
    private Double dewPoint = null;
    private Double humidity = null;
    private LocationCoordinate location = null;
    private Double nearestStormDistance = null;
    private Double ozone = null;
    private Double precipitationIntensity = null;
    private Double precipitationProbability = null;
    private Double pressure = null;
    private String summary = null;
    private Double temperature = null;
    private Date time = null;
    private Double uvIndex = null;
    private Double visibility = null;
    private Double windGust = null;
    private Double windSpeed = null;


    /**
     * All the builder methods begin here.
     */


    public WeatherDataBuilder setApparentTemperature(double _apparentTemperature) {
        this.apparentTemperature = _apparentTemperature;
        return this;
    }


    public WeatherDataBuilder setCloudCover(double _cloudCover) {
        this.cloudCover = _cloudCover;
        return this;
    }


    public WeatherDataBuilder setDewPoint(double _dewPoint) {
        this.dewPoint = _dewPoint;
        return this;
    }


    public WeatherDataBuilder setHumidity(double _apparentTemperature) {
        this.apparentTemperature = _apparentTemperature;
        return this;
    }


    public WeatherDataBuilder setLocation(LocationCoordinate _location) {
        this.location = _location;
        return this;
    }


    public WeatherDataBuilder setNearestStormDistance(double _nearestStormDistance) {
        this.nearestStormDistance = _nearestStormDistance;
        return this;
    }


    public WeatherDataBuilder setOzone(double _ozone) {
        this.ozone = _ozone;
        return this;
    }


    public WeatherDataBuilder setPrecipitationIntensity(double _precipitationIntensity) {
        this.precipitationIntensity = _precipitationIntensity;
        return this;
    }


    public WeatherDataBuilder setPrecipitationProbability(double _precipitationProbability) {
        this.precipitationProbability = _precipitationProbability;
        return this;
    }


    public WeatherDataBuilder setPressure(double _pressure) {
        this.pressure = _pressure;
        return this;
    }


    public WeatherDataBuilder setSummary(String _summary) {
        this.summary = _summary;
        return this;
    }


    public WeatherDataBuilder setTemperature(double _temperature) {
        this.temperature = _temperature;
        return this;
    }


    public WeatherDataBuilder setTime(Date _time) {
        this.time = _time;
        return this;
    }


    public WeatherDataBuilder setUVIndex(double _uvIndex) {
        this.uvIndex = _uvIndex;
        return this;
    }


    public WeatherDataBuilder setVisibility(double _visibility) {
        this.visibility = _visibility;
        return this;
    }


    public WeatherDataBuilder setWindGust(double _windGust) {
        this.windGust = _windGust;
        return this;
    }


    public WeatherDataBuilder setWindSpeed(double _windSpeed) {
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
        } else if (this.temperature == null) {
            throw new IllegalStateException("The \"temperature\" field has not been set!");
        }

        // Return a new immutable WeatherData object (hopefully now you'll know why this is needed).
        return new WeatherData(
                apparentTemperature,
                cloudCover,
                dewPoint,
                humidity,
                location,
                nearestStormDistance,
                ozone,
                precipitationIntensity,
                precipitationProbability,
                pressure,
                summary,
                temperature,
                time,
                uvIndex,
                visibility,
                windGust,
                windSpeed
        );
    }
}
