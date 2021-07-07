package org.im97mori.ble.characteristic.u2ae0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.ElectricCurrentUtils;
import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"ConstantConditions"})
public class AverageCurrentAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = (byte) ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN >> 8);
        data[ 2] = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN, result1.getElectricCurrentValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0100, result1.getElectricCurrentValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = (byte) TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0100, result1.getElectricCurrentValue());
        assertEquals(TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        assertEquals(0x0100, result1.getElectricCurrentValue());
        assertEquals(0x02, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00101() {
        int electricCurrentValue = ElectricCurrentUtils.CURRENT_VALUE_IS_NOT_KNOWN;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_ZERO_SECONDS;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00102() {
        int electricCurrentValue = 0x01;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_TOTAL_LIFE_OF_THE_DEVICE;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00103() {
        int electricCurrentValue = 0x01;
        int timeExponential8 = TimeExponential8Utils.TIME_EXPONENTIAL_8_VALUE_IS_NOT_KNOWN;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_constructor_00104() {
        int electricCurrentValue = 0x01;
        int timeExponential8 = 0x02;

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(electricCurrentValue, timeExponential8);
        assertEquals(electricCurrentValue, result1.getElectricCurrentValue());
        assertEquals(timeExponential8, result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AverageCurrentAndroid result2 = AverageCurrentAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getElectricCurrentValue(), result1.getElectricCurrentValue());
        assertEquals(result2.getSensingDuration(), result1.getSensingDuration());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = 0x00;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        AverageCurrentAndroid result1 = new AverageCurrentAndroid(bluetoothGattCharacteristic);
        AverageCurrentAndroid result2 = AverageCurrentAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
