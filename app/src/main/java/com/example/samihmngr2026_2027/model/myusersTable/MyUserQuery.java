package com.example.samihmngr2026_2027.model.myusersTable;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyUserQuery {
    @Query("SELECT * FROM MyUser")
    List<MyUser> getAllUsers();

    @Query("SELECT * FROM MyUser WHERE email = :email AND password = :password LIMIT 1")
    MyUser login(String email, String password);

    @Query("SELECT * FROM MyUser WHERE email = :email LIMIT 1")
    MyUser getUserByEmail(String email);

    @Insert
    void insert(MyUser... users);

    @Update
    void update(MyUser... users);

    @Delete
    void delete(MyUser... users);
}
