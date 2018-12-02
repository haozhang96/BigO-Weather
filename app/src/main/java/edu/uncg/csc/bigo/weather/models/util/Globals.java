package edu.uncg.csc.bigo.weather.models.util;
import java.util.Random;

/**
 * The Globals class lists the enumerations of the global variables needed across the project
 * <p>
 * updated 11/14/2018
 *
 * @authors John Isaac Wilkinson
 */
public class Globals {
    public static final String APIKEY_GEOCODIO = "f0905446086d00db93d937b64d0e999b3b45d5d";
    public static final int CITY_STATE_ZIP = 0;
    public static final int PRECIP_INTENSITY = 1;
    public static final int PRECIP_PROBABILITY = 2;
    public static final int SUMMARY = 3;
    public static final int TIME = 4;
    public static final int CLOUD_COVER = 5;
    public static final int DEW_POINT = 6;
    public static final int HUMIDITY = 7;
    public static final int LAT_LONG = 8;
    public static final int MOON_PHASE = 9;
    public static final int OZONE = 10;
    public static final int PRESSURE = 11;
    public static final int TEMP_HIGH = 12;
    public static final int TEMP_LOW = 13;
    public static final int UV_INDEX = 14;
    public static final int VISIBILITY = 15;
    public static final int WIND_GUST = 16;
    public static final int WIND_SPEED = 17;
    public static final int APPARENT_TEMPERATURE = 18;
    public static final int TEMPERATURE = 19;
    public static final int NEAREST_STORM = 20;
    public static final int ICON = 21;

    public static String getGlobalDarksky(){
        Random myRand = new Random();
        int n = myRand.nextInt(5)+1;
        String s ="";
        switch(n){
            case 1: s = "1fffd54fe65a40d92a13eb5d7e3e1fee";
                break;
            case 2: s = "3f857381963a6e37ba93de4537d5ce96";
                break;
            case 3: s = "de51f1525e57f278daac806ea16bb8a9";
                break;
            case 4: s = "7936c853b8a9c4dbf579d81eaf44ce04";
                break;
            case 5: s= "26ca455c16f60c0dc9f5c7e1af1d428d";
        }
        return s;
    }
}
