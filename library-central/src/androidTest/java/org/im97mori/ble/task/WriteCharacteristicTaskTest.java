package org.im97mori.ble.task;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
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
import java.util.UUID;

/** @noinspection DataFlowIssue */
public class WriteCharacteristicTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        WriteCharacteristicTask task = new WriteCharacteristicTask(null
                , null
                , null
                , serviceUUID
                , null
                , characteristicUUID
                , null
                , null
                , BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT
                , WriteCharacteristicTask.TIMEOUT_MILLIS
                , null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, UUID.fromString(bundle.getString(WriteCharacteristicTask.KEY_SERVICE_UUID)));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, UUID.fromString(bundle.getString(WriteCharacteristicTask.KEY_CHARACTERISTIC_UUID)));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_NEXT_PROGRESS));
        assertEquals(WriteCharacteristicTask.PROGRESS_CHARACTERISTIC_WRITE_START, bundle.getString(WriteCharacteristicTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createWriteCharacteristicSuccessMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicInstanceId = 2;
        Message message = WriteCharacteristicTask.createWriteCharacteristicSuccessMessage(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, UUID.fromString(bundle.getString(WriteCharacteristicTask.KEY_SERVICE_UUID)));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_SERVICE_INSTANCE_ID));
        assertEquals(serviceInstanceId, bundle.getInt(WriteCharacteristicTask.KEY_SERVICE_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, UUID.fromString(bundle.getString(WriteCharacteristicTask.KEY_CHARACTERISTIC_UUID)));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertEquals(characteristicInstanceId, bundle.getInt(WriteCharacteristicTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_NEXT_PROGRESS));
        assertEquals(WriteCharacteristicTask.PROGRESS_CHARACTERISTIC_WRITE_SUCCESS, bundle.getString(WriteCharacteristicTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_createWriteCharacteristicErrorMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicInstanceId = 2;
        int status = new Random().nextInt();
        Message message = WriteCharacteristicTask.createWriteCharacteristicErrorMessage(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, UUID.fromString(bundle.getString(WriteCharacteristicTask.KEY_SERVICE_UUID)));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_SERVICE_INSTANCE_ID));
        assertEquals(serviceInstanceId, bundle.getInt(WriteCharacteristicTask.KEY_SERVICE_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, UUID.fromString(bundle.getString(WriteCharacteristicTask.KEY_CHARACTERISTIC_UUID)));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertEquals(characteristicInstanceId, bundle.getInt(WriteCharacteristicTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(WriteCharacteristicTask.KEY_STATUS));
        assertTrue(bundle.containsKey(WriteCharacteristicTask.KEY_NEXT_PROGRESS));
        assertEquals(WriteCharacteristicTask.PROGRESS_CHARACTERISTIC_WRITE_ERROR, bundle.getString(WriteCharacteristicTask.KEY_NEXT_PROGRESS));
    }

    /** @noinspection deprecation*/
    @Test
    @RequiresDevice
    @Deprecated
    public void test_doProcess_00001() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        WriteCharacteristicTask task = new WriteCharacteristicTask(null, null, null, serviceUUID, null, characteristicUUID, null, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null);
        assertFalse(task.doProcess(new Message()));
    }

    /** @noinspection deprecation*/
    @Test
    @RequiresDevice
    @Deprecated
    public void test_cancel_00001() {
        Looper looper = null;
        try {
            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            WriteCharacteristicTask task = new WriteCharacteristicTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, null, null, null, null, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteDescriptorTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
        } finally {
            if (looper != null) {
                looper.quit();
            }
        }
    }

    /** @noinspection deprecation*/
    @Test
    @RequiresDevice
    @Deprecated
    public void test_cancel_00002() {
        Looper looper = null;
        try {

            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, Bundle argument) {
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

            WriteCharacteristicTask task = new WriteCharacteristicTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, null, null, null, null, null, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteDescriptorTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
