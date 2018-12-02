package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import edu.uncg.csc.bigo.weather.R;

public class Location extends AppCompatActivity {

    private TextView errorMessage;
    public EditText searchBar;
    public static int zipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        //Initialize the EditText box.
        searchBar = findViewById(R.id.searchBar);

        //Initialize the formatting message TextView box
        errorMessage = findViewById(R.id.errorMessage);


                findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //Make sure the user inputs a properly formatted zip.
                        if ((searchBar.getText().toString().length() != 5)) {
                            errorMessage.setText("Enter a Properly Formatted Zip");
                            searchBar.setText("");
                        }//If the zip is correctly formatted assign it to zipCode
                        else if (searchBar.getText().toString().length() == 5) {
                            zipCode = Integer.valueOf(searchBar.getText().toString());
                            SharedPreferences sp = getSharedPreferences("GLOBAL", MODE_PRIVATE);
                            SharedPreferences.Editor editor = sp.edit();

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


