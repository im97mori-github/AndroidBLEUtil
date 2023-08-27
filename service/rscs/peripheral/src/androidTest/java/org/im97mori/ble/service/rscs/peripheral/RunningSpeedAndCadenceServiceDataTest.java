package org.im97mori.ble.service.rscs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.RSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;
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
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Objects;

public class RunningSpeedAndCadenceServiceDataTest extends TestBase {

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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        Gson gson = new Gson();
        RunningSpeedAndCadenceServiceData result2 = gson.fromJson(gson.toJson(result1), RunningSpeedAndCadenceServiceData.class);

        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rscFeature, result2.rscFeature);
        assertEquals(result1.rscMeasurement, result2.rscMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , null
                , scControlPoint);

        Gson gson = new Gson();
        RunningSpeedAndCadenceServiceData result2 = gson.fromJson(gson.toJson(result1), RunningSpeedAndCadenceServiceData.class);

        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rscFeature, result2.rscFeature);
        assertEquals(result1.rscMeasurement, result2.rscMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
    }

    @Test
    public void test_constructor_00003() {
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , null);

        Gson gson = new Gson();
        RunningSpeedAndCadenceServiceData result2 = gson.fromJson(gson.toJson(result1), RunningSpeedAndCadenceServiceData.class);

        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rscFeature, result2.rscFeature);
        assertEquals(result1.rscMeasurement, result2.rscMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
    }

    @Test
    public void test_constructor_00101() {
        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData();

        assertNull(result1.rscFeature);
        assertNull(result1.rscMeasurement);
        assertNull(result1.sensorLocation);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        assertArrayEquals(Arrays.asList(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , null
                , scControlPoint);

        assertArrayEquals(Arrays.asList(rscFeature
                , rscMeasurement
                , scControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , null);

        assertArrayEquals(Arrays.asList(rscFeature
                , rscMeasurement
                , sensorLocation).toArray(), result1.getCharacteristicDataList().toArray());
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RunningSpeedAndCadenceServiceData result2 = RunningSpeedAndCadenceServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rscFeature, result2.rscFeature);
        assertEquals(result1.rscMeasurement, result2.rscMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , null
                , scControlPoint);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RunningSpeedAndCadenceServiceData result2 = RunningSpeedAndCadenceServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rscFeature, result2.rscFeature);
        assertEquals(result1.rscMeasurement, result2.rscMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
    }

    @Test
    public void test_parcelable_00003() {
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        RunningSpeedAndCadenceServiceData result2 = RunningSpeedAndCadenceServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(RUNNING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.rscFeature, result2.rscFeature);
        assertEquals(result1.rscMeasurement, result2.rscMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , scControlPoint);

        assertEquals(Objects.hashCode(RUNNING_SPEED_AND_CADENCE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(rscFeature)
                        ^ Objects.hashCode(rscMeasurement)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(scControlPoint)
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , null
                , scControlPoint);

        assertEquals(Objects.hashCode(RUNNING_SPEED_AND_CADENCE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(rscFeature)
                        ^ Objects.hashCode(rscMeasurement)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(scControlPoint)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
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

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(rscFeature
                , rscMeasurement
                , sensorLocation
                , null);

        assertEquals(Objects.hashCode(RUNNING_SPEED_AND_CADENCE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(rscFeature)
                        ^ Objects.hashCode(rscMeasurement)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        SCControlPointCharacteristicData firstScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        SCControlPointCharacteristicData firstScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        CharacteristicData secondRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(secondRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        SCControlPointCharacteristicData firstScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        CharacteristicData secondRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 4
                , new byte[]{55}
                , 66);

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , secondRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        SCControlPointCharacteristicData firstScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        CharacteristicData secondSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 4
                , new byte[]{55}
                , 66);

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , secondSensorLocation
                , firstScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        SCControlPointCharacteristicData firstScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        SCControlPointCharacteristicData secondScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 11
                , 22
                , 33
                , 44
                , 55
                , 66
                , new byte[]{77});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , firstScControlPoint);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , secondScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        SCControlPointCharacteristicData firstScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , new byte[]{7});

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , null
                , firstScControlPoint);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , null
                , firstScControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData firstRscFeature = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRscMeasurement = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        RunningSpeedAndCadenceServiceData result1 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , null);

        RunningSpeedAndCadenceServiceData result2 = new RunningSpeedAndCadenceServiceData(firstRscFeature
                , firstRscMeasurement
                , firstSensorLocation
                , null);
        assertEquals(result1, result2);
    }

}
