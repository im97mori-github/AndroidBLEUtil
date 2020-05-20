package org.im97mori.ble.characteristic.u2a23;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class SystemIdAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SystemIdAndroid result1 = new SystemIdAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0504030201L, result1.getManufacturerIdentifier());
        assertEquals(0x080706, result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = (byte) 0xff;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SystemIdAndroid result1 = new SystemIdAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff04030201L, result1.getManufacturerIdentifier());
        assertEquals(0xff0706, result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_constructor003() {
        long manufacturerIdentifier = 1;
        int organizationallyUniqueIdentifier = 2;

        SystemIdAndroid result1 = new SystemIdAndroid(manufacturerIdentifier, organizationallyUniqueIdentifier);
        assertEquals(manufacturerIdentifier, result1.getManufacturerIdentifier());
        assertEquals(organizationallyUniqueIdentifier, result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SystemIdAndroid result1 = new SystemIdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SystemIdAndroid result2 = SystemIdAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getManufacturerIdentifier(), result1.getManufacturerIdentifier());
        assertEquals(result2.getOrganizationallyUniqueIdentifier(), result1.getOrganizationallyUniqueIdentifier());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SystemIdAndroid result1 = new SystemIdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SystemIdAndroid result1 = new SystemIdAndroid(bluetoothGattCharacteristic);
        SystemIdAndroid result2 = SystemIdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
