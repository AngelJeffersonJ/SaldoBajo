package com.saldobajo;

import android.content.Context;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;

public class Scheduler {
    public static void iniciarRevisiones(Context context) {
        PeriodicWorkRequest request = new PeriodicWorkRequest.Builder(
            SaldoWorker.class,
            15,
            TimeUnit.MINUTES
        ).build();

        WorkManager.getInstance(context).enqueueUniquePeriodicWork(
            "saldo_check",
            ExistingPeriodicWorkPolicy.REPLACE,
            request
        );
    }
}
