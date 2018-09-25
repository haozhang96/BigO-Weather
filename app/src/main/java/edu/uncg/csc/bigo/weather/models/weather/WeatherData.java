package edu.uncg.csc.bigo.weather.models.weather;
/**
 * This class describes weather data at a given location and time.
 * You should NOT construct this directly. Use the WeatherDataBuilder object instead.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.util.LocationCoordinate;
import java.util.Date;


public class WeatherData {
    /**
     * All the properties of WeatherData objects are defined below.
     * Boxed values are used over primitives because some fields are optional.
     */
    private final Double apparentTemperature;
    private final Double cloudCover;
    private final Double dewPoint;
    private final Double humidity;
    private final LocationCoordinate location;
    private final Double nearestStormDistance;
    private final Double ozone;
    private final Double precipitationIntensity;
    private final Double precipitationProbability;
    private final Double pressure;
    private final String summary;
    private final Double temperature;
    private final Date time;
    private final Double uvIndex;
    private final Double visibility;
    private final Double windGust;
    private final Double windSpeed;


    /**
     * This constructs an object containing weather data.
     * Most of the logic are actually defined in the WeatherDataBuilder object. Check there for more
     *     details.
     * @param _apparentTemperature The apparent temperature in degrees Fahrenheit
     * @param _cloudCover The cloud cover in percent ratio
     * @param _dewPoint The dew point in degrees Fahrenheit
     * @param _humidity The humidity in percent ratio
     * @param _location The location
     * @param _nearestStormDistance The nearest storm distance in ?
     * @param _ozone The ozone quantity in ?
     * @param _precipitationIntensity The precipitation intensity in ?
     * @param _precipitationProbability The precipitation probability in ?
     * @param _pressure The pressure in ?
     * @param _summary The summary message indicating the general conditions in plain English
     * @param _temperature The temperature in degrees Fahrenheit
     * @param _time The time when the weather data was generated
     * @param _uvIndex The ultraviolet index in ?
     * @param _visibility The visibility in ?
     * @param _windGust The wind gust in miles per hour
     * @param _windSpeed The wind speed in miles per hour
     */
    protected WeatherData(
            Double _apparentTemperature,
            Double _cloudCover,
            Double _dewPoint,
            Double _humidity,
            LocationCoordinate _location,
            Double _nearestStormDistance,
            Double _ozone,
            Double _precipitationIntensity,
            Double _precipitationProbability,
            Double _pressure,
            String _summary,
            Double _temperature,
            Date _time,
            Double _uvIndex,
            Double _visibility,
            Double _windGust,
            Double _windSpeed
    ) {
        this.apparentTemperature = _apparentTemperature;
        this.cloudCover = _cloudCover;
        this.dewPoint = _dewPoint;
        this.humidity = _humidity;
        this.location = _location;
        this.nearestStormDistance = _nearestStormDistance;
        this.ozone = _ozone;
        this.precipitationIntensity = _precipitationIntensity;
        this.precipitationProbability = _precipitationProbability;
        this.pressure = _pressure;
        this.summary = _summary;
        this.temperature = _temperature;
        this.time = _time;
        this.uvIndex = _uvIndex;
        this.visibility = _visibility;
        this.windGust = _windGust;
        this.windSpeed = _windSpeed;
    }


    /**
     * All the field getters are defined below this comment.
     */


    public Double getApparentTemperature() {
        return this.apparentTemperature;
    }


    public Double getCloudCover() {
        return this.cloudCover;
    }


    public Double getDewPoint() {
        return this.dewPoint;
    }


    public Double getHumidity() {
        return this.humidity;
    }


    public LocationCoordinate getLocation() {
        return this.location;
    }


    public Double getNearestStormDistance() {
        return this.nearestStormDistance;
    }


    public Double getOzone() {
        return this.ozone;
    }


    public Double getPrecipitationIntensity() {
        return this.precipitationIntensity;
    }


    public Double getPrecipitationProbability() {
        return this.precipitationProbability;
    }


    public Double getPressure() {
        return this.pressure;
    }


    public String getSummary() {
        return this.summary;
    }


    public Double getTemperature() {
        return this.temperature;
    }


    public Date getTime() {
        return this.time;
    }


    public Double getUVIndex() {
        return this.uvIndex;
    }


    public Double getVisibility() {
        return this.visibility;
    }


    public Double getWindGust() {
        return this.windGust;
    }


    public Double getWindSpeed() {
        return this.windSpeed;
    }


    @Override
    public String toString() {
        return String.format(
                "WeatherData[%s] {\n" +
                    "\tApparentTemperature: %s\n" +
                    "\tCloudCover: %s\n" +
                    "\tDewPoint: %s\n" +
                    "\tHumidity: %s\n" +
                    "\tLocation: %s\n" +
                    "\tNearestStormDistance: %s\n" +
                    "\tOzone: %s\n" +
                    "\tPrecipitationIntensity: %s\n" +
                    "\tPrecipitationProbability: %s\n" +
                    "\tPressure: %s\n" +
                    "\tSummary: %s\n" +
                    "\tTemperature: %s\n" +
                    "\tUVIndex: %s\n" +
                    "\tVisibility: %s\n" +
                    "\tWindGust: %s\n" +
                    "\tWindSpeed: %s\n" +
                "}",

                this.time,
                this.apparentTemperature,
                this.cloudCover,
                this.dewPoint,
                this.humidity,
                this.location,
                this.nearestStormDistance,
                this.ozone,
                this.precipitationIntensity,
                this.precipitationProbability,
                this.pressure,
                this.summary,
                this.temperature,
                this.uvIndex,
                this.visibility,
                this.windGust,
                this.windSpeed
        );
    }
}