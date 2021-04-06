package com.app.listazakupow.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(CategoryEntity category);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(CategoryEntity... categories);

    @Delete
    void delete(CategoryEntity category);

    @Update
    void update(CategoryEntity... category);

    @Query("SELECT * FROM category_table")
    LiveData<List<CategoryEntity>> getAll();

    @Query("SELECT * FROM category_table WHERE name = :name")
    CategoryEntity get(String name);
}
