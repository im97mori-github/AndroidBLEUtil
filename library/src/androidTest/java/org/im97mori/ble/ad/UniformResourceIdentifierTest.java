package org.im97mori.ble.ad;

import android.os.Parcel;

import org.junit.Test;

import java.net.URI;
import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.BLEConstants.URI_SCHEME_NAME_STRING_MAPPING;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
import static org.junit.Assert.assertEquals;

public class UniformResourceIdentifierTest {

    @Test
    public void constructTest1() {
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

        UniformRsourceIdentifier result = new UniformRsourceIdentifier(data, 0, data[0]);
        assertEquals(utf8data.length + 1, result.getLength());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result.getDataType());
        assertEquals(uriString, result.getUriString());
        assertEquals(uri, result.getUri());
    }

    @Test
    public void constructTest2() {
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

        UniformRsourceIdentifier result = new UniformRsourceIdentifier(data, 0, data[0]);
        assertEquals(utf8data.length + 1, result.getLength());
        assertEquals(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER, result.getDataType());
        assertEquals(uriString, result.getUriString());
        assertEquals(uri, result.getUri());
    }

    @Test
    public void constructTest3() {
        // example scheme
        int schemeKey = 0x0000B9;
        String body = "//im97mori.org/";

        String uriString = String.valueOf(Character.toChars(schemeKey)) + body;
        byte[] utf8data = uriString.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        UniformRsourceIdentifier result1 = new UniformRsourceIdentifier(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UniformRsourceIdentifier result2 = UniformRsourceIdentifier.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getUriString(), result2.getUriString());
        assertEquals(result1.getUri(), result2.getUri());
    }
}
