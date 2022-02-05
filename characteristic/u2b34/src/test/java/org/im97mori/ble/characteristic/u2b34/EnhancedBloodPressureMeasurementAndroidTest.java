package org.im97mori.ble.characteristic.u2b34;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.EnhancedBloodPressureMeasurementUtils;
import org.im97mori.ble.characteristic.core.IEEE_11073_20601_SFLOAT;
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
public class EnhancedBloodPressureMeasurementAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(1, result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(2, result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(3, result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_KPA
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(1, result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(2, result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(3, result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
    }

    @Test
    public void test_constructor_00101() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
    }

    @Test
    public void test_constructor_00102() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        data[ 8] = 0x05;
        data[ 9] = 0x06;
        data[10] = 0x07;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(0x07060504, result1.getTimeStamp());
    }

    @Test
    public void test_constructor_00201() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertNotNull(result1.getPulseRate());
        assertArrayEquals(new byte[2], result1.getPulseRate().getData());
    }

    @Test
    public void test_constructor_00202() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertNotNull(result1.getPulseRate());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getPulseRate().getData());
    }

    @Test
    public void test_constructor_00301() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(0, result1.getUserId());
    }

    @Test
    public void test_constructor_00302() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(0x004, result1.getUserId());
    }

    @Test
    public void test_constructor_00401() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertArrayEquals(new byte[0], result1.getMeasurementStatus());
    }

    @Test
    public void test_constructor_00402() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertArrayEquals(Arrays.copyOfRange(data, 7, 9), result1.getMeasurementStatus());
    }

    @Test
    public void test_constructor_00501() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(0, result1.getUserFacingTime());
    }

    @Test
    public void test_constructor_00502() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        data[ 9] = (byte) 0x06;
        data[10] = (byte) 0x07;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertEquals(EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900, result1.getFlags());
        assertEquals(BLEUtils.createUInt32(data, 7), result1.getUserFacingTime());
    }

    @Test
    public void test_constructor_00601() {
        int flags = 1;
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicMmhg = new IEEE_11073_20601_SFLOAT(
                new byte[]{2, 3}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicMmhg = new IEEE_11073_20601_SFLOAT(
                new byte[]{4, 5}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg = new IEEE_11073_20601_SFLOAT(
                new byte[]{6, 7}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueSystolicKpa = new IEEE_11073_20601_SFLOAT(
                new byte[]{8, 9}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueDiastolicKpa = new IEEE_11073_20601_SFLOAT(
                new byte[]{10, 11}, 0);
        IEEE_11073_20601_SFLOAT bloodPressureMeasurementCompoundValueMeanArterialPressureKpa = new IEEE_11073_20601_SFLOAT(
                new byte[]{12, 13}, 0);
        long timeStamp = 14;
        IEEE_11073_20601_SFLOAT pulseRate = new IEEE_11073_20601_SFLOAT(new byte[]{15, 16}, 0);
        int userId = 17;
        byte[] measurementStatus = new byte[]{18};
        long userFacingTime = 19;

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(flags,
                bloodPressureMeasurementCompoundValueSystolicMmhg, bloodPressureMeasurementCompoundValueDiastolicMmhg,
                bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg,
                bloodPressureMeasurementCompoundValueSystolicKpa, bloodPressureMeasurementCompoundValueDiastolicKpa,
                bloodPressureMeasurementCompoundValueMeanArterialPressureKpa, timeStamp, pulseRate, userId,
                measurementStatus, userFacingTime);
        assertEquals(flags, result1.getFlags());
        assertEquals(bloodPressureMeasurementCompoundValueSystolicMmhg,
                result1.getBloodPressureMeasurementCompoundValueSystolicMmhg());
        assertEquals(bloodPressureMeasurementCompoundValueDiastolicMmhg,
                result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg());
        assertEquals(bloodPressureMeasurementCompoundValueMeanArterialPressureMmhg,
                result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg());
        assertEquals(bloodPressureMeasurementCompoundValueSystolicKpa,
                result1.getBloodPressureMeasurementCompoundValueSystolicKpa());
        assertEquals(bloodPressureMeasurementCompoundValueDiastolicKpa,
                result1.getBloodPressureMeasurementCompoundValueDiastolicKpa());
        assertEquals(bloodPressureMeasurementCompoundValueMeanArterialPressureKpa,
                result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa());
        assertEquals(timeStamp, result1.getTimeStamp());
        assertEquals(pulseRate, result1.getPulseRate());
        assertEquals(userId, result1.getUserId());
        assertArrayEquals(measurementStatus, result1.getMeasurementStatus());
        assertEquals(userFacingTime, result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFlags(), result1.getFlags());
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result2.getTimeStamp(), result1.getTimeStamp());
        assertEquals(result2.getPulseRate().getSfloat(), result1.getPulseRate().getSfloat(), 0);
        assertEquals(result2.getUserId(), result1.getUserId());
        assertArrayEquals(result2.getMeasurementStatus(), result1.getMeasurementStatus());
        assertEquals(result2.getUserFacingTime(), result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        data[ 8] = 0x05;
        data[ 9] = 0x06;
        data[10] = 0x07;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFlags(), result1.getFlags());
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result2.getTimeStamp(), result1.getTimeStamp());
        assertEquals(result2.getPulseRate().getSfloat(), result1.getPulseRate().getSfloat(), 0);
        assertEquals(result2.getUserId(), result1.getUserId());
        assertArrayEquals(result2.getMeasurementStatus(), result1.getMeasurementStatus());
        assertEquals(result2.getUserFacingTime(), result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFlags(), result1.getFlags());
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result2.getTimeStamp(), result1.getTimeStamp());
        assertEquals(result2.getPulseRate().getSfloat(), result1.getPulseRate().getSfloat(), 0);
        assertEquals(result2.getUserId(), result1.getUserId());
        assertArrayEquals(result2.getMeasurementStatus(), result1.getMeasurementStatus());
        assertEquals(result2.getUserFacingTime(), result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFlags(), result1.getFlags());
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result2.getTimeStamp(), result1.getTimeStamp());
        assertEquals(result2.getPulseRate().getSfloat(), result1.getPulseRate().getSfloat(), 0);
        assertEquals(result2.getUserId(), result1.getUserId());
        assertArrayEquals(result2.getMeasurementStatus(), result1.getMeasurementStatus());
        assertEquals(result2.getUserFacingTime(), result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00005() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFlags(), result1.getFlags());
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result2.getTimeStamp(), result1.getTimeStamp());
        assertEquals(result2.getPulseRate().getSfloat(), result1.getPulseRate().getSfloat(), 0);
        assertEquals(result2.getUserId(), result1.getUserId());
        assertArrayEquals(result2.getMeasurementStatus(), result1.getMeasurementStatus());
        assertEquals(result2.getUserFacingTime(), result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00006() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        data[ 9] = (byte) 0x06;
        data[10] = (byte) 0x07;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getFlags(), result1.getFlags());
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureMmhg().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueSystolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueDiastolicKpa().getSfloat(), 0);
        assertEquals(result2.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), result1.getBloodPressureMeasurementCompoundValueMeanArterialPressureKpa().getSfloat(), 0);
        assertEquals(result2.getTimeStamp(), result1.getTimeStamp());
        assertEquals(result2.getPulseRate().getSfloat(), result1.getPulseRate().getSfloat(), 0);
        assertEquals(result2.getUserId(), result1.getUserId());
        assertArrayEquals(result2.getMeasurementStatus(), result1.getMeasurementStatus());
        assertEquals(result2.getUserFacingTime(), result1.getUserFacingTime());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = 0x04;
        data[ 8] = 0x05;
        data[ 9] = 0x06;
        data[10] = 0x07;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[8];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00106() {
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        data[ 7] = (byte) 0x04;
        data[ 8] = (byte) 0x05;
        data[ 9] = (byte) 0x06;
        data[10] = (byte) 0x07;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00206() {
        //@formatter:off
        byte[] data = new byte[7];
        data[ 0] = EnhancedBloodPressureMeasurementUtils.FLAG_BLOOD_PRESSURE_UNITS_MMHG
                | EnhancedBloodPressureMeasurementUtils.FLAG_TIME_STAMP_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_PULSE_RATE_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_ID_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_MEASUREMENT_STATUS_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_USER_FACING_TIME_NOT_PRESENT
                | EnhancedBloodPressureMeasurementUtils.FLAG_EPOCH_START_IS_JANUARY_1_1900;
        data[ 1] = (byte) 0x0001;
        data[ 2] = (byte) (0x0001 >> 8);
        data[ 3] = (byte) 0x0002;
        data[ 4] = (byte) (0x0002 >> 8);
        data[ 5] = (byte) 0x0003;
        data[ 6] = (byte) (0x0003 >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        EnhancedBloodPressureMeasurementAndroid result1 = new EnhancedBloodPressureMeasurementAndroid(bluetoothGattCharacteristic);
        EnhancedBloodPressureMeasurementAndroid result2 = EnhancedBloodPressureMeasurementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
