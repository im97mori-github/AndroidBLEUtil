package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.im97mori.ble.characteristic.UserIndexUtils;
import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RegisteredUserTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] additionalData = new byte[1];
        additionalData[0] = 0x02;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0 << 2), result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (63 << 2));
        data[ 1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (63 << 2), result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(63, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(UserIndexUtils.USER_ID_UNKNOWN_USER, result1.getRegisteredUserIndex());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] additionalData = new byte[1];
        additionalData[0] = 0x02;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (0 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (0 << 2), result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(0, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                | (63 << 2), result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertFalse(result1.isSegmentationHeaderNotLastSegment());
        assertTrue(result1.isSegmentationHeaderLastSegment());
        assertEquals(63, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] additionalData = new byte[1];
        additionalData[0] = 0x02;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (0 << 2));
        data[ 1] = 0x01;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0 << 2), result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(0x01, result1.getRegisteredUserIndex());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                     | (63 << 2));
        data[ 1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (63 << 2), result1.getSegmentationHeader());
        assertFalse(result1.isSegmentationHeaderNotFirstSegment());
        assertTrue(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(63, result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(UserIndexUtils.USER_ID_UNKNOWN_USER, result1.getRegisteredUserIndex());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor401() {
        //@formatter:off
        byte[] additionalData = new byte[1];
        additionalData[0] = 0x02;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                    | (0 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (0 << 2), result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(0, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_constructor402() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertEquals(RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                | (63 << 2), result1.getSegmentationHeader());
        assertTrue(result1.isSegmentationHeaderNotFirstSegment());
        assertFalse(result1.isSegmentationHeaderFirstSegment());
        assertTrue(result1.isSegmentationHeaderNotLastSegment());
        assertFalse(result1.isSegmentationHeaderLastSegment());
        assertEquals(63, result1.getSegmentationHeaderRollingSegmentNumber());
        assertArrayEquals(additionalData, result1.getRegisteredUserData());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (63 << 2));
        data[ 1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getSegmentationHeader(), result1.getSegmentationHeader());
        assertEquals(result2.getSegmentationHeaderRollingSegmentNumber(), result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result2.getRegisteredUserIndex(), result1.getRegisteredUserIndex());
        assertArrayEquals(result2.getRegisteredUserData(), result1.getRegisteredUserData());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getSegmentationHeader(), result1.getSegmentationHeader());
        assertEquals(result2.getSegmentationHeaderRollingSegmentNumber(), result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result2.getRegisteredUserIndex(), result1.getRegisteredUserIndex());
        assertArrayEquals(result2.getRegisteredUserData(), result1.getRegisteredUserData());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                     | (63 << 2));
        data[ 1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getSegmentationHeader(), result1.getSegmentationHeader());
        assertEquals(result2.getSegmentationHeaderRollingSegmentNumber(), result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result2.getRegisteredUserIndex(), result1.getRegisteredUserIndex());
        assertArrayEquals(result2.getRegisteredUserData(), result1.getRegisteredUserData());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_FALSE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getSegmentationHeader(), result1.getSegmentationHeader());
        assertEquals(result2.getSegmentationHeaderRollingSegmentNumber(), result1.getSegmentationHeaderRollingSegmentNumber());
        assertEquals(result2.getRegisteredUserIndex(), result1.getRegisteredUserIndex());
        assertArrayEquals(result2.getRegisteredUserData(), result1.getRegisteredUserData());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (63 << 2));
        data[ 1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[2 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_TRUE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                    | (63 << 2));
        data[ 1] = (byte) UserIndexUtils.USER_ID_UNKNOWN_USER;

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] additionalData = new byte[2];
        additionalData[0] = 0x02;
        additionalData[1] = 0x03;

        byte[] data = new byte[1 + additionalData.length];
        data[ 0] = (byte) (RegisteredUser.SEGMENTATION_HEADER_FIRST_SEGMENT_FALSE
                    | RegisteredUser.SEGMENTATION_HEADER_LAST_SEGMENT_TRUE
                     | (63 << 2));

        System.arraycopy(additionalData, 0, data, data.length - additionalData.length, additionalData.length);
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        RegisteredUser result1 = new RegisteredUser(bluetoothGattCharacteristic);
        RegisteredUser result2 = RegisteredUser.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
