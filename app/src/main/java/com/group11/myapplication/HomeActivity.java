package com.group11.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.group11.myapplication.Database.DBHandler;

public class HomeActivity extends AppCompatActivity {

    EditText userName,password;
    Button btnLogin,btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userName = findViewById(R.id.etUserNameH);
        password = findViewById(R.id.etPasswordH);
        btnLogin = findViewById(R.id.btnLoginH);
        btnRegister = findViewById(R.id.btnRegisterH);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ProfileManagement.class);
                startActivity(i);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHandler dbHandler = new DBHandler(getApplicationContext());
                if(dbHandler.loginUser(userName.getText().toString(),password.getText().toString())){
                    Toast.makeText(HomeActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(getApplicationContext(),UserList.class);
                    startActivity(i);
                }
                else{
                    Toast.makeText(HomeActivity.this, "Invalid User details", Toast.LENGTH_SHORT).show();
                    userName.setText(null);
                    password.setText(null);
                }
            }
        });
    }
}