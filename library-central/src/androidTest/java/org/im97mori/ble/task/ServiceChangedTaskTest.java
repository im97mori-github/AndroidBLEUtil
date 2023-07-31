package org.im97mori.ble.task;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

public class ServiceChangedTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        //noinspection DataFlowIssue
        ServiceChangedTask task = new ServiceChangedTask(null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.isEmpty());
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        ServiceChangedTask task = new ServiceChangedTask(MOCK_BLE_CONNECTION);
        assertTrue(task.doProcess(new Message()));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            ServiceChangedTask task = new ServiceChangedTask(MOCK_BLE_CONNECTION);
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
