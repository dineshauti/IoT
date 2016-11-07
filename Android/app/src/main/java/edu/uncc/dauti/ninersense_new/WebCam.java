package edu.uncc.dauti.ninersense_new;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class WebCam extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState)
    {super.onCreate(savedInstanceState);
        setContentView(R.layout.webcam_layout);

        WebView browser = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = browser.getSettings();
        webSettings.setJavaScriptEnabled(true);

        browser.loadUrl("http://192.168.0.6:8080/flash.html");


    }
}
