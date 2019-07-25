package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.im97mori.ble.ad.AdvertisingDataConstants;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientCharacteristicConfigurationTest {

    @Test
    public void test001() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(AdvertisingDataConstants.BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);

        ClientCharacteristicConfiguration result = new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        assertArrayEquals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, result.getConfiguration());
        assertTrue(result.isNotification());
        assertFalse(result.isIndication());
    }

    @Test
    public void test002() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(AdvertisingDataConstants.BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);

        ClientCharacteristicConfiguration result = new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        assertArrayEquals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, result.getConfiguration());
        assertFalse(result.isNotification());
        assertTrue(result.isIndication());
    }

    @Test
    public void test003() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(AdvertisingDataConstants.BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE);

        ClientCharacteristicConfiguration result = new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        assertArrayEquals(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE, result.getConfiguration());
        assertFalse(result.isNotification());
        assertFalse(result.isIndication());
    }

    @Test
    public void test101() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(AdvertisingDataConstants.BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);

        ClientCharacteristicConfiguration result1 = new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientCharacteristicConfiguration result2 = ClientCharacteristicConfiguration.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getConfiguration(), result2.getConfiguration());
    }

    @Test
    public void test102() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(AdvertisingDataConstants.BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);

        ClientCharacteristicConfiguration result1 = new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        assertArrayEquals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, result1.getBytes());
    }

    @Test
    public void test103() {
        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(AdvertisingDataConstants.BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);

        ClientCharacteristicConfiguration result1 = new ClientCharacteristicConfiguration(bluetoothGattDescriptor);
        ClientCharacteristicConfiguration result2 = ClientCharacteristicConfiguration.CREATOR.createFromByteArray(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
