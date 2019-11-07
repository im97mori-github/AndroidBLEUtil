package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

/**
 * Base task class
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public abstract class AbstractBLETask {

    /**
     * KEY:NEXT_PROGRESS
     */
    public static final String KEY_NEXT_PROGRESS = "KEY_NEXT_PROGRESS";

    /**
     * KEY:SERVICE_UUID
     */
    public static final String KEY_SERVICE_UUID = "KEY_SERVICE_UUID";

    /**
     * KEY:CHARACTERISTIC_UUID
     */
    public static final String KEY_CHARACTERISTIC_UUID = "KEY_CHARACTERISTIC_UUID";

    /**
     * KEY:DESCRIPTOR_UUID
     */
    public static final String KEY_DESCRIPTOR_UUID = "KEY_DESCRIPTOR_UUID";

    /**
     * KEY:VALUES
     */
    public static final String KEY_VALUES = "KEY_VALUES";

    /**
     * KEY:STATUS
     */
    public static final String KEY_STATUS = "KEY_STATUS";

    /**
     * KEY:MTU
     */
    public static final String KEY_MTU = "KEY_MTU";

    /**
     * KEY:TX_PHY
     */
    public static final String KEY_TX_PHY = "KEY_TX_PHY";

    /**
     * KEY:RX_PHY
     */
    public static final String KEY_RX_PHY = "KEY_RX_PHY";

    /**
     * KEY:PHY_OPTIONS
     */
    public static final String KEY_PHY_OPTIONS = "KEY_PHY_OPTIONS";

    /**
     * KEY:RSSI
     */
    public static final String KEY_RSSI = "KEY_RSSI";

    /**
     * KEY:BLUETOOTH_DEVICE
     */
    public static final String KEY_BLUETOOTH_DEVICE = "KEY_BLUETOOTH_DEVICE";

    /**
     * PROGRESS:INIT
     */
    public static final int PROGRESS_INIT = 0;

    /**
     * PROGRESS:FINISHED
     */
    public static final int PROGRESS_FINISHED = PROGRESS_INIT + 1;

    /**
     * PROGRESS:BUSY
     */
    public static final int PROGRESS_BUSY = PROGRESS_FINISHED + 1;

    /**
     * PROGRESS:TIMEOUT
     */
    public static final int PROGRESS_TIMEOUT = PROGRESS_BUSY + 1;

    /**
     * PROGRESS:CONNECT
     */
    public static final int PROGRESS_CONNECT = PROGRESS_TIMEOUT + 1;

    /**
     * PROGRESS:CONNECT_SUCCESS
     */
    public static final int PROGRESS_CONNECT_SUCCESS = PROGRESS_CONNECT + 1;

    /**
     * PROGRESS:DISCOVER_SERVICE_START
     */
    public static final int PROGRESS_DISCOVER_SERVICE_START = PROGRESS_CONNECT_SUCCESS + 1;

    /**
     * PROGRESS:DISCOVER_SERVICE_SUCCESS
     */
    public static final int PROGRESS_DISCOVER_SERVICE_SUCCESS = PROGRESS_DISCOVER_SERVICE_START + 1;

    /**
     * PROGRESS:DISCOVER_SERVICE_ERROR
     */
    public static final int PROGRESS_DISCOVER_SERVICE_ERROR = PROGRESS_DISCOVER_SERVICE_SUCCESS + 1;

    /**
     * PROGRESS:DISCONNECT
     */
    public static final int PROGRESS_DISCONNECT = PROGRESS_DISCOVER_SERVICE_ERROR + 1;

    /**
     * PROGRESS:CHARACTERISTIC_READ
     */
    public static final int PROGRESS_CHARACTERISTIC_READ_START = PROGRESS_DISCONNECT + 1;

    /**
     * PROGRESS:CHARACTERISTIC_READ_SUCCESS
     */
    public static final int PROGRESS_CHARACTERISTIC_READ_SUCCESS = PROGRESS_CHARACTERISTIC_READ_START + 1;

    /**
     * PROGRESS:CHARACTERISTIC_READ_ERROR
     */
    public static final int PROGRESS_CHARACTERISTIC_READ_ERROR = PROGRESS_CHARACTERISTIC_READ_SUCCESS + 1;

    /**
     * PROGRESS:CHARACTERISTIC_WRITE
     */
    public static final int PROGRESS_CHARACTERISTIC_WRITE_START = PROGRESS_CHARACTERISTIC_READ_ERROR + 1;

    /**
     * PROGRESS:CHARACTERISTIC_WRITE_SUCCESS
     */
    public static final int PROGRESS_CHARACTERISTIC_WRITE_SUCCESS = PROGRESS_CHARACTERISTIC_WRITE_START + 1;

    /**
     * PROGRESS:CHARACTERISTIC_WRITE_ERROR
     */
    public static final int PROGRESS_CHARACTERISTIC_WRITE_ERROR = PROGRESS_CHARACTERISTIC_WRITE_SUCCESS + 1;

    /**
     * PROGRESS:DESCRIPTOR_READ
     */
    public static final int PROGRESS_DESCRIPTOR_READ_START = PROGRESS_CHARACTERISTIC_WRITE_ERROR + 1;

    /**
     * PROGRESS:DESCRIPTOR_READ_SUCCESS
     */
    public static final int PROGRESS_DESCRIPTOR_READ_SUCCESS = PROGRESS_DESCRIPTOR_READ_START + 1;

    /**
     * PROGRESS:DESCRIPTOR_READ_ERROR
     */
    public static final int PROGRESS_DESCRIPTOR_READ_ERROR = PROGRESS_DESCRIPTOR_READ_SUCCESS + 1;

    /**
     * PROGRESS:DESCRIPTOR_WRITE
     */
    public static final int PROGRESS_DESCRIPTOR_WRITE_START = PROGRESS_DESCRIPTOR_READ_ERROR + 1;

    /**
     * PROGRESS:DESCRIPTOR_WRITE_SUCCESS
     */
    public static final int PROGRESS_DESCRIPTOR_WRITE_SUCCESS = PROGRESS_DESCRIPTOR_WRITE_START + 1;

    /**
     * PROGRESS:DESCRIPTOR_WRITE_ERROR
     */
    public static final int PROGRESS_DESCRIPTOR_WRITE_ERROR = PROGRESS_DESCRIPTOR_WRITE_SUCCESS + 1;

    /**
     * PROGRESS:NOTIFICATION_START
     */
    public static final int PROGRESS_NOTIFICATION_START = PROGRESS_DESCRIPTOR_WRITE_ERROR + 1;

    /**
     * PROGRESS_NOTIFICATION_SUCCESS
     */
    public static final int PROGRESS_NOTIFICATION_SUCCESS = PROGRESS_NOTIFICATION_START + 1;

    /**
     * PROGRESS:NOTIFICATION_ERROR
     */
    public static final int PROGRESS_NOTIFICATION_ERROR = PROGRESS_NOTIFICATION_SUCCESS + 1;

    /**
     * PROGRESS:REQUEST_MTU_START
     */
    public static final int PROGRESS_REQUEST_MTU_START = PROGRESS_NOTIFICATION_ERROR + 1;

    /**
     * PROGRESS:REQUEST_MTU_SUCCESS
     */
    public static final int PROGRESS_REQUEST_MTU_SUCCESS = PROGRESS_REQUEST_MTU_START + 1;

    /**
     * PROGRESS:REQUEST_MTU_ERROR
     */
    public static final int PROGRESS_REQUEST_MTU_ERROR = PROGRESS_REQUEST_MTU_SUCCESS + 1;

    /**
     * PROGRESS:READ_PHY_START
     */
    public static final int PROGRESS_READ_PHY_START = PROGRESS_REQUEST_MTU_ERROR + 1;

    /**
     * PROGRESS:READ_PHY_SUCCESS
     */
    public static final int PROGRESS_READ_PHY_SUCCESS = PROGRESS_READ_PHY_START + 1;

    /**
     * PROGRESS:READ_PHY_ERROR
     */
    public static final int PROGRESS_READ_PHY_ERROR = PROGRESS_READ_PHY_SUCCESS + 1;

    /**
     * PROGRESS:SET_PREFERRED_PHY_START
     */
    public static final int PROGRESS_SET_PREFERRED_PHY_START = PROGRESS_READ_PHY_ERROR + 1;

    /**
     * PROGRESS:SET_PREFERRED_PHY_SUCCESS
     */
    public static final int PROGRESS_SET_PREFERRED_PHY_SUCCESS = PROGRESS_SET_PREFERRED_PHY_START + 1;

    /**
     * PROGRESS:SET_PREFERRED_PHY_ERROR
     */
    public static final int PROGRESS_SET_PREFERRED_PHY_ERROR = PROGRESS_SET_PREFERRED_PHY_SUCCESS + 1;

    /**
     * PROGRESS:READ_REMOTE_RSSI_START
     */
    public static final int PROGRESS_READ_REMOTE_RSSI_START = PROGRESS_SET_PREFERRED_PHY_ERROR + 1;

    /**
     * PROGRESS:READ_REMOTE_RSSI_SUCCESS
     */
    public static final int PROGRESS_READ_REMOTE_RSSI_SUCCESS = PROGRESS_READ_REMOTE_RSSI_START + 1;

    /**
     * PROGRESS:READ_REMOTE_RSSI_ERROR
     */
    public static final int PROGRESS_READ_REMOTE_RSSI_ERROR = PROGRESS_READ_REMOTE_RSSI_SUCCESS + 1;

    /**
     * PROGRESS:BEGIN_RELIABLE_WRITE_START
     */
    public static final int PROGRESS_BEGIN_RELIABLE_WRITE_START = PROGRESS_READ_REMOTE_RSSI_ERROR + 1;

    /**
     * PROGRESS:BEGIN_RELIABLE_WRITE_SUCCESS
     */
    public static final int PROGRESS_BEGIN_RELIABLE_WRITE_SUCCESS = PROGRESS_BEGIN_RELIABLE_WRITE_START + 1;

    /**
     * PROGRESS:BEGIN_RELIABLE_WRITE_ERROR
     */
    public static final int PROGRESS_BEGIN_RELIABLE_WRITE_ERROR = PROGRESS_BEGIN_RELIABLE_WRITE_SUCCESS + 1;

    /**
     * PROGRESS:EXECUTE_RELIABLE_WRITE_START
     */
    public static final int PROGRESS_EXECUTE_RELIABLE_WRITE_START = PROGRESS_BEGIN_RELIABLE_WRITE_ERROR + 1;

    /**
     * PROGRESS_EXECUTE:RELIABLE_WRITE_SUCCESS
     */
    public static final int PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS = PROGRESS_EXECUTE_RELIABLE_WRITE_START + 1;

    /**
     * PROGRESS:EXECUTE_RELIABLE_WRITE_ERROR
     */
    public static final int PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR = PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS + 1;

    /**
     * PROGRESS:ABORT_RELIABLE_WRITE_START
     */
    public static final int PROGRESS_ABORT_RELIABLE_WRITE_START = PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR + 1;

    /**
     * For user defined progress
     */
    public static final int PROGRESS_FIRST_USER = PROGRESS_ABORT_RELIABLE_WRITE_START + 1;

    /**
     * create timeout message
     *
     * @param obj instance for {@link android.os.Handler#removeCallbacksAndMessages(Object)}
     * @return create timeout {@link Message} instance
     */
    @NonNull
    public static Message createTimeoutMessage(@NonNull Object obj) {
        Bundle bundle = new Bundle();
        bundle.putInt(KEY_NEXT_PROGRESS, PROGRESS_TIMEOUT);
        Message message = new Message();
        message.setData(bundle);
        message.obj = obj;
        return message;
    }

    /**
     * <p>
     * task progress
     * <p>
     * one of {@link #PROGRESS_INIT}
     * {@link #PROGRESS_FINISHED}
     * {@link #PROGRESS_TIMEOUT}
     * {@link #PROGRESS_CONNECT}
     * {@link #PROGRESS_DISCONNECT}
     * {@link #PROGRESS_CHARACTERISTIC_READ_START}
     * {@link #PROGRESS_CHARACTERISTIC_READ_SUCCESS}
     * {@link #PROGRESS_CHARACTERISTIC_READ_ERROR}
     * {@link #PROGRESS_CHARACTERISTIC_WRITE_START}
     * {@link #PROGRESS_CHARACTERISTIC_WRITE_SUCCESS}
     * {@link #PROGRESS_CHARACTERISTIC_WRITE_ERROR}
     * {@link #PROGRESS_DESCRIPTOR_READ_START}
     * {@link #PROGRESS_DESCRIPTOR_READ_SUCCESS}
     * {@link #PROGRESS_DESCRIPTOR_READ_ERROR}
     * {@link #PROGRESS_DESCRIPTOR_WRITE_SUCCESS}
     * {@link #PROGRESS_DESCRIPTOR_WRITE_SUCCESS}
     * {@link #PROGRESS_DESCRIPTOR_WRITE_ERROR}
     * </p>
     */
    protected int mCurrentProgress = PROGRESS_INIT;

    /**
     * task id
     */
    private final Integer mTaskId = hashCode();

    /**
     * create inital message
     *
     * @return task's initlal {@link Message} instance
     */
    @NonNull
    public abstract Message createInitialMessage();

    /**
     * do task
     *
     * @param message {@link Message} from {@link org.im97mori.ble.TaskHandler#handleMessage(Message)}
     * @return {@code true}:this task has been finished(or timeout), {@code false}:work in progress
     */
    public abstract boolean doProcess(@NonNull Message message);

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

}
