
package com.kadri.apkbuilder;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.view.KeyEvent;

public class MainActivity extends Activity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        WebSettings settings = webView.getSettings();

        // تفعيل JavaScript
        settings.setJavaScriptEnabled(true);

        // دعم التخزين المحلي
        settings.setDomStorageEnabled(true);

        // السماح بقراءة ملفات التطبيق
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);

        // إعداد عرض صفحات الويب
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        // فتح واجهة التطبيق المحلية
        webView.loadUrl("file:///android_asset/www/index.html");
    }

    @Override
    public void onBackPressed() {
        if (webView != null && webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
