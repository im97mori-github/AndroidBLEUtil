package org.im97mori.ble.characteristic.u2abe;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ObjectNameAndroidTest {

    @Test
    public void test_constructor_00001() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        ObjectNameAndroid result1 = new ObjectNameAndroid(bluetoothGattCharacteristic);
        assertEquals(name, result1.getObjectName());
    }

    @Test
    public void test_constructor_00002() {
        String name = "Rbt-Sensor";

        ObjectNameAndroid result1 = new ObjectNameAndroid(name);
        assertEquals(name, result1.getObjectName());
    }

    @Test
    public void test_parcelable_00001() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        ObjectNameAndroid result1 = new ObjectNameAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getObjectName(), result2.getObjectName());
    }

    @Test
    public void test_parcelable_00101() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        ObjectNameAndroid result1 = new ObjectNameAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(name.getBytes(), resultData);
    }

    @Test
    public void test_parcelable_00201() {
        String name = "Rbt-Sensor";

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(name.getBytes());

        ObjectNameAndroid result1 = new ObjectNameAndroid(bluetoothGattCharacteristic);
        ObjectNameAndroid result2 = ObjectNameAndroid.CREATOR.createFromByteArray(name.getBytes());
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
