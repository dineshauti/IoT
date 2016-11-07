package edu.uncc.dauti.ninersense_new;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class GarageDoor1AsyncTask extends AsyncTask<String, Void, String> {



    @Override
    protected String doInBackground(String... params) {
        String str = params[0];
        String result = "";
        URL url = null;
        try {
            url = new URL("http://192.168.1.2/garagedoor1.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String data = "garagedoor1=" + str;
            urlConnection.setRequestMethod("POST");
            urlConnection.setDoOutput(true);
            urlConnection.getOutputStream().write(data.getBytes("UTF-8"));
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(), "iso-8859-1"), 8);
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            result = sb.toString().trim();
            Log.d("result", result);


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //http postappSpinners
        return result;
    }


}
