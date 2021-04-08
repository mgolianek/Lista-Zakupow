package com.app.listazakupow.repositories;

import androidx.lifecycle.LiveData;

import com.app.listazakupow.database.AppDatabase;
import com.app.listazakupow.models.dao.CategoryDao;
import com.app.listazakupow.models.dao.OrderDao;
import com.app.listazakupow.models.dao.ProductDao;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.models.relations.OrderWithProduct;

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
        return categoryDao.getAllCategoryLiveData();
    }

    public LiveData<List<ProductEntity>> productsForCategory(String categoryName) {
        return productDao.getProductsForCategoryLiveData(categoryName);
    }

    public LiveData<List<OrderWithProduct>> orderList() {
        return orderDao.getOrderWithProductLiveData();
    }

    public ProductEntity product(String productName) {
        return productDao.get(productName);
    }

    public void addProduct(ProductEntity productEntity) {
        productDao.insert(productEntity);
    }

    public void addProductToOrderList(OrderEntity orderEntity) {
        orderDao.insert(orderEntity);
    }

    public void removeAllOrders() {
        orderDao.removeAll();
    }

    public void removeOrder(OrderEntity orderToRemove) {
        orderDao.remove(orderToRemove);
    }

    public void removeProduct(ProductEntity productToRemove) {
        productDao.remove(productToRemove);
    }
}
