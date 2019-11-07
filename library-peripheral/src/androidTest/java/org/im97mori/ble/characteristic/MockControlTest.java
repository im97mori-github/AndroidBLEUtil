package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;

import org.im97mori.ble.BLEConstants;
import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MockControlTest {

    @Test
    public void test001() {
        byte[] data = new byte[56];

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0, 0), result1.getServiceUUID());
        assertEquals(new UUID(0, 0), result1.getCharacteristicUUID());
        assertEquals(new UUID(0, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_CHARACTERISTIC, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(new byte[0], result1.getValue());
    }

    @Test
    public void test002() {
        byte[] data = new byte[57];
        data[0] = 1;
        data[16] = 2;
        data[32] = 3;
        data[48] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[49] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[50] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[51] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[52] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[53] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[54] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[56] = 4;

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(1, 0), result1.getServiceUUID());
        assertEquals(new UUID(2, 0), result1.getCharacteristicUUID());
        assertEquals(new UUID(3, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_DESCRIPTOR, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(Arrays.copyOfRange(data, 56, 57), result1.getValue());
    }

    @Test
    public void test003() {
        UUID serviceUUID = UUID.randomUUID();
        UUID characteristicUUID = UUID.randomUUID();
        UUID descriptorUUID = UUID.randomUUID();
        byte[] data = new byte[57];
        data[0] = 1;
        data[16] = 2;
        data[32] = 3;
        data[48] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[49] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[50] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[51] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[52] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[53] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[54] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[56] = 4;

        MockControl result1 = new MockControl(serviceUUID, characteristicUUID, descriptorUUID, MockControl.TARGET_TYPE_NOTIFICATION, BLEConstants.ErrorCodes.UNKNOWN, data);
        assertEquals(serviceUUID, result1.getServiceUUID());
        assertEquals(characteristicUUID, result1.getCharacteristicUUID());
        assertEquals(descriptorUUID, result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_NOTIFICATION, result1.getTargetType());
        assertEquals(BLEConstants.ErrorCodes.UNKNOWN, result1.getStatus());
        assertArrayEquals(data, result1.getValue());
    }

    @Test
    public void test004() {
        byte[] data = new byte[57];
        data[0] = 1;
        data[16] = 2;
        data[32] = 3;
        data[48] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[49] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[50] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[51] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[52] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[53] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[54] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[56] = 4;

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test005() {
        byte[] data = new byte[57];
        data[0] = 1;
        data[16] = 2;
        data[32] = 3;
        data[48] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[49] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[50] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[51] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[52] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[53] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[54] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[56] = 4;

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }
}
