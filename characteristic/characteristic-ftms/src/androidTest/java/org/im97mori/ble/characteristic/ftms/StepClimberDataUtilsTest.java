package org.im97mori.ble.characteristic.ftms;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
public class StepClimberDataUtilsTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_FALSE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[6];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] data = new byte[4];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] data = new byte[4];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] data = new byte[7];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data_00402 = data;
    }

    private static final byte[] data_00403;
    static {
        byte[] data = new byte[7];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = (byte) StepClimberDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE;
        data[ 3] = (byte) (StepClimberDataUtils.TOTAL_ENERGY_DATA_NOT_AVAILABLE >> 8);
        data[ 4] = (byte) StepClimberDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE;
        data[ 5] = (byte) (StepClimberDataUtils.ENERGY_PER_HOUR_DATA_NOT_AVAILABLE >> 8);
        data[ 6] = (byte) StepClimberDataUtils.ENERGY_PER_MINUTE_DATA_NOT_AVAILABLE;
        data_00403 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00501 = data;
    }

    private static final byte[] data_00502;
    static {
        byte[] data = new byte[3];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00502 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00601 = data;
    }

    private static final byte[] data_00602;
    static {
        byte[] data = new byte[3];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data_00602 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00701 = data;
    }

    private static final byte[] data_00702;
    static {
        byte[] data = new byte[4];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00702 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[2];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data_00801 = data;
    }

    private static final byte[] data_00802;
    static {
        byte[] data = new byte[4];
        int flags = StepClimberDataUtils.FLAGS_MORE_DATA_TRUE
                | StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_FALSE
                | StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00802 = data;
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

        assertTrue(StepClimberDataUtils.isFlagsMoreDataFalse(data));
        assertFalse(StepClimberDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00002() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsMoreDataFalse(data));
        assertTrue(StepClimberDataUtils.isFlagsMoreDataTrue(data));
    }

    @Test
    public void test_00101() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsStepPerMinuteNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsStepPerMinutePresent(data));
    }

    @Test
    public void test_00102() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsStepPerMinuteNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsStepPerMinutePresent(data));
    }

    @Test
    public void test_00201() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsAverageStepRateNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsAverageStepRatePresent(data));
    }

    @Test
    public void test_00202() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsAverageStepRateNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsAverageStepRatePresent(data));
    }

    @Test
    public void test_00301() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsPositiveElevationGainNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsPositiveElevationGainPresent(data));
    }

    @Test
    public void test_00302() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsPositiveElevationGainNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsPositiveElevationGainPresent(data));
    }

    @Test
    public void test_00401() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsExpendedEnergyPresent(data));
    }

    @Test
    public void test_00402() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsExpendedEnergyPresent(data));
        assertFalse(StepClimberDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertFalse(StepClimberDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertFalse(StepClimberDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 6)));
    }

    @Test
    public void test_00403() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsExpendedEnergyNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsExpendedEnergyPresent(data));
        assertTrue(StepClimberDataUtils.isTotalEnergyDataNotAvailable(BLEUtils.createUInt16(data, 2)));
        assertTrue(StepClimberDataUtils.isEnergyPerHourDataNotAvailable(BLEUtils.createUInt16(data, 4)));
        assertTrue(StepClimberDataUtils.isEnergyPerMinuteDataNotAvailable(BLEUtils.createUInt8(data, 6)));
    }

    @Test
    public void test_00501() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsHeartRateNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00502() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsHeartRateNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsHeartRatePresent(data));
    }

    @Test
    public void test_00601() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsMetabolicEquivalentPresent(data));
    }

    @Test
    public void test_00602() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsMetabolicEquivalentNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsMetabolicEquivalentPresent(data));
        assertEquals(StepClimberDataUtils.METABOLIC_EQUIVALENT_RESOLUTION * BLEUtils.createUInt8(data, 2)
                , StepClimberDataUtils.getMetabolicEquivalentWithUnit(BLEUtils.createUInt8(data, 2)), 0);
    }

    @Test
    public void test_00701() {
        byte[] data = getData();

        assertTrue(StepClimberDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertFalse(StepClimberDataUtils.isFlagsElapsedTimePresent(data));
    }

    @Test
    public void test_00702() {
        byte[] data = getData();

        assertFalse(StepClimberDataUtils.isFlagsElapsedTimeNotPresent(data));
        assertTrue(StepClimberDataUtils.isFlagsElapsedTimePresent(data));
    }

}
