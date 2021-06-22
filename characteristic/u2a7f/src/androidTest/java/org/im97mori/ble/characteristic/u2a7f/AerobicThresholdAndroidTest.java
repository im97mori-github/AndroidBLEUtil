package org.im97mori.ble.characteristic.u2a7f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AerobicThresholdAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(0x00, result1.getAerobicThreshold());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getAerobicThreshold());
    }

    @Test
    public void test_constructor003() {
        int aerobicThreshold = 1;

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(aerobicThreshold);
        assertEquals(aerobicThreshold, result1.getAerobicThreshold());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AerobicThresholdAndroid result2 = AerobicThresholdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAerobicThreshold(), result1.getAerobicThreshold());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AerobicThresholdAndroid result1 = new AerobicThresholdAndroid(bluetoothGattCharacteristic);
        AerobicThresholdAndroid result2 = AerobicThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
