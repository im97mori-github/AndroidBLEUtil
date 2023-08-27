package org.im97mori.ble.service.cscs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;
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

public class CyclingSpeedAndCadenceServiceDataTest extends TestBase {

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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        Gson gson = new Gson();
        CyclingSpeedAndCadenceServiceData result2 = gson.fromJson(gson.toJson(result1), CyclingSpeedAndCadenceServiceData.class);

        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cscMeasurement, result2.cscMeasurement);
        assertEquals(result1.cscFeature, result2.cscFeature);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , null
                , scControlPoint);

        Gson gson = new Gson();
        CyclingSpeedAndCadenceServiceData result2 = gson.fromJson(gson.toJson(result1), CyclingSpeedAndCadenceServiceData.class);

        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cscMeasurement, result2.cscMeasurement);
        assertEquals(result1.cscFeature, result2.cscFeature);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
    }

    @Test
    public void test_constructor_00003() {
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , null);

        Gson gson = new Gson();
        CyclingSpeedAndCadenceServiceData result2 = gson.fromJson(gson.toJson(result1), CyclingSpeedAndCadenceServiceData.class);

        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cscMeasurement, result2.cscMeasurement);
        assertEquals(result1.cscFeature, result2.cscFeature);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
    }

    @Test
    public void test_constructor_00101() {
        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData();

        assertNull(result1.cscMeasurement);
        assertNull(result1.cscFeature);
        assertNull(result1.sensorLocation);
        assertNull(result1.scControlPoint);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        assertArrayEquals(Arrays.asList(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , null
                , scControlPoint);

        assertArrayEquals(Arrays.asList(cscMeasurement
                , cscFeature
                , scControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , null);

        assertArrayEquals(Arrays.asList(cscMeasurement
                , cscFeature
                , sensorLocation).toArray(), result1.getCharacteristicDataList().toArray());
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingSpeedAndCadenceServiceData result2 = CyclingSpeedAndCadenceServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cscMeasurement, result2.cscMeasurement);
        assertEquals(result1.cscFeature, result2.cscFeature);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , null
                , scControlPoint);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingSpeedAndCadenceServiceData result2 = CyclingSpeedAndCadenceServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cscMeasurement, result2.cscMeasurement);
        assertEquals(result1.cscFeature, result2.cscFeature);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
    }

    @Test
    public void test_parcelable_00003() {
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , null);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingSpeedAndCadenceServiceData result2 = CyclingSpeedAndCadenceServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CYCLING_SPEED_AND_CADENCE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cscMeasurement, result2.cscMeasurement);
        assertEquals(result1.cscFeature, result2.cscFeature);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.scControlPoint, result2.scControlPoint);
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , scControlPoint);

        assertEquals(Objects.hashCode(CYCLING_SPEED_AND_CADENCE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cscMeasurement)
                        ^ Objects.hashCode(cscFeature)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(scControlPoint)
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
        SCControlPointCharacteristicData scControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , null
                , scControlPoint);

        assertEquals(Objects.hashCode(CYCLING_SPEED_AND_CADENCE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cscMeasurement)
                        ^ Objects.hashCode(cscFeature)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(scControlPoint)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
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

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(cscMeasurement
                , cscFeature
                , sensorLocation
                , null);

        assertEquals(Objects.hashCode(CYCLING_SPEED_AND_CADENCE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cscMeasurement)
                        ^ Objects.hashCode(cscFeature)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
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
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
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
                , new byte[]{6});

        CharacteristicData secondCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(secondCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
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
                , new byte[]{6});

        CharacteristicData secondCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , secondCscFeature
                , firstSensorLocation
                , firstScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
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
                , new byte[]{6});

        CharacteristicData secondSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , secondSensorLocation
                , firstScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
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
                , new byte[]{6});

        SCControlPointCharacteristicData secondScControlPoint = new SCControlPointCharacteristicData(new ArrayList<>()
                , 11
                , 22
                , 33
                , 44
                , 55
                , new byte[]{66});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , firstScControlPoint);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , secondScControlPoint);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
                , new byte[]{6});

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , null
                , firstScControlPoint);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , null
                , firstScControlPoint);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData firstCscMeasurement = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCscFeature = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingSpeedAndCadenceServiceData result1 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , null);

        CyclingSpeedAndCadenceServiceData result2 = new CyclingSpeedAndCadenceServiceData(firstCscMeasurement
                , firstCscFeature
                , firstSensorLocation
                , null);
        assertEquals(result1, result2);
    }

}
