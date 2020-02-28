package org.im97mori.ble.characteristic.u2a95;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TwoZoneHeartRateLimitAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TwoZoneHeartRateLimitAndroid result1 = new TwoZoneHeartRateLimitAndroid(bluetoothGattCharacteristic);
        assertEquals(0x01, result1.getTwoZoneHeartRateLimitFatBurnFitnessLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TwoZoneHeartRateLimitAndroid result1 = new TwoZoneHeartRateLimitAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getTwoZoneHeartRateLimitFatBurnFitnessLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TwoZoneHeartRateLimitAndroid result1 = new TwoZoneHeartRateLimitAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TwoZoneHeartRateLimitAndroid result2 = TwoZoneHeartRateLimitAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTwoZoneHeartRateLimitFatBurnFitnessLimit(), result1.getTwoZoneHeartRateLimitFatBurnFitnessLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TwoZoneHeartRateLimitAndroid result1 = new TwoZoneHeartRateLimitAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TwoZoneHeartRateLimitAndroid result1 = new TwoZoneHeartRateLimitAndroid(bluetoothGattCharacteristic);
        TwoZoneHeartRateLimitAndroid result2 = TwoZoneHeartRateLimitAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
