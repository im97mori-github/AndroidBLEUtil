package org.im97mori.ble.characteristic.u2aa0;

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

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class MagneticFluxDensity2DAndroidTest {

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

        MagneticFluxDensity2DAndroid result1 = new MagneticFluxDensity2DAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0201, result1.getMagneticFluxDensityXAxis());
        assertEquals(MagneticFluxDensity2D.MAGNETIC_FLUX_DENSITY_X_AXIS_RESOLUTION * 0x0201, result1.getMagneticFluxDensityXAxisTesla(), 0);
        assertEquals(0x0403, result1.getMagneticFluxDensityYAxis());
        assertEquals(MagneticFluxDensity2D.MAGNETIC_FLUX_DENSITY_Y_AXIS_RESOLUTION * 0x0403, result1.getMagneticFluxDensityYAxisTesla(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int magneticFluxDensityXAxis = 1;
        int magneticFluxDensityYAxis = 2;

        MagneticFluxDensity2DAndroid result1 = new MagneticFluxDensity2DAndroid(magneticFluxDensityXAxis, magneticFluxDensityYAxis);
        assertEquals(magneticFluxDensityXAxis, result1.getMagneticFluxDensityXAxis());
        assertEquals(magneticFluxDensityYAxis, result1.getMagneticFluxDensityYAxis());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MagneticFluxDensity2DAndroid result1 = new MagneticFluxDensity2DAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MagneticFluxDensity2DAndroid result2 = MagneticFluxDensity2DAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMagneticFluxDensityXAxis(), result2.getMagneticFluxDensityXAxis());
        assertEquals(result1.getMagneticFluxDensityYAxis(), result2.getMagneticFluxDensityYAxis());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MagneticFluxDensity2DAndroid result1 = new MagneticFluxDensity2DAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        MagneticFluxDensity2DAndroid result1 = new MagneticFluxDensity2DAndroid(bluetoothGattCharacteristic);
        MagneticFluxDensity2DAndroid result2 = MagneticFluxDensity2DAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
