package org.im97mori.ble.task;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattServer;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BaseBLEServerCallback;
import org.im97mori.ble.TaskHandler;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class NotificationTaskTest {

    @Test
    public void test_createInitialMessage001() {
        NotificationTask task = new NotificationTask(null, null, null, null, null, null, null, true, NotificationTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createNotificationSentSuccessMessage001() {
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        Message message = NotificationTask.createNotificationSentSuccessMessage(bluetoothDevice);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
        assertEquals(bluetoothDevice, bundle.getParcelable(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createNotificationSentErrorMessage001() {
        BluetoothDevice bluetoothDevice = BluetoothAdapter.getDefaultAdapter().getRemoteDevice("00:11:22:33:AA:BB");
        int status = new Random().nextInt();
        Message message = NotificationTask.createNotificationSentErrorMessage(bluetoothDevice, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
        assertEquals(bluetoothDevice, bundle.getParcelable(AbstractBLETask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_cancel001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            NotificationTask task = new NotificationTask(new BaseBLEServerCallback(), null, null, null, null, null, null, false, NotificationTask.TIMEOUT_MILLIS, null);
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

    @Test
    public void test_cancel002() {
        Looper looper = null;
        try {
            BaseBLEServerCallback callback = new BaseBLEServerCallback() {

                @Override
                public void onNotificationFailed(@NonNull Integer taskId, @NonNull BluetoothGattServer bluetoothGattServer, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, @NonNull UUID characteristicUUID, int status, @Nullable Bundle argument) {
                    result.set(true);
                }
            };

            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            NotificationTask task = new NotificationTask(callback, null, null, null, null, null, null, false, NotificationTask.TIMEOUT_MILLIS, null);
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
