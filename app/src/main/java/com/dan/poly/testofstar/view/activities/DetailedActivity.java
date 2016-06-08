package com.dan.poly.testofstar.view.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.dan.poly.testofstar.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Daniel on 6/8/2016.
 */
public class DetailedActivity extends AppCompatActivity {


    public static final String EXTRA_URL = "extra_url";
    @BindView(R.id.actvity_detailed_webview)
    WebView mWebView;
    @BindView(R.id.loading_progress)
    LinearLayout mLoadProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);

        String url = getIntent().getStringExtra(EXTRA_URL);

        mWebView.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                mLoadProgress.setVisibility(View.GONE);
            }
        });
        mWebView.loadUrl(url);
    }

}
