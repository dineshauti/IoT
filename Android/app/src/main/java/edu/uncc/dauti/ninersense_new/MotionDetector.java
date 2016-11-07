package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class MotionDetector extends AppCompatActivity {
    Boolean switchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_motiondetector);  //change the activity name

    }

    public void motiondetector(View view) {
        Switch simpleSwitch = (Switch) findViewById(R.id.motiondetectorswitch);
        switchState = simpleSwitch.isChecked();
        String str = String.valueOf(switchState);
        new MotionDetectorAsyncTask().execute(str);

    }
}
