package org.im97mori.ble.characteristic.u2a94;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class ThreeZoneHeartRateLimitsAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ThreeZoneHeartRateLimitsAndroid result1 = new ThreeZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        assertEquals(0x01, result1.getThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit());
        assertEquals(0x02, result1.getThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ThreeZoneHeartRateLimitsAndroid result1 = new ThreeZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit());
        assertEquals(0xff, result1.getThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit());
    }

    @Test
    public void test_constructor003() {
        int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit = 1;
        int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit = 2;

        ThreeZoneHeartRateLimitsAndroid result1 = new ThreeZoneHeartRateLimitsAndroid(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit);
        assertEquals(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, result1.getThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit());
        assertEquals(threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit, result1.getThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ThreeZoneHeartRateLimitsAndroid result1 = new ThreeZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ThreeZoneHeartRateLimitsAndroid result2 = ThreeZoneHeartRateLimitsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit(), result1.getThreeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit());
        assertEquals(result2.getThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit(), result1.getThreeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ThreeZoneHeartRateLimitsAndroid result1 = new ThreeZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ThreeZoneHeartRateLimitsAndroid result1 = new ThreeZoneHeartRateLimitsAndroid(bluetoothGattCharacteristic);
        ThreeZoneHeartRateLimitsAndroid result2 = ThreeZoneHeartRateLimitsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
