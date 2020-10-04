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
                , 4
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
        assertEquals(result1.registerNewUserResponceValue, result2.registerNewUserResponceValue);
        assertEquals(result1.consentResponceValue, result2.consentResponceValue);
        assertEquals(result1.deleteUserDataResponceValue, result2.deleteUserDataResponceValue);
        assertEquals(result1.listAllUsersResponceValue, result2.listAllUsersResponceValue);
        assertEquals(result1.deleteUsersResponceValue, result2.deleteUsersResponceValue);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                , 4
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
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponceValue, result2.registerNewUserResponceValue);
        assertEquals(result1.consentResponceValue, result2.consentResponceValue);
        assertEquals(result1.deleteUserDataResponceValue, result2.deleteUserDataResponceValue);
        assertEquals(result1.listAllUsersResponceValue, result2.listAllUsersResponceValue);
        assertEquals(result1.deleteUsersResponceValue, result2.deleteUsersResponceValue);
    }

    @Test
    public void test_setRegisterNewUserResponceValue_00001() {
        int firstRegisterNewUserResponceValue = 5;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 4
                , firstRegisterNewUserResponceValue
                , 6
                , 7
                , 8
                , 9);

        assertEquals(firstRegisterNewUserResponceValue, result1.registerNewUserResponceValue);

        int secondRegisterNewUserResponceValue = 55;
        result1.registerNewUserResponceValue = secondRegisterNewUserResponceValue;
        assertEquals(secondRegisterNewUserResponceValue, result1.registerNewUserResponceValue);
    }

    @Test
    public void test_setConsentResponceValue_00001() {
        int firstConsentResponceValue = 6;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 4
                , 5
                , firstConsentResponceValue
                , 7
                , 8
                , 9);

        assertEquals(firstConsentResponceValue, result1.consentResponceValue);

        int secondConsentResponceValue = 66;
        result1.consentResponceValue = secondConsentResponceValue;
        assertEquals(secondConsentResponceValue, result1.consentResponceValue);
    }

    @Test
    public void test_setDeleteUserDataResponceValue_00001() {
        int firstDeleteUserDataResponceValue = 7;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 4
                , 5
                , 6
                , firstDeleteUserDataResponceValue
                , 8
                , 9);

        assertEquals(firstDeleteUserDataResponceValue, result1.deleteUserDataResponceValue);

        int secondDeleteUserDataResponceValue = 77;
        result1.deleteUserDataResponceValue = secondDeleteUserDataResponceValue;
        assertEquals(secondDeleteUserDataResponceValue, result1.deleteUserDataResponceValue);
    }

    @Test
    public void test_setListAllUsersResponceValue_00001() {
        int firstListAllUsersResponceValue = 8;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstListAllUsersResponceValue
                , 9);

        assertEquals(firstListAllUsersResponceValue, result1.listAllUsersResponceValue);

        int secondListAllUsersResponceValue = 88;
        result1.listAllUsersResponceValue = secondListAllUsersResponceValue;
        assertEquals(secondListAllUsersResponceValue, result1.listAllUsersResponceValue);
    }

    @Test
    public void test_setDeleteUsersResponceValue_00001() {
        int firstDeleteUsersResponceValue = 9;
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<DescriptorData>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , firstDeleteUsersResponceValue);

        assertEquals(firstDeleteUsersResponceValue, result1.deleteUsersResponceValue);

        int secondDeleteUsersResponceValue = 99;
        result1.deleteUsersResponceValue = secondDeleteUsersResponceValue;
        assertEquals(secondDeleteUsersResponceValue, result1.deleteUsersResponceValue);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                , 4
                , 5
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
        assertNotNull(result2.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponceValue, result2.registerNewUserResponceValue);
        assertEquals(result1.consentResponceValue, result2.consentResponceValue);
        assertEquals(result1.deleteUserDataResponceValue, result2.deleteUserDataResponceValue);
        assertEquals(result1.listAllUsersResponceValue, result2.listAllUsersResponceValue);
        assertEquals(result1.deleteUsersResponceValue, result2.deleteUsersResponceValue);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 17, 18, 19, new byte[]{20}));
        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(1
                , 2
                , descriptorDataList
                , 3
                , 4
                , 5
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
        assertNotNull(result2.descriptorDataList);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.registerNewUserResponceValue, result2.registerNewUserResponceValue);
        assertEquals(result1.consentResponceValue, result2.consentResponceValue);
        assertEquals(result1.deleteUserDataResponceValue, result2.deleteUserDataResponceValue);
        assertEquals(result1.listAllUsersResponceValue, result2.listAllUsersResponceValue);
        assertEquals(result1.deleteUsersResponceValue, result2.deleteUsersResponceValue);
    }

    @Test
    public void test_hashCode_00001() {
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long delay = 3;
        int notificationCount = 4;
        int registerNewUserResponceValue = 5;
        int consentResponceValue = 6;
        int deleteUserDataResponceValue = 7;
        int listAllUsersResponceValue = 8;
        int deleteUsersResponceValue = 9;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , delay
                , notificationCount
                , registerNewUserResponceValue
                , consentResponceValue
                , deleteUserDataResponceValue
                , listAllUsersResponceValue
                , deleteUsersResponceValue);

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
                        ^ Integer.valueOf(registerNewUserResponceValue).hashCode()
                        ^ Integer.valueOf(consentResponceValue).hashCode()
                        ^ Integer.valueOf(deleteUserDataResponceValue).hashCode()
                        ^ Integer.valueOf(listAllUsersResponceValue).hashCode()
                        ^ Integer.valueOf(deleteUsersResponceValue).hashCode()
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
        int notificationCount = 4;
        int registerNewUserResponceValue = 5;
        int consentResponceValue = 6;
        int deleteUserDataResponceValue = 7;
        int listAllUsersResponceValue = 8;
        int deleteUsersResponceValue = 9;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(
                property
                , permission
                , descriptorDataList
                , delay
                , notificationCount
                , registerNewUserResponceValue
                , consentResponceValue
                , deleteUserDataResponceValue
                , listAllUsersResponceValue
                , deleteUsersResponceValue);

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
                        ^ Integer.valueOf(registerNewUserResponceValue).hashCode()
                        ^ Integer.valueOf(consentResponceValue).hashCode()
                        ^ Integer.valueOf(deleteUserDataResponceValue).hashCode()
                        ^ Integer.valueOf(listAllUsersResponceValue).hashCode()
                        ^ Integer.valueOf(deleteUsersResponceValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondProperty = 101;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(secondProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondPermission = 102;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , secondPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , secondDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondDelay = 103;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , secondDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondNotificationCount = 104;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , secondNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondRegisterNewUserResponceValue = 105;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , secondRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondConsentResponceValue = 106;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , secondConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondDeleteUserDataResponceValue = 107;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , secondDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondListAllUsersResponceValue = 108;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , secondListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        long firstDelay = 3;
        int firstNotificationCount = 4;
        int firstRegisterNewUserResponceValue = 5;
        int firstConsentResponceValue = 6;
        int firstDeleteUserDataResponceValue = 7;
        int firstListAllUsersResponceValue = 8;
        int firstDeleteUsersResponceValue = 9;

        int secondDeleteUsersResponceValue = 109;

        UserControlPointCharacteristicData result1 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , firstDeleteUsersResponceValue);
        UserControlPointCharacteristicData result2 = new UserControlPointCharacteristicData(firstProperty
                , firstPermission
                , firstDescriptorDataList
                , firstDelay
                , firstNotificationCount
                , firstRegisterNewUserResponceValue
                , firstConsentResponceValue
                , firstDeleteUserDataResponceValue
                , firstListAllUsersResponceValue
                , secondDeleteUsersResponceValue);
        assertNotEquals(result1, result2);
    }

}
