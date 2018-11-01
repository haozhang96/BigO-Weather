package edu.uncg.csc.bigo.weather.models.util.caching;
/**
 * This class defines an abstract time expirable object.
 *
 * @updated 2018/10/25
 * @authors Hao Zhang
 */


import java.util.Date;


public abstract class TimeExpirable extends Expirable {
    private final Date refreshTime;
    private Date expiration;


    /**
     * This constructs a TimeExpirable object that will never expire.
     * It can be used by sub-classes for when they don't have an explicit timeout determined.
     */
    protected TimeExpirable() {
        this(Long.MAX_VALUE);
    }


    /**
     * This constructs a TimeExpirable object that will expire after the given milliseconds from
     *     now.
     * @param _timeout The expiration timeout from now in millisecond
     */
    protected TimeExpirable(long _timeout) {
        this(new Date(new Date().getTime() + _timeout));
    }


    /**
     * This constructs a TimeExpirable object that will expire at a given time.
     * @param _expiration The expiration time as a Date object
     */
    protected TimeExpirable(Date _expiration) {
        // Set the refreshed time
        this.refreshTime = new Date();

        // Set the expiration date
        this.expiration = _expiration;
    }


    /**
     * This method flags the object as expired. Once an object has been flagged as expired, it
     *     cannot be unflagged unless a sub-class overrides the implementation.
     */
    @Override
    public void expire() {
        this.expiration = this.refreshTime;
    }


    /**
     * This method returns whether the object has expired.
     * @return Whether the object has expired.
     */
    @Override
    public boolean expired() {
        return new Date().compareTo(this.expiration) >= 0;
    }


    /**
     * This method returns the expiration time.
     * @return The expiration time as a Date object
     */
    public Date getExpiration() {
        return this.expiration;
    }


    /**
     * This method returns when the object was "fresh".
     * @return The time when the object was "fresh" as a Date object
     */
    public Date getRefreshTime() {
        return this.refreshTime;
    }
}