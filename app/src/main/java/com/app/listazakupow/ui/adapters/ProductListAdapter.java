package com.app.listazakupow.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.listazakupow.databinding.ProductItemListViewBinding;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.ui.base.BaseViewHolder;
import com.app.listazakupow.viewModel.ProductItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private List<ProductEntity> mItems;

    public ProductListAdapter(List<ProductEntity> items) {
        if (items == null) {
            items = new ArrayList<>();
        }
        mItems = items;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProductItemListViewBinding selectableItemBinding = ProductItemListViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProductListAdapter.ProductItemViewHolder(selectableItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class ProductItemViewHolder extends BaseViewHolder {
        private final ProductItemListViewBinding binding;

        public ProductItemViewHolder(ProductItemListViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            ProductEntity item = mItems.get(position);
            final ProductItemViewModel productItemViewModel = new ProductItemViewModel(item);
            binding.setViewModel(productItemViewModel);
        }
    }
}
