package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLEConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class DisconnectTaskTest {

    @Test
    public void test_createDisconnectMessage001() {
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
    public void test_doProcess001() {
        BLEConnection mockBleConnection = new BLEConnection(null, null, null) {
            @Override
            public boolean isConnected() {
                return false;
            }
        };

        DisconnectTask task = new DisconnectTask(mockBleConnection, null, BLEConstants.ErrorCodes.UNKNOWN, null);

        assertTrue(task.doProcess(null));
    }

}
