package com.example.bigo.weatherapp;


import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Author: Steven Tran
 */

public class DailyWeather extends CurrentWeather {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_weather);

    }
}