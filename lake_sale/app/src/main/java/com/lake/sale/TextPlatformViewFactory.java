package com.lake.sale;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

/**
 * @anthor created by jingzhanwu
 * @date 2019-12-27
 * @change
 * @describe native 平台view构造工厂
 * 创建一个nvtive平台的TextView组件
 **/
public class TextPlatformViewFactory extends PlatformViewFactory {

    public TextPlatformViewFactory(MessageCodec<Object> createArgsCodec) {
        super(createArgsCodec);
    }

    @Override
    public PlatformView create(Context context, int i, Object o) {
        return new TextPlatformView(context);
    }

    private static class TextPlatformView implements PlatformView {

        private TextView platformTv;

        public TextPlatformView(Context context) {
            platformTv = new TextView(context);
            platformTv.setText("PlatformView Demo");
        }

        @Override
        public View getView() {
            return platformTv;
        }

        @Override
        public void dispose() {

        }
    }
}