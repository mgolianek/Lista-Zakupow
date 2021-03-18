package com.app.listazakupow.models.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;

import java.util.List;

public interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CategoryEntity... categories);

    @Delete
    void delete(CategoryEntity category);

    @Update
    void update(CategoryEntity... category);

    @Query("SELECT * FROM category_table")
    List<CategoryEntity> getAll();

    @Query("SELECT * FROM category_table WHERE name = :name")
    CategoryEntity get(String name);
}
