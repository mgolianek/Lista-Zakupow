package com.app.listazakupow.models.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_table")
public class CategoryEntity {
    @PrimaryKey
    @NonNull
    public String name;
}
