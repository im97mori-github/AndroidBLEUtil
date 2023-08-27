package org.im97mori.ble.descriptor.u290b;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class EnvironmentalSensingConfigurationAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(value);
        assertEquals(value[0], result.getTriggerLogicValue());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingConfigurationAndroid.TRIGGER_LOGIC_VALUE_BOOLAEN_AND;
        //@formatter:on

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(value);
        assertTrue(result.isTriggerLogicValueBooleanAnd());
        assertFalse(result.isTriggerLogicValueBooleanOr());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = (byte) EnvironmentalSensingConfigurationAndroid.TRIGGER_LOGIC_VALUE_BOOLAEN_OR;
        //@formatter:on

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(value);
        assertFalse(result.isTriggerLogicValueBooleanAnd());
        assertTrue(result.isTriggerLogicValueBooleanOr());
    }

    @Test
    public void test_constructor004() {
        int triggerLogicValue = 1;

        EnvironmentalSensingConfigurationAndroid result = new EnvironmentalSensingConfigurationAndroid(triggerLogicValue);
        assertEquals(triggerLogicValue, result.getTriggerLogicValue());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingConfigurationAndroid result1 = new EnvironmentalSensingConfigurationAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EnvironmentalSensingConfigurationAndroid result2 = EnvironmentalSensingConfigurationAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getTriggerLogicValue(), result2.getTriggerLogicValue());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingConfigurationAndroid result1 = new EnvironmentalSensingConfigurationAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        EnvironmentalSensingConfigurationAndroid result1 = new EnvironmentalSensingConfigurationAndroid(value);
        EnvironmentalSensingConfigurationAndroid result2 = EnvironmentalSensingConfigurationAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
