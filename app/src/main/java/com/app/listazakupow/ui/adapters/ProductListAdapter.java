package com.app.listazakupow.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.listazakupow.databinding.ProductItemListViewBinding;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.ProductEntity;
import com.app.listazakupow.ui.base.BaseViewHolder;
import com.app.listazakupow.viewModel.ProductItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private OnItemClickListener onItemClickListener;
    private List<ProductEntity> mItems;

    public ProductListAdapter(List<ProductEntity> items) {
        if (items == null) {
            items = new ArrayList<>();
        }
        mItems = items;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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

    public class ProductItemViewHolder extends BaseViewHolder implements View.OnClickListener {
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
            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(mItems.get(position));
                }
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(ProductEntity entity);
    }
}
