package org.im97mori.ble.characteristic.u2abf;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;

public class ObjectTypeAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(value, result.getObjectType());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] value = new byte[16];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        value[ 9] = 0x0a;
        value[10] = 0x0b;
        value[11] = 0x0c;
        value[12] = 0x0d;
        value[13] = 0x0e;
        value[14] = 0x0f;
        value[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(value, result.getObjectType());
    }

    @Test
    public void test_constructor_00101() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        int uuid = BLEUtils.createUInt16(value, 0);

        ObjectTypeAndroid result = new ObjectTypeAndroid(uuid);
        assertArrayEquals(value, result.getObjectType());
    }

    @Test
    public void test_constructor_00102() {
        //@formatter:off
        byte[] value = new byte[16];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        value[ 9] = 0x0a;
        value[10] = 0x0b;
        value[11] = 0x0c;
        value[12] = 0x0d;
        value[13] = 0x0e;
        value[14] = 0x0f;
        value[15] = 0x10;
        //@formatter:on

        ByteBuffer bb = ByteBuffer.wrap(value, 0, 16).order(ByteOrder.LITTLE_ENDIAN);
        long lsb = bb.getLong();
        long msb = bb.getLong();

        UUID uuid = new UUID(msb, lsb);

        ObjectTypeAndroid result = new ObjectTypeAndroid(uuid);
        assertArrayEquals(value, result.getObjectType());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result1 = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectTypeAndroid result2 = ObjectTypeAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getObjectType(), result2.getObjectType());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] value = new byte[16];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        value[ 9] = 0x0a;
        value[10] = 0x0b;
        value[11] = 0x0c;
        value[12] = 0x0d;
        value[13] = 0x0e;
        value[14] = 0x0f;
        value[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result1 = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ObjectTypeAndroid result2 = ObjectTypeAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getObjectType(), result2.getObjectType());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result1 = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(value, resultData);
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] value = new byte[16];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        value[ 9] = 0x0a;
        value[10] = 0x0b;
        value[11] = 0x0c;
        value[12] = 0x0d;
        value[13] = 0x0e;
        value[14] = 0x0f;
        value[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result1 = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(value, resultData);
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result1 = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        ObjectTypeAndroid result2 = ObjectTypeAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
//@formatter:off
        byte[] value = new byte[16];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        value[ 9] = 0x0a;
        value[10] = 0x0b;
        value[11] = 0x0c;
        value[12] = 0x0d;
        value[13] = 0x0e;
        value[14] = 0x0f;
        value[15] = 0x10;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(value);

        ObjectTypeAndroid result1 = new ObjectTypeAndroid(bluetoothGattCharacteristic);
        ObjectTypeAndroid result2 = ObjectTypeAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
