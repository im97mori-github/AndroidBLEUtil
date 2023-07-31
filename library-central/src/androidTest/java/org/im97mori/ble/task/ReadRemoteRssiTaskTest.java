package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLECallbackDistributor;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue */
public class ReadRemoteRssiTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        ReadRemoteRssiTask task = new ReadRemoteRssiTask(null, null, null, ReadRemoteRssiTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadRemoteRssiTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadRemoteRssiTask.PROGRESS_READ_REMOTE_RSSI_START, bundle.getString(ReadRemoteRssiTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createReadRemoteRssiSuccessMessage_00001() {
        int rssi = new Random().nextInt();
        Message message = ReadRemoteRssiTask.createReadRemoteRssiSuccessMessage(rssi);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadRemoteRssiTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadRemoteRssiTask.PROGRESS_READ_REMOTE_RSSI_SUCCESS, bundle.getString(ReadRemoteRssiTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(ReadRemoteRssiTask.KEY_RSSI));
        assertEquals(rssi, bundle.getInt(ReadRemoteRssiTask.KEY_RSSI));
    }

    @Test
    @RequiresDevice
    public void test_createReadRemoteRssiErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = ReadRemoteRssiTask.createReadRemoteRssiErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadRemoteRssiTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadRemoteRssiTask.PROGRESS_READ_REMOTE_RSSI_ERROR, bundle.getString(ReadRemoteRssiTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(ReadRemoteRssiTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(ReadRemoteRssiTask.KEY_STATUS));
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        ReadRemoteRssiTask task = new ReadRemoteRssiTask(null, null, null, ReadRemoteRssiTask.TIMEOUT_MILLIS, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ReadRemoteRssiTask task = new ReadRemoteRssiTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, ReadRemoteRssiTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

    @Test
    @RequiresDevice
    public void test_cancel_00002() {
        Looper looper = null;
        try {

            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onReadRemoteRssiFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                    result.set(true);
                }
            };
            MOCK_BLE_CONNECTION.attach(callback);

            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ReadRemoteRssiTask task = new ReadRemoteRssiTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, ReadRemoteRssiTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
