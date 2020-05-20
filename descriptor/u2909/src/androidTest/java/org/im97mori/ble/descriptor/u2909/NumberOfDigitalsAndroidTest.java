package org.im97mori.ble.descriptor.u2909;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class NumberOfDigitalsAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        NumberOfDigitalsAndroid result = new NumberOfDigitalsAndroid(bluetoothGattDescriptor);
        assertEquals(0x01, result.getNoOfDigitals());
    }

    @Test
    public void test_constructor002() {
        int noOfDigitals = 1;

        NumberOfDigitalsAndroid result = new NumberOfDigitalsAndroid(noOfDigitals);
        assertEquals(noOfDigitals, result.getNoOfDigitals());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        NumberOfDigitalsAndroid result1 = new NumberOfDigitalsAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        NumberOfDigitalsAndroid result2 = NumberOfDigitalsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getNoOfDigitals(), result2.getNoOfDigitals());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        NumberOfDigitalsAndroid result1 = new NumberOfDigitalsAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        NumberOfDigitalsAndroid result1 = new NumberOfDigitalsAndroid(bluetoothGattDescriptor);
        NumberOfDigitalsAndroid result2 = NumberOfDigitalsAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
