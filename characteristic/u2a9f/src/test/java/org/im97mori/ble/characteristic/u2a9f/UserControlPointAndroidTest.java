package org.im97mori.ble.characteristic.u2a9f;

import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.test.TestBase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class UserControlPointAndroidTest extends TestBase {

    @Test
    public void test_constructor001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_DELETE_USER_DATA, result1.getOpCode());
    }

    @Test
    public void test_constructor004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_LIST_ALL_USERS, result1.getOpCode());
    }

    @Test
    public void test_constructor005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_DELETE_USERS, result1.getOpCode());
        assertEquals(0x31, result1.getUserIndex());
    }

    @Test
    public void test_constructor101() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
        assertEquals(0x31, result1.getUserIndex());
    }

    @Test
    public void test_constructor102() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
    }

    @Test
    public void test_constructor103() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USER_DATA, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
    }

    @Test
    public void test_constructor104() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_LIST_ALL_USERS, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
        assertEquals(0x31, result1.getNumberOfUsers());
    }

    @Test
    public void test_constructor105() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USERS, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_SUCCESS, result1.getResponseValue());
        assertEquals(0x31, result1.getUserIndex());
    }

    @Test
    public void test_constructor201() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = 0x31;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(0x31, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, result1.getResponseValue());
    }

    @Test
    public void test_constructor301() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER, result1.getResponseValue());
    }

    @Test
    public void test_constructor302() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER, result1.getResponseValue());
    }

    @Test
    public void test_constructor303() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USERS, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER, result1.getResponseValue());
    }

    @Test
    public void test_constructor401() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_REGISTER_NEW_USER, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_OPERATION_FAILED, result1.getResponseValue());
    }

    @Test
    public void test_constructor402() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_OPERATION_FAILED, result1.getResponseValue());
    }

    @Test
    public void test_constructor501() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_DELETE_USER_DATA, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED, result1.getResponseValue());
    }

    @Test
    public void test_constructor502() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_CONSENT;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertEquals(UserControlPoint.OP_CODE_RESPONSE_CODE, result1.getOpCode());
        assertEquals(UserControlPoint.OP_CODE_CONSENT, result1.getRequestOpCode());
        assertEquals(UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED, result1.getResponseValue());
    }

    @Test
    public void test_constructor503() {
        int opCode = 1;
        int userIndex = 2;
        int consentCode = 3;
        int requestOpCode = 4;
        int responseValue = 5;
        int numberOfUsers = 6;

        UserControlPointAndroid result1 = new UserControlPointAndroid(opCode, userIndex, consentCode, requestOpCode, responseValue, numberOfUsers);
        assertEquals(opCode, result1.getOpCode());
        assertEquals(userIndex, result1.getUserIndex());
        assertEquals(requestOpCode, result1.getRequestOpCode());
        assertEquals(responseValue, result1.getResponseValue());
        assertEquals(numberOfUsers, result1.getNumberOfUsers());
    }

    @Test
    public void test_opCode001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertTrue(result1.isOpCodeRegisterNewUser(result1.getOpCode()));
        assertFalse(result1.isOpCodeConsent(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUserData(result1.getOpCode()));
        assertFalse(result1.isOpCodeListAllUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_opCode002() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_CONSENT;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        data[ 3] = 0x33;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isOpCodeRegisterNewUser(result1.getOpCode()));
        assertTrue(result1.isOpCodeConsent(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUserData(result1.getOpCode()));
        assertFalse(result1.isOpCodeListAllUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_opCode003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isOpCodeRegisterNewUser(result1.getOpCode()));
        assertFalse(result1.isOpCodeConsent(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteUserData(result1.getOpCode()));
        assertFalse(result1.isOpCodeListAllUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_opCode004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isOpCodeRegisterNewUser(result1.getOpCode()));
        assertFalse(result1.isOpCodeConsent(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUserData(result1.getOpCode()));
        assertTrue(result1.isOpCodeListAllUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_opCode005() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isOpCodeRegisterNewUser(result1.getOpCode()));
        assertFalse(result1.isOpCodeConsent(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUserData(result1.getOpCode()));
        assertFalse(result1.isOpCodeListAllUsers(result1.getOpCode()));
        assertTrue(result1.isOpCodeDeleteUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_opCode006() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isOpCodeRegisterNewUser(result1.getOpCode()));
        assertFalse(result1.isOpCodeConsent(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUserData(result1.getOpCode()));
        assertFalse(result1.isOpCodeListAllUsers(result1.getOpCode()));
        assertFalse(result1.isOpCodeDeleteUsers(result1.getOpCode()));
        assertTrue(result1.isOpCodeResponseCode(result1.getOpCode()));
    }

    @Test
    public void test_responseValue001() {
        //@formatter:off
        byte[] data = new byte[4];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_SUCCESS;
        data[ 3] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertTrue(result1.isResponseValueSuccess(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOpCodeNotSupported(result1.getResponseValue()));
        assertFalse(result1.isResponseValueInvalidParameter(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOperationFailed(result1.getResponseValue()));
        assertFalse(result1.isResponseValueUserNotAuthorized(result1.getResponseValue()));
    }

    @Test
    public void test_responseValue002() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = 0x31;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isResponseValueSuccess(result1.getResponseValue()));
        assertTrue(result1.isResponseValueOpCodeNotSupported(result1.getResponseValue()));
        assertFalse(result1.isResponseValueInvalidParameter(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOperationFailed(result1.getResponseValue()));
        assertFalse(result1.isResponseValueUserNotAuthorized(result1.getResponseValue()));
    }

    @Test
    public void test_responseValue003() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_INVALID_PARAMETER;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isResponseValueSuccess(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOpCodeNotSupported(result1.getResponseValue()));
        assertTrue(result1.isResponseValueInvalidParameter(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOperationFailed(result1.getResponseValue()));
        assertFalse(result1.isResponseValueUserNotAuthorized(result1.getResponseValue()));
    }

    @Test
    public void test_responseValue004() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_OPERATION_FAILED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isResponseValueSuccess(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOpCodeNotSupported(result1.getResponseValue()));
        assertFalse(result1.isResponseValueInvalidParameter(result1.getResponseValue()));
        assertTrue(result1.isResponseValueOperationFailed(result1.getResponseValue()));
        assertFalse(result1.isResponseValueUserNotAuthorized(result1.getResponseValue()));
    }

    @Test
    public void test_responseValue005() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_RESPONSE_CODE;
        data[ 1] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        data[ 2] = UserControlPoint.RESPONSE_VALUE_USER_NOT_AUTHORIZED;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertFalse(result1.isResponseValueSuccess(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOpCodeNotSupported(result1.getResponseValue()));
        assertFalse(result1.isResponseValueInvalidParameter(result1.getResponseValue()));
        assertFalse(result1.isResponseValueOperationFailed(result1.getResponseValue()));
        assertTrue(result1.isResponseValueUserNotAuthorized(result1.getResponseValue()));
    }

    @Test
    public void test_parcelable001() {
        //@formatter:off
        byte[] data = new byte[3];
        data[ 0] = UserControlPoint.OP_CODE_REGISTER_NEW_USER;
        data[ 1] = 0x31;
        data[ 2] = 0x32;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromParcel(parcel);

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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable003() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromParcel(parcel);

        assertEquals(result2.getOpCode(), result1.getOpCode());
        assertEquals(result2.getConsentCode(), result1.getConsentCode());
    }

    @Test
    public void test_parcelable004() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromParcel(parcel);

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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromParcel(parcel);

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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable103() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable104() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable105() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromByteArray(data);
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

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable203() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USER_DATA;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable204() {
        //@formatter:off
        byte[] data = new byte[1];
        data[ 0] = UserControlPoint.OP_CODE_LIST_ALL_USERS;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable205() {
        //@formatter:off
        byte[] data = new byte[2];
        data[ 0] = UserControlPoint.OP_CODE_DELETE_USERS;
        data[ 1] = 0x31;
        //@formatter:on

        UserControlPointAndroid result1 = new UserControlPointAndroid(data);
        UserControlPointAndroid result2 = UserControlPointAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
    
    
}
