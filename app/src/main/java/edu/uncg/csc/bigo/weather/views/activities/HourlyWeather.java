package edu.uncg.csc.bigo.weather.views.activities;


import android.content.Intent;
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
import edu.uncg.csc.bigo.weather.controllers.DataController;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.util.Globals;
import edu.uncg.csc.bigo.weather.views.Icons;

import static android.content.Context.MODE_PRIVATE;


/**
 * The third fragment activity that represents the hourly weather view. This fragment is made from
 * the MainActivity class. It shows the date, apparent temperature, summary, and weather icon.
 *
 * @Updated 12/2/2018
 * @Author Steven Tran
 */
public class HourlyWeather extends Fragment {


    //The textviews for each hour.
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

    //The image for each hour.
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

    //The buttons for each hour.
    private Button hourDetailOne;
    private Button hourDetailTwo;
    private Button hourDetailThree;
    private Button hourDetailFour;
    private Button hourDetailFive;
    private Button hourDetailSix;
    private Button hourDetailSeven;
    private Button hourDetailEight;
    private Button hourDetailNine;
    private Button hourDetailTen;
    private Button hourDetailEleven;
    private Button hourDetailTwelve;


    //The array for the textviews.
    private TextView[] textViews = {hourOneMessage, hourTwoMessage, hourThreeMessage,
            hourFourMessage, hourFiveMessage, hourSixMessage, hourSevenMessage, hourEightMessage,
            hourNineMessage, hourTenMessage, hourElevenMessage, hourTwelveMessage};

    //The array for the integer that represent the textview ID.
    private Integer[] textViewID = {R.id.hourOneMessage, R.id.hourTwoMessage, R.id.hourThreeMessage,
            R.id.hourFourMessage, R.id.hourFiveMessage, R.id.hourSixMessage, R.id.hourSevenMessage,
            R.id.hourEightMessage, R.id.hourNineMessage, R.id.hourTenMessage, R.id.hourElevenMessage,
            R.id.hourTwelveMessage};


    //The array for the imageviews.
    private ImageView[] imageViews = {hourOneImage, hourTwoImage, hourThreeImage, hourFourImage,
            hourFiveImage, hourSixImage, hourSevenImage, hourEightImage, hourNineImage,
            hourTenImage, hourElevenImage, hourTwelveImage};


    //The array for the integer that represents the image ID.
    private Integer[] imageViewID = {R.id.hourOneImage, R.id.hourTwoImage, R.id.hourThreeImage,
            R.id.hourFourImage, R.id.hourFiveImage, R.id.hourSixImage, R.id.hourSevenImage,
            R.id.hourEightImage, R.id.hourNineImage, R.id.hourTenImage, R.id.hourElevenImage,
            R.id.hourTwelveImage};

    //The array that represents the buttons.
    private Button[] buttons = {hourDetailOne, hourDetailTwo, hourDetailThree, hourDetailFour,
            hourDetailFive, hourDetailSix, hourDetailSeven, hourDetailEight, hourDetailNine,
            hourDetailTen, hourDetailEleven, hourDetailTwelve};


    //The array of integers that represent the button IDs.
    private Integer[] buttonID = {R.id.hourDetailOne, R.id.hourDetailTwo, R.id.detailedThree,
            R.id.hourDetailFour, R.id.hourDetailFive, R.id.hourDetailSix, R.id.hourDetailSeven,
            R.id.hourDetailEight, R.id.hourDetailNine, R.id.hourDetailTen, R.id.hourDetailEleven,
            R.id.hourDetailTwelve};

    //The 2D array for the controller.
    String[][] hourlyWeatherForecastController;

