package com.example.codehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Calendar;

public class Signup2ndClass extends AppCompatActivity {

    //ImageView backbtn;
    //Button next, login;
    TextView titleText, slideText;
    //RadioButton selectGender;
    //RadioGroup radioGroup;
    //DatePicker datePicker;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2nd_class);

        //hooks
        //ImageView backbtn = findViewById(R.id.signup_back_button);
        //Button next = findViewById(R.id.signup_next_btn);
        //Button login = findViewById(R.id.signup_login_button);
        //slideText = findViewById(R.id.sign_slide_text);
        //RadioGroup radioGroup = findViewById(R.id.radiogroup);
        //DatePicker datePicker = findViewById(R.id.age_picker);

        //Intent intent = getIntent();
        //String nameS = intent.getStringExtra("name");
        //String userS = intent.getStringExtra("user");
        //String emailS = intent.getStringExtra("email");
        //String passwordS = intent.getStringExtra("password");

        //Toast.makeText(this,"Testing"+nameS, Toast.LENGTH_SHORT).show();


    }




    public void callnextsignup2ndscreen(View view){
        boolean ok = true;
        ImageView backbtn = findViewById(R.id.signup_back_button);
        Button next = findViewById(R.id.signup_next_btn);
        Button login = findViewById(R.id.signup_login_button);
        //slideText = findViewById(R.id.sign_slide_text);
        RadioGroup radioGroup = findViewById(R.id.radiogroup);
        DatePicker datePicker = findViewById(R.id.age_picker);

        Intent second_to_third = new Intent(getApplicationContext(),SignUp3rdClass.class);
        Intent intent = getIntent();
        String nameS = intent.getStringExtra("name");
        String userS = intent.getStringExtra("user");
        String emailS = intent.getStringExtra("email");
        String passwordS = intent.getStringExtra("password");
        Toast.makeText(this,"user"+userS, Toast.LENGTH_SHORT).show();
        //Intent secondc_to_otp = new Intent(getApplicationContext(),VerifyOTP.class);

        if(radioGroup.getCheckedRadioButtonId()== -1){
            Toast.makeText(this,"Gender not selected", Toast.LENGTH_SHORT).show();
            ok =false;
        }

        int currentyear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isagevalid = currentyear - userAge;

        if(isagevalid<14){
            Toast.makeText(this,"Age is too short to register", Toast.LENGTH_SHORT).show();
            ok = false;
        }

        RadioButton selectGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String _gender = selectGender.getText().toString();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        String date = day+"/"+month+"/"+year;

        second_to_third.putExtra("dob",date);
        second_to_third.putExtra("gender",_gender);
        second_to_third.putExtra("name",nameS);
        second_to_third.putExtra("user",userS);
        second_to_third.putExtra("email",emailS);
        second_to_third.putExtra("password",passwordS);

        if (ok == true){
            startActivity(second_to_third);
        }else{
            Toast.makeText(this,"You cannot register!", Toast.LENGTH_SHORT).show();
        }

        /*Intent intent = getIntent();

        String namesS = intent.getStringExtra("name");
        String userS = intent.getStringExtra("userName");
        String emailS = intent.getStringExtra("email");
        String passwordS = intent.getStringExtra("password");

        Toast.makeText(getApplicationContext(), "This is"+namesS,
                Toast.LENGTH_LONG).show();

        System.out.println(namesS);
        System.out.println(userS);
        System.out.println(emailS);
        System.out.println(passwordS);*/
        //startActivity(i1);
    }

    public void callloginsignup2ndscreen(View view){
        Intent i2 = new Intent(getApplicationContext(),Login.class);
        startActivity(i2);
    }
}