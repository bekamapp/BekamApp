package com.bekamapp.User;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.bekamapp.LoginActivity;
import com.bekamapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivityUser extends AppCompatActivity {

    FirebaseAuth auth;
    Button signUp;
    EditText email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign_up_activity_user);

        auth = FirebaseAuth.getInstance();

        email = (EditText)findViewById(R.id.et_user_email);
        password = (EditText)findViewById(R.id.et_user_password);

        signUp = (Button) findViewById(R.id.btn_user_signUp);

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user_email = email.getText().toString().trim();
                String user_password = password.getText().toString().trim();

                auth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(SignUpActivityUser.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(SignUpActivityUser.this, LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getBaseContext(), "Authentication Fail.", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
