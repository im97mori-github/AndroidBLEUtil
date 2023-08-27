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

import org.im97mori.ble.BLECallbackDistributor;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Random;

/** @noinspection DataFlowIssue */
public class ExecuteReliableWriteTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(null, null, null, ExecuteReliableWriteTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ExecuteReliableWriteTask.KEY_NEXT_PROGRESS));
        assertEquals(ExecuteReliableWriteTask.PROGRESS_EXECUTE_RELIABLE_WRITE_START, bundle.getString(ExecuteReliableWriteTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createExecuteReliableWriteSuccessMessage_00001() {
        Message message = ExecuteReliableWriteTask.createExecuteReliableWriteSuccessMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ExecuteReliableWriteTask.KEY_NEXT_PROGRESS));
        assertEquals(ExecuteReliableWriteTask.PROGRESS_EXECUTE_RELIABLE_WRITE_SUCCESS, bundle.getString(ExecuteReliableWriteTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_createWriteCharacteristicErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = ExecuteReliableWriteTask.createExecuteReliableWriteErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ExecuteReliableWriteTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(ExecuteReliableWriteTask.KEY_STATUS));
        assertTrue(bundle.containsKey(ExecuteReliableWriteTask.KEY_NEXT_PROGRESS));
        assertEquals(ExecuteReliableWriteTask.PROGRESS_EXECUTE_RELIABLE_WRITE_ERROR, bundle.getString(ExecuteReliableWriteTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(null, null, null, ExecuteReliableWriteTask.TIMEOUT_MILLIS, null);
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

            ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, ExecuteReliableWriteTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
                public void onExecuteReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
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

            ExecuteReliableWriteTask task = new ExecuteReliableWriteTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, ExecuteReliableWriteTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
