package org.im97mori.ble.characteristic.ftms;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class SupportedResistanceLevelRangeTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[6];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data_00001 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = 1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if (stackTraceElementArray[2].getMethodName().equals(stackTraceElement.getMethodName())) {
                index += i;
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

        SupportedResistanceLevelRange result1 = new SupportedResistanceLevelRange(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getMinimumResistanceLevel());
        assertEquals(SupportedResistanceLevelRange.MINIMUM_RESISTANCE_LEVEL_RESOLUTION * 0x0201, result1.getMinimumResistanceLevelWithUnit(), 0);
        assertEquals(0x0403, result1.getMaximumResistanceLevel());
        assertEquals(SupportedResistanceLevelRange.MAXIMUM_RESISTANCE_LEVEL_RESOLUTION * 0x0403, result1.getMaximumResistanceLevelWithUnit(), 0);
        assertEquals(0x0605, result1.getMinimumIncrement());
        assertEquals(SupportedResistanceLevelRange.MINIMUM_INCREMENT_RESOLUTION * 0x0605, result1.getMinimumIncrementWithUnit(), 0);
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedResistanceLevelRange result1 = new SupportedResistanceLevelRange(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedResistanceLevelRange result2 = SupportedResistanceLevelRange.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMinimumResistanceLevel(), result2.getMinimumResistanceLevel());
        assertEquals(result1.getMaximumResistanceLevel(), result2.getMaximumResistanceLevel());
        assertEquals(result1.getMinimumIncrement(), result2.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedResistanceLevelRange result1 = new SupportedResistanceLevelRange(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedResistanceLevelRange result1 = new SupportedResistanceLevelRange(bluetoothGattCharacteristic);
        SupportedResistanceLevelRange result2 = SupportedResistanceLevelRange.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
