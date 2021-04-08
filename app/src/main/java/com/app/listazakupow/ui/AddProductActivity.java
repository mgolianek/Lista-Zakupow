package com.app.listazakupow.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityAddProductBinding;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.viewModel.AddProductViewModel;
import com.app.listazakupow.viewModel.factory.AddProductViewModelFactory;


public class AddProductActivity extends BaseActivity {
    private AddProductViewModel viewModel;
    private ActivityAddProductBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String categoryName = i.getStringExtra("categoryName");

        viewModel = new ViewModelProvider(this, new AddProductViewModelFactory(categoryName)).get(AddProductViewModel.class);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void registerObservables() {
        //not used?
    }
}
