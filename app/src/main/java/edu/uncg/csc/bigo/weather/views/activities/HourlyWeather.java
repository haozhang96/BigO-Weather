package edu.uncg.csc.bigo.weather.views.activities;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.WeatherController;
import edu.uncg.csc.bigo.weather.models.util.Globals;


/**
 * A simple {@link Fragment} subclass.
 */
public class HourlyWeather extends Fragment {


    private TextView hourlyMessage;
    String[][] testHourlyWeatherForecastController;



    public HourlyWeather() {
        // Required empty public constructor
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_hourly_weather, container, false);

        //Initialize the message TextView box
        hourlyMessage = v.findViewById(R.id.hourlyMessage);

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
    public class Test extends AsyncTask<Void, Void, String> {

        protected String doInBackground(Void... nothing) {
            try {

                // Store a message buffer to append strings to.
                StringBuffer message = new StringBuffer();

                //Get the zipcode entered by the user.
                int zipCode = 27407;


                //Testing the WeatherController methods
                message.append("Hourly: \n");

                testHourlyWeatherForecastController = WeatherController.getWeatherHourlyForecast(zipCode);

                message.append(testHourlyWeatherForecastController[0][Globals.CITY_STATE_ZIP]+"\n");
                for (int i = 0; i<2; i++) {
                    message.append(testHourlyWeatherForecastController[i][Globals.TIME] + "\n");
                    message.append(testHourlyWeatherForecastController[i][Globals.SUMMARY] + "\n");
                    message.append(testHourlyWeatherForecastController[i][Globals.TEMPERATURE] + "\n\n");
                    message.append(testHourlyWeatherForecastController[i][Globals.ICON] + "\n\n");
                }
                message.append("\n");

                return message.toString();
            } catch (Exception exception) {
                return exception.toString();
            }
        }

        protected void onPostExecute(String result) {
            hourlyMessage.setText(result);
        }
    }

}
