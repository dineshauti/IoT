package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class GarageDoor1 extends AppCompatActivity {

    Boolean switchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagedoor2car);  //change the activity name

    }

    public void garagedoor2car(View view) {
        Switch simpleSwitch = (Switch) findViewById(R.id.garagedoor2switch);
        switchState = simpleSwitch.isChecked();
        String str = String.valueOf(switchState);
        new GarageDoor1AsyncTask().execute(str);

    }

}
