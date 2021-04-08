package com.app.listazakupow.ui.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.listazakupow.databinding.ShoppingItemListEmptyViewBinding;
import com.app.listazakupow.databinding.ShoppingItemListViewBinding;
import com.app.listazakupow.models.entities.OrderEntity;
import com.app.listazakupow.ui.base.BaseViewHolder;
import com.app.listazakupow.viewModel.ShoppingItemEmptyViewModel;
import com.app.listazakupow.viewModel.ShoppingItemViewModel;

import java.util.ArrayList;
import java.util.List;

public class ShopListAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    public static final int VIEW_TYPE_NORMAL = 0;
    public static final int VIEW_TYPE_EMPTY = 1;
    private List<OrderEntity> mItems;
    private OnItemClickListener onItemClickListener;

    public ShopListAdapter(List<OrderEntity> items) {
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
        switch (viewType) {
            case VIEW_TYPE_NORMAL : {
                ShoppingItemListViewBinding selectableItemBinding = ShoppingItemListViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new ShopListAdapter.ShoppingItemViewHolder(selectableItemBinding);
            }
            case VIEW_TYPE_EMPTY:
            default: {
                ShoppingItemListEmptyViewBinding selectableItemBinding = ShoppingItemListEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
                return new ShoppingItemEmptyViewHolder(selectableItemBinding);
            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mItems.isEmpty()) {
            return VIEW_TYPE_EMPTY;
        }
        return VIEW_TYPE_NORMAL;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        if (mItems.size() == 0) {
            return 1;
        }
        return mItems.size();
    }

    public class ShoppingItemViewHolder extends BaseViewHolder implements OnItemClickListener {
        private final ShoppingItemListViewBinding binding;

        public ShoppingItemViewHolder(ShoppingItemListViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            OrderEntity item = mItems.get(position);
            final ShoppingItemViewModel categoryItemViewModel = new ShoppingItemViewModel(item);
            binding.setViewModel(categoryItemViewModel);
        }

        @Override
        public void onItemClick(OrderEntity entity) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(mItems.get(position));
                }
            }
        }
    }

    public static class ShoppingItemEmptyViewHolder extends BaseViewHolder {
        private final ShoppingItemListEmptyViewBinding binding;

        public ShoppingItemEmptyViewHolder(ShoppingItemListEmptyViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        @Override
        public void onBind(int position) {
            final ShoppingItemEmptyViewModel shoppingItemEmptyViewModel = new ShoppingItemEmptyViewModel();
            binding.setViewModel(shoppingItemEmptyViewModel);
        }
    }


    public interface OnItemClickListener {
        void onItemClick(OrderEntity entity);
    }
}
