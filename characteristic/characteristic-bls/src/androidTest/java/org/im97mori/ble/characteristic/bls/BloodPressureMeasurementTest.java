package org.im97mori.ble.characteristic.bls;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.im97mori.ble.characteristic.core.UserIndexUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BloodPressureMeasurementTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsBloodPressureUnitsMmhg());
        assertFalse(result1.isFlagsBloodPressureUnitsKpa());
        assertEquals(1, result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(2, result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(3, result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsBloodPressureUnitsMmhg());
        assertTrue(result1.isFlagsBloodPressureUnitsKpa());
        assertEquals(1, result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(2, result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(3, result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 1582;
        data[ 8] = (byte) (1582 >> 8);
        data[ 9] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[10] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
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
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JANUARY;
        data[10] = 1;
        data[11] = 23;
        data[12] = 59;
        data[13] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
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
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_FEBRUARY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor105() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MARCH;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor106() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_APRIL;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor107() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor108() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JUNE;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor109() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JULY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor110() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_AUGUST;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor111() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_SEPTEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor112() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_OCTOBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor113() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_NOVEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor114() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_DECEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsPulseRateNotPresent());
        assertFalse(result1.isFlagsPulseRatePresent());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsPulseRateNotPresent());
        assertTrue(result1.isFlagsPulseRatePresent());
        assertEquals(0x0004, result1.getPulseRate().getSfloat(), 0);
    }

    @Test
    public void test_constructor301() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
    }

    @Test
    public void test_constructor302() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertEquals(UserIndexUtils.USER_ID_UNKNOWN_USER, result1.getUserId());
    }

    @Test
    public void test_constructor303() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertEquals(0x04, result1.getUserId());
    }

    @Test
    public void test_constructor401() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsMeasurementStatusNotPresent());
        assertFalse(result1.isFlagsMeasurementStatusPresent());
    }

    @Test
    public void test_constructor402() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor403() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor404() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor405() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor406() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor407() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor408() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsMeasurementStatusNotPresent());
        assertTrue(result1.isFlagsMeasurementStatusPresent());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
        assertTrue(result1.isMeasurementStatusBodyMoveDetectionNoBodyMovement());
        assertFalse(result1.isMeasurementStatusBodyMoveDetectionBodyMovementDuringMeasurement());
        assertTrue(result1.isMeasurementStatusCuffFitDetectionCuffFitsProperly());
        assertFalse(result1.isMeasurementStatusCuffFitDetectionCuffTooLoose());
        assertTrue(result1.isMeasurementStatusIrregularPulseDetectionNoIrregularPulseDetected());
        assertFalse(result1.isMeasurementStatusIrregularPulseDetectionIrregularPulseDetected());
        assertTrue(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsWithinTheRange());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateExceedssUpperLimit());
        assertFalse(result1.isMeasurementStatusPulseRateRangeDetectionPulseRateIsLessThanLowerLimit());
        assertFalse(result1.isMeasurementStatusMeasurementPositionDetectionProperMeasurementPosition());
        assertTrue(result1.isMeasurementStatusMeasurementPositionDetectionImproperMeasurementPosition());
    }

    @Test
    public void test_constructor501() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsBloodPressureUnitsMmhg());
        assertFalse(result1.isFlagsBloodPressureUnitsKpa());
        assertEquals(1, result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(2, result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(3, result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(0x0004, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(10, result1.getPulseRate().getSfloat(), 0);
        assertEquals(0x0b, result1.getUserId());
        assertArrayEquals(Arrays.copyOfRange(data, 17, 19), result1.getMeasurementStatus());
    }

    @Test
    public void test_constructor502() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertEquals(BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsBloodPressureUnitsMmhg());
        assertTrue(result1.isFlagsBloodPressureUnitsKpa());
        assertEquals(1, result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(2, result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(3, result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(0x0004, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(10, result1.getPulseRate().getSfloat(), 0);
        assertEquals(0x0b, result1.getUserId());
        assertArrayEquals(Arrays.copyOfRange(data, 17, 19), result1.getMeasurementStatus());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 1582;
        data[ 8] = (byte) (1582 >> 8);
        data[ 9] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[10] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JANUARY;
        data[10] = 1;
        data[11] = 23;
        data[12] = 59;
        data[13] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_FEBRUARY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_APRIL;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JUNE;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JULY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_AUGUST;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_SEPTEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable014() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_OCTOBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable015() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_NOVEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable016() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_DECEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable017() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable018() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable019() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable020() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable021() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable022() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable023() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable024() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable025() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable026() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable027() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable028() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable029() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable030() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable031() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getPulseRate().getSfloat(), result2.getPulseRate().getSfloat(), 0);
        assertEquals(result1.getUserId(), result2.getUserId());
        assertArrayEquals(result1.getMeasurementStatus(), result2.getMeasurementStatus());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 1582;
        data[ 8] = (byte) (1582 >> 8);
        data[ 9] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[10] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JANUARY;
        data[10] = 1;
        data[11] = 23;
        data[12] = 59;
        data[13] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_FEBRUARY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_APRIL;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JUNE;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JULY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_AUGUST;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_SEPTEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_OCTOBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_NOVEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_DECEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable119() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable120() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable121() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable122() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable123() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable124() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable125() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable126() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable127() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable128() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable129() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable130() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable131() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 1582;
        data[ 8] = (byte) (1582 >> 8);
        data[ 9] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[10] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JANUARY;
        data[10] = 1;
        data[11] = 23;
        data[12] = 59;
        data[13] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_FEBRUARY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_APRIL;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_MAY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JUNE;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_JULY;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_AUGUST;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_SEPTEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_OCTOBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_NOVEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 9999;
        data[ 8] = (byte) (9999 >> 8);
        data[ 9] = DateTimeUtils.MONTH_DECEMBER;
        data[10] = 31;
        data[11] = 0;
        data[12] = 0;
        data[13] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable219() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable220() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable221() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable222() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_NOT_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable223() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable224() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable225() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_TOO_LOOSE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable226() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable227() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_EXCEEDS_UPPER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable228() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_LESS_THAN_LOWER_LIMIT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_PROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable229() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_NOT_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_NO_BODY_MOVEMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_NO_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[ 7] = (byte) measurementStatusFlag;
        data[ 8] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable230() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable231() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = BloodPressureMeasurement.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | BloodPressureMeasurement.FLAG_TIME_STAMP_PRESENT
                | BloodPressureMeasurement.FLAG_PULSE_RATE_PRESENT
                | BloodPressureMeasurement.FLAG_USER_ID_PRESENT
                | BloodPressureMeasurement.FLAG_MEASUREMENT_STATUS_PRESENT;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x0004;
        data[ 8] = (byte) (0x0004 >> 8);
        data[ 9] = 0x05;
        data[10] = 0x06;
        data[11] = 0x07;
        data[12] = 0x08;
        data[13] = 0x09;
        data[14] = (byte) 0x0a;
        data[15] = (byte) (0x0a >> 8);
        data[16] = 0x0b;

        int measurementStatusFlag = BloodPressureMeasurement.MEASUREMENT_STATUS_BODY_MOVEMENT_DETECTION_BODY_MOVEMENT_DURING_MEASUREMENT
                | BloodPressureMeasurement.MEASUREMENT_STATUS_CUFF_FIT_DETECTION_CUFF_FITS_PROPERLY
                | BloodPressureMeasurement.MEASUREMENT_STATUS_IRREGULAR_PULSE_DETECTION_IRREGULAR_PULSE_DETECTED
                | BloodPressureMeasurement.MEASUREMENT_STATUS_PULSE_RATE_RANGE_DETECTION_PULSE_RATE_IS_WITHIN_THE_RANGE
                | BloodPressureMeasurement.MEASUREMENT_STATUS_MEASUREMENT_POSITION_DETECTION_IMPROPER_MEASUREMENT_POSITION;
        data[17] = (byte) measurementStatusFlag;
        data[18] = (byte) (measurementStatusFlag >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BloodPressureMeasurement result1 = new BloodPressureMeasurement(bluetoothGattCharacteristic);
        BloodPressureMeasurement result2 = BloodPressureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
