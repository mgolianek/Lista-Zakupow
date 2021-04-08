package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.enums.QuantityType;
import com.app.listazakupow.repositories.AppRepository;

public class ChooseProductDetailsViewModel extends ViewModel {
    AppRepository repository = new AppRepository();
    private final String productName; //id
    private final String displayedName;

    public ChooseProductDetailsViewModel(String productName) {
        this.productName = productName;
        displayedName = repository.product(productName).name;
    }


    public void addProductToOrder(String quantity, int selectedQuantityTypeId) {
        double quantityDouble;
        try {
            quantityDouble = Double.parseDouble(quantity);
        } catch (Exception ignored) {
            return;
        }

        QuantityType quantityType = QuantityType.values()[selectedQuantityTypeId];

        OrderEntity orderEntity = new OrderEntity(productName, false, quantityDouble, quantityType);
        repository.addProductToOrderList(orderEntity);
    }

    public String getDisplayedName() {
        return displayedName;
    }
}

