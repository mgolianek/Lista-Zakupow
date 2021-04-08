package com.app.listazakupow.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.app.listazakupow.models.entities.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ProductEntity categoryEntity);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ProductEntity... products);

    @Delete
    void delete(ProductEntity product);

    @Update
    void update(ProductEntity... products);

    @Query("SELECT * FROM product_table")
    List<ProductEntity> getAll();

    @Query("SELECT * FROM product_table WHERE name = :name")
    ProductEntity get(String name);

    @Query("SELECT * FROM product_table WHERE categoryId = :categoryName")
    LiveData<List<ProductEntity>> getProductsForCategory(String categoryName);
}
