package com.saldobajo;

import android.content.Context;
import android.graphics.Bitmap;
import android.webkit.WebView;

public class LoginManager {
    private Context context;
    private WebView webView;
    private OCRUtil ocr;

    public LoginManager(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
        this.ocr = new OCRUtil(context);
    }

    public void performLogin() {
        Bitmap captchaBitmap = WebViewCapture.capture(webView);
        String captchaText = ocr.extractText(captchaBitmap);

        if (captchaText == null || captchaText.trim().length() < 4) {
            AlertUtil.showToast(context, "❌ Captcha ilegible.");
            return;
        }

        String js = "document.getElementById('Usuario').value='multi_saldo';" +
                    "document.getElementById('Password').value='multiscjef';" +
                    "document.getElementById('Captcha').value='" + captchaText.trim() + "';" +
                    "document.forms[0].submit();";

        webView.evaluateJavascript(js, null);
    }
}
