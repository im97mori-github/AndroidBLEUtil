package org.im97mori.ble.ad;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SHORTENED_LOCAL_NAME;
import static org.junit.Assert.assertEquals;

public class ShortenedLocalNameTest {

    @Test
    public void constructTest1() {
        String name = "shortened local name";
        byte[] utf8data = name.getBytes(StandardCharsets.UTF_8);
        byte[] data = new byte[utf8data.length + 2];
        data[0] = (byte) (utf8data.length + 1);
        data[1] = DATA_TYPE_SHORTENED_LOCAL_NAME;
        System.arraycopy(utf8data, 0, data, 2, utf8data.length);

        ShortenedLocalName result = new ShortenedLocalName(data, 0, data[0]);
        assertEquals(utf8data.length + 1, result.getLength());
        assertEquals(DATA_TYPE_SHORTENED_LOCAL_NAME, result.getDataType());
        assertEquals(name, result.getShortenedLocalName());
    }
}
