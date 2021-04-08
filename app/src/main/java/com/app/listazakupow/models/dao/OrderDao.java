package com.app.listazakupow.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.app.listazakupow.models.entities.OrderEntity;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OrderEntity order);

    @Delete
    void delete(OrderEntity order);

    @Update
    void update(OrderEntity... orders);

    @Query("SELECT * FROM order_table")
    List<OrderEntity> getAll();

    @Query("SELECT * FROM order_table")
    LiveData<List<OrderEntity>> getOrderLiveData();

//    @Query("SELECT * FROM order_table WHERE name = :name")
//    OrderEntity get(String name);
}
