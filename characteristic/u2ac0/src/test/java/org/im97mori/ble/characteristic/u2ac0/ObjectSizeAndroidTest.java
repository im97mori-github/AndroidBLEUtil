package org.im97mori.ble.characteristic.u2ac0;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ObjectSizeAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data_00001 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectSizeAndroid result1 = new ObjectSizeAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt32(data, 0), result1.getCurrentSize());
        assertEquals(BLEUtils.createUInt32(data, 4), result1.getAllocatedSize());
    }

    @Test
    public void test_constructor_00101() {
        long currentSize = 1;
        long allocatedSize = 2;

        ObjectSizeAndroid result1 = new ObjectSizeAndroid(currentSize, allocatedSize);
        assertEquals(currentSize, result1.getCurrentSize());
        assertEquals(allocatedSize, result1.getAllocatedSize());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectSizeAndroid result1 = new ObjectSizeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectSizeAndroid result2 = ObjectSizeAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCurrentSize(), result2.getCurrentSize());
        assertEquals(result1.getAllocatedSize(), result2.getAllocatedSize());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectSizeAndroid result1 = new ObjectSizeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ObjectSizeAndroid result1 = new ObjectSizeAndroid(bluetoothGattCharacteristic);
        ObjectSizeAndroid result2 = ObjectSizeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
