package org.im97mori.ble.characteristic.u2a02;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PeripheralPrivacyFlagAndroidTest {

    @SuppressWarnings("ConstantConditions")
    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_DISABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(bluetoothGattCharacteristic);
        assertEquals(PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_DISABLED_IN_THIS_DEVICE, result1.getFlag());
        assertTrue(result1.isPrivacyDisabled());
        assertFalse(result1.isPrivacyEnabled());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(bluetoothGattCharacteristic);
        assertEquals(PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE, result1.getFlag());
        assertFalse(result1.isPrivacyDisabled());
        assertTrue(result1.isPrivacyEnabled());
    }

    @Test
    public void test_constructor003() {
        int flag = 1;

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(flag);
        assertEquals(flag, result1.getFlag());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        PeripheralPrivacyFlagAndroid result2 = PeripheralPrivacyFlagAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getFlag(), result2.getFlag());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (PeripheralPrivacyFlag.FLAGS_PRIVACY_IS_ENABLED_IN_THIS_DEVICE & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        PeripheralPrivacyFlagAndroid result1 = new PeripheralPrivacyFlagAndroid(bluetoothGattCharacteristic);
        PeripheralPrivacyFlagAndroid result2 = PeripheralPrivacyFlagAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
