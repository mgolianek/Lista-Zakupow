package com.app.listazakupow.viewModel;

import androidx.lifecycle.ViewModel;

import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.ui.adapters.CategoryListAdapter;

public class CategoryItemViewModel extends ViewModel {
    private final String name;
    private final int resourceImageId;

    public CategoryItemViewModel(CategoryEntity entity) {
        this.name = entity.name;
        this.resourceImageId = entity.resourceImageId;
    }

    public String getName() {
        return name;
    }

    public int getResourceImageId() {
        return resourceImageId;
    }
}
