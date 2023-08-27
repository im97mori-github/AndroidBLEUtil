package org.im97mori.ble.profile.cscp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
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
import org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceData;
import org.im97mori.ble.service.cscs.peripheral.SCControlPointCharacteristicData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CyclingSpeedAndCadenceProfileMockDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, deviceInformation);

        Gson gson = new Gson();
        CyclingSpeedAndCadenceProfileMockData result2 = gson.fromJson(gson.toJson(result1), CyclingSpeedAndCadenceProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingSpeedAndCadence, result2.cyclingSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, null);

        Gson gson = new Gson();
        CyclingSpeedAndCadenceProfileMockData result2 = gson.fromJson(gson.toJson(result1), CyclingSpeedAndCadenceProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingSpeedAndCadence, result2.cyclingSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00101() {
        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData();

        assertNull(result1.cyclingSpeedAndCadence);
        assertNull(result1.deviceInformation);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, deviceInformation);

        List<ServiceData> list = new ArrayList<>();
        list.add(cyclingSpeedAndCadence);
        list.add(deviceInformation);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(cyclingSpeedAndCadence);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, deviceInformation);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingSpeedAndCadenceProfileMockData result2 = CyclingSpeedAndCadenceProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingSpeedAndCadence, result2.cyclingSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingSpeedAndCadenceProfileMockData result2 = CyclingSpeedAndCadenceProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.cyclingSpeedAndCadence, result2.cyclingSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, deviceInformation);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingSpeedAndCadence)
                        ^ Objects.hashCode(deviceInformation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData cyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(cyclingSpeedAndCadence, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingSpeedAndCadence)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData firstCyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, firstDeviceInformation);

        CyclingSpeedAndCadenceProfileMockData result2 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, firstDeviceInformation);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData firstCyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        CyclingSpeedAndCadenceServiceData secondCyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , null);

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, firstDeviceInformation);

        CyclingSpeedAndCadenceProfileMockData result2 = new CyclingSpeedAndCadenceProfileMockData(secondCyclingSpeedAndCadence, firstDeviceInformation);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData firstCyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData secondDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, firstDeviceInformation);

        CyclingSpeedAndCadenceProfileMockData result2 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, secondDeviceInformation);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData cscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData cscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData firstCyclingSpeedAndCadence = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        CyclingSpeedAndCadenceProfileMockData result1 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, null);

        CyclingSpeedAndCadenceProfileMockData result2 = new CyclingSpeedAndCadenceProfileMockData(firstCyclingSpeedAndCadence, null);

        assertEquals(result1, result2);
    }

}
