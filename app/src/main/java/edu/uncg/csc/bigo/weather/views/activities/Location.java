package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.controllers.DataController;
import edu.uncg.csc.bigo.weather.data.CreateFile;

/**
 * This class is responsible for setting the app off to choose a location for their weather.
 *
 * @Updated: 12/4/2018
 * @Authors: Steven Tran, Harmain Bains
 */
public class Location extends AppCompatActivity {

    //Textview for error message (wrong zip code).
    private TextView errorMessage;

    //Int used to store zip code.
    private int zipCode;

    //Autocomplete view for search bar.
    AutoCompleteTextView autoView;


    @Override
    protected void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        //Setting the view to Location view.
        setContentView(R.layout.activity_location);

        //Initialize the formatting message TextView box.
        errorMessage = findViewById(R.id.errorMessage);

        //Initialize the AutoCompleteTextBox which gets data from the saved text file.
        autoView = findViewById(R.id.autoCompleteTextView);

        // Declare the context of the app.
        final Context context = getApplicationContext();

        try {
            // This is used for CRUD operations.
            DataController dataController = new DataController();

            // Returns all of the stored locations from the file.
            String[] zipArray = dataController.returnLocation();

            // Create an adapter that connects the context, AutoCompleteTextView and the saved locations
            // array together.
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.support_simple_spinner_dropdown_item, zipArray);

            // Begin displaying the saved locations after the first number has been entered and set
            // the adapter.
            autoView.setThreshold(1);
            autoView.setAdapter(adapter);

        } catch (Exception e) {
            e.toString();
        }

        //This gets set off when the button gets clicked on.
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View _v) {
                //Make sure the user inputs a properly formatted zip.
                if ((autoView.getText().toString().length() != 5)) {
                    errorMessage.setText("Enter a Properly Formatted Zip");
                    autoView.setText("");
                }//If the zip is correctly formatted assign it to zipCode
                else if (autoView.getText().toString().length() == 5) {
                    zipCode = Integer.valueOf(autoView.getText().toString());

                    //Shared preference for storing the zip code.
                    SharedPreferences sp = getSharedPreferences("GLOBAL", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();

                    try {
                        // Using the CreateFile class.
                        CreateFile.createFile(context);

                        // This is used for CRUD operations.
                        DataController dataController = new DataController();
                        dataController.insert(zipCode, context);

                    } catch (Exception exception) {
                        exception.toString();
                    }

                    //Actually storing the int into shared preference editor.
                    editor.putInt("ZIP", zipCode);
                    editor.apply();

                    errorMessage.setText("");

                    //Switching from location view to Main activity.
                    startActivity(new Intent(Location.this, MainActivity.class));
                }
            }
        });
    }
}


