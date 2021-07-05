package org.im97mori.ble.characteristic.u2aee;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.ElectricCurrentUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"PointlessBitwiseExpression", "ConstantConditions"})
public class ElectricCurrentAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN, result.getCurrent());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCurrent());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCurrent());
    }

    @Test
    public void test_constructor_00101() {
        int current = ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(current);
        assertEquals(current, result.getCurrent());
    }

    @Test
    public void test_constructor_00102() {
        int current = 0;

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(current);
        assertEquals(current, result.getCurrent());
    }

    @Test
    public void test_constructor_00103() {
        int current = 65534;

        ElectricCurrentAndroid result = new ElectricCurrentAndroid(current);
        assertEquals(current, result.getCurrent());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrent(), result1.getCurrent());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrent(), result1.getCurrent());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCurrent(), result1.getCurrent());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0;
        data[ 1] = (byte) (0 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 65534;
        data[ 1] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ElectricCurrentAndroid result1 = new ElectricCurrentAndroid(bluetoothGattCharacteristic);
        ElectricCurrentAndroid result2 = ElectricCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
