package com.app.listazakupow.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.listazakupow.models.entities.ProductEntity;

import java.util.List;

@Dao
public interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(ProductEntity categoryEntity);

    @Query("SELECT * FROM product_table WHERE name = :name")
    ProductEntity get(String name);

    @Query("SELECT * FROM product_table WHERE categoryId = :categoryName")
    LiveData<List<ProductEntity>> getProductsForCategoryLiveData(String categoryName);

    @Delete
    void remove(ProductEntity orderToRemove);
}
