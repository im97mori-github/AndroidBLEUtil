package org.im97mori.ble;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import android.os.Parcel;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);

        Gson gson = new Gson();
        CharacteristicData result2 = gson.fromJson(gson.toJson(result1), CharacteristicData.class);

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
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6}, 7);

        Gson gson = new Gson();
        CharacteristicData result2 = gson.fromJson(gson.toJson(result1), CharacteristicData.class);

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
        CharacteristicData characteristicData = new CharacteristicData(firstUUID, 1, 2, descriptorDataList, 3, 4, null, 5);
        assertEquals(firstUUID, characteristicData.uuid);

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        characteristicData.uuid = secondUUID;
        assertEquals(secondUUID, characteristicData.uuid);
    }

    @Test
    public void test_setProperty_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstProperty = 1;
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), firstProperty, 2, descriptorDataList, 3, 4, null, 5);
        assertEquals(firstProperty, characteristicData.property);

        int secondProperty = 2;
        characteristicData.property = secondProperty;
        assertEquals(secondProperty, characteristicData.property);
    }

    @Test
    public void test_setPermission_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstPermission = 2;
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, firstPermission, descriptorDataList, 3, 4, null, 5);
        assertEquals(firstPermission, characteristicData.permission);

        int secondPermission = 22;
        characteristicData.permission = secondPermission;
        assertEquals(secondPermission, characteristicData.permission);
    }

    @Test
    public void test_setDescriptorDataList_00001() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, firstDescriptorDataList, 3, 4, null, 5);
        assertArrayEquals(firstDescriptorDataList.toArray(), characteristicData.descriptorDataList.toArray());

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));
        characteristicData.descriptorDataList = secondDescriptorDataList;
        assertArrayEquals(secondDescriptorDataList.toArray(), characteristicData.descriptorDataList.toArray());
    }

    @Test
    public void test_setResponseCode_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstResponseCode = 3;
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, firstResponseCode, 4, null, 5);
        assertEquals(firstResponseCode, characteristicData.responseCode);

        int secondResponseCode = 33;
        characteristicData.responseCode = secondResponseCode;
        assertEquals(secondResponseCode, characteristicData.responseCode);
    }

    @Test
    public void test_setDelay_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        long firstDelay = 4;
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, firstDelay, null, 5);
        assertEquals(firstDelay, characteristicData.delay);

        long secondDelay = 44;
        characteristicData.delay = secondDelay;
        assertEquals(secondDelay, characteristicData.delay);
    }

    @Test
    public void test_setData_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, characteristicData.data);

        byte[] secondData = new byte[1];
        characteristicData.data = secondData;
        assertArrayEquals(secondData, characteristicData.data);
    }

    @Test
    public void test_getBytes_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, characteristicData.getBytes());

        byte[] secondData = new byte[1];
        characteristicData.data = secondData;
        assertArrayEquals(secondData, characteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, characteristicData.getBytes());

        byte[] secondData = new byte[1];
        characteristicData.currentData = secondData;
        assertArrayEquals(secondData, characteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        byte[] firstData = new byte[0];
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData, 5);
        assertArrayEquals(firstData, characteristicData.getBytes());

        characteristicData.temporaryData.put(1, new byte[]{2});
        assertArrayEquals(firstData, characteristicData.getBytes());
    }

    @Test
    public void test_setNotificationCount_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        int firstNotificationCount = 5;
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, null, firstNotificationCount);
        assertEquals(firstNotificationCount, characteristicData.notificationCount);

        int secondNotificationCount = 55;
        characteristicData.notificationCount = secondNotificationCount;
        assertEquals(secondNotificationCount, characteristicData.notificationCount);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6}, 7);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicData result2 = CharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.temporaryData.size(), result2.temporaryData.size());
        for (Integer key : result1.temporaryData.keySet()) {
            assertArrayEquals(result1.temporaryData.get(key), result2.temporaryData.get(key));
        }
        assertEquals(result1.notificationCount, result2.notificationCount);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6}, 7);
        result1.currentData = new byte[]{8};
        result1.temporaryData.put(9, new byte[]{10});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CharacteristicData result2 = CharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.temporaryData.size(), result2.temporaryData.size());
        for (Integer key : result1.temporaryData.keySet()) {
            assertArrayEquals(result1.temporaryData.get(key), result2.temporaryData.get(key));
        }
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

        CharacteristicData result1 = new CharacteristicData(uuid, property, permission, descriptorDataList, responseCode, delay, data, notificationCount);
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
        HashMap<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(9, new byte[]{10});
        int notificationCount = 11;

        CharacteristicData result1 = new CharacteristicData(uuid, property, permission, descriptorDataList, responseCode, delay, data, notificationCount);
        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);
        assertNotEquals(uuid.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode(currentData)
                        ^ temporaryData.hashCode()
                        ^ Integer.valueOf(notificationCount).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        UUID uuid = UUID.randomUUID();
        int property = 1;
        int permission = 2;
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int responseCode = 3;
        long delay = 4;
        byte[] data = new byte[]{5, 6};
        byte[] currentData = new byte[]{7, 8};
        HashMap<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(9, new byte[]{10});
        int notificationCount = 11;

        CharacteristicData result1 = new CharacteristicData(uuid, property, permission, descriptorDataList, responseCode, delay, data, notificationCount);
        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);

        int hashCode = 0;
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            hashCode ^= entry.getKey().hashCode();
            hashCode ^= Arrays.hashCode(entry.getValue());
        }
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode(currentData)
                        ^ hashCode
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(secondUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, secondProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, secondPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, secondDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, secondResponseCode, firstDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, secondDelay, firstData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, secondData, firstNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, secondNotificationCount);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(secondUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        int secondProperty = 12;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, secondProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        int secondPermission = 22;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, secondPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;


        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 111, 222, 333, null));

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, secondDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        int secondResponseCode = 33;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, secondResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        long secondDelay = 44;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, secondDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        byte[] secondData = new byte[]{55, 66};

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, secondData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        byte[] secondCurrentData = new byte[]{77, 88};

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = secondCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        HashMap<Integer, byte[]> secondTemporaryData = new HashMap<>();
        secondTemporaryData.put(99, new byte[]{110});

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(secondTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        int secondNotificationCount = 77;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, secondNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
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
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(null, result1);
    }

    @Test
    public void test_equals_00201() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstProperty = 1;
        int firstPermission = 2;
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        int firstResponseCode = 3;
        long firstDelay = 4;
        byte[] firstData = new byte[]{5, 6};
        byte[] firstCurrentData = new byte[]{7, 8};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(9, new byte[]{10});
        int firstNotificationCount = 11;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData, firstNotificationCount);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertEquals(result1, result2);
    }

    @Test
    public void test_isTemporaryDataValid_00001() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00002() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[0]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00003() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[1]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00004() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[0]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00005() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00006() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);
        result1.temporaryData.put(2, new byte[0]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00007() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);
        result1.temporaryData.put(2, new byte[1]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00008() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(1, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00009() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[0]);
        result1.temporaryData.put(1, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00010() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[2]);
        result1.temporaryData.put(1, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00011() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);
        result1.temporaryData.put(3, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_executeReliableWrite_00001() {
        byte[] data = new byte[]{0};
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, data, 5);

        assertTrue(result1.executeReliableWrite());
        assertArrayEquals(new byte[0], result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

    @Test
    public void test_executeReliableWrite_00002() {
        byte[] data = new byte[]{0};
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, data, 5);

        byte[] newData = new byte[]{1};
        result1.temporaryData.put(0, newData);
        assertTrue(result1.executeReliableWrite());
        assertArrayEquals(newData, result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

    @Test
    public void test_executeReliableWrite_00003() {
        byte[] data = new byte[]{0};
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, data, 5);

        byte[] newData = new byte[]{1, 2};
        result1.temporaryData.put(0, Arrays.copyOfRange(newData, 0, 1));
        result1.temporaryData.put(1, Arrays.copyOfRange(newData, 1, 2));
        assertTrue(result1.executeReliableWrite());
        assertArrayEquals(newData, result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

    @Test
    public void test_executeReliableWrite_00004() {
        byte[] data = new byte[]{0};
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, data, 5);

        byte[] newData = new byte[]{1};
        result1.temporaryData.put(1, newData);
        assertFalse(result1.executeReliableWrite());
        assertArrayEquals(data, result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

}
