package edu.uncc.dauti.ninersense_new;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Sajin S on 10/27/2016.
 */

public class ThermostatAsyncTask extends AsyncTask<String,Void,String> {



    protected String doInBackground(String... params) {



        String desired = params[0];
        String room = params[1];
        String mode = params[2];

        String result = "";
        URL url = null;
        try {
            url = new URL("https://ninersense.mybluemix.net/thermostat.php");
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            String data = "desired=" + desired+ "&room="+room+ "&mode="+mode;

            urlConnection.setRequestProperty("User-Agent","Chrome/30.0.0.0 Mobile ");
            urlConnection.setRequestProperty("Accept","*/*");

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
interface IData
{
    void getResult(String result);
}
