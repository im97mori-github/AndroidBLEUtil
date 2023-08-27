package org.im97mori.ble.descriptor.u290f;

import static org.junit.Assert.assertArrayEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class CompleteBrEdrTransportBlockDataAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result = new CompleteBrEdrTransportBlockDataAndroid(value);
        assertArrayEquals(value, result.getTransportData());
    }

    @Test
    public void test_constructor_00002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result = new CompleteBrEdrTransportBlockDataAndroid(value);
        assertArrayEquals(value, result.getTransportData());
    }

    @Test
    public void test_parcelable_00001() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getTransportData(), result2.getTransportData());
    }

    @Test
    public void test_parcelable_00002() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(value);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromParcel(parcel);

        assertArrayEquals(result1.getTransportData(), result2.getTransportData());
    }

    @Test
    public void test_parcelable_00101() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00102() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(value);
        assertArrayEquals(value, result1.getBytes());
    }

    @Test
    public void test_parcelable_00201() {
        //@formatter:off
        byte[] value = new byte[0];
        //@formatter:on

        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(value);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_00202() {
        //@formatter:off
        byte[] value = new byte[1];
        value[ 0] = 0x01;
        //@formatter:on


        CompleteBrEdrTransportBlockDataAndroid result1 = new CompleteBrEdrTransportBlockDataAndroid(value);
        CompleteBrEdrTransportBlockDataAndroid result2 = CompleteBrEdrTransportBlockDataAndroid.CREATOR.createFromByteArray(value);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
