package edu.uncg.csc.bigo.weather.models.util.caching;

public abstract class Cacheable<K, V> {
    protected final Cache<K, V> cache = new Cache();
}