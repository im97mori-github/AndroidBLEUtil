package org.im97mori.ble;

import android.os.Parcel;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.Arrays;
import java.util.UUID;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class DescriptorDataTest {

    @Test
    public void test_constructor_00001() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);

        Gson gson = new Gson();
        DescriptorData result2 = gson.fromJson(gson.toJson(result1), DescriptorData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.permission, result2.permission);
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
    }

    @Test
    public void test_constructor_00002() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, new byte[]{4, 5});

        Gson gson = new Gson();
        DescriptorData result2 = gson.fromJson(gson.toJson(result1), DescriptorData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.permission, result2.permission);
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
    }

    @Test
    public void test_setUuid_00001() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        DescriptorData descriptorData = new DescriptorData(firstUUID, 1, 2, 3, null);
        assertEquals(firstUUID, descriptorData.uuid);

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");
        descriptorData.uuid = secondUUID;
        assertEquals(secondUUID, descriptorData.uuid);
    }

    @Test
    public void test_setPermission_00001() {
        int firstPermisttion = 1;
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), firstPermisttion, 2, 3, null);
        assertEquals(firstPermisttion, descriptorData.permission);

        int secondPermisttion = 11;
        descriptorData.permission = secondPermisttion;
        assertEquals(secondPermisttion, descriptorData.permission);
    }

    @Test
    public void test_setResponseCode_00001() {
        int firstResponseCode = 2;
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), 1, firstResponseCode, 3, null);
        assertEquals(firstResponseCode, descriptorData.responseCode);

        int secondResponseCode = 22;
        descriptorData.responseCode = secondResponseCode;
        assertEquals(secondResponseCode, descriptorData.responseCode);
    }

    @Test
    public void test_setDelay_00001() {
        long firstDelay = 3;
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), 1, 2, firstDelay, null);
        assertEquals(firstDelay, descriptorData.delay);

        long secondDelay = 33;
        descriptorData.delay = secondDelay;
        assertEquals(secondDelay, descriptorData.delay);
    }

    @Test
    public void test_setData_00001() {
        byte[] firstData = new byte[0];
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), 1, 2, 3, firstData);
        assertArrayEquals(firstData, descriptorData.data);

        byte[] secondData = new byte[1];
        descriptorData.data = secondData;
        assertEquals(secondData, descriptorData.data);
    }

    @Test
    public void test_parcelable_00001() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, new byte[]{4, 5});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorData result2 = DescriptorData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.permission, result2.permission);
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
    }

    @Test
    public void test_hashCode_00001() {
        UUID uuid = UUID.randomUUID();
        int permission = 1;
        int responseCode = 2;
        long delay = 3;
        byte[] data = new byte[]{4, 5};

        DescriptorData result1 = new DescriptorData(uuid, permission, responseCode, delay, data);
        assertEquals(uuid.hashCode() ^ Integer.valueOf(permission).hashCode() ^ Integer.valueOf(responseCode).hashCode() ^ Long.valueOf(delay).hashCode() ^ Arrays.hashCode(data), result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        DescriptorData result2 = new DescriptorData(secondUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        int secondPermission = 11;

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        DescriptorData result2 = new DescriptorData(firstUUID, secondPermission, firstResponseCode, firstDelay, firstData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        int secondResponseCode = 22;

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, secondResponseCode, firstDelay, firstData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        long secondDelay = 33;

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, secondDelay, firstData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        byte[] secondData = new byte[]{44, 55};

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, secondData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        assertNotEquals(null, result1);
    }


}
