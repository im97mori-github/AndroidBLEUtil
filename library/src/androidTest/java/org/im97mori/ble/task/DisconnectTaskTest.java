package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.Message;

import org.im97mori.ble.BLEConnection;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class DisconnectTaskTest {

    @Test
    public void test_createDisconnectMessage001() {
        Message message = DisconnectTask.createDisconnectMessage(null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DISCONNECT, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertNull(message.obj);
    }

    @Test
    public void test_createDisconnectMessage002() {
        Object object = new Object();
        Message message = DisconnectTask.createDisconnectMessage(object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DISCONNECT, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    public void test_doProcess001() {
        BLEConnection mockBleConnection = new BLEConnection(null, null, null) {
            @Override
            public boolean isConnected() {
                return false;
            }
        };

        DisconnectTask task = new DisconnectTask(mockBleConnection, null);

        assertTrue(task.doProcess(null));
    }

}
