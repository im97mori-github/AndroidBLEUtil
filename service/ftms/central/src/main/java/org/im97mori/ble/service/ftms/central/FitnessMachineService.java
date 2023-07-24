package org.im97mori.ble.service.ftms.central;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLECallback;
import org.im97mori.ble.BLEConnection;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeatureAndroid;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataAndroid;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataAndroid;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataPacketAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataAndroid;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataAndroid;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerDataAndroid;
import org.im97mori.ble.characteristic.u2ad1.RowerDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataAndroid;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataPacketAndroid;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatusAndroid;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRangeAndroid;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRangeAndroid;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRangeAndroid;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRangeAndroid;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRangeAndroid;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPointAndroid;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatusAndroid;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfigurationAndroid;
import org.im97mori.ble.service.central.AbstractCentralService;
import org.im97mori.ble.task.ReadCharacteristicTask;
import org.im97mori.ble.task.ReadDescriptorTask;
import org.im97mori.ble.task.WriteCharacteristicTask;
import org.im97mori.ble.task.WriteDescriptorTask;

import java.util.List;
import java.util.UUID;

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

/**
 * Fitness Machine Service (Service UUID: 0x1826) for Central
 */
public class FitnessMachineService extends AbstractCentralService {

    /**
     * {@link FitnessMachineServiceCallback} instance
     */
    private final FitnessMachineServiceCallback mFitnessMachineServiceCallback;

    /**
     * Treadmill Data characteristic flag
     * {@code true}:Treadmill Data characteristic is exist, {@code false}:Treadmill Data characteristic is not exist or service not ready
     */
    private boolean mIsTreadmillDataCharacteristicSupported;

    /**
     * Cross Trainer Data characteristic flag
     * {@code true}:Cross Trainer Data characteristic is exist, {@code false}:Cross Trainer Data characteristic is not exist or service not ready
     */
    private boolean mIsCrossTrainerDataCharacteristicSupported;

    /**
     * Step Climber Data characteristic flag
     * {@code true}:Step Climber Data characteristic is exist, {@code false}:Step Climber Data characteristic is not exist or service not ready
     */
    private boolean mIsStepClimberDataCharacteristicSupported;

    /**
     * Stair Climber Data characteristic flag
     * {@code true}:Stair Climber Data characteristic is exist, {@code false}:Stair Climber Data characteristic is not exist or service not ready
     */
    private boolean mIsStairClimberDataCharacteristicSupported;

    /**
     * Rower Data characteristic flag
     * {@code true}:Rower Data characteristic is exist, {@code false}:Rower Data characteristic is not exist or service not ready
     */
    private boolean mIsRowerDataCharacteristicSupported;

    /**
     * Indoor Bike Data characteristic flag
     * {@code true}:Indoor Bike Data characteristic is exist, {@code false}:Indoor Bike Data characteristic is not exist or service not ready
     */
    private boolean mIsIndoorBikeDataCharacteristicSupported;

    /**
     * Training Status characteristic flag
     * {@code true}:Training Status characteristic is exist, {@code false}:Training Status characteristic is not exist or service not ready
     */
    private boolean mIsTrainingStatusCharacteristicSupported;

    /**
     * Supported Speed Range characteristic flag
     * {@code true}:Supported Speed Range characteristic is exist, {@code false}:Supported Speed Range characteristic is not exist or service not ready
     */
    private boolean mIsSupportedSpeedRangeCharacteristicSupported;

    /**
     * Supported Inclination Range characteristic flag
     * {@code true}:Supported Inclination Range characteristic is exist, {@code false}:Supported Inclination Range characteristic is not exist or service not ready
     */
    private boolean mIsSupportedInclinationRangeCharacteristicSupported;

    /**
     * Supported Resistance Level Range characteristic flag
     * {@code true}:Supported Resistance Level Range characteristic is exist, {@code false}:Supported Resistance Level Range characteristic is not exist or service not ready
     */
    private boolean mIsSupportedResistanceLevelRangeCharacteristicSupported;

    /**
     * Supported Power Range characteristic flag
     * {@code true}:Supported Power Range characteristic is exist, {@code false}:Supported Power Range characteristic is not exist or service not ready
     */
    private boolean mIsSupportedPowerRangeCharacteristicSupported;

