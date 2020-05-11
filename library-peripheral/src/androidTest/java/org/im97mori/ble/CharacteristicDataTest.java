package org.im97mori.ble;

import android.os.Parcel;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class CharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<DescriptorData>(), 3, 4, null);

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
    }

    @Test
    public void test_constructor_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6});

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
    }

    @Test
    public void test_setUuid_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        CharacteristicData characteristicData = new CharacteristicData(firstUUID, 1, 2, descriptorDataList, 3, 4, null);
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
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), firstProperty, 2, descriptorDataList, 3, 4, null);
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
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, firstPermission, descriptorDataList, 3, 4, null);
        assertEquals(firstPermission, characteristicData.permission);

        int secondPermission = 22;
        characteristicData.permission = secondPermission;
        assertEquals(secondPermission, characteristicData.permission);
    }

    @Test
    public void test_setDescriptorDataList_00001() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));

        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, firstDescriptorDataList, 3, 4, null);
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
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, firstResponseCode, 4, null);
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
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, firstDelay, null);
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
        CharacteristicData characteristicData = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, firstData);
        assertArrayEquals(firstData, characteristicData.data);

        byte[] secondData = new byte[1];
        characteristicData.data = secondData;
        assertArrayEquals(secondData, characteristicData.data);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 1, 2, 3, null));
        CharacteristicData result1 = new CharacteristicData(UUID.randomUUID(), 1, 2, descriptorDataList, 3, 4, new byte[]{5, 6});
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

        CharacteristicData result1 = new CharacteristicData(uuid, property, permission, descriptorDataList, responseCode, delay, data);
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(property).hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
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

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(secondUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
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

        int secondProperty = 11;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, secondProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
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

        int secondPermission = 22;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, secondPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
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

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 11, 22, 33, null));

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, secondDescriptorDataList, firstResponseCode, firstDelay, firstData);
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

        int secondResponseCode = 33;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, secondResponseCode, firstDelay, firstData);
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

        long secondDelay = 44;

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, secondDelay, firstData);
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

        byte[] secondData = new byte[]{55, 66};

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        CharacteristicData result2 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, secondData);
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

        CharacteristicData result1 = new CharacteristicData(firstUUID, firstProperty, firstPermission, firstDescriptorDataList, firstResponseCode, firstDelay, firstData);
        assertNotEquals(null, result1);
    }

}
