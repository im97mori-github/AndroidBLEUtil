package org.im97mori.ble.service.ftms.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;

import org.im97mori.ble.characteristic.core.CrossTrainerDataUtils;
import org.im97mori.ble.characteristic.core.IndoorBikeDataUtils;
import org.im97mori.ble.characteristic.core.RowerDataUtils;
import org.im97mori.ble.characteristic.core.StairClimberDataUtils;
import org.im97mori.ble.characteristic.core.StepClimberDataUtils;
import org.im97mori.ble.characteristic.core.TreadmillDataUtils;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeature;
import org.im97mori.ble.characteristic.u2acd.TreadmillData;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerData;
import org.im97mori.ble.characteristic.u2acf.StepClimberData;
import org.im97mori.ble.characteristic.u2ad0.StairClimberData;
import org.im97mori.ble.characteristic.u2ad1.RowerData;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeData;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatus;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRange;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRange;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRange;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRange;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRange;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatus;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.test.peripheral.AbstractPeripherallTest;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.CROSS_TRAINER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.FITNESS_MACHINE_STATUS_CHARACTERISTIC;
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
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.FITNESS_MACHINE_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class FitnessMachineServiceMockCallbackBuilderTest extends AbstractPeripherallTest {

    @Test
    public void test_exception_00001() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Fitness Machine Feature data", exception.getMessage());
    }

    @Test
    public void test_exception_00101() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Average Speed not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00102() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Total Distance not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00103() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Inclination not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00104() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            ,
                            new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elevation Gain not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00105() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            ,
                            new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Pace not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00106() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Pace not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00107() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Expended Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00108() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Heart Rate Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00109() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Metabolic Equivalent not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00110() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elapsed Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00111() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Remaining Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00112() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[]{(byte) TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE
                                    , (byte) (TreadmillDataUtils.FLAGS_FORCE_ON_BELT_AND_POWER_OUTPUT_PRESSENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Force on Belt and Power Output not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00113() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addTreadmillData(new TreadmillData(new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00201() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Average Speed not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00202() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Total Distance not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00203() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_STEP_COUNT_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Step Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00204() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Stride Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00205() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_ELEVATION_GAIN_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elevation Gain not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00206() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_INCLINATION_AND_RAMP_ANGLE_SETTING_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Inclination not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00207() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_REGISTANCE_LEVEL_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Resistance Level not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00208() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Power Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00209() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Power Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00210() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Expended Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00211() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Heart Rate Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00212() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Metabolic Equivalent not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00213() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elapsed Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00214() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[]{(byte) CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                                    , (byte) (CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 8)
                                    , (byte) (CrossTrainerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 16)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Remaining Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00215() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addCrossTrainerData(new CrossTrainerData(new byte[3]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00301() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Step Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00302() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Step Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00303() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elevation Gain not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00304() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Expended Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00305() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Heart Rate Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00306() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Metabolic Equivalent not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00307() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elapsed Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00308() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[]{(byte) StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                                    , (byte) (StepClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Remaining Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00309() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStepClimberData(new StepClimberData(new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00401() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_STEP_PER_MINUTE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Step Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00402() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_AVERAGE_STEP_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Step Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00403() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_POSITIVE_ELEVATION_GAIN_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elevation Gain not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00404() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_STRIDE_COUNT_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Stride Count not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00405() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_EXPENDED_ENERGY_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Expended Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00406() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Heart Rate Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00407() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Metabolic Equivalent not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00408() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elapsed Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00409() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[]{(byte) StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                                    , (byte) (StairClimberDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Remaining Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00410() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addStairClimberData(new StairClimberData(new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00501() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_AVERAGE_STROKE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Cadence not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00502() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Total Distance not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00503() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_INSTANTANEOUS_PACE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Pace not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00504() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_AVERAGE_PACE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Pace not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00505() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Power Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00506() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Power Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00507() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Resistance Level not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00508() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Expended Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00509() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Heart Rate Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00510() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Metabolic Equivalent not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00511() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elapsed Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00512() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[]{(byte) RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                                    , (byte) (RowerDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Remaining Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00513() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addRowerData(new RowerData(new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00601() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_AVERAGE_SPEED_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Average Speed not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00602() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_CADENCE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Cadence not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00603() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_AVERAGE_CADENCE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Cadence not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00604() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_TOTAL_DISTANCE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Total Distance not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00605() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_RESISTANCE_LEVEL_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Resistance Level not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00606() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_INSTANTANEOUS_POWER_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Power Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00607() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_AVERAGE_POWER_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Power Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00608() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_EXPANDED_ENERGY_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Expended Energy not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00609() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_HEART_RATE_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Heart Rate Measurement not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00610() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_METABOLIC_EQUIVALENT_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Metabolic Equivalent not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00611() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_ELAPSED_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Elapsed Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00612() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[]{(byte) IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE
                                    , (byte) (IndoorBikeDataUtils.FLAGS_REMAINING_TIME_PRESENT_TRUE >> 8)}
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Remaining Time not Supported", exception.getMessage());
    }

    @Test
    public void test_exception_00613() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addIndoorBikeData(new IndoorBikeData(new byte[2]
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0
                                    , 0)
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00701() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[]{0
                            , 0
                            , 0
                            , 0
                            , (byte) FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE >> 8)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE >> 16)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_SPEED_TARGET_SETTING_SUPPORTED_TRUE >> 24)
                    }))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Speed Range data", exception.getMessage());
    }

    @Test
    public void test_exception_00702() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[]{0
                            , 0
                            , 0
                            , 0
                            , (byte) FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE >> 8)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE >> 16)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_INCLINATION_TARGET_SETTING_SUPPORTED_TRUE >> 24)}))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Inclination Range data", exception.getMessage());
    }

    @Test
    public void test_exception_00703() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[]{0
                            , 0
                            , 0
                            , 0
                            , (byte) FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE >> 8)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE >> 16)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_RESISTANCE_TARGET_SETTING_SUPPORTED_TRUE >> 24)}))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Resistance Level Range data", exception.getMessage());
    }

    @Test
    public void test_exception_00704() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[]{0
                            , 0
                            , 0
                            , 0
                            , (byte) FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE >> 8)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE >> 16)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_POWER_TARGET_SETTING_SUPPORTED_TRUE >> 24)}))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Power Range data", exception.getMessage());
    }

    @Test
    public void test_exception_00705() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[]{0
                            , 0
                            , 0
                            , 0
                            , (byte) FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE >> 8)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE >> 16)
                            , (byte) (FitnessMachineFeature.TARGET_SETTING_FEATURES_HEART_RATE_TARGET_SETTING_SUPPORTED_TRUE >> 24)}))
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Supported Heart Rate Range data", exception.getMessage());
    }

    @Test
    public void test_exception_00801() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Fitness Machine Control Point data", exception.getMessage());
    }

    @Test
    public void test_exception_00802() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("Spin Down Status not matched", exception.getMessage());
    }

    @Test
    public void test_exception_00803() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00804() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_SUCCESS
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00805() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_ERROR
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_exception_00806() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[8]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_STOP_PEDALING
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_addFitnessMachineFeature_00001() {
        FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(fitnessMachineFeature)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FITNESS_MACHINE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fitnessMachineFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFitnessMachineFeature_00002() {
        FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(fitnessMachineFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FITNESS_MACHINE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fitnessMachineFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addFitnessMachineFeature_00003() {
        FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(new byte[4]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(BluetoothGatt.GATT_SUCCESS, 0, fitnessMachineFeature.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_FEATURE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FITNESS_MACHINE_FEATURE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(fitnessMachineFeature.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeFitnessMachineFeature_00001() {
        Exception exception = null;
        try {
            new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .removeFitnessMachineFeature()
                    .build();
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Fitness Machine Feature data", exception.getMessage());
    }

    @Test
    public void test_addTreadmillData_00001() {
        TreadmillData treadmillData = new TreadmillData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addTreadmillData(treadmillData, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TREADMILL_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TREADMILL_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(treadmillData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addTreadmillData_00002() {
        TreadmillData treadmillData = new TreadmillData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addTreadmillData(BluetoothGatt.GATT_SUCCESS, 0, treadmillData.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TREADMILL_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TREADMILL_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(treadmillData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeTreadmillData_00001() {
        TreadmillData treadmillData = new TreadmillData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addTreadmillData(treadmillData, clientCharacteristicConfiguration)
                    .removeTreadmillData()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TREADMILL_DATA_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addCrossTrainerData_00001() {
        CrossTrainerData crossTrainerData = new CrossTrainerData(new byte[3]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addCrossTrainerData(crossTrainerData, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CROSS_TRAINER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(crossTrainerData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addCrossTrainerData_00002() {
        CrossTrainerData crossTrainerData = new CrossTrainerData(new byte[3]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addCrossTrainerData(BluetoothGatt.GATT_SUCCESS, 0, crossTrainerData.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(CROSS_TRAINER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(crossTrainerData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeCrossTrainerData_00001() {
        CrossTrainerData crossTrainerData = new CrossTrainerData(new byte[3]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addCrossTrainerData(crossTrainerData, clientCharacteristicConfiguration)
                    .removeCrossTrainerData()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addStepClimberData_00001() {
        StepClimberData stepClimberData = new StepClimberData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addStepClimberData(stepClimberData, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(STEP_CLIMBER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(stepClimberData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addStepClimberData_00002() {
        StepClimberData stepClimberData = new StepClimberData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addStepClimberData(BluetoothGatt.GATT_SUCCESS, 0, stepClimberData.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(STEP_CLIMBER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(stepClimberData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeStepClimberData_00001() {
        StepClimberData stepClimberData = new StepClimberData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addStepClimberData(stepClimberData, clientCharacteristicConfiguration)
                    .removeStepClimberData()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addStairClimberData_00001() {
        StairClimberData stairClimberData = new StairClimberData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addStairClimberData(stairClimberData, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(STAIR_CLIMBER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(stairClimberData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addStairClimberData_00002() {
        StairClimberData stairClimberData = new StairClimberData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addStairClimberData(BluetoothGatt.GATT_SUCCESS, 0, stairClimberData.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(STAIR_CLIMBER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(stairClimberData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeStairClimberData_00001() {
        StairClimberData stairClimberData = new StairClimberData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addStairClimberData(stairClimberData, clientCharacteristicConfiguration)
                    .removeStairClimberData()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addRowerData_00001() {
        RowerData rowerData = new RowerData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addRowerData(rowerData, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ROWER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ROWER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rowerData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addRowerData_00002() {
        RowerData rowerData = new RowerData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addRowerData(BluetoothGatt.GATT_SUCCESS, 0, rowerData.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ROWER_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(ROWER_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(rowerData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeRowerData_00001() {
        RowerData rowerData = new RowerData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addRowerData(rowerData, clientCharacteristicConfiguration)
                    .removeRowerData()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ROWER_DATA_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addIndoorBikeData_00001() {
        IndoorBikeData indoorBikeData = new IndoorBikeData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addIndoorBikeData(indoorBikeData, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(INDOOR_BIKE_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(indoorBikeData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addIndoorBikeData_00002() {
        IndoorBikeData indoorBikeData = new IndoorBikeData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addIndoorBikeData(BluetoothGatt.GATT_SUCCESS, 0, indoorBikeData.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(INDOOR_BIKE_DATA_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(indoorBikeData.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeIndoorBikeData_00001() {
        IndoorBikeData indoorBikeData = new IndoorBikeData(new byte[2]
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0
                , 0);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addIndoorBikeData(indoorBikeData, clientCharacteristicConfiguration)
                    .removeIndoorBikeData()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addTrainingStatus_00001() {
        TrainingStatus trainingStatus = new TrainingStatus(new byte[2]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addTrainingStatus(trainingStatus, clientCharacteristicConfiguration)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TRAINING_STATUS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TRAINING_STATUS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(trainingStatus.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_addTrainingStatus_00002() {
        TrainingStatus trainingStatus = new TrainingStatus(new byte[2]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addTrainingStatus(BluetoothGatt.GATT_SUCCESS, 0, trainingStatus.getBytes(), 0, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TRAINING_STATUS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(TRAINING_STATUS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(trainingStatus.getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(clientCharacteristicConfiguration.getBytes(), bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeTrainingStatus_00001() {
        TrainingStatus trainingStatus = new TrainingStatus(new byte[2]);

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addTrainingStatus(trainingStatus, clientCharacteristicConfiguration)
                    .removeTrainingStatus()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TRAINING_STATUS_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addSupportedSpeedRange_00001() {
        SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedSpeedRange(supportedSpeedRange)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedSpeedRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedSpeedRange_00002() {
        SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedSpeedRange(supportedSpeedRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedSpeedRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedSpeedRange_00003() {
        SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedSpeedRange(BluetoothGatt.GATT_SUCCESS, 0, supportedSpeedRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedSpeedRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedSpeedRange_00001() {
        SupportedSpeedRange supportedSpeedRange = new SupportedSpeedRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedSpeedRange(supportedSpeedRange)
                    .removeSupportedSpeedRange()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addSupportedInclinationRange_00001() {
        SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedInclinationRange(supportedInclinationRange)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedInclinationRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedInclinationRange_00002() {
        SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedInclinationRange(supportedInclinationRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedInclinationRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedInclinationRange_00003() {
        SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedInclinationRange(BluetoothGatt.GATT_SUCCESS, 0, supportedInclinationRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedInclinationRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedInclinationRange_00001() {
        SupportedInclinationRange supportedInclinationRange = new SupportedInclinationRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedInclinationRange(supportedInclinationRange)
                    .removeSupportedInclinationRange()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addSupportedResistanceLevelRange_00001() {
        SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedResistanceLevelRange(supportedResistanceLevelRange)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedResistanceLevelRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedResistanceLevelRange_00002() {
        SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedResistanceLevelRange(supportedResistanceLevelRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedResistanceLevelRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedResistanceLevelRange_00003() {
        SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedResistanceLevelRange(BluetoothGatt.GATT_SUCCESS, 0, supportedResistanceLevelRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedResistanceLevelRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedResistanceLevelRange_00001() {
        SupportedResistanceLevelRange supportedResistanceLevelRange = new SupportedResistanceLevelRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedResistanceLevelRange(supportedResistanceLevelRange)
                    .removeSupportedResistanceLevelRange()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addSupportedPowerRange_00001() {
        SupportedPowerRange supportedPowerRange = new SupportedPowerRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedPowerRange(supportedPowerRange)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_POWER_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedPowerRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedPowerRange_00002() {
        SupportedPowerRange supportedPowerRange = new SupportedPowerRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedPowerRange(supportedPowerRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_POWER_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedPowerRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedPowerRange_00003() {
        SupportedPowerRange supportedPowerRange = new SupportedPowerRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedPowerRange(BluetoothGatt.GATT_SUCCESS, 0, supportedPowerRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_POWER_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedPowerRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedPowerRange_00001() {
        SupportedPowerRange supportedPowerRange = new SupportedPowerRange(new byte[6]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedPowerRange(supportedPowerRange)
                    .removeSupportedPowerRange()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addSupportedHeartRateRange_00001() {
        SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedHeartRateRange(supportedHeartRateRange)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedHeartRateRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedHeartRateRange_00002() {
        SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedHeartRateRange(supportedHeartRateRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedHeartRateRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_addSupportedHeartRateRange_00003() {
        SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedHeartRateRange(BluetoothGatt.GATT_SUCCESS, 0, supportedHeartRateRange.getBytes())
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_READ, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_READ, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(supportedHeartRateRange.getBytes(), bluetoothGattCharacteristic.getValue());
    }

    @Test
    public void test_removeSupportedHeartRateRange_00001() {
        SupportedHeartRateRange supportedHeartRateRange = new SupportedHeartRateRange(new byte[3]);

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addSupportedHeartRateRange(supportedHeartRateRange)
                    .removeSupportedHeartRateRange()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addFitnessMachineControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , descriptorValue
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_STOP_PEDALING
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, bluetoothGattCharacteristic.getProperties());
        assertEquals(BluetoothGattCharacteristic.PERMISSION_WRITE, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes(), bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeFitnessMachineControlPoint_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addFitnessMachineControlPoint(0
                            , 0
                            , 0
                            , descriptorValue
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS
                            , new byte[4]
                            , FitnessMachineControlPoint.RESULT_CODE_SUCCESS)
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_STOP_PEDALING
                            , 0
                            , 0
                            , BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE)
                    .removeFitnessMachineControlPoint()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

    @Test
    public void test_addFitnessMachineStatus_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED, BluetoothGatt.GATT_SUCCESS, 0, descriptorValue)
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC);
        assertNotNull(bluetoothGattCharacteristic);
        assertEquals(FITNESS_MACHINE_STATUS_CHARACTERISTIC, bluetoothGattCharacteristic.getUuid());
        assertEquals(BluetoothGattCharacteristic.PROPERTY_NOTIFY, bluetoothGattCharacteristic.getProperties());
        assertEquals(0, bluetoothGattCharacteristic.getPermissions());
        assertArrayEquals(null, bluetoothGattCharacteristic.getValue());
        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
        assertNotNull(bluetoothGattDescriptor);
        assertEquals(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, bluetoothGattDescriptor.getUuid());
        assertEquals(BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, bluetoothGattDescriptor.getPermissions());
        assertArrayEquals(descriptorValue, bluetoothGattDescriptor.getValue());
    }

    @Test
    public void test_removeFitnessMachineStatus_00001() {
        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;

        final List<BluetoothGattService> bluetoothGattServiceList = new LinkedList<>();
        MOCK_BLE_SERVER_CONNECTION.setCreateAddServiceTaskBluetoothGattServiceList(bluetoothGattServiceList);

        Exception exception = null;
        try {
            FitnessMachineServiceMockCallback callback = new FitnessMachineServiceMockCallback.Builder<>()
                    .addFitnessMachineFeature(new FitnessMachineFeature(new byte[4]))
                    .addFitnessMachineStatus(FitnessMachineStatus.SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED, BluetoothGatt.GATT_SUCCESS, 0, descriptorValue)
                    .removeFitnessMachineStatus()
                    .build();
            callback.setup(MOCK_BLE_SERVER_CONNECTION);
        } catch (RuntimeException e) {
            exception = e;
        }

        assertNull(exception);
        assertFalse(bluetoothGattServiceList.isEmpty());
        assertEquals(1, bluetoothGattServiceList.size());
        BluetoothGattService bluetoothGattService = bluetoothGattServiceList.get(0);
        assertEquals(FITNESS_MACHINE_SERVICE, bluetoothGattService.getUuid());
        assertEquals(BluetoothGattService.SERVICE_TYPE_PRIMARY, bluetoothGattService.getType());

        BluetoothGattCharacteristic bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC);
        assertNull(bluetoothGattCharacteristic);
    }

}
