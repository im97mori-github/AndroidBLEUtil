package org.im97mori.ble.service.uds.peripheral;

import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.core.UserIndexUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class UDSCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        UDSCharacteristicData result1 = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);

        Gson gson = new Gson();
        UDSCharacteristicData result2 = gson.fromJson(gson.toJson(result1), UDSCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        UDSCharacteristicData result1 = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6}, 7);

        Gson gson = new Gson();
        UDSCharacteristicData result2 = gson.fromJson(gson.toJson(result1), UDSCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
    }

    @Test
    public void test_setUuid_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(firstUUID, 1, 2, descriptorDataList, 3, 4, null, 5);
        assertEquals(firstUUID, udsCharacteristicData.uuid);

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        udsCharacteristicData.uuid = secondUUID;
        assertEquals(secondUUID, udsCharacteristicData.uuid);
    }

    @Test
    public void test_setProperty_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstProperty = 1;
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), firstProperty, 2, descriptorDataList, 3, 4, null, 5);
        assertEquals(firstProperty, udsCharacteristicData.property);

        int secondProperty = 2;
        udsCharacteristicData.property = secondProperty;
        assertEquals(secondProperty, udsCharacteristicData.property);
    }

    @Test
    public void test_setPermission_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstPermission = 2;
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, firstPermission, descriptorDataList, 3, 4, null, 5);
        assertEquals(firstPermission, udsCharacteristicData.permission);

        int secondPermission = 22;
        udsCharacteristicData.permission = secondPermission;
        assertEquals(secondPermission, udsCharacteristicData.permission);
    }

    @Test
    public void test_setDescriptorDataList_00001() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, firstDescriptorDataList, 3, 4, null, 5);
        assertArrayEquals(firstDescriptorDataList.toArray(), udsCharacteristicData.descriptorDataList.toArray());

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));
        udsCharacteristicData.descriptorDataList = secondDescriptorDataList;
        assertArrayEquals(secondDescriptorDataList.toArray(), udsCharacteristicData.descriptorDataList.toArray());
    }

    @Test
    public void test_setResponseCode_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstResponseCode = 3;
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, firstResponseCode, 4, null, 5);
        assertEquals(firstResponseCode, udsCharacteristicData.responseCode);

        int secondResponseCode = 33;
        udsCharacteristicData.responseCode = secondResponseCode;
        assertEquals(secondResponseCode, udsCharacteristicData.responseCode);
    }

    @Test
    public void test_setDelay_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        long firstDelay = 4;
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, firstDelay, null, 5);
        assertEquals(firstDelay, udsCharacteristicData.delay);

        long secondDelay = 44;
        udsCharacteristicData.delay = secondDelay;
        assertEquals(secondDelay, udsCharacteristicData.delay);
    }

    @Test
    public void test_setData_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, udsCharacteristicData.data);

        byte[] secondData = new byte[1];
        udsCharacteristicData.data = secondData;
        assertArrayEquals(secondData, udsCharacteristicData.data);
    }

    @Test
    public void test_setNotificationCount_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstNotificationCount = 5;
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, null, firstNotificationCount);
        assertEquals(firstNotificationCount, udsCharacteristicData.notificationCount);

        int secondNotificationCount = 55;
        udsCharacteristicData.notificationCount = secondNotificationCount;
        assertEquals(secondNotificationCount, udsCharacteristicData.notificationCount);
    }

    @Test
    public void test_getBytes_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, udsCharacteristicData.getBytes());

        byte[] secondData = new byte[1];
        udsCharacteristicData.data = secondData;
        assertArrayEquals(secondData, udsCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, udsCharacteristicData.getBytes());

        byte[] secondData = new byte[1];
        udsCharacteristicData.currentData = secondData;
        assertArrayEquals(secondData, udsCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        UDSCharacteristicData udsCharacteristicData = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, udsCharacteristicData.getBytes());

        byte[] secondData = new byte[1];
        udsCharacteristicData.temporaryData = secondData;
        assertArrayEquals(firstData, udsCharacteristicData.getBytes());
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        UDSCharacteristicData result1 = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6}, 7);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UDSCharacteristicData result2 = UDSCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertArrayEquals(result1.currentData, result2.currentData);
        assertArrayEquals(result1.temporaryData, result2.temporaryData);
        assertEquals(result1.notificationCount, result2.notificationCount);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        UDSCharacteristicData result1 = new UDSCharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6}, 7);
        result1.currentData = new byte[]{8};
        result1.temporaryData = new byte[]{9};
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        UDSCharacteristicData result2 = UDSCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertArrayEquals(result1.currentData, result2.currentData);
        assertArrayEquals(result1.temporaryData, result2.temporaryData);
        assertEquals(result1.notificationCount, result2.notificationCount);
    }

    @Test
    public void test_hashCode_00001() {
        UUID uuid = UUID.randomUUID();
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new byte[]{5, 6};
        int notificationCount = 7;

        UDSCharacteristicData result1 = new UDSCharacteristicData(uuid, property, permission, descriptorDataList, responseCode, delay, data, notificationCount);
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(notificationCount).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        UUID uuid = UUID.randomUUID();
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new byte[]{5, 6};
        byte[] currentData = new byte[]{7, 8};
        byte[] temporaryData = new byte[]{9, 10};
        int notificationCount = 11;

        UDSCharacteristicData result1 = new UDSCharacteristicData(uuid, property, permission, descriptorDataList, responseCode, delay, data, notificationCount);
        result1.currentData = currentData;
        result1.temporaryData = temporaryData;
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(notificationCount).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(secondUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        int secondProperty = 11;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, secondProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        int secondPermission = 22;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, secondPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, secondDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        int secondResponseCode = 33;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, secondResponseCode, firstDelay, firstData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        long secondDelay = 44;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, secondDelay, firstData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        byte[] secondData = new byte[]{55, 66};

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, secondData, firstNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        int secondNotificationCount = 77;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, secondNotificationCount);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        assertNotEquals(null, result1);
    }

    @Test
    public void test_equals_00101() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(secondUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00103() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        int secondProperty = 12;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, secondProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00104() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        int secondPermission = 22;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, secondPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00105() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;


        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 111, 222, 333, null));

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, secondDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00106() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        int secondResponseCode = 33;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, secondResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00107() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        long secondDelay = 44;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, secondDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00108() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        byte[] secondData = new byte[]{55, 66};

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, secondData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00109() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        byte[] secondCurrentData = new byte[]{77, 88};

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = secondCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00110() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        byte[] secondTemporaryData = new byte[]{99, 110};

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = secondTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00111() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        int secondNotificationCount = 77;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        UDSCharacteristicData result2 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, secondNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData = firstTemporaryData;
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00112() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        byte[] firstTemporaryData = new byte[]{9, 10};
        int firstNotificationCount = 11;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData = firstTemporaryData;
        assertNotEquals(null, result1);
    }

    @Test
    public void test_getUserData_00001() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);

        CharacteristicData characteristicData = result1.getUserData(UserIndexUtils.USER_ID_UNKNOWN_USER);
        assertNull(characteristicData);
    }

    @Test
    public void test_getUserData_00002() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);

        CharacteristicData characteristicData = result1.getUserData(1);
        assertNotNull(characteristicData);
        assertEquals(firstUUID, characteristicData.uuid);
        assertEquals(firstProperty, characteristicData.property);
        assertEquals(firstPermission, characteristicData.permission);
        assertEquals(firstDescriptorDataList, characteristicData.descriptorDataList);
        assertEquals(firstResponseCode, characteristicData.responseCode);
        assertEquals(firstDelay, characteristicData.delay);
        assertArrayEquals(firstData, characteristicData.data);
        assertEquals(firstNotificationCount, characteristicData.notificationCount);
    }

    @Test
    public void test_getUserData_00003() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        int firstNotificationCount = 7;

        UDSCharacteristicData result1 = new UDSCharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-00000000000a");
        int secondProperty = 11;
        int secondPermission = 22;
        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));
        int secondResponseCode = 33;
        long secondDelay = 44;
        byte[] secondData = new byte[]{55, 66};
        int secondNotificationCount = 77;

        int userIndex = 1;

        CharacteristicData characteristicData = new CharacteristicData(secondUUID, secondProperty, secondPermission, secondDescriptorDataList, secondResponseCode, secondDelay, secondData, secondNotificationCount);

        result1.setUserData(userIndex, characteristicData);
        characteristicData = result1.getUserData(userIndex);
        assertNotNull(characteristicData);
        assertEquals(secondUUID, characteristicData.uuid);
        assertEquals(secondProperty, characteristicData.property);
        assertEquals(secondPermission, characteristicData.permission);
        assertEquals(secondDescriptorDataList, characteristicData.descriptorDataList);
        assertEquals(secondResponseCode, characteristicData.responseCode);
        assertEquals(secondDelay, characteristicData.delay);
        assertArrayEquals(secondData, characteristicData.data);
        assertEquals(secondNotificationCount, characteristicData.notificationCount);
    }
}
