package org.im97mori.ble.descriptor.u290d;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EnvironmentalSensingTriggerSettingAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertEquals(0x01, result.getConditions());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[1];
        //noinspection DataFlowIssue
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_INACTIVE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertTrue(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_USE_A_FIXED_TIME_INTERVAL_BETWEEN_TRANSMISSIONS;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertTrue(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_NO_LESS_THAN_THE_SPECIFIED_TIME_BETWEEN_TRANSMISSIONS;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertTrue(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHEN_VALUE_CHANGES_COMPARED_TO_PREVIOUS_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertTrue(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor006() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHILE_LESS_THAN_THE_SPECIFIED_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertTrue(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor007() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHILE_LESS_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertTrue(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor008() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHILE_GREATER_THAN_THE_SPECIFIED_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertTrue(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor009() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHILE_GREATER_THAN_OR_EQUAL_TO_THE_SPECIFIED_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertTrue(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor010() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHILE_EQUAL_TO_THE_SPECIFIED_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertTrue(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor011() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingTriggerSettingAndroid.CONDITIONS_TRIGGER_WHILE_NOT_EQUAL_TO_THE_SPECIFIED_VALUE;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertFalse(result.isConditionsTriggerInactive());
        assertFalse(result.isConditionsTriggerUsedAFixedTimeIntervalBetweenTransmissions());
        assertFalse(result.isConditionsTriggerNoLessThanTheSpecifiedTimeBetweenTransmissions());
        assertFalse(result.isConditionsTriggerWhenValueChangesComparedToPreviousValue());
        assertFalse(result.isConditionsTriggerWhileLessThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileLessThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileGreaterThanOrEqualToTheSpecifiedValue());
        assertFalse(result.isConditionsTriggerWhileEqualToTheSpecifiedValue());
        assertTrue(result.isConditionsTriggerWhileNotEqualToTheSpecifiedValue());
    }

    @Test
    public void test_constructor012() {
        int conditions = 1;

        EnvironmentalSensingTriggerSettingAndroid result = new EnvironmentalSensingTriggerSettingAndroid(conditions);
        assertEquals(conditions, result.getConditions());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result1 = new EnvironmentalSensingTriggerSettingAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnvironmentalSensingTriggerSettingAndroid result2 = EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getConditions(), result2.getConditions());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result1 = new EnvironmentalSensingTriggerSettingAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingTriggerSettingAndroid result1 = new EnvironmentalSensingTriggerSettingAndroid(value);
        EnvironmentalSensingTriggerSettingAndroid result2 = EnvironmentalSensingTriggerSettingAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
