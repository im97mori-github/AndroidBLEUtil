package org.im97mori.ble.characteristic.u2a4e;

import android.bluetooth.BluetoothGattCharacteristic;
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

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ProtocolModeAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = ProtocolMode.PROTOCOL_MODE_VALUE_BOOT_PROTOCOL_MODE;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = ProtocolMode.PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE;
        data_00002 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        assertEquals(ProtocolMode.PROTOCOL_MODE_VALUE_BOOT_PROTOCOL_MODE, result1.getProtocolModeValue());
        assertTrue(result1.isProtocolModeValueBootProtocolMode());
        assertFalse(result1.isProtocolModeValueReportProtocolMode());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        assertEquals(ProtocolMode.PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE, result1.getProtocolModeValue());
        assertFalse(result1.isProtocolModeValueBootProtocolMode());
        assertTrue(result1.isProtocolModeValueReportProtocolMode());
    }

    @Test
    public void test_constructor_00003() {
        int protocolModeValues = 1;

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(protocolModeValues);
        assertEquals(ProtocolMode.PROTOCOL_MODE_VALUE_REPORT_PROTOCOL_MODE, result1.getProtocolModeValue());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getProtocolModeValue(), result2.getProtocolModeValue());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getProtocolModeValue(), result2.getProtocolModeValue());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ProtocolModeAndroid result1 = new ProtocolModeAndroid(bluetoothGattCharacteristic);
        ProtocolModeAndroid result2 = ProtocolModeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
