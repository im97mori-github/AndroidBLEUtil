package org.im97mori.ble.characteristic.u2a07;

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
public class TxPowerLevelAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = (byte) 0x9c;
        //@formatter:on

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data);
        assertEquals(0xffffff9c, result1.getTxPower());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x14;
        //@formatter:on

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data);
        assertEquals(0x14, result1.getTxPower());
    }

    @Test
    public void test_constructor003() {
        int txPower = 1;

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(txPower);
        assertEquals(txPower, result1.getTxPower());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x14;
        //@formatter:on

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TxPowerLevelAndroid result2 = TxPowerLevelAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getTxPower(), result1.getTxPower());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x64;
        //@formatter:on

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = 0x64;
        //@formatter:on

        TxPowerLevelAndroid result1 = new TxPowerLevelAndroid(data);
        TxPowerLevelAndroid result2 = TxPowerLevelAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
