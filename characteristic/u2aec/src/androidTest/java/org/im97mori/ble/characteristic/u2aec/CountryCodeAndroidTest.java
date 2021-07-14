package org.im97mori.ble.characteristic.u2aec;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class CountryCodeAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result = new CountryCodeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCountryCode());
        assertTrue(result.isCountryCodeValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MINIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result = new CountryCodeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCountryCode());
        assertFalse(result.isCountryCodeValueIsNotKnown());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MAXIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result = new CountryCodeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCountryCode());
        assertFalse(result.isCountryCodeValueIsNotKnown());
    }

    @Test
    public void test_constructor_00101() {
        int countryCode = CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN;

        CountryCodeAndroid result = new CountryCodeAndroid(countryCode);
        assertEquals(countryCode, result.getCountryCode());
        assertTrue(result.isCountryCodeValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int countryCode = CountryCode.COUNTRY_CODE_VALUE_MINIMUM;

        CountryCodeAndroid result = new CountryCodeAndroid(countryCode);
        assertEquals(countryCode, result.getCountryCode());
        assertFalse(result.isCountryCodeValueIsNotKnown());
    }

    @Test
    public void test_constructor_00103() {
        int countryCode = CountryCode.COUNTRY_CODE_VALUE_MAXIMUM;

        CountryCodeAndroid result = new CountryCodeAndroid(countryCode);
        assertEquals(countryCode, result.getCountryCode());
        assertFalse(result.isCountryCodeValueIsNotKnown());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CountryCodeAndroid result2 = CountryCodeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCountryCode(), result1.getCountryCode());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MINIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CountryCodeAndroid result2 = CountryCodeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCountryCode(), result1.getCountryCode());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MAXIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CountryCodeAndroid result2 = CountryCodeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCountryCode(), result1.getCountryCode());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MINIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MAXIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        CountryCodeAndroid result2 = CountryCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MINIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        CountryCodeAndroid result2 = CountryCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) CountryCode.COUNTRY_CODE_VALUE_MAXIMUM;
        data[ 1] = (byte) (CountryCode.COUNTRY_CODE_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CountryCodeAndroid result1 = new CountryCodeAndroid(bluetoothGattCharacteristic);
        CountryCodeAndroid result2 = CountryCodeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
