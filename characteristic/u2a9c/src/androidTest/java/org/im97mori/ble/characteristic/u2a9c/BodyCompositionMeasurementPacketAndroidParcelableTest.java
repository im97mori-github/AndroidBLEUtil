package org.im97mori.ble.characteristic.u2a9c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import java.util.Arrays;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("ConstantConditions")
public class BodyCompositionMeasurementPacketAndroidParcelableTest {

    @Test
    public void test_parcelable001() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable002() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable003() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable004() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 1582;
        data[ 5] = (byte) (1582 >> 8);
        data[ 6] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 7] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable005() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JANUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable006() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable007() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MARCH;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable008() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_APRIL;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable009() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MAY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable010() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JUNE;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable011() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JULY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable012() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_AUGUST;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable013() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable014() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_OCTOBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable015() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable016() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_DECEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable017() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable018() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable019() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable020() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable021() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable022() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable023() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable024() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable025() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable026() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable027() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable028() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable029() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable030() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable031() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable032() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable033() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable034() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable035() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable036() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable037() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable038() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable039() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable040() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable041() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable042() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable043() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable044() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable045() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable046() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable047() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable048() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable049() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable050() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable051() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable052() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable053() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable054() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable055() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable056() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable057() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable058() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable059() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable060() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable061() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable062() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[31];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable063() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BodyCompositionMeasurementPacketAndroid bodyCompositionMeasurementPacket = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        BodyCompositionMeasurementAndroid result1 = new BodyCompositionMeasurementAndroid(bodyCompositionMeasurementPacket);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementAndroid result2 = BodyCompositionMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable064() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BodyCompositionMeasurementPacketAndroid bodyCompositionMeasurementPacket = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        BodyCompositionMeasurementAndroid result1 = new BodyCompositionMeasurementAndroid(bodyCompositionMeasurementPacket);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurementAndroid result2 = BodyCompositionMeasurementAndroid.CREATOR.createFromParcel(parcel);
        assertArrayEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getBodyFatPercentage(), result2.getBodyFatPercentage());
        assertEquals(result1.getYear(), result2.getYear());
        assertEquals(result1.getMonth(), result2.getMonth());
        assertEquals(result1.getDay(), result2.getDay());
        assertEquals(result1.getHours(), result2.getHours());
        assertEquals(result1.getMinutes(), result2.getMinutes());
        assertEquals(result1.getSeconds(), result2.getSeconds());
        assertEquals(result1.getUserId(), result2.getUserId());
        assertEquals(result1.getBasalMetabolism(), result2.getBasalMetabolism());
        assertEquals(result1.getMusclePercentage(), result2.getMusclePercentage());
        assertEquals(result1.getMuscleMassSi(), result2.getMuscleMassSi());
        assertEquals(result1.getMuscleMassImperial(), result2.getMuscleMassImperial());
        assertEquals(result1.getFatFreeMassSi(), result2.getFatFreeMassSi());
        assertEquals(result1.getFatFreeMassImperial(), result2.getFatFreeMassImperial());
        assertEquals(result1.getSoftLeanMassSi(), result2.getSoftLeanMassSi());
        assertEquals(result1.getSoftLeanMassImperial(), result2.getSoftLeanMassImperial());
        assertEquals(result1.getBodyWaterMassSi(), result2.getBodyWaterMassSi());
        assertEquals(result1.getBodyWaterMassImperial(), result2.getBodyWaterMassImperial());
        assertEquals(result1.getImpedance(), result2.getImpedance());
        assertEquals(result1.getWeightSi(), result2.getWeightSi());
        assertEquals(result1.getWeightImperial(), result2.getWeightImperial());
        assertEquals(result1.getHeightSi(), result2.getHeightSi());
        assertEquals(result1.getHeightImperial(), result2.getHeightImperial());
    }

    @Test
    public void test_parcelable101() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 1582;
        data[ 5] = (byte) (1582 >> 8);
        data[ 6] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 7] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JANUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MARCH;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_APRIL;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MAY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JUNE;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JULY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_AUGUST;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable114() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_OCTOBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable115() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable116() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_DECEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable117() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable118() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable119() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable120() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable121() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable122() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable123() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable124() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable125() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable126() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable127() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable128() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable129() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable130() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable131() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable132() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable133() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable134() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable135() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable136() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable137() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable138() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable139() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable140() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable141() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable142() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable143() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable144() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable145() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable146() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable147() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable148() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable149() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable150() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable151() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable152() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable153() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable154() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable155() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable156() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable157() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable158() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable159() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable160() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable161() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable162() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[31];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(Arrays.copyOfRange(data, 0, 12), result1.getBytes());
    }

    @Test
    public void test_parcelable163() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable164() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 1582;
        data[ 5] = (byte) (1582 >> 8);
        data[ 6] = DateTimeUtils.MONTH_IS_NOT_KNOWN;
        data[ 7] = DateTimeUtils.DAY_OF_MONTH_IS_NOT_KNOWN;
        data[ 8] = 0;
        data[ 9] = 0;
        data[10] = 0;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JANUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 59;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_FEBRUARY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MARCH;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_APRIL;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_MAY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JUNE;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_JULY;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_AUGUST;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_SEPTEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable214() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_OCTOBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable215() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_NOVEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable216() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[11];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 9999;
        data[ 5] = (byte) (9999 >> 8);
        data[ 6] = DateTimeUtils.MONTH_DECEMBER;
        data[ 7] = 1;
        data[ 8] = 23;
        data[ 9] = 59;
        data[10] = 58;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable217() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable218() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable219() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable220() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable221() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable222() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable223() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable224() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable225() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable226() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable227() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable228() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable229() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable230() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable231() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable232() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable233() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable234() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable235() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable236() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable237() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable238() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable239() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable240() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable241() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable242() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable243() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable244() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable245() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable246() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable247() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable248() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable249() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable250() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable251() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable252() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable253() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable254() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable255() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable256() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable257() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable258() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable259() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable260() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable261() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable262() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[31];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurementAndroid.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable263() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable264() {
        int flags = BodyCompositionMeasurementAndroid.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurementAndroid.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurementAndroid.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[30];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data[18] = 0x11;
        data[19] = 0x12;
        data[20] = 0x13;
        data[21] = 0x14;
        data[22] = 0x15;
        data[23] = 0x16;
        data[24] = 0x17;
        data[25] = 0x18;
        data[26] = 0x19;
        data[27] = 0x1a;
        data[28] = 0x1b;
        data[29] = 0x1c;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        BodyCompositionMeasurementPacketAndroid result1 = new BodyCompositionMeasurementPacketAndroid(bluetoothGattCharacteristic);
        BodyCompositionMeasurementPacketAndroid result2 = BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
