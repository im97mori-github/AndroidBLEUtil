package org.im97mori.ble.characteristic.u2ad7;

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

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class SupportedHeartRateRangeAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
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

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(bluetoothGattCharacteristic);
        assertEquals(0x01, result1.getMinimumHeartRate());
        assertEquals(0x02, result1.getMaximumHeartRate());
        assertEquals(0x03, result1.getMinimumIncrement());
    }

    @Test
    public void test_constructor_00002() {
        int minimumHeartRate = 1;
        int maximumHeartRate = 2;
        int minimumIncrement = 3;

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(minimumHeartRate, maximumHeartRate, minimumIncrement);
        assertEquals(minimumHeartRate, result1.getMinimumHeartRate());
        assertEquals(maximumHeartRate, result1.getMaximumHeartRate());
        assertEquals(minimumIncrement, result1.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        SupportedHeartRateRangeAndroid result2 = SupportedHeartRateRangeAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMinimumHeartRate(), result2.getMinimumHeartRate());
        assertEquals(result1.getMaximumHeartRate(), result2.getMaximumHeartRate());
        assertEquals(result1.getMinimumIncrement(), result2.getMinimumIncrement());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        SupportedHeartRateRangeAndroid result1 = new SupportedHeartRateRangeAndroid(bluetoothGattCharacteristic);
        SupportedHeartRateRangeAndroid result2 = SupportedHeartRateRangeAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
