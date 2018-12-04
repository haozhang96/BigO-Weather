package edu.uncg.csc.bigo.weather.models.util;
/**
 * This class is intended to hold the dates from which the weather data is valid.
 *
 * @updated 9/25/2018
 * @authors Hao Zhang
 */

import java.util.Date;

public class DateRange {
    private final Date from;
    private final Date to;

    public DateRange(Date _from, Date _to) {
        this.from = _from;
        this.to = _to;
    }

    /**
     * Returns the from Date for the current object.
     * @return Date
     */
    public Date getFrom() {
        return this.from;
    }


    /**
     * Return The to Date for the current object.
     * @return Date
     */
    public Date getTo() {
        return this.to;
    }
}