package com.app.listazakupow.models.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.app.listazakupow.models.enums.QuantityType;
import com.app.listazakupow.ui.MainActivity;

@Entity(tableName = "order_table")
public class OrderEntity{
    @PrimaryKey(autoGenerate = true)
    public int listId;

    public String productId;
    public Boolean checked;
    public double quantity;
    public QuantityType quantityType;


    public OrderEntity(String productId, Boolean checked, double quantity, QuantityType quantityType) {
        this.productId = productId;
        this.checked = checked;
        this.quantity = quantity;
        this.quantityType = quantityType;
    }
}