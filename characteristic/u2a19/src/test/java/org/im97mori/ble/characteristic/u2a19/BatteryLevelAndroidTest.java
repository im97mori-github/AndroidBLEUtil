package org.im97mori.ble.characteristic.u2a19;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BatteryLevelAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        //@formatter:on

        BatteryLevelAndroid result1 = new BatteryLevelAndroid(data);
        assertEquals(0x00, result1.getLevel());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x64;
        //@formatter:on

        BatteryLevelAndroid result1 = new BatteryLevelAndroid(data);
        assertEquals(0x64, result1.getLevel());
    }

    @Test
    public void test_constructor003() {
        int level = 1;

        BatteryLevelAndroid result1 = new BatteryLevelAndroid(level);
        assertEquals(level, result1.getLevel());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x64;
        //@formatter:on

        BatteryLevelAndroid result1 = new BatteryLevelAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BatteryLevelAndroid result2 = BatteryLevelAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLevel(), result1.getLevel());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x64;
        //@formatter:on

        BatteryLevelAndroid result1 = new BatteryLevelAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x64;
        //@formatter:on

        BatteryLevelAndroid result1 = new BatteryLevelAndroid(data);
        BatteryLevelAndroid result2 = BatteryLevelAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
