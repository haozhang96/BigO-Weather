package edu.uncg.csc.bigo.weather.views.activities;

import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
 * The first fragment activity that represents the current weather view. This fragment is made from
 * the MainActivity class. It shows the current temperature, city name, weather summary, precipitation,
 * humidity, wind speed, and weather icon.
 *
 * @Updated 12/2/2018
 * @Author Steven Tran
 */
public class CurrentWeather extends Fragment {

    private TextView temperature;
    private TextView currentMessage;

    private ImageView weatherIcon;

    private String[] currentWeatherController;


    /**
     * After onCreate method, this method handles executing the data retrieval and creating a saved
     * instance.
     *
     * @param _savedInstanceState
     */
    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);

        new CurrentDataRetrieval().execute();
    }

    /**
     * The initial startup loading from the view to handle the initializations.
     *
     * @param _inflater
     * @param _container
     * @param _savedInstanceState
     * @return v = Current Fragment Layout View
     */
    public View onCreateView(LayoutInflater _inflater, ViewGroup _container,
                             Bundle _savedInstanceState) {

        //Initializing the view to the current weather fragment.
        View v = _inflater.inflate(R.layout.fragment_current_weather, _container, false);

        //Initializing the weather icon.
        weatherIcon = v.findViewById(R.id.imageView);

        //Initializing the current message.
        currentMessage = v.findViewById(R.id.currentMessage);

        //Initializing the temperature message.
        temperature = v.findViewById(R.id.temperature);

        return v;
    }

    /**
     * This class is used for retrieving (CURRENT WEATHER) data from the Weather Controllers
     * to obtain the requested data for the user. It works in the background to handle problems
     * with running in the main thread. This allows the app to perform long/background operations
     * and show the results on the UI thread without having to manipulate threads.
     *
     * @Updated: 12/2/2018
     * @Author Steven Tran
     */
    private class CurrentDataRetrieval extends AsyncTask<Void, Void, Wrapper> {
        SharedPreferences sp;

        /**
         * @param _nothing
         * @return w = Wrapper of String data.
         */
        protected Wrapper doInBackground(Void... _nothing) {

            //Obtaining instance of Wrapper object to retrieve more than one string
            Wrapper w = new Wrapper();

            try {
                //This is used to retrieve the zipCode data from the Location class.
                sp = getActivity().getSharedPreferences("GLOBAL", MODE_PRIVATE);

                //This is used to initialize the weather controller with the zip code input.
                currentWeatherController = WeatherController.getWeatherCurrent(sp.getInt("ZIP", 27403));

                //This stores a message buffer to append strings to.
                StringBuffer StringBuffer = new StringBuffer();

                //This will pass the current temperature to a string for message output.
                String temp = currentWeatherController[Globals.APPARENT_TEMPERATURE];

                //This will pass the city, summary, precipitation, humidity, and wind speed
                StringBuffer.append(currentWeatherController[Globals.CITY_STATE_ZIP] + "\n");
                StringBuffer.append("Summary: " + currentWeatherController[Globals.SUMMARY] + "\n");
                StringBuffer.append("Precipitation: " + currentWeatherController[Globals.PRECIP_PROBABILITY] + "\n");
                StringBuffer.append("Humidity: " + currentWeatherController[Globals.HUMIDITY] + "\n");
                StringBuffer.append("Wind Speed: " + currentWeatherController[Globals.WIND_SPEED] + "\n");

                //This will set the two wrapper variables from the String/StringBuffer.
                w.currentMessage = StringBuffer.toString();
                w.temperature = temp;
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
            try {

                //This will choose the correct weather icon for the ImageView.
                switch (currentWeatherController[Globals.ICON]) {
                    case "clear-day":
                        Icons clear_day = Icons.valueOf("Clear_day".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(clear_day.getIconResID());
                        break;

                    case "clear-night":
                        Icons clear_night = Icons.valueOf("Clear_night".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(clear_night.getIconResID());
                        break;

                    case "cloudy":
                        Icons cloudy = Icons.valueOf("Cloudy".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(cloudy.getIconResID());
                        break;

                    case "fog":
                        Icons fog = Icons.valueOf("Fog".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(fog.getIconResID());
                        break;

                    case "partly-cloudy-day":
                        Icons partly_cloudy_day = Icons.valueOf("Partly_cloudy_day".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(partly_cloudy_day.getIconResID());
                        break;

                    case "partly-cloudy-night":
                        Icons partly_cloudy_night = Icons.valueOf("Partly_cloudy_night".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(partly_cloudy_night.getIconResID());
                        break;

                    case "rain":
                        Icons rain = Icons.valueOf("Rain".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(rain.getIconResID());
                        break;

                    case "sleet":
                        Icons sleet = Icons.valueOf("Sleet".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(sleet.getIconResID());
                        break;

                    case "snow":
                        Icons snow = Icons.valueOf("Snow".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(snow.getIconResID());
                        break;

                    case "wind":
                        Icons wind = Icons.valueOf("Wind".toUpperCase(Locale.ENGLISH));
                        weatherIcon.setImageResource(wind.getIconResID());
                        break;
                }

                //Sets the TextViews with the String data for view output.
                currentMessage.setText(w.currentMessage);
                temperature.setText(w.temperature);

                // Catch invalid zip codes here and display error message.
            } catch (Exception _e) {
                currentMessage.setText(w.currentMessage = "CURRENTLY: Invalid Zip Code. Please Try Again.");

                // Erase invalid inputs from the file.
                DataController controller = new DataController();

                // Retrieve the zip code from SharedPreference and default to 27403 if an error occurs.
                controller.removeInvalidZipCodeController(sp.getInt("ZIP", 27403), getContext());
            }
        }
    }
}

