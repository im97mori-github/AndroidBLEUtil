package org.im97mori.ble.characteristic.u2ac9;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ResolvablePrivateAddressOnlyAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection ConstantConditions
data[ 0] = (byte) (ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ResolvablePrivateAddressOnlyAndroid result1 = new ResolvablePrivateAddressOnlyAndroid(bluetoothGattCharacteristic);
        assertEquals(ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0, result1.getResolvablePrivateAddress());
        assertTrue(result1.isResolvablePrivateAddress0());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0 + 1 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ResolvablePrivateAddressOnlyAndroid result1 = new ResolvablePrivateAddressOnlyAndroid(bluetoothGattCharacteristic);
        assertEquals(ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0 + 1, result1.getResolvablePrivateAddress());
        assertFalse(result1.isResolvablePrivateAddress0());
    }

    @Test
    public void test_constructor003() {
        int resolvablePrivateAddress = 1;

        ResolvablePrivateAddressOnlyAndroid result1 = new ResolvablePrivateAddressOnlyAndroid(resolvablePrivateAddress);
        assertEquals(resolvablePrivateAddress, result1.getResolvablePrivateAddress());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0 + 1 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ResolvablePrivateAddressOnlyAndroid result1 = new ResolvablePrivateAddressOnlyAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ResolvablePrivateAddressOnlyAndroid result2 = ResolvablePrivateAddressOnlyAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getResolvablePrivateAddress(), result2.getResolvablePrivateAddress());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0 + 1 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ResolvablePrivateAddressOnlyAndroid result1 = new ResolvablePrivateAddressOnlyAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (ResolvablePrivateAddressOnly.RESOLVABLE_PRIVATE_ADDRESS_0 + 1 & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ResolvablePrivateAddressOnlyAndroid result1 = new ResolvablePrivateAddressOnlyAndroid(bluetoothGattCharacteristic);
        ResolvablePrivateAddressOnlyAndroid result2 = ResolvablePrivateAddressOnlyAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
