package com.app.listazakupow.viewModel;

import com.app.listazakupow.models.entities.CategoryEntity;

public class CategoryItemViewModel {
    private final String name;

    public CategoryItemViewModel(CategoryEntity entity) {
        this.name = entity.name;
    }

    public String getName() {
        return name;
    }
}
