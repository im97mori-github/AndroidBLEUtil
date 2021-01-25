package org.im97mori.ble.service.ftms.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.ByteArrayInterface;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeatureAndroid;
import org.im97mori.ble.characteristic.u2acd.TreadmillData;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerData;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberData;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberData;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerData;
import org.im97mori.ble.characteristic.u2ad1.RowerDataAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeData;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataAndroid;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatus;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatusAndroid;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRangeAndroid;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRangeAndroid;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRangeAndroid;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRangeAndroid;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRangeAndroid;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPointAndroid;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatus;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatusAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.test.central.MockBLEConnection;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CROSS_TRAINER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FITNESS_MACHINE_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INDOOR_BIKE_DATA_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ROWER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.STAIR_CLIMBER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.STEP_CLIMBER_DATA_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_POWER_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRAINING_STATUS_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TREADMILL_DATA_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.FITNESS_MACHINE_SERVICE;
import static org.im97mori.ble.BLEConstants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class FitnessMachineServiceTest {

    @Test
    public void test_onBLEDisconnected_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00007() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00008() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00009() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00010() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00011() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_POWER_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00012() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00013() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onBLEDisconnected_00014() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_STATUS_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00006() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00106() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00401() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00402() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00403() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00404() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00405() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00406() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00501() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00502() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00503() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00504() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00505() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00506() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00601() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00602() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00603() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00604() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00605() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00606() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00607() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00608() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00701() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00702() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00703() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00704() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00705() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00801() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00802() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00803() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00804() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00805() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00901() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00902() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00903() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00904() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_00905() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01001() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01004() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01005() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01101() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01102() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01103() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01104() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01105() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01201() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01202() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01203() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01204() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01205() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01206() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01207() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01208() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01301() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.<BluetoothGattService>emptyList(), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01302() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01303() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01304() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01305() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onDiscoverServiceSuccess_01306() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[8];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineFeatureReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FitnessMachineFeatureAndroid fitnessMachineFeatureAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fitnessMachineFeatureAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[2];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TrainingStatusAndroid trainingStatusAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, trainingStatusAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedSpeedRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedSpeedRangeAndroid supportedSpeedRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedSpeedRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedInclinationRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedInclinationRangeAndroid supportedInclinationRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedInclinationRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedResistanceLevelRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedResistanceLevelRangeAndroid supportedResistanceLevelRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedResistanceLevelRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_POWER_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedPowerRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedPowerRangeAndroid supportedPowerRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedPowerRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[3];
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedHeartRateRangeReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull SupportedHeartRateRangeAndroid supportedHeartRateRangeAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, supportedHeartRateRangeAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineFeatureReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedSpeedRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedInclinationRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedResistanceLevelRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_POWER_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedPowerRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedHeartRateRangeReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineFeatureReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedSpeedRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedInclinationRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedResistanceLevelRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_POWER_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedPowerRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicReadTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onSupportedHeartRateRangeReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0]).getBytes();
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FitnessMachineControlPointAndroid fitnessMachineControlPointAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fitnessMachineControlPointAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadSuccess_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadFailed_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorReadTimeout_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteSuccess_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final byte[] originalValues = new byte[]{4, 5};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteFailed_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onDescriptorWriteTimeout_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }


    @Test
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TreadmillData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TreadmillDataAndroid treadmillDataAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, treadmillDataAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new CrossTrainerData(new byte[3], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull CrossTrainerDataAndroid crossTrainerDataAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, crossTrainerDataAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new StepClimberData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull StepClimberDataAndroid stepClimberDataAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, stepClimberDataAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new StairClimberData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull StairClimberDataAndroid stairClimberDataAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, stairClimberDataAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new RowerData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull RowerDataAndroid rowerDataAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, rowerDataAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new IndoorBikeData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull IndoorBikeDataAndroid indoorBikeDataAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, indoorBikeDataAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TrainingStatus(0, 0, "").getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull TrainingStatusAndroid trainingStatusAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, trainingStatusAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0]).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicated(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FitnessMachineControlPointAndroid fitnessMachineControlPointAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fitnessMachineControlPointAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_onCharacteristicNotified_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = MockBLEConnection.MOCK_DEVICE;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_RESET, new byte[0]).getBytes();

        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull FitnessMachineStatusAndroid fitnessMachineStatusAndroid) {
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertArrayEquals(originalValues, fitnessMachineStatusAndroid.getBytes());
                isCalled.set(true);
            }

        };

        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_isTreadmillDataCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupporeted());
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isCrossTrainerDataCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStepClimberDataCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isStairClimberDataCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupporeted());
    }

    @Test
    public void test_isRowerDataCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isRowerDataCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isRowerDataCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupporeted());
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_isIndoorBikeDataCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupporeted());
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isTrainingStatusCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedSpeedRangeCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedInclinationRangeCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedResistanceLevelRangeCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedPowerRangeCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isSupportedHeartRateRangeCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineControlPointCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupporeted_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupporeted_00002() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_isFitnessMachineStatusCharacteristicSupporeted_00003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, MockBLEConnection.MOCK_DEVICE, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, MockBLEConnection.MOCK_DEVICE, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupporeted());
    }

    @Test
    public void test_getFitnessMachineFeature_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getFitnessMachineFeature());
    }

    @Test
    public void test_getFitnessMachineFeature_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineFeature());
    }

    @Test
    public void test_getFitnessMachineFeature_000003() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(fitnessMachineService.getFitnessMachineFeature());
    }

    @Test
    public void test_getTreadmillDataClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getTreadmillDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTreadmillDataClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTreadmillDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTreadmillDataClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTreadmillDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTreadmillDataClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getTreadmillDataClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startTreadmillDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startTreadmillDataNotification());
    }

    @Test
    public void test_startTreadmillDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startTreadmillDataNotification());
    }

    @Test
    public void test_startTreadmillDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startTreadmillDataNotification());
    }

    @Test
    public void test_startTreadmillDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startTreadmillDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopTreadmillDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopTreadmillDataNotification());
    }

    @Test
    public void test_stopTreadmillDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopTreadmillDataNotification());
    }

    @Test
    public void test_stopTreadmillDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopTreadmillDataNotification());
    }

    @Test
    public void test_stopTreadmillDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopTreadmillDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startCrossTrainerDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startCrossTrainerDataNotification());
    }

    @Test
    public void test_startCrossTrainerDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startCrossTrainerDataNotification());
    }

    @Test
    public void test_startCrossTrainerDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startCrossTrainerDataNotification());
    }

    @Test
    public void test_startCrossTrainerDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startCrossTrainerDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopCrossTrainerDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopCrossTrainerDataNotification());
    }

    @Test
    public void test_stopCrossTrainerDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopCrossTrainerDataNotification());
    }

    @Test
    public void test_stopCrossTrainerDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopCrossTrainerDataNotification());
    }

    @Test
    public void test_stopCrossTrainerDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopCrossTrainerDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getStepClimberDataClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getStepClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStepClimberDataClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getStepClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStepClimberDataClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getStepClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStepClimberDataClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getStepClimberDataClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startStepClimberDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startStepClimberDataNotification());
    }

    @Test
    public void test_startStepClimberDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startStepClimberDataNotification());
    }

    @Test
    public void test_startStepClimberDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startStepClimberDataNotification());
    }

    @Test
    public void test_startStepClimberDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startStepClimberDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopStepClimberDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopStepClimberDataNotification());
    }

    @Test
    public void test_stopStepClimberDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopStepClimberDataNotification());
    }

    @Test
    public void test_stopStepClimberDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopStepClimberDataNotification());
    }

    @Test
    public void test_stopStepClimberDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopStepClimberDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getStairClimberDataClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getStairClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStairClimberDataClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getStairClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStairClimberDataClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getStairClimberDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getStairClimberDataClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getStairClimberDataClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startStairClimberDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startStairClimberDataNotification());
    }

    @Test
    public void test_startStairClimberDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startStairClimberDataNotification());
    }

    @Test
    public void test_startStairClimberDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startStairClimberDataNotification());
    }

    @Test
    public void test_startStairClimberDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startStairClimberDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopStairClimberDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopStairClimberDataNotification());
    }

    @Test
    public void test_stopStairClimberDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopStairClimberDataNotification());
    }

    @Test
    public void test_stopStairClimberDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopStairClimberDataNotification());
    }

    @Test
    public void test_stopStairClimberDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopStairClimberDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getRowerDataClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getRowerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRowerDataClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getRowerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRowerDataClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getRowerDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getRowerDataClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getRowerDataClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startRowerDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    public void test_startRowerDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    public void test_startRowerDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    public void test_startRowerDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startRowerDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopRowerDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopRowerDataNotification());
    }

    @Test
    public void test_stopRowerDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopRowerDataNotification());
    }

    @Test
    public void test_stopRowerDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopRowerDataNotification());
    }

    @Test
    public void test_stopRowerDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopRowerDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration());
    }

    @Test
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startIndoorBikeDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startIndoorBikeDataNotification());
    }

    @Test
    public void test_startIndoorBikeDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    public void test_startIndoorBikeDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startIndoorBikeDataNotification());
    }

    @Test
    public void test_startIndoorBikeDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startIndoorBikeDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopIndoorBikeDataNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopIndoorBikeDataNotification());
    }

    @Test
    public void test_stopIndoorBikeDataNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopIndoorBikeDataNotification());
    }

    @Test
    public void test_stopIndoorBikeDataNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopIndoorBikeDataNotification());
    }

    @Test
    public void test_stopIndoorBikeDataNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopIndoorBikeDataNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getTrainingStatus_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getTrainingStatus());
    }

    @Test
    public void test_getTrainingStatus_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTrainingStatus());
    }

    @Test
    public void test_getTrainingStatus_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTrainingStatus());
    }

    @Test
    public void test_getTrainingStatus_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getTrainingStatus();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getTrainingStatusClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getTrainingStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTrainingStatusClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTrainingStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTrainingStatusClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTrainingStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getTrainingStatusClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getTrainingStatusClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startTrainingStatusNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startTrainingStatusNotification());
    }

    @Test
    public void test_startTrainingStatusNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startTrainingStatusNotification());
    }

    @Test
    public void test_startTrainingStatusNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startTrainingStatusNotification());
    }

    @Test
    public void test_startTrainingStatusNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startTrainingStatusNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopTrainingStatusNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopTrainingStatusNotification());
    }

    @Test
    public void test_stopTrainingStatusNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopTrainingStatusNotification());
    }

    @Test
    public void test_stopTrainingStatusNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopTrainingStatusNotification());
    }

    @Test
    public void test_stopTrainingStatusNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopTrainingStatusNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSupportedSpeedRange_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedSpeedRange());
    }

    @Test
    public void test_getSupportedSpeedRange_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedSpeedRange());
    }

    @Test
    public void test_getSupportedSpeedRange_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedSpeedRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedSpeedRange());
    }

    @Test
    public void test_getSupportedSpeedRange_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedSpeedRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getSupportedSpeedRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSupportedInclinationRange_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedInclinationRange());
    }

    @Test
    public void test_getSupportedInclinationRange_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedInclinationRange());
    }

    @Test
    public void test_getSupportedInclinationRange_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedInclinationRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedInclinationRange());
    }

    @Test
    public void test_getSupportedInclinationRange_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedInclinationRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getSupportedInclinationRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSupportedResistanceLevelRange_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedResistanceLevelRange());
    }

    @Test
    public void test_getSupportedResistanceLevelRange_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedResistanceLevelRange());
    }

    @Test
    public void test_getSupportedResistanceLevelRange_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedResistanceLevelRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedResistanceLevelRange());
    }

    @Test
    public void test_getSupportedResistanceLevelRange_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedResistanceLevelRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getSupportedResistanceLevelRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSupportedPowerRange_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedPowerRange());
    }

    @Test
    public void test_getSupportedPowerRange_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedPowerRange());
    }

    @Test
    public void test_getSupportedPowerRange_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedPowerRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedPowerRange());
    }

    @Test
    public void test_getSupportedPowerRange_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedPowerRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getSupportedPowerRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getSupportedHeartRateRange_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedHeartRateRange());
    }

    @Test
    public void test_getSupportedHeartRateRange_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedHeartRateRange());
    }

    @Test
    public void test_getSupportedHeartRateRange_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedHeartRateRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedHeartRateRange());
    }

    @Test
    public void test_getSupportedHeartRateRange_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedHeartRateRangeCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getSupportedHeartRateRange();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_setFitnessMachineControlPoint_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
    }

    @Test
    public void test_setFitnessMachineControlPoint_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
    }

    @Test
    public void test_setFitnessMachineControlPoint_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
    }

    @Test
    public void test_setFitnessMachineControlPoint_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteCharacteristicTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull ByteArrayInterface byteArrayInterface, int writeType, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0]));
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startFitnessMachineControlPointIndication_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startFitnessMachineControlPointIndication());
    }

    @Test
    public void test_startFitnessMachineControlPointIndication_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startFitnessMachineControlPointIndication());
    }

    @Test
    public void test_startFitnessMachineControlPointIndication_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startFitnessMachineControlPointIndication());
    }

    @Test
    public void test_startFitnessMachineControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startFitnessMachineControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopFitnessMachineControlPointIndication_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopFitnessMachineControlPointIndication());
    }

    @Test
    public void test_stopFitnessMachineControlPointIndication_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopFitnessMachineControlPointIndication());
    }

    @Test
    public void test_stopFitnessMachineControlPointIndication_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopFitnessMachineControlPointIndication());
    }

    @Test
    public void test_stopFitnessMachineControlPointIndication_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopFitnessMachineControlPointIndication();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration());
    }

    @Test
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createReadDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_startFitnessMachineStatusNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startFitnessMachineStatusNotification());
    }

    @Test
    public void test_startFitnessMachineStatusNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startFitnessMachineStatusNotification());
    }

    @Test
    public void test_startFitnessMachineStatusNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startFitnessMachineStatusNotification());
    }

    @Test
    public void test_startFitnessMachineStatusNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.startFitnessMachineStatusNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

    @Test
    public void test_stopFitnessMachineStatusNotification_000001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopFitnessMachineStatusNotification());
    }

    @Test
    public void test_stopFitnessMachineStatusNotification_000002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(new MockBLEConnection(), new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopFitnessMachineStatusNotification());
    }

    @Test
    public void test_stopFitnessMachineStatusNotification_000003() {
        MockBLEConnection mockBLEConnection = new MockBLEConnection();
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopFitnessMachineStatusNotification());
    }

    @Test
    public void test_stopFitnessMachineStatusNotification_000004() {
        final Integer originalTaskId = 1;
        MockBLEConnection mockBLEConnection = new MockBLEConnection() {

            @Override
            public synchronized Integer createWriteDescriptorTask(@NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull ByteArrayInterface byteArrayInterface, long timeout, @Nullable Bundle argument, @Nullable BLECallback bleCallback) {
                return originalTaskId;
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(mockBLEConnection, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupporeted() {
                return true;
            }

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        Integer taskId = fitnessMachineService.stopFitnessMachineStatusNotification();
        assertNotNull(taskId);
        assertEquals(originalTaskId, taskId);
    }

}
