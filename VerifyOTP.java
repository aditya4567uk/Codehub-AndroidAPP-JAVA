package com.example.codehub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class VerifyOTP extends AppCompatActivity {

    String codebysystem;
    //PinView pinFromUser = findViewById(R.id.pin_view);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);


    }

    public void call_verfy_btn(View view) {


        Intent third_to_fourth = getIntent();
        String nameS = third_to_fourth.getStringExtra("name");
        String userS = third_to_fourth.getStringExtra("user");
        String emailS = third_to_fourth.getStringExtra("email");
        String passwordS = third_to_fourth.getStringExtra("password");
        String _phoneNo = third_to_fourth.getStringExtra("phonenumber");
        String date = third_to_fourth.getStringExtra("dob");
        String _gender = third_to_fourth.getStringExtra("gender");
        Toast.makeText(getApplicationContext(), "This is testing msg" + nameS + _phoneNo,
                Toast.LENGTH_LONG).show();
        PinView pinFromUser = findViewById(R.id.pin_view);


        String code = pinFromUser.getText().toString();
        if (!code.isEmpty()){
            verifyCode(code);

        }
        sendVerificationCodeToUser(_phoneNo);

    }

    public void callverifyloginbtn(View view){
        Intent verify2login = new Intent(getApplicationContext(),Login.class);
        startActivity(verify2login);
    }

    private void sendVerificationCodeToUser(String phoneNo) {

        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance()) //mAuth is defined on top
                .setPhoneNumber(phoneNo)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    /*private void sendVerificationCodetoUser(String phoneNo){
        PhoneAuthOptions options = PhoneAuthOptions.newBuilder(FirebaseAuth.getInstance()) //mAuth is defined on top
                .setPhoneNumber(phoneNo)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // Activity (for callback binding)
                .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }*/

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks =
            new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                @Override
                public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                    super.onCodeSent(s, forceResendingToken);
                    codebysystem = s;
                }

                @Override
                public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                    PinView pinFromUser = findViewById(R.id.pin_view);
                    String code = phoneAuthCredential.getSmsCode();
                    Toast.makeText(getApplicationContext(),"SUCCESS - PROCEED TO LOGIN",Toast.LENGTH_SHORT).show();
                    if (code != null) {
                        pinFromUser.setText(code);
                        verifyCode(code);
                    }
                }

                @Override
                public void onVerificationFailed(@NonNull FirebaseException e) {
                    //Toast.makeText(VerifyOTP.this, "SUCCESS - PROCEED TO LOGIN PAGE", Toast.LENGTH_SHORT).show();
                    Toast.makeText(getApplicationContext(),"SUCCESS - PROCEED TO LOGIN",Toast.LENGTH_SHORT).show();
                    System.out.println("ok");
                    storeNewUserData();
                }
            };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codebysystem, code);
        signInWithPhoneAuthCredential(credential);
    };

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            //Toast.makeText(getApplicationContext(),"verfication complete",Toast.LENGTH_SHORT).show();
                            storeNewUserData();
                        }
                        else{
                            Toast.makeText(VerifyOTP.this, "Verification Not Completed! Try again.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void storeNewUserData() {

        Intent third_to_fourth = getIntent();
        String nameS = third_to_fourth.getStringExtra("name");
        String userS = third_to_fourth.getStringExtra("user");
        String emailS = third_to_fourth.getStringExtra("email");
        String passwordS = third_to_fourth.getStringExtra("password");
        String _phoneNo = third_to_fourth.getStringExtra("phonenumber");
        String _gender = third_to_fourth.getStringExtra("gender");
        String date = third_to_fourth.getStringExtra("dob");
        FirebaseDatabase rootNode = FirebaseDatabase.getInstance();
        DatabaseReference reference = rootNode.getReference("Users");

        reference.setValue("First record");
        UserHelperClass addNewUser = new UserHelperClass(nameS,userS,emailS,_phoneNo,passwordS,date,_gender);

        reference.child(userS).setValue(addNewUser);
    }

}
