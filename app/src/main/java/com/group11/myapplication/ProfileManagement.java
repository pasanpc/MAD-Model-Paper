package com.group11.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.group11.myapplication.Database.DBHandler;

public class ProfileManagement extends AppCompatActivity {

    EditText userName,dob,password;
    Button btnAdd,btnUpdateProfile;
    RadioButton male,female;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_management);

        userName = findViewById(R.id.etUserNamePM);
        dob = findViewById(R.id.etDobPM);
        password = findViewById(R.id.etPasswordPM);
        btnAdd = findViewById(R.id.btnAddPM);
        btnUpdateProfile = findViewById(R.id.btnAddPM);
        male = findViewById(R.id.rbMalePM);
        female = findViewById(R.id.rbFemalePM);

        btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(male.isChecked()){
                    gender = "Male";
                }
                else{
                    gender = "Female";
                }

                DBHandler dbHandler = new DBHandler(getApplicationContext());
                long newID = dbHandler.addInfo(userName.getText().toString(),dob.getText().toString(),password.getText().toString(),gender);
                Toast.makeText(ProfileManagement.this, "New User Added User ID : 7"+newID, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(getApplicationContext(),EditProfile.class);
                startActivity(i);

                userName.setText(null);
                dob.setText(null);
                password.setText(null);
            }
        });

    }
}