package org.im97mori.ble.characteristic.u2a99;

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
public class DatabaseChangeIncrementAndroidTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        DatabaseChangeIncrementAndroid result1 = new DatabaseChangeIncrementAndroid(data);
        assertEquals(0x04030201, result1.getDatabaseChangeIncrement());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = (byte) 0xff;
        data[ 1] = (byte) 0xff;
        data[ 2] = (byte) 0xff;
        data[ 3] = (byte) 0xff;
        //@formatter:on

        DatabaseChangeIncrementAndroid result1 = new DatabaseChangeIncrementAndroid(data);
        assertEquals(0xffffffffL, result1.getDatabaseChangeIncrement());
    }

    @Test
    public void test_constructor003() {
        long databaseChangeIncrement = 1;

        DatabaseChangeIncrementAndroid result1 = new DatabaseChangeIncrementAndroid(databaseChangeIncrement);
        assertEquals(databaseChangeIncrement, result1.getDatabaseChangeIncrement());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        DatabaseChangeIncrementAndroid result1 = new DatabaseChangeIncrementAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DatabaseChangeIncrementAndroid result2 = DatabaseChangeIncrementAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDatabaseChangeIncrement(), result1.getDatabaseChangeIncrement());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        DatabaseChangeIncrementAndroid result1 = new DatabaseChangeIncrementAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        DatabaseChangeIncrementAndroid result1 = new DatabaseChangeIncrementAndroid(data);
        DatabaseChangeIncrementAndroid result2 = DatabaseChangeIncrementAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
