package org.im97mori.ble.characteristic.u2a74;

import android.os.Build;
import android.os.Parcel;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class GustFactorAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 0x01;
        data_00001 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] stringArray = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + stringArray[stringArray.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        GustFactorAndroid result1 = new GustFactorAndroid(data);
        assertEquals(0x01, result1.getGustFactor());
        assertEquals(GustFactor.GUST_FACTOR_RESOLUTION * 0x01, result1.getGustFactorWithUnit(), 0);
    }

    @Test
    public void test_constructor_00002() {
        int gustFactor = 1;

        GustFactorAndroid result1 = new GustFactorAndroid(gustFactor);
        assertEquals(gustFactor, result1.getGustFactor());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        GustFactorAndroid result1 = new GustFactorAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        GustFactorAndroid result2 = GustFactorAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getGustFactor(), result2.getGustFactor());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        GustFactorAndroid result1 = new GustFactorAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        GustFactorAndroid result1 = new GustFactorAndroid(data);
        GustFactorAndroid result2 = GustFactorAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
