package edu.uncg.csc.bigo.weather.models.metrics;
/**
 * This class defines an amount object with an amount unit attached to it.
 *
 * @updated 09/27/2018
 * @authors Hao Zhang
 */

import edu.uncg.csc.bigo.weather.models.metrics.units.AmountUnit;

public final class Amount extends UnitTaggedValue<Double, AmountUnit> {
    /**
     * This constructs an Amount object with a value and a unit.
     * @param _value The amount's value.
     * @param _unit The amount's unit.
     */
    public Amount(double _value, AmountUnit _unit) {
        super(_value, _unit);
    }


    /**
     * This method returns a new amount converted to the given unit.
     * @param _unit The amount unit to convert to.
     * @return A new Amount object with the converted value and unit.
     */
    @Override
    public Amount convertTo(AmountUnit _unit) {
        if (_unit == null) {
            // Make sure a new unit was given.
            throw new IllegalArgumentException("A new unit was not specified!");
        } else if (_unit.equals(this.getUnit())) {
            // Converting something to itself is just itself.
            return this;
        }

        return new Amount(this.getValue() * (
                _unit == AmountUnit.PERCENTAGE ? 100 : 1 / 100.0
        ), _unit);
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string.
     */
    @Override
    public String toString() {
        switch (this.getUnit()) {
            case PERCENTAGE: return String.format("%.2f%%", this.getValue());
            case RATIO: return this.getValue().toString();
        }
        return null;
    }
}