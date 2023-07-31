package org.im97mori.ble.characteristic.u2a64;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue*/
@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CyclingPowerVectorAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[5];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[3];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00202 = data;
    }

    private static final byte[] data_00203;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00203 = data;
    }

    private static final byte[] data_00204;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00204 = data;
    }

    private static final byte[] data_00205;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00205 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00302 = data;
    }

    private static final byte[] data_00303;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00303 = data;
    }

    private static final byte[] data_00304;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00304 = data;
    }

    private static final byte[] data_00305;
    static {
        byte[] data = new byte[19];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_TRUE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data[11] = 0x0b;
        data[12] = 0x0c;
        data[13] = 0x0d;
        data[14] = 0x0e;
        data[15] = 0x0f;
        data[16] = 0x10;
        data[17] = 0x11;
        data[18] = 0x12;
        data_00305 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_UNKNOWN;
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_TANGENTIAL_COMPONENT;
        data_00402 = data;
    }

    private static final byte[] data_00403;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_RADIAL_COMPONENT;
        data_00403 = data;
    }

    private static final byte[] data_00404;
    static {
        byte[] data = new byte[1];
        data[ 0] = CyclingPowerVector.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_FIRST_CRANK_MEASUREMENT_ANGLE_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_FORCE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_PRESENT_FALSE
                | CyclingPowerVector.FLAGS_INSTANTANEOUS_MEASUREMENT_DIRECTION_LATERAL_COMPONENT;
        data_00404 = data;
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
            String[] stringArray = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + stringArray[stringArray.length - 1]).get(null);
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

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsCrankRevolutionDataNotPresent());
        assertFalse(result1.isFlagsCrankRevolutionDataPresent());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsCrankRevolutionDataNotPresent());
        assertTrue(result1.isFlagsCrankRevolutionDataPresent());
        assertEquals(0x0201, result1.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(0x0403, result1.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(CyclingPowerVector.CRANK_REVOLUTION_DATA_LAST_CRANK_EVENT_TIME_RESOLUTION * 0x0403, result1.getCrankRevolutionDataLastCrankEventTimeSeconds(), 0);
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsFirstCrankMeasurementAngleNotPresent());
        assertFalse(result1.isFlagsFirstCrankMeasurementAnglePresent());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsFirstCrankMeasurementAngleNotPresent());
        assertTrue(result1.isFlagsFirstCrankMeasurementAnglePresent());
        assertEquals(0x0201, result1.getFirstCrankMeasurementAngle());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsInstantaneousForceMagnitudeArrayNotPresent());
        assertFalse(result1.isFlagsInstantaneousForceMagnitudeArrayPresent());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousForceMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousForceMagnitudeArrayPresent());
        assertEquals(9, result1.getInstantaneousForceMagnitudeArray().length);
        assertEquals(0x0201, result1.getInstantaneousForceMagnitude(0));
        assertEquals(0x0403, result1.getInstantaneousForceMagnitude(1));
        assertEquals(0x0605, result1.getInstantaneousForceMagnitude(2));
        assertEquals(0x0807, result1.getInstantaneousForceMagnitude(3));
        assertEquals(0x0a09, result1.getInstantaneousForceMagnitude(4));
        assertEquals(0x0c0b, result1.getInstantaneousForceMagnitude(5));
        assertEquals(0x0e0d, result1.getInstantaneousForceMagnitude(6));
        assertEquals(0x100f, result1.getInstantaneousForceMagnitude(7));
        assertEquals(0x1211, result1.getInstantaneousForceMagnitude(8));
    }

    @Test
    public void test_constructor_00203() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousForceMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousForceMagnitudeArrayPresent());
        assertEquals(7, result1.getInstantaneousForceMagnitudeArray().length);
        assertEquals(0x0605, result1.getInstantaneousForceMagnitude(0));
        assertEquals(0x0807, result1.getInstantaneousForceMagnitude(1));
        assertEquals(0x0a09, result1.getInstantaneousForceMagnitude(2));
        assertEquals(0x0c0b, result1.getInstantaneousForceMagnitude(3));
        assertEquals(0x0e0d, result1.getInstantaneousForceMagnitude(4));
        assertEquals(0x100f, result1.getInstantaneousForceMagnitude(5));
        assertEquals(0x1211, result1.getInstantaneousForceMagnitude(6));
    }

    @Test
    public void test_constructor_00204() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousForceMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousForceMagnitudeArrayPresent());
        assertEquals(8, result1.getInstantaneousForceMagnitudeArray().length);
        assertEquals(0x0403, result1.getInstantaneousForceMagnitude(0));
        assertEquals(0x0605, result1.getInstantaneousForceMagnitude(1));
        assertEquals(0x0807, result1.getInstantaneousForceMagnitude(2));
        assertEquals(0x0a09, result1.getInstantaneousForceMagnitude(3));
        assertEquals(0x0c0b, result1.getInstantaneousForceMagnitude(4));
        assertEquals(0x0e0d, result1.getInstantaneousForceMagnitude(5));
        assertEquals(0x100f, result1.getInstantaneousForceMagnitude(6));
        assertEquals(0x1211, result1.getInstantaneousForceMagnitude(7));
    }

    @Test
    public void test_constructor_00205() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousForceMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousForceMagnitudeArrayPresent());
        assertEquals(6, result1.getInstantaneousForceMagnitudeArray().length);
        assertEquals(0x0807, result1.getInstantaneousForceMagnitude(0));
        assertEquals(0x0a09, result1.getInstantaneousForceMagnitude(1));
        assertEquals(0x0c0b, result1.getInstantaneousForceMagnitude(2));
        assertEquals(0x0e0d, result1.getInstantaneousForceMagnitude(3));
        assertEquals(0x100f, result1.getInstantaneousForceMagnitude(4));
        assertEquals(0x1211, result1.getInstantaneousForceMagnitude(5));
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsInstantaneousTorqueMagnitudeArrayNotPresent());
        assertFalse(result1.isFlagsInstantaneousTorqueMagnitudeArrayPresent());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousTorqueMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousTorqueMagnitudeArrayPresent());
        assertEquals(9, result1.getInstantaneousTorqueMagnitudeArray().length);
        assertEquals(0x0201, result1.getInstantaneousTorqueMagnitude(0));
        assertEquals(0x0403, result1.getInstantaneousTorqueMagnitude(1));
        assertEquals(0x0605, result1.getInstantaneousTorqueMagnitude(2));
        assertEquals(0x0807, result1.getInstantaneousTorqueMagnitude(3));
        assertEquals(0x0a09, result1.getInstantaneousTorqueMagnitude(4));
        assertEquals(0x0c0b, result1.getInstantaneousTorqueMagnitude(5));
        assertEquals(0x0e0d, result1.getInstantaneousTorqueMagnitude(6));
        assertEquals(0x100f, result1.getInstantaneousTorqueMagnitude(7));
        assertEquals(0x1211, result1.getInstantaneousTorqueMagnitude(8));
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0201, result1.getInstantaneousTorqueMagnitudeNewtonMeter(0), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0403, result1.getInstantaneousTorqueMagnitudeNewtonMeter(1), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0605, result1.getInstantaneousTorqueMagnitudeNewtonMeter(2), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0807, result1.getInstantaneousTorqueMagnitudeNewtonMeter(3), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0a09, result1.getInstantaneousTorqueMagnitudeNewtonMeter(4), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0c0b, result1.getInstantaneousTorqueMagnitudeNewtonMeter(5), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0e0d, result1.getInstantaneousTorqueMagnitudeNewtonMeter(6), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x100f, result1.getInstantaneousTorqueMagnitudeNewtonMeter(7), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x1211, result1.getInstantaneousTorqueMagnitudeNewtonMeter(8), 0);
    }

    @Test
    public void test_constructor_00303() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousTorqueMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousTorqueMagnitudeArrayPresent());
        assertEquals(7, result1.getInstantaneousTorqueMagnitudeArray().length);
        assertEquals(0x0605, result1.getInstantaneousTorqueMagnitude(0));
        assertEquals(0x0807, result1.getInstantaneousTorqueMagnitude(1));
        assertEquals(0x0a09, result1.getInstantaneousTorqueMagnitude(2));
        assertEquals(0x0c0b, result1.getInstantaneousTorqueMagnitude(3));
        assertEquals(0x0e0d, result1.getInstantaneousTorqueMagnitude(4));
        assertEquals(0x100f, result1.getInstantaneousTorqueMagnitude(5));
        assertEquals(0x1211, result1.getInstantaneousTorqueMagnitude(6));
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0605, result1.getInstantaneousTorqueMagnitudeNewtonMeter(0), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0807, result1.getInstantaneousTorqueMagnitudeNewtonMeter(1), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0a09, result1.getInstantaneousTorqueMagnitudeNewtonMeter(2), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0c0b, result1.getInstantaneousTorqueMagnitudeNewtonMeter(3), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0e0d, result1.getInstantaneousTorqueMagnitudeNewtonMeter(4), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x100f, result1.getInstantaneousTorqueMagnitudeNewtonMeter(5), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x1211, result1.getInstantaneousTorqueMagnitudeNewtonMeter(6), 0);
    }

    @Test
    public void test_constructor_00304() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousTorqueMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousTorqueMagnitudeArrayPresent());
        assertEquals(8, result1.getInstantaneousTorqueMagnitudeArray().length);
        assertEquals(0x0403, result1.getInstantaneousTorqueMagnitude(0));
        assertEquals(0x0605, result1.getInstantaneousTorqueMagnitude(1));
        assertEquals(0x0807, result1.getInstantaneousTorqueMagnitude(2));
        assertEquals(0x0a09, result1.getInstantaneousTorqueMagnitude(3));
        assertEquals(0x0c0b, result1.getInstantaneousTorqueMagnitude(4));
        assertEquals(0x0e0d, result1.getInstantaneousTorqueMagnitude(5));
        assertEquals(0x100f, result1.getInstantaneousTorqueMagnitude(6));
        assertEquals(0x1211, result1.getInstantaneousTorqueMagnitude(7));
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0403, result1.getInstantaneousTorqueMagnitudeNewtonMeter(0), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0605, result1.getInstantaneousTorqueMagnitudeNewtonMeter(1), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0807, result1.getInstantaneousTorqueMagnitudeNewtonMeter(2), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0a09, result1.getInstantaneousTorqueMagnitudeNewtonMeter(3), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0c0b, result1.getInstantaneousTorqueMagnitudeNewtonMeter(4), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0e0d, result1.getInstantaneousTorqueMagnitudeNewtonMeter(5), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x100f, result1.getInstantaneousTorqueMagnitudeNewtonMeter(6), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x1211, result1.getInstantaneousTorqueMagnitudeNewtonMeter(7), 0);
    }

    @Test
    public void test_constructor_00305() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousTorqueMagnitudeArrayNotPresent());
        assertTrue(result1.isFlagsInstantaneousTorqueMagnitudeArrayPresent());
        assertEquals(6, result1.getInstantaneousTorqueMagnitudeArray().length);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0807, result1.getInstantaneousTorqueMagnitudeNewtonMeter(0), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0a09, result1.getInstantaneousTorqueMagnitudeNewtonMeter(1), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0c0b, result1.getInstantaneousTorqueMagnitudeNewtonMeter(2), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x0e0d, result1.getInstantaneousTorqueMagnitudeNewtonMeter(3), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x100f, result1.getInstantaneousTorqueMagnitudeNewtonMeter(4), 0);
        assertEquals(CyclingPowerVector.INSTANTANEOUS_TORQUE_MAGNITUDE_ARRAY_RESOLUTION * 0x1211, result1.getInstantaneousTorqueMagnitudeNewtonMeter(5), 0);
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertTrue(result1.isFlagsInstantaneousMeasurementDirectionUnknown());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionTangentialComponent());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionRadialComponent());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionLateralComponent());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionUnknown());
        assertTrue(result1.isFlagsInstantaneousMeasurementDirectionTangentialComponent());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionRadialComponent());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionLateralComponent());
    }

    @Test
    public void test_constructor_00403() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionUnknown());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionTangentialComponent());
        assertTrue(result1.isFlagsInstantaneousMeasurementDirectionRadialComponent());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionLateralComponent());
    }

    @Test
    public void test_constructor_00404() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertEquals(data[0], result1.getFlags());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionUnknown());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionTangentialComponent());
        assertFalse(result1.isFlagsInstantaneousMeasurementDirectionRadialComponent());
        assertTrue(result1.isFlagsInstantaneousMeasurementDirectionLateralComponent());
    }

    @Test
    public void test_constructor_00405() {
        int flags = 1;
        int crankRevolutionDataCumulativeCrankRevolutions = 2;
        int crankRevolutionDataLastCrankEventTime = 3;
        int firstCrankMeasurementAngle = 4;
        int[] instantaneousForceMagnitudeArray = new int[]{5};
        int[] instantaneousTorqueMagnitudeArray = new int[]{6};

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(flags, crankRevolutionDataCumulativeCrankRevolutions, crankRevolutionDataLastCrankEventTime, firstCrankMeasurementAngle, instantaneousForceMagnitudeArray, instantaneousTorqueMagnitudeArray);
        assertEquals(flags, result1.getFlags());
        assertEquals(crankRevolutionDataCumulativeCrankRevolutions, result1.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(crankRevolutionDataLastCrankEventTime, result1.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(firstCrankMeasurementAngle, result1.getFirstCrankMeasurementAngle());
        assertArrayEquals(instantaneousForceMagnitudeArray, result1.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(instantaneousTorqueMagnitudeArray, result1.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00202() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00203() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00204() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00205() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00302() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00303() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00304() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00305() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00402() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00403() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_1_00404() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getCrankRevolutionDataCumulativeCrankRevolutions(), result2.getCrankRevolutionDataCumulativeCrankRevolutions());
        assertEquals(result1.getCrankRevolutionDataLastCrankEventTime(), result2.getCrankRevolutionDataLastCrankEventTime());
        assertEquals(result1.getFirstCrankMeasurementAngle(), result2.getFirstCrankMeasurementAngle());
        assertArrayEquals(result1.getInstantaneousForceMagnitudeArray(), result2.getInstantaneousForceMagnitudeArray());
        assertArrayEquals(result1.getInstantaneousTorqueMagnitudeArray(), result2.getInstantaneousTorqueMagnitudeArray());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00202() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00203() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00204() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00205() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00302() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00303() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00304() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00305() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00402() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00403() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00404() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00202() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00203() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00204() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00205() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00302() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00303() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00304() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00305() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00402() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00403() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00404() {
        byte[] data = getData();

        CyclingPowerVectorAndroid result1 = new CyclingPowerVectorAndroid(data);
        CyclingPowerVectorAndroid result2 = CyclingPowerVectorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
