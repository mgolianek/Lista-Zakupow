package com.app.listazakupow.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.app.listazakupow.R;
import com.app.listazakupow.databinding.ActivityMainBinding;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.ui.adapters.ShopListAdapter;
import com.app.listazakupow.ui.base.BaseActivity;
import com.app.listazakupow.util.OnSingleClickListener;
import com.app.listazakupow.viewModel.MainActivityViewModel;

public class MainActivity extends BaseActivity implements ShopListAdapter.OnItemClickListener {
    private MainActivityViewModel viewModel;
    private ActivityMainBinding binding;
    private ShopListAdapter adapter;

    public static  int ORDER_LIST_ID = 1; //mialo byc wiecej list zakupowych, ale jest tylko jedna :(

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.setViewModel(viewModel);
        binding.setLifecycleOwner(this);

        setupToolbar();
        setupRecyclerView();
        registerObservables();
    }

    private void setupRecyclerView() {
        adapter = new ShopListAdapter(null); //TODO: livedata
        adapter.setOnItemClickListener(this);
        binding.shoppingRv.setAdapter(adapter);

//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//                //TODO: delete!
//            }
//
//        }).attachToRecyclerView(binding.shoppingRv);
    }

    @Override
    protected void registerObservables() { //not used here YET
        viewModel.getOrderData().observe(this, orderEntities -> {
            Log.d("TAG", "registerObservables: ");
            adapter = new ShopListAdapter(orderEntities); //TODO: livedata
            adapter.setOnItemClickListener(this);
            binding.shoppingRv.setAdapter(adapter);
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
            viewModel.removeAllProductsFromList();
            return true;
        }

        return false;
    }

    @Override
    public void onItemClick(OrderEntity entity) {
        Toast.makeText(this,"TESCIK", Toast.LENGTH_SHORT).show();
    }
}