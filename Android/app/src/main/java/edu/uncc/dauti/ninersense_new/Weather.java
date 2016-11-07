package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class Weather extends AppCompatActivity implements WeatherAsyncTask.IData {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);  //change the activity name
        new WeatherAsyncTask(this).execute();

    }


    @Override
    public void getWeather(String temp) {
        TextView weatherView = (TextView) findViewById(R.id.weatherTextView);
        weatherView.setText(String.valueOf(temp));




    }
}
