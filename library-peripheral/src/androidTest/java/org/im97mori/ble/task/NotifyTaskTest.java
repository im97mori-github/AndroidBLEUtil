package org.im97mori.ble.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLEServerCallbackDistributor;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BaseBLEServerCallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/** @noinspection DataFlowIssue*/
public class NotifyTaskTest extends AbstractPeripheralTest {

    @Test
    public void test_createInitialMessage_00001() {
        NotifyTask task = new NotifyTask(null
                , null
                , null
                , null
                , null
                , 1
                , null
                , 2
                , null
                , true
                , NotifyTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(NotifyTask.PROGRESS_NOTIFICATION_START, bundle.getString(NotifyTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    @Deprecated
    public void test_createNotificationSentSuccessMessage_00001() {
        Message message = NotifyTask.createNotificationSentSuccessMessage(BLETestUtilsAndroid.MOCK_DEVICE_0);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(NotifyTask.KEY_BLUETOOTH_DEVICE));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), bundle.getString(NotifyTask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(NotifyTask.KEY_NEXT_PROGRESS));
        assertEquals(NotifyTask.PROGRESS_NOTIFICATION_SUCCESS, bundle.getString(NotifyTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_createNotificationSentErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = NotifyTask.createNotificationSentErrorMessage(BLETestUtilsAndroid.MOCK_DEVICE_0, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(NotifyTask.KEY_BLUETOOTH_DEVICE));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), bundle.getString(NotifyTask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(NotifyTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(NotifyTask.KEY_STATUS));
        assertTrue(bundle.containsKey(NotifyTask.KEY_NEXT_PROGRESS));
        assertEquals(NotifyTask.PROGRESS_NOTIFICATION_ERROR, bundle.getString(NotifyTask.KEY_NEXT_PROGRESS));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_doProcess_00001() {
        NotifyTask task = new NotifyTask(null
                , null
                , null
                , null
                , null
                , 1
                , null
                , 2
                , null
                , true
                , NotifyTask.TIMEOUT_MILLIS
                , null);
        assertFalse(task.doProcess(new Message()));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            NotifyTask task = new NotifyTask(MOCK_BLE_SERVER_CONNECTION
                    , null
                    , null
                    , mockTaskHandler
                    , null
                    , 1
                    , null
                    , 2
                    , null
                    , false
                    , NotifyTask.TIMEOUT_MILLIS
                    , BLEServerCallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }

    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_cancel_00002() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            BaseBLEServerCallback callback = new BaseBLEServerCallback() {

                @Override
                public void onNotificationTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                    result.set(true);
                }
            };
            MOCK_BLE_SERVER_CONNECTION.attach(callback);

            AddServiceTask task = new AddServiceTask(MOCK_BLE_SERVER_CONNECTION
                    , mockTaskHandler
                    , null
                    , AddServiceTask.TIMEOUT_MILLIS
                    , BLEServerCallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
