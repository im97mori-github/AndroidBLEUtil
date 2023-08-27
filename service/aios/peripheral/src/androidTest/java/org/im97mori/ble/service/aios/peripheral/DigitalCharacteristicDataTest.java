package org.im97mori.ble.service.aios.peripheral;

import static org.im97mori.ble.constants.DescriptorUUID.NUMBER_OF_DIGITALS_DESCRIPTOR;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattDescriptor;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.descriptor.u2909.NumberOfDigitals;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.Arrays;

public class DigitalCharacteristicDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        DigitalCharacteristicData result1 = new DigitalCharacteristicData(1, 2, 3, 4, new byte[]{5});

        Gson gson = new Gson();
        DigitalCharacteristicData result2 = gson.fromJson(gson.toJson(result1), DigitalCharacteristicData.class);

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
    public void test_constructor_00101() {
        Throwable t = null;
        try {
            new DigitalCharacteristicData();
        } catch (Throwable e) {
            t = e;
        }
        assertNull(t);
    }

    @Test
    public void test_setProperty_00001() {
        int firstProperty = 1;
        DigitalCharacteristicData characteristicData = new DigitalCharacteristicData(firstProperty, 2, 3, 4, new byte[]{5});
        assertEquals(firstProperty, characteristicData.property);

        int secondProperty = 2;
        characteristicData.property = secondProperty;
        assertEquals(secondProperty, characteristicData.property);
    }

    @Test
    public void test_setPermission_00001() {
        int firstPermission = 2;
        DigitalCharacteristicData characteristicData = new DigitalCharacteristicData(1, firstPermission, 3, 4, new byte[]{5});
        assertEquals(firstPermission, characteristicData.permission);

        int secondPermission = 22;
        characteristicData.permission = secondPermission;
        assertEquals(secondPermission, characteristicData.permission);
    }

    @Test
    public void test_setResponseCode_00001() {
        int firstResponseCode = 3;
        DigitalCharacteristicData characteristicData = new DigitalCharacteristicData(1, 2, firstResponseCode, 4, new byte[]{5});
        assertEquals(firstResponseCode, characteristicData.responseCode);

        int secondResponseCode = 33;
        characteristicData.responseCode = secondResponseCode;
        assertEquals(secondResponseCode, characteristicData.responseCode);
    }

    @Test
    public void test_setDelay_00001() {
        long firstDelay = 4;
        DigitalCharacteristicData characteristicData = new DigitalCharacteristicData(1, 2, 3, firstDelay, new byte[]{5});
        assertEquals(firstDelay, characteristicData.delay);

        long secondDelay = 44;
        characteristicData.delay = secondDelay;
        assertEquals(secondDelay, characteristicData.delay);
    }

    @Test
    public void test_setData_00001() {
        byte[] firstData = new byte[0];
        DigitalCharacteristicData characteristicData = new DigitalCharacteristicData(1, 2, 3, 4, firstData);
        assertArrayEquals(firstData, characteristicData.data);

        byte[] secondData = new byte[1];
        characteristicData.data = secondData;
        assertArrayEquals(secondData, characteristicData.data);
    }

    @Test
    public void test_executeReliableWrite_00001() {
        DigitalCharacteristicData result1 = new DigitalCharacteristicData(1, 2, 3, 4, new byte[0]);
        result1.descriptorDataList.add(new DescriptorData(NUMBER_OF_DIGITALS_DESCRIPTOR
                , BluetoothGattDescriptor.PERMISSION_READ
                , 0
                , 0
                , new NumberOfDigitals(4).getBytes()));
        byte[] data = new byte[]{5, 6, 7, 8};
        result1.temporaryData.put(0, data);

        assertTrue(result1.executeReliableWrite());
        assertArrayEquals(Arrays.copyOfRange(data, 0, 2), result1.getBytes());
    }

}
