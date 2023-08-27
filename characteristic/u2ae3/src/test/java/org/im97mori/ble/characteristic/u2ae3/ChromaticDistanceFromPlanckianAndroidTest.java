package org.im97mori.ble.characteristic.u2ae3;

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

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class ChromaticDistanceFromPlanckianAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticDistanceFromPlanckianAndroid result = new ChromaticDistanceFromPlanckianAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result.getDistanceFromPlanckian());
    }

    @Test
    public void test_constructor_00101() {
        int distanceFromPlanckian = 1;

        ChromaticDistanceFromPlanckianAndroid result = new ChromaticDistanceFromPlanckianAndroid(distanceFromPlanckian);
        assertEquals(distanceFromPlanckian, result.getDistanceFromPlanckian());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticDistanceFromPlanckianAndroid result1 = new ChromaticDistanceFromPlanckianAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticDistanceFromPlanckianAndroid result2 = ChromaticDistanceFromPlanckianAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getDistanceFromPlanckian(), result1.getDistanceFromPlanckian());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticDistanceFromPlanckianAndroid result1 = new ChromaticDistanceFromPlanckianAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticDistanceFromPlanckianAndroid result1 = new ChromaticDistanceFromPlanckianAndroid(data);
        ChromaticDistanceFromPlanckianAndroid result2 = ChromaticDistanceFromPlanckianAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
