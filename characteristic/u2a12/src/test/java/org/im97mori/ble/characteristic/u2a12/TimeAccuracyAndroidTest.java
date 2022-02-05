package org.im97mori.ble.characteristic.u2a12;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"PointlessArithmeticExpression", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class TimeAccuracyAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeAccuracy.ACCURACY_OUT_OF_RANGE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        assertEquals(TimeAccuracy.ACCURACY_OUT_OF_RANGE, result1.getAccuracy());
        assertTrue(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) TimeAccuracy.ACCURACY_UNKNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        assertEquals(TimeAccuracy.ACCURACY_UNKNOWN, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertTrue(result1.isAccuracyUnknown());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        assertEquals(0, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(0 * TimeAccuracy.ACCURACY_UNIT, result1.getAccuracyMillis());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        assertEquals(253, result1.getAccuracy());
        assertFalse(result1.isAccuracyOutOfRange());
        assertFalse(result1.isAccuracyUnknown());
        assertEquals(253 * TimeAccuracy.ACCURACY_UNIT, result1.getAccuracyMillis());
    }

    @Test
    public void test_constructor_00101() {
        int accuracy = 1;

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(accuracy);
        assertEquals(accuracy, result1.getAccuracy());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeAccuracyAndroid result2 = TimeAccuracyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAccuracy(), result1.getAccuracy());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TimeAccuracyAndroid result1 = new TimeAccuracyAndroid(bluetoothGattCharacteristic);
        TimeAccuracyAndroid result2 = TimeAccuracyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
