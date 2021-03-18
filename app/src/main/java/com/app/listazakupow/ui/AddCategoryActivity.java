package com.app.listazakupow.ui;

import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityAddCategoryBinding;
import com.app.listazakupow.viewModel.AddCategoryViewModel;

public class AddCategoryActivity extends BaseActivity{
    private AddCategoryViewModel viewModel;
    private ActivityAddCategoryBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(AddCategoryViewModel.class);
        binding = ActivityAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        showBackArrow();
        registerObservables();
    }

    @Override
    protected void registerObservables() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
