package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLECallbackDistributer;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class BeginReliableWriteTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
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
    @RequiresDevice
    public void test_doProcess_00001() {
        BeginReliableWriteTask task = new BeginReliableWriteTask(null, null, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00001() {
        Message message = Message.obtain();
        message.setData(Bundle.EMPTY);

        BeginReliableWriteTask task = new BeginReliableWriteTask(MOCK_BLE_CONNECTION, null, BLECallbackDistributer.wrapArgument(null, null));
        task.cancel();
        assertTrue(task.doProcess(message));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00002() {
        BaseBLECallback callback = new BaseBLECallback() {

            @Override
            public void onBeginReliableWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
                result.set(true);
            }
        };
        MOCK_BLE_CONNECTION.attach(callback);

        Message message = Message.obtain();
        message.setData(Bundle.EMPTY);

        BeginReliableWriteTask task = new BeginReliableWriteTask(MOCK_BLE_CONNECTION, null, BLECallbackDistributer.wrapArgument(null, null));
        task.cancel();
        assertTrue(task.doProcess(message));
        assertTrue(callback.result.get());
    }

}
