package com.akshay.aspire;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class cppvideo extends AppCompatActivity {
    private WebView cppweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cppvideo);

        cppweb = (WebView)findViewById(R.id.cppweb);

        cppweb.setWebViewClient(new WebViewClient());
        cppweb.loadUrl("https://www.youtube.com/playlist?list=PLDzeHZWIZsTryvtXdMr6rPh4IDexB5NIA");
        WebSettings webSettings=cppweb.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}