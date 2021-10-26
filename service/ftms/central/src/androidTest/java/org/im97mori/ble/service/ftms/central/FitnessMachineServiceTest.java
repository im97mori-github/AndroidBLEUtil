package org.im97mori.ble.service.ftms.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.filters.RequiresDevice;

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
import org.im97mori.ble.test.BLETestUtilsAndroid;
import org.im97mori.ble.test.central.AbstractCentralTest;
import org.junit.Test;

import java.util.Collections;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

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
import static org.im97mori.ble.constants.ServiceUUID.GENERIC_ACCESS_SERVICE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("UnnecessaryLocalVariable")
public class FitnessMachineServiceTest extends AbstractCentralTest {

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00004() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00005() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00006() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00007() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00008() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00009() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00010() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00011() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_POWER_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00012() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00013() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onBLEDisconnected_00014() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_STATUS_CHARACTERISTIC, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00004() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00005() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00006() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00101() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00102() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00103() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00104() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00105() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00106() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00201() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00202() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00203() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00204() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00205() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00206() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00301() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00302() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00303() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00304() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00305() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00306() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00401() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00402() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00403() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00404() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00405() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00406() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00501() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00502() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00503() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00504() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00505() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00506() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00601() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00602() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00603() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00604() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00605() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00606() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00607() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00608() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00701() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00702() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00703() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00704() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00705() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00801() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00802() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00803() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00804() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00805() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00901() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00902() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00903() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00904() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_00905() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01004() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01005() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01101() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01102() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01103() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01104() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01105() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01201() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01202() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01203() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01204() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01205() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01206() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01207() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01208() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01301() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.emptyList(), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01302() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(GENERIC_ACCESS_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01303() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01304() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, 0, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01305() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        bluetoothGattService.addCharacteristic(new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0));
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onDiscoverServiceSuccess_01306() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[8];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[2];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_POWER_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[6];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new byte[3];
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_POWER_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_FEATURE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_SPEED_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_POWER_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicReadTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0]).getBytes();
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final int originalStatus = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final long originalTimeout = 4;
        final Bundle originalBundle = new Bundle();
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
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadSuccess_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusClientCharacteristicConfigurationReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @NonNull ClientCharacteristicConfigurationAndroid clientCharacteristicConfigurationAndroid, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertArrayEquals(originalValues, clientCharacteristicConfigurationAndroid.getBytes());
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadFailed_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusClientCharacteristicConfigurationReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorReadTimeout_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusClientCharacteristicConfigurationReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorReadTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStartSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteSuccess_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final byte[] originalValues = new byte[]{5, 6};
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStopSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull Integer descriptorInstanceId, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteSuccess(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalValues, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStartFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteFailed_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final int originalStatus = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStopFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalStatus, status);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteFailed(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalStatus, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 0);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStartTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00101() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTreadmillDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00102() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onCrossTrainerDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00103() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStepClimberDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00104() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onStairClimberDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00105() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onRowerDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00106() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onIndoorBikeDataNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00107() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onTrainingStatusNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00108() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineControlPointIndicateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onDescriptorWriteTimeout_00109() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final Integer originalTaskId = 1;
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final UUID originalDescriptorUUID = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
        final Integer originalDescriptorInstanceId = 4;
        final long originalTimeout = 5;
        final Bundle originalBundle = new Bundle();
        originalBundle.putInt("KEY_STATUS", 1);
        MockFitnessMachineServiceCallback mockFitnessMachineServiceCallback = new MockFitnessMachineServiceCallback() {

            @Override
            public void onFitnessMachineStatusNotificateStopTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
                assertEquals(originalTaskId, taskId);
                assertEquals(originalBluetoothDevice, bluetoothDevice);
                assertEquals(originalServiceUUID, serviceUUID);
                assertEquals(originalServiceInstanceId, serviceInstanceId);
                assertEquals(originalCharacteristicUUID, characteristicUUID);
                assertEquals(originalCharacteristicInstanceId, characteristicInstanceId);
                assertEquals(originalDescriptorInstanceId, descriptorInstanceId);
                assertEquals(originalTimeout, timeout);
                assertEquals(originalBundle, argument);
                isCalled.set(true);
            }

        };
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onDescriptorWriteTimeout(originalTaskId, originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalDescriptorUUID, originalDescriptorInstanceId, originalTimeout, originalBundle);

        assertTrue(isCalled.get());
    }


    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00001() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TREADMILL_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TreadmillData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00002() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = CROSS_TRAINER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new CrossTrainerData(new byte[3], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00003() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STEP_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new StepClimberData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00004() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = STAIR_CLIMBER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new StairClimberData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00005() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = ROWER_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new RowerData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00006() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = INDOOR_BIKE_DATA_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new IndoorBikeData(new byte[2], 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00007() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = TRAINING_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new TrainingStatus(0, 0, "").getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00008() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0]).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_onCharacteristicNotified_00009() {
        final AtomicBoolean isCalled = new AtomicBoolean(false);
        final BluetoothDevice originalBluetoothDevice = BLETestUtilsAndroid.MOCK_DEVICE_0;
        final UUID originalServiceUUID = FITNESS_MACHINE_SERVICE;
        final Integer originalServiceInstanceId = 2;
        final UUID originalCharacteristicUUID = FITNESS_MACHINE_STATUS_CHARACTERISTIC;
        final Integer originalCharacteristicInstanceId = 3;
        final byte[] originalValues = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_RESET, new byte[0]).getBytes();
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

        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, mockFitnessMachineServiceCallback, null);
        fitnessMachineService.onCharacteristicNotified(originalBluetoothDevice, originalServiceUUID, originalServiceInstanceId, originalCharacteristicUUID, originalCharacteristicInstanceId, originalValues);

        assertTrue(isCalled.get());
    }

    @Test
    @RequiresDevice
    public void test_isTreadmillDataCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isTreadmillDataCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isTreadmillDataCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TREADMILL_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isTreadmillDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCrossTrainerDataCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCrossTrainerDataCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isCrossTrainerDataCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isCrossTrainerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isStepClimberDataCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isStepClimberDataCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isStepClimberDataCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isStepClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isStairClimberDataCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isStairClimberDataCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isStairClimberDataCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isStairClimberDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isRowerDataCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isRowerDataCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isRowerDataCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ROWER_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isRowerDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isIndoorBikeDataCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isIndoorBikeDataCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isIndoorBikeDataCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isIndoorBikeDataCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isTrainingStatusCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isTrainingStatusCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isTrainingStatusCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRAINING_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isTrainingStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedSpeedRangeCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedSpeedRangeCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedSpeedRangeCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedSpeedRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedInclinationRangeCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedInclinationRangeCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedInclinationRangeCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedInclinationRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedResistanceLevelRangeCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedResistanceLevelRangeCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedResistanceLevelRangeCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedResistanceLevelRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedPowerRangeCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedPowerRangeCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedPowerRangeCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedPowerRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedHeartRateRangeCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedHeartRateRangeCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isSupportedHeartRateRangeCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_READ, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isSupportedHeartRateRangeCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFitnessMachineControlPointCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFitnessMachineControlPointCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFitnessMachineControlPointCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineControlPointCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFitnessMachineStatusCharacteristicSupported_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFitnessMachineStatusCharacteristicSupported_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);

        assertTrue(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_isFitnessMachineStatusCharacteristicSupported_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);
        BluetoothGattService bluetoothGattService = new BluetoothGattService(FITNESS_MACHINE_SERVICE, 0);
        BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC, BluetoothGattCharacteristic.PROPERTY_NOTIFY, 0);
        bluetoothGattCharacteristic.addDescriptor(new BluetoothGattDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE));
        bluetoothGattService.addCharacteristic(bluetoothGattCharacteristic);
        fitnessMachineService.onDiscoverServiceSuccess(1, BLETestUtilsAndroid.MOCK_DEVICE_0, Collections.singletonList(bluetoothGattService), null);
        fitnessMachineService.onBLEDisconnected(1, BLETestUtilsAndroid.MOCK_DEVICE_0, 0, null);

        assertFalse(fitnessMachineService.isFitnessMachineStatusCharacteristicSupported());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineFeature_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getFitnessMachineFeature());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineFeature_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineFeature());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineFeature_00003() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNotNull(fitnessMachineService.getFitnessMachineFeature());
    }

    @Test
    @RequiresDevice
    public void test_getTreadmillDataClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getTreadmillDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getTreadmillDataClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTreadmillDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getTreadmillDataClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getTreadmillDataClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startTreadmillDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startTreadmillDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startTreadmillDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startTreadmillDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startTreadmillDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startTreadmillDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopTreadmillDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopTreadmillDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopTreadmillDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopTreadmillDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopTreadmillDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopTreadmillDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTreadmillDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getCrossTrainerDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getCrossTrainerDataClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startCrossTrainerDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startCrossTrainerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCrossTrainerDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startCrossTrainerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startCrossTrainerDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startCrossTrainerDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopCrossTrainerDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopCrossTrainerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCrossTrainerDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopCrossTrainerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopCrossTrainerDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopCrossTrainerDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isCrossTrainerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getStepClimberDataClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getStepClimberDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getStepClimberDataClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getStepClimberDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getStepClimberDataClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getStepClimberDataClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startStepClimberDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startStepClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startStepClimberDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startStepClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startStepClimberDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startStepClimberDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopStepClimberDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopStepClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopStepClimberDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopStepClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopStepClimberDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopStepClimberDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStepClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getStairClimberDataClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getStairClimberDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getStairClimberDataClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getStairClimberDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getStairClimberDataClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getStairClimberDataClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startStairClimberDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startStairClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startStairClimberDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startStairClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startStairClimberDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startStairClimberDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopStairClimberDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopStairClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopStairClimberDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopStairClimberDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopStairClimberDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopStairClimberDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStairClimberDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getRowerDataClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getRowerDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRowerDataClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getRowerDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getRowerDataClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getRowerDataClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startRowerDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRowerDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startRowerDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startRowerDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopRowerDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopRowerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRowerDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopRowerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopRowerDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopRowerDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isRowerDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getIndoorBikeDataClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getIndoorBikeDataClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startIndoorBikeDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startIndoorBikeDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startIndoorBikeDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startRowerDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_startIndoorBikeDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startIndoorBikeDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopIndoorBikeDataNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopIndoorBikeDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopIndoorBikeDataNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopIndoorBikeDataNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopIndoorBikeDataNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopIndoorBikeDataNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isIndoorBikeDataCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getTrainingStatus_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getTrainingStatus());
    }

    @Test
    @RequiresDevice
    public void test_getTrainingStatus_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTrainingStatus());
    }

    @Test
    @RequiresDevice
    public void test_getTrainingStatus_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getTrainingStatus_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getTrainingStatusClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getTrainingStatusClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getTrainingStatusClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getTrainingStatusClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getTrainingStatusClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getTrainingStatusClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startTrainingStatusNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startTrainingStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_startTrainingStatusNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startTrainingStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_startTrainingStatusNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startTrainingStatusNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopTrainingStatusNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopTrainingStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopTrainingStatusNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopTrainingStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopTrainingStatusNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopTrainingStatusNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isTrainingStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedSpeedRange_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedSpeedRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedSpeedRange_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedSpeedRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedSpeedRange_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedSpeedRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedSpeedRange_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedSpeedRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedInclinationRange_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedInclinationRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedInclinationRange_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedInclinationRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedInclinationRange_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedInclinationRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedInclinationRange_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedInclinationRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedResistanceLevelRange_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedResistanceLevelRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedResistanceLevelRange_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedResistanceLevelRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedResistanceLevelRange_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedResistanceLevelRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedResistanceLevelRange_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedResistanceLevelRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedPowerRange_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedPowerRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedPowerRange_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedPowerRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedPowerRange_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedPowerRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedPowerRange_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedPowerRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedHeartRateRange_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getSupportedHeartRateRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedHeartRateRange_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getSupportedHeartRateRange());
    }

    @Test
    @RequiresDevice
    public void test_getSupportedHeartRateRange_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedHeartRateRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getSupportedHeartRateRange_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isSupportedHeartRateRangeCharacteristicSupported() {
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
    @RequiresDevice
    public void test_setFitnessMachineControlPoint_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
    }

    @Test
    @RequiresDevice
    public void test_setFitnessMachineControlPoint_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.setFitnessMachineControlPoint(new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESET, new byte[0], 0, 0, new byte[0])));
    }

    @Test
    @RequiresDevice
    public void test_setFitnessMachineControlPoint_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_setFitnessMachineControlPoint_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteCharacteristicTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineControlPointClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getFitnessMachineControlPointClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startFitnessMachineControlPointIndication_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startFitnessMachineControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startFitnessMachineControlPointIndication_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startFitnessMachineControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_startFitnessMachineControlPointIndication_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startFitnessMachineControlPointIndication_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopFitnessMachineControlPointIndication_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopFitnessMachineControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopFitnessMachineControlPointIndication_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopFitnessMachineControlPointIndication());
    }

    @Test
    @RequiresDevice
    public void test_stopFitnessMachineControlPointIndication_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopFitnessMachineControlPointIndication_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineControlPointCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.getFitnessMachineStatusClientCharacteristicConfiguration());
    }

    @Test
    @RequiresDevice
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_getFitnessMachineStatusClientCharacteristicConfiguration_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateReadDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startFitnessMachineStatusNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.startFitnessMachineStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_startFitnessMachineStatusNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.startFitnessMachineStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_startFitnessMachineStatusNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_startFitnessMachineStatusNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopFitnessMachineStatusNotification_00001() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null);

        assertNull(fitnessMachineService.stopFitnessMachineStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopFitnessMachineStatusNotification_00002() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isStarted() {
                return true;
            }

        };

        assertNull(fitnessMachineService.stopFitnessMachineStatusNotification());
    }

    @Test
    @RequiresDevice
    public void test_stopFitnessMachineStatusNotification_00003() {
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupported() {
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
    @RequiresDevice
    public void test_stopFitnessMachineStatusNotification_00004() {
        final Integer originalTaskId = 1;
        MOCK_BLE_CONNECTION.setCreateWriteDescriptorTaskId(originalTaskId);
        FitnessMachineService fitnessMachineService = new FitnessMachineService(MOCK_BLE_CONNECTION, new MockFitnessMachineServiceCallback(), null) {

            @Override
            public boolean isFitnessMachineStatusCharacteristicSupported() {
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
