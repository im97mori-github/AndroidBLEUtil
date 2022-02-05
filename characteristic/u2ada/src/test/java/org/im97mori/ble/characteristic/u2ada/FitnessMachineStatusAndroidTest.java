package org.im97mori.ble.characteristic.u2ada;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Build;
import android.os.Parcel;

import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.Arrays;

import static org.im97mori.ble.BLEUtils.BASE_UUID;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unused")
@RunWith(RobolectricTestRunner.class)
@Config(instrumentedPackages = {
        // required to access final members on androidx.loader.content.ModernAsyncTask
        "androidx.loader.content"}
        , sdk = Build.VERSION_CODES.JELLY_BEAN_MR2)
public class FitnessMachineStatusAndroidTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[1];
        data[ 0] = FitnessMachineStatus.OP_CODE_RESET;
        data_00001 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER;
        data[ 1] = FitnessMachineControlPoint.STOP_OR_PAUSE_STOP;
        data_00101 = data;
    }

    private static final byte[] data_00102;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER;
        data[ 1] = FitnessMachineControlPoint.STOP_OR_PAUSE_PAUSE;
        data_00102 = data;
    }

    private static final byte[] data_00201;
    static {
        byte[] data = new byte[1];
        data[ 0] = FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY;
        data_00201 = data;
    }

    private static final byte[] data_00301;
    static {
        byte[] data = new byte[1];
        data[ 0] = FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER;
        data_00301 = data;
    }

    private static final byte[] data_00401;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGET_SPEED_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00401 = data;
    }

    private static final byte[] data_00501;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGET_INCLINE_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00501 = data;
    }

    private static final byte[] data_00601;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGET_RESISTANCE_LEVEL_CHANGED;
        data[ 1] = 0x01;
        data_00601 = data;
    }

    private static final byte[] data_00701;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGET_POWER_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00701 = data;
    }

    private static final byte[] data_00801;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGET_HEART_RATE_CHANGED;
        data[ 1] = 0x01;
        data_00801 = data;
    }

    private static final byte[] data_00901;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_EXPENDED_ENERGY_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_00901 = data;
    }

    private static final byte[] data_01001;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_NUMBER_OF_STEPS_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01001 = data;
    }

    private static final byte[] data_01101;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_NUMBER_OF_STRIDES_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01101 = data;
    }

    private static final byte[] data_01201;
    static {
        byte[] data = new byte[4];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_DISTANCE_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data_01201 = data;
    }

    private static final byte[] data_01301;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_TRAINING_TIME_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01301 = data;
    }

    private static final byte[] data_01401;
    static {
        byte[] data = new byte[5];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data_01401 = data;
    }

    private static final byte[] data_01501;
    static {
        byte[] data = new byte[7];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_01501 = data;
    }

    private static final byte[] data_01601;
    static {
        byte[] data = new byte[11];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data[ 7] = 0x07;
        data[ 8] = 0x08;
        data[ 9] = 0x09;
        data[10] = 0x0a;
        data_01601 = data;
    }

    private static final byte[] data_01701;
    static {
        byte[] data = new byte[7];
        data[ 0] = FitnessMachineStatus.OP_CODE_INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data[ 3] = 0x03;
        data[ 4] = 0x04;
        data[ 5] = 0x05;
        data[ 6] = 0x06;
        data_01701 = data;
    }

    private static final byte[] data_01801;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_WHEEL_CIRCUMFERENCE_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_01801 = data;
    }

    private static final byte[] data_01901;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS;
        data[ 1] = FitnessMachineStatus.SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED;
        data_01901 = data;
    }

    private static final byte[] data_01902;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS;
        data[ 1] = FitnessMachineStatus.SPIN_DOWN_STATUS_SUCCESS;
        data_01902 = data;
    }

    private static final byte[] data_01903;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS;
        data[ 1] = FitnessMachineStatus.SPIN_DOWN_STATUS_ERROR;
        data_01903 = data;
    }

    private static final byte[] data_01904;
    static {
        byte[] data = new byte[2];
        data[ 0] = FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS;
        data[ 1] = FitnessMachineStatus.SPIN_DOWN_STATUS_STOP_PEDALING;
        data_01904 = data;
    }

    private static final byte[] data_02001;
    static {
        byte[] data = new byte[3];
        data[ 0] = FitnessMachineStatus.OP_CODE_TARGETED_CADENCE_CHANGED;
        data[ 1] = 0x01;
        data[ 2] = 0x02;
        data_02001 = data;
    }

    private static final byte[] data_02101;
    static {
        byte[] data = new byte[1];
        data[ 0] = (byte) FitnessMachineStatus.OP_CODE_CONTROL_PERMISSION_LOST;
        data_02101 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_RESET, result1.getOpCode());
        assertTrue(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertTrue(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertArrayEquals(Arrays.copyOfRange(data, 1, 2), result1.getParameter());
        assertTrue(result1.isStopOrPauseStop());
        assertFalse(result1.isStopOrPausePause());
    }

    @Test
    public void test_constructor_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertTrue(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertArrayEquals(Arrays.copyOfRange(data, 1, 2), result1.getParameter());
        assertFalse(result1.isStopOrPauseStop());
        assertTrue(result1.isStopOrPausePause());
    }

    @Test
    public void test_constructor_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertTrue(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
    }

    @Test
    public void test_constructor_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertTrue(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
    }

    @Test
    public void test_constructor_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGET_SPEED_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertTrue(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.getTargetSpeedChanged());
        assertEquals(FitnessMachineStatus.TARGET_SPEED_CHANGED_RESOLUTION * 0x0201, result1.getTargetSpeedChangedKmH(), 0);
    }

    @Test
    public void test_constructor_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGET_INCLINE_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertTrue(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.getTargetInclineChanged());
        assertEquals(FitnessMachineStatus.TARGET_INCLINE_CHANGED_RESOLUTION * 0x0201, result1.getTargetInclineChangedPercent(), 0);
    }

    @Test
    public void test_constructor_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGET_RESISTANCE_LEVEL_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertTrue(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x01, result1.getTargetResistanceLevelChanged());
        assertEquals(FitnessMachineStatus.TARGET_RESISTANCE_LEVEL_CHANGED_RESOLUTION * 0x01, result1.getTargetResistanceLevelChangedWithUnit(), 0);
    }

    @Test
    public void test_constructor_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGET_POWER_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertTrue(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.getTargetPowerChanged());
    }

    @Test
    public void test_constructor_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGET_HEART_RATE_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertTrue(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x01, result1.getTargetHeartRateChanged());
    }

    @Test
    public void test_constructor_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_EXPENDED_ENERGY_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertTrue(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.getTargetedExpendedEnergyChanged());
    }

    @Test
    public void test_constructor_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_NUMBER_OF_STEPS_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertTrue(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedNumberOfStepsChanged());
    }

    @Test
    public void test_constructor_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_NUMBER_OF_STRIDES_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertTrue(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedNumberOfStridesChanged());
    }

    @Test
    public void test_constructor_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_DISTANCE_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertTrue(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x030201, result1.geTargetedDistanceChanged());
    }

    @Test
    public void test_constructor_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_TRAINING_TIME_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertTrue(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedTrainingTimeChanged());
    }

    @Test
    public void test_constructor_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertTrue(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedTimeInTwoHeartRateZonesChangedTargetedTimeInFatBurnZone());
        assertEquals(0x0403, result1.geTargetedTimeInTwoHeartRateZonesChangedTargetedTimeInFitnessZone());
    }

    @Test
    public void test_constructor_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertTrue(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInLightZone());
        assertEquals(0x0403, result1.geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInModerateZone());
        assertEquals(0x0605, result1.geTargetedTimeInThreeHeartRateZonesChangedTargetedTimeInHardZone());
    }

    @Test
    public void test_constructor_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertTrue(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInVeryLightZone());
        assertEquals(0x0403, result1.geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInLightZone());
        assertEquals(0x0605, result1.geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInModerateZone());
        assertEquals(0x0807, result1.geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInHardZone());
        assertEquals(0x0a09, result1.geTargetedTimeInFiveHeartRateZonesChangedTargetedTimeInMaximumZone());
    }

    @Test
    public void test_constructor_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertTrue(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geIndoorBikeSimulationParametersChangedWindSpeed());
        assertEquals(FitnessMachineStatus.INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_WIND_SPEED_RESOLUTION * 0x0201
                , result1.geIndoorBikeSimulationParametersChangedWindSpeedMetersPerSecond(), 0);
        assertEquals(0x0403, result1.geIndoorBikeSimulationParametersChangedGrade());
        assertEquals(FitnessMachineStatus.INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_GRADE_RESOLUTION * 0x0403
                , result1.geIndoorBikeSimulationParametersChangedGradePercentage(), 0);
        assertEquals(0x05, result1.geIndoorBikeSimulationParametersChangedCoefficientOfRollingResistance());
        assertEquals(FitnessMachineStatus.INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_COEFFICIENT_OF_ROLLING_RESISTANCE_RESOLUTION * 0x05
                , result1.geIndoorBikeSimulationParametersChangedCoefficientOfRollingResistanceWithUnit(), 0);
        assertEquals(0x06, result1.geIndoorBikeSimulationParametersChangedWindResistanceCoefficient());
        assertEquals(FitnessMachineStatus.INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED_WIND_RESISTANCE_COEFFICIENT_RESOLUTION * 0x06
                , result1.geIndoorBikeSimulationParametersChangedWindResistanceCoefficientKilogramPerMeter(), 0);
    }

    @Test
    public void test_constructor_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_WHEEL_CIRCUMFERENCE_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertTrue(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geWheelCircumferenceChanged());
        assertEquals(FitnessMachineStatus.WHEEL_CIRCUMFERENCE_CHANGED_RESOLUTION * 0x0201, result1.geWheelCircumferenceChangedMillimeter(), 0);
    }

    @Test
    public void test_constructor_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertTrue(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertTrue(result1.isSpinDownStatusSpinDownRequested());
        assertFalse(result1.isSpinDownStatusSuccess());
        assertFalse(result1.isSpinDownStatusError());
        assertFalse(result1.isSpinDownStatusStopPedaling());
    }

    @Test
    public void test_constructor_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertTrue(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertFalse(result1.isSpinDownStatusSpinDownRequested());
        assertTrue(result1.isSpinDownStatusSuccess());
        assertFalse(result1.isSpinDownStatusError());
        assertFalse(result1.isSpinDownStatusStopPedaling());
    }

    @Test
    public void test_constructor_01903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertTrue(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertFalse(result1.isSpinDownStatusSpinDownRequested());
        assertFalse(result1.isSpinDownStatusSuccess());
        assertTrue(result1.isSpinDownStatusError());
        assertFalse(result1.isSpinDownStatusStopPedaling());
    }

    @Test
    public void test_constructor_01904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertTrue(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertFalse(result1.isSpinDownStatusSpinDownRequested());
        assertFalse(result1.isSpinDownStatusSuccess());
        assertFalse(result1.isSpinDownStatusError());
        assertTrue(result1.isSpinDownStatusStopPedaling());
    }

    @Test
    public void test_constructor_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_TARGETED_CADENCE_CHANGED, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertTrue(result1.isOpCodeTargetedCadenceChanged());
        assertFalse(result1.isOpCodeControlPermissionLost());
        assertEquals(0x0201, result1.geTargetedCadenceChanged());
        assertEquals(FitnessMachineStatus.TARGETED_CADENCE_CHANGED_RESOLUTION * 0x0201, result1.geTargetedCadenceChangedRpm(), 0);
    }

    @Test
    public void test_constructor_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertEquals(FitnessMachineStatus.OP_CODE_CONTROL_PERMISSION_LOST, result1.getOpCode());
        assertFalse(result1.isOpCodeReset());
        assertFalse(result1.isOpCodeFitnessMachineStoppedOrPausedByTheUser());
        assertFalse(result1.isOpCodeFitnessMachineStoppedBySafetyKey());
        assertFalse(result1.isOpCodeFitnessMachineStartedOrResumedByTheUser());
        assertFalse(result1.isOpCodeTargetSpeedChanged());
        assertFalse(result1.isOpCodeTargetInclineChanged());
        assertFalse(result1.isOpCodeTargetResistanceLevelChanged());
        assertFalse(result1.isOpCodeTargetPowerChanged());
        assertFalse(result1.isOpCodeTargetHeartRateChanged());
        assertFalse(result1.isOpCodeTargetedExpendedEnergyChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStepsChanged());
        assertFalse(result1.isOpCodeTargetedNumberOfStridesChanged());
        assertFalse(result1.isOpCodeTargetedDistanceChanged());
        assertFalse(result1.isOpCodeTargetedTrainingTimeChanged());
        assertFalse(result1.isOpCodeTargetedTimeInTwoHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInThreeHeartRateZonesChanged());
        assertFalse(result1.isOpCodeTargetedTimeInFiveHeartRateZonesChanged());
        assertFalse(result1.isOpCodeIndoorBikeSimulationParametersChanged());
        assertFalse(result1.isOpCodeWheelCircumferenceChanged());
        assertFalse(result1.isOpCodeSpinDownStatus());
        assertFalse(result1.isOpCodeTargetedCadenceChanged());
        assertTrue(result1.isOpCodeControlPermissionLost());
    }

    @Test
    public void test_constructor_02102() {
        int opCode = 1;
        byte[] parameter = new byte[] { 2 };

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(opCode, parameter);
        assertEquals(opCode, result1.getOpCode());
        assertArrayEquals(parameter, result1.getParameter());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_01904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_1_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getOpCode(), result2.getOpCode());
        assertArrayEquals(result1.getParameter(), result2.getParameter());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_01904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00102() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01201() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01301() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01401() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01501() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01601() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01701() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01801() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01901() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01902() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01903() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_01904() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02001() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_02101() {
        byte[] data = getData();

        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(BASE_UUID, 0, 0);
        bluetoothGattCharacteristic.setValue(data);

        FitnessMachineStatusAndroid result1 = new FitnessMachineStatusAndroid(bluetoothGattCharacteristic);
        FitnessMachineStatusAndroid result2 = FitnessMachineStatusAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

}
