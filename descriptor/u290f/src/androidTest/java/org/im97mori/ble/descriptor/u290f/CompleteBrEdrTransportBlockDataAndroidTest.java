package org.im97mori.ble.descriptor.u290f;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;

public class CompleteBrEdrTransportBlockDataAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result.getTransportData());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result.getTransportData());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getTransportData(), result2.getTransportData());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getTransportData(), result2.getTransportData());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on


        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(bluetoothGattDescriptor);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
