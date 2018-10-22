package com.example.bigo.weatherapp.models.util;

import java.util.Date;

public class DateRange {
    private final Date from;
    private final Date to;

    public DateRange(Date _from, Date _to) {
        this.from = _from;
        this.to = _to;
    }

    public Date getFrom() {
        return this.from;
    }

    public Date getTo() {
        return this.to;
    }
}