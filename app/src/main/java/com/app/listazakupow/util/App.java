package com.app.listazakupow.util;

import android.app.Application;

public class App extends Application {
    private static App mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
    }

    public static App getContext() {  //used to get app context even in view model (in some cases we really need it)
        return mContext;
    }
}