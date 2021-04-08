package com.app.listazakupow.util;

import android.content.Context;
import android.content.DialogInterface;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;

public class Util {
    public static AlertDialog showSimpleDialog(@NonNull Context context,
                                               @NonNull String title,
                                               @NonNull String msg,
                                               @NonNull String positiveBtnText,
                                               @Nullable String negativeBtnText,
                                               @NonNull DialogInterface.OnClickListener positiveBtnClickListener,
                                               @Nullable DialogInterface.OnClickListener negativeBtnClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(msg)
                .setCancelable(true)
                .setPositiveButton(positiveBtnText, positiveBtnClickListener);
        if (negativeBtnText != null)
            builder.setNegativeButton(negativeBtnText, negativeBtnClickListener);
        AlertDialog alert = builder.create();
        alert.show();
        return alert;
    }
}
