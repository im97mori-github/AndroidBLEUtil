package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallbackDistributer;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.MockBLEConnection;
import org.im97mori.ble.TaskHandler;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class ExecuteReliableWriteTaskTest {

    @Test
    public void test_createInitialMessage001() {
        ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(null, null, null, ExecuteReliableWriteTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_EXECUTE_RELIABLE_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createExecuteReliableWriteSuccessMessage001() {
        Message message = ExecuteReliableWriteTask.createExecuteReliableWriteSuccessMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteCharacteristicErrorMessage001() {
        int status = new Random().nextInt();
        Message message = ExecuteReliableWriteTask.createExecuteReliableWriteErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
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

            ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(new MockBLEConnection(), null, mockTaskHandler, ExecuteReliableWriteTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
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
        MockBLEConnection mockBleConnection = new MockBLEConnection();
        Looper looper = null;
        try {
            mockBleConnection.start();

            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                    result.set(true);
                }
            };
            mockBleConnection.attach(callback);

            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(mockBleConnection, null, mockTaskHandler, ExecuteReliableWriteTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            if (looper != null) {
                looper.quit();
            }
            mockBleConnection.quit();
        }
    }
}