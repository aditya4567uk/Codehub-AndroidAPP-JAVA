package com.example.codehub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class Login extends AppCompatActivity {

    //vars

    //TextInputLayout username = findViewById(R.id.enterusername);
    //TextInputLayout password = findViewById(R.id.enterpassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_login);
    }

    public void createaccout(View view){
        Intent login2signup = new Intent(getApplicationContext(),SignUp.class);
        startActivity(login2signup);
    }

    public void lettheuserloggedin(View view){

        TextInputLayout username = findViewById(R.id.enterusername);
        String _user = username.getEditText().getText().toString().trim();
        Intent login2dashboard = new Intent(getApplicationContext(),Dashboard.class);
        login2dashboard.putExtra("name",_user);
        validateFields();
        Toast.makeText(getApplicationContext(),"Button is working",Toast.LENGTH_SHORT).show();

    }

    private boolean validateFields(){

        TextInputLayout username = findViewById(R.id.enterusername);
        TextInputLayout password = findViewById(R.id.enterpassword);

        boolean ok = true;
        String _user = username.getEditText().getText().toString().trim();
        String _password = password.getEditText().getText().toString().trim();

        if (_password.isEmpty()){
            Toast.makeText(getApplicationContext(),"Password cannot be empty",Toast.LENGTH_SHORT).show();
            ok = false;
        }
        if(_user.isEmpty()){
            Toast.makeText(getApplicationContext(),"Username cannot be empty",Toast.LENGTH_SHORT).show();
            ok = false;
        }
        else{
            Query checkUser = FirebaseDatabase.getInstance().getReference("Users").orderByChild("username").equalTo(String.valueOf(_user));

            checkUser.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (snapshot.exists()){
                        username.setError(null);
                        username.setErrorEnabled(false);

                        String systemPassword = snapshot.child(String.valueOf(_user)).child("password").getValue(String.class);
                        Toast.makeText(getApplicationContext(),"username valid",Toast.LENGTH_SHORT).show();

                        if(systemPassword.equals(_password)){
                            password.setError(null);
                            password.setErrorEnabled(false);
                            Intent login2dashboard = new Intent(getApplicationContext(),Dashboard.class);
                            startActivity(login2dashboard);
                            Toast.makeText(getApplicationContext(),"Password valid",Toast.LENGTH_SHORT).show();
                            Toast.makeText(getApplicationContext(),"LOGGED IN SUCCESSFULLY",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"Password invalid",Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(),"User invalid",Toast.LENGTH_SHORT).show();
                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                    Toast.makeText(getApplicationContext(),"Database problem",Toast.LENGTH_SHORT).show();

                }
            });
        }
        return ok=true;
    }
}