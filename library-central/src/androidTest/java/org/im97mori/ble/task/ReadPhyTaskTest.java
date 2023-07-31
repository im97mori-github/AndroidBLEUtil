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
public class ReadPhyTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        ReadPhyTask task = new ReadPhyTask(null, null, null, ReadPhyTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadPhyTask.PROGRESS_READ_PHY_START, bundle.getString(ReadPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createReadPhySuccessMessage_00001() {
        int txPhy = new Random().nextInt();
        int rxPhy = new Random().nextInt();
        Message message = ReadPhyTask.createReadPhySuccessMessage(txPhy, rxPhy);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadPhyTask.PROGRESS_READ_PHY_SUCCESS, bundle.getString(ReadPhyTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(ReadPhyTask.KEY_TX_PHY));
        assertEquals(txPhy, bundle.getInt(ReadPhyTask.KEY_TX_PHY));
        assertTrue(bundle.containsKey(ReadPhyTask.KEY_RX_PHY));
        assertEquals(rxPhy, bundle.getInt(ReadPhyTask.KEY_RX_PHY));
    }

    @Test
    @RequiresDevice
    public void test_createReadPhyErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = ReadPhyTask.createReadPhyErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadPhyTask.PROGRESS_READ_PHY_ERROR, bundle.getString(ReadPhyTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(ReadPhyTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(ReadPhyTask.KEY_STATUS));
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        ReadPhyTask task = new ReadPhyTask(null, null, null, ReadPhyTask.TIMEOUT_MILLIS, null);
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

            ReadPhyTask task = new ReadPhyTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, ReadPhyTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
                public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
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

            ReadPhyTask task = new ReadPhyTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, ReadPhyTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
