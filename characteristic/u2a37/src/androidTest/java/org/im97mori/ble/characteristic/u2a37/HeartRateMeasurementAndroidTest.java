package org.im97mori.ble.characteristic.u2a37;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class HeartRateMeasurementAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsHeartRateValueFormatUint8());
        assertFalse(result1.isFlagsHeartRateValueFormatUint16());
        assertEquals(0x01, result1.getHeartRateMeasurementValueUint8());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsHeartRateValueFormatUint8());
        assertTrue(result1.isFlagsHeartRateValueFormatUint16());
        assertEquals(0x0201, result1.getHeartRateMeasurementValueUint16());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsSesorContactStatusNotSupported());
        assertFalse(result1.isFlagsSeonsorContactStatusSupportedButNotDetected());
        assertFalse(result1.isFlagsSeonsorContactStatusSupportedAndDetected());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_1
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_1
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsSesorContactStatusNotSupported());
        assertFalse(result1.isFlagsSeonsorContactStatusSupportedButNotDetected());
        assertFalse(result1.isFlagsSeonsorContactStatusSupportedAndDetected());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_BUT_NOT_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_BUT_NOT_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsSesorContactStatusNotSupported());
        assertTrue(result1.isFlagsSeonsorContactStatusSupportedButNotDetected());
        assertFalse(result1.isFlagsSeonsorContactStatusSupportedAndDetected());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_AND_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_AND_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsSesorContactStatusNotSupported());
        assertFalse(result1.isFlagsSeonsorContactStatusSupportedButNotDetected());
        assertTrue(result1.isFlagsSeonsorContactStatusSupportedAndDetected());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsEnergyExpendedStatusNotPresent());
        assertFalse(result1.isFlagsEnergyExpendedStatusPresent());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsEnergyExpendedStatusNotPresent());
        assertTrue(result1.isFlagsEnergyExpendedStatusPresent());
        assertEquals(0x0302, result1.getEnergyExpended());
    }

    @Test
    public void test_constructor203() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsEnergyExpendedStatusNotPresent());
        assertTrue(result1.isFlagsEnergyExpendedStatusPresent());
        assertEquals(0x0403, result1.getEnergyExpended());
    }

    @Test
    public void test_constructor301() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT, result1.getFlags());
        assertTrue(result1.isFlagsRrIntervalNotPresent());
        assertFalse(result1.isFlagsRrIntervalPresent());
    }

    @Test
    public void test_constructor302() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsRrIntervalNotPresent());
        assertTrue(result1.isFlagsRrIntervalPresent());
        byte[] original = Arrays.copyOfRange(data, 2, 20);
        int[] rrInterval = result1.getRrInterval();
        assertEquals(9, rrInterval.length);
        for (int i = 0; i < rrInterval.length; i++) {
            assertEquals(BLEUtils.createSInt16(original, i * 2), rrInterval[i]);
        }
    }

    @Test
    public void test_constructor303() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsRrIntervalNotPresent());
        assertTrue(result1.isFlagsRrIntervalPresent());
        byte[] original = Arrays.copyOfRange(data, 3, 19);
        int[] rrInterval = result1.getRrInterval();
        assertEquals(8, rrInterval.length);
        for (int i = 0; i < rrInterval.length; i++) {
            assertEquals(BLEUtils.createSInt16(original, i * 2), rrInterval[i]);
        }
    }

    @Test
    public void test_constructor304() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsRrIntervalNotPresent());
        assertTrue(result1.isFlagsRrIntervalPresent());
        byte[] original = Arrays.copyOfRange(data, 4, 20);
        int[] rrInterval = result1.getRrInterval();
        assertEquals(8, rrInterval.length);
        for (int i = 0; i < rrInterval.length; i++) {
            assertEquals(BLEUtils.createSInt16(original, i * 2), rrInterval[i]);
        }
    }

    @Test
    public void test_constructor305() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT, result1.getFlags());
        assertFalse(result1.isFlagsRrIntervalNotPresent());
        assertTrue(result1.isFlagsRrIntervalPresent());
        byte[] original = Arrays.copyOfRange(data, 5, 19);
        int[] rrInterval = result1.getRrInterval();
        assertEquals(7, rrInterval.length);
        for (int i = 0; i < rrInterval.length; i++) {
            assertEquals(BLEUtils.createSInt16(original, i * 2), rrInterval[i]);
        }
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_1
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_BUT_NOT_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_AND_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable014() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on


        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getHeartRateMeasurementValueUint8(), result2.getHeartRateMeasurementValueUint8());
        assertEquals(result1.getHeartRateMeasurementValueUint16(), result2.getHeartRateMeasurementValueUint16());
        assertEquals(result1.getEnergyExpended(), result2.getEnergyExpended());
        assertArrayEquals(result1.getRrInterval(), result2.getRrInterval());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_1
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_BUT_NOT_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_AND_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_1
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_BUT_NOT_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_SUPPORTED_AND_DETECTED
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_NOT_PRESENT;
        data[ 1] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_NOT_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[20];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT8
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data[19] = 0x13;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        //@formatter:off
        byte[] data = new byte[19];
        data[ 0] = HeartRateMeasurement.FLAGS_HEART_RATE_VALUE_FORMAT_UINT16
                | HeartRateMeasurement.FLAGS_SENSOR_CONTACT_STATUS_NOT_SUPPORTED_0
                | HeartRateMeasurement.FLAGS_ENERGY_EXPENDED_STATUS_PRESENT
                | HeartRateMeasurement.FLAGS_RR_INTERVAL_PRESENT;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
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
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HeartRateMeasurementAndroid result1 = new HeartRateMeasurementAndroid(bluetoothGattCharacteristic);
        HeartRateMeasurementAndroid result2 = HeartRateMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
