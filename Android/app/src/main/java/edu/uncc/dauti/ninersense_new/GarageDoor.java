package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;

/**
 * Created by Dinesh Auti on 22-10-2016.
 */
public class GarageDoor extends AppCompatActivity implements GarageDoorAsyncTask.IData {

    Boolean switchState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garagedoor);

    }

    public void garagedoor(View view) {
        Switch simpleSwitch = (Switch) findViewById(R.id.garagedoorswitch);
        switchState = simpleSwitch.isChecked();
        String str = String.valueOf(switchState);
        //Log.d("z",str);
        new GarageDoorAsyncTask(GarageDoor.this).execute(str);

    }


    @Override
    public void garageDoorDataSet(String s) {

    }
}
