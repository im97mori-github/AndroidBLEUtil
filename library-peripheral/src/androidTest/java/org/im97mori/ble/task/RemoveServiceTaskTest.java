package org.im97mori.ble.task;

import android.bluetooth.BluetoothGattService;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLEServerCallbackDistributer;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BaseBLEServerCallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class RemoveServiceTaskTest extends AbstractPeripherallTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        MOCK_BLE_SERVER_CONNECTION.start();
        RemoveServiceTask task = new RemoveServiceTask(MOCK_BLE_SERVER_CONNECTION
                , null
                , null
                , RemoveServiceTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(AbstractBLETask.PROGRESS_REMOVE_SERVICE, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_doProcess_00001() {
        RemoveServiceTask task = new RemoveServiceTask(MOCK_BLE_SERVER_CONNECTION
                , null
                , null
                , RemoveServiceTask.TIMEOUT_MILLIS
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

            RemoveServiceTask task = new RemoveServiceTask(MOCK_BLE_SERVER_CONNECTION
                    , mockTaskHandler
                    , null
                    , RemoveServiceTask.TIMEOUT_MILLIS
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
                public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
                    result.set(true);
                }

            };
            MOCK_BLE_SERVER_CONNECTION.attach(callback);

            RemoveServiceTask task = new RemoveServiceTask(MOCK_BLE_SERVER_CONNECTION
                    , mockTaskHandler
                    , null
                    , RemoveServiceTask.TIMEOUT_MILLIS
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
