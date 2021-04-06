package com.app.listazakupow.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public final class BindingUtils {
    private BindingUtils() {
    }

    @BindingAdapter({"errorMsg"})
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }

    @BindingAdapter({"bind:src"})
    public static void setImageViewResource(ImageView imageView, int resource) {
        imageView.setImageResource(resource);
    }
}