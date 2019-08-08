package org.im97mori.ble.task;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.os.ParcelUuid;
import android.os.SystemClock;
import android.support.test.InstrumentationRegistry;
import android.text.format.DateUtils;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.BLELogUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ReadCharacteristicTaskTest {

    @Test
    public void test_createReadCharacteristicMessage001() {
        Message message = ReadCharacteristicTask.createReadCharacteristicMessage(null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertNull(message.obj);
    }

    @Test
    public void test_createReadCharacteristicMessage002() {
        UUID uuid = UUID.randomUUID();
        Message message = ReadCharacteristicTask.createReadCharacteristicMessage(uuid, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(uuid, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertNull(message.obj);
    }

    @Test
    public void test_createReadCharacteristicMessage003() {
        Object object = new Object();
        Message message = ReadCharacteristicTask.createReadCharacteristicMessage(null, object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    public void test_createReadCharacteristicMessage004() {
        UUID uuid = UUID.randomUUID();
        Object object = new Object();
        Message message = ReadCharacteristicTask.createReadCharacteristicMessage(uuid, object);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(uuid, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_START, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(object, message.obj);
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage001() {
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(null, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getParcelable(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage002() {
        UUID uuid = UUID.randomUUID();
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(uuid, null);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(uuid, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertNull(bundle.getParcelable(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage003() {
        byte[] original = new byte[0];
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(null, original);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertArrayEquals(original, bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicFinishedMessage004() {
        UUID uuid = UUID.randomUUID();
        byte[] original = new byte[0];
        Message message = ReadCharacteristicTask.createReadCharacteristicFinishedMessage(uuid, original);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(uuid, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_VALUES));
        assertArrayEquals(original, bundle.getByteArray(AbstractBLETask.KEY_VALUES));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_SUCCESS, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicErrorMessage001() {
        int status = 1;
        Message message = ReadCharacteristicTask.createReadCharacteristicErrorMessage(null, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertNull(bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    @Test
    public void test_createReadCharacteristicErrorMessage002() {
        UUID uuid = UUID.randomUUID();
        int status = 1;
        Message message = ReadCharacteristicTask.createReadCharacteristicErrorMessage(uuid, status);

        assertNotNull(message);
        Bundle bundle = message.getData();
        assertNotNull(bundle);
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertEquals(uuid, bundle.getSerializable(AbstractBLETask.KEY_CHARACTERISTIC_UUID));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_STATUS));
        assertEquals(status, bundle.getInt(AbstractBLETask.KEY_STATUS));
        assertTrue(bundle.containsKey(AbstractBLETask.KEY_NEXT_PROGRESS));
        assertEquals(AbstractBLETask.PROGRESS_CHARACTERISTIC_READ_ERROR, bundle.getInt(AbstractBLETask.KEY_NEXT_PROGRESS));
    }

    private BLEConnection mBLEConnection;

    @BeforeClass
    public void setup() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(Context.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Context context = InstrumentationRegistry.getContext();
        BluetoothManager bluetoothManager = (BluetoothManager) context.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> bluetoothDeviceSet = bluetoothAdapter.getBondedDevices();
        BluetoothDevice target = null;
        for (BluetoothDevice bluetoothDevice : bluetoothDeviceSet) {
            ParcelUuid[] parcelUuids = bluetoothDevice.getUuids();
            for (ParcelUuid parcelUuid : parcelUuids) {
                if (ReadChracteristicTestTask.GATT_SERVICE_UUID.equals(parcelUuid.getUuid())) {
                    target = bluetoothDevice;
                    break;
                }
            }
        }

        final AtomicBoolean isTimeout = new AtomicBoolean(false);
        mBLEConnection = new BLEConnection(InstrumentationRegistry.getContext(), target, new BLECallback() {
            @Override
            public void onBLEConnected(BluetoothDevice bluetoothDevice) {

            }

            @Override
            public void onBLEConnectTimeout(BluetoothDevice bluetoothDevice) {
                isTimeout.set(true);
            }

            @Override
            public void onBLEDisonnected(BluetoothDevice bluetoothDevice) {

            }

            @Override
            public void onCharacteristicReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {

            }

            @Override
            public void onCharacteristicReadFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, int status) {

            }

            @Override
            public void onCharacteristicReadTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, long timeout) {

            }

            @Override
            public void onCharacteristicWriteSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {

            }

            @Override
            public void onCharacteristicWriteFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, int status) {

            }

            @Override
            public void onCharacteristicWriteTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, long timeout) {

            }

            @Override
            public void onDescriptorReadSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, byte[] values) {

            }

            @Override
            public void onDescriptorReadFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, int status) {

            }

            @Override
            public void onDescriptorReadTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, long timeout) {

            }

            @Override
            public void onDescriptorWriteSuccess(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, byte[] values) {

            }

            @Override
            public void onDescriptorWriteFailed(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, int status) {

            }

            @Override
            public void onDescriptorWriteTimeout(BluetoothDevice bluetoothDevice, UUID characteristicUUID, UUID descriptorUUID, long timeout) {

            }

            @Override
            public void onCharacteristicNotified(BluetoothDevice bluetoothDevice, UUID characteristicUUID, byte[] values) {

            }
        });
        mBLEConnection.connect(ConnectTask.TIMEOUT_MILLIS);

        long end = SystemClock.elapsedRealtime() + ConnectTask.TIMEOUT_MILLIS;
        do {
            try {
                Thread.sleep(DateUtils.SECOND_IN_MILLIS);
            } catch (InterruptedException e) {
                BLELogUtils.stackLog(e);
            }
        } while (!mBLEConnection.isConnected() && !isTimeout.get() && SystemClock.elapsedRealtime() < end);

        if (!mBLEConnection.isConnected()) {
            mBLEConnection = null;
        }
    }

    @AfterClass
    public void tearDown() {
        if (mBLEConnection != null) {
            mBLEConnection.quit();
        }
    }
}
