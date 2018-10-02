package com.example.bigo.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CurrentWeatherActivity extends AppCompatActivity {
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_weather);
        textView = findViewById(R.id.text);

    }

    public void Navigation(View View) {
        String button_text;
        button_text = ((Button) View).getText().toString();
        if (button_text.equals("Hourly Weather")) {
            Intent a = new Intent(this, HourlyWeatherActivity.class);
            startActivity(a);
        } if (button_text.equals("Daily Weather")) {
            Intent b = new Intent(this, DailyWeatherActivity.class);
            startActivity(b);

        } if (button_text.equals("Map View")) {
            Intent c = new Intent(this, MapActivity.class);
            startActivity(c);

        } if (button_text.equals("Settings")) {
            Intent d = new Intent(this, SettingsActivity.class);
            startActivity(d);

        }
    }
}
