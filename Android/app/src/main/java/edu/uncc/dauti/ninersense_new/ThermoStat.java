package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ThermoStat extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermo_stat);

        Button button = (Button) findViewById(R.id.thermostatbutton);
    }


        public void thermostat(View view)
    {
        Button button = (Button) findViewById(R.id.thermostatbutton);
        EditText mEdit;
        mEdit= (EditText) findViewById(R.id.editText6);

        String str = mEdit.getText().toString();

        new ThermostatAsyncTask().execute(str);






    }

    }



