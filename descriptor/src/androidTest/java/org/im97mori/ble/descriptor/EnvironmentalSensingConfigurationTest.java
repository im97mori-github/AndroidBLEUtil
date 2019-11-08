package org.im97mori.ble.descriptor;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EnvironmentalSensingConfigurationTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfiguration result = new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        assertEquals(value[0], result.getTriggerLogicValue());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_AND;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfiguration result = new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        assertTrue(result.isTriggerLogicValueBooleanAnd());
        assertFalse(result.isTriggerLogicValueBooleanOr());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingConfiguration.TRIGGER_LOGIC_VALUE_BOOLAEN_OR;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfiguration result = new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        assertFalse(result.isTriggerLogicValueBooleanAnd());
        assertTrue(result.isTriggerLogicValueBooleanOr());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfiguration result1 = new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnvironmentalSensingConfiguration result2 = EnvironmentalSensingConfiguration.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getTriggerLogicValue(), result2.getTriggerLogicValue());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfiguration result1 = new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        EnvironmentalSensingConfiguration result1 = new EnvironmentalSensingConfiguration(bluetoothGattDescriptor);
        EnvironmentalSensingConfiguration result2 = EnvironmentalSensingConfiguration.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
