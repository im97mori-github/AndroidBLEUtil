package org.im97mori.ble.characteristic.u2aea;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.Count16Utils;
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
public class Count16AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result = new Count16Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCount());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result = new Count16Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCount());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result = new Count16Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCount());
    }

    @Test
    public void test_constructor_00101() {
        int count = Count16Utils.COUNT_IS_NOT_KNOWN;

        Count16Android result = new Count16Android(count);
        assertEquals(count, result.getCount());
    }

    @Test
    public void test_constructor_00102() {
        int count = Count16Utils.COUNT_VALUE_MINIMUM;

        Count16Android result = new Count16Android(count);
        assertEquals(count, result.getCount());
    }

    @Test
    public void test_constructor_00103() {
        int count = Count16Utils.COUNT_VALUE_MAXIMUM;

        Count16Android result = new Count16Android(count);
        assertEquals(count, result.getCount());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Count16Android result2 = Count16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCount(), result1.getCount());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Count16Android result2 = Count16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCount(), result1.getCount());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Count16Android result2 = Count16Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCount(), result1.getCount());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_IS_NOT_KNOWN;
        data[ 1] = (byte) (Count16Utils.COUNT_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        Count16Android result2 = Count16Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MINIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        Count16Android result2 = Count16Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) Count16Utils.COUNT_VALUE_MAXIMUM;
        data[ 1] = (byte) (Count16Utils.COUNT_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        Count16Android result1 = new Count16Android(bluetoothGattCharacteristic);
        Count16Android result2 = Count16Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
