package org.im97mori.ble.characteristic.u2ae2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"ConstantConditions"})
public class BLEBooleanAndroidAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) BLEBoolean.BOOLEAN_FALSE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEBoolean.BOOLEAN_FALSE, result1.getBoolean());
        assertTrue(result1.isBooleanFalse());
        assertFalse(result1.isBooleanTrue());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) BLEBoolean.BOOLEAN_TRUE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEBoolean.BOOLEAN_TRUE, result1.getBoolean());
        assertFalse(result1.isBooleanFalse());
        assertTrue(result1.isBooleanTrue());
    }

    @Test
    public void test_constructor_00101() {
        int booleanValue = 1;

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(booleanValue);
        assertEquals(booleanValue, result1.getBoolean());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BLEBooleanAndroid result2 = BLEBooleanAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getBoolean(), result1.getBoolean());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(bluetoothGattCharacteristic);
        BLEBooleanAndroid result2 = BLEBooleanAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
