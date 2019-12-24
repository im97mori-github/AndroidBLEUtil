package org.im97mori.ble.characteristic.bcs;

import android.os.Parcel;

import org.im97mori.ble.characteristic.core.DateTimeUtils;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BodyCompositionMeasurementParcelableTest {

    @Test
    public void test_parcelable001() {
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[5];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[6];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = (byte) 0xff;
        data[ 5] = (byte) 0xff;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_FALSE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
        //@formatter:off
        byte[] data = new byte[31];
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL;
        data[ 3] = (byte) (BodyCompositionMeasurement.MEASUREMENT_UNSUCCESSFUL >> 8);
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_SI
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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
        int flags = BodyCompositionMeasurement.FLAG_MEASUREMENT_UNITS_IMPERIAL
                | BodyCompositionMeasurement.FLAG_TIME_STAMP_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_USER_ID_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BASAL_METABOLISM_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_PERCENTAGE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MUSCLE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_FAT_FREE_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_SOFT_LEAN_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_BODY_WATER_MASS_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_IMPEDANCE_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_WEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_HEIGHT_PRESENT_TRUE
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_FALSE;
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacket[]{BodyCompositionMeasurementPacket.CREATOR.createFromByteArray(data)});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BodyCompositionMeasurement result2 = BodyCompositionMeasurement.CREATOR.createFromParcel(parcel);
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

}
