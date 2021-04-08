package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.R;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.models.relations.OrderWithProduct;

public class ShoppingItemViewModel extends ViewModel {
    private final String name;
    private final String quantityString;

    public ShoppingItemViewModel(OrderWithProduct entity) {
        name = entity.getProduct().name;
        quantityString = "" + entity.getOrder().quantity + " " + entity.getOrder().quantityType.toString();
    }

    public String getName() {
        return name;
    }

    public String getQuantityString() {
        return quantityString;
    }
}
