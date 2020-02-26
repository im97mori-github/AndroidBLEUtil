package org.im97mori.ble.characteristic.u2b2a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseHashAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DatabaseHashAndroid result1 = new DatabaseHashAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getDatabaseHash());
        assertEquals(0x04030201, result1.getDatabaseHashBigInteger().intValue());
        assertEquals(0x08070605, result1.getDatabaseHashBigInteger().shiftRight(32).intValue());
        assertEquals(0x0c0b0a09, result1.getDatabaseHashBigInteger().shiftRight(64).intValue());
        assertEquals(0x100f0e0d, result1.getDatabaseHashBigInteger().shiftRight(96).intValue());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DatabaseHashAndroid result1 = new DatabaseHashAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getDatabaseHash());
        assertEquals(0x04030201, result1.getDatabaseHashBigInteger().intValue());
        assertEquals(0x08070605, result1.getDatabaseHashBigInteger().shiftRight(32).intValue());
        assertEquals(0x0c0b0a09, result1.getDatabaseHashBigInteger().shiftRight(64).intValue());
        assertEquals(0xff0f0e0d, result1.getDatabaseHashBigInteger().shiftRight(96).intValue());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DatabaseHashAndroid result1 = new DatabaseHashAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DatabaseHashAndroid result2 = DatabaseHashAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getDatabaseHash(), result1.getDatabaseHash());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DatabaseHashAndroid result1 = new DatabaseHashAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[16];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 8] = 0x09;
        data[ 9] = 0x0a;
        data[10] = 0x0b;
        data[11] = 0x0c;
        data[12] = 0x0d;
        data[13] = 0x0e;
        data[14] = 0x0f;
        data[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        DatabaseHashAndroid result1 = new DatabaseHashAndroid(bluetoothGattCharacteristic);
        DatabaseHashAndroid result2 = DatabaseHashAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
