package edu.uncc.dauti.ninersense_new;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Switch;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class FrontDoor extends AppCompatActivity implements FrontDoorAsyncTask.IData {

    Boolean switchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frontdoor);  //change the activity name

        Switch simpleSwitch = (Switch) findViewById(R.id.frontdoorswitch);

        SharedPreferences sharedPreferences = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE);
        simpleSwitch.setChecked(sharedPreferences.getBoolean("frontdoor",false));


    }

    public void frontdoor(View view) {
        Switch simpleSwitch = (Switch) findViewById(R.id.frontdoorswitch);
        switchState = simpleSwitch.isChecked();
        String str = String.valueOf(switchState);
        Log.d("z",str);
        if (simpleSwitch.isChecked())
        {
            SharedPreferences.Editor editor = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE).edit();
            editor.putBoolean("frontdoor", true);
            editor.commit();
        }
        else
        {
            SharedPreferences.Editor editor = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE).edit();
            editor.putBoolean("frontdoor", false);
            editor.commit();
        }
        new FrontDoorAsyncTask(FrontDoor.this).execute(str);

    }

}
