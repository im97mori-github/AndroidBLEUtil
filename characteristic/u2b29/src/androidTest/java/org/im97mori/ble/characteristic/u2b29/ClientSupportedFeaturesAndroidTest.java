package org.im97mori.ble.characteristic.u2b29;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ClientSupportedFeaturesAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getClientFeatures());
        assertTrue(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getClientFeatures());
        assertTrue(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getClientFeatures());
        assertFalse(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 2];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1] = ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getClientFeatures());
        assertFalse(result1.isClientFeatresRobustCachingSuppreted());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ClientSupportedFeaturesAndroid result2 = ClientSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result2.getClientFeatures(), result1.getClientFeatures());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        byte[] data = new byte[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET + 1];
        data[ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_OCTET] = ~ClientSupportedFeatures.CLIENT_FEATYRES_ROBUST_CACHING_BIT;

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ClientSupportedFeaturesAndroid result1 = new ClientSupportedFeaturesAndroid(bluetoothGattCharacteristic);
        ClientSupportedFeaturesAndroid result2 = ClientSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
