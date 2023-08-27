package org.im97mori.ble.service.tip.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import android.bluetooth.BluetoothGattService;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.service.cts.peripheral.CurrentTimeServiceData;
import org.im97mori.ble.service.cts.peripheral.ReferenceTimeInformationCharacteristicData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class TimeProfileMockDataTest extends TestBase {

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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, referenceTimeUpdate);

        Gson gson = new Gson();
        TimeProfileMockData result2 = gson.fromJson(gson.toJson(result1), TimeProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.nextDstChange, result2.nextDstChange);
        assertEquals(result1.referenceTimeUpdate, result2.referenceTimeUpdate);
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, null, referenceTimeUpdate);

        Gson gson = new Gson();
        TimeProfileMockData result2 = gson.fromJson(gson.toJson(result1), TimeProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.nextDstChange, result2.nextDstChange);
        assertEquals(result1.referenceTimeUpdate, result2.referenceTimeUpdate);
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
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, null);

        Gson gson = new Gson();
        TimeProfileMockData result2 = gson.fromJson(gson.toJson(result1), TimeProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.nextDstChange, result2.nextDstChange);
        assertEquals(result1.referenceTimeUpdate, result2.referenceTimeUpdate);
    }

    @Test
    public void test_constructor_00101() {
        TimeProfileMockData result1 = new TimeProfileMockData();

        assertNull(result1.currentTime);
        assertNull(result1.nextDstChange);
        assertNull(result1.referenceTimeUpdate);
    }

    @Test
    public void test_getServiceDataList_00001() {
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, referenceTimeUpdate);

        List<ServiceData> list = new ArrayList<>();
        list.add(currentTimeService);
        list.add(nextDstChange);
        list.add(referenceTimeUpdate);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, null, referenceTimeUpdate);

        List<ServiceData> list = new ArrayList<>();
        list.add(currentTimeService);
        list.add(referenceTimeUpdate);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00003() {
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(currentTimeService);
        list.add(nextDstChange);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, referenceTimeUpdate);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeProfileMockData result2 = TimeProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.nextDstChange, result2.nextDstChange);
        assertEquals(result1.referenceTimeUpdate, result2.referenceTimeUpdate);
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, null, referenceTimeUpdate);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeProfileMockData result2 = TimeProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.nextDstChange, result2.nextDstChange);
        assertEquals(result1.referenceTimeUpdate, result2.referenceTimeUpdate);
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
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        TimeProfileMockData result2 = TimeProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.currentTime, result2.currentTime);
        assertEquals(result1.nextDstChange, result2.nextDstChange);
        assertEquals(result1.referenceTimeUpdate, result2.referenceTimeUpdate);
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, referenceTimeUpdate);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(currentTimeService)
                        ^ Objects.hashCode(nextDstChange)
                        ^ Objects.hashCode(referenceTimeUpdate)
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

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData referenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, null, referenceTimeUpdate);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(currentTimeService)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(referenceTimeUpdate)
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
        ReferenceTimeInformationCharacteristicData referenceTimeInformation = new ReferenceTimeInformationCharacteristicData(
                1
                , 2
                , new byte[]{3, 4, 5, 6});

        CurrentTimeServiceData currentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData nextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(currentTimeService, nextDstChange, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(currentTimeService)
                        ^ Objects.hashCode(nextDstChange)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
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

        CurrentTimeServiceData firstCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData firstNextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData firstReferenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, firstReferenceTimeUpdate);

        TimeProfileMockData result2 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, firstReferenceTimeUpdate);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
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

        CurrentTimeServiceData firstCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData firstNextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData firstReferenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CurrentTimeServiceData secondCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , null);

        TimeProfileMockData result1 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, firstReferenceTimeUpdate);

        TimeProfileMockData result2 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, secondCurrentTimeService);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
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

        CurrentTimeServiceData firstCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData firstNextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData firstReferenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData secondNextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        TimeProfileMockData result1 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, firstReferenceTimeUpdate);

        TimeProfileMockData result2 = new TimeProfileMockData(firstCurrentTimeService, secondNextDstChange, firstReferenceTimeUpdate);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
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

        CurrentTimeServiceData firstCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData firstNextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData firstReferenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData secondReferenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        TimeProfileMockData result1 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, firstReferenceTimeUpdate);

        TimeProfileMockData result2 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, secondReferenceTimeUpdate);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
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

        CurrentTimeServiceData firstCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData firstReferenceTimeUpdate = new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(firstCurrentTimeService, null, firstReferenceTimeUpdate);

        TimeProfileMockData result2 = new TimeProfileMockData(firstCurrentTimeService, null, firstReferenceTimeUpdate);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
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

        CurrentTimeServiceData firstCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , referenceTimeInformation);

        ServiceData firstNextDstChange = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        TimeProfileMockData result1 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, null);

        TimeProfileMockData result2 = new TimeProfileMockData(firstCurrentTimeService, firstNextDstChange, null);

        assertEquals(result1, result2);
    }

}
