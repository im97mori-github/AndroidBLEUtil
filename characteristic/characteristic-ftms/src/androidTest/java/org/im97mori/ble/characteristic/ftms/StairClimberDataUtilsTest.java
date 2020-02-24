package org.im97mori.ble.characteristic.ftms;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class StairClimberDataUtilsTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_FALSE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00402 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[7];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data_00502 = data;
    }

    private static final byte[] data_00503;
    static {
        byte[] data = new byte[7];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) StairClimberDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE;
        data[ 3] = (byte) (StairClimberDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE >> 8);
        data[ 4] = (byte) StairClimberDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (StairClimberDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) StairClimberDataUtils.ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE;
        data_00503 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[3];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[3];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00802 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[2];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00901 = data;
    }

    private static final byte[] data_00902;
    static {
        byte[] data = new byte[4];
        int flags = StairClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00902 = data;
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
    public void test_00001() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsMoreDataFalse(data));
        assertFalse(StairClimberDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00002() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsMoreDataFalse(data));
        assertTrue(StairClimberDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00101() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsStepPerMinuteNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsStepPerMinutePresent(data));
    }

    @Test
    public void test_00102() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsStepPerMinuteNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsStepPerMinutePresent(data));
    }

    @Test
    public void test_00201() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsAverageStepRateNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsAverageStepRatePresent(data));
    }

    @Test
    public void test_00202() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsAverageStepRateNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsAverageStepRatePresent(data));
    }

    @Test
    public void test_00301() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsPositiveElevationGainNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsPositiveElevationGainPresent(data));
    }

    @Test
    public void test_00302() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsPositiveElevationGainNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsPositiveElevationGainPresent(data));
    }

    @Test
    public void test_00401() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsStrideCountNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsStrideCountPresent(data));
    }

    @Test
    public void test_00402() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsStrideCountNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsStrideCountPresent(data));
    }

    @Test
    public void test_00501() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsExpendedEnergyPresent(data));
    }

    @Test
    public void test_00502() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsExpendedEnergyPresent(data));
        assertFalse(StairClimberDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertFalse(StairClimberDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertFalse(StairClimberDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 6)));
    }

    @Test
    public void test_00503() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsExpendedEnergyPresent(data));
        assertTrue(StairClimberDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertTrue(StairClimberDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertTrue(StairClimberDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 6)));
    }

    @Test
    public void test_00601() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsHeartRateNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00602() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsHeartRateNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00701() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_00702() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsMetabolicEquivalentPresent(data));
        assertEquals(StairClimberDataUtils.METABOLIC_EQUIVALENT_RESOLUTION * BLEUtils.createUInt8(data, 2)
                , StairClimberDataUtils.getMetabolicEquivalentWithUnit(BLEUtils.createUInt8(data, 2)), 0);
    }

    @Test
    public void test_00801() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_00802() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_00901() {
        byte[] data = getData();

        assertTrue(StairClimberDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertFalse(StairClimberDataUtils.isFlagsRemainingTimePresent(data));
    }

    @Test
    public void test_00902() {
        byte[] data = getData();

        assertFalse(StairClimberDataUtils.isFlagsRemainingTimeNotPresent(data));
        assertTrue(StairClimberDataUtils.isFlagsRemainingTimePresent(data));
    }

}
