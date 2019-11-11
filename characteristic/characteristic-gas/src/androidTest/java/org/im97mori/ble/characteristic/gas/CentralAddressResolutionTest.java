package org.im97mori.ble.characteristic.gas;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class CentralAddressResolutionTest {

    @Test
    public void test1() {
        byte[] data = new byte[1];
        data[0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolution peripheralPreferredConnectionParameters = new CentralAddressResolution(bluetoothGattCharacteristic);
        assertEquals(CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED, peripheralPreferredConnectionParameters.getCentralAddressResolutionSupport());
    }

    @Test
    public void test2() {
        byte[] data = new byte[1];
        data[0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolution result1 = new CentralAddressResolution(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CentralAddressResolution result2 = CentralAddressResolution.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCentralAddressResolutionSupport(), result2.getCentralAddressResolutionSupport());
    }

    @Test
    public void test3() {
        byte[] data = new byte[1];
        data[0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolution result1 = new CentralAddressResolution(bluetoothGattCharacteristic);
        byte[] resultData = result1.getBytes();
        assertArrayEquals(data, resultData);
    }

    @Test
    public void test4() {
        byte[] data = new byte[1];
        data[0] = (byte) (CentralAddressResolution.CENTRAL_ADDRESS_RESOLUTION_SUPPORTED & 0xff);

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CentralAddressResolution result1 = new CentralAddressResolution(bluetoothGattCharacteristic);
        CentralAddressResolution result2 = CentralAddressResolution.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
