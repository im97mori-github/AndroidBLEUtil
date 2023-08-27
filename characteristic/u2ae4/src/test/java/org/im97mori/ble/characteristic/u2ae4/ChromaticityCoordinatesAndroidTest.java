package org.im97mori.ble.characteristic.u2ae4;

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
public class ChromaticityCoordinatesAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ChromaticityCoordinatesAndroid result = new ChromaticityCoordinatesAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getChromaticityXCoordinate());
        assertEquals(BLEUtils.createUInt16(data, 2), result.getChromaticityYCoordinate());
    }

    @Test
    public void test_constructor_00101() {
        int chromaticityXCoordinate = 1;
        int chromaticityYCoordinate = 2;

        ChromaticityCoordinatesAndroid result = new ChromaticityCoordinatesAndroid(chromaticityXCoordinate, chromaticityYCoordinate);
        assertEquals(chromaticityXCoordinate, result.getChromaticityXCoordinate());
        assertEquals(chromaticityYCoordinate, result.getChromaticityYCoordinate());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ChromaticityCoordinatesAndroid result1 = new ChromaticityCoordinatesAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ChromaticityCoordinatesAndroid result2 = ChromaticityCoordinatesAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getChromaticityXCoordinate(), result1.getChromaticityXCoordinate());
        assertEquals(result2.getChromaticityYCoordinate(), result1.getChromaticityYCoordinate());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ChromaticityCoordinatesAndroid result1 = new ChromaticityCoordinatesAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        data[ 2] = 0x03;
        data[ 3] = 0x04;
        //@formatter:on

        ChromaticityCoordinatesAndroid result1 = new ChromaticityCoordinatesAndroid(data);
        ChromaticityCoordinatesAndroid result2 = ChromaticityCoordinatesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
