package com.app.listazakupow.repositories;

import androidx.lifecycle.LiveData;

import com.app.listazakupow.database.AppDatabase;
import com.app.listazakupow.models.dao.CategoryDao;
import com.app.listazakupow.models.dao.OrderDao;
import com.app.listazakupow.models.dao.ProductDao;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;

import java.util.List;

public class AppRepository {
    private final CategoryDao categoryDao;
    private final OrderDao orderDao;
    private final ProductDao productDao;

    public AppRepository() {
        AppDatabase db = AppDatabase.getInstance();
        categoryDao = db.categoryDao();
        orderDao = db.orderDao();
        productDao = db.productDao();
    }

    public LiveData<List<CategoryEntity>> categoryList() {
        return categoryDao.getAll();
    }

    public LiveData<List<ProductEntity>> productsForCategory(String categoryName) {
        return productDao.getProductsForCategory(categoryName);
    }

    public LiveData<List<OrderEntity>> orderList() {
        return orderDao.getOrderLiveData();
    }

    public void addProduct(ProductEntity productEntity) {
        productDao.insert(productEntity);
    }

    public void addProductToOrderList(OrderEntity orderEntity) {
        orderDao.insert(orderEntity);
    }
}
