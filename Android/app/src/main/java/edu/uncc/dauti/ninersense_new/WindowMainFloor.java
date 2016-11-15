package edu.uncc.dauti.ninersense_new;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class WindowMainFloor extends AppCompatActivity {

    Boolean switchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_windowmain);  //change the activity name

        Switch simpleSwitch = (Switch) findViewById(R.id.windowmainswitch);

        SharedPreferences sharedPreferences = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE);
        simpleSwitch.setChecked(sharedPreferences.getBoolean("windowmain",false));

    }

    public void windowmain(View view) {
        Switch simpleSwitch = (Switch) findViewById(R.id.windowmainswitch);
        switchState = simpleSwitch.isChecked();
        String str = String.valueOf(switchState);

        if (simpleSwitch.isChecked())
        {
            SharedPreferences.Editor editor = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE).edit();
            editor.putBoolean("windowmain", true);
            editor.commit();
        }
        else
        {
            SharedPreferences.Editor editor = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE).edit();
            editor.putBoolean("windowmain", false);
            editor.commit();
        }
        new WindowMainFloorAsyncTask().execute(str);

    }
}
