package org.im97mori.ble;

import com.google.gson.Gson;

import org.im97mori.ble.test.TestBase;
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

import android.os.Parcel;

public class MockDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        MockData result1 = new MockData(new ArrayList<>());

        Gson gson = new Gson();
        MockData result2 = gson.fromJson(gson.toJson(result1), MockData.class);

        assertNotNull(result2.serviceDataList);
        assertTrue(result2.serviceDataList.isEmpty());
    }

    @Test
    public void test_constructor_00002() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<>()));

        MockData result1 = new MockData(serviceDataList);

        Gson gson = new Gson();
        MockData result2 = gson.fromJson(gson.toJson(result1), MockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
    }

    @Test
    public void test_constructor_00101() {
        MockData result1 = new MockData();

        assertNull(result1.serviceDataList);
    }

    @Test
    public void test_getServiceDataList_00001() {
        List<ServiceData> firstServiceDataList = new ArrayList<>();
        firstServiceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<>()));

        MockData mockData = new MockData(firstServiceDataList);
        mockData.serviceDataList = firstServiceDataList;
        assertArrayEquals(firstServiceDataList.toArray(), mockData.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<>()));
        MockData result1 = new MockData(serviceDataList);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        MockData result2 = MockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        result1.serviceDataList.clear();
        assertNotEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
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
        List<ServiceData> firstServiceDataList = new ArrayList<>();
        firstServiceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<>()));

        MockData result1 = new MockData(firstServiceDataList);
        MockData result2 = new MockData(firstServiceDataList);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        List<ServiceData> firstServiceDataList = new ArrayList<>();
        firstServiceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<>()));

        List<ServiceData> secondServiceDataList = new ArrayList<>();
        secondServiceDataList.add(new ServiceData(UUID.randomUUID(), 11, new ArrayList<>()));

        MockData result1 = new MockData(firstServiceDataList);
        MockData result2 = new MockData(secondServiceDataList);
        assertNotEquals(result1, result2);
    }

}
