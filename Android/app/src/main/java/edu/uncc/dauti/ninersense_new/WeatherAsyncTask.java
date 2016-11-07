package edu.uncc.dauti.ninersense_new;

import android.os.AsyncTask;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class WeatherAsyncTask extends AsyncTask<String, Void, String> {

    IData context;
    private String weatherAPI = "https://api.darksky.net/forecast/6e204a2cf67e1ae67497355898a6cb0b/37.8267,-122.4233";
    public WeatherAsyncTask(IData context) { this.context=context;}

    @Override
    protected String doInBackground(String... params) {

        String result = "";
        URL url = null;
        try {
            url = new URL(weatherAPI);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = "";
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString();
            //Log.d("result", result);
            return parseWeatherJSON(sb.toString());


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //http postappSpinners
        return null;
    }

    private String parseWeatherJSON(String JSONResponse)
    {
        String temp = null;
        String summary = null;
        String totalSummary = null;
        try {
            JSONObject jsonObject = new JSONObject(JSONResponse);
            temp = jsonObject.getJSONObject("currently").getString("temperature");
            summary = jsonObject.getJSONObject("currently").getString("summary");
            totalSummary = summary + "  " + temp + "°F";
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return totalSummary;
    }

    @Override
    protected void onPostExecute(String s) {
        context.getWeather(s);
    }

    interface IData {
        void getWeather(String temp);
    }
}
