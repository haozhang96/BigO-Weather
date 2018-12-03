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
 * The second fragment activity that represents the daily weather view. This fragment is made from
 * the MainActivity class. It shows the date, high/low temperatures, summary, and weather icon.
 *
 * @Updated 12/2/2018
 * @Author Steven Tran
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

    private Button detailedOne;
    private Button detailedTwo;
    private Button detailedThree;
    private Button detailedFour;
    private Button detailedFive;
    private Button detailedSix;
    private Button detailedSeven;

    //TextView array for the 7 TextViews that represent the days
    private TextView[] textViews = {dayOneMessage, dayTwoMessage, dayThreeMessage,
            dayFourMessage, dayFiveMessage, daySixMessage, daySevenMessage};

    //Integer array for the 7 TextViews that represent their xml ID
    private Integer[] textViewID = {R.id.dayOneMessage, R.id.dayTwoMessage, R.id.dayThreeMessage,
            R.id.dayFourMessage, R.id.dayFiveMessage, R.id.daySixMessage, R.id.daySevenMessage};


    //ImageView array for the 7 ImageViews that represent the days
    private ImageView[] imageViews = {dayOneImage, dayTwoImage, dayThreeImage, dayFourImage,
            dayFiveImage, daySixImage, daySevenImage};


    //Integer array for the 7 ImageViews that represent their xml ID
    private Integer[] imageViewID = {R.id.dayOneImage, R.id.dayTwoImage, R.id.dayThreeImage,
            R.id.dayFourImage, R.id.dayFiveImage, R.id.daySixImage, R.id.daySevenImage};

    private String[][] dailyWeatherForecastController;

    /**
     * After onCreate method, this method handles executing the data retrieval and creating a saved
     * instance.
     *
     * @param _savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);
        new DailyDataRetrieval().execute();
    }

    /**
     * The initial startup loading from the view to handle the initializations.
     *
     * @param _inflater
     * @param _container
     * @param _savedInstanceState
     * @return v = Daily Fragment Layout View
     */
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container,
                             Bundle _savedInstanceState) {

        //Initializing the view to the daily weather fragment
        View v = _inflater.inflate(R.layout.fragment_daily_weather, _container, false);

        //Initializing the daily messages and images
        for (int i = 0; i < 7; i++) {
            textViews[i] = v.findViewById(textViewID[i]);
            imageViews[i] = v.findViewById(imageViewID[i]);
        }

        return v;
    }


    /**
     * This class is used for retrieving (DAILY WEATHER) data from the Weather Controllers
     * to obtain the requested data for the user. It works in the background to handle problems
     * with running in the main thread. This allows the app to perform long/background operations
     * and show the results on the UI thread without having to manipulate threads.
     *
     * @Updated: 12/2/2018
     * @Author Steven Tran
     */
    protected class DailyDataRetrieval extends AsyncTask<Void, Void, Wrapper> {


        /**
         * @param _nothing
         * @return w = Wrapper of String data.
         */
        protected Wrapper doInBackground(Void... _nothing) {

            //Obtaining instance of Wrapper object to retrieve more than one string.
            Wrapper w = new Wrapper();

            try {

                //This is used to retrieve the zipCode data from the Location class.
                SharedPreferences sp = getActivity().getSharedPreferences("GLOBAL", MODE_PRIVATE);

                // This stores a string buffer to append strings to.
                StringBuffer dayOne = new StringBuffer();
                StringBuffer dayTwo = new StringBuffer();
                StringBuffer dayThree = new StringBuffer();
                StringBuffer dayFour = new StringBuffer();
                StringBuffer dayFive = new StringBuffer();
                StringBuffer daySix = new StringBuffer();
                StringBuffer daySeven = new StringBuffer();

                //StringBuffer array to pass the StringBuffer data to each of the days.
                StringBuffer[] StringBuffer = {dayOne, dayTwo, dayThree, dayFour, dayFive,
                        daySix, daySeven};

                //This is used to initialize the weather controller with the zip code input.
                dailyWeatherForecastController = WeatherController.getWeatherDailyForecast(sp.getInt("ZIP", 27403));

                //This will pass the day, summary, high and low temperatures
                for (int i = 0; i < 7; i++) {
                    StringBuffer[i].append("\n   " + dailyWeatherForecastController[i][Globals.TIME].replaceAll("00:00:00 EST 2018", "") + "\n\n");
                    StringBuffer[i].append("   " + dailyWeatherForecastController[i][Globals.SUMMARY] + "\n");
                    StringBuffer[i].append("   High: " + dailyWeatherForecastController[i][Globals.TEMP_HIGH]);
                    StringBuffer[i].append(", Low: " + dailyWeatherForecastController[i][Globals.TEMP_LOW] + "\n\n");
                    w.dailyMessages[i] = StringBuffer[i].toString();
                }

            } catch (Exception exception) {
                exception.getMessage();
            }
            return w;
        }

        /**
         * This method will display the results to the views and be called after everything is done.
         *
         * @param w = Wrapper of string data.
         */
        protected void onPostExecute(Wrapper w) {

            //Iterates through the days to add the correct weather icon.
            for (int i = 0; i < 7; i++) {
                switch (dailyWeatherForecastController[i][Globals.ICON]) {
                    case "clear-day":
                        Icons clear_day = Icons.valueOf("Clear_day".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(clear_day.getIconResID());
                        break;

                    case "clear-night":
                        Icons clear_night = Icons.valueOf("Clear_night".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(clear_night.getIconResID());
                        break;

                    case "cloudy":
                        Icons cloudy = Icons.valueOf("Cloudy".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(cloudy.getIconResID());
                        break;

                    case "fog":
                        Icons fog = Icons.valueOf("Fog".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(fog.getIconResID());
                        break;

                    case "partly-cloudy-day":
                        Icons partly_cloudy_day = Icons.valueOf("Partly_cloudy_day".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(partly_cloudy_day.getIconResID());
                        break;

                    case "partly-cloudy-night":
                        Icons partly_cloudy_night = Icons.valueOf("Partly_cloudy_night".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(partly_cloudy_night.getIconResID());
                        break;

                    case "rain":
                        Icons rain = Icons.valueOf("Rain".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(rain.getIconResID());
                        break;

                    case "sleet":
                        Icons sleet = Icons.valueOf("Sleet".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(sleet.getIconResID());
                        break;

                    case "snow":
                        Icons snow = Icons.valueOf("Snow".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(snow.getIconResID());
                        break;

                    case "wind":
                        Icons wind = Icons.valueOf("Wind".toUpperCase(Locale.ENGLISH));
                        imageViews[i].setImageResource(wind.getIconResID());
                        break;
                }

            }

            //Displays the message to view output
            for (int i = 0; i < 7; i++) {
                textViews[i].setText(w.dailyMessages[i]);
            }
        }
    }
}


