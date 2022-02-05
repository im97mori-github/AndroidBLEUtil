package org.im97mori.ble.characteristic.u2aff;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.LuminousFluxUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class LuminousFluxAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getLuminousFlux());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getLuminousFlux());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getLuminousFlux());
    }

    @Test
    public void test_constructor_00101() {
        int luminousFlux = LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN;

        LuminousFluxAndroid result = new LuminousFluxAndroid(luminousFlux);
        assertEquals(luminousFlux, result.getLuminousFlux());
    }

    @Test
    public void test_constructor_00102() {
        int luminousFlux = LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM;

        LuminousFluxAndroid result = new LuminousFluxAndroid(luminousFlux);
        assertEquals(luminousFlux, result.getLuminousFlux());
    }

    @Test
    public void test_constructor_00103() {
        int luminousFlux = LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM;

        LuminousFluxAndroid result = new LuminousFluxAndroid(luminousFlux);
        assertEquals(luminousFlux, result.getLuminousFlux());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousFluxAndroid result2 = LuminousFluxAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousFlux(), result1.getLuminousFlux());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousFluxAndroid result2 = LuminousFluxAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousFlux(), result1.getLuminousFlux());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousFluxAndroid result2 = LuminousFluxAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousFlux(), result1.getLuminousFlux());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        LuminousFluxAndroid result2 = LuminousFluxAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MINIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        LuminousFluxAndroid result2 = LuminousFluxAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM;
        data[ 1] = (byte) (LuminousFluxUtils.LUMINOUS_FLUX_VALUE_MAXIMUM >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousFluxAndroid result1 = new LuminousFluxAndroid(bluetoothGattCharacteristic);
        LuminousFluxAndroid result2 = LuminousFluxAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
