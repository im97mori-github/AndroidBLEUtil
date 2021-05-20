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

public class ServiceDataTest {

    @Test
    public void test_constructor_00001() {
        ServiceData result1 = new ServiceData(UUID.randomUUID(), 1, new ArrayList<>());

        Gson gson = new Gson();
        ServiceData result2 = gson.fromJson(gson.toJson(result1), ServiceData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.type, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
    }

    @Test
    public void test_constructor_00002() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        ServiceData result1 = new ServiceData(UUID.randomUUID(), 1, characteristicDataList);

        Gson gson = new Gson();
        ServiceData result2 = gson.fromJson(gson.toJson(result1), ServiceData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.type, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
    }

    @Test
    public void test_setUuid_00001() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        ServiceData serviceData = new ServiceData(firstUUID, 1, characteristicDataList);
        assertEquals(firstUUID, serviceData.uuid);

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        serviceData.uuid = secondUUID;
        assertEquals(secondUUID, serviceData.uuid);
    }

    @Test
    public void test_setType_00001() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        int firstType = 1;
        ServiceData serviceData = new ServiceData(UUID.randomUUID(), firstType, characteristicDataList);
        assertEquals(firstType, serviceData.type);

        int secondType = 11;
        serviceData.type = secondType;
        assertEquals(secondType, serviceData.type);
    }


    @Test
    public void test_setCharacteristicDataList_00001() {
        List<CharacteristicData> firstCharacteristicDataList = new ArrayList<>();
        firstCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        ServiceData serviceData = new ServiceData(UUID.randomUUID(), 1, firstCharacteristicDataList);
        assertArrayEquals(firstCharacteristicDataList.toArray(), serviceData.characteristicDataList.toArray());

        List<CharacteristicData> secondCharacteristicDataList = new ArrayList<>();
        secondCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 11, 22, new ArrayList<>(), 33, 44, null, 5));
        serviceData.characteristicDataList = secondCharacteristicDataList;
        assertArrayEquals(secondCharacteristicDataList.toArray(), serviceData.characteristicDataList.toArray());
    }

    @Test
    public void test_parcelable_00001() {
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));
        ServiceData result1 = new ServiceData(UUID.randomUUID(), 1, characteristicDataList);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        ServiceData result2 = ServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.type, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        result1.characteristicDataList.clear();
        assertNotEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
    }

    @Test
    public void test_hashCode_00001() {
        UUID uuid = UUID.randomUUID();
        int type = 1;
        List<CharacteristicData> characteristicDataList = new ArrayList<>();
        characteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        ServiceData result1 = new ServiceData(uuid, type, characteristicDataList);
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(type).hashCode()
                        ^ Arrays.hashCode(characteristicDataList.toArray())
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstType = 1;
        List<CharacteristicData> firstCharacteristicDataList = new ArrayList<>();
        firstCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        ServiceData result1 = new ServiceData(firstUUID, firstType, firstCharacteristicDataList);
        ServiceData result2 = new ServiceData(firstUUID, firstType, firstCharacteristicDataList);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstType = 1;
        List<CharacteristicData> firstCharacteristicDataList = new ArrayList<>();
        firstCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        ServiceData result1 = new ServiceData(firstUUID, firstType, firstCharacteristicDataList);
        ServiceData result2 = new ServiceData(secondUUID, firstType, firstCharacteristicDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstType = 1;
        List<CharacteristicData> firstCharacteristicDataList = new ArrayList<>();
        firstCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        int secondType = 11;

        ServiceData result1 = new ServiceData(firstUUID, firstType, firstCharacteristicDataList);
        ServiceData result2 = new ServiceData(firstUUID, secondType, firstCharacteristicDataList);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstType = 1;
        List<CharacteristicData> firstCharacteristicDataList = new ArrayList<>();
        firstCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 1, 2, new ArrayList<>(), 3, 4, null, 5));

        List<CharacteristicData> secondCharacteristicDataList = new ArrayList<>();
        secondCharacteristicDataList.add(new CharacteristicData(UUID.randomUUID(), 11, 22, new ArrayList<>(), 33, 44, null, 55));

        ServiceData result1 = new ServiceData(firstUUID, firstType, firstCharacteristicDataList);
        ServiceData result2 = new ServiceData(firstUUID, firstType, secondCharacteristicDataList);
        assertNotEquals(result1, result2);
    }

}
