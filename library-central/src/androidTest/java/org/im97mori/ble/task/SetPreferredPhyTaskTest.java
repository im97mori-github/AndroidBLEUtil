package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
public class SetPreferredPhyTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        SetPreferredPhyTask task = new SetPreferredPhyTask(null, null, null, 0, 0, 0, SetPreferredPhyTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(SetPreferredPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(SetPreferredPhyTask.PROGRESS_SET_PREFERRED_PHY_START, bundle.getString(SetPreferredPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createSetPreferredPhySuccessMessage_00001() {
        int txPhy = new Random().nextInt();
        int rxPhy = new Random().nextInt();
        Message message = SetPreferredPhyTask.createSetPreferredPhySuccessMessage(txPhy, rxPhy);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(SetPreferredPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(SetPreferredPhyTask.PROGRESS_SET_PREFERRED_PHY_SUCCESS, bundle.getString(SetPreferredPhyTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(SetPreferredPhyTask.KEY_TX_PHY));
        assertEquals(txPhy, bundle.getInt(SetPreferredPhyTask.KEY_TX_PHY));
        assertTrue(bundle.containsKey(SetPreferredPhyTask.KEY_RX_PHY));
        assertEquals(rxPhy, bundle.getInt(SetPreferredPhyTask.KEY_RX_PHY));
    }

    @Test
    @RequiresDevice
    public void test_createSetPreferredPhyErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = SetPreferredPhyTask.createSetPreferredPhyErrorMessage(status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(SetPreferredPhyTask.KEY_NEXT_PROGRESS));
        assertEquals(SetPreferredPhyTask.PROGRESS_SET_PREFERRED_PHY_ERROR, bundle.getString(SetPreferredPhyTask.KEY_NEXT_PROGRESS));
        assertTrue(bundle.containsKey(SetPreferredPhyTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(SetPreferredPhyTask.KEY_STATUS));
    }

    @Test
    @RequiresDevice
    public void test_doProcess_00001() {
        SetPreferredPhyTask task = new SetPreferredPhyTask(null, null, null, 0, 0, 0, SetPreferredPhyTask.TIMEOUT_MILLIS, null);
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

            SetPreferredPhyTask task = new SetPreferredPhyTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, 0, 0, 0, SetPreferredPhyTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
                public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
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

            SetPreferredPhyTask task = new SetPreferredPhyTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, 0, 0, 0, SetPreferredPhyTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
