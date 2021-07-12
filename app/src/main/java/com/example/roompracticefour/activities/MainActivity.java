package com.example.roompracticefour.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.roompracticefour.R;
import com.example.roompracticefour.database.UserDatabase;
import com.example.roompracticefour.entities.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private UserListAdapter userListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addUsertoDatabase = findViewById(R.id.userToDatabase);
        addUsertoDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(
                                MainActivity.this,
                                CreateNewUserActivity.class
                        ), 100
                );
            }
        });








    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.userRecyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
    }


    private void loadUserList() {
        UserDatabase db = UserDatabase.getUserInstance(this.getApplicationContext());
        List<User> userList = db.userDao().getAllUsers();

    }



}