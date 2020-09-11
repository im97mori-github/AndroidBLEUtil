package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallbackDistributer;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.MockBLEConnection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class BeginReliableWriteTaskTest {

    @Test
    public void test_createInitialMessage_00001() {
        BeginReliableWriteTask task = new BeginReliableWriteTask(null, null, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_BEGIN_RELIABLE_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_doProcess_00001() {
        BeginReliableWriteTask task = new BeginReliableWriteTask(null, null, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    public void test_cancel_00001() {
        Message message = Message.obtain();
        message.setData(Bundle.EMPTY);

        BeginReliableWriteTask task = new BeginReliableWriteTask(new MockBLEConnection(), null, BLECallbackDistributer.wrapArgument(null, null));
        task.cancel();
        assertTrue(task.doProcess(message));
    }

    @Test
    public void test_cancel_00002() {
        MockBLEConnection mockBleConnection = new MockBLEConnection();
        try {
            mockBleConnection.start();
            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                    result.set(true);
                }
            };
            mockBleConnection.attach(callback);

            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            BeginReliableWriteTask task = new BeginReliableWriteTask(mockBleConnection, null, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            mockBleConnection.quit();
        }
    }

}
