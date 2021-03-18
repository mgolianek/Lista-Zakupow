package com.app.listazakupow.repositories;

import androidx.lifecycle.LiveData;

import com.app.listazakupow.database.AppDatabase;
import com.app.listazakupow.models.entities.CategoryEntity;

import java.util.List;

public class AppRepository {
    private final AppDatabase db = AppDatabase.getInstance();


    public void addCategory(String categoryName) {
        CategoryEntity categoryEntity = new CategoryEntity(categoryName);
        db.productDao().insert(categoryEntity);
    }

    public LiveData<List<CategoryEntity>> categoryList() {
        return db.categoryDao().getAll();
    }
}
