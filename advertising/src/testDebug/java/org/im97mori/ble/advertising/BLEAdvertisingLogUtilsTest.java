package org.im97mori.ble.advertising;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BLEAdvertisingLogUtilsTest {

    @Before
    public void setup() {
        ShadowLog.reset();
    }

    @Test
    public void verboseTest() {
        BLEAdvertisingLogUtils.verbose();
        BLEAdvertisingLogUtils.stackLog();
        assertFalse(ShadowLog.getLogs().isEmpty());
    }

    @Test
    public void muteTest() {
        BLEAdvertisingLogUtils.mute();
        BLEAdvertisingLogUtils.stackLog();
        assertFalse(ShadowLog.getLogs().isEmpty());
    }

    @Test
    public void stackLogTest001() {
        BLEAdvertisingLogUtils.stackLog();
        assertFalse(ShadowLog.getLogs().isEmpty());
    }

    @Test
    public void stackLogTest002() {
        BLEAdvertisingLogUtils.stackLog(new Exception());
        assertFalse(ShadowLog.getLogs().isEmpty());
    }
}