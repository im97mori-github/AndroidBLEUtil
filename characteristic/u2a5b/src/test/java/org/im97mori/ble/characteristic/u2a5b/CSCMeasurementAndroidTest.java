package org.im97mori.ble.characteristic.u2a5b;

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
public class CSCMeasurementAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        int flag = CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE;
        data[ 0] = (byte) flag;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[7];
        int flag = CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_TRUE
                | CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        int flag = CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE;
        data[ 0] = (byte) flag;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[5];
        int flag = CSCMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_FALSE
                | CSCMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_00102 = data;
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

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsWheelRevolutionDataNotPresent());
        assertFalse(result1.isFlagsWheelRevolutionDataPresent());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsWheelRevolutionDataNotPresent());
        assertTrue(result1.isFlagsWheelRevolutionDataPresent());
        assertEquals(0x04030201L, result1.getCumulativeWheelRevolutions());
        assertEquals(0x0605L, result1.getLastWheelEventTime());
        assertEquals(CSCMeasurement.LAST_WHEEL_EVENT_TIME_RESOLUTION * 0x0605L, result1.getLastWheelEventTimeSecond(), 0);
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsCrankRevolutionDataNotPresent());
        assertFalse(result1.isFlagsCrankRevolutionDataPresent());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsCrankRevolutionDataNotPresent());
        assertTrue(result1.isFlagsCrankRevolutionDataPresent());
        assertEquals(0x0201L, result1.getCumulativeCrankRevolutions());
        assertEquals(0x0403L, result1.getLastCrankEventTime());
        assertEquals(CSCMeasurement.LAST_CRANK_EVENT_TIME_RESOLUTION * 0x0403L, result1.getLastCrankEventTimeSecond(), 0);
    }

    @Test
    public void test_constructor_00103() {
        int flags = 1;
        long cumulativeWheelRevolutions = 2;
        int lastWheelEventTime = 3;
        int cumulativeCrankRevolutions = 4;
        int lastCrankEventTime = 5;

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(flags, cumulativeWheelRevolutions, lastWheelEventTime, cumulativeCrankRevolutions, lastCrankEventTime);
        assertEquals(flags, result1.getFlags());
        assertEquals(cumulativeWheelRevolutions, result1.getCumulativeWheelRevolutions());
        assertEquals(lastWheelEventTime, result1.getLastWheelEventTime());
        assertEquals(cumulativeCrankRevolutions, result1.getCumulativeCrankRevolutions());
        assertEquals(lastCrankEventTime, result1.getLastCrankEventTime());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCumulativeWheelRevolutions(), result2.getCumulativeWheelRevolutions());
        assertEquals(result1.getLastWheelEventTime(), result2.getLastWheelEventTime());
        assertEquals(result1.getCumulativeCrankRevolutions(), result2.getCumulativeCrankRevolutions());
        assertEquals(result1.getLastCrankEventTime(), result2.getLastCrankEventTime());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCumulativeWheelRevolutions(), result2.getCumulativeWheelRevolutions());
        assertEquals(result1.getLastWheelEventTime(), result2.getLastWheelEventTime());
        assertEquals(result1.getCumulativeCrankRevolutions(), result2.getCumulativeCrankRevolutions());
        assertEquals(result1.getLastCrankEventTime(), result2.getLastCrankEventTime());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCumulativeWheelRevolutions(), result2.getCumulativeWheelRevolutions());
        assertEquals(result1.getLastWheelEventTime(), result2.getLastWheelEventTime());
        assertEquals(result1.getCumulativeCrankRevolutions(), result2.getCumulativeCrankRevolutions());
        assertEquals(result1.getLastCrankEventTime(), result2.getLastCrankEventTime());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCumulativeWheelRevolutions(), result2.getCumulativeWheelRevolutions());
        assertEquals(result1.getLastWheelEventTime(), result2.getLastWheelEventTime());
        assertEquals(result1.getCumulativeCrankRevolutions(), result2.getCumulativeCrankRevolutions());
        assertEquals(result1.getLastCrankEventTime(), result2.getLastCrankEventTime());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCMeasurementAndroid result1 = new CSCMeasurementAndroid(bluetoothGattCharacteristic);
        CSCMeasurementAndroid result2 = CSCMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
