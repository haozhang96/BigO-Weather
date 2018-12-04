package edu.uncg.csc.bigo.weather.models.metrics;
/**
 * This class defines a columnar density object with a columnar density unit attached to it.
 * The conversion formulas were derived from https://en.wikipedia.org/wiki/Dobson_unit.
 *
 * @updated 09/27/2018
 * @authors Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.metrics.units.ColumnarDensityUnit;

public final class ColumnarDensity extends UnitTaggedValue<Double, ColumnarDensityUnit> {
    /**
     * This constructs a ColumnarDensity object with a value and a unit.
     * @param _value The columnar density's value.
     * @param _unit The columnar density's unit.
     */
    public ColumnarDensity(double _value, ColumnarDensityUnit _unit) {
        super(_value, _unit);
    }


    /**
     * This method returns a new columnar density converted to the given unit.
     * @param _unit The columnar density unit to convert to.
     * @return A new ColumnarDensity object with the converted value and unit.
     */
    @Override
    public ColumnarDensity convertTo(ColumnarDensityUnit _unit) {
        if (_unit == null) {
            // Make sure a new unit was given
            throw new IllegalArgumentException("A new unit was not specified!");
        } else if (_unit.equals(this.getUnit())) {
            // Converting something to itself is just itself
            return this;
        }

        double scaleFactor = Double.NaN;
        switch (this.getUnit()) {
            case DOBSON_UNIT: {
                switch (_unit) {
                    // Dobson unit to mole per square meter
                    case MOLE_PER_SQUARE_METER: scaleFactor = 4.4615E-4; break;
                    // Dobson unit to molecule per square meter
                    case MOLECULE_PER_SQUARE_METER: scaleFactor = 2.6867E20; break;
                }
                break;
            }

            case MOLE_PER_SQUARE_METER: {
                switch (_unit) {
                    // Mole per square meter to Dobson unit
                    case DOBSON_UNIT: scaleFactor = 1 / 4.4615E-4; break;
                    // Mole per square meter to molecule per square meter
                    case MOLECULE_PER_SQUARE_METER: scaleFactor = 6.02214085774E23; break;
                }
                break;
            }

            case MOLECULE_PER_SQUARE_METER: {
                switch (_unit) {
                    // Molecule per square meter to Dobson unit
                    case DOBSON_UNIT: scaleFactor = 1 / 2.6867E20; break;
                    // Molecule per square meter to mole per square meter
                    case MOLE_PER_SQUARE_METER: scaleFactor = 1 / 6.02214085774E23; break;
                }
                break;
            }
        }
        return new ColumnarDensity(this.getValue() * scaleFactor, _unit);
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string.
     */
    @Override
    public String toString() {
        String unit = null;
        switch (this.getUnit()) {
            case DOBSON_UNIT: unit = "DU"; break;
            case MOLE_PER_SQUARE_METER: unit = "mol/m²"; break;
            case MOLECULE_PER_SQUARE_METER: unit = "molecule/m²"; break;
        }
        return this.getValue() + " " + unit;
    }
}