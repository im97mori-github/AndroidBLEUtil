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
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class ReadPhyTaskTest {

    @Test
    public void test_createInitialMessage_00001() {
        ReadPhyTask task = new ReadPhyTask(null, null, null, ReadPhyTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_READ_PHY_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadPhySuccessMessage_00001() {
        int txPhy = new Random().nextInt();
        int rxPhy = new Random().nextInt();
        Message message = ReadPhyTask.createReadPhySuccessMessage(txPhy, rxPhy);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_READ_PHY_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_TX_PHY));
        assertEquals(txPhy, bundle.getInt(AbstractBLETask.KEY_TX_PHY));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_RX_PHY));
        assertEquals(rxPhy, bundle.getInt(AbstractBLETask.KEY_RX_PHY));
    }

    @Test
    public void test_createReadPhyErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = ReadPhyTask.createReadPhyErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_READ_PHY_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
    }

    @Test
    public void test_doProcess_00001() {
        ReadPhyTask task = new ReadPhyTask(null, null, null, ReadPhyTask.TIMEOUT_MILLIS, null);
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

            ReadPhyTask task = new ReadPhyTask(new MockBLEConnection(), null, mockTaskHandler, ReadPhyTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
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
        MockBLEConnection mockBleConnection = new MockBLEConnection();
        Looper looper = null;
        try {
            mockBleConnection.start();

            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onReadPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
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

            ReadPhyTask task = new ReadPhyTask(mockBleConnection, null, mockTaskHandler, ReadPhyTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
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
