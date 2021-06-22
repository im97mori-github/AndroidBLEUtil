package org.im97mori.ble.characteristic.u2a4f;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class ScanIntervalWindowAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data_00001 = data;
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

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getLeScanInterval());
        assertEquals(ScanIntervalWindow.LE_SCAN_INTERVAL_RESOLUTION * 0x0201, result1.getLeScanIntervalMs(), 0);
        assertEquals(0x0403, result1.getLeScanWindow());
        assertEquals(ScanIntervalWindow.LE_SCAN_WINDOW_RESOLUTION * 0x0403, result1.getLeScanWindowMs(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int leScanInterval = 1;
        int leScanWindow = 2;

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(leScanInterval, leScanWindow);
        assertEquals(leScanInterval, result1.getLeScanInterval());
        assertEquals(leScanWindow, result1.getLeScanWindow());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ScanIntervalWindowAndroid result2 = ScanIntervalWindowAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLeScanInterval(), result2.getLeScanInterval());
        assertEquals(result1.getLeScanWindow(), result2.getLeScanWindow());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        ScanIntervalWindowAndroid result1 = new ScanIntervalWindowAndroid(bluetoothGattCharacteristic);
        ScanIntervalWindowAndroid result2 = ScanIntervalWindowAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
