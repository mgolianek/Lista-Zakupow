package com.app.listazakupow.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;

import com.app.listazakupow.databinding.ActivityChooseProductDetailsBinding;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.util.OnSingleClickListener;
import com.app.listazakupow.viewModel.ChooseProductDetailsViewModel;
import com.app.listazakupow.viewModel.factory.ChooseProductDetailsViewModelFactory;

public class ChooseProductDetailsActivity extends BaseActivity {
    private ChooseProductDetailsViewModel viewModel;
    private ActivityChooseProductDetailsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent i = getIntent();
        String productName = i.getStringExtra("productName");

        viewModel = new ViewModelProvider(this, new ChooseProductDetailsViewModelFactory(productName)).get(ChooseProductDetailsViewModel.class);
        binding = ActivityChooseProductDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);


        binding.addProductToOrderBtn.setOnClickListener(new OnSingleClickListener() {
            @Override
            public void onSingleClick(View v) {
                String quantity = binding.quantityEt.getText().toString();

                Button selectedButton = findViewById(binding.radioGroup.getCheckedRadioButtonId());
                int selectedQuantityTypeId = (int) Integer.parseInt((String) selectedButton.getTag());

                viewModel.addProductToOrder(quantity, selectedQuantityTypeId);

                goBackToMainMenu();
            }
        });
    }


    @Override
    protected void registerObservables() {
        //not used
    }

    private void goBackToMainMenu() {
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(i);
    }
}