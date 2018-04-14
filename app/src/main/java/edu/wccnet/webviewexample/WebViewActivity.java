package edu.wccnet.webviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // By default JavaScript is off in a WebView... for a more advanced application we
        // will need to enable it
        WebView myView=(WebView)findViewById(R.id.webView);
        myView.setWebViewClient(new WebViewClient());

        myView.loadUrl( "http://www.google.com" );
    }
}
