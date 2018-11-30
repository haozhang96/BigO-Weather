package edu.uncg.csc.bigo.weather.views.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import edu.uncg.csc.bigo.weather.R;

public class Settings extends AppCompatActivity {

    private String button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public void Navigation(View View) {
        button = ((Button) View).getText().toString();
        if (button.equals("Location")) {
            Intent a = new Intent(this, Location.class);
            startActivity(a);
        }
        if (button.equals("Time and Date")) {
            Intent b = new Intent(this, TimeDate.class);
            startActivity(b);
        }
        if (button.equals("About")) {
            Intent c = new Intent(this, About.class);
            startActivity(c);
        }
    }
}
