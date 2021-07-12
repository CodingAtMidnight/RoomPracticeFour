package com.example.roompracticefour.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.roompracticefour.R;
import com.example.roompracticefour.database.UserDatabase;
import com.example.roompracticefour.entities.User;

public class CreateNewUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_user);

        EditText userFirstName = findViewById(R.id.firstName);
        EditText userLastName = findViewById(R.id.lastName);
        Button addUser = findViewById(R.id.userToDatabase);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewUser(userFirstName.getText().toString(), userLastName.getText().toString());
            }
        });
    }

    private void saveNewUser(String firstName, String lastName) {
        UserDatabase db = UserDatabase.getUserInstance(this.getApplicationContext());

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        db.userDao().insertUser(user);

        finish();
    }
}