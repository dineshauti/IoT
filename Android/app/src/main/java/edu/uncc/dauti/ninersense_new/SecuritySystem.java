package edu.uncc.dauti.ninersense_new;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SecuritySystem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_system);
    }


    public void securitystatus(View view)
    {
        Button disarmed = (Button)findViewById(R.id.disarmbutton);
        Button armedaway = (Button)findViewById(R.id.armedawaybutton);
        Button armedstay = (Button)findViewById(R.id.armedstaybutton);
        String str="";
       // Toast.makeText(SecuritySystem.this,String.valueOf(view.getId()),Toast.LENGTH_LONG).show();
       // Toast.makeText(SecuritySystem.this,String.valueOf(R.id.disarmbutton),Toast.LENGTH_LONG).show();


        switch(view.getId())
        {
            case R.id.disarmbutton:
                str = String.valueOf(0);
// handle button A click;
                break;
            case R.id.armedawaybutton:
                str=String.valueOf(1);
// handle button B click;
                break;
            case R.id.armedstaybutton:
                str=String.valueOf(2);
                break;
            default:
                throw new RuntimeException("Unknow button ID");
        }

        /*if(disarmed.is())
            str = String.valueOf(0);
        else
            if(armedaway.isPressed())
                str= String.valueOf(1);
        else
                if(armedstay.isPressed())
                    str= String.valueOf(2);*/
        new SecuritySystemAsyncTask().execute(str);



    }

}
