package com.example.roompracticefour.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.roompracticefour.entities.User;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM users")
    List<User> getAllUsers();

    @Insert
    void insertUser(User...users);

    @Delete
    void deleteUser(User...users);
}
