package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.URI_SCHEME_NAME_STRING_MAPPING;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class UniformResourceIdentifierTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        // http scheme
        int schemeKey = 0x000016;
        String body = "//im97mori.org/";
        URI uri = URI.create(URI_SCHEME_NAME_STRING_MAPPING.get(schemeKey) + body);

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        // example scheme
        int schemeKey = 0x0000B9;
        String body = "//im97mori.org/";
        URI uri = URI.create(URI_SCHEME_NAME_STRING_MAPPING.get(schemeKey) + body);

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);
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

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result1.getDataType());
        assertEquals(new String(data, 2, data.length - 2), result1.getUriString());
        assertEquals(URI.create("http://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result1.getDataType());
        assertEquals(new String(data, 2, data.length - 2), result1.getUriString());
        assertEquals(URI.create("example://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UniformRsourceIdentifierAndroid result2 = UniformRsourceIdentifierAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUriString(), result2.getUriString());
        assertEquals(result1.getUri(), result2.getUri());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UniformRsourceIdentifierAndroid result2 = UniformRsourceIdentifierAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUriString(), result2.getUriString());
        assertEquals(result1.getUri(), result2.getUri());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        UniformRsourceIdentifierAndroid result2 = UniformRsourceIdentifierAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        UniformRsourceIdentifierAndroid result1 = new UniformRsourceIdentifierAndroid(data, 0, data[0]);
        UniformRsourceIdentifierAndroid result2 = UniformRsourceIdentifierAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
