package org.im97mori.ble.characteristic.wss;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.DateTimeUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WeightMeasurementTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0, result1.getWeightSi());
        assertEquals(0, result1.getWeightSiKg(), 0);
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0xffff, result1.getWeightSi());
        assertEquals(WeightMeasurement.WEIGHT_SI_RESOLUTION * 0xffff, result1.getWeightSiKg(), 0);
    }


    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0, result1.getWeightImperial());
        assertEquals(0, result1.getWeightImperialLb(), 0);
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0xffff, result1.getWeightImperial());
        assertEquals(WeightMeasurement.WEIGHT_IMPERIAL_RESOLUTION * 0xffff, result1.getWeightImperialLb(), 0);
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 1582;
        data[ 4] = (byte) (1582 >> 8);
        data[ 5] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 6] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(0, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_JANUARY;
        data[ 6] = 1;
        data[ 7] = 23;
        data[ 8] = 59;
        data[ 9] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
        assertEquals(23, result1.getHours());
        assertEquals(59, result1.getMinutes());
        assertEquals(59, result1.getSeconds());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_MARCH;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor105() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_APRIL;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor106() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_MAY;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor107() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_JUNE;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor108() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_JULY;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor109() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_AUGUST;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor110() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor111() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_OCTOBER;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor112() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
        assertEquals(0, result1.getHours());
        assertEquals(0, result1.getMinutes());
        assertEquals(0, result1.getSeconds());
    }

    @Test
    public void test_constructor113() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 9999;
        data[ 4] = (byte) (9999 >> 8);
        data[ 5] = DateTimeUtils.MONTH_DECEMBER;
        data[ 6] = 31;
        data[ 7] = 0;
        data[ 8] = 0;
        data[ 9] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
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
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) WeightMeasurement.USER_ID_UNKNOWN_USER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(WeightMeasurement.USER_ID_UNKNOWN_USER, result1.getUserId());
        assertTrue(result1.isUserIdUnknownUser());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0, result1.getUserId());
        assertFalse(result1.isUserIdUnknownUser());
    }

    @Test
    public void test_constructor203() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 254;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(254, result1.getUserId());
        assertFalse(result1.isUserIdUnknownUser());
    }

    @Test
    public void test_constructor301() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0, result1.getBmi());
        assertEquals(0, result1.getBmiWithUnit(), 0);
        assertEquals(0, result1.getHeightSi());
        assertEquals(0, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor302() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 0xff;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        data[ 6] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0xffff, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0xffff, result1.getBmiWithUnit(), 0);
        assertEquals(0xffff, result1.getHeightSi());
        assertEquals(WeightMeasurement.HEIGHT_SI * 0xffff, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor303() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0, result1.getBmi());
        assertEquals(0, result1.getBmiWithUnit(), 0);
        assertEquals(0, result1.getHeightImperial());
        assertEquals(0, result1.getHeightImperialInch(), 0);
    }

    @Test
    public void test_constructor304() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = (byte) 0xff;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        data[ 6] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0xffff, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0xffff, result1.getBmiWithUnit(), 0);
        assertEquals(0xffff, result1.getHeightImperial());
        assertEquals(WeightMeasurement.HEIGHT_IMPERIAL * 0xffff, result1.getHeightImperialInch(), 0);
    }

    @Test
    public void test_constructor401() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
    }

    @Test
    public void test_constructor402() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
    }

    @Test
    public void test_constructor403() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
    }

    @Test
    public void test_constructor404() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
    }

    @Test
    public void test_constructor405() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0a, result1.getUserId());
    }

    @Test
    public void test_constructor406() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0a, result1.getUserId());
    }

    @Test
    public void test_constructor407() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
    }

    @Test
    public void test_constructor408() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertTrue(result1.isFlagsBmiAndHeightNotPresent());
        assertFalse(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
    }

    @Test
    public void test_constructor409() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightSi());
        assertEquals(WeightMeasurement.HEIGHT_SI * 0x0e0d, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor410() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightImperial());
        assertEquals(WeightMeasurement.HEIGHT_IMPERIAL * 0x0e0d, result1.getHeightImperialInch(), 0);
    }

    @Test
    public void test_constructor411() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightSi());
        assertEquals(WeightMeasurement.HEIGHT_SI * 0x0e0d, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor412() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertTrue(result1.isFlagsUserIdNotPresent());
        assertFalse(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightImperial());
        assertEquals(WeightMeasurement.HEIGHT_IMPERIAL * 0x0e0d, result1.getHeightImperialInch(), 0);
    }

    @Test
    public void test_constructor413() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightSi());
        assertEquals(WeightMeasurement.HEIGHT_SI * 0x0e0d, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor414() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertTrue(result1.isFlagsTimeStampNotPresent());
        assertFalse(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightImperial());
        assertEquals(WeightMeasurement.HEIGHT_IMPERIAL * 0x0e0d, result1.getHeightImperialInch(), 0);
    }

    @Test
    public void test_constructor415() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertTrue(result1.isFlagsMeasurementUnitSI());
        assertFalse(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightSi());
        assertEquals(WeightMeasurement.HEIGHT_SI * 0x0e0d, result1.getHeightSiMeters(), 0);
    }

    @Test
    public void test_constructor416() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertEquals(WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                        | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                        | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                        | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE
                , result1.getFlags());
        assertFalse(result1.isFlagsMeasurementUnitSI());
        assertTrue(result1.isFlagsMeasurementUnitImperial());
        assertFalse(result1.isFlagsTimeStampNotPresent());
        assertTrue(result1.isFlagsTimeStampPresent());
        assertFalse(result1.isFlagsUserIdNotPresent());
        assertTrue(result1.isFlagsUserIdPresent());
        assertFalse(result1.isFlagsBmiAndHeightNotPresent());
        assertTrue(result1.isFlagsBmiAndHeightPresent());
        assertEquals(0x0304, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBmi());
        assertEquals(WeightMeasurement.BMI_RESOLUTION * 0x0c0b, result1.getBmiWithUnit(), 0);
        assertEquals(0x0e0d, result1.getHeightImperial());
        assertEquals(WeightMeasurement.HEIGHT_IMPERIAL * 0x0e0d, result1.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable014() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable015() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable016() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.isFlagsMeasurementUnitSI(), result2.isFlagsMeasurementUnitSI());
        assertEquals(result1.isFlagsMeasurementUnitImperial(), result2.isFlagsMeasurementUnitImperial());
        assertEquals(result1.isFlagsTimeStampNotPresent(), result2.isFlagsTimeStampNotPresent());
        assertEquals(result1.isFlagsTimeStampPresent(), result2.isFlagsTimeStampPresent());
        assertEquals(result1.isFlagsUserIdNotPresent(), result2.isFlagsUserIdNotPresent());
        assertEquals(result1.isFlagsUserIdPresent(), result2.isFlagsUserIdPresent());
        assertEquals(result1.isFlagsBmiAndHeightNotPresent(), result2.isFlagsBmiAndHeightNotPresent());
        assertEquals(result1.isFlagsBmiAndHeightPresent(), result2.isFlagsBmiAndHeightPresent());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightSiKg(), result2.getWeightSiKg(), 0);
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getWeightImperialLb(), result2.getWeightImperialLb(), 0);
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.isUserIdUnknownUser(), result2.isUserIdUnknownUser());
        assertEquals(result1.getBmi(), result2.getBmi());
        assertEquals(result1.getBmiWithUnit(), result2.getBmiWithUnit(), 0);
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightSiMeters(), result2.getHeightSiMeters(), 0);
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
        assertEquals(result1.getHeightImperialInch(), result2.getHeightImperialInch(), 0);
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[10];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_FALSE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0b;
        data[ 4] = 0x0c;
        data[ 5] = 0x0d;
        data[ 6] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[14];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_FALSE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x0a;
        data[ 4] = 0x0b;
        data[ 5] = 0x0c;
        data[ 6] = 0x0d;
        data[ 7] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_SI
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        //@formatter:off
        byte[] data = new byte[15];
        data[ 0] = WeightMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                    | WeightMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                    | WeightMeasurement.FLAG_USER_ID_PRESENT_TRUE
                    | WeightMeasurement.FLAG_BMI_AND_HEIGHT_PRESENT_TRUE;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = (byte) 0x0304;
        data[ 4] = (byte) (0x0304 >> 8);
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        WeightMeasurement result1 = new WeightMeasurement(bluetoothGattCharacteristic);
        WeightMeasurement result2 = WeightMeasurement.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
