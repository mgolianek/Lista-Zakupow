package com.app.listazakupow.viewModel;

import android.text.TextUtils;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.repositories.AppRepository;

import java.util.List;

public class CategoryViewModel extends ViewModel {
    private final AppRepository repository = new AppRepository();
    private final MutableLiveData<String> categoryLiveData;

    public CategoryViewModel() {
        categoryLiveData = new MutableLiveData<>();
    }

    public void addCategory() {
        String categoryName = categoryLiveData.getValue();
        if (TextUtils.isEmpty(categoryName)) return; //will fix later
        repository.addCategory(categoryName);
    }

    public MutableLiveData<String> getCategoryLiveData() {
        return categoryLiveData;
    }

    public LiveData<List<CategoryEntity>> categoryList() {
        return repository.categoryList();
    }
}
