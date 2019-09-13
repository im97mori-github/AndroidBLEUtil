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

public class ReadDescriptorTaskTest {

    @Test
    public void test_createReadDescriptorMessage001() {
        ReadDescriptorTask task = new ReadDescriptorTask(null, null, null, null, null, null, ReadDescriptorTask.TIMEOUT_MILLIS, null);
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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadDescriptorMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        ReadDescriptorTask task = new ReadDescriptorTask(null, null, null, serviceUUID, null, null, ReadDescriptorTask.TIMEOUT_MILLIS, null);
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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadDescriptorMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        ReadDescriptorTask task = new ReadDescriptorTask(null, null, null, null, characteristicUUID, null, ReadDescriptorTask.TIMEOUT_MILLIS, null);
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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadDescriptorMessage004() {
        UUID descriptorUUID = UUID.randomUUID();
        ReadDescriptorTask task = new ReadDescriptorTask(null, null, null, null, null, descriptorUUID, ReadDescriptorTask.TIMEOUT_MILLIS, null);
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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadDescriptorFinishedMessage001() {
        Message message = ReadDescriptorTask.createReadDescriptorFinishedMessage(null, null, null, null);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorFinishedMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        Message message = ReadDescriptorTask.createReadDescriptorFinishedMessage(serviceUUID, null, null, null);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorFinishedMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        Message message = ReadDescriptorTask.createReadDescriptorFinishedMessage(null, characteristicUUID, null, null);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorFinishedMessage004() {
        UUID descriptorUUID = UUID.randomUUID();
        Message message = ReadDescriptorTask.createReadDescriptorFinishedMessage(null, null, descriptorUUID, null);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorFinishedMessage005() {
        byte[] values = new byte[0];
        Message message = ReadDescriptorTask.createReadDescriptorFinishedMessage(null, null, null, values);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorErrorMessage001() {
        int status = new Random().nextInt();
        Message message = ReadDescriptorTask.createReadDescriptorErrorMessage(null, null, null, status);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorErrorMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = ReadDescriptorTask.createReadDescriptorErrorMessage(serviceUUID, null, null, status);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorErrorMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = ReadDescriptorTask.createReadDescriptorErrorMessage(null, characteristicUUID, null, status);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadDescriptorErrorMessage004() {
        UUID descriptorUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = ReadDescriptorTask.createReadDescriptorErrorMessage(null, null, descriptorUUID, status);

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
        assertEquals(AbstractBLETask.PROGRESS_DESCRIPTOR_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

}
