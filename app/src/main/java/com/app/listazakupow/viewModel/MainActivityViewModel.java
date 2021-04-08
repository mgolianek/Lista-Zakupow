package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.repositories.AppRepository;

public class MainActivityViewModel extends ViewModel {
    AppRepository repository = new AppRepository();

    public void removeAllProductsFromList() {
        //delete all orders!
    }
}
