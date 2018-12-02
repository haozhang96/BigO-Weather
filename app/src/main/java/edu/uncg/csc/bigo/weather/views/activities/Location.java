package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import edu.uncg.csc.bigo.weather.R;
import edu.uncg.csc.bigo.weather.data.CreateFile;
import edu.uncg.csc.bigo.weather.data.DataInterface;
import edu.uncg.csc.bigo.weather.data.DataStore;

public class Location extends AppCompatActivity {

    private TextView errorMessage;
    public EditText searchBar;
    public static int zipCode;

    AutoCompleteTextView autoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //Initialize the EditText box.
       // searchBar = findViewById(R.id.searchBar);

        //Initialize the formatting message TextView box
        errorMessage = findViewById(R.id.errorMessage);

        //Initialize the AutoCompleteTextBox which gets data from the saved text file.
        autoView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        // Declare the context of the app.
        final Context context = getApplicationContext();

        try{
            // This is used for CRUD operations.
            DataInterface dataModifier = new DataStore();

            // Returns all of the stored locations from the file.
            String[] zipArray = dataModifier.returnLocation();

            // Create an adapter that connects the context, AutoCompleteTextView and the saved locations
            // array together.
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                    R.layout.support_simple_spinner_dropdown_item, zipArray);

            // Begin displaying the saved locations after the first number has been entered and set
            // the adapter.
            autoView.setThreshold(1);
            autoView.setAdapter(adapter);


        }catch (Exception e){
            e.toString();
        }

   /*     // This generates the drop down list from the text file for the view.
        try {
            // Pass in the directory and file name to be read.
            File loadFile = new File(CreateFile.sortedFilePath);

            // Create ArrayList and Array that will hold the saved locations.
            ArrayList<String> zipList = new ArrayList<String>();
            String[] zipArray = null;

            try (Scanner scanner = new Scanner(loadFile)) {

                // Clear the arrayList.
                zipList.clear();

                while (scanner.hasNext()) {
                    // Add each location that is saved in the file to the arrayList.
                    zipList.add(scanner.next());
                }

                // Transfer the locations from the ArrayList to an Array so they can be used in the
                // AutoCompleteTextView.
                zipArray = (String[]) zipList.toArray(new String[zipList.size()]);

                // Create an adapter that connects the context, AutoCompleteTextView and the saved locations
                // array together.
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),
                        R.layout.support_simple_spinner_dropdown_item, zipArray);

                // Begin displaying the saved locations after the first number has been entered and set
                // the adapter.
                autoView.setThreshold(1);
                autoView.setAdapter(adapter);

            } catch (FileNotFoundException | InputMismatchException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.toString();
        }

*/
                findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Make sure the user inputs a properly formatted zip.
                        if ((autoView.getText().toString().length() != 5)) {
                            errorMessage.setText("Enter a Properly Formatted Zip");
                            autoView.setText("");
                        }//If the zip is correctly formatted assign it to zipCode
                        else if (autoView.getText().toString().length() == 5) {
                            zipCode = Integer.valueOf(autoView.getText().toString());
                            SharedPreferences sp = getSharedPreferences("GLOBAL", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

                            try {
                                // Using the CreateFile class.
                                CreateFile.createFile(context);

                                // This is used for CRUD operations.
                                DataInterface dataModifier = new DataStore();

                                dataModifier.insert(zipCode, context);

                            } catch (Exception exception) {
                                exception.toString();
                            }

                            editor.putInt("ZIP", zipCode);
                            editor.apply();

                            errorMessage.setText("");
                            startActivity(new Intent(Location.this, MainActivity.class));
                        }
                    }
                });
    }
    public static int getZipCode() {
        return zipCode;
    }

}


