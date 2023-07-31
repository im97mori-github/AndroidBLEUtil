package org.im97mori.ble.characteristic.u2ab7;

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
public class HTTPHeadersAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = 'a';
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[2];
        data[ 0] = 'a';
        data[ 1] = 'b';
        data_00002 = data;
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

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        assertEquals("a", result1.getHttpHeaders());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        assertEquals("ab", result1.getHttpHeaders());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPHeadersAndroid result2 = HTTPHeadersAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHttpHeaders(), result2.getHttpHeaders());
    }

    @Test
    public void test_constructor_00003() {
        String httpHeaders = "1";

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(httpHeaders);
        assertEquals(httpHeaders, result1.getHttpHeaders());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        HTTPHeadersAndroid result2 = HTTPHeadersAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getHttpHeaders(), result2.getHttpHeaders());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        HTTPHeadersAndroid result2 = HTTPHeadersAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        HTTPHeadersAndroid result1 = new HTTPHeadersAndroid(data);
        HTTPHeadersAndroid result2 = HTTPHeadersAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
