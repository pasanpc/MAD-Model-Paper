package com.group11.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.group11.myapplication.Database.DBHandler;

import java.util.ArrayList;

public class UserList extends AppCompatActivity {

    ListView userList;
    ArrayList dataList;
    ArrayAdapter adapter;

    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userList = findViewById(R.id.users_list);

        db = new DBHandler(getApplicationContext());
        dataList = db.readAllInfo();

        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,dataList);

        userList.setAdapter(adapter);

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = userList.getItemAtPosition(i).toString();
                Toast.makeText(UserList.this, "User : "+text, Toast.LENGTH_SHORT).show();
            }
        });

    }
}