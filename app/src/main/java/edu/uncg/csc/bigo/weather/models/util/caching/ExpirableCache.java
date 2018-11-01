package edu.uncg.csc.bigo.weather.models.util.caching;
/**
 * This class defines an cache object to store expirable objects.
 *
 * @updated 2018/10/31
 * @authors Hao Zhang
 */


public class ExpirableCache<K, V extends Expirable> extends Cache<K, V> {
    /**
     * This method flags an object in the cache with a given key as expired.
     * @param _key The key for which the object is stored in the cache as
     * @return Whether the cache contained an object for the given key
     */
    public boolean expire(K _key) {
        if (this.isCached(_key)) {
            this.getCached(_key).expire();
            return true;
        }
        return false;
    }


    /**
     * This method flags every object in the cache as expired and removes them from the cache.
     */
    public void expireAll() {
        for (Expirable cached : this.cache.values()) {
            cached.expire();
        }
        this.clearCache();
    }


    /**
     * This method returns whether an object in the cache has expired.
     * If the object is not in the cache, then it is considered "expired", and should be updated.
     *
     * @param _key The key of the object stored in the cache
     * @return Whether the object in the cache has expired
     */
    public boolean expired(K _key) {
        return !this.isCached(_key) || this.getCached(_key).expired();
    }
}
