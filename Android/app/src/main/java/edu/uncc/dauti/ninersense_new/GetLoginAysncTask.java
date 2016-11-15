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
 * Created by Dinesh Auti on 22-10-2016.
 */
public class GetLoginAysncTask extends AsyncTask<String,Void,String> {

    IData context;

    public GetLoginAysncTask(IData context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... params) {
        String result = "";
        String usr = params[0];
        String pwd = params[1];
        URL url = null;
        try {
            url = new URL("https://ninersense.mybluemix.net/login.php");
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            String data = "username=" + usr + "&password=" + pwd;
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

    @Override
    protected void onPostExecute(String result) {
        Log.d("result",result);
        context.getResult(result);
    }

    interface IData
    {
        void getResult(String result);
    }
}
