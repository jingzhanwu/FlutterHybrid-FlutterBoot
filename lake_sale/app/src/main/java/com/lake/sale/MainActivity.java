package com.lake.sale;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lake.sale.flutter.PageRouter;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnOpenNative;
    private Button btnOpenFlutter;
    private Button btnOpenFlutterFragment;
    private Button btnOpenFlutterDemoPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpenNative = findViewById(R.id.btnOpenNativePage);
        btnOpenFlutter = findViewById(R.id.btnOpenFlutterPage);
        btnOpenFlutterFragment = findViewById(R.id.btnOpenFlutterFragment);
        btnOpenFlutterDemoPage = findViewById(R.id.btnOpenFlutterDemoPage);

        btnOpenNative.setOnClickListener(this);
        btnOpenFlutter.setOnClickListener(this);
        btnOpenFlutterFragment.setOnClickListener(this);
        btnOpenFlutterDemoPage.setOnClickListener(this);
        findViewById(R.id.btnOpenFlutterFirst).setOnClickListener(this);
        findViewById(R.id.btnOpenFlutterSecond).setOnClickListener(this);
        findViewById(R.id.btnOpenFlutterTab).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Map<String, String> params = new HashMap<>();
        params.put("test1", "v_test1");
        params.put("test2", "v_test2");
        switch (v.getId()) {
            case R.id.btnOpenNativePage:
                PageRouter.openPageByUrl(this, PageRouter.NATIVE_PAGE_URL, params);
                break;
            case R.id.btnOpenFlutterPage:
                //打开一个flutter页面
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_PAGE_URL, params);
                break;
            case R.id.btnOpenFlutterDemoPage:
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_DEMO_PAGE_URL, params);
                break;
            case R.id.btnOpenFlutterFragment:
                //打开一个flutter创建的fragment的activity原生page
                PageRouter.openPageByUrl(this, PageRouter.FLUTTER_FRAGMENT_PAGE_URL, params);
                break;

            case R.id.btnOpenFlutterFirst:
                PageRouter.openPageByUrl(this, "first", params);
                break;

            case R.id.btnOpenFlutterSecond:
                PageRouter.openPageByUrl(this, "second", params);
                break;

            case R.id.btnOpenFlutterTab:
                PageRouter.openPageByUrl(this, "tab", params);
                break;
        }
    }
}
