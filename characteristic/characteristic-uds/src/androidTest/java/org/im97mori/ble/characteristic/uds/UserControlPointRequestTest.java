package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserControlPointRequestTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getOpCode());
        assertEquals(0x3231, result1.getConsentCode());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_CONSENT;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        data[ 3] = 0x33;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getOpCode());
        assertEquals(0x31, result1.getUserIndex());
        assertEquals(0x3332, result1.getConsentCode());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_DELETE_USER_DATA, result1.getOpCode());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_LIST_ALL_USERS, result1.getOpCode());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_DELETE_USERS, result1.getOpCode());
        assertEquals(0x31, result1.getUserIndex());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_CONSENT;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        data[ 3] = 0x33;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_CONSENT;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        data[ 3] = 0x33;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_CONSENT;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        data[ 3] = 0x33;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointRequest result1 = new UserControlPointRequest(bluetoothGattCharacteristic);
        UserControlPointRequest result2 = UserControlPointRequest.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
