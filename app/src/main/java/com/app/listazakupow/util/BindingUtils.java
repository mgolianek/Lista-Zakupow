package com.app.listazakupow.util;

import androidx.databinding.BindingAdapter;

import com.google.android.material.textfield.TextInputLayout;

public final class BindingUtils {
    private BindingUtils() {
    }

    @BindingAdapter({"errorMsg"})
    public static void setErrorMessage(TextInputLayout view, String errorMessage) {
        view.setError(errorMessage);
    }
}