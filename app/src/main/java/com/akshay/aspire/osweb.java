package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class osweb extends AppCompatActivity {
    private WebView osweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_osweb);
        osweb = findViewById(R.id.osweb);

        osweb.setWebViewClient(new WebViewClient());
        osweb.loadUrl("https://www.youtube.com/watch?v=3obEP8eLsCw");
        WebSettings webSettings=osweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}