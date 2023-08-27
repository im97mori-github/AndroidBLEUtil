package org.im97mori.ble.profile.rscp.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.RSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RSC_MEASUREMENT_CHARACTERISTIC;
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
import org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceData;
import org.im97mori.ble.service.rscs.peripheral.SCControlPointCharacteristicData;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class RunningSpeedAndCadenceProfileMockDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, deviceInformation);

        Gson gson = new Gson();
        RunningSpeedAndCadenceProfileMockData result2 = gson.fromJson(gson.toJson(result1), RunningSpeedAndCadenceProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.runningSpeedAndCadence, result2.runningSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, null);

        Gson gson = new Gson();
        RunningSpeedAndCadenceProfileMockData result2 = gson.fromJson(gson.toJson(result1), RunningSpeedAndCadenceProfileMockData.class);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.runningSpeedAndCadence, result2.runningSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_constructor_00101() {
        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData();

        assertNull(result1.runningSpeedAndCadence);
        assertNull(result1.deviceInformation);
    }

    @Test
    public void test_getServiceDataList_00001() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, deviceInformation);

        List<ServiceData> list = new ArrayList<>();
        list.add(runningSpeedAndCadence);
        list.add(deviceInformation);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_getServiceDataList_00002() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, null);

        List<ServiceData> list = new ArrayList<>();
        list.add(runningSpeedAndCadence);
        assertArrayEquals(list.toArray(), result1.getServiceDataList().toArray());
    }

    @Test
    public void test_parcelable_00001() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, deviceInformation);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RunningSpeedAndCadenceProfileMockData result2 = RunningSpeedAndCadenceProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.runningSpeedAndCadence, result2.runningSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RunningSpeedAndCadenceProfileMockData result2 = RunningSpeedAndCadenceProfileMockData.CREATOR.createFromParcel(parcel);

        assertNotNull(result2.serviceDataList);
        assertEquals(result1.serviceDataList.size(), result2.serviceDataList.size());
        assertArrayEquals(result1.serviceDataList.toArray(), result2.serviceDataList.toArray());
        assertEquals(result1.runningSpeedAndCadence, result2.runningSpeedAndCadence);
        assertEquals(result1.deviceInformation, result2.deviceInformation);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData deviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, deviceInformation);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(runningSpeedAndCadence)
                        ^ Objects.hashCode(deviceInformation)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData runningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(runningSpeedAndCadence, null);

        assertEquals(Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(runningSpeedAndCadence)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData firstRunningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, firstDeviceInformation);

        RunningSpeedAndCadenceProfileMockData result2 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, firstDeviceInformation);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData firstRunningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        RunningSpeedAndCadenceServiceData secondRunningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , null);

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, firstDeviceInformation);

        RunningSpeedAndCadenceProfileMockData result2 = new RunningSpeedAndCadenceProfileMockData(secondRunningSpeedAndCadence, firstDeviceInformation);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData firstRunningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        ServiceData firstDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.emptyList());

        ServiceData secondDeviceInformation = new ServiceData(DEVICE_INFORMATION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, Collections.singletonList(new CharacteristicData()));

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, firstDeviceInformation);

        RunningSpeedAndCadenceProfileMockData result2 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, secondDeviceInformation);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData rscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData sensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData firstRunningSpeedAndCadence = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        RunningSpeedAndCadenceProfileMockData result1 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, null);

        RunningSpeedAndCadenceProfileMockData result2 = new RunningSpeedAndCadenceProfileMockData(firstRunningSpeedAndCadence, null);

        assertEquals(result1, result2);
    }

}
