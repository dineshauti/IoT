package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;


public class ThermoStat extends AppCompatActivity {

    private String ckbox = "2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thermo_stat);


        Button button = (Button) findViewById(R.id.thermostatbutton);
    }

    public void onCheckboxClicked(View view) {

        CheckBox checkBoxA = (CheckBox) findViewById(R.id.checkBoxA);
        CheckBox checkBoxB = (CheckBox) findViewById(R.id.checkBoxB);
        CheckBox checkBoxC = (CheckBox) findViewById(R.id.checkBoxC);


        switch (view.getId()) {

            case R.id.checkBoxA:

                checkBoxB.setChecked(false);
                checkBoxC.setChecked(false);
                ckbox = "0";

                break;

            case R.id.checkBoxB:

                checkBoxC.setChecked(false);
                checkBoxA.setChecked(false);
                ckbox = "1";

                break;

            case R.id.checkBoxC:

                checkBoxA.setChecked(false);
                checkBoxB.setChecked(false);
                ckbox = "2";

                break;
        }

    }
        public void thermostat(View view)
    {
        Button button = (Button) findViewById(R.id.thermostatbutton);
        EditText mEdit;

        TextView textView = (TextView) findViewById(R.id.roomtemp);

        String a = textView.getText().toString();

        mEdit= (EditText) findViewById(R.id.destemp);

        String str = mEdit.getText().toString();



        new ThermostatAsyncTask().execute(str, a, ckbox);






    }

    }



