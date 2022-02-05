package org.im97mori.ble.characteristic.u2afb;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.IlluminanceUtils;
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
public class IlluminanceAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result = new IlluminanceAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getIlluminance());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result = new IlluminanceAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getIlluminance());
    }

    @Test
    public void test_constructor_00101() {
        int illuminance = IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN;

        IlluminanceAndroid result = new IlluminanceAndroid(illuminance);
        assertEquals(illuminance, result.getIlluminance());
    }

    @Test
    public void test_constructor_00102() {
        int illuminance = 1;

        IlluminanceAndroid result = new IlluminanceAndroid(illuminance);
        assertEquals(illuminance, result.getIlluminance());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result1 = new IlluminanceAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IlluminanceAndroid result2 = IlluminanceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getIlluminance(), result1.getIlluminance());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result1 = new IlluminanceAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        IlluminanceAndroid result2 = IlluminanceAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getIlluminance(), result1.getIlluminance());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result1 = new IlluminanceAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result1 = new IlluminanceAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (IlluminanceUtils.ILLUMINANCE_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result1 = new IlluminanceAndroid(bluetoothGattCharacteristic);
        IlluminanceAndroid result2 = IlluminanceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        IlluminanceAndroid result1 = new IlluminanceAndroid(bluetoothGattCharacteristic);
        IlluminanceAndroid result2 = IlluminanceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
