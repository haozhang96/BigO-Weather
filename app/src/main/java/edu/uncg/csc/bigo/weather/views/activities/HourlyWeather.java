package edu.uncg.csc.bigo.weather.views.activities;


import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.util.Globals;
import edu.uncg.csc.bigo.weather.models.weather.Icons;

import static android.content.Context.MODE_PRIVATE;


/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyWeather extends Fragment {


    public int zipCode;
    String[][] hourlyWeatherForecastController;

    private TextView hourOneMessage;
    private TextView hourTwoMessage;
    private TextView hourThreeMessage;
    private TextView hourFourMessage;
    private TextView hourFiveMessage;
    private TextView hourSixMessage;
    private TextView hourSevenMessage;
    private TextView hourEightMessage;
    private TextView hourNineMessage;
    private TextView hourTenMessage;
    private TextView hourElevenMessage;
    private TextView hourTwelveMessage;

    private ImageView hourOneImage;
    private ImageView hourTwoImage;
    private ImageView hourThreeImage;
    private ImageView hourFourImage;
    private ImageView hourFiveImage;
    private ImageView hourSixImage;
    private ImageView hourSevenImage;
    private ImageView hourEightImage;
    private ImageView hourNineImage;
    private ImageView hourTenImage;
    private ImageView hourElevenImage;
    private ImageView hourTwelveImage;


    private TextView[] textViews = {hourOneMessage, hourTwoMessage, hourThreeMessage,
            hourFourMessage, hourFiveMessage, hourSixMessage, hourSevenMessage, hourEightMessage,
            hourNineMessage, hourTenMessage, hourElevenMessage, hourTwelveMessage};

    private Integer[] textViewID = {R.id.hourOneMessage, R.id.hourTwoMessage, R.id.hourThreeMessage,
            R.id.hourFourMessage, R.id.hourFiveMessage, R.id.hourSixMessage, R.id.hourSevenMessage,
            R.id.hourEightMessage, R.id.hourNineMessage, R.id.hourTenMessage, R.id.hourElevenMessage,
            R.id.hourTwelveMessage};


    private ImageView[] imageViews = {hourOneImage, hourTwoImage, hourThreeImage, hourFourImage,
            hourFiveImage, hourSixImage, hourSevenImage, hourEightImage, hourNineImage,
            hourTenImage, hourElevenImage, hourTwelveImage};


    private Integer[] imageViewID = {R.id.hourOneImage, R.id.hourTwoImage, R.id.hourThreeImage,
            R.id.hourFourImage, R.id.hourFiveImage, R.id.hourSixImage, R.id.hourSevenImage,
            R.id.hourEightImage, R.id.hourNineImage, R.id.hourTenImage, R.id.hourElevenImage,
            R.id.hourTwelveImage};


    public HourlyWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hourly_weather, container, false);

        for (int i = 0; i < 12; i++) {
            textViews[i] = v.findViewById(textViewID[i]);
            imageViews[i] = v.findViewById(imageViewID[i]);
        }

        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        new Test().execute();
    }


    /**
     * This is where we will test things
     */
    public class Test extends AsyncTask<Void, Void, Wrapper> {

        protected Wrapper doInBackground(Void... nothing) {
            Wrapper w = new Wrapper();

            try {

                SharedPreferences sp = getActivity().getSharedPreferences("GLOBAL", MODE_PRIVATE);

                // Store a message buffer to append strings to.

                StringBuffer message = new StringBuffer();
                StringBuffer message2 = new StringBuffer();
                StringBuffer message3 = new StringBuffer();
                StringBuffer message4 = new StringBuffer();
                StringBuffer message5 = new StringBuffer();
                StringBuffer message6 = new StringBuffer();
                StringBuffer message7 = new StringBuffer();
                StringBuffer message8 = new StringBuffer();
                StringBuffer message9 = new StringBuffer();
                StringBuffer message10 = new StringBuffer();
                StringBuffer message11 = new StringBuffer();
                StringBuffer message12 = new StringBuffer();

                StringBuffer[] StringBuffer = {message, message2, message3, message4, message5, message6, message7, message8, message9, message10, message11, message12};


                //Get the zipcode entered by the user.
                zipCode = sp.getInt("ZIP", -1);;


                //Testing the WeatherController methods
                hourlyWeatherForecastController = WeatherController.getWeatherHourlyForecast(zipCode);

                for (int i = 0; i < 12; i++) {
                    StringBuffer[i].append("   " + hourlyWeatherForecastController[i][Globals.TIME] + "\n");
                    StringBuffer[i].append("   " + hourlyWeatherForecastController[i][Globals.SUMMARY] + "\n");
                    StringBuffer[i].append("   " + hourlyWeatherForecastController[i][Globals.TEMPERATURE] + "\n\n");
                    StringBuffer[i].append("   " + hourlyWeatherForecastController[i][Globals.ICON] + "\n\n");
                    w.messages[i] = StringBuffer[i].toString();
                }

            } catch (Exception exception) {

            }
            return w;
        }

        protected void onPostExecute(Wrapper w) {

            for (int i = 0; i < 12; i++) {
                switch (hourlyWeatherForecastController[i][Globals.ICON]) {
                    case "clear-day":
                        Icons clear_day = Icons.valueOf("Clear_day".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(clear_day.getIconResId());
                        break;

                    case "clear-night":
                        Icons clear_night = Icons.valueOf("Clear_night".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(clear_night.getIconResId());
                        break;

                    case "cloudy":
                        Icons cloudy = Icons.valueOf("Cloudy".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(cloudy.getIconResId());
                        break;

                    case "fog":
                        Icons fog = Icons.valueOf("Fog".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(fog.getIconResId());
                        break;

                    case "partly-cloudy-day":
                        Icons partly_cloudy_day = Icons.valueOf("Partly_cloudy_day".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(partly_cloudy_day.getIconResId());
                        break;

                    case "partly-cloudy-night":
                        Icons partly_cloudy_night = Icons.valueOf("Partly_cloudy_night".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(partly_cloudy_night.getIconResId());
                        break;

                    case "rain":
                        Icons rain = Icons.valueOf("Rain".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(rain.getIconResId());
                        break;

                    case "sleet":
                        Icons sleet = Icons.valueOf("Sleet".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(sleet.getIconResId());
                        break;

                    case "snow":
                        Icons snow = Icons.valueOf("Snow".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(snow.getIconResId());
                        break;

                    case "wind":
                        Icons wind = Icons.valueOf("Wind".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(wind.getIconResId());
                        break;
                }
            }

            for(int i = 0; i < 12; i++) {
                textViews[i].setText(w.messages[i]);
            }
        }
    }

}
