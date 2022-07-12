package com.example.codehub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent login2dashboard = getIntent();
        String _user = login2dashboard.getStringExtra("name");
        String email = login2dashboard.getStringExtra("emailS");
        String number = login2dashboard.getStringExtra("numberS");
        String gender = login2dashboard.getStringExtra("genderS");

    }

    public void getinfo(View view){
        Intent login2dashboard = getIntent();
        String _user = login2dashboard.getStringExtra("name");
        Toast.makeText(getApplicationContext(),"Welcome to account "+_user+ email+ number +  gender +,Toast.LENGTH_LONG).show();
    }

    public void gotohomepage(View view){
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
    }


}