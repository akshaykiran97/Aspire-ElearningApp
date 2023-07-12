package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class javaweb extends AppCompatActivity {
    private WebView javaweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_javaweb);
        javaweb =(WebView)findViewById(R.id.javaweb);

        javaweb.setWebViewClient(new WebViewClient());
        javaweb.loadUrl("https://www.youtube.com/playlist?list=PLfqMhTWNBTe3LtFWcvwpqTkUSlB32kJop");
        WebSettings webSettings=javaweb.getSettings();
        webSettings.setJavaScriptEnabled(true);


    }
}