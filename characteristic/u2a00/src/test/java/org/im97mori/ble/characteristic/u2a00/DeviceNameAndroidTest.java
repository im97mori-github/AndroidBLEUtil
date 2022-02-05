package org.im97mori.ble.characteristic.u2a00;

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

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class DeviceNameAndroidTest {

    @Test
    public void test_constructor001() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        DeviceNameAndroid result1 = new DeviceNameAndroid(bluetoothGattCharacteristic);
        assertEquals(name, result1.getName());
    }

    @Test
    public void test_constructor002() {
        String name = "Rbt-Sensor";

        DeviceNameAndroid result1 = new DeviceNameAndroid(name);
        assertEquals(name, result1.getName());
    }

    @Test
    public void test_parcelable001() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        DeviceNameAndroid result1 = new DeviceNameAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DeviceNameAndroid result2 = DeviceNameAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getName(), result2.getName());
    }

    @Test
    public void test_parcelable002() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        DeviceNameAndroid result1 = new DeviceNameAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(name.getBytes(), resultData);
    }

    @Test
    public void test_parcelable003() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        DeviceNameAndroid result1 = new DeviceNameAndroid(bluetoothGattCharacteristic);
        DeviceNameAndroid result2 = DeviceNameAndroid.CREATOR.createFromByteArray(name.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
