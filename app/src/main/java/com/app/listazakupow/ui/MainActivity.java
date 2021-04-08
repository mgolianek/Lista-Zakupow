package com.app.listazakupow.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.app.listazakupow.R;
import com.app.listazakupow.databinding.ActivityMainBinding;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.models.relations.OrderWithProduct;
import com.app.listazakupow.ui.adapters.ShopListAdapter;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.util.Util;
import com.app.listazakupow.viewModel.MainActivityViewModel;

public class MainActivity extends BaseActivity implements ShopListAdapter.OnItemClickListener {
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private ShopListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        setupToolbar();
        registerObservables();
    }

    @Override
    protected void registerObservables() {
        viewModel.getOrderData().observe(this, orderEntities -> {
            adapter = new ShopListAdapter(orderEntities);
            adapter.setOnItemClickListener(this);
            binding.shoppingRv.setAdapter(adapter);

            new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
                @Override
                public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                    return false;
                }

                @Override
                public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                    int position = viewHolder.getAdapterPosition();
                    OrderEntity orderToRemove = adapter.getOrderAt(position);
                    viewModel.removeOrder(orderToRemove);

                    Toast.makeText(MainActivity.this,"Usunięto", Toast.LENGTH_SHORT).show();
                }

            }).attachToRecyclerView(binding.shoppingRv);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.shopping_list_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add) {
            startActivity(CategoryActivity.class);
            return true;
        }

        if (id == R.id.action_remove_all) {
            Util.showSimpleDialog(
                    this,
                    "Uwaga",
                    "Czy na pewno chcesz usunąc wszystkie produkty z listy?",
                    "Usuń",
                    "Anuluj",
                    (dialog, which) -> viewModel.removeAllOrdersFromList(),
                    (dialog, which) -> { /* nic nie robimy przy anulowaniu */ });
            return true;
        }
        return false;
    }

    @Override
    public void onItemClick(OrderWithProduct entity) {
        //TODO: check collected product
    }
}