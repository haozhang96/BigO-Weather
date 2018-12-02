package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
public class DailyWeather extends Fragment {

    private TextView dayOneMessage;
    private TextView dayTwoMessage;
    private TextView dayThreeMessage;
    private TextView dayFourMessage;
    private TextView dayFiveMessage;
    private TextView daySixMessage;
    private TextView daySevenMessage;

    private ImageView dayOneImage;
    private ImageView dayTwoImage;
    private ImageView dayThreeImage;
    private ImageView dayFourImage;
    private ImageView dayFiveImage;
    private ImageView daySixImage;
    private ImageView daySevenImage;

    private String[][] dailyWeatherForecastController;

    private TextView[] textViews = {dayOneMessage, dayTwoMessage, dayThreeMessage,
            dayFourMessage, dayFiveMessage, daySixMessage, daySevenMessage};

    private Integer[] textViewID = {R.id.dayOneMessage, R.id.dayTwoMessage, R.id.dayThreeMessage,
            R.id.dayFourMessage, R.id.dayFiveMessage, R.id.daySixMessage, R.id.daySevenMessage};


    private ImageView[] imageViews = {dayOneImage, dayTwoImage, dayThreeImage, dayFourImage,
            dayFiveImage, daySixImage, daySevenImage};


    private Integer[] imageViewID = {R.id.dayOneImage, R.id.dayTwoImage, R.id.dayThreeImage,
            R.id.dayFourImage, R.id.dayFiveImage, R.id.daySixImage, R.id.daySevenImage};

    private int zipCode;

    public DailyWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_daily_weather, container, false);

        //Initialize the message TextView box
        for (int i = 0; i < 7; i++) {
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

                StringBuffer[] StringBuffer = {message, message2, message3, message4, message5,
                        message6, message7};

                //Get the zipcode entered by the user.
                zipCode = sp.getInt("ZIP", -1);

                //Testing the WeatherController methods
                dailyWeatherForecastController = WeatherController.getWeatherDailyForecast(zipCode);

                for (int i = 0; i < 7; i++) {
                    StringBuffer[i].append("   " + dailyWeatherForecastController[i][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n");
                    StringBuffer[i].append("   " + dailyWeatherForecastController[i][Globals.SUMMARY] + "\n");
                    StringBuffer[i].append("   High: " + dailyWeatherForecastController[i][Globals.TEMP_HIGH]);
                    StringBuffer[i].append("   , Low: " + dailyWeatherForecastController[i][Globals.TEMP_LOW] + "\n\n");
                    StringBuffer[i].append("   Icon: " + dailyWeatherForecastController[i][Globals.ICON] + "\n\n");
                    w.dailyMessages[i] = StringBuffer[i].toString();
                }

            } catch (Exception exception) {

            }
            return w;
        }

        protected void onPostExecute(Wrapper w) {

            for (int i = 0; i < 7; i++) {
                switch (dailyWeatherForecastController[i][Globals.ICON]) {
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
            for (int i = 0; i < 7; i++) {
                textViews[i].setText(w.dailyMessages[i]);
            }

        }
    }
}


