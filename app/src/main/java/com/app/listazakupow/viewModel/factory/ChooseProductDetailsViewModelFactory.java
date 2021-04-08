package com.app.listazakupow.viewModel.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.viewModel.CategoryDetailsViewModel;
import com.app.listazakupow.viewModel.ChooseProductDetailsViewModel;

public class ChooseProductDetailsViewModelFactory implements ViewModelProvider.Factory {
    private final String productName;
    public ChooseProductDetailsViewModelFactory(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        return (T) new ChooseProductDetailsViewModel(productName);
    }
}