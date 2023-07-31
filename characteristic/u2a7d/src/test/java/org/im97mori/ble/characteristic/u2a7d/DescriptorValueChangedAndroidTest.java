package org.im97mori.ble.characteristic.u2a7d;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.BLEUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.UUID;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused", "ConstantConditions"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class DescriptorValueChangedAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_CLIENT
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_00002 = data;
    }

    private static final byte[] data_10001;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_10001 = data;
    }

    private static final byte[] data_10002;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_TRUE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_10002 = data;
    }

    private static final byte[] data_20001;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_20001 = data;
    }

    private static final byte[] data_20002;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_TRUE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_20002 = data;
    }

    private static final byte[] data_30001;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_30001 = data;
    }

    private static final byte[] data_30002;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_TRUE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_30002 = data;
    }

    private static final byte[] data_40001;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_40001 = data;
    }

    private static final byte[] data_40002;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_TRUE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_40002 = data;
    }

    private static final byte[] data_50001;
    static {
        byte[] data = new byte[4];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data_50001 = data;
    }

    private static final byte[] data_50002;
    static {
        byte[] data = new byte[18];
        int flags = DescriptorValueChanged.FLAGS_SOURCE_OF_CHANGE_SERVER
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ONE_OR_MORE_ES_TRIGGER_SETTING_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_CONFIGURATION_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_ES_MEASUREMENT_DESCRIPTORS_FALSE
                | DescriptorValueChanged.FLAGS_CHANGE_TO_CHARACTERISTIC_USER_DESCRIPTION_DESCRIPTORS_FALSE;
        data[ 0] = (byte) flags;
        data[ 1] = (byte) (flags >> 8);
        data[ 2] = 0x01;
        data[ 3] = 0x02;
        data[ 4] = 0x03;
        data[ 5] = 0x04;
        data[ 6] = 0x05;
        data[ 7] = 0x06;
        data[ 8] = 0x07;
        data[ 9] = 0x08;
        data[10] = 0x09;
        data[11] = 0x0a;
        data[12] = 0x0b;
        data[13] = 0x0c;
        data[14] = 0x0d;
        data[15] = 0x0e;
        data[16] = 0x0f;
        data[17] = 0x10;
        data_50002 = data;
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

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertTrue(result1.isFlagsSourceOfChangeServer());
        assertFalse(result1.isFlagsSourceOfChangeClient());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertFalse(result1.isFlagsSourceOfChangeServer());
        assertTrue(result1.isFlagsSourceOfChangeClient());
    }

    @Test
    public void test_constructor_10001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertTrue(result1.isFlagsChangeToOneOrMoreEsTriggerSettingDescriptorsFalse());
        assertFalse(result1.isFlagsChangeToOneOrMoreEsTriggerSettingDescriptorsTrue());
    }

    @Test
    public void test_constructor_10002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertFalse(result1.isFlagsChangeToOneOrMoreEsTriggerSettingDescriptorsFalse());
        assertTrue(result1.isFlagsChangeToOneOrMoreEsTriggerSettingDescriptorsTrue());
    }

    @Test
    public void test_constructor_20001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertTrue(result1.isFlagsChangeToEsConfigurationDescriptorFalse());
        assertFalse(result1.isFlagsChangeToEsConfigurationDescriptorTrue());
    }

    @Test
    public void test_constructor_20002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertFalse(result1.isFlagsChangeToEsConfigurationDescriptorFalse());
        assertTrue(result1.isFlagsChangeToEsConfigurationDescriptorTrue());
    }

    @Test
    public void test_constructor_30001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertTrue(result1.isFlagsChangeToEsMeasurementDescriptorFalse());
        assertFalse(result1.isFlagsChangeToEsMeasurementDescriptorTrue());
    }

    @Test
    public void test_constructor_30002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertFalse(result1.isFlagsChangeToEsMeasurementDescriptorFalse());
        assertTrue(result1.isFlagsChangeToEsMeasurementDescriptorTrue());
    }

    @Test
    public void test_constructor_40001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertTrue(result1.isFlagsChangeToCharacteristicUserDescriptionDescriptorFalse());
        assertFalse(result1.isFlagsChangeToCharacteristicUserDescriptionDescriptorTrue());
    }

    @Test
    public void test_constructor_40002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertEquals(BLEUtils.createSInt16(data, 0), result1.getFlags());
        assertFalse(result1.isFlagsChangeToCharacteristicUserDescriptionDescriptorFalse());
        assertTrue(result1.isFlagsChangeToCharacteristicUserDescriptionDescriptorTrue());
    }

    @Test
    public void test_constructor_50001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 2, 4), result1.getCharacteristicUUID());

        long lsb = BASE_UUID.getLeastSignificantBits();
        long msb = BASE_UUID.getMostSignificantBits();
        long target = data[2] & 0xff;
        target |= (data[3] & 0xff) << 8;
        target = target << 32;
        UUID uuid = new UUID(msb | target, lsb);

        assertEquals(uuid, result1.createCharacteristicUUID());
    }

    @Test
    public void test_constructor_50002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(Arrays.copyOfRange(data, 2, 18), result1.getCharacteristicUUID());

        ByteBuffer bb = ByteBuffer.wrap(data, 2, 16).order(ByteOrder.LITTLE_ENDIAN);
        long lsb = bb.getLong();
        long msb = bb.getLong();
        UUID uuid = new UUID(msb, lsb);

        assertEquals(uuid, result1.createCharacteristicUUID());
    }

    @Test
    public void test_constructor_50003() {
        int flags = 1;
        byte[] characteristicUUID = new byte[] { 1 };

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(flags, characteristicUUID);
        assertEquals(flags, result1.getFlags());
        assertArrayEquals(characteristicUUID, result1.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_10001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_10002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_20001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_20002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_30001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_30002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_40001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_40002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_50001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_1_50002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getFlags(), result2.getFlags());
        assertArrayEquals(result1.getCharacteristicUUID(), result2.getCharacteristicUUID());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_10002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_20001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_20002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_30001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_30002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_40001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_40002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_50001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_50002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_10002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_20001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_20002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_30001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_30002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_40001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_40002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_50001() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_50002() {
        byte[] data = getData();

        DescriptorValueChangedAndroid result1 = new DescriptorValueChangedAndroid(data);
        DescriptorValueChangedAndroid result2 = DescriptorValueChangedAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
