package org.im97mori.ble.service.cts.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.CURRENT_TIME_SERVICE;
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

public class CurrentTimeServiceDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        Gson gson = new Gson();
        CurrentTimeServiceData result2 = gson.fromJson(gson.toJson(result1), CurrentTimeServiceData.class);

        assertEquals(CURRENT_TIME_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.localTimeInformation, result2.localTimeInformation);
        assertEquals(result1.referenceTimeInformation, result2.referenceTimeInformation);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , null
                , referenceTimeInformation);

        Gson gson = new Gson();
        CurrentTimeServiceData result2 = gson.fromJson(gson.toJson(result1), CurrentTimeServiceData.class);

        assertEquals(CURRENT_TIME_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.localTimeInformation, result2.localTimeInformation);
        assertEquals(result1.referenceTimeInformation, result2.referenceTimeInformation);
    }

    @Test
    public void test_constructor_00003() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , null);

        Gson gson = new Gson();
        CurrentTimeServiceData result2 = gson.fromJson(gson.toJson(result1), CurrentTimeServiceData.class);

        assertEquals(CURRENT_TIME_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.localTimeInformation, result2.localTimeInformation);
        assertEquals(result1.referenceTimeInformation, result2.referenceTimeInformation);
    }

    @Test
    public void test_constructor_00101() {
        CurrentTimeServiceData result1 = new CurrentTimeServiceData();

        assertNull(result1.currentTime);
        assertNull(result1.localTimeInformation);
        assertNull(result1.referenceTimeInformation);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        assertArrayEquals(Arrays.asList(currentTime
                , localTimeInformation
                , referenceTimeInformation).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , null
                , referenceTimeInformation);

        assertArrayEquals(Arrays.asList(currentTime
                , referenceTimeInformation).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , null);

        assertArrayEquals(Arrays.asList(currentTime
                , localTimeInformation).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CurrentTimeServiceData result2 = CurrentTimeServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CURRENT_TIME_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.localTimeInformation, result2.localTimeInformation);
        assertEquals(result1.referenceTimeInformation, result2.referenceTimeInformation);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , null
                , referenceTimeInformation);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CurrentTimeServiceData result2 = CurrentTimeServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CURRENT_TIME_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.localTimeInformation, result2.localTimeInformation);
        assertEquals(result1.referenceTimeInformation, result2.referenceTimeInformation);
    }

    @Test
    public void test_parcelable_00003() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , null);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CurrentTimeServiceData result2 = CurrentTimeServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CURRENT_TIME_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.localTimeInformation, result2.localTimeInformation);
        assertEquals(result1.referenceTimeInformation, result2.referenceTimeInformation);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        assertEquals(Objects.hashCode(CURRENT_TIME_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(currentTime)
                        ^ Objects.hashCode(localTimeInformation)
                        ^ Objects.hashCode(referenceTimeInformation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , null
                , referenceTimeInformation);

        assertEquals(Objects.hashCode(CURRENT_TIME_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(currentTime)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(referenceTimeInformation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        CharacteristicData currentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData localTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , null);

        assertEquals(Objects.hashCode(CURRENT_TIME_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(currentTime)
                        ^ Objects.hashCode(localTimeInformation)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocalTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData firstReferenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , firstReferenceTimeInformation);

        CurrentTimeServiceData result2 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , firstReferenceTimeInformation);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocalTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData firstReferenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CharacteristicData secondCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , firstReferenceTimeInformation);

        CurrentTimeServiceData result2 = new CurrentTimeServiceData(secondCurrentTime
                , firstLocalTimeInformation
                , firstReferenceTimeInformation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocalTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData firstReferenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CharacteristicData secondLocalTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , firstReferenceTimeInformation);

        CurrentTimeServiceData result2 = new CurrentTimeServiceData(firstCurrentTime
                , secondLocalTimeInformation
                , firstReferenceTimeInformation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocalTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData firstReferenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        ReferenceTimeInformationCharacteristicData secondReferenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                11
                , 22
                , new byte[]{33, 44, 55, 66});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , firstReferenceTimeInformation);

        CurrentTimeServiceData result2 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , secondReferenceTimeInformation);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData firstCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        ReferenceTimeInformationCharacteristicData firstReferenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(firstCurrentTime
                , null
                , firstReferenceTimeInformation);

        CurrentTimeServiceData result2 = new CurrentTimeServiceData(firstCurrentTime
                , null
                , firstReferenceTimeInformation);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData firstCurrentTime = new CharacteristicData(CURRENT_TIME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstLocalTimeInformation = new CharacteristicData(LOCAL_TIME_INFORMATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CurrentTimeServiceData result1 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , null);

        CurrentTimeServiceData result2 = new CurrentTimeServiceData(firstCurrentTime
                , firstLocalTimeInformation
                , null);
        assertEquals(result1, result2);
    }

}
