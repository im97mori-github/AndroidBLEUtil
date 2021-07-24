package org.im97mori.ble.characteristic.u2b07;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.ElectricCurrentUtils;
import org.im97mori.ble.characteristic.core.Percentage8Utils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class RelativeRuntimeInACurrentRangeAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeRuntimeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumCurrent());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeRuntimeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumCurrent());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 100;
        data[ 1] = (byte) 65534;
        data[ 2] = (byte) (65534 >> 8);
        data[ 3] = (byte) 65534;
        data[ 4] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeRuntimeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumCurrent());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt8(data, 0), result.getRelativeRuntimeValue());
        assertEquals(BLEUtils.createUInt16(data, 1), result.getMinimumCurrent());
        assertEquals(BLEUtils.createUInt16(data, 3), result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00101() {
        int relativeRuntimeValue = Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        int minimumCurrent = ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        int maximumCurrent = ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(relativeRuntimeValue, minimumCurrent, maximumCurrent);
        assertEquals(relativeRuntimeValue, result.getRelativeRuntimeValue());
        assertEquals(minimumCurrent, result.getMinimumCurrent());
        assertEquals(maximumCurrent, result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00102() {
        int relativeRuntimeValue = 0;
        int minimumCurrent = 0;
        int maximumCurrent = 0;

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(relativeRuntimeValue, minimumCurrent, maximumCurrent);
        assertEquals(relativeRuntimeValue, result.getRelativeRuntimeValue());
        assertEquals(minimumCurrent, result.getMinimumCurrent());
        assertEquals(maximumCurrent, result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00103() {
        int relativeRuntimeValue = 100;
        int minimumCurrent = 65534;
        int maximumCurrent = 65534;

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(relativeRuntimeValue, minimumCurrent, maximumCurrent);
        assertEquals(relativeRuntimeValue, result.getRelativeRuntimeValue());
        assertEquals(minimumCurrent, result.getMinimumCurrent());
        assertEquals(maximumCurrent, result.getMaximumCurrent());
    }

    @Test
    public void test_constructor_00104() {
        int relativeRuntimeValue = 1;
        int minimumCurrent = 2;
        int maximumCurrent = 3;

        RelativeRuntimeInACurrentRangeAndroid result = new RelativeRuntimeInACurrentRangeAndroid(relativeRuntimeValue, minimumCurrent, maximumCurrent);
        assertEquals(relativeRuntimeValue, result.getRelativeRuntimeValue());
        assertEquals(minimumCurrent, result.getMinimumCurrent());
        assertEquals(maximumCurrent, result.getMaximumCurrent());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeRuntimeValue(), result1.getRelativeRuntimeValue());
        assertEquals(result2.getMinimumCurrent(), result1.getMinimumCurrent());
        assertEquals(result2.getMaximumCurrent(), result1.getMaximumCurrent());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeRuntimeValue(), result1.getRelativeRuntimeValue());
        assertEquals(result2.getMinimumCurrent(), result1.getMinimumCurrent());
        assertEquals(result2.getMaximumCurrent(), result1.getMaximumCurrent());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 100;
        data[ 1] = (byte) 65534;
        data[ 2] = (byte) (65534 >> 8);
        data[ 3] = (byte) 65534;
        data[ 4] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeRuntimeValue(), result1.getRelativeRuntimeValue());
        assertEquals(result2.getMinimumCurrent(), result1.getMinimumCurrent());
        assertEquals(result2.getMaximumCurrent(), result1.getMaximumCurrent());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getRelativeRuntimeValue(), result1.getRelativeRuntimeValue());
        assertEquals(result2.getMinimumCurrent(), result1.getMinimumCurrent());
        assertEquals(result2.getMaximumCurrent(), result1.getMaximumCurrent());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 100;
        data[ 1] = (byte) 65534;
        data[ 2] = (byte) (65534 >> 8);
        data[ 3] = (byte) 65534;
        data[ 4] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) Percentage8Utils.PERCENTAGE_8_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 2] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        data[ 3] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 4] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x00;
        data[ 1] = 0x00;
        data[ 2] = 0x00;
        data[ 3] = 0x00;
        data[ 4] = 0x00;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 100;
        data[ 1] = (byte) 65534;
        data[ 2] = (byte) (65534 >> 8);
        data[ 3] = (byte) 65534;
        data[ 4] = (byte) (65534 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RelativeRuntimeInACurrentRangeAndroid result1 = new RelativeRuntimeInACurrentRangeAndroid(bluetoothGattCharacteristic);
        RelativeRuntimeInACurrentRangeAndroid result2 = RelativeRuntimeInACurrentRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
