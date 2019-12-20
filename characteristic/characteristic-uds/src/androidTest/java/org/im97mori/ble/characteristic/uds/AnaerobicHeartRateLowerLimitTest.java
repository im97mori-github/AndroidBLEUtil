package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AnaerobicHeartRateLowerLimitTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AnaerobicHeartRateLowerLimit result1 = new AnaerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
        assertEquals(0x00, result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AnaerobicHeartRateLowerLimit result1 = new AnaerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AnaerobicHeartRateLowerLimit result1 = new AnaerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AnaerobicHeartRateLowerLimit result2 = AnaerobicHeartRateLowerLimit.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAnaerobicHeartRateLowerLimit(), result1.getAnaerobicHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AnaerobicHeartRateLowerLimit result1 = new AnaerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
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

        AnaerobicHeartRateLowerLimit result1 = new AnaerobicHeartRateLowerLimit(bluetoothGattCharacteristic);
        AnaerobicHeartRateLowerLimit result2 = AnaerobicHeartRateLowerLimit.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
