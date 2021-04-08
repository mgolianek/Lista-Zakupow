package com.app.listazakupow.models.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.relations.OrderWithProduct;

import java.util.List;

@Dao
public interface OrderDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(OrderEntity order);

    @Query("SELECT * FROM order_table")
    LiveData<List<OrderEntity>> getOrderLiveData();

    @Query("SELECT * FROM order_table")
    LiveData<List<OrderWithProduct>> getOrderWithProductLiveData();

    @Query("DELETE FROM order_table")
    void removeAll();

    @Delete
    void remove(OrderEntity orderToRemove);
}
