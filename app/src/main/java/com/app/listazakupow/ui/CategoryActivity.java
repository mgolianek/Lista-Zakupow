package com.app.listazakupow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityCategoryBinding;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.ui.adapters.CategoryListAdapter;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.viewModel.CategoryViewModel;

public class CategoryActivity extends BaseActivity implements CategoryListAdapter.OnItemClickListener {
    private CategoryViewModel viewModel;
    private ActivityCategoryBinding binding;
    private CategoryListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(CategoryViewModel.class);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        showBackArrow();
        registerObservables();
    }

    @Override
    protected void registerObservables() {
        viewModel.categoryList().observe(this, categoryEntities -> {
            adapter = new CategoryListAdapter(categoryEntities);
            adapter.setOnItemClickListener(this);
            binding.categoryRv.setAdapter(adapter);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public void onItemClick(CategoryEntity entity) {
        Intent i = new Intent(this, CategoryDetailsActivity.class);
        i.putExtra("categoryName", entity.name); //name is category ID
        startActivity(i);
    }
}