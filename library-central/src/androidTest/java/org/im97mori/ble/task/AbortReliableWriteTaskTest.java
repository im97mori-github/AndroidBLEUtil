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
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue*/
public class AbortReliableWriteTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        AbortReliableWriteTask task = new AbortReliableWriteTask(null, null, null, AbortReliableWriteTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbortReliableWriteTask.KEY_NEXT_PROGRESS));
        assertEquals(AbortReliableWriteTask.PROGRESS_ABORT_RELIABLE_WRITE_START, bundle.getString(AbortReliableWriteTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    /** @noinspection deprecation*/
    @Test
    @RequiresDevice
    @Deprecated
    public void test_doProcess_00001() {
        AbortReliableWriteTask task = new AbortReliableWriteTask(null, null, null, AbortReliableWriteTask.TIMEOUT_MILLIS, null);
        assertFalse(task.doProcess(new Message()));
    }

    /** @noinspection deprecation*/
    @Test
    @RequiresDevice
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

            AbortReliableWriteTask task = new AbortReliableWriteTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, AbortReliableWriteTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
    @RequiresDevice
    @Deprecated
    public void test_cancel_00002() {
        Looper looper = null;
        try {

            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onAbortReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
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

            AbortReliableWriteTask task = new AbortReliableWriteTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, AbortReliableWriteTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
