package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class TwoZoneHeartRateLimitTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        TwoZoneHeartRateLimit result1 = new TwoZoneHeartRateLimit(bluetoothGattCharacteristic);
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

        TwoZoneHeartRateLimit result1 = new TwoZoneHeartRateLimit(bluetoothGattCharacteristic);
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

        TwoZoneHeartRateLimit result1 = new TwoZoneHeartRateLimit(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TwoZoneHeartRateLimit result2 = TwoZoneHeartRateLimit.CREATOR.createFromParcel(parcel);

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

        TwoZoneHeartRateLimit result1 = new TwoZoneHeartRateLimit(bluetoothGattCharacteristic);
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

        TwoZoneHeartRateLimit result1 = new TwoZoneHeartRateLimit(bluetoothGattCharacteristic);
        TwoZoneHeartRateLimit result2 = TwoZoneHeartRateLimit.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
