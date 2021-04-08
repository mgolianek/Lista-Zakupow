package com.app.listazakupow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.R;
import com.app.listazakupow.databinding.ActivityCategoryDetailsBinding;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.ui.adapters.ProductListAdapter;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.viewModel.CategoryDetailsViewModel;
import com.app.listazakupow.viewModel.factory.CategoryDetailsViewModelFactory;

public class CategoryDetailsActivity extends BaseActivity implements ProductListAdapter.OnItemClickListener {
    private CategoryDetailsViewModel viewModel;
    private ActivityCategoryDetailsBinding binding;
    private ProductListAdapter adapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String categoryName = i.getStringExtra("categoryName");

        viewModel = new ViewModelProvider(this, new CategoryDetailsViewModelFactory(categoryName)).get(CategoryDetailsViewModel.class);
        binding = ActivityCategoryDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        showBackArrow();
        registerObservables();
    }

    @Override
    protected void registerObservables() {
        viewModel.productList().observe(this, productEntities -> {
            adapter = new ProductListAdapter(productEntities);
            adapter.setOnItemClickListener(this);
            binding.productRv.setAdapter(adapter);
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.category_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            Intent i = new Intent(this, AddProductActivity.class);
            i.putExtra("categoryName", viewModel.getCategoryName()); //name is category ID
            startActivity(i);
            return true;
        }
        return false;
    }

    @Override
    public void onItemClick(ProductEntity entity) {
        Intent i = new Intent(this, ChooseProductDetailsActivity.class);
        i.putExtra("productName",entity.name);
        startActivity(i);
    }
}
