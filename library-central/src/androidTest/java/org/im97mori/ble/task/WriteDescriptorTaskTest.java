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

import org.im97mori.ble.BLECallbackDistributor;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.TaskHandler;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

/** @noinspection DataFlowIssue */
public class WriteDescriptorTaskTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_createInitialMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        UUID descriptorUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, serviceUUID, null, characteristicUUID, null, descriptorUUID, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_CHARACTERISTIC_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_DESCRIPTOR_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_NEXT_PROGRESS));
        assertEquals(WriteDescriptorTask.PROGRESS_DESCRIPTOR_WRITE_START, bundle.getString(WriteDescriptorTask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    @RequiresDevice
    public void test_createWriteDescriptorSuccessMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicInstanceId = 2;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorInstanceId = 3;
        Message message = WriteDescriptorTask.createWriteDescriptorSuccessMessage(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_SERVICE_UUID)));
        assertEquals(serviceInstanceId, bundle.getInt(WriteDescriptorTask.KEY_SERVICE_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_CHARACTERISTIC_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertEquals(characteristicInstanceId, bundle.getInt(WriteDescriptorTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_DESCRIPTOR_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertEquals(descriptorInstanceId, bundle.getInt(WriteDescriptorTask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_NEXT_PROGRESS));
        assertEquals(WriteDescriptorTask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getString(WriteDescriptorTask.KEY_NEXT_PROGRESS));
    }

    @Test
    @RequiresDevice
    public void test_createWriteDescriptorErrorMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicInstanceId = 2;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorInstanceId = 3;
        int status = new Random().nextInt();
        Message message = WriteDescriptorTask.createWriteDescriptorErrorMessage(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_SERVICE_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_SERVICE_INSTANCE_ID));
        assertEquals(serviceInstanceId, bundle.getInt(WriteDescriptorTask.KEY_SERVICE_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_CHARACTERISTIC_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertEquals(characteristicInstanceId, bundle.getInt(WriteDescriptorTask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, UUID.fromString(bundle.getString(WriteDescriptorTask.KEY_DESCRIPTOR_UUID)));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertEquals(descriptorInstanceId, bundle.getInt(WriteDescriptorTask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_STATUS));
        assertEquals(status, bundle.getInt(WriteDescriptorTask.KEY_STATUS));
        assertTrue(bundle.containsKey(WriteDescriptorTask.KEY_NEXT_PROGRESS));
        assertEquals(WriteDescriptorTask.PROGRESS_DESCRIPTOR_WRITE_ERROR, bundle.getString(WriteDescriptorTask.KEY_NEXT_PROGRESS));
    }

    /** @noinspection deprecation*/
    @Test
    @RequiresDevice
    @Deprecated
    public void test_doProcess_00001() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        UUID descriptorUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, serviceUUID, null, characteristicUUID, null, descriptorUUID, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
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

            WriteDescriptorTask task = new WriteDescriptorTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, null, null, null, null, null, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
                public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, Bundle argument) {
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

            WriteDescriptorTask task = new WriteDescriptorTask(MOCK_BLE_CONNECTION, null, mockTaskHandler, null, null, null, null, null, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, BLECallbackDistributor.wrapArgument(null, null));
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
