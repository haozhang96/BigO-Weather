package edu.uncg.csc.bigo.weather.models.locale;

import java.util.ResourceBundle;

public abstract class Locale {
    static Strings strings;
}

class A {
    public A() {
        ResourceBundle a = ResourceBundle.getBundle("re");
        // System.out.println(EnglishLocale.strings.errors.unit.NEW_UNIT_NOT_SPECIFIED);
    }
}