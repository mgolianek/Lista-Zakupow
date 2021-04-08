package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.R;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

public class ShoppingItemViewModel extends ViewModel {
    private  String name;
    private  int resourceImageId;

    public ShoppingItemViewModel(OrderEntity entity) {
        name="test";
        resourceImageId = R.drawable.ic_coffe;
    }

    public String getName() {
        return name;
    }

    public int getResourceImageId() {
        return resourceImageId;
    }
}
