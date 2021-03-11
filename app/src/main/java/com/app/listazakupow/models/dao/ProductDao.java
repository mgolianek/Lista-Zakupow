package com.app.listazakupow.models.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

import java.util.List;

public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(ProductEntity... products);

    @Delete
    void delete(ProductEntity product);

    @Update
    void update(ProductEntity... products);

    @Query("SELECT * FROM product")
    List<ProductEntity> getAll();

    @Query("SELECT * FROM product WHERE id = :id")
    ProductEntity get(String id);
}
