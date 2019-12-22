package org.im97mori.ble.characteristic.uds;

import android.os.Parcel;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

import static org.junit.Assert.assertEquals;

public class LastNameTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        String lastName = "github@im97mori.org";
        byte[] additionalData = lastName.getBytes(StandardCharsets.UTF_8);

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{RegisteredUser.CREATOR.createFromByteArray(data)};
        //@formatter:on

        LastName result1 = new LastName(registeredUsers);
        assertEquals(lastName, result1.getLastName());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        String lastName1 = "github@im97mori.org";
        String lastName2 = "github_@im97mori.org";
        byte[] additionalData1 = lastName1.getBytes(StandardCharsets.UTF_8);
        byte[] additionalData2 = lastName2.getBytes(StandardCharsets.UTF_8);

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

        LastName result1 = new LastName(registeredUsers);
        assertEquals(lastName1 + lastName2, result1.getLastName());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        String lastName1 = "github@im97mori.org";
        String lastName2 = "github_@im97mori.org";
        String lastName3 = "github__@im97mori.org";
        byte[] additionalData1 = lastName1.getBytes(StandardCharsets.UTF_8);
        byte[] additionalData2 = lastName2.getBytes(StandardCharsets.UTF_8);
        byte[] additionalData3 = lastName3.getBytes(StandardCharsets.UTF_8);

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

        LastName result1 = new LastName(registeredUsers);
        assertEquals(lastName1 + lastName2 + lastName3, result1.getLastName());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        String lastName = "github@im97mori.org";
        byte[] additionalData = lastName.getBytes(StandardCharsets.UTF_8);

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{RegisteredUser.CREATOR.createFromByteArray(data)};
        //@formatter:on

        LastName result1 = new LastName(registeredUsers);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LastName result2 = LastName.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getLastName(), result1.getLastName());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        String lastName = "github@im97mori.org";
        byte[] additionalData = lastName.getBytes(StandardCharsets.UTF_8);

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);

        RegisteredUser[] registeredUsers = new RegisteredUser[]{RegisteredUser.CREATOR.createFromByteArray(data)};
        //@formatter:on

        LastName result1 = new LastName(registeredUsers);
        LastName result2 = LastName.CREATOR.createFromMultiplePacketArray(registeredUsers);
        assertEquals(result1.getLastName(), result2.getLastName());
    }

}
