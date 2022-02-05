package org.im97mori.ble.characteristic.u2a88;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class FatBurnHeartRateLowerLimitAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FatBurnHeartRateLowerLimitAndroid result1 = new FatBurnHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
        assertEquals(0x00, result1.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FatBurnHeartRateLowerLimitAndroid result1 = new FatBurnHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
        assertEquals(0xff, result1.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_constructor003() {
        int fatBurnHeartRateLowerLimit = 1;

        FatBurnHeartRateLowerLimitAndroid result1 = new FatBurnHeartRateLowerLimitAndroid(fatBurnHeartRateLowerLimit);
        assertEquals(fatBurnHeartRateLowerLimit, result1.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FatBurnHeartRateLowerLimitAndroid result1 = new FatBurnHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FatBurnHeartRateLowerLimitAndroid result2 = FatBurnHeartRateLowerLimitAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFatBurnHeartRateLowerLimit(), result1.getFatBurnHeartRateLowerLimit());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FatBurnHeartRateLowerLimitAndroid result1 = new FatBurnHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
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

        FatBurnHeartRateLowerLimitAndroid result1 = new FatBurnHeartRateLowerLimitAndroid(bluetoothGattCharacteristic);
        FatBurnHeartRateLowerLimitAndroid result2 = FatBurnHeartRateLowerLimitAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
