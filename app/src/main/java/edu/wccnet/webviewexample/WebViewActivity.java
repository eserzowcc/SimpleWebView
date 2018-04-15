package edu.wccnet.webviewexample;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewActivity extends AppCompatActivity {
    public static final String TAG=WebViewActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // By default JavaScript is off in a WebView... for a more advanced application we
        // will need to enable it
        final WebView myView=(WebView)findViewById(R.id.webView);
        myView.setWebViewClient(new WebViewClient() {
            public void onPageStarter(WebView view, String url, Bitmap favicon) {
                Log.d(TAG, "onPageStarter:  " + url + " is loading");
            }

            public void onPageFinished(WebView view, String url) {
                Log.d(TAG, "onPageFinished: " + url + " is done loading");
            }

            public void onReceivedError(WebView view, int errorCode,
                                        String description, String failingUrl) {
                Log.d(TAG, "onPageStarter: error loading page");
            }

        });

        Button buttonSearch=(Button)findViewById(R.id.buttonSearch);
        final EditText searchTerm=(EditText)findViewById(R.id.editTextSearch);
        buttonSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myView.loadUrl( "http://www.google.com/search?q=" + searchTerm.getText().toString());
            }
        });

        myView.loadUrl( "http://www.google.com" );
    }

}
