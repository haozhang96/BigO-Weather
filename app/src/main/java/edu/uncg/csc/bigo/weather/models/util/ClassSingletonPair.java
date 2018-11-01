package edu.uncg.csc.bigo.weather.models.util;
/**
 * This class pairs a class with its singleton together.
 * @param <C> A class
 * @param <S> An instance of the class
 *
 * @updated 2018/11/01
 * @authors Hao Zhang
 */


public final class ClassSingletonPair<C extends Class<S>, S> {
    private final C clazz;
    private final S singleton;


    public ClassSingletonPair(C _class, S _singleton) {
        this.clazz = _class;
        this.singleton = _singleton;
    }


    public final C getClazz() {
        return this.clazz;
    }


    public final S getSingleton() {
        return this.singleton;
    }
}