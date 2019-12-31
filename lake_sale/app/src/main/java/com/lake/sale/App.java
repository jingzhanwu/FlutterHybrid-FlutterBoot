package com.lake.sale;

import android.app.Application;

import com.lake.sale.flutter.FlutterInitializer;

/**
 * @anthor created by jzw
 * @date 2019/12/30
 * @change
 * @describe describe
 **/
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlutterInitializer.init(this);
    }
}

