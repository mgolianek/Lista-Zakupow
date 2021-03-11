package com.app.listazakupow.models.entities;

import androidx.annotation.NonNull;
import androidx.room.Entity;

import com.app.listazakupow.models.entities.base.BusinessEntity;

@Entity(tableName = "order")
public class OrderEntity extends BusinessEntity {
    private String name;
    private Boolean finished;

    public OrderEntity(@NonNull String id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Boolean isFinished() {
        return finished;
    }
}

