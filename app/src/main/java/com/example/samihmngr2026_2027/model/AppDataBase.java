package com.example.samihmngr2026_2027.model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.samihmngr2026_2027.model.myTaskTable.MyTask;
import com.example.samihmngr2026_2027.model.myTaskTable.MyTaskQuery;
import com.example.samihmngr2026_2027.model.myusersTable.MyUser;
import com.example.samihmngr2026_2027.model.myusersTable.MyUserQuery;

@Database(entities = {MyUser.class, MyTask.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {
    private static AppDataBase db;
    public abstract MyUserQuery myUserQuery();
    public abstract MyTaskQuery myTaskQuery();

    public static AppDataBase getDb(Context context) {
        if (db == null) {
            db = Room.databaseBuilder(context, AppDataBase.class, "samih_database").allowMainThreadQueries().build();
        }
        return db;
    }
}
