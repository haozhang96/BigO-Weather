package edu.uncg.csc.bigo.weather.models.util.caching;
/**
 * This class defines a cache object to store reusable objects.
 * It is basically a proxy for HashMap that exposes only a few of its methods.
 *
 * @updated 2018/10/25
 * @authors Hao Zhang
 */


import java.util.HashMap;


public class Cache<K, V> {
    // This stores a map of cached objects
    protected final HashMap<K, V> cache = new HashMap();


    /**
     * This method stores an object in the cache with a given key.
     * @param _key The key for which the object is stored in the cache as
     * @param _value The object to store in the cache for the given key
     */
    public void cache(K _key, V _value) {
        this.cache.put(_key, _value);
    }


    /**
     * This method clears out the entire cache.
     */
    public void clearCache() {
        this.cache.clear();
    }


    /**
     * This method retrieves an object from the cache for a given key.
     * @param _key The key for which the object is stored in the cache as
     * @return The object retrieved from the cache for the given key
     */
    public V getCached(K _key) {
        return this.cache.get(_key);
    }


    /**
     * This method returns whether the cache contains an object for a given key.
     * @param _key The key for which the object is stored in the cache as
     * @return Whether the cache contains an object for the given key
     */
    public boolean isCached(K _key) {
        return this.cache.containsKey(_key);
    }


    /**
     * This method removes an object from the cache for a given key.
     * @param _key The key for which the object is stored in the cache as
     * @return Whether an existing object was removed from the cache for the given key
     */
    public boolean uncache(K _key) {
        return this.cache.remove(_key) != null;
    }
}