    /**
     * After onCreate method, this method handles executing the data retrieval and creating a saved
     * instance.
     *
     * @param _savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);

        //The shared preference for the hourly data.
        SharedPreferences preferences = getActivity().getSharedPreferences("HOURLY", MODE_PRIVATE);

        //The editor for the hourly key.
        final SharedPreferences.Editor editor = preferences.edit();

        //Loops through the buttons to apply a shared preference key.
        for (int i = 0; i < 12; i++) {
            final int finalI = i;
            getActivity().findViewById(buttonID[i]).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (finalI) {
                        case 0:
                            editor.putString("HourlyDetails", "0");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 1:
                            editor.putString("HourlyDetails", "1");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 2:
                            editor.putString("HourlyDetails", "2");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 3:
                            editor.putString("HourlyDetails", "3");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 4:
                            editor.putString("HourlyDetails", "4");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 5:
                            editor.putString("HourlyDetails", "5");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 6:
                            editor.putString("HourlyDetails", "6");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;

                        case 7:
                            editor.putString("HourlyDetails", "7");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 8:
                            editor.putString("HourlyDetails", "8");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 9:
                            editor.putString("HourlyDetails", "9");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 10:
                            editor.putString("HourlyDetails", "10");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                        case 11:
                            editor.putString("HourlyDetails", "11");
                            editor.apply();
                            startActivity(new Intent(getActivity(), HourlyDetailed.class));
                            break;
                    }

                }
            });
        }

        //Executing the hourly data.
        new HourlyDataRetrieval().execute();

    }

    /**
     * The initial startup loading from the view to handle the initializations.
     *
     * @param _inflater
     * @param _container
     * @param _savedInstanceState
     * @return v = Hourly Fragment Layout View
     */
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container,
                             Bundle _savedInstanceState) {

        //Initializing the view to the hourly weather fragment
        View v = _inflater.inflate(R.layout.fragment_hourly_weather, _container, false);

        //Initializing the hourly messages and images
        for (int i = 0; i < 12; i++) {
            textViews[i] = v.findViewById(textViewID[i]);
            imageViews[i] = v.findViewById(imageViewID[i]);
        }

        return v;
    }


    /**
     * This class is used for retrieving (HOURLY WEATHER) data from the Weather Controllers
     * to obtain the requested data for the user. It works in the background to handle problems
     * with running in the main thread. This allows the app to perform long/background operations
     * and show the results on the UI thread without having to manipulate threads.
     *
     * @Updated: 12/2/2018
     * @Author Steven Tran
     */
    protected class HourlyDataRetrieval extends AsyncTask<Void, Void, Wrapper> {

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

                //StringBuffer array to pass the StringBuffer data to each of the hours.
                StringBuffer[] StringBuffer = {message, message2, message3, message4, message5,
                        message6, message7, message8, message9, message10, message11, message12};

                //This is used to initialize the weather controller with the zip code input.
                hourlyWeatherForecastController = WeatherController.getWeatherHourlyForecast(sp.getInt("ZIP", 27403));

                //This will pass the time, summary, and temperature
                for (int i = 0; i < 12; i++) {
                    StringBuffer[i].append("\n   " + hourlyWeatherForecastController[i][Globals.TIME] + "\n");
                    StringBuffer[i].append("   " + hourlyWeatherForecastController[i][Globals.SUMMARY] + "\n");
                    StringBuffer[i].append("   " + hourlyWeatherForecastController[i][Globals.TEMPERATURE] + "\n\n");
                    w.hourlyMessages[i] = StringBuffer[i].toString();
                }

            } catch (Exception _exception) {

            }
            return w;
        }

        /**
         * This method will display the results to the views and be called after everything is done.
         *
         * @param _w = Wrapper of string data.
         */
        protected void onPostExecute(Wrapper _w) {
            try {
                //Iterates through the hours to add the correct weather icon.
                for (int i = 0; i < 12; i++) {
                    switch (hourlyWeatherForecastController[i][Globals.ICON]) {
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

                // Catch invalid zip codes here and display error message.
            } catch (Exception e) {
                textViews[0].setText(_w.hourlyMessages[0] = "HOURLY: Invalid Zip Code. Please Try Again.");

                // Erase invalid inputs from the file.
                DataController controller = new DataController();
                controller.removeController();
            }
            //Displays the message to view output
            for (int i = 0; i < 12; i++) {
                textViews[i].setText(_w.hourlyMessages[i]);
            }
        }
    }

}
