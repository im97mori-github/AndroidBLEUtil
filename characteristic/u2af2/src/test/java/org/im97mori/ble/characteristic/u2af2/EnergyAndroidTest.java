package org.im97mori.ble.characteristic.u2af2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.EnergyUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EnergyAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result = new EnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergy());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result = new EnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergy());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result = new EnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getEnergy());
    }

    @Test
    public void test_constructor_00101() {
        int energy = EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;

        EnergyAndroid result = new EnergyAndroid(energy);
        assertEquals(energy, result.getEnergy());
    }

    @Test
    public void test_constructor_00102() {
        int energy = EnergyUtils.ENERGY_VALUE_MINIMUM;

        EnergyAndroid result = new EnergyAndroid(energy);
        assertEquals(energy, result.getEnergy());
    }

    @Test
    public void test_constructor_00103() {
        int energy = EnergyUtils.ENERGY_VALUE_MAXIMUM;

        EnergyAndroid result = new EnergyAndroid(energy);
        assertEquals(energy, result.getEnergy());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyAndroid result2 = EnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergy(), result1.getEnergy());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyAndroid result2 = EnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergy(), result1.getEnergy());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnergyAndroid result2 = EnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEnergy(), result1.getEnergy());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        EnergyAndroid result2 = EnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MINIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MINIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        EnergyAndroid result2 = EnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) EnergyUtils.ENERGY_VALUE_MAXIMUM;
        data[ 1] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 8);
        data[ 2] = (byte) (EnergyUtils.ENERGY_VALUE_MAXIMUM >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnergyAndroid result1 = new EnergyAndroid(bluetoothGattCharacteristic);
        EnergyAndroid result2 = EnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
