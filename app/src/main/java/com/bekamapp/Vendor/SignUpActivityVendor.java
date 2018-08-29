package com.bekamapp.Vendor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.bekamapp.LoginActivity;
import com.bekamapp.R;
import com.bekamapp.User.SignUpActivityUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivityVendor extends AppCompatActivity {

    FirebaseAuth auth;
    Spinner spinner;
    Button register;
    EditText name, email, password, phone, location, workingHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_sign_up_activity_vendor);

        spinner = (Spinner) findViewById(R.id.reg_category_spinner);

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> ArrAdapter = ArrayAdapter.createFromResource(this,
        R.array.category_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears
        ArrAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply the adapter to the spinner
        spinner.setAdapter(ArrAdapter);

        name = findViewById(R.id.et_reg_name);
        email = findViewById(R.id.et_reg_email);
        password = findViewById(R.id.et_reg_pw);
        phone = findViewById(R.id.et_reg_phone);
        location = findViewById(R.id.et_reg_loc);
        workingHours = findViewById(R.id.et_reg_WH);

        register = findViewById(R.id.btn_vendor_signUp);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String vendor_name = name.getText().toString().trim();
                String vendor_email = email.getText().toString().trim();
                String vendor_password = password.getText().toString().trim();
                String vendor_phone = phone.getText().toString().trim();
                String vendor_location = location.getText().toString().trim();
                String vendor_workingHours = workingHours.getText().toString().trim();

                auth.createUserWithEmailAndPassword(vendor_email, vendor_password).addOnCompleteListener(SignUpActivityVendor.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            startActivity(new Intent(getBaseContext(), LoginActivity.class));
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
