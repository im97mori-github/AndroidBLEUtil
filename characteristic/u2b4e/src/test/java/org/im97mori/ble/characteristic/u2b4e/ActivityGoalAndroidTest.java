package org.im97mori.ble.characteristic.u2b4e;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ActivityGoalAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        //noinspection DataFlowIssue
        data[ 0] = (byte) flags;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[4];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[4];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[4];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[4];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[4];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[4];
        int flags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_00008 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertEquals(data[0], result1.getPresenceFlags());

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * 0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertFalse(result1.isTotalEnergyExpenditureNotPresent());
        assertTrue(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(BLEUtils.createUInt16(data, 1), result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * BLEUtils.createUInt16(data, 1), result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertFalse(result1.isNormalWalkingStepsNotPresent());
        assertTrue(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(BLEUtils.createUInt24(data, 1), result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertFalse(result1.isIntensityStepsNotPresent());
        assertTrue(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(BLEUtils.createUInt24(data, 1), result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertFalse(result1.isFloorStepsNotPresent());
        assertTrue(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(BLEUtils.createUInt24(data, 1), result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertFalse(result1.isDistanceNotPresent());
        assertTrue(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(BLEUtils.createUInt24(data, 1), result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertFalse(result1.isDurationOfNormalWalkingNotPresent());
        assertTrue(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(BLEUtils.createUInt24(data, 1), result1.getDurationOfNormalWalking());
        assertEquals(0, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertFalse(result1.isDurationOfIntensityWalkingNotPresent());
        assertTrue(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(0, result1.getTotalEnergyExpenditure());
        assertEquals(0, result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(0, result1.getNormalWalkingSteps());
        assertEquals(0, result1.getIntensitySteps());
        assertEquals(0, result1.getFloorSteps());
        assertEquals(0, result1.getDistance());
        assertEquals(0, result1.getDurationOfNormalWalking());
        assertEquals(BLEUtils.createUInt24(data, 1), result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00101() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);
        assertEquals(presenceFlags, result1.getPresenceFlags());

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00102() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);
        assertFalse(result1.isTotalEnergyExpenditureNotPresent());
        assertTrue(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00103() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertFalse(result1.isNormalWalkingStepsNotPresent());
        assertTrue(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00104() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertFalse(result1.isIntensityStepsNotPresent());
        assertTrue(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00105() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertFalse(result1.isFloorStepsNotPresent());
        assertTrue(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00106() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertFalse(result1.isDistanceNotPresent());
        assertTrue(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00107() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_TRUE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_FALSE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertFalse(result1.isDurationOfNormalWalkingNotPresent());
        assertTrue(result1.isDurationOfNormalWalkingPresent());

        assertTrue(result1.isDurationOfIntensityWalkingNotPresent());
        assertFalse(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_constructor_00108() {
        int presenceFlags = ActivityGoal.PRESENCE_FLAGS_TOTAL_ENERGY_EXPENDITURE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_NORMAL_WALKING_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_INTENSITY_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_FLOOR_STEPS_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DISTANCE_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_NORMAL_WALKING_PRESENT_FALSE
                | ActivityGoal.PRESENCE_FLAGS_DURATION_OF_INTENSITY_WALKING_PRESENT_TRUE;
        int totalEnergyExpenditure = 1;
        int normalWalkingSteps = 2;
        int intensitySteps = 3;
        int floorSteps = 4;
        int distance = 5;
        int durationOfNormalWalking = 6;
        int durationOfIntensityWalking = 7;

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(presenceFlags, totalEnergyExpenditure, normalWalkingSteps,
                intensitySteps, floorSteps, distance, durationOfNormalWalking, durationOfIntensityWalking);

        assertTrue(result1.isTotalEnergyExpenditureNotPresent());
        assertFalse(result1.isTotalEnergyExpenditurePresent());

        assertTrue(result1.isNormalWalkingStepsNotPresent());
        assertFalse(result1.isNormalWalkingStepsPresent());

        assertTrue(result1.isIntensityStepsNotPresent());
        assertFalse(result1.isIntensityStepsPresent());

        assertTrue(result1.isFloorStepsNotPresent());
        assertFalse(result1.isFloorStepsPresent());

        assertTrue(result1.isDistanceNotPresent());
        assertFalse(result1.isDistancePresent());

        assertTrue(result1.isDurationOfNormalWalkingNotPresent());
        assertFalse(result1.isDurationOfNormalWalkingPresent());

        assertFalse(result1.isDurationOfIntensityWalkingNotPresent());
        assertTrue(result1.isDurationOfIntensityWalkingPresent());

        assertEquals(totalEnergyExpenditure, result1.getTotalEnergyExpenditure());
        assertEquals(ActivityGoal.TOTAL_ENERGY_EXPENDITURE_RESOLUTION * totalEnergyExpenditure,
                result1.getTotalEnergyExpenditureJoule(), 0);
        assertEquals(normalWalkingSteps, result1.getNormalWalkingSteps());
        assertEquals(intensitySteps, result1.getIntensitySteps());
        assertEquals(floorSteps, result1.getFloorSteps());
        assertEquals(distance, result1.getDistance());
        assertEquals(durationOfNormalWalking, result1.getDurationOfNormalWalking());
        assertEquals(durationOfIntensityWalking, result1.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getPresenceFlags(), result2.getPresenceFlags());
        assertEquals(result1.getNormalWalkingSteps(), result2.getNormalWalkingSteps());
        assertEquals(result1.getIntensitySteps(), result2.getIntensitySteps());
        assertEquals(result1.getFloorSteps(), result2.getFloorSteps());
        assertEquals(result1.getDistance(), result2.getDistance());
        assertEquals(result1.getDurationOfNormalWalking(), result2.getDurationOfNormalWalking());
        assertEquals(result1.getDurationOfIntensityWalking(), result2.getDurationOfIntensityWalking());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        ActivityGoalAndroid result1 = new ActivityGoalAndroid(data);
        ActivityGoalAndroid result2 = ActivityGoalAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
