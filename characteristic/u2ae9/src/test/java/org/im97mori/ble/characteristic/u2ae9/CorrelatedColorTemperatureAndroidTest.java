package org.im97mori.ble.characteristic.u2ae9;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
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
public class CorrelatedColorTemperatureAndroidTest {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        CorrelatedColorTemperatureAndroid result = new CorrelatedColorTemperatureAndroid(data);
        assertEquals(BLEUtils.createUInt16(data, 0), result.getCorrelatedColorTemperature());
    }

    @Test
    public void test_constructor_00101() {
        int correlatedColorTemperature = 1;

        CorrelatedColorTemperatureAndroid result = new CorrelatedColorTemperatureAndroid(correlatedColorTemperature);
        assertEquals(correlatedColorTemperature, result.getCorrelatedColorTemperature());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        CorrelatedColorTemperatureAndroid result1 = new CorrelatedColorTemperatureAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CorrelatedColorTemperatureAndroid result2 = CorrelatedColorTemperatureAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getCorrelatedColorTemperature(), result1.getCorrelatedColorTemperature());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        CorrelatedColorTemperatureAndroid result1 = new CorrelatedColorTemperatureAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = 0x01;
        data[ 1] = 0x02;
        //@formatter:on

        CorrelatedColorTemperatureAndroid result1 = new CorrelatedColorTemperatureAndroid(data);
        CorrelatedColorTemperatureAndroid result2 = CorrelatedColorTemperatureAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
