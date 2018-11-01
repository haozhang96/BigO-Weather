package edu.uncg.csc.bigo.weather.models.util.caching;
/**
 * This class defines an cache object to store time-expirable objects.
 *
 * @updated 2018/10/25
 * @authors Hao Zhang
 */


public class TimeExpirableCache<K, V extends TimeExpirable> extends ExpirableCache<K, V> { }