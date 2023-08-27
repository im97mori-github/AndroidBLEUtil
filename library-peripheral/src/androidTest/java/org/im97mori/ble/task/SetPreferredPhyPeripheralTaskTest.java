package org.im97mori.ble.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

import org.im97mori.ble.BLEServerCallbackDistributor;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BaseBLEServerCallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.peripheral.AbstractPeripheralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Random;

/**
 * @noinspection DataFlowIssue
 */
public class SetPreferredPhyPeripheralTaskTest extends AbstractPeripheralTest {

    @Test
    public void test_createInitialMessage_00001() {
        int txPhy = 1;
        int rxPhy = 2;
        int phyOptions = 3;
        SetPreferredPhyPeripheralTask task = new SetPreferredPhyPeripheralTask(null
                , null
                , null
                , null
                , txPhy
                , rxPhy
                , phyOptions
                , SetPreferredPhyPeripheralTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(SetPreferredPhyPeripheralTask.PROGRESS_SET_PREFERRED_PHY_START, bundle.getString(SetPreferredPhyPeripheralTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createSetPreferredPhySuccessMessage_00001() {
        int txPhy = 1;
        int rxPhy = 2;
        Message message = SetPreferredPhyPeripheralTask.createSetPreferredPhySuccessMessage(BLETestUtilsAndroid.MOCK_DEVICE_0, txPhy, rxPhy);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), bundle.getString(SetPreferredPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_TX_PHY));
        assertEquals(txPhy, bundle.getInt(SetPreferredPhyPeripheralTask.KEY_TX_PHY));
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_RX_PHY));
        assertEquals(rxPhy, bundle.getInt(SetPreferredPhyPeripheralTask.KEY_RX_PHY));
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_NEXT_PROGRESS));
        assertEquals(SetPreferredPhyPeripheralTask.PROGRESS_SET_PREFERRED_PHY_SUCCESS, bundle.getString(SetPreferredPhyPeripheralTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_createReadPhyErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = SetPreferredPhyPeripheralTask.createSetPreferredPhyErrorMessage(BLETestUtilsAndroid.MOCK_DEVICE_0, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), bundle.getString(SetPreferredPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(SetPreferredPhyPeripheralTask.KEY_STATUS));
        assertTrue(bundle.containsKey(SetPreferredPhyPeripheralTask.KEY_NEXT_PROGRESS));
        assertEquals(SetPreferredPhyPeripheralTask.PROGRESS_SET_PREFERRED_PHY_ERROR, bundle.getString(SetPreferredPhyPeripheralTask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_doProcess_00001() {
        int txPhy = 1;
        int rxPhy = 2;
        int phyOptions = 3;
        SetPreferredPhyPeripheralTask task = new SetPreferredPhyPeripheralTask(null
                , null
                , null
                , null
                , txPhy
                , rxPhy
                , phyOptions
                , SetPreferredPhyPeripheralTask.TIMEOUT_MILLIS
                , null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            int txPhy = 1;
            int rxPhy = 2;
            int phyOptions = 3;
            SetPreferredPhyPeripheralTask task = new SetPreferredPhyPeripheralTask(MOCK_BLE_SERVER_CONNECTION
                    , null
                    , null
                    , mockTaskHandler
                    , txPhy
                    , rxPhy
                    , phyOptions
                    , SetPreferredPhyPeripheralTask.TIMEOUT_MILLIS
                    , BLEServerCallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }

    }

    @Test
    public void test_cancel_00002() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            BaseBLEServerCallback callback = new BaseBLEServerCallback() {

                @Override
                public void onSetPreferredPhyFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int status, @Nullable Bundle argument) {
                    result.set(true);
                }
            };
            MOCK_BLE_SERVER_CONNECTION.attach(callback);

            int txPhy = 1;
            int rxPhy = 2;
            int phyOptions = 3;
            SetPreferredPhyPeripheralTask task = new SetPreferredPhyPeripheralTask(MOCK_BLE_SERVER_CONNECTION
                    , null
                    , null
                    , mockTaskHandler
                    , txPhy
                    , rxPhy
                    , phyOptions
                    , SetPreferredPhyPeripheralTask.TIMEOUT_MILLIS
                    , BLEServerCallbackDistributor.wrapArgument(null, null));
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
