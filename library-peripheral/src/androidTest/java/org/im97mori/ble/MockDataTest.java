package org.im97mori.ble;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class MockDataTest {

    @Test
    public void test_constructor_00001() {
        MockData result1 = new MockData(new ArrayList<ServiceData>());

        Gson gson = new Gson();
        MockData result2 = gson.fromJson(gson.toJson(result1), MockData.class);

        assertNotNull(result2.serviceDataList);
        assertTrue(result2.serviceDataList.isEmpty());
    }

    @Test
    public void test_constructor_00002() {
        List<ServiceData> serviceDataList = new ArrayList<>();
        serviceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<CharacteristicData>()));

        MockData result1 = new MockData(serviceDataList);

        Gson gson = new Gson();
        MockData result2 = gson.fromJson(gson.toJson(result1), MockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
    }

    @Test
    public void test_setServiceDataList_00001() {
        List<ServiceData> firstServiceDataList = new ArrayList<>();
        firstServiceDataList.add(new ServiceData(UUID.randomUUID(), 1, new ArrayList<CharacteristicData>()));

        MockData mockData = new MockData(firstServiceDataList);
        assertArrayEquals(firstServiceDataList.toArray(), mockData.serviceDataList.toArray());

        List<ServiceData> secondServiceDataList = new ArrayList<>();
        secondServiceDataList.add(new ServiceData(UUID.randomUUID(), 11, new ArrayList<CharacteristicData>()));
        mockData.serviceDataList = secondServiceDataList;
        assertArrayEquals(secondServiceDataList.toArray(), mockData.serviceDataList.toArray());
    }

}
