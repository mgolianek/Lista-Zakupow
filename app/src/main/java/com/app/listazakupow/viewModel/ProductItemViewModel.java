package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.R;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

public class ProductItemViewModel extends ViewModel {
    private final String name;

    public ProductItemViewModel(ProductEntity entity) {
        this.name = entity.name;
    }

    public String getName() {
        return name;
    }
}