    /**
     * Supported Heart Rate Range characteristic flag
     * {@code true}:Supported Heart Rate Range characteristic is exist, {@code false}:Supported Heart Rate Range characteristic is not exist or service not ready
     */
    private boolean mIsSupportedHeartRateRangeCharacteristicSupported;

    /**
     * Fitness Machine Control Point characteristic flag
     * {@code true}:Fitness Machine Control Point characteristic is exist, {@code false}:Fitness Machine Control Point characteristic is not exist or service not ready
     */
    private boolean mIsFitnessMachineControlPointCharacteristicSupported;

    /**
     * Fitness Machine Status characteristic flag
     * {@code true}:Fitness Machine Status characteristic is exist, {@code false}:Fitness Machine Status characteristic is not exist or service not ready
     */
    private boolean mIsFitnessMachineStatusCharacteristicSupported;

    /**
     * @param bleConnection                 {@link BLEConnection} instance
     * @param fitnessMachineServiceCallback {@link FitnessMachineServiceCallback} instance
     * @param bleCallback                   {@link BLECallback} instance(optional)
     */
    public FitnessMachineService(@NonNull BLEConnection bleConnection, @NonNull FitnessMachineServiceCallback fitnessMachineServiceCallback, @Nullable BLECallback bleCallback) {
        super(bleConnection, bleCallback);
        mFitnessMachineServiceCallback = fitnessMachineServiceCallback;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onBLEDisconnected(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            mIsTreadmillDataCharacteristicSupported = false;
            mIsCrossTrainerDataCharacteristicSupported = false;
            mIsStepClimberDataCharacteristicSupported = false;
            mIsStairClimberDataCharacteristicSupported = false;
            mIsRowerDataCharacteristicSupported = false;
            mIsIndoorBikeDataCharacteristicSupported = false;
            mIsTrainingStatusCharacteristicSupported = false;
            mIsSupportedSpeedRangeCharacteristicSupported = false;
            mIsSupportedInclinationRangeCharacteristicSupported = false;
            mIsSupportedResistanceLevelRangeCharacteristicSupported = false;
            mIsSupportedPowerRangeCharacteristicSupported = false;
            mIsSupportedHeartRateRangeCharacteristicSupported = false;
            mIsFitnessMachineControlPointCharacteristicSupported = false;
            mIsFitnessMachineStatusCharacteristicSupported = false;
        }
        super.onBLEDisconnected(taskId, bluetoothDevice, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDiscoverServiceSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull List<BluetoothGattService> serviceList, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice)) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic;
            for (BluetoothGattService bluetoothGattService : serviceList) {
                if (FITNESS_MACHINE_SERVICE.equals(bluetoothGattService.getUuid())) {
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TREADMILL_DATA_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsTreadmillDataCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(CROSS_TRAINER_DATA_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsCrossTrainerDataCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STEP_CLIMBER_DATA_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsStepClimberDataCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(STAIR_CLIMBER_DATA_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsStairClimberDataCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(ROWER_DATA_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsRowerDataCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(INDOOR_BIKE_DATA_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsIndoorBikeDataCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(TRAINING_STATUS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY) == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsTrainingStatusCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_SPEED_RANGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsSupportedSpeedRangeCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsSupportedInclinationRangeCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsSupportedResistanceLevelRangeCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_POWER_RANGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsSupportedPowerRangeCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_READ == bluetoothGattCharacteristic.getProperties()) {
                        mIsSupportedHeartRateRangeCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && (BluetoothGattCharacteristic.PROPERTY_WRITE | BluetoothGattCharacteristic.PROPERTY_INDICATE) == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsFitnessMachineControlPointCharacteristicSupported = true;
                    }
                    bluetoothGattCharacteristic = bluetoothGattService.getCharacteristic(FITNESS_MACHINE_STATUS_CHARACTERISTIC);
                    if (bluetoothGattCharacteristic != null
                            && BluetoothGattCharacteristic.PROPERTY_NOTIFY == bluetoothGattCharacteristic.getProperties()
                            && bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR) != null) {
                        mIsFitnessMachineStatusCharacteristicSupported = true;
                    }
                }
            }
        }
        super.onDiscoverServiceSuccess(taskId, bluetoothDevice, serviceList, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (FITNESS_MACHINE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineFeatureReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FitnessMachineFeatureAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TrainingStatusAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SUPPORTED_SPEED_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedSpeedRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SupportedSpeedRangeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedInclinationRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SupportedInclinationRangeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedResistanceLevelRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SupportedResistanceLevelRangeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SUPPORTED_POWER_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedPowerRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SupportedPowerRangeAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedHeartRateRangeReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, SupportedHeartRateRangeAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (FITNESS_MACHINE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineFeatureReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SUPPORTED_SPEED_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedSpeedRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedInclinationRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedResistanceLevelRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SUPPORTED_POWER_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedPowerRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            } else if (SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedHeartRateRangeReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (FITNESS_MACHINE_FEATURE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineFeatureReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SUPPORTED_SPEED_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedSpeedRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedInclinationRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedResistanceLevelRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SUPPORTED_POWER_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedPowerRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            } else if (SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onSupportedHeartRateRangeReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onCharacteristicWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
            }
        }
        super.onCharacteristicWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
            }
        }
        super.onCharacteristicWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTreadmillDataClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onCrossTrainerDataClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStepClimberDataClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStairClimberDataClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onRowerDataClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onIndoorBikeDataClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineStatusClientCharacteristicConfigurationReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, ClientCharacteristicConfigurationAndroid.CREATOR.createFromByteArray(values), argument);
            }
        }
        super.onDescriptorReadSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTreadmillDataClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onCrossTrainerDataClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStepClimberDataClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStairClimberDataClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onRowerDataClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onIndoorBikeDataClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineStatusClientCharacteristicConfigurationReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
            }
        }
        super.onDescriptorReadFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorReadTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTreadmillDataClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onCrossTrainerDataClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStepClimberDataClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStairClimberDataClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onRowerDataClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onIndoorBikeDataClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineStatusClientCharacteristicConfigurationReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
            }
        }
        super.onDescriptorReadTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteSuccess(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @NonNull Integer descriptorInstanceId, @NonNull byte[] values, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onTreadmillDataNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onTreadmillDataNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onCrossTrainerDataNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onCrossTrainerDataNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onStepClimberDataNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onStepClimberDataNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onStairClimberDataNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onStairClimberDataNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onRowerDataNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onRowerDataNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onIndoorBikeDataNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onIndoorBikeDataNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onTrainingStatusNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onTrainingStatusNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicateStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicateStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onFitnessMachineStatusNotifyStartSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                } else {
                    mFitnessMachineServiceCallback.onFitnessMachineStatusNotifyStopSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, argument);
                }
            }
        }
        super.onDescriptorWriteSuccess(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, values, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteFailed(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, int status, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onTreadmillDataNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onTreadmillDataNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onCrossTrainerDataNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onCrossTrainerDataNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onStepClimberDataNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onStepClimberDataNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onStairClimberDataNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onStairClimberDataNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onRowerDataNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onRowerDataNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onIndoorBikeDataNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onIndoorBikeDataNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onTrainingStatusNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onTrainingStatusNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicateStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicateStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onFitnessMachineStatusNotifyStartFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                } else {
                    mFitnessMachineServiceCallback.onFitnessMachineStatusNotifyStopFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, status, argument);
                }
            }
        }
        super.onDescriptorWriteFailed(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, status, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDescriptorWriteTimeout(@NonNull Integer taskId, @NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @Nullable Integer serviceInstanceId, @NonNull UUID characteristicUUID, @Nullable Integer characteristicInstanceId, @NonNull UUID descriptorUUID, @Nullable Integer descriptorInstanceId, long timeout, @Nullable Bundle argument) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID) && CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorUUID) && argument != null && argument.containsKey(KEY_STATUS)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onTreadmillDataNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onTreadmillDataNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onCrossTrainerDataNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onCrossTrainerDataNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onStepClimberDataNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onStepClimberDataNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onStairClimberDataNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onStairClimberDataNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onRowerDataNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onRowerDataNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onIndoorBikeDataNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onIndoorBikeDataNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onTrainingStatusNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onTrainingStatusNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicateStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicateStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                if (argument.getInt(KEY_STATUS, STATUS_START) == STATUS_START) {
                    mFitnessMachineServiceCallback.onFitnessMachineStatusNotifyStartTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                } else {
                    mFitnessMachineServiceCallback.onFitnessMachineStatusNotifyStopTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, timeout, argument);
                }
            }
        }
        super.onDescriptorWriteTimeout(taskId, bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorUUID, descriptorInstanceId, timeout, argument);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onCharacteristicNotified(@NonNull BluetoothDevice bluetoothDevice, @NonNull UUID serviceUUID, @NonNull Integer serviceInstanceId, @NonNull UUID characteristicUUID, @NonNull Integer characteristicInstanceId, @NonNull byte[] values) {
        if (mBLEConnection.getBluetoothDevice().equals(bluetoothDevice) && FITNESS_MACHINE_SERVICE.equals(serviceUUID)) {
            if (TREADMILL_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTreadmillDataNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TreadmillDataAndroid.CREATOR.createFromMultiplePacketArray(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(values)}));
            } else if (CROSS_TRAINER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onCrossTrainerDataNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, CrossTrainerDataAndroid.CREATOR.createFromMultiplePacketArray(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(values)}));
            } else if (STEP_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStepClimberDataNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, StepClimberDataAndroid.CREATOR.createFromMultiplePacketArray(new StepClimberDataPacketAndroid[]{StepClimberDataPacketAndroid.CREATOR.createFromByteArray(values)}));
            } else if (STAIR_CLIMBER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onStairClimberDataNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, StairClimberDataAndroid.CREATOR.createFromMultiplePacketArray(new StairClimberDataPacketAndroid[]{StairClimberDataPacketAndroid.CREATOR.createFromByteArray(values)}));
            } else if (ROWER_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onRowerDataNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, RowerDataAndroid.CREATOR.createFromMultiplePacketArray(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(values)}));
            } else if (INDOOR_BIKE_DATA_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onIndoorBikeDataNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, IndoorBikeDataAndroid.CREATOR.createFromMultiplePacketArray(new IndoorBikeDataPacketAndroid[]{IndoorBikeDataPacketAndroid.CREATOR.createFromByteArray(values)}));
            } else if (TRAINING_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onTrainingStatusNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, TrainingStatusAndroid.CREATOR.createFromByteArray(values));
            } else if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineControlPointIndicated(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FitnessMachineControlPointAndroid.CREATOR.createFromByteArray(values));
            } else if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicUUID)) {
                mFitnessMachineServiceCallback.onFitnessMachineStatusNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, FitnessMachineStatusAndroid.CREATOR.createFromByteArray(values));
            }
        }
        super.onCharacteristicNotified(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, values);
    }

    /**
     * check Treadmill Data characteristic
     *
     * @return {@code true}:Treadmill Data characteristic is exist, {@code false}:Treadmill Data characteristic is not exist or service not ready
     */
    public boolean isTreadmillDataCharacteristicSupported() {
        return mIsTreadmillDataCharacteristicSupported;
    }

    /**
     * check Cross Trainer Data characteristic
     *
     * @return {@code true}:Cross Trainer Data characteristic is exist, {@code false}:Cross Trainer Data characteristic is not exist or service not ready
     */
    public boolean isCrossTrainerDataCharacteristicSupported() {
        return mIsCrossTrainerDataCharacteristicSupported;
    }

    /**
     * check Step Climber Data characteristic
     *
     * @return {@code true}:Step Climber Data characteristic is exist, {@code false}:Step Climber Data characteristic is not exist or service not ready
     */
    public boolean isStepClimberDataCharacteristicSupported() {
        return mIsStepClimberDataCharacteristicSupported;
    }

    /**
     * check Stair Climber Data characteristic
     *
     * @return {@code true}:Stair Climber Data characteristic is exist, {@code false}:Stair Climber Data characteristic is not exist or service not ready
     */
    public boolean isStairClimberDataCharacteristicSupported() {
        return mIsStairClimberDataCharacteristicSupported;
    }

    /**
     * check Rower Data characteristic
     *
     * @return {@code true}:Rower Data characteristic is exist, {@code false}:Rower Data characteristic is not exist or service not ready
     */
    public boolean isRowerDataCharacteristicSupported() {
        return mIsRowerDataCharacteristicSupported;
    }

    /**
     * check Indoor Bike Data characteristic
     *
     * @return {@code true}:Indoor Bike Data characteristic is exist, {@code false}:Indoor Bike Data characteristic is not exist or service not ready
     */
    public boolean isIndoorBikeDataCharacteristicSupported() {
        return mIsIndoorBikeDataCharacteristicSupported;
    }

    /**
     * check Training Status Data characteristic
     *
     * @return {@code true}:Training Status Data characteristic is exist, {@code false}:Training Status Data characteristic is not exist or service not ready
     */
    public boolean isTrainingStatusCharacteristicSupported() {
        return mIsTrainingStatusCharacteristicSupported;
    }

    /**
     * check Supported Speed Range characteristic
     *
     * @return {@code true}:Supported Speed Range characteristic is exist, {@code false}:Supported Speed Range characteristic is not exist or service not ready
     */
    public boolean isSupportedSpeedRangeCharacteristicSupported() {
        return mIsSupportedSpeedRangeCharacteristicSupported;
    }

    /**
     * check Supported Inclination Range characteristic
     *
     * @return {@code true}:Supported Inclination Range characteristic is exist, {@code false}:Supported Inclination Range characteristic is not exist or service not ready
     */
    public boolean isSupportedInclinationRangeCharacteristicSupported() {
        return mIsSupportedInclinationRangeCharacteristicSupported;
    }

    /**
     * check Supported Resistance Level Range characteristic
     *
     * @return {@code true}:Supported Resistance Level Range characteristic is exist, {@code false}:Supported Resistance Level Range characteristic is not exist or service not ready
     */
    public boolean isSupportedResistanceLevelRangeCharacteristicSupported() {
        return mIsSupportedResistanceLevelRangeCharacteristicSupported;
    }

    /**
     * check Supported Power Range characteristic
     *
     * @return {@code true}:Supported Power Range characteristic is exist, {@code false}:Supported Power Range characteristic is not exist or service not ready
     */
    public boolean isSupportedPowerRangeCharacteristicSupported() {
        return mIsSupportedPowerRangeCharacteristicSupported;
    }

    /**
     * check Supported Heart Rate Range characteristic
     *
     * @return {@code true}:Supported Heart Rate Range characteristic is exist, {@code false}:Supported Heart Rate Range characteristic is not exist or service not ready
     */
    public boolean isSupportedHeartRateRangeCharacteristicSupported() {
        return mIsSupportedHeartRateRangeCharacteristicSupported;
    }

    /**
     * check Fitness Machine Control Point characteristic
     *
     * @return {@code true}:Fitness Machine Control Point characteristic is exist, {@code false}:Fitness Machine Control Point characteristic is not exist or service not ready
     */
    public boolean isFitnessMachineControlPointCharacteristicSupported() {
        return mIsFitnessMachineControlPointCharacteristicSupported;
    }

    /**
     * check Fitness Machine Status characteristic
     *
     * @return {@code true}:Fitness Machine Status characteristic is exist, {@code false}:Fitness Machine Status characteristic is not exist or service not ready
     */
    public boolean isFitnessMachineStatusCharacteristicSupported() {
        return mIsFitnessMachineStatusCharacteristicSupported;
    }

    /**
     * get Fitness Machine Feature
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineFeatureReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FitnessMachineFeatureAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineFeatureReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineFeatureReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFitnessMachineFeature() {
        Integer taskId = null;
        if (isStarted()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_FEATURE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Treadmill Data's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTreadmillDataClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onTreadmillDataClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTreadmillDataClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTreadmillDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isTreadmillDataCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, TREADMILL_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Treadmill Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTreadmillDataNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onTreadmillDataNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTreadmillDataNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startTreadmillDataNotification() {
        Integer taskId = null;
        if (isStarted() && isTreadmillDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, TREADMILL_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Treadmill Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTreadmillDataNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onTreadmillDataNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTreadmillDataNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopTreadmillDataNotification() {
        Integer taskId = null;
        if (isStarted() && isTreadmillDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, TREADMILL_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Cross Trainer Data's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onCrossTrainerDataClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onCrossTrainerDataClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onCrossTrainerDataClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getCrossTrainerDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isCrossTrainerDataCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, CROSS_TRAINER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Cross Trainer Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onCrossTrainerDataNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onCrossTrainerDataNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onCrossTrainerDataNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startCrossTrainerDataNotification() {
        Integer taskId = null;
        if (isStarted() && isCrossTrainerDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, CROSS_TRAINER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Cross Trainer Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onCrossTrainerDataNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onCrossTrainerDataNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onCrossTrainerDataNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopCrossTrainerDataNotification() {
        Integer taskId = null;
        if (isStarted() && isCrossTrainerDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, CROSS_TRAINER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Step Climber Data's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onStepClimberDataClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onStepClimberDataClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onStepClimberDataClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getStepClimberDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isStepClimberDataCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, STEP_CLIMBER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Step Climber Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onStepClimberDataNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onStepClimberDataNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onStepClimberDataNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startStepClimberDataNotification() {
        Integer taskId = null;
        if (isStarted() && isStepClimberDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, STEP_CLIMBER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Step Climber Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onStepClimberDataNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onStepClimberDataNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onStepClimberDataNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopStepClimberDataNotification() {
        Integer taskId = null;
        if (isStarted() && isStepClimberDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, STEP_CLIMBER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Stair Climber Data's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onStairClimberDataClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onStairClimberDataClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onStairClimberDataClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getStairClimberDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isStairClimberDataCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, STAIR_CLIMBER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Stair Climber Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onStairClimberDataNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onStairClimberDataNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onStairClimberDataNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startStairClimberDataNotification() {
        Integer taskId = null;
        if (isStarted() && isStairClimberDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, STAIR_CLIMBER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Stair Climber Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onStairClimberDataNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onStairClimberDataNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onStairClimberDataNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopStairClimberDataNotification() {
        Integer taskId = null;
        if (isStarted() && isStairClimberDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, STAIR_CLIMBER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Rower Data's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onRowerDataClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onRowerDataClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onRowerDataClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getRowerDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isRowerDataCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, ROWER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Rower Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onRowerDataNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onRowerDataNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onRowerDataNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startRowerDataNotification() {
        Integer taskId = null;
        if (isStarted() && isRowerDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, ROWER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Rower Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onRowerDataNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onRowerDataNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onRowerDataNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopRowerDataNotification() {
        Integer taskId = null;
        if (isStarted() && isRowerDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, ROWER_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Indoor Bike Data's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onIndoorBikeDataClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onIndoorBikeDataClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onIndoorBikeDataClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getIndoorBikeDataClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isIndoorBikeDataCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, INDOOR_BIKE_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Indoor Bike Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onIndoorBikeDataNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onIndoorBikeDataNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onIndoorBikeDataNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startIndoorBikeDataNotification() {
        Integer taskId = null;
        if (isStarted() && isIndoorBikeDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, INDOOR_BIKE_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Indoor Bike Data notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onIndoorBikeDataNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onIndoorBikeDataNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onIndoorBikeDataNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopIndoorBikeDataNotification() {
        Integer taskId = null;
        if (isStarted() && isIndoorBikeDataCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, INDOOR_BIKE_DATA_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Training Status
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTrainingStatusReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, TrainingStatusAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrainingStatus() {
        Integer taskId = null;
        if (isStarted() && isTrainingStatusCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, TRAINING_STATUS_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Training Status's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTrainingStatusClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getTrainingStatusClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isTrainingStatusCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, TRAINING_STATUS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Training Status notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTrainingStatusNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startTrainingStatusNotification() {
        Integer taskId = null;
        if (isStarted() && isTrainingStatusCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, TRAINING_STATUS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Training Status notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onTrainingStatusNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onTrainingStatusNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopTrainingStatusNotification() {
        Integer taskId = null;
        if (isStarted() && isTrainingStatusCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, TRAINING_STATUS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Supported Speed Range
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onSupportedSpeedRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SupportedSpeedRangeAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedSpeedRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedSpeedRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSupportedSpeedRange() {
        Integer taskId = null;
        if (isStarted() && isSupportedSpeedRangeCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, SUPPORTED_SPEED_RANGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Supported Inclination Range
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onSupportedInclinationRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SupportedInclinationRangeAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedInclinationRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedInclinationRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSupportedInclinationRange() {
        Integer taskId = null;
        if (isStarted() && isSupportedInclinationRangeCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Supported Resistance Level Range
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onSupportedResistanceLevelRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SupportedResistanceLevelRangeAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedResistanceLevelRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedResistanceLevelRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSupportedResistanceLevelRange() {
        Integer taskId = null;
        if (isStarted() && isSupportedResistanceLevelRangeCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Supported Power Range
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onSupportedPowerRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SupportedPowerRangeAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedPowerRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedPowerRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSupportedPowerRange() {
        Integer taskId = null;
        if (isStarted() && isSupportedPowerRangeCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, SUPPORTED_POWER_RANGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Supported Heart Rate Range
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onSupportedHeartRateRangeReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, SupportedHeartRateRangeAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedHeartRateRangeReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onSupportedHeartRateRangeReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getSupportedHeartRateRange() {
        Integer taskId = null;
        if (isStarted() && isSupportedHeartRateRangeCharacteristicSupported()) {
            taskId = mBLEConnection.createReadCharacteristicTask(FITNESS_MACHINE_SERVICE, null, SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, null, ReadCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * set Fitness Machine Control Point
     *
     * @param fitnessMachineControlPoint {@link FitnessMachineControlPoint} instance
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointWriteSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, FitnessMachineControlPointAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointWriteFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointWriteTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer setFitnessMachineControlPoint(@NonNull FitnessMachineControlPoint fitnessMachineControlPoint) {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineControlPointCharacteristicSupported()) {
            taskId = mBLEConnection.createWriteCharacteristicTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, null, fitnessMachineControlPoint, BluetoothGattCharacteristic.WRITE_TYPE_DEFAULT, WriteCharacteristicTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * get Fitness Machine Control Point's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFitnessMachineControlPointClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineControlPointCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Fitness Machine Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointIndicateStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointIndicateStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointIndicateStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startFitnessMachineControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineControlPointCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Fitness Machine Control Point indication
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointIndicateStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointIndicateStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineControlPointIndicateStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopFitnessMachineControlPointIndication() {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineControlPointCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * get Fitness Machine Status's Client Characteristic Configuration
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusClientCharacteristicConfigurationReadSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, ClientCharacteristicConfigurationAndroid, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusClientCharacteristicConfigurationReadFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusClientCharacteristicConfigurationReadTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer getFitnessMachineStatusClientCharacteristicConfiguration() {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineStatusCharacteristicSupported()) {
            taskId = mBLEConnection.createReadDescriptorTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_STATUS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, ReadDescriptorTask.TIMEOUT_MILLIS, null, this);
        }
        return taskId;
    }

    /**
     * start Fitness Machine Status notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusNotifyStartSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusNotifyStartFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusNotifyStartTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer startFitnessMachineStatusNotification() {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineStatusCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_START);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_STATUS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

    /**
     * stop Fitness Machine Status notification
     *
     * @return task id. if {@code null} returned, service is not ready
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusNotifyStopSuccess(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusNotifyStopFailed(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, int, Bundle)
     * @see FitnessMachineServiceCallback#onFitnessMachineStatusNotifyStopTimeout(Integer, BluetoothDevice, UUID, Integer, UUID, Integer, Integer, long, Bundle)
     */
    @Nullable
    public synchronized Integer stopFitnessMachineStatusNotification() {
        Integer taskId = null;
        if (isStarted() && isFitnessMachineStatusCharacteristicSupported()) {
            Bundle bundle = new Bundle();
            bundle.putInt(KEY_STATUS, STATUS_STOP);
            taskId = mBLEConnection.createWriteDescriptorTask(FITNESS_MACHINE_SERVICE, null, FITNESS_MACHINE_STATUS_CHARACTERISTIC, null, CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, null, new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE), WriteDescriptorTask.TIMEOUT_MILLIS, bundle, this);
        }
        return taskId;
    }

}
