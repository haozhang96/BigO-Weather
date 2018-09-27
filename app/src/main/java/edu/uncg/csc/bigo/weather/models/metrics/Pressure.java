package edu.uncg.csc.bigo.weather.models.metrics;
/**
 * This class defines a pressure object with a pressure unit attached to it.
 * The conversion formulas were derived from https://keisan.casio.com/exec/system/1227590310.
 *
 * @updated 2018/09/26
 * @authors Hao Zhang
 */


import edu.uncg.csc.bigo.weather.models.metrics.units.PressureUnit;


public final class Pressure extends UnitTaggedValue<Double, PressureUnit> {
    /**
     * This constructs a Pressure object with a value and a unit.
     * @param _value The pressure's value
     * @param _unit The pressure's unit
     */
    public Pressure(double _value, PressureUnit _unit) {
        super(_value, _unit);
    }


    /**
     * This method returns a new pressure converted to the given unit.
     * @param _unit The pressure unit to convert to
     * @return A new Pressure object with the converted value and unit
     */
    @Override
    public Pressure convertTo(PressureUnit _unit) {
        if (_unit == null) {
            // Make sure a new unit was given
            throw new IllegalArgumentException("A new unit was not specified!");
        } else if (_unit.equals(this.getUnit())) {
            // Converting something to itself is just itself
            return this;
        }

        double scaleFactor = Double.NaN;
        switch (this.getUnit()) {
            case ATMOSPHERE: {
                switch (_unit) {
                    // Atmosphere to hectopascal
                    case HECTOPASCAL: scaleFactor = 1013.25; break;
                    // Atmosphere to inch of mercury
                    case INCH_OF_MERCURY: scaleFactor = 29.921255579749; break;
                    // Atmosphere to pound per square inch
                    case POUND_PER_SQUARE_INCH: scaleFactor = 14.695948775513; break;
                    // Atmosphere to Torr
                    case TORR: scaleFactor = 760; break;
                }
                break;
            }

            case HECTOPASCAL: {
                switch (_unit) {
                    // Hectopascal to atmosphere
                    case ATMOSPHERE: scaleFactor = 1 / 1013.25; break;
                    // Hectopascal to inch of mercury
                    case INCH_OF_MERCURY: scaleFactor = 0.02952998330101; break;
                    // Hectopascal to pound per square inch
                    case POUND_PER_SQUARE_INCH: scaleFactor = 0.014503773773021; break;
                    // Hectopascal to Torr
                    case TORR: scaleFactor = 0.75006168270417; break;
                }
                break;
            }

            case INCH_OF_MERCURY: {
                switch (_unit) {
                    // Inch of mercury to atmosphere
                    case ATMOSPHERE: scaleFactor = 0.033421057392953; break;
                    // Inch of mercury to hectopascal
                    case HECTOPASCAL: scaleFactor = 33.86388640341; break;
                    // Inch of mercury to pound per square inch
                    case POUND_PER_SQUARE_INCH: scaleFactor = 0.49115414747034; break;
                    // Inch of mercury to Torr
                    case TORR: scaleFactor = 25.400003618645; break;
                }
                break;
            }

            case POUND_PER_SQUARE_INCH: {
                switch (_unit) {
                    // Pound per square inch to atmosphere
                    case ATMOSPHERE: scaleFactor = 0.068045963909878; break;
                    // Pound per square inch to hectopascal
                    case HECTOPASCAL: scaleFactor = 68.947572931684; break;
                    // Pound per square inch to inch of mercury
                    case INCH_OF_MERCURY: scaleFactor = 2.0360206773178; break;
                    // Pound per square inch to Torr
                    case TORR: scaleFactor = 51.714932571507; break;
                }
                break;
            }

            case TORR: {
                switch (_unit) {
                    // Torr to atmosphere
                    case ATMOSPHERE: scaleFactor = 1 / 760.0; break;
                    // Torr to hectopascal
                    case HECTOPASCAL: scaleFactor = 1.3332236842105; break;
                    // Torr to inch of mercury
                    case INCH_OF_MERCURY: scaleFactor = 0.039370073131248; break;
                    // Torr to pound per square inch
                    case POUND_PER_SQUARE_INCH: scaleFactor = 0.019336774704623; break;
                }
                break;
            }
        }
        return new Pressure(this.getValue() * scaleFactor, _unit);
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string
     */
    @Override
    public String toString() {
        String unit = null;
        switch (this.getUnit()) {
            case ATMOSPHERE: unit = "atm"; break;
            case HECTOPASCAL: unit = "hPa"; break;
            case INCH_OF_MERCURY: unit = "inHg"; break;
            case POUND_PER_SQUARE_INCH: unit = "psi"; break;
            case TORR: unit = "Torr"; break;
        }
        return this.getValue() + " " + unit;
    }
}