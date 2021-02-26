package org.im97mori.ble.task;

import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallbackDistributer;
import org.im97mori.ble.BaseBLECallback;
import org.im97mori.ble.MockBLEConnection;
import org.im97mori.ble.TaskHandler;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class WriteDescriptorTaskTest {

    @Test
    public void test_createInitialMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        UUID descriptorUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, serviceUUID, null, characteristicUUID, null, descriptorUUID, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createWriteDescriptorSuccessMessage_00001() {
        UUID serviceUUID = UUID.randomUUID();
        int serviceInstanceId = 1;
        UUID characteristicUUID = UUID.randomUUID();
        int characteristicInstanceId = 2;
        UUID descriptorUUID = UUID.randomUUID();
        int descriptorInstanceId = 3;
        byte[] values = new byte[0];
        Message message = WriteDescriptorTask.createWriteDescriptorSuccessMessage(serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceInstanceId, bundle.getInt(AbstractBLETask.KEY_SERVICE_INSTANCE_ID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertEquals(characteristicInstanceId, bundle.getInt(AbstractBLETask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertEquals(descriptorInstanceId, bundle.getInt(AbstractBLETask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertArrayEquals(values, bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
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
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_INSTANCE_ID));
        assertEquals(serviceInstanceId, bundle.getInt(AbstractBLETask.KEY_SERVICE_INSTANCE_ID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertEquals(characteristicInstanceId, bundle.getInt(AbstractBLETask.KEY_CHARACTERISTIC_INSTANCE_ID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertEquals(descriptorInstanceId, bundle.getInt(AbstractBLETask.KEY_DESCRIPTOR_INSTANCE_ID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_doProcess_00001() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        UUID descriptorUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, serviceUUID, null, characteristicUUID, null, descriptorUUID, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        assertFalse(task.doProcess(new Message()));
    }

    @Test
    public void test_cancel_00001() {
        MockBLEConnection mockBleConnection = new MockBLEConnection();
        Looper looper = null;
        try {
            mockBleConnection.start();

            BaseBLECallback callback = new BaseBLECallback() {

                @Override
                public void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, Bundle argument) {
                    result.set(true);
                }
            };
            mockBleConnection.attach(callback);

            HandlerThread thread = new HandlerThread(this.getClass().getSimpleName());
            thread.start();
            looper = thread.getLooper();
            TaskHandler mockTaskHandler = new TaskHandler(looper);
            Message message = Message.obtain();
            message.setData(Bundle.EMPTY);

            WriteDescriptorTask task = new WriteDescriptorTask(mockBleConnection, null, mockTaskHandler, null, null, null, null, null, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, BLECallbackDistributer.wrapArgument(null, null));
            task.cancel();
            assertTrue(task.doProcess(message));
            assertTrue(callback.result.get());
        } finally {
            if (looper != null) {
                looper.quit();
            }
            mockBleConnection.quit();
        }

    }

}
