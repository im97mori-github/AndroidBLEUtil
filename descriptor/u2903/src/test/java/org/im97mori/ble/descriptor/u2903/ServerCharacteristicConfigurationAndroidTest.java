package org.im97mori.ble.descriptor.u2903;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("ConstantConditions")
public class ServerCharacteristicConfigurationAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ServerCharacteristicConfigurationAndroid result = new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertEquals(0x0201, result.getProperties());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_DISABLED;
        value[ 1] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_DISABLED >> 8;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ServerCharacteristicConfigurationAndroid result = new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertTrue(result.isPropertiesBroadcastsDisabled());
        assertFalse(result.isPropertiesBroadcastsEnabled());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_ENABLED;
        value[ 1] = (byte) ServerCharacteristicConfigurationAndroid.PROPERTIES_BROADCASTS_ENABLED >> 8;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ServerCharacteristicConfigurationAndroid result = new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertFalse(result.isPropertiesBroadcastsDisabled());
        assertTrue(result.isPropertiesBroadcastsEnabled());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ServerCharacteristicConfigurationAndroid result1 = new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServerCharacteristicConfigurationAndroid result2 = ServerCharacteristicConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getProperties(), result2.getProperties());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ServerCharacteristicConfigurationAndroid result1 = new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ServerCharacteristicConfigurationAndroid result1 = new ServerCharacteristicConfigurationAndroid(bluetoothGattDescriptor);
        ServerCharacteristicConfigurationAndroid result2 = ServerCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
