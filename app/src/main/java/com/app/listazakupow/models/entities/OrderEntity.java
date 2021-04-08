package com.app.listazakupow.models.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.app.listazakupow.models.enums.QuantityType;

@Entity(tableName = "order_table")
public class OrderEntity{
    @PrimaryKey(autoGenerate = true)
    public int listId;

    public String productId;
    public Boolean checked;
    public double quantity;
    public QuantityType quantityType;
}

/*
list_id (ktora lista zakupowa) - na koncu, najpeirw jedna!
productId
quantity
typ kg/ml/g/szt
checked
 */