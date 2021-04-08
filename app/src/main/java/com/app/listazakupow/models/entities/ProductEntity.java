package com.app.listazakupow.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "product_table")
public class ProductEntity {
    @PrimaryKey
    @NonNull
    public String name;

    public String categoryId;

    public ProductEntity(@NonNull String name, String categoryId) {
        this.name = name;
        this.categoryId = categoryId;
    }
}
