package com.lake.sale.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.idlefish.flutterboost.containers.BoostFlutterActivity;
import com.lake.sale.FlutterFragmentPageActivity;
import com.lake.sale.NativePageActivity;

import java.util.HashMap;
import java.util.Map;

public class PageRouter {

    public final static Map<String, String> pageName = new HashMap<String, String>() {{

        put("first", "first");
        put("second", "second");
        put("tab", "tab");
        put("sample://flutterPage", "flutterPage");
        put("sample://demoFlutterPage", "flutterDemoPage");
    }};

    public static final String NATIVE_PAGE_URL = "sample://nativePage";

    public static final String FLUTTER_DEMO_PAGE_URL = "sample://demoFlutterPage";
    public static final String FLUTTER_PAGE_URL = "sample://flutterPage";
    public static final String FLUTTER_FRAGMENT_PAGE_URL = "sample://flutterFragmentPage";

    public static boolean openPageByUrl(Context context, String url, Map params) {
        return openPageByUrl(context, url, params, 0);
    }

    public static boolean openPageByUrl(Context context, String url, Map params, int requestCode) {

        String path = url.split("\\?")[0];

        Log.i("openPageByUrl", path);

        try {
            if (pageName.containsKey(path)) {
                //打开指定url的flutter页面
                Intent intent = BoostFlutterActivity.withNewEngine().url(pageName.get(path)).params(params)
                        .backgroundMode(BoostFlutterActivity.BackgroundMode.opaque).build(context);
                if (context instanceof Activity) {
                    Activity activity = (Activity) context;
                    activity.startActivityForResult(intent, requestCode);
                } else {
                    context.startActivity(intent);
                }
                return true;
            } else if (url.startsWith(FLUTTER_FRAGMENT_PAGE_URL)) {
                //打开flutter创建的fragment
                context.startActivity(new Intent(context, FlutterFragmentPageActivity.class));
                return true;
            } else if (url.startsWith(NATIVE_PAGE_URL)) {
                //打开原生Activity
                context.startActivity(new Intent(context, NativePageActivity.class));
                return true;
            }
            return false;
        } catch (Throwable t) {
            return false;
        }
    }
}