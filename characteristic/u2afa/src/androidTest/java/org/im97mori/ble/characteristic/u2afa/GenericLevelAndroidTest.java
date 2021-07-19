package org.im97mori.ble.characteristic.u2afa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GenericLevelAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt48(data, 0), result.getGlobalTradeItemNumber());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912343L;
        data[ 1] = (byte) (12345678912343L >> 8);
        data[ 2] = (byte) (12345678912343L >> 16);
        data[ 3] = (byte) (12345678912343L >> 24);
        data[ 4] = (byte) (12345678912343L >> 32);
        data[ 5] = (byte) (12345678912343L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt48(data, 0), result.getGlobalTradeItemNumber());
        assertTrue(result.isValid());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912344L;
        data[ 1] = (byte) (12345678912344L >> 8);
        data[ 2] = (byte) (12345678912344L >> 16);
        data[ 3] = (byte) (12345678912344L >> 24);
        data[ 4] = (byte) (12345678912344L >> 32);
        data[ 5] = (byte) (12345678912344L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt48(data, 0), result.getGlobalTradeItemNumber());
        assertFalse(result.isValid());
    }

    @Test
    public void test_constructor_00101() {
        long globalTradeItemNumber = 1;

        GlobalTradeItemNumberAndroid result = new GlobalTradeItemNumberAndroid(globalTradeItemNumber);
        assertEquals(globalTradeItemNumber, result.getGlobalTradeItemNumber());
    }

    @Test
    public void test_constructor_00102() {
        long globalTradeItemNumber = 12345678912343L;

        GlobalTradeItemNumberAndroid result = new GlobalTradeItemNumberAndroid(globalTradeItemNumber);
        assertEquals(globalTradeItemNumber, result.getGlobalTradeItemNumber());
        assertTrue(result.isValid());
    }

    @Test
    public void test_constructor_00103() {
        long globalTradeItemNumber = 12345678912344L;

        GlobalTradeItemNumberAndroid result = new GlobalTradeItemNumberAndroid(globalTradeItemNumber);
        assertEquals(globalTradeItemNumber, result.getGlobalTradeItemNumber());
        assertFalse(result.isValid());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        GlobalTradeItemNumberAndroid result2 = GlobalTradeItemNumberAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getGlobalTradeItemNumber(), result1.getGlobalTradeItemNumber());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912343L;
        data[ 1] = (byte) (12345678912343L >> 8);
        data[ 2] = (byte) (12345678912343L >> 16);
        data[ 3] = (byte) (12345678912343L >> 24);
        data[ 4] = (byte) (12345678912343L >> 32);
        data[ 5] = (byte) (12345678912343L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        GlobalTradeItemNumberAndroid result2 = GlobalTradeItemNumberAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getGlobalTradeItemNumber(), result1.getGlobalTradeItemNumber());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912344L;
        data[ 1] = (byte) (12345678912344L >> 8);
        data[ 2] = (byte) (12345678912344L >> 16);
        data[ 3] = (byte) (12345678912344L >> 24);
        data[ 4] = (byte) (12345678912344L >> 32);
        data[ 5] = (byte) (12345678912344L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        GlobalTradeItemNumberAndroid result2 = GlobalTradeItemNumberAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getGlobalTradeItemNumber(), result1.getGlobalTradeItemNumber());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912343L;
        data[ 1] = (byte) (12345678912343L >> 8);
        data[ 2] = (byte) (12345678912343L >> 16);
        data[ 3] = (byte) (12345678912343L >> 24);
        data[ 4] = (byte) (12345678912343L >> 32);
        data[ 5] = (byte) (12345678912343L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912344L;
        data[ 1] = (byte) (12345678912344L >> 8);
        data[ 2] = (byte) (12345678912344L >> 16);
        data[ 3] = (byte) (12345678912344L >> 24);
        data[ 4] = (byte) (12345678912344L >> 32);
        data[ 5] = (byte) (12345678912344L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        GlobalTradeItemNumberAndroid result2 = GlobalTradeItemNumberAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912343L;
        data[ 1] = (byte) (12345678912343L >> 8);
        data[ 2] = (byte) (12345678912343L >> 16);
        data[ 3] = (byte) (12345678912343L >> 24);
        data[ 4] = (byte) (12345678912343L >> 32);
        data[ 5] = (byte) (12345678912343L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        GlobalTradeItemNumberAndroid result2 = GlobalTradeItemNumberAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) 12345678912344L;
        data[ 1] = (byte) (12345678912344L >> 8);
        data[ 2] = (byte) (12345678912344L >> 16);
        data[ 3] = (byte) (12345678912344L >> 24);
        data[ 4] = (byte) (12345678912344L >> 32);
        data[ 5] = (byte) (12345678912344L >> 40);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        GlobalTradeItemNumberAndroid result1 = new GlobalTradeItemNumberAndroid(bluetoothGattCharacteristic);
        GlobalTradeItemNumberAndroid result2 = GlobalTradeItemNumberAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
