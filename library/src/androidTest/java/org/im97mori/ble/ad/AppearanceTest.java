package org.im97mori.ble.ad;

import android.os.Parcel;

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

    @Test
    public void constructTest2() {
        Map.Entry<Integer, String> entry = APPEARANCE_VALUE_MAP.entrySet().iterator().next();
        int key = entry.getKey();
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) (key & 0x00ff);
        data[3] = (byte) ((key >> 8) & 0x00ff);

        Appearance result1 = new Appearance(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        Appearance result2 = Appearance.CREATOR.createFromParcel(parcel);

        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAppearanceKey(), result2.getAppearanceKey());
    }
}
