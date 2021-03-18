package com.app.listazakupow.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityAddCategoryBinding;
import com.app.listazakupow.ui.adapters.CategoryListAdapter;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.util.OnSingleClickListener;
import com.app.listazakupow.viewModel.AddCategoryViewModel;

public class AddCategoryActivity extends BaseActivity {
    private AddCategoryViewModel viewModel;
    private ActivityAddCategoryBinding binding;
    private CategoryListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(AddCategoryViewModel.class);
        binding = ActivityAddCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        showBackArrow();
        setupButtons();
        registerObservables();
    }

    private void setupButtons() {
        binding.addCategoryBtn.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                viewModel.addCategory();
            }
        });
    }

    @Override
    protected void registerObservables() {
        viewModel.categoryList().observe(this, categoryEntities -> {
            adapter = new CategoryListAdapter(categoryEntities);
            binding.categoryRv.setAdapter(adapter);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
