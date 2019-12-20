package org.im97mori.ble.characteristic.uds;

import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class EmailAddressTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        String emailAddress = "github@im97mori.org";
        byte[] additionalData = emailAddress.getBytes(StandardCharsets.UTF_8);

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{RegisteredUser.CREATOR.createFromByteArray(data)};
        //@formatter:on

        EmailAddress result1 = new EmailAddress(registeredUsers);
        assertEquals(emailAddress, result1.getEmailAddress());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        String emailAddress1 = "github@im97mori.org";
        String emailAddress2 = "github_@im97mori.org";
        byte[] additionalData1 = emailAddress1.getBytes(StandardCharsets.UTF_8);
        byte[] additionalData2 = emailAddress2.getBytes(StandardCharsets.UTF_8);

        byte[] data1 = new byte[2 + additionalData1.length];
        data1[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (0 << 2));
        data1[ 1] = 0x01;
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + additionalData2.length];
        data2[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (1 << 2));
        System.arraycopy(additionalData2, 0, data2, data2.length - additionalData2.length, additionalData2.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{
                RegisteredUser.CREATOR.createFromByteArray(data1)
                , RegisteredUser.CREATOR.createFromByteArray(data2)
        };
        //@formatter:on

        EmailAddress result1 = new EmailAddress(registeredUsers);
        assertEquals(emailAddress1 + emailAddress2, result1.getEmailAddress());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        String emailAddress1 = "github@im97mori.org";
        String emailAddress2 = "github_@im97mori.org";
        String emailAddress3 = "github__@im97mori.org";
        byte[] additionalData1 = emailAddress1.getBytes(StandardCharsets.UTF_8);
        byte[] additionalData2 = emailAddress2.getBytes(StandardCharsets.UTF_8);
        byte[] additionalData3 = emailAddress3.getBytes(StandardCharsets.UTF_8);

        byte[] data1 = new byte[2 + additionalData1.length];
        data1[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (0 << 2));
        data1[ 1] = 0x01;
        System.arraycopy(additionalData1, 0, data1, data1.length - additionalData1.length, additionalData1.length);

        byte[] data2 = new byte[1 + additionalData2.length];
        data2[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (1 << 2));
        System.arraycopy(additionalData2, 0, data2, data2.length - additionalData2.length, additionalData2.length);

        byte[] data3 = new byte[1 + additionalData3.length];
        data3[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (2 << 2));
        System.arraycopy(additionalData3, 0, data3, data3.length - additionalData3.length, additionalData3.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{
                RegisteredUser.CREATOR.createFromByteArray(data1)
                , RegisteredUser.CREATOR.createFromByteArray(data2)
                , RegisteredUser.CREATOR.createFromByteArray(data3)
        };
        //@formatter:on

        EmailAddress result1 = new EmailAddress(registeredUsers);
        assertEquals(emailAddress1 + emailAddress2 + emailAddress3, result1.getEmailAddress());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        String emailAddress = "github@im97mori.org";
        byte[] additionalData = emailAddress.getBytes(StandardCharsets.UTF_8);

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{RegisteredUser.CREATOR.createFromByteArray(data)};
        //@formatter:on

        EmailAddress result1 = new EmailAddress(registeredUsers);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        EmailAddress result2 = EmailAddress.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getEmailAddress(), result1.getEmailAddress());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        String emailAddress = "github@im97mori.org";
        byte[] additionalData = emailAddress.getBytes(StandardCharsets.UTF_8);

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{RegisteredUser.CREATOR.createFromByteArray(data)};
        //@formatter:on

        EmailAddress result1 = new EmailAddress(registeredUsers);
        EmailAddress result2 = EmailAddress.CREATOR.createFromRegisteredUsersArray(registeredUsers);
        assertEquals(result1.getEmailAddress(), result2.getEmailAddress());
    }

}
