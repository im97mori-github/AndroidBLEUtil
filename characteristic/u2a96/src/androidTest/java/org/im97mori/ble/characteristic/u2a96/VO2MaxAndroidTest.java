package org.im97mori.ble.characteristic.u2a96;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VO2MaxAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VO2MaxAndroid result1 = new VO2MaxAndroid(bluetoothGattCharacteristic);
        assertEquals(0x00, result1.getVo2Max());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VO2MaxAndroid result1 = new VO2MaxAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getVo2Max());
    }

    @Test
    public void test_constructor003() {
        int vo2Max = 1;

        VO2MaxAndroid result1 = new VO2MaxAndroid(vo2Max);
        assertEquals(vo2Max, result1.getVo2Max());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VO2MaxAndroid result1 = new VO2MaxAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VO2MaxAndroid result2 = VO2MaxAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVo2Max(), result1.getVo2Max());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VO2MaxAndroid result1 = new VO2MaxAndroid(bluetoothGattCharacteristic);
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

        VO2MaxAndroid result1 = new VO2MaxAndroid(bluetoothGattCharacteristic);
        VO2MaxAndroid result2 = VO2MaxAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
