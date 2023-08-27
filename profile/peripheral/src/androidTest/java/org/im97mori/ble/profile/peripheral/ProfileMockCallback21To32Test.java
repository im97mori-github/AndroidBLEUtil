package org.im97mori.ble.profile.peripheral;

import android.content.Context;
import android.os.Build;

import androidx.test.filters.SdkSuppress;
import androidx.test.platform.app.InstrumentationRegistry;

import org.im97mori.ble.BLEUtilsAndroid;
import org.junit.BeforeClass;

@SdkSuppress(minSdkVersion = Build.VERSION_CODES.LOLLIPOP, maxSdkVersion = Build.VERSION_CODES.S_V2)
public class ProfileMockCallback21To32Test extends BaseAbstractProfileMockCallbackTest {

    @BeforeClass
    @SuppressWarnings("deprecation")
    public static void setUp() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext().getApplicationContext();
        BLEUtilsAndroid.bluetoothEnable(context);
    }

}
