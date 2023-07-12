package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class cnweb extends AppCompatActivity {

    private WebView cnweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cnweb);

        cnweb = findViewById(R.id.cnweb);

        cnweb.setWebViewClient(new WebViewClient());
        cnweb.loadUrl("https://www.youtube.com/playlist?list=PLxCzCOWd7aiGFBD2-2joCpWOLUrDLvVV_");
        WebSettings webSettings=cnweb.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}