package org.im97mori.ble.characteristic.u2b17;

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
public class TimeSecond8AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result = new TimeSecond8Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getTimeSecond8());
        assertTrue(result.isTimeSecond8ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result = new TimeSecond8Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getTimeSecond8());
        assertFalse(result.isTimeSecond8ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result = new TimeSecond8Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getTimeSecond8());
        assertFalse(result.isTimeSecond8ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00101() {
        int energy = TimeSecond8.TIME_SECOND_8_VALUE_IS_NOT_KNOWN;

        TimeSecond8Android result = new TimeSecond8Android(energy);
        assertEquals(energy, result.getTimeSecond8());
        assertTrue(result.isTimeSecond8ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int energy = TimeSecond8.TIME_SECOND_8_VALUE_MINIMUM;

        TimeSecond8Android result = new TimeSecond8Android(energy);
        assertEquals(energy, result.getTimeSecond8());
        assertFalse(result.isTimeSecond8ValueIsNotKnown());
    }

    @Test
    public void test_constructor_00103() {
        int energy = TimeSecond8.TIME_SECOND_8_VALUE_MAXIMUM;

        TimeSecond8Android result = new TimeSecond8Android(energy);
        assertEquals(energy, result.getTimeSecond8());
        assertFalse(result.isTimeSecond8ValueIsNotKnown());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSecond8Android result2 = TimeSecond8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSecond8(), result1.getTimeSecond8());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSecond8Android result2 = TimeSecond8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSecond8(), result1.getTimeSecond8());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeSecond8Android result2 = TimeSecond8Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeSecond8(), result1.getTimeSecond8());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        TimeSecond8Android result2 = TimeSecond8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        TimeSecond8Android result2 = TimeSecond8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeSecond8.TIME_SECOND_8_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeSecond8Android result1 = new TimeSecond8Android(bluetoothGattCharacteristic);
        TimeSecond8Android result2 = TimeSecond8Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
