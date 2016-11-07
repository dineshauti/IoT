package edu.uncc.dauti.ninersense_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SummaryTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary_task);

        Button backdoor = (Button) findViewById(R.id.backdoorbutton);
        Button frontdoor = (Button) findViewById(R.id.frontdoorbutton);
        Button garagedoor1car = (Button) findViewById(R.id.garagedoorbutton);
        Button garagedoor2car = (Button) findViewById(R.id.garagedoor2button);
        Button motiondetector = (Button) findViewById(R.id.motiondetectorbutton);
        Button windowmain = (Button) findViewById(R.id.windowmainbutton);
        Button windowupstairs = (Button) findViewById(R.id.windowupstairsbutton);
        Button webcam = (Button) findViewById(R.id.webview);
        Button weather = (Button) findViewById(R.id.weather);
        Button security = (Button) findViewById(R.id.securitybutton);
        Button thermo= (Button) findViewById(R.id.thermostat);



        security.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SummaryTask.this, SecuritySystem.class);
                startActivity(intent);

            }
        });
        thermo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryTask.this, ThermoStat.class);
                startActivity(intent);

            }
        });






        weather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SummaryTask.this, Weather.class);
                startActivity(intent);

            }
        });



        windowupstairs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SummaryTask.this, WindowUpstairs.class);
                startActivity(intent);

            }
        });


        webcam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SummaryTask.this, WebCam.class);
                startActivity(intent);

            }
        });


        windowmain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryTask.this, WindowMainFloor.class);
                startActivity(intent);
            }
        });


        motiondetector.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryTask.this,MotionDetector.class);
                startActivity(intent);
            }
        });





        backdoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SummaryTask.this, BackDoor.class);
                startActivity(intent);
            }
        });

        frontdoor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SummaryTask.this, FrontDoor.class);
                startActivity(intent);
            }
        });


        garagedoor1car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SummaryTask.this, GarageDoor.class);
                startActivity(intent);
            }
        });

        garagedoor2car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(SummaryTask.this, GarageDoor1.class);
                startActivity(intent);
            }
        });
    }
}
