package com.app.listazakupow.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public final class BindingUtils {
    private BindingUtils() {
    }

    @BindingAdapter({"src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}