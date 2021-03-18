package com.app.listazakupow.models.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "order_table")
public class OrderEntity{
    @PrimaryKey
    @NonNull
    public String name;
    public Boolean finished;

}

