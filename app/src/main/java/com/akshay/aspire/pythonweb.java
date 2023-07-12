package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class pythonweb extends AppCompatActivity {

    private WebView pythonweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pythonweb);

        pythonweb = findViewById(R.id.pythonweb);

        pythonweb.setWebViewClient(new WebViewClient());
        pythonweb.loadUrl("https://www.youtube.com/playlist?list=PLeo1K3hjS3uu_n_a__MI_KktGTLYopZ12");
        WebSettings webSettings=pythonweb.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}