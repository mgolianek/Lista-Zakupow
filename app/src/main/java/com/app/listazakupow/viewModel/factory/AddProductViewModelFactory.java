package com.app.listazakupow.viewModel.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.viewModel.AddProductViewModel;

public class AddProductViewModelFactory implements ViewModelProvider.Factory {
    private final String categoryName;
    public AddProductViewModelFactory(String categoryName) {
        this.categoryName = categoryName;    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new AddProductViewModel(categoryName);
    }
}