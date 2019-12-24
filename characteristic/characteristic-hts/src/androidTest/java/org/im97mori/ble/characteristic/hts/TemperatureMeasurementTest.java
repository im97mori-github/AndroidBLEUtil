package org.im97mori.ble.characteristic.hts;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TemperatureMeasurementTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertEquals(0x030201 * Math.pow(10, 0x04), result1.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertTrue(result1.isFlagsTemperatureUnitsCelsius());
        assertFalse(result1.isFlagsTemperatureUnitsFahrenheit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertEquals(0x030201 * Math.pow(10, 0x04), result1.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertFalse(result1.isFlagsTemperatureUnitsCelsius());
        assertTrue(result1.isFlagsTemperatureUnitsFahrenheit());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
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
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsTemperatureTypeNotPresent());
        assertFalse(result1.isFlagsTemperatureTypePresent());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT, result1.getTemperatureTextDescription());
        assertTrue(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor203() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertTrue(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor204() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertTrue(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor205() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertTrue(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor206() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertTrue(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor207() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertTrue(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor208() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertTrue(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor209() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertTrue(result1.isTemperatureTextDescriptionTypeToe());
        assertFalse(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_constructor210() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertEquals(TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsTemperatureTypeNotPresent());
        assertTrue(result1.isFlagsTemperatureTypePresent());
        assertEquals(TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM, result1.getTemperatureTextDescription());
        assertFalse(result1.isTemperatureTextDescriptionTypeArmpit());
        assertFalse(result1.isTemperatureTextDescriptionTypeBodyGeneral());
        assertFalse(result1.isTemperatureTextDescriptionTypeEarUsuallyEarLobe());
        assertFalse(result1.isTemperatureTextDescriptionTypeFinger());
        assertFalse(result1.isTemperatureTextDescriptionTypeGastroIntestinalTract());
        assertFalse(result1.isTemperatureTextDescriptionTypeMouth());
        assertFalse(result1.isTemperatureTextDescriptionTypeRectum());
        assertFalse(result1.isTemperatureTextDescriptionTypeToe());
        assertTrue(result1.isTemperatureTextDescriptionTypeTympanumEarDrum());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable014() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable015() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable016() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable017() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable018() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable019() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable020() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable021() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable022() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable023() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable024() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable025() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable026() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getTemperatureMeasurementValueCelsius().getFloat(), result2.getTemperatureMeasurementValueCelsius().getFloat(), 0);
        assertEquals(result1.getTemperatureMeasurementValueFahrenheit().getFloat(), result2.getTemperatureMeasurementValueFahrenheit().getFloat(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getTemperatureTextDescription(), result2.getTemperatureTextDescription());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable119() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable120() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable121() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable122() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable123() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable124() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable125() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable126() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_FAHRENHEIT
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 1582;
        data[ 6] = (byte) (1582 >> 8);
        data[ 7] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 8] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JANUARY;
        data[ 8] = 1;
        data[ 9] = 23;
        data[10] = 59;
        data[11] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MARCH;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_APRIL;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_MAY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JUNE;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_JULY;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_AUGUST;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_OCTOBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        //@formatter:off
        byte[] data = new byte[12];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = (byte) 9999;
        data[ 6] = (byte) (9999 >> 8);
        data[ 7] = DateTimeUtils.MONTH_DECEMBER;
        data[ 8] = 31;
        data[ 9] = 0;
        data[10] = 0;
        data[11] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_ARMPIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable219() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_BODY_GENERAL;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable220() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_EAR_USUALLY_EAR_LOBE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable221() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_FINGER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable222() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_GASTRO_INTESTINAL_TRACT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable223() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_MOUTH;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable224() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_RECTUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable225() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TOE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable226() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = TemperatureMeasurement.FLAGS_TEMPERATURE_UNITS_CELSIUS
                | TemperatureMeasurement.FLAGS_TIME_STAMP_NOT_PRESENT
                | TemperatureMeasurement.FLAGS_TEMPERATURE_TYPE_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = TemperatureType.TEMPERATURE_TEXT_DESCRIPTION_TYPE_TYMPANUM_EAR_DRUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureMeasurement result1 = new TemperatureMeasurement(bluetoothGattCharacteristic);
        TemperatureMeasurement result2 = TemperatureMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
