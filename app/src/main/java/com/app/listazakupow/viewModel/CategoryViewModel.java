package com.app.listazakupow.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.repositories.AppRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    private final AppRepository repository = new AppRepository();

    public LiveData<List<CategoryEntity>> categoryList() {
        return repository.categoryList();
    }
}
