package com.app.listazakupow.database;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.util.App;

@Database(entities = {
        CategoryEntity.class,
        OrderEntity.class,
        ProductEntity.class},
        version = 1,
        exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase instance;

    public static AppDatabase getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (AppDatabase.class) {
            if (instance == null) {
                instance = Room.databaseBuilder(App.getContext(),
                        AppDatabase.class, "app_db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() //little cheat, to be able to call database calls from main thread, shouldn't affect app speed in our case
                        .build();
            }
            return instance;
        }
    }
}