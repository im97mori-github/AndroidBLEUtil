package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.URI_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Parcel;

import org.im97mori.ble.constants.Scheme;
import org.junit.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("unused")
public class UniformResourceIdentifierTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        // http scheme
        byte[] schemedata = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        // example scheme
        byte[] schemedata = Scheme.EXAMPLE_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemedata.length];
        data[0] = (byte) (utf8data.length + schemedata.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemedata, 0, data, 2, schemedata.length);
        System.arraycopy(utf8data, 0, data, 2 + schemedata.length, utf8data.length);
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
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
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

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.HTTP_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 3, data.length - 3), result1.getUriString());
        assertEquals(URI.create("http://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.EXAMPLE_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 4, data.length - 4), result1.getUriString());
        assertEquals(URI.create("example://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UniformResourceIdentifierAndroid result2 = UniformResourceIdentifierAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUriString(), result2.getUriString());
        assertEquals(result1.getUri(), result2.getUri());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UniformResourceIdentifierAndroid result2 = UniformResourceIdentifierAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUriString(), result2.getUriString());
        assertEquals(result1.getUri(), result2.getUri());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        UniformResourceIdentifierAndroid result2 = UniformResourceIdentifierAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        UniformResourceIdentifierAndroid result2 = UniformResourceIdentifierAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
