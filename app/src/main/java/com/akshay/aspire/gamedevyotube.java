package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class gamedevyotube extends AppCompatActivity {
    private WebView gamedevyoutube;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamedevyotube);

        gamedevyoutube = findViewById(R.id.gamedevyoutube);

        gamedevyoutube.setWebViewClient(new WebViewClient());
        gamedevyoutube.loadUrl("https://www.youtube.com/watch?v=6UlU_FsicK8");
        WebSettings webSettings=gamedevyoutube.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}