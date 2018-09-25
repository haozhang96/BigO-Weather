package edu.uncg.csc.bigo.weather.models.weather;

/**
 * This class defines a temperature object with a temperature unit attached to it.
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.util.UnitTaggedValue;


public final class Temperature extends UnitTaggedValue<Double, TemperatureUnit> {
    /**
     *
     * @param _value
     * @param _unit
     */
    public Temperature(double _value, TemperatureUnit _unit) {
        super(_value, _unit);
    }


    /**
     *
     * @return
     */
    @Override
    public String toString() {
        String unit;
        switch (this.getUnit()) {
            case CELSIUS: unit = "°C"; break;
            case FAHRENHEIT: default: unit = "°F"; break;
            case KELVIN: unit = "K"; break;
        }
        return this.getValue() + " " + unit;
    }
}