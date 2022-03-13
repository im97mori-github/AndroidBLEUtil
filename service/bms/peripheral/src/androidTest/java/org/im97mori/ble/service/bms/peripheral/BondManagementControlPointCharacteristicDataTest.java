package org.im97mori.ble.service.bms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class BondManagementControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        Gson gson = new Gson();
        BondManagementControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), BondManagementControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrLeResponseCode, result2.deleteBondOfRequestingDeviceBrEdrLeResponseCode);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode, result2.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrResponseCode, result2.deleteBondOfRequestingDeviceBrEdrResponseCode);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrAuthorizationCode, result2.deleteBondOfRequestingDeviceBrEdrAuthorizationCode);
        assertEquals(result1.deleteBondOfRequestingDeviceLeResponseCode, result2.deleteBondOfRequestingDeviceLeResponseCode);
        assertEquals(result1.deleteBondOfRequestingDeviceLeAuthorizationCode, result2.deleteBondOfRequestingDeviceLeAuthorizationCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrLeResponseCode, result2.deleteAllBondsOnServerBrEdrLeResponseCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrLeAuthorizationCode, result2.deleteAllBondsOnServerBrEdrLeAuthorizationCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrResponseCode, result2.deleteAllBondsOnServerBrEdrResponseCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrAuthorizationCode, result2.deleteAllBondsOnServerBrEdrAuthorizationCode);
        assertEquals(result1.deleteAllBondsOnServerLeResponseCode, result2.deleteAllBondsOnServerLeResponseCode);
        assertEquals(result1.deleteAllBondsOnServerLeAuthorizationCode, result2.deleteAllBondsOnServerLeAuthorizationCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode, result2.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode, result2.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrResponseCode, result2.deleteAllButTheActiveBondOnServerBrEdrResponseCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode, result2.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerLeResponseCode, result2.deleteAllButTheActiveBondOnServerLeResponseCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerLeAuthorizationCode, result2.deleteAllButTheActiveBondOnServerLeAuthorizationCode);
    }

    @Test
    public void test_constructor_00101() {
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData();

        assertEquals(0, result1.deleteBondOfRequestingDeviceBrEdrLeResponseCode);
        assertNull(result1.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);
        assertEquals(0, result1.deleteBondOfRequestingDeviceBrEdrResponseCode);
        assertNull(result1.deleteBondOfRequestingDeviceBrEdrAuthorizationCode);
        assertEquals(0, result1.deleteBondOfRequestingDeviceLeResponseCode);
        assertNull(result1.deleteBondOfRequestingDeviceLeAuthorizationCode);
        assertEquals(0, result1.deleteAllBondsOnServerBrEdrLeResponseCode);
        assertNull(result1.deleteAllBondsOnServerBrEdrLeAuthorizationCode);
        assertEquals(0, result1.deleteAllBondsOnServerBrEdrResponseCode);
        assertNull(result1.deleteAllBondsOnServerBrEdrAuthorizationCode);
        assertEquals(0, result1.deleteAllBondsOnServerLeResponseCode);
        assertNull(result1.deleteAllBondsOnServerLeAuthorizationCode);
        assertEquals(0, result1.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);
        assertNull(result1.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);
        assertEquals(0, result1.deleteAllButTheActiveBondOnServerBrEdrResponseCode);
        assertNull(result1.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);
        assertEquals(0, result1.deleteAllButTheActiveBondOnServerLeResponseCode);
        assertNull(result1.deleteAllButTheActiveBondOnServerLeAuthorizationCode);
    }

    @Test
    public void test_setDeleteBondOfRequestingDeviceBrEdrLeResponseCode_00001() {
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode, result1.deleteBondOfRequestingDeviceBrEdrLeResponseCode);

        int secondDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 11;
        result1.deleteBondOfRequestingDeviceBrEdrLeResponseCode = secondDeleteBondOfRequestingDeviceBrEdrLeResponseCode;
        assertEquals(secondDeleteBondOfRequestingDeviceBrEdrLeResponseCode, result1.deleteBondOfRequestingDeviceBrEdrLeResponseCode);
    }

    @Test
    public void test_setDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode_00001() {
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode, result1.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);

        String secondDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "22";
        result1.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = secondDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode;
        assertEquals(secondDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode, result1.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);
    }

    @Test
    public void test_setDeleteBondOfRequestingDeviceBrEdrResponseCode_00001() {
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteBondOfRequestingDeviceBrEdrResponseCode, result1.deleteBondOfRequestingDeviceBrEdrResponseCode);

        int secondDeleteBondOfRequestingDeviceBrEdrResponseCode = 33;
        result1.deleteBondOfRequestingDeviceBrEdrResponseCode = secondDeleteBondOfRequestingDeviceBrEdrResponseCode;
        assertEquals(secondDeleteBondOfRequestingDeviceBrEdrResponseCode, result1.deleteBondOfRequestingDeviceBrEdrResponseCode);
    }

    @Test
    public void test_setDeleteBondOfRequestingDeviceBrEdrAuthorizationCode_00001() {
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode, result1.deleteBondOfRequestingDeviceBrEdrAuthorizationCode);

        String secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "44";
        result1.deleteBondOfRequestingDeviceBrEdrAuthorizationCode = secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode;
        assertEquals(secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode, result1.deleteBondOfRequestingDeviceBrEdrAuthorizationCode);
    }

    @Test
    public void test_setDeleteBondOfRequestingDeviceLeResponseCode_00001() {
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteBondOfRequestingDeviceLeResponseCode, result1.deleteBondOfRequestingDeviceLeResponseCode);

        int secondDeleteBondOfRequestingDeviceLeResponseCode = 55;
        result1.deleteBondOfRequestingDeviceLeResponseCode = secondDeleteBondOfRequestingDeviceLeResponseCode;
        assertEquals(secondDeleteBondOfRequestingDeviceLeResponseCode, result1.deleteBondOfRequestingDeviceLeResponseCode);
    }

    @Test
    public void test_setDeleteBondOfRequestingDeviceLeAuthorizationCode_00001() {
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteBondOfRequestingDeviceLeAuthorizationCode, result1.deleteBondOfRequestingDeviceLeAuthorizationCode);

        String secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "66";
        result1.deleteBondOfRequestingDeviceLeAuthorizationCode = secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode;
        assertEquals(secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode, result1.deleteBondOfRequestingDeviceLeAuthorizationCode);
    }

    @Test
    public void test_setDeleteAllBondsOnServerBrEdrLeResponseCode_00001() {
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllBondsOnServerBrEdrLeResponseCode, result1.deleteAllBondsOnServerBrEdrLeResponseCode);

        int secondDeleteAllBondsOnServerBrEdrLeResponseCode = 77;
        result1.deleteAllBondsOnServerBrEdrLeResponseCode = secondDeleteAllBondsOnServerBrEdrLeResponseCode;
        assertEquals(secondDeleteAllBondsOnServerBrEdrLeResponseCode, result1.deleteAllBondsOnServerBrEdrLeResponseCode);
    }

    @Test
    public void test_setDeleteAllBondsOnServerBrEdrLeAuthorizationCode_00001() {
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode, result1.deleteAllBondsOnServerBrEdrLeAuthorizationCode);

        String secondDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "88";
        result1.deleteAllBondsOnServerBrEdrLeAuthorizationCode = secondDeleteAllBondsOnServerBrEdrLeAuthorizationCode;
        assertEquals(secondDeleteAllBondsOnServerBrEdrLeAuthorizationCode, result1.deleteAllBondsOnServerBrEdrLeAuthorizationCode);
    }

    @Test
    public void test_setDeleteAllBondsOnServerBrEdrResponseCode_00001() {
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllBondsOnServerBrEdrResponseCode, result1.deleteAllBondsOnServerBrEdrResponseCode);

        int secondDeleteAllBondsOnServerBrEdrResponseCode = 99;
        result1.deleteAllBondsOnServerBrEdrResponseCode = secondDeleteAllBondsOnServerBrEdrResponseCode;
        assertEquals(secondDeleteAllBondsOnServerBrEdrResponseCode, result1.deleteAllBondsOnServerBrEdrResponseCode);
    }

    @Test
    public void test_setDeleteAllBondsOnServerBrEdrAuthorizationCode_00001() {
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "10";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllBondsOnServerBrEdrAuthorizationCode, result1.deleteAllBondsOnServerBrEdrAuthorizationCode);

        String secondDeleteAllBondsOnServerBrEdrAuthorizationCode = "111";
        result1.deleteAllBondsOnServerBrEdrAuthorizationCode = secondDeleteAllBondsOnServerBrEdrAuthorizationCode;
        assertEquals(secondDeleteAllBondsOnServerBrEdrAuthorizationCode, result1.deleteAllBondsOnServerBrEdrAuthorizationCode);
    }

    @Test
    public void test_setDeleteAllBondsOnServerLeResponseCode_00001() {
        int firstDeleteAllBondsOnServerLeResponseCode = 11;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , firstDeleteAllBondsOnServerLeResponseCode
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllBondsOnServerLeResponseCode, result1.deleteAllBondsOnServerLeResponseCode);

        int secondDeleteAllBondsOnServerLeResponseCode = 112;
        result1.deleteAllBondsOnServerLeResponseCode = secondDeleteAllBondsOnServerLeResponseCode;
        assertEquals(secondDeleteAllBondsOnServerLeResponseCode, result1.deleteAllBondsOnServerLeResponseCode);
    }

    @Test
    public void test_setDeleteAllBondsOnServerLeAuthorizationCode_00001() {
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "12";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllBondsOnServerLeAuthorizationCode, result1.deleteAllBondsOnServerLeAuthorizationCode);

        String secondDeleteAllBondsOnServerLeAuthorizationCode = "113";
        result1.deleteAllBondsOnServerLeAuthorizationCode = secondDeleteAllBondsOnServerLeAuthorizationCode;
        assertEquals(secondDeleteAllBondsOnServerLeAuthorizationCode, result1.deleteAllBondsOnServerLeAuthorizationCode);
    }

    @Test
    public void test_setDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode_00001() {
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 13;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode, result1.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);

        int secondDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 114;
        result1.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode = secondDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode;
        assertEquals(secondDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode, result1.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);
    }

    @Test
    public void test_setDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode_00001() {
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "14";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , 16
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode, result1.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);

        String secondDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "115";
        result1.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = secondDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode;
        assertEquals(secondDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode, result1.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);
    }

    @Test
    public void test_setDeleteAllButTheActiveBondOnServerBrEdrResponseCode_00001() {
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 15;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , "17"
                , 18
                , "19");

        assertEquals(firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode, result1.deleteAllButTheActiveBondOnServerBrEdrResponseCode);

        int secondDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 116;
        result1.deleteAllButTheActiveBondOnServerBrEdrResponseCode = secondDeleteAllButTheActiveBondOnServerBrEdrResponseCode;
        assertEquals(secondDeleteAllButTheActiveBondOnServerBrEdrResponseCode, result1.deleteAllButTheActiveBondOnServerBrEdrResponseCode);
    }

    @Test
    public void test_setDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode_00001() {
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "16";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , 18
                , "19");

        assertEquals(firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode, result1.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);

        String secondDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "117";
        result1.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = secondDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode;
        assertEquals(secondDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode, result1.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);
    }

    @Test
    public void test_setDeleteAllButTheActiveBondOnServerLeResponseCode_00001() {
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 17;
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , "19");

        assertEquals(firstDeleteAllButTheActiveBondOnServerLeResponseCode, result1.deleteAllButTheActiveBondOnServerLeResponseCode);

        int secondDeleteAllButTheActiveBondOnServerLeResponseCode = 118;
        result1.deleteAllButTheActiveBondOnServerLeResponseCode = secondDeleteAllButTheActiveBondOnServerLeResponseCode;
        assertEquals(secondDeleteAllButTheActiveBondOnServerLeResponseCode, result1.deleteAllButTheActiveBondOnServerLeResponseCode);
    }

    @Test
    public void test_setDeleteAllButTheActiveBondOnServerLeAuthorizationCode_00001() {
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "18";
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertEquals(firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode, result1.deleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "119";
        result1.deleteAllButTheActiveBondOnServerLeAuthorizationCode = secondDeleteAllButTheActiveBondOnServerLeAuthorizationCode;
        assertEquals(secondDeleteAllButTheActiveBondOnServerLeAuthorizationCode, result1.deleteAllButTheActiveBondOnServerLeAuthorizationCode);
    }

    @Test
    public void test_parcelable_00001() {
        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(0
                , 1
                , "2"
                , 3
                , "4"
                , 5
                , "6"
                , 7
                , "8"
                , 9
                , "11"
                , 12
                , "13"
                , 14
                , "15"
                , 16
                , "17"
                , 18
                , "19");

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementControlPointCharacteristicData result2 = BondManagementControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

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
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrLeResponseCode, result2.deleteBondOfRequestingDeviceBrEdrLeResponseCode);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode, result2.deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrResponseCode, result2.deleteBondOfRequestingDeviceBrEdrResponseCode);
        assertEquals(result1.deleteBondOfRequestingDeviceBrEdrAuthorizationCode, result2.deleteBondOfRequestingDeviceBrEdrAuthorizationCode);
        assertEquals(result1.deleteBondOfRequestingDeviceLeResponseCode, result2.deleteBondOfRequestingDeviceLeResponseCode);
        assertEquals(result1.deleteBondOfRequestingDeviceLeAuthorizationCode, result2.deleteBondOfRequestingDeviceLeAuthorizationCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrLeResponseCode, result2.deleteAllBondsOnServerBrEdrLeResponseCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrLeAuthorizationCode, result2.deleteAllBondsOnServerBrEdrLeAuthorizationCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrResponseCode, result2.deleteAllBondsOnServerBrEdrResponseCode);
        assertEquals(result1.deleteAllBondsOnServerBrEdrAuthorizationCode, result2.deleteAllBondsOnServerBrEdrAuthorizationCode);
        assertEquals(result1.deleteAllBondsOnServerLeResponseCode, result2.deleteAllBondsOnServerLeResponseCode);
        assertEquals(result1.deleteAllBondsOnServerLeAuthorizationCode, result2.deleteAllBondsOnServerLeAuthorizationCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode, result2.deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode, result2.deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrResponseCode, result2.deleteAllButTheActiveBondOnServerBrEdrResponseCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode, result2.deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerLeResponseCode, result2.deleteAllButTheActiveBondOnServerLeResponseCode);
        assertEquals(result1.deleteAllButTheActiveBondOnServerLeAuthorizationCode, result2.deleteAllButTheActiveBondOnServerLeAuthorizationCode);
    }

    @Test
    public void test_hashCode_00001() {
        long delay = 0;
        int deleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int deleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String deleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int deleteBondOfRequestingDeviceLeResponseCode = 5;
        String deleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int deleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String deleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int deleteAllBondsOnServerBrEdrResponseCode = 9;
        String deleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int deleteAllBondsOnServerLeResponseCode = 12;
        String deleteAllBondsOnServerLeAuthorizationCode = "13";
        int deleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int deleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int deleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String deleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(delay
                , deleteBondOfRequestingDeviceBrEdrLeResponseCode
                , deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , deleteBondOfRequestingDeviceBrEdrResponseCode
                , deleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , deleteBondOfRequestingDeviceLeResponseCode
                , deleteBondOfRequestingDeviceLeAuthorizationCode
                , deleteAllBondsOnServerBrEdrLeResponseCode
                , deleteAllBondsOnServerBrEdrLeAuthorizationCode
                , deleteAllBondsOnServerBrEdrResponseCode
                , deleteAllBondsOnServerBrEdrAuthorizationCode
                , deleteAllBondsOnServerLeResponseCode
                , deleteAllBondsOnServerLeAuthorizationCode
                , deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , deleteAllButTheActiveBondOnServerBrEdrResponseCode
                , deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , deleteAllButTheActiveBondOnServerLeResponseCode
                , deleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertEquals(BOND_MANAGEMENT_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(Collections.<DescriptorData>emptyList().toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(deleteBondOfRequestingDeviceBrEdrLeResponseCode).hashCode()
                        ^ deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteBondOfRequestingDeviceBrEdrResponseCode).hashCode()
                        ^ deleteBondOfRequestingDeviceBrEdrAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteBondOfRequestingDeviceLeResponseCode).hashCode()
                        ^ deleteBondOfRequestingDeviceLeAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteAllBondsOnServerBrEdrLeResponseCode).hashCode()
                        ^ deleteAllBondsOnServerBrEdrLeAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteAllBondsOnServerBrEdrResponseCode).hashCode()
                        ^ deleteAllBondsOnServerBrEdrAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteAllBondsOnServerLeResponseCode).hashCode()
                        ^ deleteAllBondsOnServerLeAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteAllButTheActiveBondOnServerBrEdrLeResponseCode).hashCode()
                        ^ deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteAllButTheActiveBondOnServerBrEdrResponseCode).hashCode()
                        ^ deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode.hashCode()
                        ^ Integer.valueOf(deleteAllButTheActiveBondOnServerLeResponseCode).hashCode()
                        ^ deleteAllButTheActiveBondOnServerLeAuthorizationCode.hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        long secondDelay = -1;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(secondDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 11;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , secondDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "22";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , secondDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteBondOfRequestingDeviceBrEdrResponseCode = 33;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , secondDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "44";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , secondDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteBondOfRequestingDeviceLeResponseCode = 55;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , secondDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteBondOfRequestingDeviceLeAuthorizationCode = "66";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , secondDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteAllBondsOnServerBrEdrLeResponseCode = 77;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , secondDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "88";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , secondDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteAllBondsOnServerBrEdrResponseCode = 99;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , secondDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllBondsOnServerBrEdrAuthorizationCode = "111";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , secondDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteAllBondsOnServerLeResponseCode = 112;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , secondDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllBondsOnServerLeAuthorizationCode = "113";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , secondDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 114;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , secondDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "115";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , secondDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 116;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , secondDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "117";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , secondDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        int secondDeleteAllButTheActiveBondOnServerLeResponseCode = 118;

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , secondDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00020() {
        long firstDelay = 0;
        int firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        String firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        int firstDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        String firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        int firstDeleteBondOfRequestingDeviceLeResponseCode = 5;
        String firstDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        int firstDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        String firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        int firstDeleteAllBondsOnServerBrEdrResponseCode = 9;
        String firstDeleteAllBondsOnServerBrEdrAuthorizationCode = "11";
        int firstDeleteAllBondsOnServerLeResponseCode = 12;
        String firstDeleteAllBondsOnServerLeAuthorizationCode = "13";
        int firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 14;
        String firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "15";
        int firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 16;
        String firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "17";
        int firstDeleteAllButTheActiveBondOnServerLeResponseCode = 18;
        String firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "19";

        BondManagementControlPointCharacteristicData result1 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        String secondDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "119";

        BondManagementControlPointCharacteristicData result2 = new BondManagementControlPointCharacteristicData(firstDelay
                , firstDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , firstDeleteBondOfRequestingDeviceBrEdrResponseCode
                , firstDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , firstDeleteBondOfRequestingDeviceLeResponseCode
                , firstDeleteBondOfRequestingDeviceLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrLeResponseCode
                , firstDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllBondsOnServerBrEdrResponseCode
                , firstDeleteAllBondsOnServerBrEdrAuthorizationCode
                , firstDeleteAllBondsOnServerLeResponseCode
                , firstDeleteAllBondsOnServerLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , firstDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , firstDeleteAllButTheActiveBondOnServerLeResponseCode
                , secondDeleteAllButTheActiveBondOnServerLeAuthorizationCode);

        assertNotEquals(result1, result2);
    }

}
