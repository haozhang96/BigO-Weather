package edu.uncg.csc.bigo.weather.models.metrics;
/**
 * This class defines a temperature object with a temperature unit attached to it.
 *
 * @updated 09/26/2018
 * @authors Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.metrics.units.TemperatureUnit;

public final class Temperature extends UnitTaggedValue<Double, TemperatureUnit> {
    /**
     * This constructs a Temperature object with a value and a unit.
     * @param _value The temperature's value.
     * @param _unit The temperature's unit.
     */
    public Temperature(double _value, TemperatureUnit _unit) {
        super(_value, _unit);
    }


    /**
     * This method returns a new temperature converted to the given unit.
     * @param _unit The temperature unit to convert to.
     * @return A new Temperature object with the converted value and unit.
     */
    @Override
    public Temperature convertTo(TemperatureUnit _unit) {
        if (_unit == null) {
            // Make sure a new unit was given
            throw new IllegalArgumentException("A new unit was not specified!");
        } else if (_unit.equals(this.getUnit())) {
            // Converting something to itself is just itself
            return this;
        }

        double oldValue = this.getValue(), newValue = Double.NaN;
        switch (this.getUnit()) {
            case CELSIUS: {
                switch (_unit) {
                    // Celsius to Fahrenheit
                    case FAHRENHEIT: newValue = oldValue * 9/5 + 32; break;
                    // Celsius to Kelvin
                    case KELVIN: newValue = oldValue + 273.15; break;
                }
                break;
            }

            case FAHRENHEIT: {
                switch (_unit) {
                    // Fahrenheit to Celsius
                    case CELSIUS: newValue = (oldValue - 32) * 5/9; break;
                    // Fahrenheit to Kelvin
                    case KELVIN: newValue = (oldValue - 32) * 5/9 + 273.15; break;
                }
                break;
            }

            case KELVIN: {
                switch (_unit) {
                    // Kelvin to Celsius
                    case CELSIUS: newValue = oldValue - 273.15; break;
                    // Kelvin to Fahrenheit
                    case FAHRENHEIT: newValue = (oldValue - 273.15) * 9/5 + 32; break;
                }
                break;
            }
        }
        return new Temperature(newValue, _unit);
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string.
     */
    @Override
    public String toString() {
        String unit = null;
        switch (this.getUnit()) {
            case CELSIUS: unit = "°C"; break;
            case FAHRENHEIT: unit = "°F"; break;
            case KELVIN: unit = "K"; break;
        }
        return this.getValue() + " " + unit;
    }
}