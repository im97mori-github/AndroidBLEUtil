package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.BLEConstants.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class UserControlPointResponseTest {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
        assertEquals(0x31, result1.getUserIndex());
    }

    @Test
    public void test_constructor002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
    }

    @Test
    public void test_constructor003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USER_DATA, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_LIST_ALL_USERS, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
        assertEquals(0x31, result1.getNumberOfUsers());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USERS, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
        assertEquals(0x31, result1.getUserIndex());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = 0x31;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(0x31, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, result1.getResponseValue());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER, result1.getResponseValue());
    }

    @Test
    public void test_constructor202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER, result1.getResponseValue());
    }

    @Test
    public void test_constructor203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USERS, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER, result1.getResponseValue());
    }

    @Test
    public void test_constructor301() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED, result1.getResponseValue());
    }

    @Test
    public void test_constructor302() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED, result1.getResponseValue());
    }

    @Test
    public void test_constructor401() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USER_DATA, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED, result1.getResponseValue());
    }

    @Test
    public void test_constructor402() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getResponseOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED, result1.getResponseValue());
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
        assertEquals(result2.getUserIndex(), result1.getUserIndex());
    }

    @Test
    public void test_parcelable002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
        assertEquals(result2.getNumberOfUsers(), result1.getNumberOfUsers());
    }

    @Test
    public void test_parcelable005() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
        assertEquals(result2.getUserIndex(), result1.getUserIndex());
    }

    @Test
    public void test_parcelable006() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = 0x31;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable007() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable008() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable009() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable010() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable011() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable012() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable013() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getResponseOpCode(), result1.getResponseOpCode());
        assertEquals(result2.getRequestOpCode(), result1.getRequestOpCode());
        assertEquals(result2.getResponseValue(), result1.getResponseValue());
    }

    @Test
    public void test_parcelable101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable106() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = 0x31;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable107() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable108() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable109() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable110() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable111() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable112() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable113() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable201() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable202() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable206() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = 0x31;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable207() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable208() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable209() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable210() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable211() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable212() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable213() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPointResponse.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        UserControlPointResponse result1 = new UserControlPointResponse(bluetoothGattCharacteristic);
        UserControlPointResponse result2 = UserControlPointResponse.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }


}
