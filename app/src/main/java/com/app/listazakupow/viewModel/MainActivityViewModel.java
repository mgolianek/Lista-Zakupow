package com.app.listazakupow.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.models.relations.OrderWithProduct;
import com.app.listazakupow.repositories.AppRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    AppRepository repository = new AppRepository();

    public void removeAllOrdersFromList() {
        repository.removeAllOrders();
    }

    public LiveData<List<OrderWithProduct>> getOrderData() {
        return repository.orderList();
    }


    public void removeOrder(OrderEntity orderToRemove) {
        repository.removeOrder(orderToRemove);
    }
}
