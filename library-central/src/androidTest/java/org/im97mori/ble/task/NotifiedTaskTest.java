package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import androidx.test.filters.RequiresDevice;

/** @noinspection DataFlowIssue*/
public class NotifiedTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        NotifiedTask task = new NotifiedTask(null
                , null
                , null
                , null
                , null
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.isEmpty());
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        NotifiedTask task = new NotifiedTask(MOCK_BLE_CONNECTION
                , null
                , null
                , null
                , null
                , null);
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

            NotifiedTask task = new NotifiedTask(MOCK_BLE_CONNECTION
                    , null
                    , null
                    , null
                    , null
                    , null);
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
