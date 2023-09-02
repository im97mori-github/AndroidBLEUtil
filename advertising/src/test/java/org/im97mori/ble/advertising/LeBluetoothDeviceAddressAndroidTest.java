package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class LeBluetoothDeviceAddressAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;
        data[5] = 0x04;
        data[6] = 0x05;
        data[7] = 0x06;
        data[8] = 0b00000000;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[9];
        data[0] = 8;
        data[1] = LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE;
        data[2] = 0x01;
        data[3] = 0x02;
        data[4] = 0x03;
        data[5] = 0x04;
        data[6] = 0x05;
        data[7] = 0x06;
        data[8] = 0b00000001;
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getLeBluetoothDeviceAddress());
        assertFalse(result1.isRandomAddress());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        assertEquals(8, result1.getLength());
        assertEquals(LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getLeBluetoothDeviceAddress());
        assertTrue(result1.isRandomAddress());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getLeBluetoothDeviceAddress());
        assertFalse(result1.isRandomAddress());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0);
        assertEquals(8, result1.getLength());
        assertEquals(LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getLeBluetoothDeviceAddress());
        assertTrue(result1.isRandomAddress());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(Arrays.copyOfRange(data, 2, 8), data[8] != 0);
        assertEquals(8, result1.getLength());
        assertEquals(LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getLeBluetoothDeviceAddress());
        assertFalse(result1.isRandomAddress());
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(Arrays.copyOfRange(data, 2, 8), data[8] != 0);
        assertEquals(8, result1.getLength());
        assertEquals(LE_BLUETOOTH_DEVICE_ADDRESS_DATA_TYPE, result1.getDataType());
        assertArrayEquals(Arrays.copyOfRange(data, 2, 8), result1.getLeBluetoothDeviceAddress());
        assertTrue(result1.isRandomAddress());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeBluetoothDeviceAddressAndroid result2 = LeBluetoothDeviceAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeBluetoothDeviceAddress(), result1.getLeBluetoothDeviceAddress());
        assertEquals(result1.isRandomAddress(), result2.isRandomAddress());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeBluetoothDeviceAddressAndroid result2 = LeBluetoothDeviceAddressAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeBluetoothDeviceAddress(), result1.getLeBluetoothDeviceAddress());
        assertEquals(result1.isRandomAddress(), result2.isRandomAddress());
    }


    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        LeBluetoothDeviceAddressAndroid result2 = LeBluetoothDeviceAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        LeBluetoothDeviceAddressAndroid result1 = new LeBluetoothDeviceAddressAndroid(data, 0, data[0]);
        LeBluetoothDeviceAddressAndroid result2 = LeBluetoothDeviceAddressAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
