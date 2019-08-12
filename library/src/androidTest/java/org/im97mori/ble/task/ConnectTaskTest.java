package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.TaskHandler;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ConnectTaskTest {

    @Test
    public void test_createConnectMessage001() {
        Message message = ConnectTask.createConnectMessage(null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CONNECT, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertNull(message.obj);
    }

    @Test
    public void test_createConnectMessage002() {
        Object object = new Object();
        Message message = ConnectTask.createConnectMessage(object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CONNECT, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    public void test_createConnectFinished001() {
        Message message = ConnectTask.createConnectFinished(null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_FINISHED, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertNull(message.obj);
    }

    @Test
    public void test_createConnectFinished002() {
        Object object = new Object();
        Message message = ConnectTask.createConnectFinished(object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_FINISHED, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    public void test_doProcess001() {
        BLEConnection mockBleConnection = new BLEConnection(null, null, null) {
            @Override
            public boolean isConnected() {
                return true;
            }
        };
        HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
        thread.start();
        Looper looper = thread.getLooper();
        TaskHandler mockTaskHandler = new TaskHandler(looper);

        ConnectTask task = new ConnectTask(mockBleConnection, mockTaskHandler, ConnectTask.TIMEOUT_MILLIS, null);

        assertTrue(task.doProcess(null));

        looper.quit();
    }

}
