package org.im97mori.ble.service.cps.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_POWER_SERVICE;
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

public class CyclingPowerServiceDataTest extends TestBase {

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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        Gson gson = new Gson();
        CyclingPowerServiceData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerServiceData.class);

        assertEquals(CYCLING_POWER_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cyclingPowerFeature, result2.cyclingPowerFeature);
        assertEquals(result1.cyclingPowerMeasurement, result2.cyclingPowerMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.cyclingPowerControlPoint, result2.cyclingPowerControlPoint);
        assertEquals(result1.cyclingPowerVector, result2.cyclingPowerVector);
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
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , null
                , cyclingPowerVector);

        Gson gson = new Gson();
        CyclingPowerServiceData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerServiceData.class);

        assertEquals(CYCLING_POWER_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cyclingPowerFeature, result2.cyclingPowerFeature);
        assertEquals(result1.cyclingPowerMeasurement, result2.cyclingPowerMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.cyclingPowerControlPoint, result2.cyclingPowerControlPoint);
        assertEquals(result1.cyclingPowerVector, result2.cyclingPowerVector);
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);

        Gson gson = new Gson();
        CyclingPowerServiceData result2 = gson.fromJson(gson.toJson(result1), CyclingPowerServiceData.class);

        assertEquals(CYCLING_POWER_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cyclingPowerFeature, result2.cyclingPowerFeature);
        assertEquals(result1.cyclingPowerMeasurement, result2.cyclingPowerMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.cyclingPowerControlPoint, result2.cyclingPowerControlPoint);
        assertEquals(result1.cyclingPowerVector, result2.cyclingPowerVector);
    }

    @Test
    public void test_constructor_00101() {
        CyclingPowerServiceData result1 = new CyclingPowerServiceData();

        assertNull(result1.cyclingPowerFeature);
        assertNull(result1.cyclingPowerMeasurement);
        assertNull(result1.sensorLocation);
        assertNull(result1.cyclingPowerControlPoint);
        assertNull(result1.cyclingPowerVector);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        assertArrayEquals(Arrays.asList(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
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
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , null
                , cyclingPowerVector);

        assertArrayEquals(Arrays.asList(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerVector).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);

        assertArrayEquals(Arrays.asList(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerServiceData result2 = CyclingPowerServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CYCLING_POWER_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cyclingPowerFeature, result2.cyclingPowerFeature);
        assertEquals(result1.cyclingPowerMeasurement, result2.cyclingPowerMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.cyclingPowerControlPoint, result2.cyclingPowerControlPoint);
        assertEquals(result1.cyclingPowerVector, result2.cyclingPowerVector);
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
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , null
                , cyclingPowerVector);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerServiceData result2 = CyclingPowerServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CYCLING_POWER_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cyclingPowerFeature, result2.cyclingPowerFeature);
        assertEquals(result1.cyclingPowerMeasurement, result2.cyclingPowerMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.cyclingPowerControlPoint, result2.cyclingPowerControlPoint);
        assertEquals(result1.cyclingPowerVector, result2.cyclingPowerVector);
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        CyclingPowerServiceData result2 = CyclingPowerServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(CYCLING_POWER_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.cyclingPowerFeature, result2.cyclingPowerFeature);
        assertEquals(result1.cyclingPowerMeasurement, result2.cyclingPowerMeasurement);
        assertEquals(result1.sensorLocation, result2.sensorLocation);
        assertEquals(result1.cyclingPowerControlPoint, result2.cyclingPowerControlPoint);
        assertEquals(result1.cyclingPowerVector, result2.cyclingPowerVector);
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , cyclingPowerVector);

        assertEquals(Objects.hashCode(CYCLING_POWER_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingPowerFeature)
                        ^ Objects.hashCode(cyclingPowerMeasurement)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(cyclingPowerControlPoint)
                        ^ Objects.hashCode(cyclingPowerVector)
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
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , null
                , cyclingPowerVector);

        assertEquals(Objects.hashCode(CYCLING_POWER_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingPowerFeature)
                        ^ Objects.hashCode(cyclingPowerMeasurement)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(cyclingPowerVector)
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);

        assertEquals(Objects.hashCode(CYCLING_POWER_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(cyclingPowerFeature)
                        ^ Objects.hashCode(cyclingPowerMeasurement)
                        ^ Objects.hashCode(sensorLocation)
                        ^ Objects.hashCode(cyclingPowerControlPoint)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
        CyclingPowerControlPointCharacteristicData firstCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
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
        CharacteristicData firstCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
        CyclingPowerControlPointCharacteristicData firstCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
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
        CharacteristicData firstCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(secondCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
        CyclingPowerControlPointCharacteristicData firstCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
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
        CharacteristicData firstCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , secondCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
        CyclingPowerControlPointCharacteristicData firstCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
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
        CharacteristicData firstCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondSensorLocation = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , secondSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        CharacteristicData firstCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
        CyclingPowerControlPointCharacteristicData firstCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
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
        CharacteristicData firstCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerControlPointCharacteristicData secondCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
                , 11
                , 22
                , 33
                , 44
                , 55
                , new byte[]{66}
                , 77
                , 88
                , new byte[]{99}
                , 110
                , 111
                , new byte[]{112}
                , 113
                , 114
                , new byte[]{115}
                , 116
                , 117
                , new byte[]{118}
                , 119
                , new byte[]{120}
                , 121
                , 122
                , new byte[]{123}
                , 124
                , new byte[]{125}
                , 126
                , new byte[]{127});

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , secondCyclingPowerControlPoint
                , firstCyclingPowerVector);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        CharacteristicData firstCyclingPowerFeature = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCyclingPowerMeasurement = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
        CyclingPowerControlPointCharacteristicData firstCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(new ArrayList<>()
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
        CharacteristicData firstCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CharacteristicData secondCyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , firstCyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(firstCyclingPowerFeature
                , firstCyclingPowerMeasurement
                , firstSensorLocation
                , firstCyclingPowerControlPoint
                , secondCyclingPowerVector);
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
        CharacteristicData cyclingPowerVector = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , null
                , cyclingPowerVector);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , null
                , cyclingPowerVector);
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

        CyclingPowerServiceData result1 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);
        CyclingPowerServiceData result2 = new CyclingPowerServiceData(cyclingPowerFeature
                , cyclingPowerMeasurement
                , sensorLocation
                , cyclingPowerControlPoint
                , null);
        assertEquals(result1, result2);
    }

}
