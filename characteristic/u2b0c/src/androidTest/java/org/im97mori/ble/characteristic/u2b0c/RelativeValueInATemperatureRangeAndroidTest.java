package org.im97mori.ble.characteristic.u2b0c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Percentage8Utils;
import org.im97mori.ble.characteristic.core.TemperatureUtils;
import org.im97mori.ble.characteristic.core.TimeDecihour8Utils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class RelativeValueInATemperatureRangeAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getMinimumTemperatureValue());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = (byte) -27315;
        data[ 2] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getMinimumTemperatureValue());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 32767;
        data[ 2] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getMinimumTemperatureValue());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeValue());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getMinimumTemperatureValue());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00101() {
        int relativeValue = Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        int minimumTemperatureValue = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        int maximumTemperatureValue = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(relativeValue, minimumTemperatureValue, maximumTemperatureValue);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumTemperatureValue, result.getMinimumTemperatureValue());
        assertEquals(maximumTemperatureValue, result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00102() {
        int relativeValue = 0;
        int minimumTemperatureValue = -27315;
        int maximumTemperatureValue = -27315;

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(relativeValue, minimumTemperatureValue, maximumTemperatureValue);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumTemperatureValue, result.getMinimumTemperatureValue());
        assertEquals(maximumTemperatureValue, result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00103() {
        int relativeValue = 200;
        int minimumTemperatureValue = 32767;
        int maximumTemperatureValue = 32767;

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(relativeValue, minimumTemperatureValue, maximumTemperatureValue);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumTemperatureValue, result.getMinimumTemperatureValue());
        assertEquals(maximumTemperatureValue, result.getMaximumTemperatureValue());
    }

    @Test
    public void test_constructor_00104() {
        int relativeValue = 1;
        int minimumTemperatureValue = 2;
        int maximumTemperatureValue = 3;

        RelativeValueInATemperatureRangeAndroid result = new RelativeValueInATemperatureRangeAndroid(relativeValue, minimumTemperatureValue, maximumTemperatureValue);
        assertEquals(relativeValue, result.getRelativeValue());
        assertEquals(minimumTemperatureValue, result.getMinimumTemperatureValue());
        assertEquals(maximumTemperatureValue, result.getMaximumTemperatureValue());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumTemperatureValue(), result1.getMinimumTemperatureValue());
        assertEquals(result2.getMaximumTemperatureValue(), result1.getMaximumTemperatureValue());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = (byte) -27315;
        data[ 2] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumTemperatureValue(), result1.getMinimumTemperatureValue());
        assertEquals(result2.getMaximumTemperatureValue(), result1.getMaximumTemperatureValue());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 32767;
        data[ 2] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumTemperatureValue(), result1.getMinimumTemperatureValue());
        assertEquals(result2.getMaximumTemperatureValue(), result1.getMaximumTemperatureValue());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeValue(), result1.getRelativeValue());
        assertEquals(result2.getMinimumTemperatureValue(), result1.getMinimumTemperatureValue());
        assertEquals(result2.getMaximumTemperatureValue(), result1.getMaximumTemperatureValue());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = (byte) -27315;
        data[ 2] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 32767;
        data[ 2] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = (byte) -27315;
        data[ 2] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 200;
        data[ 1] = (byte) 32767;
        data[ 2] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeValueInATemperatureRangeAndroid result1 = new RelativeValueInATemperatureRangeAndroid(bluetoothGattCharacteristic);
        RelativeValueInATemperatureRangeAndroid result2 = RelativeValueInATemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
