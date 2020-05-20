package org.im97mori.ble.characteristic.u2aa6;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CentralAddressResolutionAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_NOT_SUPPORTED & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(bluetoothGattCharacteristic);
        assertEquals(CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_NOT_SUPPORTED, result1.getCentralAddressResolutionSupport());
        assertTrue(result1.isCentralAddressResolutionNotSupported());
        assertFalse(result1.isCentralAddressResolutionSupported());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(bluetoothGattCharacteristic);
        assertEquals(CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED, result1.getCentralAddressResolutionSupport());
        assertFalse(result1.isCentralAddressResolutionNotSupported());
        assertTrue(result1.isCentralAddressResolutionSupported());
    }

    @Test
    public void test_constructor003() {
        int centralAddressResolutionSupport = 1;

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(centralAddressResolutionSupport);
        assertEquals(centralAddressResolutionSupport, result1.getCentralAddressResolutionSupport());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CentralAddressResolutionAndroid result2 = CentralAddressResolutionAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCentralAddressResolutionSupport(), result2.getCentralAddressResolutionSupport());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolutionAndroid result1 = new CentralAddressResolutionAndroid(bluetoothGattCharacteristic);
        CentralAddressResolutionAndroid result2 = CentralAddressResolutionAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
