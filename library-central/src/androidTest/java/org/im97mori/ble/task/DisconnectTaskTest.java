package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.Message;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLECallbackDistributer;
import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.MockBLEConnection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class DisconnectTaskTest {

    @Test
    public void test_createInitialMessage_00001() {
        DisconnectTask task = new DisconnectTask(null, null, BLEConstants.ErrorCodes.UNKNOWN, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DISCONNECT, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_doProcess_00001() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        DisconnectTask task = new DisconnectTask(mockBleConnection, null, BLEConstants.ErrorCodes.UNKNOWN, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    public void test_doProcess_00101() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return false;
            }
        };

        DisconnectTask task = new DisconnectTask(mockBleConnection, null, BLEConstants.ErrorCodes.UNKNOWN, null);

        assertTrue(task.doProcess(null));
    }

    @Test
    public void test_cancel_00001() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };

        Message message = Message.obtain();
        message.setData(Bundle.EMPTY);

        DisconnectTask task = new DisconnectTask(mockBleConnection, null, BLEConstants.ErrorCodes.UNKNOWN, BLECallbackDistributer.wrapArgument(null, null));
        task.cancel();
        assertTrue(task.doProcess(message));
    }

    @Test
    public void test_cancel_00002() {
        MockBLEConnection mockBleConnection = new MockBLEConnection() {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        try {
            mockBleConnection.start();

            BaseBLECallback callback = new BaseBLECallback() {
                @Override
                public void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                    result.set(true);
                }
            };
            mockBleConnection.attach(callback);

            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            DisconnectTask task = new DisconnectTask(mockBleConnection, null, BLEConstants.ErrorCodes.UNKNOWN, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            mockBleConnection.quit();
        }
    }

}
