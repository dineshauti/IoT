package edu.uncc.dauti.ninersense_new;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GetLoginAysncTask.IData{

    static String userString;
    static String pwdString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText userName= (EditText)findViewById(R.id.editText1);
        final EditText password= (EditText)findViewById(R.id.editText2);
        //password.setTransformationMethod(new PasswordTransformationMethod());
        password.setHint(R.string.password_hint);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);


        //Registration snippet
        final Button register_button = (Button) findViewById(R.id.button3);
        register_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(isNetworkAvailable()){
                    Log.d("test","Network available");
                    Intent regActivity = new Intent(getBaseContext(),RegisterActivity.class);
                    startActivity(regActivity);
                }

                else{
                    Toast.makeText(getBaseContext(), R.string.noInternet, Toast.LENGTH_SHORT).show();
                }
            }
        });

        final Button login_button = (Button) findViewById(R.id.button2);
        login_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


                userString = userName.getText().toString();
                pwdString = password.getText().toString();
                boolean isValid = true;
                if(userString.equals("")) {
                    userName.setError("Username required");
                    isValid = false;
                } else if(pwdString.equals(""))
                {
                    password.setError("Password required");
                    isValid = false;
                }

                if(isValid) {
                    new GetLoginAysncTask(MainActivity.this).execute(userString, pwdString);
                }
            }
        });

    }



    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();

        final EditText userName= (EditText)findViewById(R.id.editText1);
        final EditText password= (EditText)findViewById(R.id.editText2);
        userName.setText("");
        password.setText("");
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        // if no network is available networkInfo will be null, otherwise check if we are connected
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        }
        return false;
    }


    @Override
    public void getResult(String result) {
        Log.d("result in main activity",result);
        Toast.makeText(MainActivity.this,result,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(MainActivity.this,SummaryTask.class);//Mistake zone!!!!!!!!


        if(result.equals("false")) {
            Toast.makeText(getBaseContext(), "Invalid Username/Password!", Toast.LENGTH_SHORT).show();
        } else if (result.equals("true"))
        {
            startActivity(intent);
        } else{
            Toast.makeText(getBaseContext(), "Cannot connect to server", Toast.LENGTH_SHORT).show();

        }

    }




}


