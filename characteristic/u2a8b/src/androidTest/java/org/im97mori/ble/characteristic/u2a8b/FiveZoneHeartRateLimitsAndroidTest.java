package org.im97mori.ble.characteristic.u2a8b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FiveZoneHeartRateLimitsAndroidTest {

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

        FiveZoneHeartRateLimitsAndroid result1 = new FiveZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        assertEquals(0x01, result1.getFiveZoneHeartRateLimitsVeryLightLightLimit());
        assertEquals(0x02, result1.getFiveZoneHeartRateLimitsLightModerateLimit());
        assertEquals(0x03, result1.getFiveZoneHeartRateLimitsModerateHardLimit());
        assertEquals(0x04, result1.getFiveZoneHeartRateLimitsHardMaximumLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0xff;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FiveZoneHeartRateLimitsAndroid result1 = new FiveZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getFiveZoneHeartRateLimitsVeryLightLightLimit());
        assertEquals(0xff, result1.getFiveZoneHeartRateLimitsLightModerateLimit());
        assertEquals(0xff, result1.getFiveZoneHeartRateLimitsModerateHardLimit());
        assertEquals(0xff, result1.getFiveZoneHeartRateLimitsHardMaximumLimit());
    }

    @Test
    public void test_constructor003() {
        int fiveZoneHeartRateLimitsVeryLightLightLimit = 1;
        int fiveZoneHeartRateLimitsLightModerateLimit = 2;
        int fiveZoneHeartRateLimitsModerateHardLimit = 3;
        int fiveZoneHeartRateLimitsHardMaximumLimit = 4;

        FiveZoneHeartRateLimitsAndroid result1 = new FiveZoneHeartRateLimitsAndroid(fiveZoneHeartRateLimitsVeryLightLightLimit, fiveZoneHeartRateLimitsLightModerateLimit, fiveZoneHeartRateLimitsModerateHardLimit, fiveZoneHeartRateLimitsHardMaximumLimit);
        assertEquals(fiveZoneHeartRateLimitsVeryLightLightLimit, result1.getFiveZoneHeartRateLimitsVeryLightLightLimit());
        assertEquals(fiveZoneHeartRateLimitsLightModerateLimit, result1.getFiveZoneHeartRateLimitsLightModerateLimit());
        assertEquals(fiveZoneHeartRateLimitsModerateHardLimit, result1.getFiveZoneHeartRateLimitsModerateHardLimit());
        assertEquals(fiveZoneHeartRateLimitsHardMaximumLimit, result1.getFiveZoneHeartRateLimitsHardMaximumLimit());
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

        FiveZoneHeartRateLimitsAndroid result1 = new FiveZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FiveZoneHeartRateLimitsAndroid result2 = FiveZoneHeartRateLimitsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFiveZoneHeartRateLimitsVeryLightLightLimit(), result1.getFiveZoneHeartRateLimitsVeryLightLightLimit());
        assertEquals(result2.getFiveZoneHeartRateLimitsLightModerateLimit(), result1.getFiveZoneHeartRateLimitsLightModerateLimit());
        assertEquals(result2.getFiveZoneHeartRateLimitsModerateHardLimit(), result1.getFiveZoneHeartRateLimitsModerateHardLimit());
        assertEquals(result2.getFiveZoneHeartRateLimitsHardMaximumLimit(), result1.getFiveZoneHeartRateLimitsHardMaximumLimit());
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

        FiveZoneHeartRateLimitsAndroid result1 = new FiveZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
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

        FiveZoneHeartRateLimitsAndroid result1 = new FiveZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        FiveZoneHeartRateLimitsAndroid result2 = FiveZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
