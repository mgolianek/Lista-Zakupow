package com.app.listazakupow.models.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "category_table")
public class CategoryEntity {
    @PrimaryKey
    @NonNull
    public String name;

    public int resourceImageId;

    public CategoryEntity(@NonNull String name, int resourceImageId) {
        this.name = name;
        this.resourceImageId = resourceImageId;
    }
}
