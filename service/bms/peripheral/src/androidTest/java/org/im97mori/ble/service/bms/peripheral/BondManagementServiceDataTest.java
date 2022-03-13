package org.im97mori.ble.service.bms.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.BOND_MANAGEMENT_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.BOND_MANAGEMENT_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class BondManagementServiceDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        BondManagementServiceData result1 = new BondManagementServiceData(bondManagementFeature
                , bondManagementControlPoint);

        Gson gson = new Gson();
        BondManagementServiceData result2 = gson.fromJson(gson.toJson(result1), BondManagementServiceData.class);

        assertEquals(BOND_MANAGEMENT_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.bondManagementFeature, result2.bondManagementFeature);
        assertEquals(result1.bondManagementControlPoint, result2.bondManagementControlPoint);
    }

    @Test
    public void test_constructor_00101() {
        BondManagementServiceData result1 = new BondManagementServiceData();

        assertNull(result1.bondManagementFeature);
        assertNull(result1.bondManagementControlPoint);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        BondManagementServiceData result1 = new BondManagementServiceData(bondManagementFeature
                , bondManagementControlPoint);

        assertArrayEquals(Arrays.asList(bondManagementFeature
                , bondManagementControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        BondManagementServiceData result1 = new BondManagementServiceData(bondManagementFeature
                , bondManagementControlPoint);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        BondManagementServiceData result2 = BondManagementServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(BOND_MANAGEMENT_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertArrayEquals(result1.bondManagementFeature.getBytes(), result2.bondManagementFeature.getBytes());
        assertArrayEquals(result1.bondManagementControlPoint.getBytes(), result2.bondManagementControlPoint.getBytes());
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData bondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData bondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        BondManagementServiceData result1 = new BondManagementServiceData(bondManagementFeature
                , bondManagementControlPoint);

        assertEquals(Objects.hashCode(BOND_MANAGEMENT_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(bondManagementFeature)
                        ^ Objects.hashCode(bondManagementControlPoint)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstBondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData firstBondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        BondManagementServiceData result1 = new BondManagementServiceData(firstBondManagementFeature
                , firstBondManagementControlPoint);

        BondManagementServiceData result2 = new BondManagementServiceData(firstBondManagementFeature
                , firstBondManagementControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstBondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData firstBondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        CharacteristicData secondBondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        BondManagementServiceData result1 = new BondManagementServiceData(firstBondManagementFeature
                , firstBondManagementControlPoint);

        BondManagementServiceData result2 = new BondManagementServiceData(secondBondManagementFeature
                , firstBondManagementControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstBondManagementFeature = new CharacteristicData(BOND_MANAGEMENT_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        BondManagementControlPointCharacteristicData firstBondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
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

        BondManagementControlPointCharacteristicData secondBondManagementControlPoint = new BondManagementControlPointCharacteristicData(0
                , 11
                , "22"
                , 33
                , "44"
                , 55
                , "66"
                , 77
                , "88"
                , 99
                , "111"
                , 112
                , "113"
                , 114
                , "115"
                , 116
                , "117"
                , 118
                , "119");

        BondManagementServiceData result1 = new BondManagementServiceData(firstBondManagementFeature
                , firstBondManagementControlPoint);

        BondManagementServiceData result2 = new BondManagementServiceData(firstBondManagementFeature
                , secondBondManagementControlPoint);
        assertNotEquals(result1, result2);
    }

}
