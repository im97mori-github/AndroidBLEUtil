package org.im97mori.ble.characteristic.u2ae7;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Cie13_3_1995ColorRenderingIndexAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getColorRenderingIndex());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createSInt8(data, 0), result.getColorRenderingIndex());
    }

    @Test
    public void test_constructor_00101() {
        int colorRenderingIndex = Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(colorRenderingIndex);
        assertEquals(colorRenderingIndex, result.getColorRenderingIndex());
    }

    @Test
    public void test_constructor_00102() {
        int colorRenderingIndex = Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;

        Cie13_3_1995ColorRenderingIndexAndroid result = new Cie13_3_1995ColorRenderingIndexAndroid(colorRenderingIndex);
        assertEquals(colorRenderingIndex, result.getColorRenderingIndex());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getColorRenderingIndex(), result1.getColorRenderingIndex());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getColorRenderingIndex(), result1.getColorRenderingIndex());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MINIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) Cie13_3_1995ColorRenderingIndex.COLOR_RENDERING_INDEX_VALUE_MAXIMUM;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Cie13_3_1995ColorRenderingIndexAndroid result1 = new Cie13_3_1995ColorRenderingIndexAndroid(bluetoothGattCharacteristic);
        Cie13_3_1995ColorRenderingIndexAndroid result2 = Cie13_3_1995ColorRenderingIndexAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
