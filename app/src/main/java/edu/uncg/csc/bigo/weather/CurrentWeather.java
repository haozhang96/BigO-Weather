package com.example.bigo.weatherapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class CurrentWeather extends AppCompatActivity {
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
        if (button_text.equals("Currently")) {
            Intent a = new Intent(this, CurrentWeather.class);
            startActivity(a);
        } if (button_text.equals("Hourly")) {
            Intent b = new Intent(this, HourlyWeather.class);
            startActivity(b);
        } if (button_text.equals("Daily")) {
            Intent c = new Intent(this, DailyWeather.class);
            startActivity(c);

        } if (button_text.equals("Map")) {
            Intent d = new Intent(this, Map.class);
            startActivity(d);

        } if (button_text.equals("Settings")) {
            Intent e = new Intent(this, Settings.class);
            startActivity(e);

        }
    }
}
