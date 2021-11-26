package org.im97mori.ble.characteristic.u2b4d;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

@SuppressWarnings({"unused", "ConstantConditions"})
public class HighIntensityExerciseThresholdAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = HighIntensityExerciseThreshold.FIELD_SELECTOR_NO_FIELD_IS_SELECTED;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[ 0] = HighIntensityExerciseThreshold.FIELD_SELECTOR_ENERGY_EXPEDITURE_PER_HOUR_FIELD;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[2];
        data[ 0] = HighIntensityExerciseThreshold.FIELD_SELECTOR_METABOLIC_EQUIVALENT_FILED;
        data[ 1] = 0x01;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[2];
        data[ 0] = HighIntensityExerciseThreshold.FIELD_SELECTOR_PERCENTAGE_OF_MAXIMUM_HEART_RATE_FIELD;
        data[ 1] = 0x01;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[2];
        data[ 0] = HighIntensityExerciseThreshold.FIELD_SELECTOR_HEART_RATE_FIELD;
        data[ 1] = 0x01;
        data_00005 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(HighIntensityExerciseThreshold.FIELD_SELECTOR_NO_FIELD_IS_SELECTED, result1.getFieldSelector());
        assertTrue(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(0, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(0, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(0, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(0, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(HighIntensityExerciseThreshold.FIELD_SELECTOR_ENERGY_EXPEDITURE_PER_HOUR_FIELD,
                result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertTrue(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(BLEUtils.createUInt16(data, 1), result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(0, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(0, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(0, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(HighIntensityExerciseThreshold.FIELD_SELECTOR_METABOLIC_EQUIVALENT_FILED,
                result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertTrue(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(0, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(BLEUtils.createUInt8(data, 1), result1.getThresholdAsMetabolicEquivalent());
        assertEquals(0, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(0, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(HighIntensityExerciseThreshold.FIELD_SELECTOR_PERCENTAGE_OF_MAXIMUM_HEART_RATE_FIELD,
                result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertTrue(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(0, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(0, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(BLEUtils.createUInt8(data, 1), result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(0, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertEquals(HighIntensityExerciseThreshold.FIELD_SELECTOR_HEART_RATE_FIELD, result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertTrue(result1.isFieldSelectorHeartRateField());
        assertEquals(0, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(0, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(0, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(BLEUtils.createUInt8(data, 1), result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00101() {
        int fieldSelector = HighIntensityExerciseThreshold.FIELD_SELECTOR_NO_FIELD_IS_SELECTED;
        int thresholdAsEnergyExpenditurePerHour = 1;
        int thresholdAsMetabolicEquivalent = 2;
        int thresholdAsPercentageOfMaximumHeartRate = 3;
        int thresholdAsHeartRate = 4;

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(fieldSelector,
                thresholdAsEnergyExpenditurePerHour, thresholdAsMetabolicEquivalent,
                thresholdAsPercentageOfMaximumHeartRate, thresholdAsHeartRate);
        assertEquals(fieldSelector, result1.getFieldSelector());
        assertTrue(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(thresholdAsEnergyExpenditurePerHour, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(thresholdAsMetabolicEquivalent, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(thresholdAsPercentageOfMaximumHeartRate, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(thresholdAsHeartRate, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00102() {
        int fieldSelector = HighIntensityExerciseThreshold.FIELD_SELECTOR_ENERGY_EXPEDITURE_PER_HOUR_FIELD;
        int thresholdAsEnergyExpenditurePerHour = 1;
        int thresholdAsMetabolicEquivalent = 2;
        int thresholdAsPercentageOfMaximumHeartRate = 3;
        int thresholdAsHeartRate = 4;

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(fieldSelector,
                thresholdAsEnergyExpenditurePerHour, thresholdAsMetabolicEquivalent,
                thresholdAsPercentageOfMaximumHeartRate, thresholdAsHeartRate);
        assertEquals(fieldSelector, result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertTrue(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(thresholdAsEnergyExpenditurePerHour, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(thresholdAsMetabolicEquivalent, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(thresholdAsPercentageOfMaximumHeartRate, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(thresholdAsHeartRate, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00103() {
        int fieldSelector = HighIntensityExerciseThreshold.FIELD_SELECTOR_METABOLIC_EQUIVALENT_FILED;
        int thresholdAsEnergyExpenditurePerHour = 1;
        int thresholdAsMetabolicEquivalent = 2;
        int thresholdAsPercentageOfMaximumHeartRate = 3;
        int thresholdAsHeartRate = 4;

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(fieldSelector,
                thresholdAsEnergyExpenditurePerHour, thresholdAsMetabolicEquivalent,
                thresholdAsPercentageOfMaximumHeartRate, thresholdAsHeartRate);
        assertEquals(fieldSelector, result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertTrue(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(thresholdAsEnergyExpenditurePerHour, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(thresholdAsMetabolicEquivalent, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(thresholdAsPercentageOfMaximumHeartRate, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(thresholdAsHeartRate, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00104() {
        int fieldSelector = HighIntensityExerciseThreshold.FIELD_SELECTOR_PERCENTAGE_OF_MAXIMUM_HEART_RATE_FIELD;
        int thresholdAsEnergyExpenditurePerHour = 1;
        int thresholdAsMetabolicEquivalent = 2;
        int thresholdAsPercentageOfMaximumHeartRate = 3;
        int thresholdAsHeartRate = 4;

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(fieldSelector,
                thresholdAsEnergyExpenditurePerHour, thresholdAsMetabolicEquivalent,
                thresholdAsPercentageOfMaximumHeartRate, thresholdAsHeartRate);
        assertEquals(fieldSelector, result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertTrue(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertFalse(result1.isFieldSelectorHeartRateField());
        assertEquals(thresholdAsEnergyExpenditurePerHour, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(thresholdAsMetabolicEquivalent, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(thresholdAsPercentageOfMaximumHeartRate, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(thresholdAsHeartRate, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_constructor_00105() {
        int fieldSelector = HighIntensityExerciseThreshold.FIELD_SELECTOR_HEART_RATE_FIELD;
        int thresholdAsEnergyExpenditurePerHour = 1;
        int thresholdAsMetabolicEquivalent = 2;
        int thresholdAsPercentageOfMaximumHeartRate = 3;
        int thresholdAsHeartRate = 4;

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(fieldSelector,
                thresholdAsEnergyExpenditurePerHour, thresholdAsMetabolicEquivalent,
                thresholdAsPercentageOfMaximumHeartRate, thresholdAsHeartRate);
        assertEquals(fieldSelector, result1.getFieldSelector());
        assertFalse(result1.isFieldSelectorNoFieldIsSelected());
        assertFalse(result1.isFieldSelectorEnergyExpediturePerHourField());
        assertFalse(result1.isFieldSelectorMetabolicEquivalentField());
        assertFalse(result1.isFieldSelectorPercentageOfMaximumHeartRateField());
        assertTrue(result1.isFieldSelectorHeartRateField());
        assertEquals(thresholdAsEnergyExpenditurePerHour, result1.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(thresholdAsMetabolicEquivalent, result1.getThresholdAsMetabolicEquivalent());
        assertEquals(thresholdAsPercentageOfMaximumHeartRate, result1.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(thresholdAsHeartRate, result1.getThresholdAsHeartRate());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFieldSelector(), result2.getFieldSelector());
        assertEquals(result1.getThresholdAsEnergyExpenditurePerHour(), result2.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(result1.getThresholdAsMetabolicEquivalent(), result2.getThresholdAsMetabolicEquivalent());
        assertEquals(result1.getThresholdAsPercentageOfMaximumHeartRate(), result2.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(result1.getThresholdAsHeartRate(), result2.getThresholdAsHeartRate());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFieldSelector(), result2.getFieldSelector());
        assertEquals(result1.getThresholdAsEnergyExpenditurePerHour(), result2.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(result1.getThresholdAsMetabolicEquivalent(), result2.getThresholdAsMetabolicEquivalent());
        assertEquals(result1.getThresholdAsPercentageOfMaximumHeartRate(), result2.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(result1.getThresholdAsHeartRate(), result2.getThresholdAsHeartRate());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFieldSelector(), result2.getFieldSelector());
        assertEquals(result1.getThresholdAsEnergyExpenditurePerHour(), result2.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(result1.getThresholdAsMetabolicEquivalent(), result2.getThresholdAsMetabolicEquivalent());
        assertEquals(result1.getThresholdAsPercentageOfMaximumHeartRate(), result2.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(result1.getThresholdAsHeartRate(), result2.getThresholdAsHeartRate());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFieldSelector(), result2.getFieldSelector());
        assertEquals(result1.getThresholdAsEnergyExpenditurePerHour(), result2.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(result1.getThresholdAsMetabolicEquivalent(), result2.getThresholdAsMetabolicEquivalent());
        assertEquals(result1.getThresholdAsPercentageOfMaximumHeartRate(), result2.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(result1.getThresholdAsHeartRate(), result2.getThresholdAsHeartRate());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFieldSelector(), result2.getFieldSelector());
        assertEquals(result1.getThresholdAsEnergyExpenditurePerHour(), result2.getThresholdAsEnergyExpenditurePerHour());
        assertEquals(result1.getThresholdAsMetabolicEquivalent(), result2.getThresholdAsMetabolicEquivalent());
        assertEquals(result1.getThresholdAsPercentageOfMaximumHeartRate(), result2.getThresholdAsPercentageOfMaximumHeartRate());
        assertEquals(result1.getThresholdAsHeartRate(), result2.getThresholdAsHeartRate());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        HighIntensityExerciseThresholdAndroid result1 = new HighIntensityExerciseThresholdAndroid(bluetoothGattCharacteristic);
        HighIntensityExerciseThresholdAndroid result2 = HighIntensityExerciseThresholdAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
