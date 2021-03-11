package com.app.listazakupow.models.entities;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;

import com.app.listazakupow.models.entities.base.BusinessEntity;

@Entity(tableName = "product")
public class ProductEntity extends BusinessEntity {
    private String name;
    @ColumnInfo(typeAffinity = ColumnInfo.BLOB)
    private byte[] image; //TODO: some image converter? image from resources?

    public ProductEntity(@NonNull String id, String name, byte[] image) {
        super(id);
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public byte[] getImage() {
        return image;
    }
}
