package com.lake.sale;

import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.StandardMessageCodec;

/**
 * @anthor created by jingzhanwu
 * @date 2019-12-27
 * @change
 * @describe 注册native的TextView组件给flutter端使用
 **/
public class TextPlatformViewPlugin {

    /**
     * 提供的注册plugin方法
     *
     * @param registrar
     */
    public static void register(PluginRegistry.Registrar registrar) {
        registrar.platformViewRegistry().registerViewFactory("plugins.test/view",
                new TextPlatformViewFactory(StandardMessageCodec.INSTANCE));
    }
}