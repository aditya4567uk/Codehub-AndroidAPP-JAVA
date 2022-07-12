package com.example.codehub;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.util.Pair;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    //variables #5D1D88 PURPLE #FFB700 #007EE5 #FFFFFF 3D464D

    ImageView backbtn;
    Button next , login;
    TextView titleText ,slideText;

    //TextInputLayout username,email,password;
    //TextInputLayout fullName = findViewById(R.id.signup_fullname);
    //String nameS = fullName.getEditText().getText().toString();
    //String userS = username.getEditText().getText().toString().trim();
    //String emailS = email.getEditText().getText().toString().trim();
    //String passwordS = password.getEditText().getText().toString().trim();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up);

        //hooks
        backbtn = findViewById(R.id.signup_back_button);
        next = findViewById(R.id.signup_next_btn);
        login = findViewById(R.id.signup_login_button);
        titleText = findViewById(R.id.signup_title_text);
        //fullName = findViewById(R.id.signup_fullname);
    }

    public void callnextsignupscreen(View view){
        //some code

        //if(!validateFullName() | !validateUsername() | !validateEmail() | !validatePassword()){
            //return;
        //}



        Intent intent = new Intent(getApplicationContext(),Signup2ndClass.class);
        //add transition
        /*Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View,String>(backbtn,"transition_back_arrow_btn");
        pairs[1] = new Pair<View,String>(next,"transition_next_btn");
        pairs[2] = new Pair<View,String>(login,"transition_login_btn");
        pairs[3] = new Pair<View,String>(titleText,"transition_title_text");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this);


        //intent.putExtra("name",nameS);
        //intent.putExtra("userName",userS);
        //intent.putExtra("email",emailS);
        //intent.putExtra("password",passwordS);*/
        //intent.putExtra("name",nameS);
        TextInputLayout fullName = findViewById(R.id.signup_fullname);
        TextInputLayout username = findViewById(R.id.signup_username);
        TextInputLayout email = findViewById(R.id.signup_email);
        TextInputLayout password = findViewById(R.id.signup_password);

        String nameS = fullName.getEditText().getText().toString();
        String userS = username.getEditText().getText().toString();
        String emailS = email.getEditText().getText().toString();
        String passwordS = password.getEditText().getText().toString();


        intent.putExtra("name",nameS);
        intent.putExtra("user",userS);
        intent.putExtra("email",emailS);
        intent.putExtra("password",passwordS);
        startActivity(intent);
    }

    public void callloginsignupscreen(View view){
        //some code
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }

    /*private boolean validateFullName(){
        String val = fullName.getEditText().getText().toString().trim();

        if(val.isEmpty()){
            fullName.setError("Field can not be empty");
            return false;
        }
        else{
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }*/

    /*private boolean validateUsername(){
        String val = username.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            username.setError("Field can not be empty");
            return false;
        }
        else if(val.length()>20){
            username.setError("Username is too long");
            return false;
        }
        else if(!val.matches(checkspaces)){
            username.setError("please remove white spaces");
            return false;
        }
        else{
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }
    }*/

    /*private boolean validateEmail(){
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            email.setError("Field can not be empty");
            return false;
        }
        else if(!val.matches(checkEmail)){
            email.setError("please remove white spaces");
            return false;
        }
        else{
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }*/

    /*private boolean validatePassword(){
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                //"(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$";

        if(val.isEmpty()){
            password.setError("Field can not be empty");
            return false;
        }
        else if(!val.matches(checkPassword)){
            password.setError("Password should contain atleast 8 characters");
            return false;
        }
        else{
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }*/


}