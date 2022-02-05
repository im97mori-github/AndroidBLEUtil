package org.im97mori.ble.characteristic.u2b48;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.u2b37.RegisteredUser;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class MiddleNameAndroidTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        byte[] middleName = "github@im97mori.org".getBytes();

        byte[] additionalData = new byte[2 + middleName.length];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        System.arraycopy(middleName, 0, additionalData, 2, middleName.length);

        byte[] data = new byte[1 + additionalData.length];
        data[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x02 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data)};

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        assertEquals(new String(middleName), result1.getMiddleName());
    }

    @Test
    public void test_constructor_00002() {
        byte[] middleName1 = "github@im97mori.org".getBytes();
        byte[] middleName2 = "github_@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + middleName1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(middleName1, 0, additionalData1, 2, middleName1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + middleName2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x02 << 2));
        System.arraycopy(middleName2, 0, data2, data2.length - middleName2.length, middleName2.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data1),
                new RegisteredUser(data2)};

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        assertEquals(new String(middleName1) + new String(middleName2), result1.getMiddleName());
    }

    @Test
    public void test_constructor_00003() {
        byte[] middleName1 = "github@im97mori.org".getBytes();
        byte[] middleName2 = "github_@im97mori.org".getBytes();
        byte[] middleName3 = "github__@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + middleName1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(middleName1, 0, additionalData1, 2, middleName1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + middleName2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x02 << 2));
        System.arraycopy(middleName2, 0, data2, data2.length - middleName2.length, middleName2.length);

        byte[] data3 = new byte[1 + middleName3.length];
        data3[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x03 << 2));
        System.arraycopy(middleName3, 0, data3, data3.length - middleName3.length, middleName3.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data1), new RegisteredUser(data2),
                new RegisteredUser(data3)};

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        assertEquals(new String(middleName1) + new String(middleName2) + new String(middleName3),
                result1.getMiddleName());
    }

    @Test
    public void test_constructor_00101() {
        String middleName = "a";

        MiddleNameAndroid result1 = new MiddleNameAndroid(middleName);
        assertEquals(middleName, result1.getMiddleName());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] emailAddress = "github@im97mori.org".getBytes();

        byte[] additionalData = new byte[2 + emailAddress.length];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        System.arraycopy(emailAddress, 0, additionalData, 2, emailAddress.length);

        byte[] data = new byte[1 + additionalData.length];
        data[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));
        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data)};

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MiddleNameAndroid result2 = MiddleNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMiddleName(), result2.getMiddleName());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] emailAddress1 = "github@im97mori.org".getBytes();
        byte[] emailAddress2 = "github_@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + emailAddress1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(emailAddress1, 0, additionalData1, 2, emailAddress1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + emailAddress2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));
        System.arraycopy(emailAddress2, 0, data2, data2.length - emailAddress2.length, emailAddress2.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{
                new RegisteredUser(data1), new RegisteredUser(data2)
        };

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MiddleNameAndroid result2 = MiddleNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMiddleName(), result2.getMiddleName());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] emailAddress1 = "github@im97mori.org".getBytes();
        byte[] emailAddress2 = "github_@im97mori.org".getBytes();
        byte[] emailAddress3 = "github__@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + emailAddress1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(emailAddress1, 0, additionalData1, 2, emailAddress1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + emailAddress2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x02 << 2));
        System.arraycopy(emailAddress2, 0, data2, data2.length - emailAddress2.length, emailAddress2.length);

        byte[] data3 = new byte[1 + emailAddress3.length];
        data3[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x03 << 2));
        System.arraycopy(emailAddress3, 0, data3, data3.length - emailAddress3.length, emailAddress3.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{
                new RegisteredUser(data1), new RegisteredUser(data2), new RegisteredUser(data3)
        };

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MiddleNameAndroid result2 = MiddleNameAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getMiddleName(), result2.getMiddleName());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] middleName = "github@im97mori.org".getBytes();

        byte[] additionalData = new byte[2 + middleName.length];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        System.arraycopy(middleName, 0, additionalData, 2, middleName.length);

        byte[] data = new byte[1 + additionalData.length];
        data[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x02 << 2));
        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data)};

        byte[] merged = new byte[3 + middleName.length];
        merged[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE);
        merged[1] = (byte) (RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE);
        merged[2] = (byte) 0;
        System.arraycopy(middleName, 0, merged, 3, middleName.length);

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        assertArrayEquals(merged, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] middleName1 = "github@im97mori.org".getBytes();
        byte[] middleName2 = "github_@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + middleName1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(middleName1, 0, additionalData1, 2, middleName1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + middleName2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x02 << 2));
        System.arraycopy(middleName2, 0, data2, data2.length - middleName2.length, middleName2.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data1),
                new RegisteredUser(data2)};

        byte[] merged = new byte[3 + middleName1.length + middleName2.length];
        merged[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE);
        merged[1] = (byte) (RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE);
        merged[2] = (byte) 0;
        System.arraycopy(middleName1, 0, merged, 3, middleName1.length);
        System.arraycopy(middleName2, 0, merged, 3 + middleName1.length, middleName2.length);

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        assertArrayEquals(merged, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] middleName1 = "github@im97mori.org".getBytes();
        byte[] middleName2 = "github_@im97mori.org".getBytes();
        byte[] middleName3 = "github__@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + middleName1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(middleName1, 0, additionalData1, 2, middleName1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + middleName2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE | (0x02 << 2));
        System.arraycopy(middleName2, 0, data2, data2.length - middleName2.length, middleName2.length);

        byte[] data3 = new byte[1 + middleName3.length];
        data3[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE | (0x03 << 2));
        System.arraycopy(middleName3, 0, data3, data3.length - middleName3.length, middleName3.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data1), new RegisteredUser(data2),
                new RegisteredUser(data3)};

        byte[] merged = new byte[3 + middleName1.length + middleName2.length + middleName3.length];
        merged[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE);
        merged[1] = (byte) (RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_FALSE);
        merged[2] = (byte) 0;
        System.arraycopy(middleName1, 0, merged, 3, middleName1.length);
        System.arraycopy(middleName2, 0, merged, 3 + middleName1.length, middleName2.length);
        System.arraycopy(middleName3, 0, merged, 3 + middleName1.length + middleName2.length, middleName3.length);

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        assertArrayEquals(merged, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] emailAddress = "github@im97mori.org".getBytes();

        byte[] additionalData = new byte[2 + emailAddress.length];
        additionalData[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData[1] = 0x01;
        System.arraycopy(emailAddress, 0, additionalData, 2, emailAddress.length);

        byte[] data = new byte[1 + additionalData.length];
        data[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));
        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{new RegisteredUser(data)};

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        MiddleNameAndroid result2 = MiddleNameAndroid.CREATOR.createFromMultiplePacketArray(registeredUsers);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] emailAddress1 = "github@im97mori.org".getBytes();
        byte[] emailAddress2 = "github_@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + emailAddress1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(emailAddress1, 0, additionalData1, 2, emailAddress1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + emailAddress2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x02 << 2));
        System.arraycopy(emailAddress2, 0, data2, data2.length - emailAddress2.length, emailAddress2.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{
                new RegisteredUser(data1), new RegisteredUser(data2)
        };

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        MiddleNameAndroid result2 = MiddleNameAndroid.CREATOR.createFromMultiplePacketArray(registeredUsers);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] emailAddress1 = "github@im97mori.org".getBytes();
        byte[] emailAddress2 = "github_@im97mori.org".getBytes();
        byte[] emailAddress3 = "github__@im97mori.org".getBytes();

        byte[] additionalData1 = new byte[2 + emailAddress1.length];
        additionalData1[0] = RegisteredUser.FLAGS_REGISTERED_USER_NAME_PRESENT_TRUE
                | RegisteredUser.FLAGS_USER_NAME_TRUNCATED_TRUE;
        additionalData1[1] = 0x01;
        System.arraycopy(emailAddress1, 0, additionalData1, 2, emailAddress1.length);

        byte[] data1 = new byte[1 + additionalData1.length];
        data1[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x01 << 2));
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + emailAddress2.length];
        data2[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0x02 << 2));
        System.arraycopy(emailAddress2, 0, data2, data2.length - emailAddress2.length, emailAddress2.length);

        byte[] data3 = new byte[1 + emailAddress3.length];
        data3[0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0x03 << 2));
        System.arraycopy(emailAddress3, 0, data3, data3.length - emailAddress3.length, emailAddress3.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{
                new RegisteredUser(data1), new RegisteredUser(data2), new RegisteredUser(data3)
        };

        MiddleNameAndroid result1 = new MiddleNameAndroid(registeredUsers);
        MiddleNameAndroid result2 = MiddleNameAndroid.CREATOR.createFromMultiplePacketArray(registeredUsers);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
