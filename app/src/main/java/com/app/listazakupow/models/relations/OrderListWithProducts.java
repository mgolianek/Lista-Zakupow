package com.app.listazakupow.models.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

import java.util.List;

//TODO: create proper relationships
public class OrderListWithProducts {
    @Embedded private OrderEntity order;
    @Relation(
            parentColumn = "id",
            entityColumn = "id",
            entity = ProductEntity.class
    )
    private List<ProductEntity> products;

    public OrderEntity getOrder() {
        return order;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }
}