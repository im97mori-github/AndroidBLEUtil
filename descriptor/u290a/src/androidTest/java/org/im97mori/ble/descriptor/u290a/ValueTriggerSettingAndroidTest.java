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

@SuppressWarnings("ConstantConditions")
public class ValueTriggerSettingAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_0;
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
    public void test_constructor_00002() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_1;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(0x0302, result.getValueAnalog());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_2;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(0x0302, result.getValueAnalog());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_3;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(0x0302, result.getValueAnalog());
    }

    @Test
    public void test_constructor_00005() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.BIT_MASK_4;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertArrayEquals(Arrays.copyOfRange(value, 1, 3), result.getValueBitMask());
    }

    @Test
    public void test_constructor_00006() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_5;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
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
        assertEquals(0x0302, result.getValueAnalogOne());
        assertEquals(0x0504, result.getValueAnalogTwo());
    }

    @Test
    public void test_constructor_00007() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_6;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
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
        assertEquals(0x0302, result.getValueAnalogOne());
        assertEquals(0x0504, result.getValueAnalogTwo());
    }

    @Test
    public void test_constructor_00008() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_7;
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
    public void test_constructor_00009() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_0, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
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
    public void test_constructor_00010() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_1, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertFalse(result.isNone0());
        assertTrue(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
        assertEquals(0x0201, result.getValueAnalog());
    }

    @Test
    public void test_constructor_00011() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_2, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertTrue(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
        assertEquals(0x0201, result.getValueAnalog());
    }

    @Test
    public void test_constructor_00012() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_3, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertTrue(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
        assertEquals(0x0201, result.getValueAnalog());
    }

    @Test
    public void test_constructor_00013() {
        byte[] value = new byte[]{0x03, 0x04};

        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.BIT_MASK_4, 0x0201, value, 0x0605, 0x0807);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertTrue(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
        assertArrayEquals(value, result.getValueBitMask());
    }

    @Test
    public void test_constructor_00014() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_5, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertTrue(result.isAnalogInterval5());
        assertFalse(result.isAnalogInterval6());
        assertFalse(result.isNone7());
        assertEquals(0x0605, result.getValueAnalogOne());
        assertEquals(0x0807, result.getValueAnalogTwo());
    }

    @Test
    public void test_constructor_00015() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_6, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertFalse(result.isNone0());
        assertFalse(result.isAnalog1());
        assertFalse(result.isAnalog2());
        assertFalse(result.isAnalog3());
        assertFalse(result.isBitMask4());
        assertFalse(result.isAnalogInterval5());
        assertTrue(result.isAnalogInterval6());
        assertFalse(result.isNone7());
        assertEquals(0x0605, result.getValueAnalogOne());
        assertEquals(0x0807, result.getValueAnalogTwo());
    }

    @Test
    public void test_constructor_00016() {
        ValueTriggerSettingAndroid result = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_7, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
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
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_0;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_1;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_2;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_3;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00005() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.BIT_MASK_4;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00006() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_5;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00007() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_6;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00008() {
        //@formatter:off
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_7;
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
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00009() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_0, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00010() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_1, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00011() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_2, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00012() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_3, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00013() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.BIT_MASK_4, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00014() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_5, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00015() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_6, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00016() {
        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_7, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCondition(), result2.getCondition());
        assertEquals(result2.getValueAnalog(), result2.getValueAnalog());
        assertArrayEquals(result2.getValueBitMask(), result2.getValueBitMask());
        assertEquals(result2.getValueAnalogOne(), result2.getValueAnalogOne());
        assertEquals(result2.getValueAnalogTwo(), result2.getValueAnalogTwo());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_0;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_1;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_2;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_3;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.BIT_MASK_4;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00106() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_5;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00107() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_6;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00108() {
        //@formatter:off
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_7;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00109() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_0;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_0, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00110() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_1;
        value[ 1] = 0x01;
        value[ 2] = 0x02;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_1, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00111() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_2;
        value[ 1] = 0x01;
        value[ 2] = 0x02;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_2, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00112() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_3;
        value[ 1] = 0x01;
        value[ 2] = 0x02;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_3, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00113() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.BIT_MASK_4;
        value[ 1] = 0x03;
        value[ 2] = 0x04;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.BIT_MASK_4, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00114() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_5;
        value[ 1] = 0x05;
        value[ 2] = 0x06;
        value[ 3] = 0x07;
        value[ 4] = 0x08;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_5, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00115() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_6;
        value[ 1] = 0x05;
        value[ 2] = 0x06;
        value[ 3] = 0x07;
        value[ 4] = 0x08;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_6, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00116() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_7;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_7, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_0;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_1;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_2;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_3;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.BIT_MASK_4;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00206() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_5;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00207() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_6;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        value[ 4] = 0x05;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00208() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_7;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(bluetoothGattDescriptor);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00209() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_0;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_0, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00210() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_1;
        value[ 1] = 0x01;
        value[ 2] = 0x02;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_1, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00211() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_2;
        value[ 1] = 0x01;
        value[ 2] = 0x02;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_2, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00212() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_3;
        value[ 1] = 0x01;
        value[ 2] = 0x02;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_3, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00213() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) ValueTriggerSetting.BIT_MASK_4;
        value[ 1] = 0x03;
        value[ 2] = 0x04;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.BIT_MASK_4, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00214() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_5;
        value[ 1] = 0x05;
        value[ 2] = 0x06;
        value[ 3] = 0x07;
        value[ 4] = 0x08;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_5, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00215() {
        //@formatter:off
        byte[] value = new byte[5];
        value[ 0] = (byte) ValueTriggerSetting.ANALOG_INTERVAL_6;
        value[ 1] = 0x05;
        value[ 2] = 0x06;
        value[ 3] = 0x07;
        value[ 4] = 0x08;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.ANALOG_INTERVAL_6, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00216() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) ValueTriggerSetting.NONE_7;
        //@formatter:on

        ValueTriggerSettingAndroid result1 = new ValueTriggerSettingAndroid(ValueTriggerSetting.NONE_7, 0x0201, new byte[]{0x03, 0x04}, 0x0605, 0x0807);
        ValueTriggerSettingAndroid result2 = ValueTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
