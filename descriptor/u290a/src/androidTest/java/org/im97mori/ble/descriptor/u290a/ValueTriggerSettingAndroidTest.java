package org.im97mori.ble.descriptor.u290a;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Parcel;

import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValueTriggerSettingAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertEquals(0x01, result.getCondition());
        assertEquals(0x0302, result.getValueAnalog());
        assertArrayEquals(Arrays.copyOfRange(value, 3, 4), result.getValueBitMask());
        assertEquals(0x08070605L, result.getValueAnalogInterval());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.NONE_0;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertTrue(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.ANALOG_1;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertTrue(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.ANALOG_2;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertTrue(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.ANALOG_3;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertTrue(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.BIT_MASK_4;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertTrue(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.ANALOG_INTERVAL_5;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertTrue(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.ANALOG_INTERVAL_6;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertTrue(result.isAnalogInterval6());
        assertFalse(result.isNone7());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = (byte) ValueTriggerSettingAndroid.NONE_7;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertTrue(result.isNone7());
    }

    @Test
    public void test_constructor010() {
        //@formatter:off
        byte[] value = new byte[9];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertEquals(0x01, result.getCondition());
        assertEquals(0x0302, result.getValueAnalog());
        assertArrayEquals(Arrays.copyOfRange(value, 3, 5), result.getValueBitMask());
        assertEquals(0x09080706L, result.getValueAnalogInterval());
    }

    @Test
    public void test_constructor011() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = (byte) 0xff;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertEquals(0x01, result.getCondition());
        assertEquals(0x0302, result.getValueAnalog());
        assertArrayEquals(Arrays.copyOfRange(value, 3, 4), result.getValueBitMask());
        assertEquals(0xff070605L, result.getValueAnalogInterval());
    }

    @Test
    public void test_constructor012() {
        int condition = 0;
        int valueAnalog = 1;
        byte[] valueBitMask = new byte[] { 2 };
        long valueAnalogInterval = 3;

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(condition, valueAnalog, valueBitMask, valueAnalogInterval);
        assertEquals(condition, result.getCondition());
        assertEquals(valueAnalog, result.getValueAnalog());
        assertArrayEquals(valueBitMask, result.getValueBitMask());
        assertEquals(valueAnalogInterval, result.getValueAnalogInterval());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogInterval(), result2.getValueAnalogInterval());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[8];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] value = new byte[9];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogInterval(), result2.getValueAnalogInterval());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] value = new byte[9];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] value = new byte[9];
        value[ 0] = 0x01;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        value[ 5] = 0x06;
        value[ 6] = 0x07;
        value[ 7] = 0x08;
        value[ 8] = 0x09;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
