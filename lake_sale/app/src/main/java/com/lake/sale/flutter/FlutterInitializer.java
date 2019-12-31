package com.lake.sale.flutter;

import android.app.Application;
import android.util.Log;

import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.Platform;
import com.idlefish.flutterboost.Utils;
import com.idlefish.flutterboost.interfaces.INativeRouter;
import com.lake.sale.TextPlatformViewPlugin;


import io.flutter.app.FlutterApplication;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugins.GeneratedPluginRegistrant;
import io.flutter.view.FlutterMain;

/**
 * flutter 初始化
 */
public class FlutterInitializer {
    private final static String TAG = FlutterInitializer.class.getSimpleName();


    public static void init(Application app) {
        if (!(app instanceof FlutterApplication)) {
            FlutterMain.startInitialization(app);
        }

        //路由,Flutter 启动Native页面的时候回调这里
        INativeRouter router = (context, url, urlParams, requestCode, exts) -> {
            Log.i(TAG, "路由--INativeRouter:url=" + url);
            Log.i(TAG, "路由--INativeRouter:requestCode=" + requestCode);
            Log.i(TAG, "路由--INativeRouter:urlParams=" + urlParams);
            Log.i(TAG, "路由--INativeRouter:exts=" + exts);
            String assembleUrl = Utils.assembleUrl(url, urlParams);
            PageRouter.openPageByUrl(context, assembleUrl, urlParams);
        };


        //boost生命周期监控
        FlutterBoost.BoostLifecycleListener boostLifecycleListener = new FlutterBoost.BoostLifecycleListener() {
            @Override
            public void onEngineCreated() {
                Log.i(TAG, "FlutterBoost引擎--onEngineCreated");
            }

            @Override
            public void onPluginsRegistered() {
                Log.i(TAG, "FlutterBoost插件--onPluginsRegistered");
            }

            @Override
            public void onEngineDestroy() {
                Log.i(TAG, "FlutterBoost引擎--onEngineDestroy");
            }
        };

        //插件注册
        FlutterBoost.BoostPluginsRegister pluginsRegister = mRegistry -> {
            GeneratedPluginRegistrant.registerWith(mRegistry);
            //注册native的TextView插件，插件名称：TextPlatformViewPlugin
            TextPlatformViewPlugin.register(mRegistry.registrarFor("TextPlatformViewPlugin"));
        };
        //配置
        Platform platform = new FlutterBoost.ConfigBuilder(app, router)
                .isDebug(true)
                .whenEngineStart(FlutterBoost.ConfigBuilder.ANY_ACTIVITY_CREATED)
                .renderMode(FlutterView.RenderMode.texture)
                .pluginsRegister(pluginsRegister)
                .lifecycleListener(boostLifecycleListener)
                .build();

        //初始化flutter_boost
        FlutterBoost.instance().init(platform);
    }
}