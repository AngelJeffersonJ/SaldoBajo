package com.saldobajo;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationUtil {
    private static final String CHANNEL_ID = "saldo_alertas";

    public static void crearCanal(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "Alertas de Saldos Bajos",
                NotificationManager.IMPORTANCE_HIGH
            );
            channel.setDescription("Notificaciones cuando un saldo está por debajo del mínimo.");
            NotificationManager manager = context.getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    public static void mostrar(Context context, String operador, float saldo) {
        crearCanal(context);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(android.R.drawable.stat_notify_error)
            .setContentTitle("⚠️ Saldo Bajo Detectado")
            .setContentText("Operador: " + operador + " | Saldo: $" + saldo)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true);
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify((int) System.currentTimeMillis(), builder.build());
    }
}
