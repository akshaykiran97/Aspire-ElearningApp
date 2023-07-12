package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class appdevweb extends AppCompatActivity {
    private WebView appdevyoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appdevweb);
        appdevyoutube = findViewById(R.id.appdevyoutube);

        appdevyoutube.setWebViewClient(new WebViewClient());
        appdevyoutube.loadUrl("https://www.youtube.com/watch?v=mXjZQX3UzOs");
        WebSettings webSettings=appdevyoutube.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}