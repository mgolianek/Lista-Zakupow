package com.app.listazakupow.ui;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.app.listazakupow.R;

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract void registerObservables();

    public void showBackArrow() {
        setupToolbar();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
        }
    }

    protected void setupToolbar() {
        Toolbar toolbar = findViewById(R.id.app_toolbar);
        setSupportActionBar(toolbar);
    }


    public void startActivity(Class<?> calledActivity) {
        Intent i = new Intent(this, calledActivity);
        this.startActivity(i);
    }
}
