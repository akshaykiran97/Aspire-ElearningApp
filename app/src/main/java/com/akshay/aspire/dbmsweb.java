package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class dbmsweb extends AppCompatActivity {

    private WebView dbmsweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbmsweb);

        dbmsweb = findViewById(R.id.dbmsweb);

        dbmsweb.setWebViewClient(new WebViewClient());
        dbmsweb.loadUrl("https://www.youtube.com/playlist?list=PLxCzCOWd7aiFAN6I8CuViBuCdJgiOkT2Y");
        WebSettings webSettings=dbmsweb.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}