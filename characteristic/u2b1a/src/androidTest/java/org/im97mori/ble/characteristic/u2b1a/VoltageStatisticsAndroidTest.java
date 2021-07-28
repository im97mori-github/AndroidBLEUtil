package org.im97mori.ble.characteristic.u2b1a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
import org.im97mori.ble.characteristic.core.VoltageUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class VoltageStatisticsAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 6] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getAverageVoltageValue());
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getStandardDeviationVoltageValue());
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getMinimumVoltageValue());
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getMaximumVoltageValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertEquals(0, result1.getAverageVoltageValue());
        assertEquals(0, result1.getStandardDeviationVoltageValue());
        assertEquals(0, result1.getMinimumVoltageValue());
        assertEquals(0, result1.getMaximumVoltageValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        data[ 6] = (byte) 65408;
        data[ 7] = (byte) (65408 >> 8);
        data[ 8] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertEquals(65408, result1.getAverageVoltageValue());
        assertEquals(65408, result1.getStandardDeviationVoltageValue());
        assertEquals(65408, result1.getMinimumVoltageValue());
        assertEquals(65408, result1.getMaximumVoltageValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getAverageVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 2), result1.getStandardDeviationVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 4), result1.getMinimumVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 6), result1.getMaximumVoltageValue());
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getAverageVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 2), result1.getStandardDeviationVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 4), result1.getMinimumVoltageValue());
        assertEquals(BLEUtils.createUInt16(data, 6), result1.getMaximumVoltageValue());
        assertEquals(BLEUtils.createUInt8(data, 8), result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00101() {
        int averageVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int standardDeviationVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int minimumVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int maximumVoltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        int sensingDuration = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(averageVoltageValue, standardDeviationVoltageValue, minimumVoltageValue, maximumVoltageValue, sensingDuration);
        assertEquals(averageVoltageValue, result1.getAverageVoltageValue());
        assertEquals(standardDeviationVoltageValue, result1.getStandardDeviationVoltageValue());
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
        assertEquals(sensingDuration, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00102() {
        int averageVoltageValue = 0;
        int standardDeviationVoltageValue = 0;
        int minimumVoltageValue = 0;
        int maximumVoltageValue = 0;
        int sensingDuration = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(averageVoltageValue, standardDeviationVoltageValue, minimumVoltageValue, maximumVoltageValue, sensingDuration);
        assertEquals(averageVoltageValue, result1.getAverageVoltageValue());
        assertEquals(standardDeviationVoltageValue, result1.getStandardDeviationVoltageValue());
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
        assertEquals(sensingDuration, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00103() {
        int averageVoltageValue = 65408;
        int standardDeviationVoltageValue = 65408;
        int minimumVoltageValue = 65408;
        int maximumVoltageValue = 65408;
        int sensingDuration = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(averageVoltageValue, standardDeviationVoltageValue, minimumVoltageValue, maximumVoltageValue, sensingDuration);
        assertEquals(averageVoltageValue, result1.getAverageVoltageValue());
        assertEquals(standardDeviationVoltageValue, result1.getStandardDeviationVoltageValue());
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
        assertEquals(sensingDuration, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00104() {
        int averageVoltageValue = 1;
        int standardDeviationVoltageValue = 2;
        int minimumVoltageValue = 3;
        int maximumVoltageValue = 4;
        int sensingDuration = 253;

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(averageVoltageValue, standardDeviationVoltageValue, minimumVoltageValue, maximumVoltageValue, sensingDuration);
        assertEquals(averageVoltageValue, result1.getAverageVoltageValue());
        assertEquals(standardDeviationVoltageValue, result1.getStandardDeviationVoltageValue());
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
        assertEquals(sensingDuration, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00105() {
        int averageVoltageValue = 1;
        int standardDeviationVoltageValue = 2;
        int minimumVoltageValue = 3;
        int maximumVoltageValue = 4;
        int sensingDuration = 5;

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(averageVoltageValue, standardDeviationVoltageValue, minimumVoltageValue, maximumVoltageValue, sensingDuration);
        assertEquals(averageVoltageValue, result1.getAverageVoltageValue());
        assertEquals(standardDeviationVoltageValue, result1.getStandardDeviationVoltageValue());
        assertEquals(minimumVoltageValue, result1.getMinimumVoltageValue());
        assertEquals(maximumVoltageValue, result1.getMaximumVoltageValue());
        assertEquals(sensingDuration, result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 6] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAverageVoltageValue(), result1.getAverageVoltageValue());
        assertEquals(result2.getStandardDeviationVoltageValue(), result1.getStandardDeviationVoltageValue());
        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAverageVoltageValue(), result1.getAverageVoltageValue());
        assertEquals(result2.getStandardDeviationVoltageValue(), result1.getStandardDeviationVoltageValue());
        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        data[ 6] = (byte) 65408;
        data[ 7] = (byte) (65408 >> 8);
        data[ 8] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAverageVoltageValue(), result1.getAverageVoltageValue());
        assertEquals(result2.getStandardDeviationVoltageValue(), result1.getStandardDeviationVoltageValue());
        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAverageVoltageValue(), result1.getAverageVoltageValue());
        assertEquals(result2.getStandardDeviationVoltageValue(), result1.getStandardDeviationVoltageValue());
        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00005() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getAverageVoltageValue(), result1.getAverageVoltageValue());
        assertEquals(result2.getStandardDeviationVoltageValue(), result1.getStandardDeviationVoltageValue());
        assertEquals(result2.getMinimumVoltageValue(), result1.getMinimumVoltageValue());
        assertEquals(result2.getMaximumVoltageValue(), result1.getMaximumVoltageValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 6] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        data[ 6] = (byte) 65408;
        data[ 7] = (byte) (65408 >> 8);
        data[ 8] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 3] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 4] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 5] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 6] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 7] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0;
        data[ 1] = 0;
        data[ 2] = 0;
        data[ 3] = 0;
        data[ 4] = 0;
        data[ 5] = 0;
        data[ 6] = 0;
        data[ 7] = 0;
        data[ 8] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = (byte) 65408;
        data[ 1] = (byte) (65408 >> 8);
        data[ 2] = (byte) 65408;
        data[ 3] = (byte) (65408 >> 8);
        data[ 4] = (byte) 65408;
        data[ 5] = (byte) (65408 >> 8);
        data[ 6] = (byte) 65408;
        data[ 7] = (byte) (65408 >> 8);
        data[ 8] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = (byte) 253;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] data = new byte[9];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        data[ 4] = 0x05;
        data[ 5] = 0x06;
        data[ 6] = 0x07;
        data[ 7] = 0x08;
        data[ 6] = 0x09;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageStatisticsAndroid result1 = new VoltageStatisticsAndroid(bluetoothGattCharacteristic);
        VoltageStatisticsAndroid result2 = VoltageStatisticsAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
