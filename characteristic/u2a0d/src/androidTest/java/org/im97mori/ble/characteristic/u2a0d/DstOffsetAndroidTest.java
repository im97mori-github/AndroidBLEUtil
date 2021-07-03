package org.im97mori.ble.characteristic.u2a0d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DstOffsetUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class DstOffsetAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        assertEquals(DstOffsetUtils.DST_OFFSET_STANDARD_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        assertEquals(DstOffsetUtils.DST_OFFSET_HALF_AN_HOUR_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        assertEquals(DstOffsetUtils.DST_OFFSET_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        assertEquals(DstOffsetUtils.DST_OFFSET_DOUBLE_DAYLIGHT_TIME, result1.getDstOffset());
    }

    @Test
    public void test_constructor_00101() {
        int dstOffset = 1;

        DstOffsetAndroid result1 = new DstOffsetAndroid(dstOffset);
        assertEquals(dstOffset, result1.getDstOffset());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DstOffsetAndroid result2 = DstOffsetAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDstOffset(), result1.getDstOffset());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = DstOffsetUtils.DST_OFFSET_STANDARD_TIME;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DstOffsetAndroid result1 = new DstOffsetAndroid(bluetoothGattCharacteristic);
        DstOffsetAndroid result2 = DstOffsetAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
