package org.im97mori.ble.profile.lnp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.LN_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.LOCATION_AND_SPEED_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.NAVIGATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.POSITION_QUALITY_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.BATTERY_SERVICE;
import static org.im97mori.ble.constants.ServiceUUID.DEVICE_INFORMATION_SERVICE;
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
import org.im97mori.ble.service.lns.peripheral.LNControlPointCharacteristicData;
import org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LocationAndNavigationProfileMockDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, batteryList);

        Gson gson = new Gson();
        LocationAndNavigationProfileMockData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.locationAndNavigation, result2.locationAndNavigation);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, null, batteryList);

        Gson gson = new Gson();
        LocationAndNavigationProfileMockData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.locationAndNavigation, result2.locationAndNavigation);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_constructor_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, null);

        Gson gson = new Gson();
        LocationAndNavigationProfileMockData result2 = gson.fromJson(gson.toJson(result1), LocationAndNavigationProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.locationAndNavigation, result2.locationAndNavigation);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_constructor_00101() {
        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData();

        assertNull(result1.locationAndNavigation);
        assertNull(result1.deviceInformation);
        assertNull(result1.batteryList);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, batteryList);

        List<ServiceData> list = new ArrayList<>();
        list.add(locationAndNavigation);
        list.add(deviceInformation);
        list.addAll(batteryList);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, null, batteryList);

        List<ServiceData> list = new ArrayList<>();
        list.add(locationAndNavigation);
        list.addAll(batteryList);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(locationAndNavigation);
        list.add(deviceInformation);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, batteryList);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationProfileMockData result2 = LocationAndNavigationProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.locationAndNavigation, result2.locationAndNavigation);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, null, batteryList);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationProfileMockData result2 = LocationAndNavigationProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.locationAndNavigation, result2.locationAndNavigation);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_parcelable_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LocationAndNavigationProfileMockData result2 = LocationAndNavigationProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.locationAndNavigation, result2.locationAndNavigation);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, batteryList);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(locationAndNavigation)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(batteryList)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, null, batteryList);


        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(locationAndNavigation)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(batteryList)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData locationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(locationAndNavigation, deviceInformation, null);


        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(locationAndNavigation)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData firstLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, firstBatteryList);

        LocationAndNavigationProfileMockData result2 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, firstBatteryList);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData firstLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationServiceData secondLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , null);

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, firstBatteryList);

        LocationAndNavigationProfileMockData result2 = new LocationAndNavigationProfileMockData(secondLocationAndNavigation, firstDeviceInformation, firstBatteryList);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData firstLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        ServiceData secondDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, firstBatteryList);

        LocationAndNavigationProfileMockData result2 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, secondDeviceInformation, firstBatteryList);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData firstLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        List<ServiceData> secondBatteryList = Collections.emptyList();

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, firstBatteryList);

        LocationAndNavigationProfileMockData result2 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, secondBatteryList);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData firstLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, null, firstBatteryList);

        LocationAndNavigationProfileMockData result2 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, null, firstBatteryList);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData lnFeature = new CharacteristicData(LN_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData locationAndSpeed = new CharacteristicData(LOCATION_AND_SPEED_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData positionQuality = new CharacteristicData(POSITION_QUALITY_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        LNControlPointCharacteristicData lnControlPoint = new LNControlPointCharacteristicData(1
                , 2
                , new ArrayList<>()
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , new byte[]{9}
                , 10
                , new byte[]{11}
                , 12
                , 13
                , 14);
        CharacteristicData navigation = new CharacteristicData(NAVIGATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        LocationAndNavigationServiceData firstLocationAndNavigation = new LocationAndNavigationServiceData(lnFeature
                , locationAndSpeed
                , positionQuality
                , lnControlPoint
                , navigation);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        LocationAndNavigationProfileMockData result1 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, null);

        LocationAndNavigationProfileMockData result2 = new LocationAndNavigationProfileMockData(firstLocationAndNavigation, firstDeviceInformation, null);

        assertEquals(result1, result2);
    }

}
