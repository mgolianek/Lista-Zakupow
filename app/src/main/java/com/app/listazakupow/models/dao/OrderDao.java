package com.app.listazakupow.models.dao;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.app.listazakupow.models.entities.OrderEntity;

import java.util.List;

public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(OrderEntity... orders);

    @Delete
    void delete(OrderEntity order);

    @Update
    void update(OrderEntity... orders);

    @Query("SELECT * FROM product")
    List<OrderEntity> getAll();

    @Query("SELECT * FROM product WHERE id = :id")
    OrderEntity get(String id);
}
