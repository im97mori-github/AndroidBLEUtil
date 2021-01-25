package org.im97mori.ble.service.uds.peripheral;

import android.bluetooth.BluetoothGatt;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.USER_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UserControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);

        Gson gson = new Gson();
        UserControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), UserControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponseValue, result2.registerNewUserResponseValue);
        assertEquals(result1.consentResponseValue, result2.consentResponseValue);
        assertEquals(result1.deleteUserDataResponseValue, result2.deleteUserDataResponseValue);
        assertEquals(result1.listAllUsersResponseValue, result2.listAllUsersResponseValue);
        assertEquals(result1.deleteUsersResponseValue, result2.deleteUsersResponseValue);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                ,
                5
                , 6
                , 7
                , 8
                , 9);

        Gson gson = new Gson();
        UserControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), UserControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponseValue, result2.registerNewUserResponseValue);
        assertEquals(result1.consentResponseValue, result2.consentResponseValue);
        assertEquals(result1.deleteUserDataResponseValue, result2.deleteUserDataResponseValue);
        assertEquals(result1.listAllUsersResponseValue, result2.listAllUsersResponseValue);
        assertEquals(result1.deleteUsersResponseValue, result2.deleteUsersResponseValue);
    }

    @Test
    public void test_setRegisterNewUserResponseValue_00001() {
        int firstRegisterNewUserResponseValue = 5;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                ,
                firstRegisterNewUserResponseValue
                , 6
                , 7
                , 8
                , 9);

        assertEquals(firstRegisterNewUserResponseValue, result1.registerNewUserResponseValue);

        int secondRegisterNewUserResponseValue = 55;
        result1.registerNewUserResponseValue = secondRegisterNewUserResponseValue;
        assertEquals(secondRegisterNewUserResponseValue, result1.registerNewUserResponseValue);
    }

    @Test
    public void test_setConsentResponseValue_00001() {
        int firstConsentResponseValue = 6;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                ,
                5
                , firstConsentResponseValue
                , 7
                , 8
                , 9);

        assertEquals(firstConsentResponseValue, result1.consentResponseValue);

        int secondConsentResponseValue = 66;
        result1.consentResponseValue = secondConsentResponseValue;
        assertEquals(secondConsentResponseValue, result1.consentResponseValue);
    }

    @Test
    public void test_setDeleteUserDataResponseValue_00001() {
        int firstDeleteUserDataResponseValue = 7;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                ,
                5
                , 6
                , firstDeleteUserDataResponseValue
                , 8
                , 9);

        assertEquals(firstDeleteUserDataResponseValue, result1.deleteUserDataResponseValue);

        int secondDeleteUserDataResponseValue = 77;
        result1.deleteUserDataResponseValue = secondDeleteUserDataResponseValue;
        assertEquals(secondDeleteUserDataResponseValue, result1.deleteUserDataResponseValue);
    }

    @Test
    public void test_setListAllUsersResponseValue_00001() {
        int firstListAllUsersResponseValue = 8;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                ,
                5
                , 6
                , 7
                , firstListAllUsersResponseValue
                , 9);

        assertEquals(firstListAllUsersResponseValue, result1.listAllUsersResponseValue);

        int secondListAllUsersResponseValue = 88;
        result1.listAllUsersResponseValue = secondListAllUsersResponseValue;
        assertEquals(secondListAllUsersResponseValue, result1.listAllUsersResponseValue);
    }

    @Test
    public void test_setDeleteUsersResponseValue_00001() {
        int firstDeleteUsersResponseValue = 9;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                ,
                5
                , 6
                , 7
                , 8
                , firstDeleteUsersResponseValue);

        assertEquals(firstDeleteUsersResponseValue, result1.deleteUsersResponseValue);

        int secondDeleteUsersResponseValue = 99;
        result1.deleteUsersResponseValue = secondDeleteUsersResponseValue;
        assertEquals(secondDeleteUsersResponseValue, result1.deleteUsersResponseValue);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                ,
                5
                , 6
                , 7
                , 8
                , 9);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointCharacteristicData result2 = UserControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponseValue, result2.registerNewUserResponseValue);
        assertEquals(result1.consentResponseValue, result2.consentResponseValue);
        assertEquals(result1.deleteUserDataResponseValue, result2.deleteUserDataResponseValue);
        assertEquals(result1.listAllUsersResponseValue, result2.listAllUsersResponseValue);
        assertEquals(result1.deleteUsersResponseValue, result2.deleteUsersResponseValue);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                ,
                5
                , 6
                , 7
                , 8
                , 9);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UserControlPointCharacteristicData result2 = UserControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponseValue, result2.registerNewUserResponseValue);
        assertEquals(result1.consentResponseValue, result2.consentResponseValue);
        assertEquals(result1.deleteUserDataResponseValue, result2.deleteUserDataResponseValue);
        assertEquals(result1.listAllUsersResponseValue, result2.listAllUsersResponseValue);
        assertEquals(result1.deleteUsersResponseValue, result2.deleteUsersResponseValue);
    }

    @Test
    public void test_hashCode_00001() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long delay = 3;
        int notificationCount = 0;
        int registerNewUserResponseValue = 5;
        int consentResponseValue = 6;
        int deleteUserDataResponseValue = 7;
        int listAllUsersResponseValue = 8;
        int deleteUsersResponseValue = 9;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , delay
                , registerNewUserResponseValue
                , consentResponseValue
                , deleteUserDataResponseValue
                , listAllUsersResponseValue
                , deleteUsersResponseValue);

        assertEquals(USER_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(new byte[0])
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(registerNewUserResponseValue).hashCode()
                        ^ Integer.valueOf(consentResponseValue).hashCode()
                        ^ Integer.valueOf(deleteUserDataResponseValue).hashCode()
                        ^ Integer.valueOf(listAllUsersResponseValue).hashCode()
                        ^ Integer.valueOf(deleteUsersResponseValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long delay = 3;
        byte[] currentData = new byte[]{11, 12};
        byte[] temporaryData = new byte[]{13, 14};
        int notificationCount = 0;
        int registerNewUserResponseValue = 5;
        int consentResponseValue = 6;
        int deleteUserDataResponseValue = 7;
        int listAllUsersResponseValue = 8;
        int deleteUsersResponseValue = 9;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , delay
                , registerNewUserResponseValue
                , consentResponseValue
                , deleteUserDataResponseValue
                , listAllUsersResponseValue
                , deleteUsersResponseValue);

        result1.currentData = currentData;
        result1.temporaryData = temporaryData;

        assertEquals(USER_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(new byte[0])
                        ^ Integer.valueOf(notificationCount).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(registerNewUserResponseValue).hashCode()
                        ^ Integer.valueOf(consentResponseValue).hashCode()
                        ^ Integer.valueOf(deleteUserDataResponseValue).hashCode()
                        ^ Integer.valueOf(listAllUsersResponseValue).hashCode()
                        ^ Integer.valueOf(deleteUsersResponseValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondProperty = 101;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(secondProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondPermission = 102;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , secondPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , secondDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondDelay = 103;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , secondDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondRegisterNewUserResponseValue = 105;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                secondRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondConsentResponseValue = 106;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , secondConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondDeleteUserDataResponseValue = 107;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , secondDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondListAllUsersResponseValue = 108;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , secondListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstRegisterNewUserResponseValue = 5;
        int firstConsentResponseValue = 6;
        int firstDeleteUserDataResponseValue = 7;
        int firstListAllUsersResponseValue = 8;
        int firstDeleteUsersResponseValue = 9;

        int secondDeleteUsersResponseValue = 109;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , firstDeleteUsersResponseValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                ,
                firstRegisterNewUserResponseValue
                , firstConsentResponseValue
                , firstDeleteUserDataResponseValue
                , firstListAllUsersResponseValue
                , secondDeleteUsersResponseValue);
        assertNotEquals(result1, result2);
    }

}
