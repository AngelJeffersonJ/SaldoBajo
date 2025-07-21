package com.saldobajo;

import android.content.Context;
import android.webkit.WebView;
import android.webkit.ValueCallback;

public class SaldoChecker {
    private Context context;
    private WebView webView;

    public SaldoChecker(Context context, WebView webView) {
        this.context = context;
        this.webView = webView;
    }

    public void verificarSaldos() {
        String js = "(() => { return document.body.innerText; })()";

        webView.evaluateJavascript(js, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String value) {
                String texto = value.toLowerCase();

                if (checkSaldo(texto, "at&t", 2000) ||
                    checkSaldo(texto, "movistar", 4000) ||
                    checkSaldo(texto, "telcel", 15000)) {
                    NotificationUtil.mostrar(context, "Saldo Crítico", 0f);
                }
            }
        });
    }

    private boolean checkSaldo(String texto, String operador, int limite) {
        try {
            if (texto.contains(operador)) {
                String[] partes = texto.split(operador);
                for (String parte : partes) {
                    String[] tokens = parte.split(" ");
                    for (String token : tokens) {
                        token = token.replaceAll("[^0-9.]", "");
                        if (!token.isEmpty()) {
                            float valor = Float.parseFloat(token);
                            if (valor < (limite - 1000)) {
                                return true;
                            }
                        }
                    }
                }
            }
        } catch (Exception ignored) {}
        return false;
    }
}
