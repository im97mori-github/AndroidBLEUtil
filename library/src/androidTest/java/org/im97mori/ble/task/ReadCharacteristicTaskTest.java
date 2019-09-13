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

public class ReadCharacteristicTaskTest {

    @Test
    public void test_createReadCharacteristicMessage001() {
        ReadCharacteristicTask task = new ReadCharacteristicTask(null, null, null, null, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadCharacteristicMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        ReadCharacteristicTask task = new ReadCharacteristicTask(null, null, null, serviceUUID, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadCharacteristicMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        ReadCharacteristicTask task = new ReadCharacteristicTask(null, null, null, null, characteristicUUID, ReadCharacteristicTask.TIMEOUT_MILLIS, null);
        Message message = task.createInitialMessage();

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(task, message.obj);
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage001() {
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(null, null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getParcelable(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(serviceUUID, null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getParcelable(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(null, characteristicUUID, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getParcelable(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage004() {
        byte[] original = new byte[0];
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(null, null, original);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertArrayEquals(original, bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicErrorMessage001() {
        int status = new Random().nextInt();
        Message message = ReadCharacteristicTask.createReadCharacteristicErrorMessage(null, null, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicErrorMessage002() {
        UUID serviceUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = ReadCharacteristicTask.createReadCharacteristicErrorMessage(serviceUUID, null, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertEquals(serviceUUID, bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicErrorMessage003() {
        UUID characteristicUUID = UUID.randomUUID();
        int status = new Random().nextInt();
        Message message = ReadCharacteristicTask.createReadCharacteristicErrorMessage(null, characteristicUUID, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_SERVICE_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_SERVICE_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(characteristicUUID, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

}
