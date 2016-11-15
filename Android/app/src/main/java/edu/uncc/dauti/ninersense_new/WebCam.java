package edu.uncc.dauti.ninersense_new;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class WebCam extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState)
    {super.onCreate(savedInstanceState);
        setContentView(R.layout.webcam_layout);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.ustream.tv/channel/3GDExYEcFFH?utm_campaign=ustre.am&utm_source=ustre.am%2F1xH7w&utm_medium=social&utm_content=20161112142306"));
        startActivity(browserIntent);


    }
}
