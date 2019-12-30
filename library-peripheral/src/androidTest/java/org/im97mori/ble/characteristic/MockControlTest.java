package org.im97mori.ble.characteristic;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.im97mori.ble.BLEServerConnection.MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MockControlTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[58];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNull(result1.getServiceInstanceId());
        assertEquals(new UUID(0x02, 0), result1.getCharacteristicUUID());
        assertNull(result1.getCharacteristicInstanceId());
        assertEquals(new UUID(0x03, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_CHARACTERISTIC, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(new byte[0], result1.getValue());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNull(result1.getServiceInstanceId());
        assertEquals(new UUID(0x02, 0), result1.getCharacteristicUUID());
        assertNotNull(result1.getCharacteristicInstanceId());
        assertEquals(0x03, result1.getCharacteristicInstanceId().intValue());
        assertEquals(new UUID(0x04, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_DESCRIPTOR, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(new byte[0], result1.getValue());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNotNull(result1.getServiceInstanceId());
        assertEquals(0x02, result1.getServiceInstanceId().intValue());
        assertEquals(new UUID(0x03, 0), result1.getCharacteristicUUID());
        assertNull(result1.getCharacteristicInstanceId());
        assertEquals(new UUID(0x04, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_NOTIFICATION, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(new byte[0], result1.getValue());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[66];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNotNull(result1.getServiceInstanceId());
        assertEquals(0x02, result1.getServiceInstanceId().intValue());
        assertEquals(new UUID(0x03, 0), result1.getCharacteristicUUID());
        assertNotNull(result1.getCharacteristicInstanceId());
        assertEquals(0x04, result1.getCharacteristicInstanceId().intValue());
        assertEquals(new UUID(0x05, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_CLEAR, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(new byte[0], result1.getValue());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[59];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[58] = 'a';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNull(result1.getServiceInstanceId());
        assertEquals(new UUID(0x02, 0), result1.getCharacteristicUUID());
        assertNull(result1.getCharacteristicInstanceId());
        assertEquals(new UUID(0x03, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_CHARACTERISTIC, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(Arrays.copyOfRange(data, 58, 59), result1.getValue());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'b';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNull(result1.getServiceInstanceId());
        assertEquals(new UUID(0x02, 0), result1.getCharacteristicUUID());
        assertNotNull(result1.getCharacteristicInstanceId());
        assertEquals(0x03, result1.getCharacteristicInstanceId().intValue());
        assertEquals(new UUID(0x04, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_DESCRIPTOR, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(Arrays.copyOfRange(data, 62, 63), result1.getValue());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'c';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNotNull(result1.getServiceInstanceId());
        assertEquals(0x02, result1.getServiceInstanceId().intValue());
        assertEquals(new UUID(0x03, 0), result1.getCharacteristicUUID());
        assertNull(result1.getCharacteristicInstanceId());
        assertEquals(new UUID(0x04, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_TYPE_NOTIFICATION, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(Arrays.copyOfRange(data, 62, 63), result1.getValue());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[67];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[66] = 'd';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertEquals(new UUID(0x01, 0), result1.getServiceUUID());
        assertNotNull(result1.getServiceInstanceId());
        assertEquals(0x02, result1.getServiceInstanceId().intValue());
        assertEquals(new UUID(0x03, 0), result1.getCharacteristicUUID());
        assertNotNull(result1.getCharacteristicInstanceId());
        assertEquals(0x04, result1.getCharacteristicInstanceId().intValue());
        assertEquals(new UUID(0x05, 0), result1.getDescriptorUUID());
        assertEquals(MockControl.TARGET_CLEAR, result1.getTargetType());
        assertEquals(BluetoothGatt.GATT_SUCCESS, result1.getStatus());
        assertArrayEquals(Arrays.copyOfRange(data, 66, 67), result1.getValue());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[58];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[66];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[59];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[58] = 'a';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'b';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'c';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[67];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[66] = 'd';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockControl result2 = MockControl.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getServiceUUID(), result2.getServiceUUID());
        assertEquals(result1.getServiceInstanceId(), result2.getServiceInstanceId());
        assertEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
        assertEquals(result1.getCharacteristicInstanceId(), result2.getCharacteristicInstanceId());
        assertEquals(result1.getDescriptorUUID(), result2.getDescriptorUUID());
        assertEquals(result1.getTargetType(), result2.getTargetType());
        assertEquals(result1.getStatus(), result2.getStatus());
        assertArrayEquals(result1.getValue(), result2.getValue());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[58];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[66];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[59];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[58] = 'a';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'b';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'c';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[67];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[66] = 'd';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[58];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[62];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[66];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[59];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x00;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0xff & MockControl.TARGET_TYPE_CHARACTERISTIC;
        data[51] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 8);
        data[52] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 16);
        data[53] = 0xff & (MockControl.TARGET_TYPE_CHARACTERISTIC >> 24);
        data[54] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[55] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[56] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[57] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[58] = 'a';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x00;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = MockControl.INSTANCE_ID_NOT_NULL;
        data[34] = 0x03;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = 0x00;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_DESCRIPTOR;
        data[55] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_DESCRIPTOR >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'b';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[63];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x00;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0xff & MockControl.TARGET_TYPE_NOTIFICATION;
        data[55] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 8);
        data[56] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 16);
        data[57] = 0xff & (MockControl.TARGET_TYPE_NOTIFICATION >> 24);
        data[58] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[59] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[60] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[61] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[62] = 'c';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[67];
        data[ 0] = 0x01;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        data[ 5] = 0x00;
        data[ 6] = 0x00;
        data[ 7] = 0x00;
        data[ 8] = 0x00;
        data[ 9] = 0x00;
        data[10] = 0x00;
        data[11] = 0x00;
        data[12] = 0x00;
        data[13] = 0x00;
        data[14] = 0x00;
        data[15] = 0x00;
        data[16] = MockControl.INSTANCE_ID_NOT_NULL;
        data[17] = 0x02;
        data[18] = 0x00;
        data[19] = 0x00;
        data[20] = 0x00;
        data[21] = 0x03;
        data[22] = 0x00;
        data[23] = 0x00;
        data[24] = 0x00;
        data[25] = 0x00;
        data[26] = 0x00;
        data[27] = 0x00;
        data[28] = 0x00;
        data[29] = 0x00;
        data[30] = 0x00;
        data[31] = 0x00;
        data[32] = 0x00;
        data[33] = 0x00;
        data[34] = 0x00;
        data[35] = 0x00;
        data[36] = 0x00;
        data[37] = MockControl.INSTANCE_ID_NOT_NULL;
        data[38] = 0x04;
        data[39] = 0x00;
        data[40] = 0x00;
        data[41] = 0x00;
        data[42] = 0x05;
        data[43] = 0x00;
        data[44] = 0x00;
        data[45] = 0x00;
        data[46] = 0x00;
        data[47] = 0x00;
        data[48] = 0x00;
        data[49] = 0x00;
        data[50] = 0x00;
        data[51] = 0x00;
        data[52] = 0x00;
        data[53] = 0x00;
        data[54] = 0x00;
        data[55] = 0x00;
        data[56] = 0x00;
        data[57] = 0x00;
        data[58] = 0xff & MockControl.TARGET_CLEAR;
        data[59] = 0xff & (MockControl.TARGET_CLEAR >> 8);
        data[60] = 0xff & (MockControl.TARGET_CLEAR >> 16);
        data[61] = 0xff & (MockControl.TARGET_CLEAR >> 24);
        data[62] = 0xff & BluetoothGatt.GATT_SUCCESS;
        data[63] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 8);
        data[64] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 16);
        data[65] = 0xff & (BluetoothGatt.GATT_SUCCESS >> 24);
        data[66] = 'd';
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MOCK_CONTROL_TARGET_CHARACTERISTIC_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MockControl result1 = new MockControl(bluetoothGattCharacteristic);
        MockControl result2 = MockControl.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
