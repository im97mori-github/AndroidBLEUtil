package org.im97mori.ble.characteristic.u2a05;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ServiceChangedAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(0x0403, result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = (byte) 0xff;
        data[ 2] = 0x03;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff01, result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(0xff03, result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_constructor003() {
        int startOfAffectedAttributeHandleRange = 1;
        int endOfAffectedAttributeHandleRange = 2;

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(startOfAffectedAttributeHandleRange, endOfAffectedAttributeHandleRange);
        assertEquals(startOfAffectedAttributeHandleRange, result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(endOfAffectedAttributeHandleRange, result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceChangedAndroid result2 = ServiceChangedAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getStartOfAffectedAttributeHandleRange(), result1.getStartOfAffectedAttributeHandleRange());
        assertEquals(result2.getEndOfAffectedAttributeHandleRange(), result1.getEndOfAffectedAttributeHandleRange());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ServiceChangedAndroid result1 = new ServiceChangedAndroid(bluetoothGattCharacteristic);
        ServiceChangedAndroid result2 = ServiceChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
