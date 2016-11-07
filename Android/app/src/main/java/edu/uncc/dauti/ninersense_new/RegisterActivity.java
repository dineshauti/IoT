package edu.uncc.dauti.ninersense_new;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Sajin S on 10/23/2016.
 */

public class RegisterActivity extends AppCompatActivity implements RegisterAsyncTask.IData2{


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);



        final EditText usrName = (EditText) findViewById(R.id.editText1);
        final EditText pwd = (EditText) findViewById(R.id.editText2);
        final EditText verifyPwd = (EditText) findViewById(R.id.editText3);
        final EditText firstName = (EditText) findViewById(R.id.editText4);
        final EditText lastName = (EditText) findViewById(R.id.editText5);



        //mapping the button from the main layout
        Button resetButton = (Button) findViewById(R.id.button1);
        Button registerButton = (Button) findViewById(R.id.button2);
        Button backButton = (Button) findViewById(R.id.button3);

        // setting functions for the reset button
        resetButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                usrName.setText("");
                pwd.setText("");
                verifyPwd.setText("");
                firstName.setText("");
                lastName.setText("");


            }
        });

        // setting functions for the endApp button. goes to main screen
        backButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });

        //setting functions to the register button
        // all validations are done here
        registerButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //getting current string values from the view
                String userName = usrName.getText().toString();
                String password = pwd.getText().toString();
                String vPassword = verifyPwd.getText().toString();
                String first_Name = firstName.getText().toString();
                String last_Name = lastName.getText().toString();




                // all the validations are done in sequence
                if (userName.length() == 0){
                    usrName.setError(getResources().getString(R.string.username_error_message));
                }
                else if (userName.length() < 6){
                    usrName.setError(getResources().getString(R.string.minimum_length_error));
                }
                else if (password.length() == 0){
                    pwd.setError(getResources().getString(R.string.password_error_message));
                }
                else if ((password.length() < 6)){
                    pwd.setError(getResources().getString(R.string.minimum_length_error));
                }
                else if (vPassword.length() == 0){
                    verifyPwd.setError(getResources().getString(R.string.password_error_message));
                }
                else if (!password.equals(vPassword)){
                    verifyPwd.setError(getResources().getString(R.string.passwordmatch_error_message));
                }
                else if (first_Name.length() == 0){
                    firstName.setError(getResources().getString(R.string.fName_error_message));
                }
                else if (last_Name.length() == 0){
                    lastName.setError(getResources().getString(R.string.lName_error_message));
                }

                //finally on successfull verification the appropriate message is displayed
                else {

                    new RegisterAsyncTask(RegisterActivity.this).execute(userName,password,first_Name,last_Name);

                }
            }
        });

    }

    @Override
    public void getRegistration(String result) {
        Log.d("result in main activity",result);
        //Toast.makeText(MainActivity.,result,Toast.LENGTH_LONG).show();
        Intent intent = new Intent(RegisterActivity.this,MainActivity.class);

        if(result.equals("false")) {
            Toast.makeText(getBaseContext(), "Registration Failed!", Toast.LENGTH_SHORT).show();
        }

        else{
            Toast.makeText(getBaseContext(), "Registration Success!", Toast.LENGTH_SHORT).show();
            startActivity(intent);
        }

    }
}
