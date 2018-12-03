package edu.uncg.csc.bigo.weather.models.weather;

import edu.uncg.csc.bigo.weather.R;

/**
 * This is the Enum class for selecting weather icons.
 *
 * @Updated 12/2/2018
 * @Author Steven Tran
 */
public enum Icons {

    CLEAR_DAY(R.drawable.clear_day),
    CLEAR_NIGHT(R.drawable.clear_night),
    CLOUDY(R.drawable.cloudy),
    FOG(R.drawable.fog),
    PARTLY_CLOUDY_DAY(R.drawable.partly_cloudy_day),
    PARTLY_CLOUDY_NIGHT(R.drawable.partly_cloudy_night),
    RAIN(R.drawable.rain),
    SLEET(R.drawable.sleet),
    SNOW(R.drawable.snow),
    WIND(R.drawable.wind);


    //Icon resource ID
    private int iconResID;


    /**
     * This is the constructor for the Enum class.
     *
     * @param _iconResID = Icon Resource ID
     */
    Icons(int _iconResID) {
        this.iconResID = _iconResID;
    }

    /**
     * Getter for iconResID
     *
     * @return iconResID = Icon Resource ID
     */
    public int getIconResID() {
        return iconResID;
    }
 }
