package org.im97mori.ble.characteristic.u2b1c;

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
public class ChromaticityCoordinateAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticityCoordinateAndroid result = new ChromaticityCoordinateAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getChromaticityCoordinate());
    }

    @Test
    public void test_constructor_00101() {
        int chromaticityCoordinate = 1;

        ChromaticityCoordinateAndroid result = new ChromaticityCoordinateAndroid(chromaticityCoordinate);
        assertEquals(chromaticityCoordinate, result.getChromaticityCoordinate());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticityCoordinateAndroid result1 = new ChromaticityCoordinateAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityCoordinateAndroid result2 = ChromaticityCoordinateAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityCoordinate(), result1.getChromaticityCoordinate());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticityCoordinateAndroid result1 = new ChromaticityCoordinateAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        ChromaticityCoordinateAndroid result1 = new ChromaticityCoordinateAndroid(data);
        ChromaticityCoordinateAndroid result2 = ChromaticityCoordinateAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
