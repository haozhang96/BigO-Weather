package edu.uncg.csc.bigo.weather.models.metrics;
/**
 * This class defines an immutable object holding a value tagged with a unit.
 * @param <V> The value's type.
 * @param <U> The unit's type.
 *
 * @updated 09/25/2018
 * @authors Hao Zhang
 */

public abstract class UnitTaggedValue<V, U> {
    private final V value;
    private final U unit;

    /**
     * This constructs a UnitTaggedValue object holding a value and a unit.
     * @param _value The value.
     * @param _unit The unit for the value.
     */
    public UnitTaggedValue(V _value, U _unit) {
        this.value = _value;
        this.unit = _unit;
    }


    /**
     * This method returns the value.
     * @return The value.
     */
    public final V getValue() {
        return this.value;
    }


    /**
     * This method returns the unit for the value.
     * @return The unit for the value.
     */
    public final U getUnit() {
        return this.unit;
    }


    /**
     * This method indicates whether the value is null.
     * @return Whether the value is null.
     */
    public final boolean isNull() {
        return this.value == null;
    }


    /**
     * This method defines a common interface for converting between units based on the sub-class'
     *     implementation.
     * @param _unit The unit to convert to.
     * @return A new UnitTaggedValue object with the converted value and unit.
     */
    public UnitTaggedValue<V, U> convertTo(U _unit) {
        throw new UnsupportedOperationException(
                "This method is not implemented in " + this.getClass().getSimpleName() + "."
        );
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string.
     */
    @Override
    public String toString() {
        return this.value + " " + this.unit;
    }
}