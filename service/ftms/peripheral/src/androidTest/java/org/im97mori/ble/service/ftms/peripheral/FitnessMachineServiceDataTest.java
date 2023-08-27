package org.im97mori.ble.service.ftms.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CROSS_TRAINER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.INDOOR_BIKE_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.ROWER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.STAIR_CLIMBER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.STEP_CLIMBER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_POWER_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TRAINING_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TREADMILL_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.FITNESS_MACHINE_SERVICE;
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

public class FitnessMachineServiceDataTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , null
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , null
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00004() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , null
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00005() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , null
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00006() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , null
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00007() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , null
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00008() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , null
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00009() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , null
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00010() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , null
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00011() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , null
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00012() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , null
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00013() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , null
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00014() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , null
                , fitnessMachineStatus);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00015() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , null);

        Gson gson = new Gson();
        FitnessMachineServiceData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineServiceData.class);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_constructor_00101() {
        FitnessMachineServiceData result1 = new FitnessMachineServiceData();

        assertNull(result1.fitnessMachineFeature);
        assertNull(result1.treadmillData);
        assertNull(result1.crossTrainerData);
        assertNull(result1.stepClimberData);
        assertNull(result1.stairClimberData);
        assertNull(result1.rowerData);
        assertNull(result1.indoorBikeData);
        assertNull(result1.trainingStatus);
        assertNull(result1.supportedSpeedRange);
        assertNull(result1.supportedInclinationRange);
        assertNull(result1.supportedResistanceLevelRange);
        assertNull(result1.supportedPowerRange);
        assertNull(result1.supportedHeartRateRange);
        assertNull(result1.fitnessMachineControlPoint);
        assertNull(result1.fitnessMachineStatus);
    }

    @Test
    public void test_getCharacteristicDataList_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , null
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , null
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00004() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , null
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00005() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , null
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00006() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , null
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00007() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , null
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00008() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , null
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00009() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , null
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00010() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , null
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00011() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , null
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00012() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , null
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00013() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , null
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00014() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , null
                , fitnessMachineStatus);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineStatus).toArray(), result1.getCharacteristicDataList().toArray());
    }

    @Test
    public void test_getCharacteristicDataList_00015() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , null);

        assertArrayEquals(Arrays.asList(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint).toArray(), result1.getCharacteristicDataList().toArray());
    }


    @Test
    public void test_parcelable_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , null
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , null
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00004() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , null
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00005() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , null
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00006() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , null
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00007() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , null
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00008() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , null
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00009() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , null
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00010() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , null
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00011() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , null
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00012() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , null
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00013() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , null
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00014() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , null
                , fitnessMachineStatus);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_parcelable_00015() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , null);

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineServiceData result2 = FitnessMachineServiceData.CREATOR.createFromParcel(parcel);

        assertEquals(FITNESS_MACHINE_SERVICE, result2.uuid);
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, result2.type);
        assertNotNull(result2.characteristicDataList);
        assertTrue(result2.characteristicDataList.isEmpty());
        assertEquals(result1.characteristicDataList.size(), result2.characteristicDataList.size());
        assertArrayEquals(result1.characteristicDataList.toArray(), result2.characteristicDataList.toArray());
        assertEquals(result1.fitnessMachineFeature, result2.fitnessMachineFeature);
        assertEquals(result1.treadmillData, result2.treadmillData);
        assertEquals(result1.crossTrainerData, result2.crossTrainerData);
        assertEquals(result1.stepClimberData, result2.stepClimberData);
        assertEquals(result1.stairClimberData, result2.stairClimberData);
        assertEquals(result1.rowerData, result2.rowerData);
        assertEquals(result1.indoorBikeData, result2.indoorBikeData);
        assertEquals(result1.trainingStatus, result2.trainingStatus);
        assertEquals(result1.supportedSpeedRange, result2.supportedSpeedRange);
        assertEquals(result1.supportedInclinationRange, result2.supportedInclinationRange);
        assertEquals(result1.supportedResistanceLevelRange, result2.supportedResistanceLevelRange);
        assertEquals(result1.supportedPowerRange, result2.supportedPowerRange);
        assertEquals(result1.supportedHeartRateRange, result2.supportedHeartRateRange);
        assertEquals(result1.fitnessMachineControlPoint, result2.fitnessMachineControlPoint);
        assertEquals(result1.fitnessMachineStatus, result2.fitnessMachineStatus);
    }

    @Test
    public void test_hashCode_00001() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , null
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , null
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00004() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , null
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00005() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , null
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00006() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , null
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00007() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , null
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00008() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , null
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00009() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , null
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00010() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , null
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00011() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , null
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00012() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , null
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00013() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , null
                , fitnessMachineControlPoint
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00014() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineStatusCharacteristicData fitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , null
                , fitnessMachineStatus);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(null)
                        ^ Objects.hashCode(fitnessMachineStatus)
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00015() {
        CharacteristicData fitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData treadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData crossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData stairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData rowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData indoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData trainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData supportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(fitnessMachineFeature
                , treadmillData
                , crossTrainerData
                , stepClimberData
                , stairClimberData
                , rowerData
                , indoorBikeData
                , trainingStatus
                , supportedSpeedRange
                , supportedInclinationRange
                , supportedResistanceLevelRange
                , supportedPowerRange
                , supportedHeartRateRange
                , fitnessMachineControlPoint
                , null);

        assertEquals(Objects.hashCode(FITNESS_MACHINE_SERVICE)
                        ^ Integer.valueOf(BluetoothGattService.SERVICE_TYPE_PRIMARY).hashCode()
                        ^ Objects.hashCode(Collections.emptyList())
                        ^ Objects.hashCode(fitnessMachineFeature)
                        ^ Objects.hashCode(treadmillData)
                        ^ Objects.hashCode(crossTrainerData)
                        ^ Objects.hashCode(stepClimberData)
                        ^ Objects.hashCode(stairClimberData)
                        ^ Objects.hashCode(rowerData)
                        ^ Objects.hashCode(indoorBikeData)
                        ^ Objects.hashCode(trainingStatus)
                        ^ Objects.hashCode(supportedSpeedRange)
                        ^ Objects.hashCode(supportedInclinationRange)
                        ^ Objects.hashCode(supportedResistanceLevelRange)
                        ^ Objects.hashCode(supportedPowerRange)
                        ^ Objects.hashCode(supportedHeartRateRange)
                        ^ Objects.hashCode(fitnessMachineControlPoint)
                        ^ Objects.hashCode(null)
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(secondFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , secondTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , secondCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , secondStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , secondStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , secondRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , secondIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , secondTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , secondSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , secondSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , secondSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , secondSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        CharacteristicData secondSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 11
                , 22
                , Collections.emptyList()
                , 33
                , 44
                , new byte[]{55}
                , 66);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , secondSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineControlPointCharacteristicData secondFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 11
                , 22
                , 33
                , 44
                , 55
                , 66
                , 77
                , 88
                , 99
                , 110
                , 111
                , 112
                , 113
                , 114
                , 115
                , 116
                , 117
                , 118
                , 119
                , 120
                , 121
                , new byte[]{122}
                , 123);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , secondFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineStatusCharacteristicData secondFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 11);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , secondFitnessMachineStatus);
        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00101() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , null
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , null
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00102() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , null
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , null
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00103() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , null
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , null
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00104() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , null
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , null
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00105() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , null
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , null
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00106() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , null
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , null
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00107() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , null
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , null
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00108() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , null
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , null
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00109() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , null
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , null
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00110() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , null
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , null
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00111() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , null
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , null
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00112() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , null
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , null
                , firstFitnessMachineControlPoint
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00113() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineStatusCharacteristicData firstFitnessMachineStatus = new FitnessMachineStatusCharacteristicData(new ArrayList<>()
                , 1);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , null
                , firstFitnessMachineStatus);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , null
                , firstFitnessMachineStatus);
        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00114() {
        CharacteristicData firstFitnessMachineFeature = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTreadmillData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstCrossTrainerData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStepClimberData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstStairClimberData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstRowerData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstIndoorBikeData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstTrainingStatus = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedSpeedRange = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedInclinationRange = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedResistanceLevelRange = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedPowerRange = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        CharacteristicData firstSupportedHeartRateRange = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                , 1
                , 2
                , Collections.emptyList()
                , 3
                , 4
                , new byte[]{5}
                , 6);
        FitnessMachineControlPointCharacteristicData firstFitnessMachineControlPoint = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , 10
                , 11
                , 12
                , 13
                , 14
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        FitnessMachineServiceData result1 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , null);

        FitnessMachineServiceData result2 = new FitnessMachineServiceData(firstFitnessMachineFeature
                , firstTreadmillData
                , firstCrossTrainerData
                , firstStepClimberData
                , firstStairClimberData
                , firstRowerData
                , firstIndoorBikeData
                , firstTrainingStatus
                , firstSupportedSpeedRange
                , firstSupportedInclinationRange
                , firstSupportedResistanceLevelRange
                , firstSupportedPowerRange
                , firstSupportedHeartRateRange
                , firstFitnessMachineControlPoint
                , null);
        assertEquals(result1, result2);
    }

}
