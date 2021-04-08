package com.app.listazakupow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityAddProductBinding;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.viewModel.AddProductViewModel;
import com.app.listazakupow.viewModel.factory.AddProductViewModelFactory;

public class AddProductActivity extends BaseActivity implements View.OnClickListener {
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

        binding.addProductBtn.setOnClickListener(this);

        binding.productNameEt.setOnKeyListener((v, keyCode, event) -> {
            // If the event is a key-down event on the "enter" button
            if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)) {
                // Perform action on key press
                onClick(binding.addProductBtn);
                return true;
            }
            return false;
        });
        showBackArrow();
    }

    @Override
    public void onClick(View v) {
        viewModel.addProduct(binding.productNameEt.getText().toString());
        Toast.makeText(AddProductActivity.this, "Dodano produkt", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    protected void registerObservables() {
        //not used
    }
}
