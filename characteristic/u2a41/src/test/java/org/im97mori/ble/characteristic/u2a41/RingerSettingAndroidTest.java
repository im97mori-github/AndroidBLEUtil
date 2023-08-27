package org.im97mori.ble.characteristic.u2a41;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/** @noinspection DataFlowIssue*/
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class RingerSettingAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        RingerSettingAndroid result1 = new RingerSettingAndroid(data);
        assertEquals(RingerSetting.RINGER_SETTING_SILENT, result1.getRingerSetting());
        assertTrue(result1.isRingerSettingSilent());
        assertFalse(result1.isRingerSettingNormal());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_NORMAL;
        //@formatter:on

        RingerSettingAndroid result1 = new RingerSettingAndroid(data);
        assertEquals(RingerSetting.RINGER_SETTING_NORMAL, result1.getRingerSetting());
        assertFalse(result1.isRingerSettingSilent());
        assertTrue(result1.isRingerSettingNormal());
    }

    @Test
    public void test_constructor003() {
        int ringerSetting = 1;

        RingerSettingAndroid result1 = new RingerSettingAndroid(ringerSetting);
        assertEquals(ringerSetting, result1.getRingerSetting());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        RingerSettingAndroid result1 = new RingerSettingAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RingerSettingAndroid result2 = RingerSettingAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getRingerSetting(), result2.getRingerSetting());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        RingerSettingAndroid result1 = new RingerSettingAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = RingerSetting.RINGER_SETTING_SILENT;
        //@formatter:on

        RingerSettingAndroid result1 = new RingerSettingAndroid(data);
        RingerSettingAndroid result2 = RingerSettingAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
