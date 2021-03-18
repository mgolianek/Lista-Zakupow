package com.app.listazakupow.util;

import android.os.SystemClock;
import android.view.View;

/**
 * This class allows a single click and prevents multiple clicks on
 * the same button in rapid succession. Setting unclickable is not enough
 * because click events may still be queued up.
 * <p>
 * Override onSingleClick() to handle single clicks.
 * accept another click.
 */

public abstract class OnSingleClickListener implements View.OnClickListener {
    private static final long MIN_CLICK_INTERVAL=1000;
    private long mLastClickTime;


    public abstract void onSingleClick(View v);

    @Override
    public final void onClick(View v) {
        long currentClickTime=SystemClock.uptimeMillis();
        long elapsedTime=currentClickTime-mLastClickTime;
        mLastClickTime=currentClickTime;

        if(elapsedTime<=MIN_CLICK_INTERVAL)
            return;

        onSingleClick(v);
    }
}