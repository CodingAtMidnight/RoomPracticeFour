package com.example.roompracticefour.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.roompracticefour.Dao.UserDao;
import com.example.roompracticefour.entities.User;

@Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class UserDatabase extends RoomDatabase {
    public abstract UserDao userDao();

    private static UserDatabase INSTANCE;

    public static UserDatabase getUserInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(
                    context.getApplicationContext(),
                    UserDatabase.class,
                    "user_db").allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }

}
