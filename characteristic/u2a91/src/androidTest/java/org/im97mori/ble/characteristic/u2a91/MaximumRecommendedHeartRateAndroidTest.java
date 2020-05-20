package org.im97mori.ble.characteristic.u2a91;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MaximumRecommendedHeartRateAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MaximumRecommendedHeartRateAndroid result1 = new MaximumRecommendedHeartRateAndroid(bluetoothGattCharacteristic);
        assertEquals(0x00, result1.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MaximumRecommendedHeartRateAndroid result1 = new MaximumRecommendedHeartRateAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_constructor003() {
        int maximumRecommendedHeartRate = 1;

        MaximumRecommendedHeartRateAndroid result1 = new MaximumRecommendedHeartRateAndroid(maximumRecommendedHeartRate);
        assertEquals(maximumRecommendedHeartRate, result1.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MaximumRecommendedHeartRateAndroid result1 = new MaximumRecommendedHeartRateAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MaximumRecommendedHeartRateAndroid result2 = MaximumRecommendedHeartRateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getMaximumRecommendedHeartRate(), result1.getMaximumRecommendedHeartRate());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MaximumRecommendedHeartRateAndroid result1 = new MaximumRecommendedHeartRateAndroid(bluetoothGattCharacteristic);
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

        MaximumRecommendedHeartRateAndroid result1 = new MaximumRecommendedHeartRateAndroid(bluetoothGattCharacteristic);
        MaximumRecommendedHeartRateAndroid result2 = MaximumRecommendedHeartRateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
