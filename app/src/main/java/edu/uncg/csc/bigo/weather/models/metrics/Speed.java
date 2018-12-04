package edu.uncg.csc.bigo.weather.models.metrics;
/**
 * This class defines a speed object with a speed unit attached to it.
 * The conversion formulas were derived from https://keisan.casio.com/exec/system/1227605622.
 *
 * @updated 09/26/2018
 * @authors Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.metrics.units.SpeedUnit;

public final class Speed extends UnitTaggedValue<Double, SpeedUnit> {
    /**
     * This constructs a Speed object with a value and a unit.
     * @param _value The speed's value.
     * @param _unit The speed's unit.
     */
    public Speed(double _value, SpeedUnit _unit) {
        super(_value, _unit);
    }


    /**
     * This method returns a new speed converted to the given unit.
     * @param _unit The speed unit to convert to.
     * @return A new Speed object with the converted value and unit.
     */
    @Override
    public Speed convertTo(SpeedUnit _unit) {
        if (_unit == null) {
            // Make sure a new unit was given.
            throw new IllegalArgumentException("A new unit was not specified!");
        } else if (_unit.equals(this.getUnit())) {
            // Converting something to itself is just itself.
            return this;
        }

        double scaleFactor = Double.NaN;
        switch (this.getUnit()) {
            case KILOMETER_PER_HOUR: {
                switch (_unit) {
                    // Kilometer per hour to meter per second.
                    case METER_PER_SECOND: scaleFactor = 1000 / 3600.0; break;
                    // Kilometer per hour to mile per hour.
                    case MILE_PER_HOUR: scaleFactor = 0.62137119223733; break;
                }
                break;
            }

            case METER_PER_SECOND: {
                switch (_unit) {
                    // Meter per second to kilometer per hour.
                    case KILOMETER_PER_HOUR: scaleFactor = 3.6; break;
                    // Meter per second to mile per hour.
                    case MILE_PER_HOUR: scaleFactor = 2.2369362920544; break;
                }
                break;
            }

            case MILE_PER_HOUR: {
                switch (_unit) {
                    // Mile per hour to kilometer per hour.
                    case KILOMETER_PER_HOUR: scaleFactor = 1.609344; break;
                    // Mile per hour to meter per second.
                    case METER_PER_SECOND: scaleFactor = 0.44704; break;
                }
                break;
            }
        }
        return new Speed(this.getValue() * scaleFactor, _unit);
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string
     */
    @Override
    public String toString() {
        String unit = null;
        switch (this.getUnit()) {
            case KILOMETER_PER_HOUR: unit = "km/h"; break;
            case METER_PER_SECOND: unit = "m/s"; break;
            case MILE_PER_HOUR: unit = "mph"; break;
        }
        return this.getValue() + " " + unit;
    }
}