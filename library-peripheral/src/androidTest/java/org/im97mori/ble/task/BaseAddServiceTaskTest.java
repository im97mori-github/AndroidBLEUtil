package org.im97mori.ble.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;
import androidx.test.filters.Suppress;

import org.im97mori.ble.BLEServerCallbackDistributor;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BaseBLEServerCallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Random;

/** @noinspection DataFlowIssue*/
@Suppress
public class BaseAddServiceTaskTest extends AbstractPeripheralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
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
        assertEquals(AddServiceTask.PROGRESS_ADD_SERVICE_START, bundle.getString(AddServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createAddServiceSuccessMessage_00001() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(null, 0);
        Message message = AddServiceTask.createAddServiceSuccessMessage(bluetoothGattService);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(bluetoothGattService, message.obj);
        assertTrue(bundle.containsKey(AddServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(AddServiceTask.PROGRESS_ADD_SERVICE_SUCCESS, bundle.getString(AddServiceTask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createAddServiceErrorMessage_00001() {
        BluetoothGattService bluetoothGattService = new BluetoothGattService(null, 0);
        int status = new Random().nextInt();
        Message message = AddServiceTask.createAddServiceErrorMessage(bluetoothGattService, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(bluetoothGattService, message.obj);
        assertTrue(bundle.containsKey(AddServiceTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AddServiceTask.KEY_STATUS));
        assertTrue(bundle.containsKey(AddServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(AddServiceTask.PROGRESS_ADD_SERVICE_ERROR, bundle.getString(AddServiceTask.KEY_NEXT_PROGRESS));
    }

    /** @noinspection deprecation*/
    @Test
    @Deprecated
    public void test_doProcess_00001() {
        AddServiceTask task = new AddServiceTask(MOCK_BLE_SERVER_CONNECTION
                , null
                , null
                , AddServiceTask.TIMEOUT_MILLIS
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
                public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
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
            assertTrue(callback.result.get());
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
