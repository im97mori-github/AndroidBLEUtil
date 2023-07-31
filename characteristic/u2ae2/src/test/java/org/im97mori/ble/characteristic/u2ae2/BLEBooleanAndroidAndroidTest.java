package org.im97mori.ble.characteristic.u2ae2;

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

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class BLEBooleanAndroidAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        //noinspection DataFlowIssue
        data[ 0] = (byte) BLEBoolean.BOOLEAN_FALSE;
        //@formatter:on

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(data);
        assertEquals(BLEBoolean.BOOLEAN_FALSE, result1.getBoolean());
        assertTrue(result1.isBooleanFalse());
        assertFalse(result1.isBooleanTrue());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) BLEBoolean.BOOLEAN_TRUE;
        //@formatter:on

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(data);
        assertEquals(BLEBoolean.BOOLEAN_TRUE, result1.getBoolean());
        assertFalse(result1.isBooleanFalse());
        assertTrue(result1.isBooleanTrue());
    }

    @Test
    public void test_constructor_00101() {
        int booleanValue = 1;

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(booleanValue);
        assertEquals(booleanValue, result1.getBoolean());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BLEBooleanAndroid result2 = BLEBooleanAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getBoolean(), result1.getBoolean());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        //@formatter:on

        BLEBooleanAndroid result1 = new BLEBooleanAndroid(data);
        BLEBooleanAndroid result2 = BLEBooleanAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
