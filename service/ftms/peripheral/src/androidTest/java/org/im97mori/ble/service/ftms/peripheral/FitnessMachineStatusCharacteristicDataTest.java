package org.im97mori.ble.service.ftms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_STATUS_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FitnessMachineStatusCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(new ArrayList<DescriptorData>()
                , 1);

        Gson gson = new Gson();
        FitnessMachineStatusCharacteristicData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineStatusCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.spinDownStatusValue, result2.spinDownStatusValue);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(descriptorDataList
                , 1);

        Gson gson = new Gson();
        FitnessMachineStatusCharacteristicData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineStatusCharacteristicData.class);

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
        assertEquals(result1.spinDownStatusValue, result2.spinDownStatusValue);
    }

    @Test
    public void test_setSpinDownStatusValue_00001() {
        int firstSpinDownStatusValue = 1;
        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(new ArrayList<DescriptorData>()
                , firstSpinDownStatusValue);

        assertEquals(firstSpinDownStatusValue, result1.spinDownStatusValue);

        int secondSpinDownStatusValue = 11;
        result1.spinDownStatusValue = secondSpinDownStatusValue;
        assertEquals(secondSpinDownStatusValue, result1.spinDownStatusValue);
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(descriptorDataList
                , 1);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusCharacteristicData result2 = FitnessMachineStatusCharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.spinDownStatusValue, result2.spinDownStatusValue);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(descriptorDataList
                , 1);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusCharacteristicData result2 = FitnessMachineStatusCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.spinDownStatusValue, result2.spinDownStatusValue);
    }

    @Test
    public void test_hashCode_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        int spinDownStatusValue = 1;

        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(descriptorDataList
                , spinDownStatusValue);

        assertEquals(FITNESS_MACHINE_STATUS_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_NOTIFY).hashCode()
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(spinDownStatusValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        int spinDownStatusValue = 1;
        byte[] currentData = new byte[]{6};
        byte[] temporaryData = new byte[]{7};

        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(descriptorDataList
                , spinDownStatusValue);

        result1.currentData = currentData;
        result1.temporaryData = temporaryData;

        assertEquals(FITNESS_MACHINE_STATUS_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_NOTIFY).hashCode()
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ Arrays.hashCode(temporaryData)
                        ^ Integer.valueOf(spinDownStatusValue).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        int firstSpinDownStatusValue = 1;

        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(firstDescriptorDataList
                , firstSpinDownStatusValue);

        FitnessMachineStatusCharacteristicData result2 = new FitnessMachineStatusCharacteristicData(firstDescriptorDataList
                , firstSpinDownStatusValue);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        int firstSpinDownStatusValue = 1;

        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(firstDescriptorDataList
                , firstSpinDownStatusValue);

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 6, 7, 8, new byte[]{9}));

        FitnessMachineStatusCharacteristicData result2 = new FitnessMachineStatusCharacteristicData(secondDescriptorDataList
                , firstSpinDownStatusValue);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 2, 3, 4, new byte[]{5}));
        int firstSpinDownStatusValue = 1;

        FitnessMachineStatusCharacteristicData result1 = new FitnessMachineStatusCharacteristicData(firstDescriptorDataList
                , firstSpinDownStatusValue);

        int secondSpinDownStatusValue = 101;

        FitnessMachineStatusCharacteristicData result2 = new FitnessMachineStatusCharacteristicData(firstDescriptorDataList
                , secondSpinDownStatusValue);

        assertNotEquals(result1, result2);
    }

}
