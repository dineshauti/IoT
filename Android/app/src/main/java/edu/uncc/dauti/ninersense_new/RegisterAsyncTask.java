package edu.uncc.dauti.ninersense_new;

import android.os.AsyncTask;
import android.util.Log;

import java.net.HttpURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Sajin S on 10/23/2016.
 */

public class RegisterAsyncTask extends AsyncTask<String,Void,String>{



    IData2 context;
    public RegisterAsyncTask(IData2 context) {
        this.context = context;
    }



    @Override
    protected String doInBackground(String... params) {
        String result = "";
        String usr = params[0];
        String pwd = params[1];
        String firstName = params[2];
        String lastName = params[3];

        URL url = null;

        try {
            url = new URL("http://192.168.1.2/register.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            String data = "username=" + usr + "&password=" + pwd + "&firstname=" + firstName + "&lastname=" +  lastName;
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

    protected void onPostExecute(String result) {
        Log.d("result",result);
        context.getRegistration(result);
    }

    interface IData2
    {
        void getRegistration(String result);
    }
}
