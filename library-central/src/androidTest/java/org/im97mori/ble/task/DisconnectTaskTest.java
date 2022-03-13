package org.im97mori.ble.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLECallbackDistributor;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

@SuppressWarnings({"ConstantConditions", "unused"})
public class DisconnectTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        DisconnectTask task = new DisconnectTask(null, null, DisconnectTask.STATUS_MANUAL_DISCONNECT, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(DisconnectTask.KEY_NEXT_PROGRESS));
        assertEquals(DisconnectTask.PROGRESS_DISCONNECT, bundle.getString(DisconnectTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);
        DisconnectTask task = new DisconnectTask(MOCK_BLE_CONNECTION, null, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00101() {
        MOCK_BLE_CONNECTION.setConnected(false);
        DisconnectTask task = new DisconnectTask(MOCK_BLE_CONNECTION, null, null);

        assertTrue(task.doProcess(null));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00001() {
        MOCK_BLE_CONNECTION.setConnected(true);

        Message message = Message.obtain();
        message.setData(Bundle.EMPTY);

        DisconnectTask task = new DisconnectTask(MOCK_BLE_CONNECTION, null, BLECallbackDistributor.wrapArgument(null, null));
        task.cancel();
        assertTrue(task.doProcess(message));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00002() {
        MOCK_BLE_CONNECTION.setConnected(true);

        BaseBLECallback callback = new BaseBLECallback() {
            @Override
            public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                result.set(true);
            }
        };
        MOCK_BLE_CONNECTION.attach(callback);

        Message message = Message.obtain();
        message.setData(Bundle.EMPTY);

        DisconnectTask task = new DisconnectTask(MOCK_BLE_CONNECTION, null, BLECallbackDistributor.wrapArgument(null, null));
        task.cancel();
        assertTrue(task.doProcess(message));
        assertTrue(callback.result.get());
    }
}
