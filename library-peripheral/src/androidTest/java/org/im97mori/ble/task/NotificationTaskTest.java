package org.im97mori.ble.task;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallbackDistributer;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BaseBLEServerCallback;
import org.im97mori.ble.MockBLEServerConnection;
import org.im97mori.ble.TaskHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class NotificationTaskTest {

    private MockBLEServerConnection MOCK_BLE_SERVER_CONNECTION;

    @Before
    public void setup() {
        MOCK_BLE_SERVER_CONNECTION = new MockBLEServerConnection();
    }

    @After
    public void tearDown() {
        if (MOCK_BLE_SERVER_CONNECTION != null) {
            MOCK_BLE_SERVER_CONNECTION.quit();
            MOCK_BLE_SERVER_CONNECTION = null;
        }
    }

    @Test
    public void test_createInitialMessage_00001() {
        NotificationTask task = new NotificationTask(null
                , null
                , null
                , null
                , null
                , 1
                , null
                , 2
                , null
                , true
                , NotificationTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_NOTIFICATION_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createNotificationSentSuccessMessage_00001() {
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
    public void test_createNotificationSentErrorMessage_00001() {
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
    public void test_doProcess_00001() {
        NotificationTask task = new NotificationTask(null
                , null
                , null
                , null
                , null
                , 1
                , null
                , 2
                , null
                , true
                , NotificationTask.TIMEOUT_MILLIS
                , null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            NotificationTask task = new NotificationTask(MOCK_BLE_SERVER_CONNECTION
                    , null
                    , null
                    , mockTaskHandler
                    , null
                    , 1
                    , null
                    , 2
                    , null
                    , false
                    , NotificationTask.TIMEOUT_MILLIS
                    , BLEServerCallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }

    }

    @Test
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
                    , BLEServerCallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
