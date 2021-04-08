package com.app.listazakupow.models.relations;

import androidx.room.Embedded;
import androidx.room.Relation;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

public class OrderWithProduct {
    @Embedded
    private OrderEntity order;
    @Relation(
            parentColumn = "productId",
            entityColumn = "name",
            entity = ProductEntity.class
    )
    private ProductEntity product;

    public OrderEntity getOrder() {
        return order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
