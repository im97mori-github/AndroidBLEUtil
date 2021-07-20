package org.im97mori.ble.characteristic.u2afd;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("ConstantConditions")
public class LuminousEnergyAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousEnergy());
        assertTrue(result.isLuminousEnergyValueIsNotKnown());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt24(data, 0), result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(BLEUtils.createUInt24(data, 0) * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00101() {
        int luminousEnergy = LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN;

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertTrue(result.isLuminousEnergyValueIsNotKnown());
    }

    @Test
    public void test_constructor_00102() {
        int luminousEnergy = (int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(luminousEnergy * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00103() {
        int luminousEnergy = (int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(luminousEnergy * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00104() {
        int luminousEnergy = 16777216;

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00105() {
        int luminousEnergy = 1;

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(luminousEnergy * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00106() {
        int luminousEnergy = 16777213;

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(luminousEnergy * LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_constructor_00107() {
        int luminousEnergy = -1;

        LuminousEnergyAndroid result = new LuminousEnergyAndroid(luminousEnergy);
        assertEquals(luminousEnergy, result.getLuminousEnergy());
        assertFalse(result.isLuminousEnergyValueIsNotKnown());
        assertEquals(LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM, result.getLuminousEfficacyLumenHour(), 0);
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousEnergy(), result1.getLuminousEnergy());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousEnergy(), result1.getLuminousEnergy());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousEnergy(), result1.getLuminousEnergy());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousEnergy(), result1.getLuminousEnergy());
    }

    @Test
    public void test_parcelable_00005() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLuminousEnergy(), result1.getLuminousEnergy());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_IS_NOT_KNOWN >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MINIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT);
        data[ 1] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 8);
        data[ 2] = (byte) (((int) (LuminousEnergy.LUMINOUS_ENERGY_VALUE_MAXIMUM / LuminousEnergy.LUMINOUS_ENERGY_VALUE_UNIT)) >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 1;
        data[ 1] = (byte) (1 >> 8);
        data[ 2] = (byte) (1 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) 16777213;
        data[ 1] = (byte) (16777213 >> 8);
        data[ 2] = (byte) (16777213 >> 16);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        LuminousEnergyAndroid result1 = new LuminousEnergyAndroid(bluetoothGattCharacteristic);
        LuminousEnergyAndroid result2 = LuminousEnergyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
