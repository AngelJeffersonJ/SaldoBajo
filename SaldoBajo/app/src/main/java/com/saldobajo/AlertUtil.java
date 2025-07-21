package com.saldobajo;

import android.content.Context;
import android.widget.Toast;

public class AlertUtil {
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
