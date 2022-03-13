package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

/**
 * Base task class
 */
@SuppressWarnings({"WeakerAccess"})
public abstract class AbstractBLETask {

    /**
     * KEY:NEXT_PROGRESS
     */
    public static final String KEY_NEXT_PROGRESS = "KEY_NEXT_PROGRESS";

    /**
     * PROGRESS:INIT
     */
    public static final String PROGRESS_INIT = "PROGRESS_INIT";

    /**
     * PROGRESS:TIMEOUT
     */
    public static final String PROGRESS_TIMEOUT = "PROGRESS_TIMEOUT";

    /**
     * create timeout message
     *
     * @param obj instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return create timeout {@link Message} instance
     */
    @NonNull
    public static Message createTimeoutMessage(@NonNull Object obj) {
        Bundle bundle = new Bundle();
        bundle.putString(KEY_NEXT_PROGRESS, PROGRESS_TIMEOUT);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * task progress
     */
    @SuppressWarnings("unused")
    protected String mCurrentProgress = PROGRESS_INIT;

    /**
     * task id
     */
    private final Integer mTaskId = hashCode();

    /**
     * create initial message
     *
     * @return task's initial {@link Message} instance
     */
    @NonNull
    public abstract Message createInitialMessage();

    /**
     * do task
     *
     * @param message {@link Message} from {@link org.im97mori.ble.TaskHandler#handleMessage(Message)}
     * @return {@code true}:this task has been finished(or timeout), {@code false}:work in progress
     */
    @SuppressWarnings("SameReturnValue")
    public abstract boolean doProcess(@SuppressWarnings("unused") @NonNull Message message);

    /**
     * check busy status
     *
     * @return {@code true}:{@link android.bluetooth.BluetoothGatt} is busy, {@code false}: not busy
     */
    public abstract boolean isBusy();

    /**
     * cancel task
     */
    public abstract void cancel();

    /**
     * @return task id
     */
    @NonNull
    public final Integer getTaskId() {
        return mTaskId;
    }

    /**
     * @return {@code true}:ignore busy status on {@link org.im97mori.ble.TaskHandler}, {@code false}:wait until busy status clears(default)
     */
    @SuppressWarnings("SameReturnValue")
    public boolean isIgnoreBusy() {
        return false;
    }

}