package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;

import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_APPEARANCE;
import static org.im97mori.ble.constants.AppearanceUUID.APPEARANCE_SUB_CATEGORY_MAPPING_128;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

@SuppressWarnings("unused")
public class AppearanceTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        Map.Entry<UUID, String> entry = APPEARANCE_SUB_CATEGORY_MAPPING_128.entrySet().iterator().next();
        int key = BLEUtils.convert128to16(entry.getKey());
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_APPEARANCE;
        data[2] = (byte) key;
        data[3] = (byte) (key >> 8);
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

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(DATA_TYPE_APPEARANCE, result1.getDataType());
        int key = (data[2] & 0xff) | ((data[3] & 0xff) << 8);
        assertEquals(key, result1.getAppearanceKey());
        assertEquals(APPEARANCE_SUB_CATEGORY_MAPPING_128.get(BLEUtils.convert16to128(key)), result1.getAppearanceSubCategory());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertEquals(result1.getAppearanceKey(), result2.getAppearanceKey());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        AppearanceAndroid result1 = new AppearanceAndroid(data, 0, data[0]);
        AppearanceAndroid result2 = AppearanceAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
