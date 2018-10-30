package edu.uncg.csc.bigo.weather.models.util.caching;
/**
 * This class defines an abstract expirable object.
 *
 * @updated 2018/10/25
 * @authors Hao Zhang
 */


public abstract class Expirable {
    private boolean expired = false;


    /**
     * This method flags the object as expired. Once an object has been flagged as expired, it
     *     cannot be unflagged unless a sub-class overrides the implementation.
     */
    public void expire() {
        this.expired = true;
    }


    /**
     * This method returns whether the object has expired.
     * @return Whether the object has expired.
     */
    public boolean expired() {
        return this.expired;
    }
}