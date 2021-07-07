package org.im97mori.ble.characteristic.u2b18;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.characteristic.core.TimeExponential8Utils;
import org.im97mori.ble.characteristic.core.VoltageUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"ConstantConditions"})
public class VoltageAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = (byte) VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;
        data[ 1] = (byte) (VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageAndroid result1 = new VoltageAndroid(bluetoothGattCharacteristic);
        assertEquals(VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN, result1.getVoltageValue());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageAndroid result1 = new VoltageAndroid(bluetoothGattCharacteristic);
        assertEquals(BLEUtils.createUInt16(data, 0), result1.getVoltageValue());
    }

    @Test
    public void test_constructor_00101() {
        int voltageValue = VoltageUtils.VOLTAGE_VALUE_IS_NOT_KNOWN;

        VoltageAndroid result1 = new VoltageAndroid(voltageValue);
        assertEquals(voltageValue, result1.getVoltageValue());
    }

    @Test
    public void test_constructor_00102() {
        int voltageValue = 0x0201;

        VoltageAndroid result1 = new VoltageAndroid(voltageValue);
        assertEquals(voltageValue, result1.getVoltageValue());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageAndroid result1 = new VoltageAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        VoltageAndroid result2 = VoltageAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getVoltageValue(), result1.getVoltageValue());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageAndroid result1 = new VoltageAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        VoltageAndroid result1 = new VoltageAndroid(bluetoothGattCharacteristic);
        VoltageAndroid result2 = VoltageAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
