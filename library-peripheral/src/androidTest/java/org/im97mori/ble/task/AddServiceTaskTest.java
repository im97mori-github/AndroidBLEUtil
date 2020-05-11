package org.im97mori.ble.task;

import android.bluetooth.BluetoothGattService;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class AddServiceTaskTest {

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
    public void test_createInitialMessage001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        AddServiceTask task = new AddServiceTask(MOCK_BLE_SERVER_CONNECTION
                , null
                , null
                , AddServiceTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_ADD_SERVICE, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createAddServiceSuccessMessage001() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(null, 0);
        Message message = AddServiceTask.createAddServiceSuccessMessage(bluetoothGattService);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(bluetoothGattService, message.obj);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_ADD_SERVICE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createAddServiceErrorMessage001() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(null, 0);
        int status = new Random().nextInt();
        Message message = AddServiceTask.createAddServiceErrorMessage(bluetoothGattService, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(bluetoothGattService, message.obj);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_ADD_SERVICE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
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

            AddServiceTask task = new AddServiceTask(new MockBLEServerConnection()
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

    @Test
    public void test_cancel002() {
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
                public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
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
