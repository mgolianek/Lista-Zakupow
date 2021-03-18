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
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    public byte[] image;
    public String categoryId;

}
