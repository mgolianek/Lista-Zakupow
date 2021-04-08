package com.app.listazakupow.viewModel;

import com.app.listazakupow.models.other.BaseViewModel;

public class AddProductViewModel extends BaseViewModel {
    private final String categoryName;

    public AddProductViewModel(String categoryName) {
        this.categoryName = categoryName;
    }
}
