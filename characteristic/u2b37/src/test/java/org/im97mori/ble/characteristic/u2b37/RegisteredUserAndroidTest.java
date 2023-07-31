package org.im97mori.ble.characteristic.u2b37;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.core.UserIndexUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings({"unused"})
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class RegisteredUserAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] additionalData = new byte[3];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        additionalData[2] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] additionalData = new byte[4];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;
        additionalData[2] = 'a';
        additionalData[3] = 'b';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        data_00002 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x01 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 'a';
        additionalData[1] = 'b';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x01 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] additionalData = new byte[3];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        additionalData[2] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00201 = data;
    }

    private static final byte[] data_00202;
    static {
        byte[] additionalData = new byte[4];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;
        additionalData[2] = 'a';
        additionalData[3] = 'b';

        byte[] data = new byte[1 + additionalData.length];
        data[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00202 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] additionalData = new byte[1];
        additionalData[0] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x01 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00301 = data;
    }

    private static final byte[] data_00302;
    static {
        byte[] additionalData = new byte[2];
        additionalData[0] = 'a';
        additionalData[1] = 'b';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x01 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00302 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] additionalData = new byte[3];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        additionalData[2] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        data_00401 = data;
    }

    private static final byte[] data_00402;
    static {
        byte[] additionalData = new byte[3];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_FALSE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        additionalData[2] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        data_00402 = data;
    }

    private static final byte[] data_00403;
    static {
        byte[] additionalData = new byte[3];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE;
        additionalData[1] = 0x01;
        additionalData[2] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        data_00403 = data;
    }

    private static final byte[] data_00404;
    static {
        byte[] additionalData = new byte[3];
        //noinspection DataFlowIssue
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_FALSE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE;
        additionalData[1] = 0x01;
        additionalData[2] = 'a';

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        data_00404 = data;
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

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertFalse(result1.isFlagsRegisteredUserNameNotPresent());
        assertTrue(result1.isFlagsRegisteredUserNamePresent());
        assertFalse(result1.isFlagsUserNameNotTruncated());
        assertTrue(result1.isFlagsUserNameTruncated());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertFalse(result1.isFlagsRegisteredUserNameNotPresent());
        assertTrue(result1.isFlagsRegisteredUserNamePresent());
        assertFalse(result1.isFlagsUserNameNotTruncated());
        assertTrue(result1.isFlagsUserNameTruncated());
        assertEquals(UserIndexUtils.USER_ID_UNKNOWN_USER, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x01, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x01, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertFalse(result1.isFlagsRegisteredUserNameNotPresent());
        assertTrue(result1.isFlagsRegisteredUserNamePresent());
        assertFalse(result1.isFlagsUserNameNotTruncated());
        assertTrue(result1.isFlagsUserNameTruncated());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00202() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertFalse(result1.isFlagsRegisteredUserNameNotPresent());
        assertTrue(result1.isFlagsRegisteredUserNamePresent());
        assertFalse(result1.isFlagsUserNameNotTruncated());
        assertTrue(result1.isFlagsUserNameTruncated());
        assertEquals(UserIndexUtils.USER_ID_UNKNOWN_USER, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x01, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00302() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x01, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(Arrays.copyOfRange(data, 1, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertFalse(result1.isFlagsRegisteredUserNameNotPresent());
        assertTrue(result1.isFlagsRegisteredUserNamePresent());
        assertFalse(result1.isFlagsUserNameNotTruncated());
        assertTrue(result1.isFlagsUserNameTruncated());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00402() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertTrue(result1.isFlagsRegisteredUserNameNotPresent());
        assertFalse(result1.isFlagsRegisteredUserNamePresent());
        assertFalse(result1.isFlagsUserNameNotTruncated());
        assertTrue(result1.isFlagsUserNameTruncated());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00403() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertFalse(result1.isFlagsRegisteredUserNameNotPresent());
        assertTrue(result1.isFlagsRegisteredUserNamePresent());
        assertTrue(result1.isFlagsUserNameNotTruncated());
        assertFalse(result1.isFlagsUserNameTruncated());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor_00404() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertEquals(data[0], result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0x02, result1.getSegmentationHeaderRollingSegmentNumber());
        assertTrue(result1.isFlagsRegisteredUserNameNotPresent());
        assertFalse(result1.isFlagsRegisteredUserNamePresent());
        assertTrue(result1.isFlagsUserNameNotTruncated());
        assertFalse(result1.isFlagsUserNameTruncated());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(Arrays.copyOfRange(data, 3, data.length), result1.getRegisteredUserData());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RegisteredUserAndroid result2 = RegisteredUserAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getSegmentationHeader(), result2.getSegmentationHeader());
        assertEquals(result1.getSegmentationHeaderRollingSegmentNumber(), result2.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result1.getFlags(), result2.getFlags());
        assertEquals(result1.getRegisteredUserIndex(), result2.getRegisteredUserIndex());
        assertArrayEquals(result1.getRegisteredUserData(), result2.getRegisteredUserData());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        RegisteredUserAndroid result1 = new RegisteredUserAndroid(data);
        RegisteredUserAndroid result2 = RegisteredUserAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
