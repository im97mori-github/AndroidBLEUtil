package org.im97mori.ble.task;

import android.os.Message;

import androidx.annotation.NonNull;

public class AbstractBLETaskBase extends AbstractBLETask {

    @NonNull
    @Override
    public Message createInitialMessage() {
        return new Message();
    }

    @Override
    public boolean doProcess(@NonNull Message message) {
        return false;
    }

    @Override
    public boolean isBusy() {
        return false;
    }

    @Override
    public void cancel() {

    }
}
