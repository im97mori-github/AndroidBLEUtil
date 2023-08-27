package org.im97mori.ble.profile.wsp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TIME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.DATABASE_CHANGE_INCREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FIRST_NAME_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCAL_TIME_INFORMATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.USER_INDEX_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.WEIGHT_SCALE_SERVICE;
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
import org.im97mori.ble.service.uds.peripheral.UDSCharacteristicData;
import org.im97mori.ble.service.uds.peripheral.UserControlPointCharacteristicData;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class WeightScaleProfileMockDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, currentTimeService);

        Gson gson = new Gson();
        WeightScaleProfileMockData result2 = gson.fromJson(gson.toJson(result1), WeightScaleProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_constructor_00002() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, null, userData, batteryList, currentTimeService);

        Gson gson = new Gson();
        WeightScaleProfileMockData result2 = gson.fromJson(gson.toJson(result1), WeightScaleProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_constructor_00003() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, null, batteryList, currentTimeService);

        Gson gson = new Gson();
        WeightScaleProfileMockData result2 = gson.fromJson(gson.toJson(result1), WeightScaleProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_constructor_00004() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, null, currentTimeService);

        Gson gson = new Gson();
        WeightScaleProfileMockData result2 = gson.fromJson(gson.toJson(result1), WeightScaleProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_constructor_00005() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, null);

        Gson gson = new Gson();
        WeightScaleProfileMockData result2 = gson.fromJson(gson.toJson(result1), WeightScaleProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_constructor_00101() {
        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData();

        assertNull(result1.weightScale);
        assertNull(result1.deviceInformation);
        assertNull(result1.userData);
        assertNull(result1.batteryList);
        assertNull(result1.currentTime);
    }

    @Test
    public void test_getServiceDataList_00001() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, currentTimeService);

        List<ServiceData> list = new ArrayList<>();
        list.add(weightScale);
        list.add(deviceInformation);
        list.add(userData);
        list.addAll(batteryList);
        list.add(currentTimeService);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, null, userData, batteryList, currentTimeService);

        List<ServiceData> list = new ArrayList<>();
        list.add(weightScale);
        list.add(userData);
        list.addAll(batteryList);
        list.add(currentTimeService);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00003() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, null, batteryList, currentTimeService);

        List<ServiceData> list = new ArrayList<>();
        list.add(weightScale);
        list.add(deviceInformation);
        list.addAll(batteryList);
        list.add(currentTimeService);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00004() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, null, currentTimeService);

        List<ServiceData> list = new ArrayList<>();
        list.add(weightScale);
        list.add(deviceInformation);
        list.add(userData);
        list.add(currentTimeService);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00005() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(weightScale);
        list.add(deviceInformation);
        list.add(userData);
        list.addAll(batteryList);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, currentTimeService);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightScaleProfileMockData result2 = WeightScaleProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_parcelable_00002() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, null, userData, batteryList, currentTimeService);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightScaleProfileMockData result2 = WeightScaleProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_parcelable_00003() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, null, batteryList, currentTimeService);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightScaleProfileMockData result2 = WeightScaleProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_parcelable_00004() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, null, currentTimeService);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightScaleProfileMockData result2 = WeightScaleProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_parcelable_00005() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        WeightScaleProfileMockData result2 = WeightScaleProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.weightScale, result2.weightScale);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.userData, result2.userData);
        assertEquals(result1.batteryList, result2.batteryList);
        assertEquals(result1.currentTime, result2.currentTime);
    }

    @Test
    public void test_hashCode_00001() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, currentTimeService);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(weightScale)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(userData)
                        ^ Objects.hashCode(batteryList)
                        ^ Objects.hashCode(currentTimeService)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, null, userData, batteryList, currentTimeService);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(weightScale)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(userData)
                        ^ Objects.hashCode(batteryList)
                        ^ Objects.hashCode(currentTimeService)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, null, batteryList, currentTimeService);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(weightScale)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(batteryList)
                        ^ Objects.hashCode(currentTimeService)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00004() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, null, currentTimeService);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(weightScale)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(userData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(currentTimeService)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00005() {
        ServiceData weightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData userData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(weightScale, deviceInformation, userData, batteryList, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(weightScale)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(userData)
                        ^ Objects.hashCode(batteryList)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        ServiceData secondWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(secondWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        ServiceData secondDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, secondDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        UserDataServiceData secondUserData = new UserDataServiceData();

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, secondUserData, firstBatteryList, firstCurrentTimeService);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        List<ServiceData> secondBatteryList = Collections.emptyList();

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, secondBatteryList, firstCurrentTimeService);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        CurrentTimeServiceData secondCurrentTimeService = new CurrentTimeServiceData(currentTime
                , localTimeInformation
                , null);

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, secondCurrentTimeService);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, null, firstUserData, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, null, firstUserData, firstBatteryList, firstCurrentTimeService);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, null, firstBatteryList, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, null, firstBatteryList, firstCurrentTimeService);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00103() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

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

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, null, firstCurrentTimeService);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, null, firstCurrentTimeService);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00104() {
        ServiceData firstWeightScale = new ServiceData(WEIGHT_SCALE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());
        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        UDSCharacteristicData firstName = new UDSCharacteristicData(FIRST_NAME_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData databaseChangeIncrement = new CharacteristicData(DATABASE_CHANGE_INCREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData userIndex = new CharacteristicData(USER_INDEX_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        UserControlPointCharacteristicData userControlPoint = new UserControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 5
                , 6
                , 7
                , 8
                , 9);
        UserDataServiceData firstUserData = new UserDataServiceData(firstName
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , null
                , databaseChangeIncrement
                , userIndex
                , userControlPoint
                , null);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        WeightScaleProfileMockData result1 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, null);

        WeightScaleProfileMockData result2 = new WeightScaleProfileMockData(firstWeightScale, firstDeviceInformation, firstUserData, firstBatteryList, null);

        assertEquals(result1, result2);
    }

}
