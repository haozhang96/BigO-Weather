package com.example.bigo.weatherapp.models.metrics;
/**
 * This class defines a distance object with a distance unit attached to it.
 * The conversion formulas were derived from https://keisan.casio.com/exec/system/1226976632.
 *
 * @updated 2018/09/26
 * @authors Hao Zhang
 */


import com.example.bigo.weatherapp.models.metrics.units.DistanceUnit;


public final class Distance extends UnitTaggedValue<Double, DistanceUnit> {
    /**
     * This constructs a Distance object with a value and a unit.
     * @param _value The distance's value
     * @param _unit The distance's unit
     */
    public Distance(double _value, DistanceUnit _unit) {
        super(_value, _unit);
    }


    /**
     * This method returns a new distance converted to the given unit.
     * @param _unit The distance unit to convert to
     * @return A new Distance object with the converted value and unit
     */
    @Override
    public Distance convertTo(DistanceUnit _unit) {
        if (_unit == null) {
            // Make sure a new unit was given
            throw new IllegalArgumentException("A new unit was not specified!");
        } else if (_unit.equals(this.getUnit())) {
            // Converting something to itself is just itself
            return this;
        }

        double scaleFactor = Double.NaN;
        switch (this.getUnit()) {
            case FOOT: {
                switch (_unit) {
                    // Foot to kilometer
                    case KILOMETER: scaleFactor = 3.048E-4; break;
                    // Foot to meter
                    case METER: scaleFactor = 0.3048; break;
                    // Foot to mile
                    case MILE: scaleFactor = 1.8939393939394E-4; break;
                }
                break;
            }

            case KILOMETER: {
                switch (_unit) {
                    // Kilometer to foot
                    case FOOT: scaleFactor = 3280.8398950131; break;
                    // Kilometer to meter
                    case METER: scaleFactor = 1000; break;
                    // Kilometer to mile
                    case MILE: scaleFactor = 0.62137119223733; break;
                }
                break;
            }

            case METER: {
                switch (_unit) {
                    // Meter to foot
                    case FOOT: scaleFactor = 3.2808398950131; break;
                    // Meter to kilometer
                    case KILOMETER: scaleFactor = 0.001; break;
                    // Meter to mile
                    case MILE: scaleFactor = 6.2137119223733E-4; break;
                }
                break;
            }

            case MILE: {
                switch (_unit) {
                    // Mile to foot
                    case FOOT: scaleFactor = 5280; break;
                    // Mile to kilometer
                    case KILOMETER: scaleFactor = 1.609344; break;
                    // Mile to meter
                    case METER: scaleFactor = 1609.344; break;
                }
                break;
            }
        }
        return new Distance(this.getValue() * scaleFactor, _unit);
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string
     */
    @Override
    public String toString() {
        String unit = null;
        switch (this.getUnit()) {
            case FOOT: unit = "ft"; break;
            case KILOMETER: unit = "km"; break;
            case METER: unit = "m"; break;
            case MILE: unit = "mi"; break;
        }
        return this.getValue() + " " + unit;
    }
}