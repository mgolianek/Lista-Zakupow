package com.app.listazakupow.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityProductBinding;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.viewModel.ProductViewModel;

public class ProductActivity extends BaseActivity {
    private ProductViewModel viewModel;
    private ActivityProductBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);
        binding = ActivityProductBinding.inflate(getLayoutInflater());
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
