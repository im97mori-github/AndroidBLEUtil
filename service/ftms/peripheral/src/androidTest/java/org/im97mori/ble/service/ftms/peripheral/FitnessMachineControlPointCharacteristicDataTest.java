package org.im97mori.ble.service.ftms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;

import com.google.gson.Gson;

import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class FitnessMachineControlPointCharacteristicDataTest {

    @Test
    public void test_constructor_00001() {
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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

        Gson gson = new Gson();
        FitnessMachineControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertTrue(result2.descriptorDataList.isEmpty());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.requestControlResultCode, result2.requestControlResultCode);
        assertEquals(result1.resetResultCode, result2.resetResultCode);
        assertEquals(result1.setTargetSpeedResultCode, result2.setTargetSpeedResultCode);
        assertEquals(result1.setTargetInclinationResultCode, result2.setTargetInclinationResultCode);
        assertEquals(result1.setTargetResistanceLevelResultCode, result2.setTargetResistanceLevelResultCode);
        assertEquals(result1.setTargetPowerResultCode, result2.setTargetPowerResultCode);
        assertEquals(result1.setTargetHeartRateResultCode, result2.setTargetHeartRateResultCode);
        assertEquals(result1.startOrResumeResultCode, result2.startOrResumeResultCode);
        assertEquals(result1.stopOrPauseResultCode, result2.stopOrPauseResultCode);
        assertEquals(result1.setTargetedExpendedEnergyResultCode, result2.setTargetedExpendedEnergyResultCode);
        assertEquals(result1.setTargetedNumberOfStepsResultCode, result2.setTargetedNumberOfStepsResultCode);
        assertEquals(result1.setTargetedNumberOfStridesResultCode, result2.setTargetedNumberOfStridesResultCode);
        assertEquals(result1.setTargetedDistanceResultCode, result2.setTargetedDistanceResultCode);
        assertEquals(result1.setTargetedTrainingTimeResultCode, result2.setTargetedTrainingTimeResultCode);
        assertEquals(result1.setTargetedTimeInTwoHeartRateZonesResultCode, result2.setTargetedTimeInTwoHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInThreeHeartRateZonesResultCode, result2.setTargetedTimeInThreeHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInFiveHeartRateZonesResultCode, result2.setTargetedTimeInFiveHeartRateZonesResultCode);
        assertEquals(result1.setIndoorBikeSimulationParametersResultCode, result2.setIndoorBikeSimulationParametersResultCode);
        assertEquals(result1.setWheelCircumferenceResultCode, result2.setWheelCircumferenceResultCode);
        assertEquals(result1.spinDownControlResultCode, result2.spinDownControlResultCode);
        assertArrayEquals(result1.spinDownControlResultParameter, result2.spinDownControlResultParameter);
        assertEquals(result1.setTargetedCadenceResultCode, result2.setTargetedCadenceResultCode);
    }

    @Test
    public void test_constructor_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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

        Gson gson = new Gson();
        FitnessMachineControlPointCharacteristicData result2 = gson.fromJson(gson.toJson(result1), FitnessMachineControlPointCharacteristicData.class);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.requestControlResultCode, result2.requestControlResultCode);
        assertEquals(result1.resetResultCode, result2.resetResultCode);
        assertEquals(result1.setTargetSpeedResultCode, result2.setTargetSpeedResultCode);
        assertEquals(result1.setTargetInclinationResultCode, result2.setTargetInclinationResultCode);
        assertEquals(result1.setTargetResistanceLevelResultCode, result2.setTargetResistanceLevelResultCode);
        assertEquals(result1.setTargetPowerResultCode, result2.setTargetPowerResultCode);
        assertEquals(result1.setTargetHeartRateResultCode, result2.setTargetHeartRateResultCode);
        assertEquals(result1.startOrResumeResultCode, result2.startOrResumeResultCode);
        assertEquals(result1.stopOrPauseResultCode, result2.stopOrPauseResultCode);
        assertEquals(result1.setTargetedExpendedEnergyResultCode, result2.setTargetedExpendedEnergyResultCode);
        assertEquals(result1.setTargetedNumberOfStepsResultCode, result2.setTargetedNumberOfStepsResultCode);
        assertEquals(result1.setTargetedNumberOfStridesResultCode, result2.setTargetedNumberOfStridesResultCode);
        assertEquals(result1.setTargetedDistanceResultCode, result2.setTargetedDistanceResultCode);
        assertEquals(result1.setTargetedTrainingTimeResultCode, result2.setTargetedTrainingTimeResultCode);
        assertEquals(result1.setTargetedTimeInTwoHeartRateZonesResultCode, result2.setTargetedTimeInTwoHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInThreeHeartRateZonesResultCode, result2.setTargetedTimeInThreeHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInFiveHeartRateZonesResultCode, result2.setTargetedTimeInFiveHeartRateZonesResultCode);
        assertEquals(result1.setIndoorBikeSimulationParametersResultCode, result2.setIndoorBikeSimulationParametersResultCode);
        assertEquals(result1.setWheelCircumferenceResultCode, result2.setWheelCircumferenceResultCode);
        assertEquals(result1.spinDownControlResultCode, result2.spinDownControlResultCode);
        assertArrayEquals(result1.spinDownControlResultParameter, result2.spinDownControlResultParameter);
        assertEquals(result1.setTargetedCadenceResultCode, result2.setTargetedCadenceResultCode);
    }

    @Test
    public void test_setRequestControlResultCode_00001() {
        int firstRequestControlResultCode = 2;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , firstRequestControlResultCode
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

        assertEquals(firstRequestControlResultCode, result1.requestControlResultCode);

        int secondRequestControlResultCode = 22;
        result1.requestControlResultCode = secondRequestControlResultCode;
        assertEquals(secondRequestControlResultCode, result1.requestControlResultCode);
    }

    @Test
    public void test_setResetResultCode_00001() {
        int firstResetResultCode = 3;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , firstResetResultCode
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

        assertEquals(firstResetResultCode, result1.resetResultCode);

        int secondResetResultCode = 33;
        result1.resetResultCode = secondResetResultCode;
        assertEquals(secondResetResultCode, result1.resetResultCode);
    }

    @Test
    public void test_setSetTargetSpeedResultCode_00001() {
        int firstSetTargetSpeedResultCode = 4;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , firstSetTargetSpeedResultCode
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

        assertEquals(firstSetTargetSpeedResultCode, result1.setTargetSpeedResultCode);

        int secondSetTargetSpeedResultCode = 44;
        result1.setTargetSpeedResultCode = secondSetTargetSpeedResultCode;
        assertEquals(secondSetTargetSpeedResultCode, result1.setTargetSpeedResultCode);
    }

    @Test
    public void test_setSetTargetInclinationResultCode_00001() {
        int firstSetTargetInclinationResultCode = 55;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , firstSetTargetInclinationResultCode
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

        assertEquals(firstSetTargetInclinationResultCode, result1.setTargetInclinationResultCode);

        int secondSetTargetInclinationResultCode = 55;
        result1.setTargetInclinationResultCode = secondSetTargetInclinationResultCode;
        assertEquals(secondSetTargetInclinationResultCode, result1.setTargetInclinationResultCode);
    }

    @Test
    public void test_setSetTargetResistanceLevelResultCode_00001() {
        int firstSetTargetResistanceLevelResultCode = 66;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , firstSetTargetResistanceLevelResultCode
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

        assertEquals(firstSetTargetResistanceLevelResultCode, result1.setTargetResistanceLevelResultCode);

        int secondSetTargetResistanceLevelResultCode = 66;
        result1.setTargetResistanceLevelResultCode = secondSetTargetResistanceLevelResultCode;
        assertEquals(secondSetTargetResistanceLevelResultCode, result1.setTargetResistanceLevelResultCode);
    }

    @Test
    public void test_setSetTargetPowerResultCode_00001() {
        int firstSetTargetPowerResultCode = 7;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstSetTargetPowerResultCode
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

        assertEquals(firstSetTargetPowerResultCode, result1.setTargetPowerResultCode);

        int secondSetTargetPowerResultCode = 77;
        result1.setTargetPowerResultCode = secondSetTargetPowerResultCode;
        assertEquals(secondSetTargetPowerResultCode, result1.setTargetPowerResultCode);
    }

    @Test
    public void test_setSetTargetHeartRateResultCode_00001() {
        int firstSetTargetHeartRateResultCode = 8;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstSetTargetHeartRateResultCode
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

        assertEquals(firstSetTargetHeartRateResultCode, result1.setTargetHeartRateResultCode);

        int secondSetTargetHeartRateResultCode = 88;
        result1.setTargetHeartRateResultCode = secondSetTargetHeartRateResultCode;
        assertEquals(secondSetTargetHeartRateResultCode, result1.setTargetHeartRateResultCode);
    }

    @Test
    public void test_setStartOrResumeResultCode_00001() {
        int firstStartOrResumeResultCode = 9;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , firstStartOrResumeResultCode
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

        assertEquals(firstStartOrResumeResultCode, result1.startOrResumeResultCode);

        int secondStartOrResumeResultCode = 99;
        result1.startOrResumeResultCode = secondStartOrResumeResultCode;
        assertEquals(secondStartOrResumeResultCode, result1.startOrResumeResultCode);
    }

    @Test
    public void test_setStopOrPauseResultCode_00001() {
        int firstStopOrPauseResultCode = 10;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , firstStopOrPauseResultCode
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

        assertEquals(firstStopOrPauseResultCode, result1.stopOrPauseResultCode);

        int secondStopOrPauseResultCode = 110;
        result1.stopOrPauseResultCode = secondStopOrPauseResultCode;
        assertEquals(secondStopOrPauseResultCode, result1.stopOrPauseResultCode);
    }

    @Test
    public void test_setSetTargetedExpendedEnergyResultCode_00001() {
        int firstSetTargetedExpendedEnergyResultCode = 11;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedExpendedEnergyResultCode
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

        assertEquals(firstSetTargetedExpendedEnergyResultCode, result1.setTargetedExpendedEnergyResultCode);

        int secondSetTargetedExpendedEnergyResultCode = 111;
        result1.setTargetedExpendedEnergyResultCode = secondSetTargetedExpendedEnergyResultCode;
        assertEquals(secondSetTargetedExpendedEnergyResultCode, result1.setTargetedExpendedEnergyResultCode);
    }

    @Test
    public void test_setSetTargetedNumberOfStepsResultCode_00001() {
        int firstSetTargetedNumberOfStepsResultCode = 12;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedNumberOfStepsResultCode
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

        assertEquals(firstSetTargetedNumberOfStepsResultCode, result1.setTargetedNumberOfStepsResultCode);

        int secondSetTargetedNumberOfStepsResultCode = 112;
        result1.setTargetedNumberOfStepsResultCode = secondSetTargetedNumberOfStepsResultCode;
        assertEquals(secondSetTargetedNumberOfStepsResultCode, result1.setTargetedNumberOfStepsResultCode);
    }

    @Test
    public void test_setSetTargetedNumberOfStridesResultCode_00001() {
        int firstSetTargetedNumberOfStridesResultCode = 13;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedNumberOfStridesResultCode
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

        assertEquals(firstSetTargetedNumberOfStridesResultCode, result1.setTargetedNumberOfStridesResultCode);

        int secondSetTargetedNumberOfStridesResultCode = 113;
        result1.setTargetedNumberOfStridesResultCode = secondSetTargetedNumberOfStridesResultCode;
        assertEquals(secondSetTargetedNumberOfStridesResultCode, result1.setTargetedNumberOfStridesResultCode);
    }

    @Test
    public void test_setSetTargetedDistanceResultCode_00001() {
        int firstSetTargetedDistanceResultCode = 14;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedDistanceResultCode
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetTargetedDistanceResultCode, result1.setTargetedDistanceResultCode);

        int secondSetTargetedDistanceResultCode = 114;
        result1.setTargetedDistanceResultCode = secondSetTargetedDistanceResultCode;
        assertEquals(secondSetTargetedDistanceResultCode, result1.setTargetedDistanceResultCode);
    }

    @Test
    public void test_setSetTargetedTrainingTimeResultCode_00001() {
        int firstSetTargetedTrainingTimeResultCode = 15;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedTrainingTimeResultCode
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetTargetedTrainingTimeResultCode, result1.setTargetedTrainingTimeResultCode);

        int secondSetTargetedTrainingTimeResultCode = 115;
        result1.setTargetedTrainingTimeResultCode = secondSetTargetedTrainingTimeResultCode;
        assertEquals(secondSetTargetedTrainingTimeResultCode, result1.setTargetedTrainingTimeResultCode);
    }

    @Test
    public void test_setSetTargetedTimeInTwoHeartRateZonesResultCode_00001() {
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetTargetedTimeInTwoHeartRateZonesResultCode, result1.setTargetedTimeInTwoHeartRateZonesResultCode);

        int secondSetTargetedTimeInTwoHeartRateZonesResultCode = 116;
        result1.setTargetedTimeInTwoHeartRateZonesResultCode = secondSetTargetedTimeInTwoHeartRateZonesResultCode;
        assertEquals(secondSetTargetedTimeInTwoHeartRateZonesResultCode, result1.setTargetedTimeInTwoHeartRateZonesResultCode);
    }

    @Test
    public void test_setSetTargetedTimeInThreeHeartRateZonesResultCode_00001() {
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetTargetedTimeInThreeHeartRateZonesResultCode, result1.setTargetedTimeInThreeHeartRateZonesResultCode);

        int secondSetTargetedTimeInThreeHeartRateZonesResultCode = 117;
        result1.setTargetedTimeInThreeHeartRateZonesResultCode = secondSetTargetedTimeInThreeHeartRateZonesResultCode;
        assertEquals(secondSetTargetedTimeInThreeHeartRateZonesResultCode, result1.setTargetedTimeInThreeHeartRateZonesResultCode);
    }

    @Test
    public void test_setSetTargetedTimeInFiveHeartRateZonesResultCode_00001() {
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetTargetedTimeInFiveHeartRateZonesResultCode, result1.setTargetedTimeInFiveHeartRateZonesResultCode);

        int secondSetTargetedTimeInFiveHeartRateZonesResultCode = 118;
        result1.setTargetedTimeInFiveHeartRateZonesResultCode = secondSetTargetedTimeInFiveHeartRateZonesResultCode;
        assertEquals(secondSetTargetedTimeInFiveHeartRateZonesResultCode, result1.setTargetedTimeInFiveHeartRateZonesResultCode);
    }

    @Test
    public void test_setSetIndoorBikeSimulationParametersResultCode_00001() {
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetIndoorBikeSimulationParametersResultCode
                , 20
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetIndoorBikeSimulationParametersResultCode, result1.setIndoorBikeSimulationParametersResultCode);

        int secondSetIndoorBikeSimulationParametersResultCode = 119;
        result1.setIndoorBikeSimulationParametersResultCode = secondSetIndoorBikeSimulationParametersResultCode;
        assertEquals(secondSetIndoorBikeSimulationParametersResultCode, result1.setIndoorBikeSimulationParametersResultCode);
    }

    @Test
    public void test_setSetWheelCircumferenceResultCode_00001() {
        int firstSetWheelCircumferenceResultCode = 20;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetWheelCircumferenceResultCode
                , 21
                , new byte[]{22}
                , 23);

        assertEquals(firstSetWheelCircumferenceResultCode, result1.setWheelCircumferenceResultCode);

        int secondSetWheelCircumferenceResultCode = 120;
        result1.setWheelCircumferenceResultCode = secondSetWheelCircumferenceResultCode;
        assertEquals(secondSetWheelCircumferenceResultCode, result1.setWheelCircumferenceResultCode);
    }

    @Test
    public void test_setSpinDownControlResultCode_00001() {
        int firstSpinDownControlResultCode = 21;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSpinDownControlResultCode
                , new byte[]{22}
                , 23);

        assertEquals(firstSpinDownControlResultCode, result1.spinDownControlResultCode);

        int secondSpinDownControlResultCode = 121;
        result1.spinDownControlResultCode = secondSpinDownControlResultCode;
        assertEquals(secondSpinDownControlResultCode, result1.spinDownControlResultCode);
    }

    @Test
    public void test_setSpinDownControlResultParameter_00001() {
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSpinDownControlResultParameter
                , 23);

        assertArrayEquals(firstSpinDownControlResultParameter, result1.spinDownControlResultParameter);

        byte[] secondSpinDownControlResultParameter = new byte[]{122};
        result1.spinDownControlResultParameter = secondSpinDownControlResultParameter;
        assertArrayEquals(secondSpinDownControlResultParameter, result1.spinDownControlResultParameter);
    }

    @Test
    public void test_setSetTargetedCadenceResultCode_00001() {
        int firstSetTargetedCadenceResultCode = 23;
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(new ArrayList<>()
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
                , firstSetTargetedCadenceResultCode);

        assertEquals(firstSetTargetedCadenceResultCode, result1.setTargetedCadenceResultCode);

        int secondSetTargetedCadenceResultCode = 123;
        result1.setTargetedCadenceResultCode = secondSetTargetedCadenceResultCode;
        assertEquals(secondSetTargetedCadenceResultCode, result1.setTargetedCadenceResultCode);
    }

    @Test
    public void test_getBytes_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstRequestControlResultCode = 2;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , firstRequestControlResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL
                , firstRequestControlResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstResetResultCode = 3;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , firstResetResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESET
                , firstResetResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetSpeedResultCode = 4;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , firstSetTargetSpeedResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED
                , firstSetTargetSpeedResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00004() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetInclinationResultCode = 5;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , firstSetTargetInclinationResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION
                , firstSetTargetInclinationResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00005() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetResistanceLevelResultCode = 6;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , firstSetTargetResistanceLevelResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL
                , firstSetTargetResistanceLevelResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00006() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetPowerResultCode = 7;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , firstSetTargetPowerResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER
                , firstSetTargetPowerResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00007() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetHeartRateResultCode = 8;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , firstSetTargetHeartRateResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE
                , firstSetTargetHeartRateResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00008() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstStartOrResumeResultCode = 9;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , firstStartOrResumeResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_START_OR_RESUME
                , firstStartOrResumeResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_START_OR_RESUME
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00009() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstStopOrPauseResultCode = 10;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , 1
                , 2
                , 3
                , 4
                , 5
                , 6
                , 7
                , 8
                , 9
                , firstStopOrPauseResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE
                , firstStopOrPauseResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00010() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedExpendedEnergyResultCode = 11;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedExpendedEnergyResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY
                , firstSetTargetedExpendedEnergyResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00011() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedNumberOfStepsResultCode = 12;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedNumberOfStepsResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS
                , firstSetTargetedNumberOfStepsResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00012() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedNumberOfStridesResultCode = 13;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedNumberOfStridesResultCode
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
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES
                , firstSetTargetedNumberOfStridesResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00013() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedDistanceResultCode = 14;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedDistanceResultCode
                , 15
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE
                , firstSetTargetedDistanceResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00014() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedTrainingTimeResultCode = 15;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedTrainingTimeResultCode
                , 16
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME
                , firstSetTargetedTrainingTimeResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00015() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , 17
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00016() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , 18
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00017() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , 19
                , 20
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00018() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetIndoorBikeSimulationParametersResultCode
                , 20
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES
                , firstSetIndoorBikeSimulationParametersResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00019() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetWheelCircumferenceResultCode = 20;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetWheelCircumferenceResultCode
                , 21
                , new byte[]{22}
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE
                , firstSetWheelCircumferenceResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00020() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , 23);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_getBytes_00021() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));

        byte[] firstData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED
                , new byte[0]).getBytes();
        int firstSetTargetedCadenceResultCode = 23;
        FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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
                , firstSetTargetedCadenceResultCode);
        assertArrayEquals(firstData, fitnessMachineControlPointCharacteristicData.getBytes());

        byte[] secondData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE
                , new byte[0]
                , FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE
                , firstSetTargetedCadenceResultCode
                , new byte[0]).getBytes();
        fitnessMachineControlPointCharacteristicData.currentData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE
                , new byte[0]
                , 0
                , 0
                , new byte[0]).getBytes();
        assertArrayEquals(secondData, fitnessMachineControlPointCharacteristicData.getBytes());
    }

    @Test
    public void test_parcelable_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointCharacteristicData result2 = FitnessMachineControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result2.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.requestControlResultCode, result2.requestControlResultCode);
        assertEquals(result1.resetResultCode, result2.resetResultCode);
        assertEquals(result1.setTargetSpeedResultCode, result2.setTargetSpeedResultCode);
        assertEquals(result1.setTargetInclinationResultCode, result2.setTargetInclinationResultCode);
        assertEquals(result1.setTargetResistanceLevelResultCode, result2.setTargetResistanceLevelResultCode);
        assertEquals(result1.setTargetPowerResultCode, result2.setTargetPowerResultCode);
        assertEquals(result1.setTargetHeartRateResultCode, result2.setTargetHeartRateResultCode);
        assertEquals(result1.startOrResumeResultCode, result2.startOrResumeResultCode);
        assertEquals(result1.stopOrPauseResultCode, result2.stopOrPauseResultCode);
        assertEquals(result1.setTargetedExpendedEnergyResultCode, result2.setTargetedExpendedEnergyResultCode);
        assertEquals(result1.setTargetedNumberOfStepsResultCode, result2.setTargetedNumberOfStepsResultCode);
        assertEquals(result1.setTargetedNumberOfStridesResultCode, result2.setTargetedNumberOfStridesResultCode);
        assertEquals(result1.setTargetedDistanceResultCode, result2.setTargetedDistanceResultCode);
        assertEquals(result1.setTargetedTrainingTimeResultCode, result2.setTargetedTrainingTimeResultCode);
        assertEquals(result1.setTargetedTimeInTwoHeartRateZonesResultCode, result2.setTargetedTimeInTwoHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInThreeHeartRateZonesResultCode, result2.setTargetedTimeInThreeHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInFiveHeartRateZonesResultCode, result2.setTargetedTimeInFiveHeartRateZonesResultCode);
        assertEquals(result1.setIndoorBikeSimulationParametersResultCode, result2.setIndoorBikeSimulationParametersResultCode);
        assertEquals(result1.setWheelCircumferenceResultCode, result2.setWheelCircumferenceResultCode);
        assertEquals(result1.spinDownControlResultCode, result2.spinDownControlResultCode);
        assertArrayEquals(result1.spinDownControlResultParameter, result2.spinDownControlResultParameter);
        assertEquals(result1.setTargetedCadenceResultCode, result2.setTargetedCadenceResultCode);
    }

    @Test
    public void test_parcelable_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(descriptorDataList
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

        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineControlPointCharacteristicData result2 = FitnessMachineControlPointCharacteristicData.CREATOR.createFromParcel(parcel);

        assertEquals(result1.uuid, result2.uuid);
        assertEquals(result1.property, result2.property);
        assertEquals(result1.permission, result2.permission);
        assertNotNull(result1.descriptorDataList);
        assertEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertArrayEquals(result1.descriptorDataList.toArray(), result2.descriptorDataList.toArray());
        result1.descriptorDataList.clear();
        assertNotEquals(result1.descriptorDataList.size(), result2.descriptorDataList.size());
        assertEquals(result1.responseCode, result2.responseCode);
        assertEquals(result1.delay, result2.delay);
        assertArrayEquals(result1.data, result2.data);
        assertEquals(result1.notificationCount, result2.notificationCount);
        assertEquals(result1.requestControlResultCode, result2.requestControlResultCode);
        assertEquals(result1.resetResultCode, result2.resetResultCode);
        assertEquals(result1.setTargetSpeedResultCode, result2.setTargetSpeedResultCode);
        assertEquals(result1.setTargetInclinationResultCode, result2.setTargetInclinationResultCode);
        assertEquals(result1.setTargetResistanceLevelResultCode, result2.setTargetResistanceLevelResultCode);
        assertEquals(result1.setTargetPowerResultCode, result2.setTargetPowerResultCode);
        assertEquals(result1.setTargetHeartRateResultCode, result2.setTargetHeartRateResultCode);
        assertEquals(result1.startOrResumeResultCode, result2.startOrResumeResultCode);
        assertEquals(result1.stopOrPauseResultCode, result2.stopOrPauseResultCode);
        assertEquals(result1.setTargetedExpendedEnergyResultCode, result2.setTargetedExpendedEnergyResultCode);
        assertEquals(result1.setTargetedNumberOfStepsResultCode, result2.setTargetedNumberOfStepsResultCode);
        assertEquals(result1.setTargetedNumberOfStridesResultCode, result2.setTargetedNumberOfStridesResultCode);
        assertEquals(result1.setTargetedDistanceResultCode, result2.setTargetedDistanceResultCode);
        assertEquals(result1.setTargetedTrainingTimeResultCode, result2.setTargetedTrainingTimeResultCode);
        assertEquals(result1.setTargetedTimeInTwoHeartRateZonesResultCode, result2.setTargetedTimeInTwoHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInThreeHeartRateZonesResultCode, result2.setTargetedTimeInThreeHeartRateZonesResultCode);
        assertEquals(result1.setTargetedTimeInFiveHeartRateZonesResultCode, result2.setTargetedTimeInFiveHeartRateZonesResultCode);
        assertEquals(result1.setIndoorBikeSimulationParametersResultCode, result2.setIndoorBikeSimulationParametersResultCode);
        assertEquals(result1.setWheelCircumferenceResultCode, result2.setWheelCircumferenceResultCode);
        assertEquals(result1.spinDownControlResultCode, result2.spinDownControlResultCode);
        assertArrayEquals(result1.spinDownControlResultParameter, result2.spinDownControlResultParameter);
        assertEquals(result1.setTargetedCadenceResultCode, result2.setTargetedCadenceResultCode);
    }

    @Test
    public void test_hashCode_00001() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long delay = 1;
        int requestControlResultCode = 2;
        int resetResultCode = 3;
        int setTargetSpeedResultCode = 4;
        int setTargetInclinationResultCode = 5;
        int setTargetResistanceLevelResultCode = 6;
        int setTargetPowerResultCode = 7;
        int setTargetHeartRateResultCode = 8;
        int startOrResumeResultCode = 9;
        int stopOrPauseResultCode = 10;
        int setTargetedExpendedEnergyResultCode = 11;
        int setTargetedNumberOfStepsResultCode = 12;
        int setTargetedNumberOfStridesResultCode = 13;
        int setTargetedDistanceResultCode = 14;
        int setTargetedTrainingTimeResultCode = 15;
        int setTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int setTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int setTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int setIndoorBikeSimulationParametersResultCode = 19;
        int setWheelCircumferenceResultCode = 20;
        int spinDownControlResultCode = 21;
        byte[] spinDownControlResultParameter = new byte[]{22};
        int setTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , delay
                , requestControlResultCode
                , resetResultCode
                , setTargetSpeedResultCode
                , setTargetInclinationResultCode
                , setTargetResistanceLevelResultCode
                , setTargetPowerResultCode
                , setTargetHeartRateResultCode
                , startOrResumeResultCode
                , stopOrPauseResultCode
                , setTargetedExpendedEnergyResultCode
                , setTargetedNumberOfStepsResultCode
                , setTargetedNumberOfStridesResultCode
                , setTargetedDistanceResultCode
                , setTargetedTrainingTimeResultCode
                , setTargetedTimeInTwoHeartRateZonesResultCode
                , setTargetedTimeInThreeHeartRateZonesResultCode
                , setTargetedTimeInFiveHeartRateZonesResultCode
                , setIndoorBikeSimulationParametersResultCode
                , setWheelCircumferenceResultCode
                , spinDownControlResultCode
                , spinDownControlResultParameter
                , setTargetedCadenceResultCode);

        assertEquals(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(requestControlResultCode).hashCode()
                        ^ Integer.valueOf(resetResultCode).hashCode()
                        ^ Integer.valueOf(setTargetSpeedResultCode).hashCode()
                        ^ Integer.valueOf(setTargetInclinationResultCode).hashCode()
                        ^ Integer.valueOf(setTargetResistanceLevelResultCode).hashCode()
                        ^ Integer.valueOf(setTargetPowerResultCode).hashCode()
                        ^ Integer.valueOf(setTargetHeartRateResultCode).hashCode()
                        ^ Integer.valueOf(startOrResumeResultCode).hashCode()
                        ^ Integer.valueOf(stopOrPauseResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedExpendedEnergyResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedNumberOfStepsResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedNumberOfStridesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedDistanceResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTrainingTimeResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInTwoHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInThreeHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInFiveHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setIndoorBikeSimulationParametersResultCode).hashCode()
                        ^ Integer.valueOf(setWheelCircumferenceResultCode).hashCode()
                        ^ Integer.valueOf(spinDownControlResultCode).hashCode()
                        ^ Arrays.hashCode(spinDownControlResultParameter)
                        ^ Integer.valueOf(setTargetedCadenceResultCode).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00002() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long delay = 1;
        int requestControlResultCode = 2;
        int resetResultCode = 3;
        int setTargetSpeedResultCode = 4;
        int setTargetInclinationResultCode = 5;
        int setTargetResistanceLevelResultCode = 6;
        int setTargetPowerResultCode = 7;
        int setTargetHeartRateResultCode = 8;
        int startOrResumeResultCode = 9;
        int stopOrPauseResultCode = 10;
        int setTargetedExpendedEnergyResultCode = 11;
        int setTargetedNumberOfStepsResultCode = 12;
        int setTargetedNumberOfStridesResultCode = 13;
        int setTargetedDistanceResultCode = 14;
        int setTargetedTrainingTimeResultCode = 15;
        int setTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int setTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int setTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int setIndoorBikeSimulationParametersResultCode = 19;
        int setWheelCircumferenceResultCode = 20;
        int spinDownControlResultCode = 21;
        byte[] spinDownControlResultParameter = new byte[]{22};
        int setTargetedCadenceResultCode = 23;
        byte[] currentData = new byte[]{28};
        Map<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(29, new byte[]{30});

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , delay
                , requestControlResultCode
                , resetResultCode
                , setTargetSpeedResultCode
                , setTargetInclinationResultCode
                , setTargetResistanceLevelResultCode
                , setTargetPowerResultCode
                , setTargetHeartRateResultCode
                , startOrResumeResultCode
                , stopOrPauseResultCode
                , setTargetedExpendedEnergyResultCode
                , setTargetedNumberOfStepsResultCode
                , setTargetedNumberOfStridesResultCode
                , setTargetedDistanceResultCode
                , setTargetedTrainingTimeResultCode
                , setTargetedTimeInTwoHeartRateZonesResultCode
                , setTargetedTimeInThreeHeartRateZonesResultCode
                , setTargetedTimeInFiveHeartRateZonesResultCode
                , setIndoorBikeSimulationParametersResultCode
                , setWheelCircumferenceResultCode
                , spinDownControlResultCode
                , spinDownControlResultParameter
                , setTargetedCadenceResultCode);

        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);

        assertNotEquals(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ temporaryData.hashCode()
                        ^ Integer.valueOf(requestControlResultCode).hashCode()
                        ^ Integer.valueOf(resetResultCode).hashCode()
                        ^ Integer.valueOf(setTargetSpeedResultCode).hashCode()
                        ^ Integer.valueOf(setTargetInclinationResultCode).hashCode()
                        ^ Integer.valueOf(setTargetResistanceLevelResultCode).hashCode()
                        ^ Integer.valueOf(setTargetPowerResultCode).hashCode()
                        ^ Integer.valueOf(setTargetHeartRateResultCode).hashCode()
                        ^ Integer.valueOf(startOrResumeResultCode).hashCode()
                        ^ Integer.valueOf(stopOrPauseResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedExpendedEnergyResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedNumberOfStepsResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedNumberOfStridesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedDistanceResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTrainingTimeResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInTwoHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInThreeHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInFiveHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setIndoorBikeSimulationParametersResultCode).hashCode()
                        ^ Integer.valueOf(setWheelCircumferenceResultCode).hashCode()
                        ^ Integer.valueOf(spinDownControlResultCode).hashCode()
                        ^ Arrays.hashCode(spinDownControlResultParameter)
                        ^ Integer.valueOf(setTargetedCadenceResultCode).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_hashCode_00003() {
        List<DescriptorData> descriptorDataList = new ArrayList<>();
        descriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long delay = 1;
        int requestControlResultCode = 2;
        int resetResultCode = 3;
        int setTargetSpeedResultCode = 4;
        int setTargetInclinationResultCode = 5;
        int setTargetResistanceLevelResultCode = 6;
        int setTargetPowerResultCode = 7;
        int setTargetHeartRateResultCode = 8;
        int startOrResumeResultCode = 9;
        int stopOrPauseResultCode = 10;
        int setTargetedExpendedEnergyResultCode = 11;
        int setTargetedNumberOfStepsResultCode = 12;
        int setTargetedNumberOfStridesResultCode = 13;
        int setTargetedDistanceResultCode = 14;
        int setTargetedTrainingTimeResultCode = 15;
        int setTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int setTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int setTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int setIndoorBikeSimulationParametersResultCode = 19;
        int setWheelCircumferenceResultCode = 20;
        int spinDownControlResultCode = 21;
        byte[] spinDownControlResultParameter = new byte[]{22};
        int setTargetedCadenceResultCode = 23;
        byte[] currentData = new byte[]{28};
        Map<Integer, byte[]> temporaryData = new HashMap<>();
        temporaryData.put(29, new byte[]{30});

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(descriptorDataList
                , delay
                , requestControlResultCode
                , resetResultCode
                , setTargetSpeedResultCode
                , setTargetInclinationResultCode
                , setTargetResistanceLevelResultCode
                , setTargetPowerResultCode
                , setTargetHeartRateResultCode
                , startOrResumeResultCode
                , stopOrPauseResultCode
                , setTargetedExpendedEnergyResultCode
                , setTargetedNumberOfStepsResultCode
                , setTargetedNumberOfStridesResultCode
                , setTargetedDistanceResultCode
                , setTargetedTrainingTimeResultCode
                , setTargetedTimeInTwoHeartRateZonesResultCode
                , setTargetedTimeInThreeHeartRateZonesResultCode
                , setTargetedTimeInFiveHeartRateZonesResultCode
                , setIndoorBikeSimulationParametersResultCode
                , setWheelCircumferenceResultCode
                , spinDownControlResultCode
                , spinDownControlResultParameter
                , setTargetedCadenceResultCode);

        result1.currentData = currentData;
        result1.temporaryData.putAll(temporaryData);

        int hashCode = 0;
        for (Map.Entry<Integer, byte[]> entry : temporaryData.entrySet()) {
            hashCode ^= entry.getKey().hashCode();
            hashCode ^= Arrays.hashCode(entry.getValue());
        }
        assertEquals(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE).hashCode()
                        ^ Integer.valueOf(BluetoothGattCharacteristic.PERMISSION_WRITE).hashCode()
                        ^ Arrays.hashCode(descriptorDataList.toArray())
                        ^ Integer.valueOf(BluetoothGatt.GATT_SUCCESS).hashCode()
                        ^ Long.valueOf(delay).hashCode()
                        ^ Arrays.hashCode((byte[]) null)
                        ^ Integer.valueOf(0).hashCode()
                        ^ Arrays.hashCode(currentData)
                        ^ hashCode
                        ^ Integer.valueOf(requestControlResultCode).hashCode()
                        ^ Integer.valueOf(resetResultCode).hashCode()
                        ^ Integer.valueOf(setTargetSpeedResultCode).hashCode()
                        ^ Integer.valueOf(setTargetInclinationResultCode).hashCode()
                        ^ Integer.valueOf(setTargetResistanceLevelResultCode).hashCode()
                        ^ Integer.valueOf(setTargetPowerResultCode).hashCode()
                        ^ Integer.valueOf(setTargetHeartRateResultCode).hashCode()
                        ^ Integer.valueOf(startOrResumeResultCode).hashCode()
                        ^ Integer.valueOf(stopOrPauseResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedExpendedEnergyResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedNumberOfStepsResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedNumberOfStridesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedDistanceResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTrainingTimeResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInTwoHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInThreeHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setTargetedTimeInFiveHeartRateZonesResultCode).hashCode()
                        ^ Integer.valueOf(setIndoorBikeSimulationParametersResultCode).hashCode()
                        ^ Integer.valueOf(setWheelCircumferenceResultCode).hashCode()
                        ^ Integer.valueOf(spinDownControlResultCode).hashCode()
                        ^ Arrays.hashCode(spinDownControlResultParameter)
                        ^ Integer.valueOf(setTargetedCadenceResultCode).hashCode()
                , result1.hashCode());
    }

    @Test
    public void test_equals_00001() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertEquals(result1, result2);
    }

    @Test
    public void test_equals_00002() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        List<DescriptorData> secondDescriptorDataList = new ArrayList<>();
        secondDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 28, 29, 30, new byte[]{31}));

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(secondDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00003() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        long secondDelay = 101;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , secondDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00004() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondRequestControlResultCode = 102;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , secondRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00005() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondResetResultCode = 103;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , secondResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00006() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetSpeedResultCode = 104;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , secondSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00007() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetInclinationResultCode = 105;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , secondSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00008() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetResistanceLevelResultCode = 106;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , secondSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00009() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetPowerResultCode = 107;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , secondSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00010() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetHeartRateResultCode = 108;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , secondSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00011() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondStartOrResumeResultCode = 109;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , secondStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00012() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondStopOrPauseResultCode = 110;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , secondStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00013() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedExpendedEnergyResultCode = 111;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , secondSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00014() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedNumberOfStepsResultCode = 112;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , secondSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00015() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedNumberOfStridesResultCode = 113;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , secondSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00016() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedDistanceResultCode = 114;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , secondSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00017() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedTrainingTimeResultCode = 115;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , secondSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00018() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedTimeInTwoHeartRateZonesResultCode = 116;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , secondSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00019() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedTimeInThreeHeartRateZonesResultCode = 117;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , secondSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00020() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedTimeInFiveHeartRateZonesResultCode = 118;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , secondSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00021() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetIndoorBikeSimulationParametersResultCode = 119;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , secondSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00022() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetWheelCircumferenceResultCode = 120;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , secondSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00023() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSpinDownControlResultCode = 121;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , secondSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00024() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        byte[] secondSpinDownControlResultParameter = new byte[]{122};

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , secondSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

    @Test
    public void test_equals_00025() {
        List<DescriptorData> firstDescriptorDataList = new ArrayList<>();
        firstDescriptorDataList.add(new DescriptorData(UUID.randomUUID(), 24, 25, 26, new byte[]{27}));
        long firstDelay = 1;
        int firstRequestControlResultCode = 2;
        int firstResetResultCode = 3;
        int firstSetTargetSpeedResultCode = 4;
        int firstSetTargetInclinationResultCode = 5;
        int firstSetTargetResistanceLevelResultCode = 6;
        int firstSetTargetPowerResultCode = 7;
        int firstSetTargetHeartRateResultCode = 8;
        int firstStartOrResumeResultCode = 9;
        int firstStopOrPauseResultCode = 10;
        int firstSetTargetedExpendedEnergyResultCode = 11;
        int firstSetTargetedNumberOfStepsResultCode = 12;
        int firstSetTargetedNumberOfStridesResultCode = 13;
        int firstSetTargetedDistanceResultCode = 14;
        int firstSetTargetedTrainingTimeResultCode = 15;
        int firstSetTargetedTimeInTwoHeartRateZonesResultCode = 16;
        int firstSetTargetedTimeInThreeHeartRateZonesResultCode = 17;
        int firstSetTargetedTimeInFiveHeartRateZonesResultCode = 18;
        int firstSetIndoorBikeSimulationParametersResultCode = 19;
        int firstSetWheelCircumferenceResultCode = 20;
        int firstSpinDownControlResultCode = 21;
        byte[] firstSpinDownControlResultParameter = new byte[]{22};
        int firstSetTargetedCadenceResultCode = 23;

        FitnessMachineControlPointCharacteristicData result1 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , firstSetTargetedCadenceResultCode);

        int secondSetTargetedCadenceResultCode = 123;

        FitnessMachineControlPointCharacteristicData result2 = new FitnessMachineControlPointCharacteristicData(firstDescriptorDataList
                , firstDelay
                , firstRequestControlResultCode
                , firstResetResultCode
                , firstSetTargetSpeedResultCode
                , firstSetTargetInclinationResultCode
                , firstSetTargetResistanceLevelResultCode
                , firstSetTargetPowerResultCode
                , firstSetTargetHeartRateResultCode
                , firstStartOrResumeResultCode
                , firstStopOrPauseResultCode
                , firstSetTargetedExpendedEnergyResultCode
                , firstSetTargetedNumberOfStepsResultCode
                , firstSetTargetedNumberOfStridesResultCode
                , firstSetTargetedDistanceResultCode
                , firstSetTargetedTrainingTimeResultCode
                , firstSetTargetedTimeInTwoHeartRateZonesResultCode
                , firstSetTargetedTimeInThreeHeartRateZonesResultCode
                , firstSetTargetedTimeInFiveHeartRateZonesResultCode
                , firstSetIndoorBikeSimulationParametersResultCode
                , firstSetWheelCircumferenceResultCode
                , firstSpinDownControlResultCode
                , firstSpinDownControlResultParameter
                , secondSetTargetedCadenceResultCode);

        assertNotEquals(result1, result2);
    }

}
