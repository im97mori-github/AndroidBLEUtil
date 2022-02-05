package org.im97mori.ble.characteristic.u2b10;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.TemperatureUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TemperatureRangeAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getMinimumTemperature());
        assertEquals(BLEUtils.createSInt16(data, 2), result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) -27315;
        data[ 1] = (byte) (-27315 >> 8);
        data[ 2] = (byte) -27315;
        data[ 3] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getMinimumTemperature());
        assertEquals(BLEUtils.createSInt16(data, 2), result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 32767;
        data[ 1] = (byte) (32767 >> 8);
        data[ 2] = (byte) 32767;
        data[ 3] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getMinimumTemperature());
        assertEquals(BLEUtils.createSInt16(data, 2), result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getMinimumTemperature());
        assertEquals(BLEUtils.createSInt16(data, 2), result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00101() {
        int minimumTemperature = TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        int maximumTemperature = TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(minimumTemperature, maximumTemperature);
        assertEquals(minimumTemperature, result.getMinimumTemperature());
        assertEquals(maximumTemperature, result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00102() {
        int minimumTemperature = -27315;
        int maximumTemperature = -27315;

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(minimumTemperature, maximumTemperature);
        assertEquals(minimumTemperature, result.getMinimumTemperature());
        assertEquals(maximumTemperature, result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00103() {
        int minimumTemperature = 32767;
        int maximumTemperature = 32767;

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(minimumTemperature, maximumTemperature);
        assertEquals(minimumTemperature, result.getMinimumTemperature());
        assertEquals(maximumTemperature, result.getMaximumTemperature());
    }

    @Test
    public void test_constructor_00104() {
        int minimumTemperature = 1;
        int maximumTemperature = 2;

        TemperatureRangeAndroid result = new TemperatureRangeAndroid(minimumTemperature, maximumTemperature);
        assertEquals(minimumTemperature, result.getMinimumTemperature());
        assertEquals(maximumTemperature, result.getMaximumTemperature());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumTemperature(), result1.getMinimumTemperature());
        assertEquals(result2.getMaximumTemperature(), result1.getMaximumTemperature());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) -27315;
        data[ 1] = (byte) (-27315 >> 8);
        data[ 2] = (byte) -27315;
        data[ 3] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumTemperature(), result1.getMinimumTemperature());
        assertEquals(result2.getMaximumTemperature(), result1.getMaximumTemperature());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 32767;
        data[ 1] = (byte) (32767 >> 8);
        data[ 2] = (byte) 32767;
        data[ 3] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumTemperature(), result1.getMinimumTemperature());
        assertEquals(result2.getMaximumTemperature(), result1.getMaximumTemperature());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMinimumTemperature(), result1.getMinimumTemperature());
        assertEquals(result2.getMaximumTemperature(), result1.getMaximumTemperature());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) -27315;
        data[ 1] = (byte) (-27315 >> 8);
        data[ 2] = (byte) -27315;
        data[ 3] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 32767;
        data[ 1] = (byte) (32767 >> 8);
        data[ 2] = (byte) 32767;
        data[ 3] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (TemperatureUtils.TEMPERATURE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) -27315;
        data[ 1] = (byte) (-27315 >> 8);
        data[ 2] = (byte) -27315;
        data[ 3] = (byte) (-27315 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 32767;
        data[ 1] = (byte) (32767 >> 8);
        data[ 2] = (byte) 32767;
        data[ 3] = (byte) (32767 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TemperatureRangeAndroid result1 = new TemperatureRangeAndroid(bluetoothGattCharacteristic);
        TemperatureRangeAndroid result2 = TemperatureRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
