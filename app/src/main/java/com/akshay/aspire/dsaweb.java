package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class dsaweb extends AppCompatActivity {
    private WebView dsaweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dsaweb);

        dsaweb = findViewById(R.id.dsaweb);

        dsaweb.setWebViewClient(new WebViewClient());
        dsaweb.loadUrl("https://www.geeksforgeeks.org/learn-data-structures-and-algorithms-dsa-tutorial/");
        WebSettings webSettings=dsaweb.getSettings();
        webSettings.setJavaScriptEnabled(true);



    }
}