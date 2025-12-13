package com.AdeebTechLab.PakInfoDatabase.pak_info;

import android.Manifest;
import android.app.DownloadManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class browser extends AppCompatActivity {

    private WebView webView;
    private String url;
    private boolean isMobileView = true;

    private ValueCallback<Uri[]> filePathCallback;
    private ActivityResultLauncher<Intent> fileChooserLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable Edge-to-Edge
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_browser);

        webView = findViewById(R.id.webview);

        // Apply Window Insets to handle System Bars (Status Bar/Navigation Bar)
        ViewCompat.setOnApplyWindowInsetsListener(webView, (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            // Add padding only to the top and bottom to avoid content hiding under bars
            // while maintaining full width.
            v.setPadding(0, systemBars.top, 0, systemBars.bottom);
            return insets;
        });

        // Request permissions for file upload/download
        ActivityCompat.requestPermissions(this,
                new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                },
                1);

        url = getIntent().getStringExtra("url");
        if (url == null || url.isEmpty()) {
            url = "https://www.google.com";
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        setupWebView();
        setupFileChooser();
        setupDownloadListener();
        loadWebView();
    }

    private void setupWebView() {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setAllowContentAccess(true);
        settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);

        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                if (getSupportActionBar() != null) {
                    getSupportActionBar().setTitle(title);
                }
            }

            // Handle file chooser
            @Override
            public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> filePathCallback,
                                             FileChooserParams fileChooserParams) {
                if (browser.this.filePathCallback != null) {
                    browser.this.filePathCallback.onReceiveValue(null);
                }
                browser.this.filePathCallback = filePathCallback;

                Intent intent = fileChooserParams.createIntent();
                try {
                    fileChooserLauncher.launch(intent);
                } catch (Exception e) {
                    browser.this.filePathCallback = null;
                    Toast.makeText(browser.this, "Cannot open file chooser", Toast.LENGTH_SHORT).show();
                    return false;
                }
                return true;
            }
        });
    }

    private void setupFileChooser() {
        fileChooserLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (filePathCallback == null) return;

                    Uri[] resultUris = null;
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Uri dataUri = result.getData().getData();
                        if (dataUri != null) {
                            resultUris = new Uri[]{dataUri};
                        }
                    }

                    filePathCallback.onReceiveValue(resultUris);
                    filePathCallback = null;
                });
    }

    private void setupDownloadListener() {
        webView.setDownloadListener((url, userAgent, contentDisposition, mimeType, contentLength) -> {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setMimeType(mimeType);
            String fileName = contentDisposition.replace("inline; filename=", "").replace("\"", "");
            request.addRequestHeader("cookie", android.webkit.CookieManager.getInstance().getCookie(url));
            request.addRequestHeader("User-Agent", userAgent);
            request.setDescription("Downloading file...");
            request.setTitle(fileName);
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, fileName);

            DownloadManager dm = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
            dm.enqueue(request);
            Toast.makeText(getApplicationContext(), "Downloading File...", Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_mobile_view) {
            isMobileView = true;
            loadWebView();
            return true;
        } else if (id == R.id.action_desktop_view) {
            isMobileView = false;
            loadWebView();
            return true;
        } else if (id == R.id.action_refresh) {
            webView.reload(); // ✅ refresh functionality
            Toast.makeText(this, "Refreshing...", Toast.LENGTH_SHORT).show();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void loadWebView() {
        WebSettings settings = webView.getSettings();

        if (isMobileView) {
            // Mobile View
            settings.setUserAgentString("Mozilla/5.0 (Linux; Android 10; Mobile) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0 Mobile Safari/537.36");
            settings.setLoadWithOverviewMode(true);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(false);
        } else {
            // Desktop View
            settings.setUserAgentString("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/115.0 Safari/537.36");
            settings.setLoadWithOverviewMode(false);
            settings.setUseWideViewPort(true);
            settings.setSupportZoom(true);
            settings.setBuiltInZoomControls(true);
            settings.setDisplayZoomControls(false);

            webView.setWebViewClient(new WebViewClient() {
                @Override
                public void onPageFinished(WebView view, String url) {
                    if (!isMobileView) {
                        webView.loadUrl("javascript:(function() {" +
                                "var meta = document.querySelector('meta[name=viewport]');" +
                                "if(meta) meta.parentNode.removeChild(meta);" +
                                "var head = document.getElementsByTagName('head')[0];" +
                                "var newMeta = document.createElement('meta');" +
                                "newMeta.name='viewport';" +
                                "newMeta.content='width=1200';" +
                                "head.appendChild(newMeta);" +
                                "})()");
                    }
                }
            });
        }

        webView.loadUrl(url);
    }
}
