package org.im97mori.ble.advertising;

import static org.im97mori.ble.constants.DataType.URI_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.constants.Scheme;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.net.URI;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
@SuppressWarnings("unused")
public class UniformResourceIdentifierAndroidTest extends TestBase {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        // http scheme
        byte[] schemeData = Scheme.HTTP_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemeData.length];
        data[0] = (byte) (utf8data.length + schemeData.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemeData, 0, data, 2, schemeData.length);
        System.arraycopy(utf8data, 0, data, 2 + schemeData.length, utf8data.length);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        // example scheme
        byte[] schemeData = Scheme.EXAMPLE_SCHEME.toString().getBytes();
        String body = "//im97mori.org/";

        byte[] utf8data = body.getBytes();
        byte[] data = new byte[utf8data.length + 2 + schemeData.length];
        data[0] = (byte) (utf8data.length + schemeData.length + 1);
        data[1] = URI_DATA_TYPE;
        System.arraycopy(schemeData, 0, data, 2, schemeData.length);
        System.arraycopy(utf8data, 0, data, 2 + schemeData.length, utf8data.length);
        data_00002 = data;
    }
    //@formatter:on

    @Test
    public void test_constructor_1_00001() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.HTTP_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 3, data.length - 3), result1.getUriString());
        assertEquals(URI.create("http://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_1_00002() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0, data[0]);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.EXAMPLE_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 4, data.length - 4), result1.getUriString());
        assertEquals(URI.create("example://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_2_00001() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.HTTP_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 3, data.length - 3), result1.getUriString());
        assertEquals(URI.create("http://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_2_00002() {
        byte[] data = getData();

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(data, 0);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.EXAMPLE_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 4, data.length - 4), result1.getUriString());
        assertEquals(URI.create("example://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_3_00001() {
        byte[] data = getData();

        String allString = new String(data, 2, data[0] - 1);

        char scheme = allString.charAt(0);
        String uriString = allString.substring(1);

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(scheme, uriString);
        assertEquals(data[0], result1.getLength());
        assertEquals(URI_DATA_TYPE, result1.getDataType());
        assertEquals(Scheme.HTTP_SCHEME.charValue(), result1.getScheme());
        assertEquals(new String(data, 3, data.length - 3), result1.getUriString());
        assertEquals(URI.create("http://im97mori.org/"), result1.getUri());
    }

    @Test
    public void test_constructor_3_00002() {
        byte[] data = getData();

        String allString = new String(data, 2, data[0] - 1);

        char scheme = allString.charAt(0);
        String uriString = allString.substring(1);

        UniformResourceIdentifierAndroid result1 = new UniformResourceIdentifierAndroid(scheme, uriString);
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
