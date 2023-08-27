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
public class ReadPhyPeripheralTaskTest extends AbstractPeripheralTest {

    @Test
    public void test_createInitialMessage_00001() {
        ReadPhyPeripheralTask task = new ReadPhyPeripheralTask(null
                , null
                , null
                , null
                , ReadPhyPeripheralTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertEquals(ReadPhyPeripheralTask.PROGRESS_READ_PHY_START, bundle.getString(ReadPhyPeripheralTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createReadPhySuccessMessage_00001() {
        int txPhy = 1;
        int rxPhy = 2;
        Message message = ReadPhyPeripheralTask.createReadPhySuccessMessage(BLETestUtilsAndroid.MOCK_DEVICE_0, txPhy, rxPhy);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), bundle.getString(ReadPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_TX_PHY));
        assertEquals(txPhy, bundle.getInt(ReadPhyPeripheralTask.KEY_TX_PHY));
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_RX_PHY));
        assertEquals(rxPhy, bundle.getInt(ReadPhyPeripheralTask.KEY_RX_PHY));
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadPhyPeripheralTask.PROGRESS_READ_PHY_SUCCESS, bundle.getString(ReadPhyPeripheralTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_createReadPhyErrorMessage_00001() {
        int status = new Random().nextInt();
        Message message = ReadPhyPeripheralTask.createReadPhyErrorMessage(BLETestUtilsAndroid.MOCK_DEVICE_0, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertEquals(BLETestUtilsAndroid.MOCK_DEVICE_0.getAddress(), bundle.getString(ReadPhyPeripheralTask.KEY_BLUETOOTH_DEVICE));
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(ReadPhyPeripheralTask.KEY_STATUS));
        assertTrue(bundle.containsKey(ReadPhyPeripheralTask.KEY_NEXT_PROGRESS));
        assertEquals(ReadPhyPeripheralTask.PROGRESS_READ_PHY_ERROR, bundle.getString(ReadPhyPeripheralTask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_doProcess_00001() {
        ReadPhyPeripheralTask task = new ReadPhyPeripheralTask(null
                , null
                , null
                , null
                , ReadPhyPeripheralTask.TIMEOUT_MILLIS
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

            ReadPhyPeripheralTask task = new ReadPhyPeripheralTask(MOCK_BLE_SERVER_CONNECTION
                    , null
                    , null
                    , mockTaskHandler
                    , ReadPhyPeripheralTask.TIMEOUT_MILLIS
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
                public void onPhyReadFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int status, @Nullable Bundle argument) {
                    result.set(true);
                }
            };
            MOCK_BLE_SERVER_CONNECTION.attach(callback);

            ReadPhyPeripheralTask task = new ReadPhyPeripheralTask(MOCK_BLE_SERVER_CONNECTION
                    , null
                    , null
                    , mockTaskHandler
                    , ReadPhyPeripheralTask.TIMEOUT_MILLIS
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
