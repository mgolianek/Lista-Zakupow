package com.app.listazakupow.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.repositories.AppRepository;

import java.util.List;

public class CategoryDetailsViewModel extends ViewModel {
    private final String categoryName;
    private final AppRepository repository = new AppRepository();

    public CategoryDetailsViewModel(String categoryName) {
        this.categoryName = categoryName;
    }

    public LiveData<List<ProductEntity>> productList() {
        return repository.productsForCategory(categoryName);
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void removeProduct(ProductEntity productToRemove) {
        repository.removeProduct(productToRemove);
    }
}
