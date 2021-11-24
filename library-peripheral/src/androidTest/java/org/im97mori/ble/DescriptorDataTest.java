package org.im97mori.ble;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import android.os.Parcel;

import com.google.gson.Gson;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    public void test_getBytes_00001() {
        byte[] firstData = new byte[0];
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), 1, 2, 3, firstData);
        assertArrayEquals(firstData, descriptorData.data);

        byte[] secondData = new byte[1];
        descriptorData.data = secondData;
        assertEquals(secondData, descriptorData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        byte[] firstData = new byte[0];
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), 1, 2, 3, firstData);
        assertArrayEquals(firstData, descriptorData.data);

        byte[] secondData = new byte[1];
        descriptorData.currentData = secondData;
        assertEquals(secondData, descriptorData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        byte[] firstData = new byte[0];
        DescriptorData descriptorData = new DescriptorData(UUID.randomUUID(), 1, 2, 3, firstData);
        assertArrayEquals(firstData, descriptorData.data);

        descriptorData.temporaryData.put(1, new byte[]{2});
        assertEquals(firstData, descriptorData.getBytes());
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
        assertArrayEquals(result1.currentData, result2.currentData);
        assertEquals(result1.temporaryData.size(), result2.temporaryData.size());
        for (Integer key : result1.temporaryData.keySet()) {
            assertArrayEquals(result1.temporaryData.get(key), result2.temporaryData.get(key));
        }
    }

    @Test
    public void test_parcelable_00002() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, new byte[]{4, 5});
        result1.currentData = new byte[]{6};
        result1.temporaryData.put(7, new byte[]{8});
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        DescriptorData result2 = DescriptorData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.permission, result2.permission);
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertArrayEquals(result1.currentData, result2.currentData);
        assertEquals(result1.temporaryData.size(), result2.temporaryData.size());
        for (Integer key : result1.temporaryData.keySet()) {
            assertArrayEquals(result1.temporaryData.get(key), result2.temporaryData.get(key));
        }
    }

    @Test
    public void test_hashCode_00001() {
        UUID uuid = UUID.randomUUID();
        int permission = 1;
        int responseCode = 2;
        long delay = 3;
        byte[] data = new byte[]{4, 5};

        DescriptorData result1 = new DescriptorData(uuid, permission, responseCode, delay, data);
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ new HashMap<>().hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        UUID uuid = UUID.randomUUID();
        int permission = 1;
        int responseCode = 2;
        long delay = 3;
        byte[] data = new byte[]{4, 5};
        byte[] currentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(8, new byte[]{9});

        DescriptorData result1 = new DescriptorData(uuid, permission, responseCode, delay, data);
        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);
        assertNotEquals(uuid.hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode(currentData)
                        ^ temporaryData.hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        UUID uuid = UUID.randomUUID();
        int permission = 1;
        int responseCode = 2;
        long delay = 3;
        byte[] data = new byte[]{4, 5};
        byte[] currentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(8, new byte[]{9});

        DescriptorData result1 = new DescriptorData(uuid, permission, responseCode, delay, data);
        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);

        int hashCode = 0;
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            hashCode ^= entry.getKey().hashCode();
            hashCode ^= Arrays.hashCode(entry.getValue());
        }
        assertEquals(uuid.hashCode()
                        ^ Integer.valueOf(permission).hashCode()
                        ^ Integer.valueOf(responseCode).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode(data)
                        ^ Arrays.hashCode(currentData)
                        ^ hashCode
                , result1.hashCode());
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

    @Test
    public void test_equals_00101() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        UUID secondUUID = UUID.fromString("00000000-0000-0000-0000-000000000001");

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(secondUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00103() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        int secondPermission = 11;

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, secondPermission, firstResponseCode, firstDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00104() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        int secondResponseCode = 22;

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, secondResponseCode, firstDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00105() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        long secondDelay = 33;

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, secondDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00106() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        byte[] secondData = new byte[]{44, 55};

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, secondData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00107() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        byte[] secondCurrentData = new byte[]{110, 111};

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result2.currentData = secondCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00108() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        HashMap<Integer, byte[]> secondTemporaryData = new HashMap<>();
        secondTemporaryData.put(110, new byte[]{111});

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(secondTemporaryData);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00109() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        assertNotEquals(null, result1);
    }

    @Test
    public void test_equals_00201() {
        UUID firstUUID = UUID.fromString("00000000-0000-0000-0000-000000000000");
        int firstPermission = 1;
        int firstResponseCode = 2;
        long firstDelay = 3;
        byte[] firstData = new byte[]{4, 5};
        byte[] firstCurrentData = new byte[]{6, 7};
        HashMap<Integer, byte[]> firstTemporaryData = new HashMap<>();
        firstTemporaryData.put(8, new byte[]{9});

        DescriptorData result1 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result1.currentData = firstCurrentData;
        result1.temporaryData.putAll(firstTemporaryData);
        DescriptorData result2 = new DescriptorData(firstUUID, firstPermission, firstResponseCode, firstDelay, firstData);
        result2.currentData = firstCurrentData;
        result2.temporaryData.putAll(firstTemporaryData);
        assertEquals(result1, result2);
    }

    @Test
    public void test_isTemporaryDataValid_00001() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00002() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[0]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00003() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[1]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00004() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[0]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00005() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00006() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);
        result1.temporaryData.put(2, new byte[0]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00007() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);
        result1.temporaryData.put(2, new byte[1]);

        assertTrue(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00008() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(1, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00009() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[0]);
        result1.temporaryData.put(1, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00010() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[2]);
        result1.temporaryData.put(1, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_isTemporaryDataValid_00011() {
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, null);
        result1.temporaryData.put(0, new byte[1]);
        result1.temporaryData.put(1, new byte[1]);
        result1.temporaryData.put(3, new byte[0]);

        assertFalse(result1.isTemporaryDataValid());
    }

    @Test
    public void test_executeReliableWrite_00001() {
        byte[] data = new byte[]{0};
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, data);

        assertTrue(result1.executeReliableWrite());
        assertArrayEquals(new byte[0], result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

    @Test
    public void test_executeReliableWrite_00002() {
        byte[] data = new byte[]{0};
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, data);

        byte[] newData = new byte[]{1};
        result1.temporaryData.put(0, newData);
        assertTrue(result1.executeReliableWrite());
        assertArrayEquals(newData, result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

    @Test
    public void test_executeReliableWrite_00003() {
        byte[] data = new byte[]{0};
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, data);

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
        DescriptorData result1 = new DescriptorData(UUID.randomUUID(), 1, 2, 3, data);

        byte[] newData = new byte[]{1};
        result1.temporaryData.put(1, newData);
        assertFalse(result1.executeReliableWrite());
        assertArrayEquals(data, result1.getBytes());
        assertTrue(result1.temporaryData.isEmpty());
    }

}
