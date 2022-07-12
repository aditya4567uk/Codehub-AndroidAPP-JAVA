package com.example.codehub;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
    }

    public void calllogin(View view){
        Intent i = new Intent(getApplicationContext(),Login.class);
        //Pair[] pairs = new Pair[1];
        //pairs[0] = new Pair<View,String>(findViewById(R.id.login_btn),"transition_login");
        //ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
        startActivity(i);
    }

    public void callsignup(View view){
        Intent i1 = new Intent(getApplicationContext(),SignUp.class);
        startActivity(i1);
    }
}