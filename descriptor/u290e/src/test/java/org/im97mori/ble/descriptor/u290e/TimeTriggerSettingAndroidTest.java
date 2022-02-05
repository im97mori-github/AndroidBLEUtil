package org.im97mori.ble.descriptor.u290e;

import android.bluetooth.BluetoothGattDescriptor;
import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("ConstantConditions")
public class TimeTriggerSettingAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertTrue(result.isConditionNoTimeBasedTriggeringUsed());
        assertFalse(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertFalse(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertFalse(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x02, result.getValueNone());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isConditionNoTimeBasedTriggeringUsed());
        assertTrue(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertFalse(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertFalse(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x040302, result.getValueTimeInterval());
    }

    @Test
    public void test_constructor_00003() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isConditionNoTimeBasedTriggeringUsed());
        assertFalse(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertTrue(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertFalse(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x040302, result.getValueTimeInterval());
    }

    @Test
    public void test_constructor_00004() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertFalse(result.isConditionNoTimeBasedTriggeringUsed());
        assertFalse(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertFalse(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertTrue(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x0302, result.getValueCount());
    }

    @Test
    public void test_constructor_00005() {
        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0x02, 0x050403, 0x0706);
        assertTrue(result.isConditionNoTimeBasedTriggeringUsed());
        assertFalse(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertFalse(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertFalse(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x02, result.getValueNone());
    }

    @Test
    public void test_constructor_00006() {
        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        assertFalse(result.isConditionNoTimeBasedTriggeringUsed());
        assertTrue(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertFalse(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertFalse(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x050403, result.getValueTimeInterval());
    }

    @Test
    public void test_constructor_00007() {
        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        assertFalse(result.isConditionNoTimeBasedTriggeringUsed());
        assertFalse(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertTrue(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertFalse(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x050403, result.getValueTimeInterval());
    }

    @Test
    public void test_constructor_00008() {
        TimeTriggerSettingAndroid result = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0x02, 0x050403, 0x0706);
        assertFalse(result.isConditionNoTimeBasedTriggeringUsed());
        assertFalse(result.isConditionIndicatesOrNotifiedIUnconditionallyAfterASettableTime());
        assertFalse(result.isConditionNotIndicatedOrNotifiedMoreOftenThanASettableTime());
        assertTrue(result.isConditionChangedMoreOfthenThan());
        assertEquals(0x0706, result.getValueCount());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueNone(), result2.getValueNone());
        assertEquals(result1.getValueTimeInterval(), result2.getValueTimeInterval());
        assertEquals(result1.getValueCount(), result2.getValueCount());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueNone(), result2.getValueNone());
        assertEquals(result1.getValueTimeInterval(), result2.getValueTimeInterval());
        assertEquals(result1.getValueCount(), result2.getValueCount());
    }

    @Test
    public void test_parcelable_00003() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueNone(), result2.getValueNone());
        assertEquals(result1.getValueTimeInterval(), result2.getValueTimeInterval());
        assertEquals(result1.getValueCount(), result2.getValueCount());
    }

    @Test
    public void test_parcelable_00004() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueNone(), result2.getValueNone());
        assertEquals(result1.getValueTimeInterval(), result2.getValueTimeInterval());
        assertEquals(result1.getValueCount(), result2.getValueCount());
    }

    @Test
    public void test_parcelable_00005() {
        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0x02, 0x050403, 0x0706);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueNone(), result2.getValueNone());
    }

    @Test
    public void test_parcelable_00006() {
        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueTimeInterval(), result2.getValueTimeInterval());
    }

    @Test
    public void test_parcelable_00007() {
        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueTimeInterval(), result2.getValueTimeInterval());
    }

    @Test
    public void test_parcelable_00008() {
        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0x02, 0x050403, 0x0706);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getCondition(), result2.getCondition());
        assertEquals(result1.getValueCount(), result2.getValueCount());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00103() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00104() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00105() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED;
        value[ 1] = 0x02;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0x02, 0x050403, 0x0706);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00106() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME;
        value[ 1] = 0x03;
        value[ 2] = 0x04;
        value[ 3] = 0x05;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00107() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME;
        value[ 1] = 0x03;
        value[ 2] = 0x04;
        value[ 3] = 0x05;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00108() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN;
        value[ 1] = 0x06;
        value[ 2] = 0x07;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0x02, 0x050403, 0x0706);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED;
        value[ 1] = 0x02;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00203() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        value[ 3] = 0x04;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00204() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN;
        value[ 1] = 0x02;
        value[ 2] = 0x03;
        //@formatter:on

        BluetoothGattDescriptor bluetoothGattDescriptor = new BluetoothGattDescriptor(BASE_UUID, 0);
        bluetoothGattDescriptor.setValue(value);

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(bluetoothGattDescriptor);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00205() {
        //@formatter:off
        byte[] value = new byte[2];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED;
        value[ 1] = 0x02;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NO_TIME_BASED_TRIGGERING_USED, 0x02, 0x050403, 0x0706);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00206() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME;
        value[ 1] = 0x03;
        value[ 2] = 0x04;
        value[ 3] = 0x05;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_INDICATES_OR_NOTIFIED_UNCONDITIONALLY_AFTER_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00207() {
        //@formatter:off
        byte[] value = new byte[4];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME;
        value[ 1] = 0x03;
        value[ 2] = 0x04;
        value[ 3] = 0x05;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_NOT_INDICATED_OR_NOTIFIED_MORE_OFTEN_THAN_A_SETTABLE_TIME, 0x02, 0x050403, 0x0706);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00208() {
        //@formatter:off
        byte[] value = new byte[3];
        value[ 0] = (byte) TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN;
        value[ 1] = 0x06;
        value[ 2] = 0x07;
        //@formatter:on

        TimeTriggerSettingAndroid result1 = new TimeTriggerSettingAndroid(TimeTriggerSetting.CONDITION_CHANGED_MORE_OFTEN_THAN, 0x02, 0x050403, 0x0706);
        TimeTriggerSettingAndroid result2 = TimeTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
