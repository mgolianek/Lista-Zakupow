package com.app.listazakupow.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.repositories.AppRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    AppRepository repository = new AppRepository();

    public void removeAllProductsFromList() {
        //delete all orders!
    }

    public LiveData<List<OrderEntity>> getOrderData() {
        return repository.orderList();
    }
}
