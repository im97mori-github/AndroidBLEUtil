package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DateOfThresholdAssessmentTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = DateTimeUtils.YEAR_IS_NOT_KNOWN;
        data[ 1] = (byte) (DateTimeUtils.YEAR_IS_NOT_KNOWN >> 8);
        data[ 2] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 3] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(DateTimeUtils.YEAR_IS_NOT_KNOWN, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_IS_NOT_KNOWN, result1.getMonth());
        assertEquals(DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN, result1.getDay());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(1582, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JANUARY, result1.getMonth());
        assertEquals(1, result1.getDay());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_FEBRUARY, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MARCH;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MARCH, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_APRIL;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_APRIL, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_MAY;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_MAY, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JUNE;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JUNE, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JULY;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_JULY, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_AUGUST;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_AUGUST, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor010() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_SEPTEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor011() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_OCTOBER;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_OCTOBER, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor012() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_NOVEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_constructor013() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 9999;
        data[ 1] = (byte) (9999 >> 8);
        data[ 2] = DateTimeUtils.MONTH_DECEMBER;
        data[ 3] = 31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertEquals(9999, result1.getYear());
        assertEquals(DateTimeUtils.MONTH_DECEMBER, result1.getMonth());
        assertEquals(31, result1.getDay());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DateOfThresholdAssessment result2 = DateOfThresholdAssessment.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getYear(), result1.getYear());
        assertEquals(result2.getMonth(), result1.getMonth());
        assertEquals(result2.getDay(), result1.getDay());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        //@formatter:on


        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 1582;
        data[ 1] = (byte) (1582 >> 8);
        data[ 2] = DateTimeUtils.MONTH_JANUARY;
        data[ 3] = 1;
        //@formatter:on


        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DateOfThresholdAssessment result1 = new DateOfThresholdAssessment(bluetoothGattCharacteristic);
        DateOfThresholdAssessment result2 = DateOfThresholdAssessment.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
