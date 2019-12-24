package org.im97mori.ble.characteristic.bcs;

import android.bluetooth.BluetoothGattCharacteristic;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BodyCompositionMeasurementPacketConstructorTest {

    @Test
    public void test_constructor0001() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
    }

    @Test
    public void test_constructor0002() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
    }

    @Test
    public void test_constructor0101() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
    }

    @Test
    public void test_constructor0102() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 1582;
        data[ 5] = (byte) (1582 >> 8);
        data[ 6] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 7] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(0, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor0103() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JANUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
    }

    @Test
    public void test_constructor0104() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0105() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MARCH;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0106() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_APRIL;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0107() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MAY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0108() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JUNE;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0109() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JULY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0110() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_AUGUST;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0111() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0112() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_OCTOBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0113() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0114() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_DECEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(58, result1.getSeconds());
    }

    @Test
    public void test_constructor0201() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
    }

    @Test
    public void test_constructor0202() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertEquals(0x03, result1.getUserId());
    }

    @Test
    public void test_constructor0301() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsBasalMetabolismNotPresent());
        assertFalse(result1.isFlagsBasalMetabolismPresent());
    }

    @Test
    public void test_constructor0302() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBasalMetabolismNotPresent());
        assertTrue(result1.isFlagsBasalMetabolismPresent());
        assertEquals(0x0403, result1.getBasalMetabolism());
        assertEquals(BodyCompositionMeasurement.BASAL_METABOLISM_RESOLUTION * 0x0403, result1.getBasalMetabolismKj(), 0);
    }

    @Test
    public void test_constructor0303() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBasalMetabolismNotPresent());
        assertTrue(result1.isFlagsBasalMetabolismPresent());
        assertEquals(0xffff, result1.getBasalMetabolism());
        assertEquals(BodyCompositionMeasurement.BASAL_METABOLISM_RESOLUTION * 0xffff, result1.getBasalMetabolismKj(), 0);
    }

    @Test
    public void test_constructor0401() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsMusclePercentageNotPresent());
        assertFalse(result1.isFlagsMusclePercentagePresent());
    }

    @Test
    public void test_constructor0402() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMusclePercentageNotPresent());
        assertTrue(result1.isFlagsMusclePercentagePresent());
        assertEquals(0x0403, result1.getMusclePercentage());
        assertEquals(BodyCompositionMeasurement.MUSCLE_PERCENTAGE_RESOLUTION * 0x0403, result1.getMusclePercentageWithUnit(), 0);
    }

    @Test
    public void test_constructor0403() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMusclePercentageNotPresent());
        assertTrue(result1.isFlagsMusclePercentagePresent());
        assertEquals(0xffff, result1.getMusclePercentage());
        assertEquals(BodyCompositionMeasurement.MUSCLE_PERCENTAGE_RESOLUTION * 0xffff, result1.getMusclePercentageWithUnit(), 0);
    }

    @Test
    public void test_constructor0501() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsMuscleMassNotPresent());
        assertFalse(result1.isFlagsMuscleMassPresent());
    }

    @Test
    public void test_constructor0502() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMuscleMassNotPresent());
        assertTrue(result1.isFlagsMuscleMassPresent());
        assertEquals(0x0403, result1.getMuscleMassSi());
        assertEquals(BodyCompositionMeasurement.MUSCLE_MASS_SI_RESOLUTION * 0x0403, result1.getMuscleMassSiKg(), 0);
    }

    @Test
    public void test_constructor0503() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMuscleMassNotPresent());
        assertTrue(result1.isFlagsMuscleMassPresent());
        assertEquals(0xffff, result1.getMuscleMassSi());
        assertEquals(BodyCompositionMeasurement.MUSCLE_MASS_SI_RESOLUTION * 0xffff, result1.getMuscleMassSiKg(), 0);
    }

    @Test
    public void test_constructor0504() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMuscleMassNotPresent());
        assertTrue(result1.isFlagsMuscleMassPresent());
        assertEquals(0x0403, result1.getMuscleMassImperial());
        assertEquals(BodyCompositionMeasurement.MUSCLE_MASS_IMPERIAL_RESOLUTION * 0x0403, result1.getMuscleMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0505() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsMuscleMassNotPresent());
        assertTrue(result1.isFlagsMuscleMassPresent());
        assertEquals(0xffff, result1.getMuscleMassImperial());
        assertEquals(BodyCompositionMeasurement.MUSCLE_MASS_IMPERIAL_RESOLUTION * 0xffff, result1.getMuscleMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0601() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsFatFreeMassNotPresent());
        assertFalse(result1.isFlagsFatFreeMassPresent());
    }

    @Test
    public void test_constructor0602() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsFatFreeMassNotPresent());
        assertTrue(result1.isFlagsFatFreeMassPresent());
        assertEquals(0x0403, result1.getFatFreeMassSi());
        assertEquals(BodyCompositionMeasurement.FAT_FREE_MASS_SI_RESOLUTION * 0x0403, result1.getFatFreeMassSiKg(), 0);
    }

    @Test
    public void test_constructor0603() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsFatFreeMassNotPresent());
        assertTrue(result1.isFlagsFatFreeMassPresent());
        assertEquals(0xffff, result1.getFatFreeMassSi());
        assertEquals(BodyCompositionMeasurement.FAT_FREE_MASS_SI_RESOLUTION * 0xffff, result1.getFatFreeMassSiKg(), 0);
    }

    @Test
    public void test_constructor0604() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsFatFreeMassNotPresent());
        assertTrue(result1.isFlagsFatFreeMassPresent());
        assertEquals(0x0403, result1.getFatFreeMassImperial());
        assertEquals(BodyCompositionMeasurement.FAT_FREE_MASS_IMPERIAL_RESOLUTION * 0x0403, result1.getFatFreeMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0605() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsFatFreeMassNotPresent());
        assertTrue(result1.isFlagsFatFreeMassPresent());
        assertEquals(0xffff, result1.getFatFreeMassImperial());
        assertEquals(BodyCompositionMeasurement.FAT_FREE_MASS_IMPERIAL_RESOLUTION * 0xffff, result1.getFatFreeMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0701() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsSoftLeanMassNotPresent());
        assertFalse(result1.isFlagsSoftLeanMassPresent());
    }

    @Test
    public void test_constructor0702() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsSoftLeanMassNotPresent());
        assertTrue(result1.isFlagsSoftLeanMassPresent());
        assertEquals(0x0403, result1.getSoftLeanMassSi());
        assertEquals(BodyCompositionMeasurement.SOFT_LEAN_MASS_SI_RESOLUTION * 0x0403, result1.getSoftLeanMassSiKg(), 0);
    }

    @Test
    public void test_constructor0703() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsSoftLeanMassNotPresent());
        assertTrue(result1.isFlagsSoftLeanMassPresent());
        assertEquals(0xffff, result1.getSoftLeanMassSi());
        assertEquals(BodyCompositionMeasurement.SOFT_LEAN_MASS_SI_RESOLUTION * 0xffff, result1.getSoftLeanMassSiKg(), 0);
    }

    @Test
    public void test_constructor0704() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsSoftLeanMassNotPresent());
        assertTrue(result1.isFlagsSoftLeanMassPresent());
        assertEquals(0x0403, result1.getSoftLeanMassImperial());
        assertEquals(BodyCompositionMeasurement.SOFT_LEAN_MASS_IMPERIAL_RESOLUTION * 0x0403, result1.getSoftLeanMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0705() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsSoftLeanMassNotPresent());
        assertTrue(result1.isFlagsSoftLeanMassPresent());
        assertEquals(0xffff, result1.getSoftLeanMassImperial());
        assertEquals(BodyCompositionMeasurement.SOFT_LEAN_MASS_IMPERIAL_RESOLUTION * 0xffff, result1.getSoftLeanMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0801() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsBodyWaterMassNotPresent());
        assertFalse(result1.isFlagsBodyWaterMassPresent());
    }

    @Test
    public void test_constructor0802() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBodyWaterMassNotPresent());
        assertTrue(result1.isFlagsBodyWaterMassPresent());
        assertEquals(0x0403, result1.getBodyWaterMassSi());
        assertEquals(BodyCompositionMeasurement.BODY_WATER_MASS_SI_RESOLUTION * 0x0403, result1.getBodyWaterMassSiKg(), 0);
    }

    @Test
    public void test_constructor0803() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBodyWaterMassNotPresent());
        assertTrue(result1.isFlagsBodyWaterMassPresent());
        assertEquals(0xffff, result1.getBodyWaterMassSi());
        assertEquals(BodyCompositionMeasurement.BODY_WATER_MASS_SI_RESOLUTION * 0xffff, result1.getBodyWaterMassSiKg(), 0);
    }

    @Test
    public void test_constructor0804() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBodyWaterMassNotPresent());
        assertTrue(result1.isFlagsBodyWaterMassPresent());
        assertEquals(0x0403, result1.getBodyWaterMassImperial());
        assertEquals(BodyCompositionMeasurement.BODY_WATER_MASS_IMPERIAL_RESOLUTION * 0x0403, result1.getBodyWaterMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0805() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsBodyWaterMassNotPresent());
        assertTrue(result1.isFlagsBodyWaterMassPresent());
        assertEquals(0xffff, result1.getBodyWaterMassImperial());
        assertEquals(BodyCompositionMeasurement.BODY_WATER_MASS_IMPERIAL_RESOLUTION * 0xffff, result1.getBodyWaterMassImperialLb(), 0);
    }

    @Test
    public void test_constructor0901() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsImpedanceNotPresent());
        assertFalse(result1.isFlagsImpedancePresent());
    }

    @Test
    public void test_constructor0902() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsImpedanceNotPresent());
        assertTrue(result1.isFlagsImpedancePresent());
        assertEquals(0x0403, result1.getImpedance());
        assertEquals(BodyCompositionMeasurement.IMPEDANCE_RESOLUTION * 0x0403, result1.getImpedanceOhms(), 0);
    }

    @Test
    public void test_constructor0903() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsImpedanceNotPresent());
        assertTrue(result1.isFlagsImpedancePresent());
        assertEquals(0xffff, result1.getImpedance());
        assertEquals(BodyCompositionMeasurement.IMPEDANCE_RESOLUTION * 0xffff, result1.getImpedanceOhms(), 0);
    }

    @Test
    public void test_constructor1001() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsWeightNotPresent());
        assertFalse(result1.isFlagsWeightPresent());
    }

    @Test
    public void test_constructor1002() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsWeightNotPresent());
        assertTrue(result1.isFlagsWeightPresent());
        assertEquals(0x0403, result1.getWeightSi());
        assertEquals(BodyCompositionMeasurement.WEIGHT_SI_RESOLUTION * 0x0403, result1.getWeightSiKg(), 0);
    }

    @Test
    public void test_constructor1003() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsWeightNotPresent());
        assertTrue(result1.isFlagsWeightPresent());
        assertEquals(0xffff, result1.getWeightSi());
        assertEquals(BodyCompositionMeasurement.WEIGHT_SI_RESOLUTION * 0xffff, result1.getWeightSiKg(), 0);
    }

    @Test
    public void test_constructor1004() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsWeightNotPresent());
        assertTrue(result1.isFlagsWeightPresent());
        assertEquals(0x0403, result1.getWeightImperial());
        assertEquals(BodyCompositionMeasurement.WEIGHT_IMPERIAL_RESOLUTION * 0x0403, result1.getWeightImperialLb(), 0);
    }

    @Test
    public void test_constructor1005() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsWeightNotPresent());
        assertTrue(result1.isFlagsWeightPresent());
        assertEquals(0xffff, result1.getWeightImperial());
        assertEquals(BodyCompositionMeasurement.WEIGHT_IMPERIAL_RESOLUTION * 0xffff, result1.getWeightImperialLb(), 0);
    }

    @Test
    public void test_constructor1101() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsHeightNotPresent());
        assertFalse(result1.isFlagsHeightPresent());
    }

    @Test
    public void test_constructor1102() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHeightNotPresent());
        assertTrue(result1.isFlagsHeightPresent());
        assertEquals(0x0403, result1.getHeightSi());
        assertEquals(BodyCompositionMeasurement.HEIGHT_SI_RESOLUTION * 0x0403, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor1103() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHeightNotPresent());
        assertTrue(result1.isFlagsHeightPresent());
        assertEquals(0xffff, result1.getHeightSi());
        assertEquals(BodyCompositionMeasurement.HEIGHT_SI_RESOLUTION * 0xffff, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor1104() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHeightNotPresent());
        assertTrue(result1.isFlagsHeightPresent());
        assertEquals(0x0403, result1.getHeightImperial());
        assertEquals(BodyCompositionMeasurement.HEIGHT_IMPERIAL_RESOLUTION * 0x0403, result1.getHeightImperialInches(), 0);
    }

    @Test
    public void test_constructor1105() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsHeightNotPresent());
        assertTrue(result1.isFlagsHeightPresent());
        assertEquals(0xffff, result1.getHeightImperial());
        assertEquals(BodyCompositionMeasurement.HEIGHT_IMPERIAL_RESOLUTION * 0xffff, result1.getHeightImperialInches(), 0);
    }

    @Test
    public void test_constructor1201() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isFlagsNotMultiplePacketMeasurement());
        assertFalse(result1.isFlagsMultiplePacketMeasurement());
    }

    @Test
    public void test_constructor1202() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isFlagsNotMultiplePacketMeasurement());
        assertTrue(result1.isFlagsMultiplePacketMeasurement());
    }

    @Test
    public void test_constructor1301() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertTrue(result1.isMeasurementSuccessful());
        assertFalse(result1.isMeasurementUnsuccessful());
    }

    @Test
    public void test_constructor1302() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isMeasurementSuccessful());
        assertTrue(result1.isMeasurementUnsuccessful());
    }

    @Test
    public void test_constructor1303() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[31];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertFalse(result1.isMeasurementSuccessful());
        assertTrue(result1.isMeasurementUnsuccessful());
    }

    @Test
    public void test_constructor1304() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertEquals(0x0201, result1.getBodyFatPercentage());
        assertTrue(result1.isMeasurementSuccessful());
        assertFalse(result1.isMeasurementUnsuccessful());
        assertEquals(0x0403, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBasalMetabolism());
        assertEquals(0x0e0d, result1.getMusclePercentage());
        assertEquals(0x100f, result1.getMuscleMassSi());
        assertEquals(0x1211, result1.getFatFreeMassSi());
        assertEquals(0x1413, result1.getSoftLeanMassSi());
        assertEquals(0x1615, result1.getBodyWaterMassSi());
        assertEquals(0x1817, result1.getImpedance());
        assertEquals(0x1a19, result1.getWeightSi());
        assertEquals(0x1c1b, result1.getHeightSi());
    }

    @Test
    public void test_constructor1305() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacket result1 = new BodyCompositionMeasurementPacket(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertEquals(0x0201, result1.getBodyFatPercentage());
        assertTrue(result1.isMeasurementSuccessful());
        assertFalse(result1.isMeasurementUnsuccessful());
        assertEquals(0x0403, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBasalMetabolism());
        assertEquals(0x0e0d, result1.getMusclePercentage());
        assertEquals(0x100f, result1.getMuscleMassImperial());
        assertEquals(0x1211, result1.getFatFreeMassImperial());
        assertEquals(0x1413, result1.getSoftLeanMassImperial());
        assertEquals(0x1615, result1.getBodyWaterMassImperial());
        assertEquals(0x1817, result1.getImpedance());
        assertEquals(0x1a19, result1.getWeightImperial());
        assertEquals(0x1c1b, result1.getHeightImperial());
    }

}
