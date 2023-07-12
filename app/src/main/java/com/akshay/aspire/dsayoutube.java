package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class dsayoutube extends AppCompatActivity {
    private WebView dsayoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsayoutube);

        dsayoutube = findViewById(R.id.dsayoutube);

        dsayoutube.setWebViewClient(new WebViewClient());
        dsayoutube.loadUrl("https://www.youtube.com/playlist?list=PLgUwDviBIf0oF6QL8m22w1hIDC1vJ_BHz");
        WebSettings webSettings=dsayoutube.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}