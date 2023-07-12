package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webdevweb extends AppCompatActivity {

    private WebView webdevyoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webdevweb);
        webdevyoutube = findViewById(R.id.webdevyoutube);

        webdevyoutube.setWebViewClient(new WebViewClient());
        webdevyoutube.loadUrl("https://www.youtube.com/playlist?list=PLu0W_9lII9agiCUZYRsvtGTXdxkzPyItg");
        WebSettings webSettings=webdevyoutube.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}