package org.im97mori.ble.characteristic.u2aa3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class BarometricPressureTrendAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_UNKNOWN;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_CONTINUOUSLY_FALLING;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_CONTINUOUSLY_RISING;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_FALLING_THEN_STEADY;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_RISING_THEN_STEADY;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_FALLING_BEFORE_A_LESSER_RISE;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_FALLING_BEFORE_A_GREATER_RISE;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_RISING_BEFORE_A_GREATER_FALL;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_RISING_BEFORE_A_LESSER_FALL;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[1];
        data[ 0] = BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_STEADY;
        data_00010 = data;
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

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_UNKNOWN, result1.getBarometricPressureTrend());
        assertTrue(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_CONTINUOUSLY_FALLING, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertTrue(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_CONTINUOUSLY_RISING, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertTrue(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_FALLING_THEN_STEADY, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertTrue(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_RISING_THEN_STEADY, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertTrue(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_FALLING_BEFORE_A_LESSER_RISE, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertTrue(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_FALLING_BEFORE_A_GREATER_RISE, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertTrue(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_RISING_BEFORE_A_GREATER_FALL, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertTrue(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_RISING_BEFORE_A_LESSER_FALL, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertTrue(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertFalse(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertEquals(BarometricPressureTrend.BAROMETRIC_PRESSURE_TREND_STEADY, result1.getBarometricPressureTrend());
        assertFalse(result1.isBarometricPressureTrendUnknown());
        assertFalse(result1.isBarometricPressureTrendContinuouslyFalling());
        assertFalse(result1.isBarometricPressureTrendContinuouslyRising());
        assertFalse(result1.isBarometricPressureTrendFallingThenSteady());
        assertFalse(result1.isBarometricPressureTrendRisingThenSteady());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeALesserRise());
        assertFalse(result1.isBarometricPressureTrendFallingBeforeAGreaterRise());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeAGreaterFall());
        assertFalse(result1.isBarometricPressureTrendRisingBeforeALesserFall());
        assertTrue(result1.isBarometricPressureTrendSteady());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getBarometricPressureTrend(), result2.getBarometricPressureTrend());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BarometricPressureTrendAndroid result1 = new BarometricPressureTrendAndroid(bluetoothGattCharacteristic);
        BarometricPressureTrendAndroid result2 = BarometricPressureTrendAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
