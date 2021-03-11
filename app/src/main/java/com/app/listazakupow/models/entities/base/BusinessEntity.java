package com.app.listazakupow.models.entities.base;

import androidx.annotation.NonNull;
import androidx.room.PrimaryKey;

public abstract class BusinessEntity {
    @PrimaryKey
    @NonNull
    private String id;

    public BusinessEntity(@NonNull String id) {
        this.id = id;
    }

    @NonNull
    public String getId() {
        return id;
    }
}
