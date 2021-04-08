package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.repositories.AppRepository;

public class AddProductViewModel extends ViewModel {
    AppRepository repository = new AppRepository();
    private final String categoryName;

    public AddProductViewModel(String categoryName) {
        this.categoryName = categoryName;
    }

    public void addProduct(String productName) {
        ProductEntity productEntity = new ProductEntity(productName, categoryName);
        repository.addProduct(productEntity);
    }
}
