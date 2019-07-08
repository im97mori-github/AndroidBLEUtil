package org.im97mori.ble.ad;

import org.junit.Test;

import java.util.Map;

import static org.im97mori.ble.ad.AdvertisingDataConstants.APPEARANCE_DESCRIPTION_MAP;
import static org.im97mori.ble.ad.AdvertisingDataConstants.APPEARANCE_VALUE_MAP;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;
import static org.junit.Assert.assertEquals;

public class AppearanceTest {

    @Test
    public void constructTest1() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        Appearance result = new Appearance(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_APPEARANCE, result.getDataType());
        assertEquals(key, result.getAppearanceKey());
        assertEquals(entry.getValue(), result.getAppearanceValue());
        assertEquals(APPEARANCE_DESCRIPTION_MAP.get(key), result.getAppearanceDescription());
    }
}
