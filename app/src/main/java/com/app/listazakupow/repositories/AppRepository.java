package com.app.listazakupow.repositories;

import android.util.Log;

import androidx.lifecycle.LiveData;

import com.app.listazakupow.R;
import com.app.listazakupow.database.AppDatabase;
import com.app.listazakupow.models.entities.CategoryEntity;

import java.util.List;

public class AppRepository {
    private final AppDatabase db = AppDatabase.getInstance();


    public void addCategory(String categoryName) {
        CategoryEntity categoryEntity = new CategoryEntity(categoryName, R.drawable.ic_bread); //TODO: dynamically?
        long test = db.productDao().insert(categoryEntity);

        Log.d("TAG", "addCategory: ");
    }

    public LiveData<List<CategoryEntity>> categoryList() {
        return db.categoryDao().getAll();
    }
}
