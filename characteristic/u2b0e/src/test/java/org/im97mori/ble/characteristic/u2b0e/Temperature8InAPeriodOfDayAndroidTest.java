package org.im97mori.ble.characteristic.u2b0e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Temperature8Utils;
import org.im97mori.ble.characteristic.core.TimeDecihour8Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class Temperature8InAPeriodOfDayAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Temperature8Utils.TEMPERATURE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getTemperature());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = -128;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getTemperature());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 126;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getTemperature());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
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

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getTemperature());
        assertEquals(BLEUtils.createUInt8(data, 1), result.getStartTime());
        assertEquals(BLEUtils.createUInt8(data, 2), result.getEndTime());
    }

    @Test
    public void test_constructor_00101() {
        int relativeValue = Temperature8Utils.TEMPERATURE_8_VALUE_IS_NOT_KNOWN;
        int startTime = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        int endTime = TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getTemperature());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00102() {
        int relativeValue = -128;
        int startTime = 0;
        int endTime = 0;

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getTemperature());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00103() {
        int relativeValue = 126;
        int startTime = 240;
        int endTime = 240;

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getTemperature());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_constructor_00104() {
        int relativeValue = 1;
        int startTime = 2;
        int endTime = 3;

        Temperature8InAPeriodOfDayAndroid result = new Temperature8InAPeriodOfDayAndroid(relativeValue, startTime, endTime);
        assertEquals(relativeValue, result.getTemperature());
        assertEquals(startTime, result.getStartTime());
        assertEquals(endTime, result.getEndTime());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Temperature8Utils.TEMPERATURE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTemperature(), result1.getTemperature());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = -128;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTemperature(), result1.getTemperature());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 126;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTemperature(), result1.getTemperature());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
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

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTemperature(), result1.getTemperature());
        assertEquals(result2.getStartTime(), result1.getStartTime());
        assertEquals(result2.getEndTime(), result1.getEndTime());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Temperature8Utils.TEMPERATURE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = -128;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 126;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
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

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) Temperature8Utils.TEMPERATURE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) TimeDecihour8Utils.TIME_DECIHOUR_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = -128;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 126;
        data[ 1] = (byte) 240;
        data[ 2] = (byte) 240;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
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

        Temperature8InAPeriodOfDayAndroid result1 = new Temperature8InAPeriodOfDayAndroid(bluetoothGattCharacteristic);
        Temperature8InAPeriodOfDayAndroid result2 = Temperature8InAPeriodOfDayAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
