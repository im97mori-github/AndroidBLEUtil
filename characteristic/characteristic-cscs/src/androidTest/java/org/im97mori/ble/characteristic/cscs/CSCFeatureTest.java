package org.im97mori.ble.characteristic.cscs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class CSCFeatureTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
        | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_TRUE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_TRUE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_FALSE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[2];
        int flag = CSCFeature.CSC_FEATURE_WHEEL_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_CRANK_REVOLUTION_DATA_SUPPORTED_FALSE
                | CSCFeature.CSC_FEATURE_MULTIPLE_SENSOR_LOCATIONS_SUPPORTED_TRUE;
        data[ 0] = (byte) flag;
        data[ 1] = (byte) (flag >> 8);
        data_00202 = data;
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

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureWheelRevolutionDataNotSupported());
        assertFalse(result1.isCscFeatureWheelRevolutionDataSupported());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertFalse(result1.isCscFeatureWheelRevolutionDataNotSupported());
        assertTrue(result1.isCscFeatureWheelRevolutionDataSupported());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureCrankRevolutionDataSupportedNotSupported());
        assertFalse(result1.isCscFeatureCrankRevolutionDataSupportedSupported());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertFalse(result1.isCscFeatureCrankRevolutionDataSupportedNotSupported());
        assertTrue(result1.isCscFeatureCrankRevolutionDataSupportedSupported());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureMultipleSensorLocationsSupportedNotSupported());
        assertFalse(result1.isCscFeatureMultipleSensorLocationsSupportedSupported());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertFalse(result1.isCscFeatureMultipleSensorLocationsSupportedNotSupported());
        assertTrue(result1.isCscFeatureMultipleSensorLocationsSupportedSupported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeature result2 = CSCFeature.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeature result2 = CSCFeature.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getCscFeature());
        assertTrue(result1.isCscFeatureCrankRevolutionDataSupportedNotSupported());
        assertFalse(result1.isCscFeatureCrankRevolutionDataSupportedSupported());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeature result2 = CSCFeature.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeature result2 = CSCFeature.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CSCFeature result2 = CSCFeature.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getCscFeature(), result2.getCscFeature());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        CSCFeature result2 = CSCFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        CSCFeature result2 = CSCFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        CSCFeature result2 = CSCFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        CSCFeature result2 = CSCFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        CSCFeature result2 = CSCFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        CSCFeature result1 = new CSCFeature(bluetoothGattCharacteristic);
        CSCFeature result2 = CSCFeature.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
