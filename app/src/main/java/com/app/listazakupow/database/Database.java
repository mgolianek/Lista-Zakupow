package com.app.listazakupow.database;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import com.app.listazakupow.util.App;

@androidx.room.Database(entities = {},version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {
    private static Database instance;

    public static Database getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (Database.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(App.getContext(),
                        Database.class, "app_db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() //little cheat, to be able to call database calls from main thread, shouldn't affect app speed in our case
                        .build();
            }
            return instance;
        }
    }
}