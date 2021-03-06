package edu.uncc.dauti.ninersense_new;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Created by Sourabhpc on 10/26/2016.
 */

public class BackDoor extends AppCompatActivity {

    Boolean switchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backdoor);  //change the activity name

        Switch simpleSwitch = (Switch) findViewById(R.id.backdoorswitch);

        SharedPreferences sharedPreferences = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE);
        simpleSwitch.setChecked(sharedPreferences.getBoolean("backdoor",false));

    }

    public void backdoor(View view) {
        Switch simpleSwitch = (Switch) findViewById(R.id.backdoorswitch);
        switchState = simpleSwitch.isChecked();
        String str = String.valueOf(switchState);

        if (simpleSwitch.isChecked())
        {
            SharedPreferences.Editor editor = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE).edit();
            editor.putBoolean("backdoor", true);
            editor.commit();
        }
        else
        {
            SharedPreferences.Editor editor = getSharedPreferences("edu.uncc.dauti.ninersense_new",MODE_PRIVATE).edit();
            editor.putBoolean("backdoor", false);
            editor.commit();
        }

        new BackDoorAsyncTask().execute(str);

    }
}
