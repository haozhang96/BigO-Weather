package edu.uncg.csc.bigo.weather.models.weather;

import edu.uncg.csc.bigo.weather.R;

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


    private int iconResId;


    private Icons(int iconResId) {
        this.iconResId = iconResId;
    }

    public int getIconResId() {
        return iconResId;
    }
 }
