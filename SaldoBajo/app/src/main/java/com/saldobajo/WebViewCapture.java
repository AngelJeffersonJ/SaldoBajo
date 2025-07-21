package com.saldobajo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.webkit.WebView;

public class WebViewCapture {
    public static Bitmap capture(WebView webView) {
        int width = webView.getWidth();
        int height = webView.getContentHeight();
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        webView.draw(canvas);
        return bitmap;
    }
}
