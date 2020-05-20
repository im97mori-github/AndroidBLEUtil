package org.im97mori.ble.characteristic.u2a9c;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class BodyCompositionMeasurementAndroidConstructorTest {

    @Test
    public void test_constructor001() {
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

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacketAndroid[]{BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data)});
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getFlags());
        assertEquals(0x0201, result1.getBodyFatPercentage());
        assertEquals(0x0403, result1.getYear());
        assertEquals(0x05, result1.getMonth());
        assertEquals(0x06, result1.getDay());
        assertEquals(0x07, result1.getHours());
        assertEquals(0x08, result1.getMinutes());
        assertEquals(0x09, result1.getSeconds());
        assertEquals(0x0a, result1.getUserId());
        assertEquals(0x0c0b, result1.getBasalMetabolism());
        assertEquals(0x0e0d, result1.getMusclePercentage());
        assertEquals(0x100f, result1.getMuscleMassSi());
        assertEquals(0x1211, result1.getFatFreeMassSi());
        assertEquals(0x1413, result1.getSoftLeanMassSi());
        assertEquals(0x1615, result1.getBodyWaterMassSi());
        assertEquals(0x1817, result1.getImpedance());
        assertEquals(0x1a19, result1.getWeightSi());
        assertEquals(0x1c1b, result1.getHeightSi());
    }

    @Test
    public void test_constructor002() {
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
                | BodyCompositionMeasurement.FLAG_MULTIPLE_PACKET_MEASUREMENT_TRUE;
        //@formatter:off
        byte[] data1 = new byte[30];
        data1[ 0] = (byte) flags;
        data1[ 1] = (byte) (flags >> 8);
        data1[ 2] = 0x01;
        data1[ 3] = 0x02;
        data1[ 4] = 0x03;
        data1[ 5] = 0x04;
        data1[ 6] = 0x05;
        data1[ 7] = 0x06;
        data1[ 8] = 0x07;
        data1[ 9] = 0x08;
        data1[10] = 0x09;
        data1[11] = 0x0a;
        data1[12] = 0x0b;
        data1[13] = 0x0c;
        data1[14] = 0x0d;
        data1[15] = 0x0e;
        data1[16] = 0x0f;
        data1[17] = 0x10;
        data1[18] = 0x11;
        data1[19] = 0x12;
        data1[20] = 0x13;
        data1[21] = 0x14;
        data1[22] = 0x15;
        data1[23] = 0x16;
        data1[24] = 0x17;
        data1[25] = 0x18;
        data1[26] = 0x19;
        data1[27] = 0x1a;
        data1[28] = 0x1b;
        data1[29] = 0x1c;

        byte[] data2 = new byte[30];
        data2[ 0] = (byte) flags;
        data2[ 1] = (byte) (flags >> 8);
        data2[ 2] = 0x21;
        data2[ 3] = 0x22;
        data2[ 4] = 0x23;
        data2[ 5] = 0x24;
        data2[ 6] = 0x25;
        data2[ 7] = 0x26;
        data2[ 8] = 0x27;
        data2[ 9] = 0x28;
        data2[10] = 0x29;
        data2[11] = 0x2a;
        data2[12] = 0x2b;
        data2[13] = 0x2c;
        data2[14] = 0x2d;
        data2[15] = 0x2e;
        data2[16] = 0x2f;
        data2[17] = 0x30;
        data2[18] = 0x31;
        data2[19] = 0x32;
        data2[20] = 0x33;
        data2[21] = 0x34;
        data2[22] = 0x35;
        data2[23] = 0x36;
        data2[24] = 0x37;
        data2[25] = 0x38;
        data2[26] = 0x39;
        data2[27] = 0x3a;
        data2[28] = 0x3b;
        data2[29] = 0x3c;
        //@formatter:on

        BodyCompositionMeasurement result1 = new BodyCompositionMeasurement(new BodyCompositionMeasurementPacketAndroid[]{BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data1), BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(data2)});
        assertArrayEquals(Arrays.copyOfRange(data1, 0, 2), result1.getFlags());
        assertEquals(0x2221, result1.getBodyFatPercentage());
        assertEquals(0x2423, result1.getYear());
        assertEquals(0x25, result1.getMonth());
        assertEquals(0x26, result1.getDay());
        assertEquals(0x27, result1.getHours());
        assertEquals(0x28, result1.getMinutes());
        assertEquals(0x29, result1.getSeconds());
        assertEquals(0x2a, result1.getUserId());
        assertEquals(0x2c2b, result1.getBasalMetabolism());
        assertEquals(0x2e2d, result1.getMusclePercentage());
        assertEquals(0x302f, result1.getMuscleMassSi());
        assertEquals(0x3231, result1.getFatFreeMassSi());
        assertEquals(0x3433, result1.getSoftLeanMassSi());
        assertEquals(0x3635, result1.getBodyWaterMassSi());
        assertEquals(0x3837, result1.getImpedance());
        assertEquals(0x3a39, result1.getWeightSi());
        assertEquals(0x3c3b, result1.getHeightSi());
    }

    @Test
    public void test_constructor003() {
        byte[] flags = new byte[] { 1 };
        int bodyFatPercentage = 2;
        int year = 3;
        int month = 4;
        int day = 5;
        int hours = 6;
        int minutes = 7;
        int seconds = 8;
        int userId = 9;
        int basalMetabolism = 10;
        int musclePercentage = 11;
        int muscleMassSi = 12;
        int muscleMassImperial = 13;
        int fatFreeMassSi = 14;
        int fatFreeMassImperial = 15;
        int softLeanMassSi = 16;
        int softLeanMassImperial = 17;
        int bodyWaterSi = 18;
        int bodyWaterImperial = 19;
        int impedance = 20;
        int weightSi = 21;
        int weightImperial = 22;
        int heightSi = 23;
        int heightImperial = 24;

        BodyCompositionMeasurementAndroid result1 = new BodyCompositionMeasurementAndroid(
                flags, bodyFatPercentage, year, month, day, hours, minutes, seconds, userId, basalMetabolism, musclePercentage, muscleMassSi, muscleMassImperial, fatFreeMassSi, fatFreeMassImperial, softLeanMassSi, softLeanMassImperial, bodyWaterSi, bodyWaterImperial, impedance, weightSi, weightImperial, heightSi, heightImperial);
        assertArrayEquals(flags, result1.getFlags());
        assertEquals(bodyFatPercentage, result1.getBodyFatPercentage());
        assertEquals(year, result1.getYear());
        assertEquals(month, result1.getMonth());
        assertEquals(day, result1.getDay());
        assertEquals(hours, result1.getHours());
        assertEquals(minutes, result1.getMinutes());
        assertEquals(seconds, result1.getSeconds());
        assertEquals(userId, result1.getUserId());
        assertEquals(basalMetabolism, result1.getBasalMetabolism());
        assertEquals(musclePercentage, result1.getMusclePercentage());
        assertEquals(muscleMassSi, result1.getMuscleMassSi());
        assertEquals(muscleMassImperial, result1.getMuscleMassImperial());
        assertEquals(fatFreeMassSi, result1.getFatFreeMassSi());
        assertEquals(fatFreeMassImperial, result1.getFatFreeMassImperial());
        assertEquals(softLeanMassSi, result1.getSoftLeanMassSi());
        assertEquals(softLeanMassImperial, result1.getSoftLeanMassImperial());
        assertEquals(bodyWaterSi, result1.getBodyWaterMassSi());
        assertEquals(bodyWaterImperial, result1.getBodyWaterMassImperial());
        assertEquals(impedance, result1.getImpedance());
        assertEquals(weightSi, result1.getWeightSi());
        assertEquals(weightImperial, result1.getWeightImperial());
        assertEquals(heightSi, result1.getHeightSi());
        assertEquals(heightImperial, result1.getHeightImperial());
    }

}
