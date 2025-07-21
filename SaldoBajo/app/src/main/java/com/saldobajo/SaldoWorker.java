package com.saldobajo;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class SaldoWorker extends Worker {
    public SaldoWorker(@NonNull Context context, @NonNull WorkerParameters params) {
        super(context, params);
    }

    @NonNull
    @Override
    public Result doWork() {
        NotificationUtil.mostrar(getApplicationContext(), "Revisión", 0f);
        return Result.success();
    }
}
