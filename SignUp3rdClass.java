package com.example.codehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

public class SignUp3rdClass extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up3rd_class);
    }

    public void callloginsignup3rdscreen(View view){
        Intent i = new Intent(getApplicationContext(),Login.class);
        startActivity(i);
    }

    public void callnext3rdsignup(View view){
        Intent third_to_fourth = new Intent(getApplicationContext(),VerifyOTP.class);
        Intent second_to_third = getIntent();

        TextInputLayout phonenumber = findViewById(R.id.signup_phonenumber);
        CountryCodePicker countrycodepicker = findViewById(R.id.signup_codepicker);

        String _getUserEnteredPhoneNumber = phonenumber.getEditText().getText().toString().trim();
        //String _phoneNo = "+"+countrycodepicker.getFullNumber()+_getUserEnteredPhoneNumber;
        String _phoneNo = "+91 629-909-8884";
        //String namesS = intent.getStringExtra("name");
        //String userS = intent.getStringExtra("userName");
        //String emailS = intent.getStringExtra("email");
        //String passwordS = intent.getStringExtra("password");
        String date = second_to_third.getStringExtra("dob");
        String _gender = second_to_third.getStringExtra("gender");
        String nameS = second_to_third.getStringExtra("name");
        String emailS = second_to_third.getStringExtra("email");
        String userS = second_to_third.getStringExtra("user");
        String passwordS = second_to_third.getStringExtra("password");

        third_to_fourth.putExtra("name",nameS);
        third_to_fourth.putExtra("user",userS);
        third_to_fourth.putExtra("email",emailS);
        third_to_fourth.putExtra("password",passwordS);
        third_to_fourth.putExtra("gender",_gender);
        third_to_fourth.putExtra("dob",date);
        third_to_fourth.putExtra("phonenumber",_phoneNo);


        Toast.makeText(getApplicationContext(), "This is"+date+_gender+nameS+passwordS,
                Toast.LENGTH_LONG).show();


        //TextInputLayout phonenumber = findViewById(R.id.signup_phonenumber);
        //CountryCodePicker countrycodepicker = findViewById(R.id.signup_codepicker);
        startActivity(third_to_fourth);
    }
}