package com.app.listazakupow.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.listazakupow.databinding.CategoryItemListViewBinding;
import com.app.listazakupow.models.entities.CategoryEntity;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.ui.base.BaseViewHolder;
import com.app.listazakupow.util.OnSingleClickListener;
import com.app.listazakupow.viewModel.CategoryItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class CategoryListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int VIEW_TYPE_EMPTY = 0;
    private static final int VIEW_TYPE_NORMAL = 1;
    private OnItemClickListener onItemClickListener;
    private List<CategoryEntity> mItems;

    public CategoryListAdapter(List<CategoryEntity> items) {
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
        CategoryItemListViewBinding selectableItemBinding = CategoryItemListViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CategoryItemViewHolder(selectableItemBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public class CategoryItemViewHolder extends BaseViewHolder implements View.OnClickListener {
        private final CategoryItemListViewBinding binding;

        public CategoryItemViewHolder(CategoryItemListViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
            this.binding.getRoot().setOnClickListener(this);
        }

        @Override
        public void onBind(int position) {
            CategoryEntity item = mItems.get(position);
            final CategoryItemViewModel categoryItemViewModel = new CategoryItemViewModel(item);
            binding.setViewModel(categoryItemViewModel);
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
        void onItemClick(CategoryEntity entity);
    }
}