package edu.uncg.csc.bigo.weather.models.util;

/**
 * This class defines an immutable object holding a value tagged with a unit.
 * @param <V> The value's type
 * @param <U> The unit's type
 *
 * @updated 2018/09/25
 * @authors Hao Zhang
 */


public class UnitTaggedValue<V, U> {
    private final V value;
    private final U unit;


    /**
     * This constructs a UnitTaggedValue object.
     * @param _value The value
     * @param _unit The unit for the value
     */
    public UnitTaggedValue(V _value, U _unit) {
        this.value = _value;
        this.unit = _unit;
    }


    /**
     * This method returns the value.
     * @return The value
     */
    public V getValue() {
        return this.value;
    }


    /**
     * This method returns the unit for the value.
     * @return The unit for the value
     */
    public U getUnit() {
        return this.unit;
    }


    /**
     * This method overrides Object's toString method for pretty-printing.
     * @return A prettified string
     */
    @Override
    public String toString() {
        return this.value + " " + this.unit;
    }
}