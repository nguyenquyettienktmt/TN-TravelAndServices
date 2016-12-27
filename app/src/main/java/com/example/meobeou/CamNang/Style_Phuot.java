package com.example.meobeou.CamNang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.meobeou.tn_travelandservices.R;

public class Style_Phuot extends AppCompatActivity {
    WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style__phuot);
        addControl();
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://www.facebook.com/Th%E1%BB%9Di-trang-l%C3%ADnh%C4%91%E1%BB%93-Ph%C6%B0%E1%BB%A3t-Th%C3%A1i-Nguy%C3%AAn-Trang-Ho%C3%A0-US-ARMY-1788850471339527/?hc_ref=SEARCH&fref=nf");
            webView.getSettings().setJavaScriptEnabled(true);
        }
    private void addControl() {
        webView = (WebView) findViewById(R.id.webViewStyle);
    }
}
