package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLECallbackDistributor;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue */
public class DiscoverServiceTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        DiscoverServiceTask task = new DiscoverServiceTask(null, null, null, DiscoverServiceTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(DiscoverServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(DiscoverServiceTask.PROGRESS_DISCOVER_SERVICE_START, bundle.getString(DiscoverServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createServiceDiscoverSuccessMessage_00001() {
        Object object = new Object();
        Message message = DiscoverServiceTask.createDiscoverServiceSuccessMessage(object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(DiscoverServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(DiscoverServiceTask.PROGRESS_DISCOVER_SERVICE_SUCCESS, bundle.getString(DiscoverServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createServiceDiscoverErrorMessage_00001() {
        Object object = new Object();
        int status = new Random().nextInt();
        Message message = DiscoverServiceTask.createDiscoverServiceErrorMessage(object, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(DiscoverServiceTask.KEY_NEXT_PROGRESS));
        assertEquals(DiscoverServiceTask.PROGRESS_DISCOVER_SERVICE_ERROR, bundle.getString(DiscoverServiceTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(DiscoverServiceTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(DiscoverServiceTask.KEY_STATUS));
        assertEquals(object, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        DiscoverServiceTask task = new DiscoverServiceTask(null, null, null, DiscoverServiceTask.TIMEOUT_MILLIS, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    @RequiresDevice
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            DiscoverServiceTask task = new DiscoverServiceTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, DiscoverServiceTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

    @Test
    @RequiresDevice
    public void test_cancel_00002() {
        Looper looper = null;
        try {

            BaseBLECallback callback = new BaseBLECallback() {
                @Override
                public void onDiscoverServiceFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, Bundle argument) {
                    result.set(true);
                }
            };
            MOCK_BLE_CONNECTION.attach(callback);

            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            DiscoverServiceTask task = new DiscoverServiceTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, DiscoverServiceTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

}
