package org.im97mori.ble.task;

import android.os.Bundle;
import android.os.Message;

import org.junit.Test;

import java.util.Random;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class WriteDescriptorTaskTest {

    @Test
    public void test_createWriteDescriptorMessage001() {
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, null, null, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createWriteDescriptorMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, serviceUUID, null, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createWriteDescriptorMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, null, characteristicUUID, null, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createWriteDescriptorMessage004() {
        UUID descriptorUUID = UUID.randomUUID();
        WriteDescriptorTask task = new WriteDescriptorTask(null, null, null, null, null, descriptorUUID, null, WriteDescriptorTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createWriteDescriptorFinishedMessage001() {
        Message message = WriteDescriptorTask.createWriteDescriptorFinishedMessage(null, null, null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorFinishedMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        Message message = WriteDescriptorTask.createWriteDescriptorFinishedMessage(serviceUUID, null, null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorFinishedMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        Message message = WriteDescriptorTask.createWriteDescriptorFinishedMessage(null, characteristicUUID, null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorFinishedMessage004() {
        UUID descriptorUUID = UUID.randomUUID();
        Message message = WriteDescriptorTask.createWriteDescriptorFinishedMessage(null, null, descriptorUUID, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorFinishedMessage005() {
        byte[] values = new byte[0];
        Message message = WriteDescriptorTask.createWriteDescriptorFinishedMessage(null, null, null, values);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertArrayEquals(values, bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorErrorMessage001() {
        int status = new Random().nextInt();
        Message message = WriteDescriptorTask.createWriteDescriptorErrorMessage(null, null, null, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorErrorMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = WriteDescriptorTask.createWriteDescriptorErrorMessage(serviceUUID, null, null, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorErrorMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = WriteDescriptorTask.createWriteDescriptorErrorMessage(null, characteristicUUID, null, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createWriteDescriptorErrorMessage004() {
        UUID descriptorUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = WriteDescriptorTask.createWriteDescriptorErrorMessage(null, null, descriptorUUID, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertEquals(descriptorUUID, bundle.getSerializable(AbstractBLETask.KEY_DESCRIPTOR_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_WRITE_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

}
