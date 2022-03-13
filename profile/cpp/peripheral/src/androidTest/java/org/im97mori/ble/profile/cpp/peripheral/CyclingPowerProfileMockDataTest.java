package org.im97mori.ble.profile.cpp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
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
import org.im97mori.ble.service.cps.peripheral.CyclingPowerControlPointCharacteristicData;
import org.im97mori.ble.service.cps.peripheral.CyclingPowerServiceData;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CyclingPowerProfileMockDataTest {

    @Test
    public void test_constructor_00001() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, batteryList);

        Gson gson = new Gson();
        CyclingPowerProfileMockData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingPower, result2.cyclingPower);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, null, batteryList);

        Gson gson = new Gson();
        CyclingPowerProfileMockData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingPower, result2.cyclingPower);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_constructor_00003() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, null);

        Gson gson = new Gson();
        CyclingPowerProfileMockData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingPower, result2.cyclingPower);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_constructor_00101() {
        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData();

        assertNull(result1.cyclingPower);
        assertNull(result1.deviceInformation);
        assertNull(result1.batteryList);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, batteryList);

        List<ServiceData> list = new ArrayList<>();
        list.add(cyclingPower);
        list.add(deviceInformation);
        list.addAll(batteryList);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, null, batteryList);

        List<ServiceData> list = new ArrayList<>();
        list.add(cyclingPower);
        list.addAll(batteryList);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00003() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(cyclingPower);
        list.add(deviceInformation);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, batteryList);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerProfileMockData result2 = CyclingPowerProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingPower, result2.cyclingPower);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, null, batteryList);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerProfileMockData result2 = CyclingPowerProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingPower, result2.cyclingPower);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_parcelable_00003() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerProfileMockData result2 = CyclingPowerProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingPower, result2.cyclingPower);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
        assertEquals(result1.batteryList, result2.batteryList);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, batteryList);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingPower)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(batteryList)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        List<ServiceData> batteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, null, batteryList);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingPower)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(batteryList)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData cyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(cyclingPower, deviceInformation, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingPower)
                        ^ Objects.hashCode(deviceInformation)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData firstCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, firstBatteryList);

        CyclingPowerProfileMockData result2 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, firstBatteryList);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData firstCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerServiceData secondCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, firstBatteryList);

        CyclingPowerProfileMockData result2 = new CyclingPowerProfileMockData(secondCyclingPower, firstDeviceInformation, firstBatteryList);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData firstCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        ServiceData secondDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, firstBatteryList);

        CyclingPowerProfileMockData result2 = new CyclingPowerProfileMockData(firstCyclingPower, secondDeviceInformation, firstBatteryList);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData firstCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        List<ServiceData> secondBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData())));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, firstBatteryList);

        CyclingPowerProfileMockData result2 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, secondBatteryList);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData firstCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        List<ServiceData> firstBatteryList = Collections.singletonList(new ServiceData(BATTERY_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList()));

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(firstCyclingPower, null, firstBatteryList);

        CyclingPowerProfileMockData result2 = new CyclingPowerProfileMockData(firstCyclingPower, null, firstBatteryList);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData cyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CyclingPowerControlPointCharacteristicData cyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6}
                , 7
                , 8
                , new byte[]{9}
                , 10
                , 11
                , new byte[]{12}
                , 13
                , 14
                , new byte[]{15}
                , 16
                , 17
                , new byte[]{18}
                , 19
                , new byte[]{20}
                , 21
                , 22
                , new byte[]{23}
                , 24
                , new byte[]{25}
                , 26
                , new byte[]{27});
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData firstCyclingPower = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingPowerProfileMockData result1 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, null);

        CyclingPowerProfileMockData result2 = new CyclingPowerProfileMockData(firstCyclingPower, firstDeviceInformation, null);

        assertEquals(result1, result2);
    }

}
