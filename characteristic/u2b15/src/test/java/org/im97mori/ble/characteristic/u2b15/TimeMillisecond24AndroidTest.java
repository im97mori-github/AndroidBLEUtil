package org.im97mori.ble.characteristic.u2b15;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeMillisecond24AndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeMillisecond24());
        assertTrue(result.isTimeMillisecond24IsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_MINIMUM, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_MAXIMUM, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 1;
        data[ 1] = 1 >> 8;
        data[ 2] = 1 >> 16;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_UNIT * 1, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_constructor_00101() {
        int timeMillisecond24 = TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN;

        TimeMillisecond24Android result = new TimeMillisecond24Android(timeMillisecond24);
        assertEquals(timeMillisecond24, result.getTimeMillisecond24());
        assertTrue(result.isTimeMillisecond24IsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int timeMillisecond24 = 0;

        TimeMillisecond24Android result = new TimeMillisecond24Android(timeMillisecond24);
        assertEquals(timeMillisecond24, result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_MINIMUM, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_constructor_00103() {
        int timeMillisecond24 = 16777214;

        TimeMillisecond24Android result = new TimeMillisecond24Android(timeMillisecond24);
        assertEquals(timeMillisecond24, result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_MAXIMUM, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_constructor_00104() {
        int timeMillisecond24 = 1;

        TimeMillisecond24Android result = new TimeMillisecond24Android(timeMillisecond24);
        assertEquals(timeMillisecond24, result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_UNIT * 1, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_constructor_00105() {
        int timeMillisecond24 = -1;

        TimeMillisecond24Android result = new TimeMillisecond24Android(timeMillisecond24);
        assertEquals(timeMillisecond24, result.getTimeMillisecond24());
        assertFalse(result.isTimeMillisecond24IsNotKnown());
        assertEquals(TimeMillisecond24.TIME_MILLISECOND_24_VALUE_MINIMUM, result.geTimeMillisecond24Second(), 0);
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeMillisecond24(), result1.getTimeMillisecond24());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeMillisecond24(), result1.getTimeMillisecond24());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeMillisecond24(), result1.getTimeMillisecond24());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 1;
        data[ 1] = 1 >> 8;
        data[ 2] = 1 >> 16;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTimeMillisecond24(), result1.getTimeMillisecond24());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 1;
        data[ 1] = 1 >> 8;
        data[ 2] = 1 >> 16;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (TimeMillisecond24.TIME_MILLISECOND_24_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777214;
        data[ 1] = (byte) (16777214 >> 8);
        data[ 2] = (byte) (16777214 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 1;
        data[ 1] = 1 >> 8;
        data[ 2] = 1 >> 16;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeMillisecond24Android result1 = new TimeMillisecond24Android(bluetoothGattCharacteristic);
        TimeMillisecond24Android result2 = TimeMillisecond24Android.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
