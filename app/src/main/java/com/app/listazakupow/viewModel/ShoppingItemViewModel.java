package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.R;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

public class ShoppingItemViewModel extends ViewModel {
    private String name;
    private String quantityString;

    public ShoppingItemViewModel(OrderEntity entity) {
        name = "temp name";
        quantityString = "" + entity.quantity + " " + entity.quantityType.toString();
    }

    public String getName() {
        return name;
    }

    public String getQuantityString() {
        return quantityString;
    }
}
