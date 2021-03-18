package com.app.listazakupow.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityAddProductBinding;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.viewModel.AddProductViewModel;

public class AddProductActivity extends BaseActivity {
    private AddProductViewModel viewModel;
    private ActivityAddProductBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(AddProductViewModel.class);
        binding = ActivityAddProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        showBackArrow();
        registerObservables();
    }

    @Override
    protected void registerObservables() {

    }
}
