package org.im97mori.ble.service.ftms.peripheral;

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
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ErrorCode.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED;
import static org.im97mori.ble.constants.ServiceUUID.FITNESS_MACHINE_SERVICE;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.core.CrossTrainerDataUtils;
import org.im97mori.ble.characteristic.core.IndoorBikeDataUtils;
import org.im97mori.ble.characteristic.core.RowerDataUtils;
import org.im97mori.ble.characteristic.core.StairClimberDataUtils;
import org.im97mori.ble.characteristic.core.StepClimberDataUtils;
import org.im97mori.ble.characteristic.core.TreadmillDataUtils;
import org.im97mori.ble.characteristic.u2acc.FitnessMachineFeature;
import org.im97mori.ble.characteristic.u2acd.TreadmillData;
import org.im97mori.ble.characteristic.u2acd.TreadmillDataPacket;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerData;
import org.im97mori.ble.characteristic.u2ace.CrossTrainerDataPacket;
import org.im97mori.ble.characteristic.u2acf.StepClimberData;
import org.im97mori.ble.characteristic.u2acf.StepClimberDataPacket;
import org.im97mori.ble.characteristic.u2ad0.StairClimberData;
import org.im97mori.ble.characteristic.u2ad0.StairClimberDataPacket;
import org.im97mori.ble.characteristic.u2ad1.RowerData;
import org.im97mori.ble.characteristic.u2ad1.RowerDataPacket;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeData;
import org.im97mori.ble.characteristic.u2ad2.IndoorBikeDataPacket;
import org.im97mori.ble.characteristic.u2ad3.TrainingStatus;
import org.im97mori.ble.characteristic.u2ad4.SupportedSpeedRange;
import org.im97mori.ble.characteristic.u2ad5.SupportedInclinationRange;
import org.im97mori.ble.characteristic.u2ad6.SupportedResistanceLevelRange;
import org.im97mori.ble.characteristic.u2ad7.SupportedHeartRateRange;
import org.im97mori.ble.characteristic.u2ad8.SupportedPowerRange;
import org.im97mori.ble.characteristic.u2ad9.FitnessMachineControlPoint;
import org.im97mori.ble.characteristic.u2ada.FitnessMachineStatus;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Fitness Machine Service (Service UUID: 0x1826) for Peripheral
 */
public class FitnessMachineServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link FitnessMachineServiceMockCallback}
     *
     * @param <T> subclass of {@link FitnessMachineServiceMockCallback}
     */
    public static class Builder<T extends FitnessMachineServiceMockCallback> extends AbstractServiceMockCallback.Builder<FitnessMachineServiceMockCallback> {

        /**
         * Fitness Machine Feature data
         */
        protected CharacteristicData mFitnessMachineFeatureData;

        /**
         * Treadmill Data data
         */
        protected CharacteristicData mTreadmillDataData;

        /**
         * Cross Trainer Data data
         */
        protected CharacteristicData mCrossTrainerDataData;

        /**
         * Step Climber Data data
         */
        protected CharacteristicData mStepClimberDataData;

        /**
         * Stair Climber Data data
         */
        protected CharacteristicData mStairClimberDataData;

        /**
         * Rower Data data
         */
        protected CharacteristicData mRowerDataData;

        /**
         * Indoor Bike Data data
         */
        protected CharacteristicData mIndoorBikeDataData;

        /**
         * Training Status data
         */
        protected CharacteristicData mTrainingStatusData;

        /**
         * Supported Speed Range data
         */
        protected CharacteristicData mSupportedSpeedRangeData;

        /**
         * Supported Inclination Range data
         */
        protected CharacteristicData mSupportedInclinationRangeData;

        /**
         * Supported Resistance Level Range data
         */
        protected CharacteristicData mSupportedResistanceLevelRangeData;

        /**
         * Supported Power Range data
         */
        protected CharacteristicData mSupportedPowerRangeData;

        /**
         * Supported Heart Rate Range data
         */
        protected CharacteristicData mSupportedHeartRateRangeData;

        /**
         * Fitness Machine Control Point data
         */
        protected FitnessMachineControlPointCharacteristicData mFitnessMachineControlPointData;

        /**
         * Fitness Machine Status data
         */
        protected FitnessMachineStatusCharacteristicData mFitnessMachineStatusData;

        /**
         * @see #addFitnessMachineFeature(byte[])
         */
        @NonNull
        public Builder<T> addFitnessMachineFeature(@NonNull FitnessMachineFeature fitnessMachineFeature) {
            return addFitnessMachineFeature(fitnessMachineFeature.getBytes());
        }

        /**
         * @see #addFitnessMachineFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFitnessMachineFeature(@NonNull byte[] value) {
            return addFitnessMachineFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Fitness Machine Feature characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFitnessMachineFeature(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineFeatureData = new CharacteristicData(FITNESS_MACHINE_FEATURE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Fitness Machine Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFitnessMachineFeature() {
            mFitnessMachineFeatureData = null;
            return this;
        }

        /**
         * @see #addTreadmillData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTreadmillData(@NonNull TreadmillData treadmillData, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addTreadmillData(BluetoothGatt.GATT_SUCCESS, 0, treadmillData.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Treadmill Data characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTreadmillData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mTreadmillDataData = new CharacteristicData(TREADMILL_DATA_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Treadmill Data characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTreadmillData() {
            mTreadmillDataData = null;
            return this;
        }

        /**
         * @see #addCrossTrainerData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCrossTrainerData(@NonNull CrossTrainerData crossTrainerData, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCrossTrainerData(BluetoothGatt.GATT_SUCCESS, 0, crossTrainerData.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Cross Trainer Data characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCrossTrainerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCrossTrainerDataData = new CharacteristicData(CROSS_TRAINER_DATA_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Cross Trainer Data characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCrossTrainerData() {
            mCrossTrainerDataData = null;
            return this;
        }

        /**
         * @see #addStepClimberData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addStepClimberData(@NonNull StepClimberData stepClimberData, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addStepClimberData(BluetoothGatt.GATT_SUCCESS, 0, stepClimberData.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Step Climber Data characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addStepClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mStepClimberDataData = new CharacteristicData(STEP_CLIMBER_DATA_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Step Climber Data characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeStepClimberData() {
            mStepClimberDataData = null;
            return this;
        }

        /**
         * @see #addStairClimberData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addStairClimberData(@NonNull StairClimberData stairClimberData, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addStairClimberData(BluetoothGatt.GATT_SUCCESS, 0, stairClimberData.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Stair Climber Data characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addStairClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mStairClimberDataData = new CharacteristicData(STAIR_CLIMBER_DATA_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Stair Climber Data characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeStairClimberData() {
            mStairClimberDataData = null;
            return this;
        }

        /**
         * @see #addRowerData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRowerData(@NonNull RowerData rowerData, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addRowerData(BluetoothGatt.GATT_SUCCESS, 0, rowerData.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Rower Data characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRowerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mRowerDataData = new CharacteristicData(ROWER_DATA_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Rower Data characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRowerData() {
            mRowerDataData = null;
            return this;
        }

        /**
         * @see #addIndoorBikeData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIndoorBikeData(@NonNull IndoorBikeData indoorBikeData, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addIndoorBikeData(BluetoothGatt.GATT_SUCCESS, 0, indoorBikeData.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Indoor Bike Data characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addIndoorBikeData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mIndoorBikeDataData = new CharacteristicData(INDOOR_BIKE_DATA_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Indoor Bike Data characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIndoorBikeData() {
            mIndoorBikeDataData = null;
            return this;
        }

        /**
         * @see #addTrainingStatus(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTrainingStatus(@NonNull TrainingStatus trainingStatus, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addTrainingStatus(BluetoothGatt.GATT_SUCCESS, 0, trainingStatus.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Training Status characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTrainingStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mTrainingStatusData = new CharacteristicData(TRAINING_STATUS_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ | BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Training Status characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTrainingStatus() {
            mTrainingStatusData = null;
            return this;
        }

        /**
         * @see #addSupportedSpeedRange(byte[])
         */
        @NonNull
        public Builder<T> addSupportedSpeedRange(@NonNull SupportedSpeedRange supportedSpeedRange) {
            return addSupportedSpeedRange(supportedSpeedRange.getBytes());
        }

        /**
         * @see #addSupportedSpeedRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedSpeedRange(@NonNull byte[] value) {
            return addSupportedSpeedRange(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported Speed Range characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedSpeedRange(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedSpeedRangeData = new CharacteristicData(SUPPORTED_SPEED_RANGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Supported Speed Range characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedSpeedRange() {
            mSupportedSpeedRangeData = null;
            return this;
        }

        /**
         * @see #addSupportedInclinationRange(byte[])
         */
        @NonNull
        public Builder<T> addSupportedInclinationRange(@NonNull SupportedInclinationRange supportedInclinationRange) {
            return addSupportedInclinationRange(supportedInclinationRange.getBytes());
        }

        /**
         * @see #addSupportedInclinationRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedInclinationRange(@NonNull byte[] value) {
            return addSupportedInclinationRange(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported Inclination Range characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedInclinationRange(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedInclinationRangeData = new CharacteristicData(SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Supported Inclination Range characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedInclinationRange() {
            mSupportedInclinationRangeData = null;
            return this;
        }

        /**
         * @see #addSupportedResistanceLevelRange(byte[])
         */
        @NonNull
        public Builder<T> addSupportedResistanceLevelRange(@NonNull SupportedResistanceLevelRange supportedResistanceLevelRange) {
            return addSupportedResistanceLevelRange(supportedResistanceLevelRange.getBytes());
        }

        /**
         * @see #addSupportedResistanceLevelRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedResistanceLevelRange(@NonNull byte[] value) {
            return addSupportedResistanceLevelRange(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported Resistance Level Range characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedResistanceLevelRange(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedResistanceLevelRangeData = new CharacteristicData(SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Supported Resistance Level Range characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedResistanceLevelRange() {
            mSupportedResistanceLevelRangeData = null;
            return this;
        }

        /**
         * @see #addSupportedPowerRange(byte[])
         */
        @NonNull
        public Builder<T> addSupportedPowerRange(@NonNull SupportedPowerRange supportedPowerRange) {
            return addSupportedPowerRange(supportedPowerRange.getBytes());
        }

        /**
         * @see #addSupportedPowerRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedPowerRange(@NonNull byte[] value) {
            return addSupportedPowerRange(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported Power Range characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedPowerRange(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedPowerRangeData = new CharacteristicData(SUPPORTED_POWER_RANGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Supported Power Range characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedPowerRange() {
            mSupportedPowerRangeData = null;
            return this;
        }

        /**
         * @see #addSupportedPowerRange(byte[])
         */
        @NonNull
        public Builder<T> addSupportedHeartRateRange(@NonNull SupportedHeartRateRange supportedHeartRateRange) {
            return addSupportedHeartRateRange(supportedHeartRateRange.getBytes());
        }

        /**
         * @see #addSupportedHeartRateRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedHeartRateRange(@NonNull byte[] value) {
            return addSupportedHeartRateRange(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Supported Heart Rate Range characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSupportedHeartRateRange(int responseCode, long delay, @NonNull byte[] value) {
            mSupportedHeartRateRangeData = new CharacteristicData(SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Supported Heart Rate Range characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSupportedHeartRateRange() {
            mSupportedHeartRateRangeData = null;
            return this;
        }

        /**
         * add Fitness Machine Control Point characteristic
         *
         * @param characteristicDelay                            characteristic response delay(millis)
         * @param descriptorResponseCode                         descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                                descritptor response delay(millis)
         * @param descriptorValue                                descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param requestControlResultCode                       characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Control result)
         * @param resetResultCode                                characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Reset result)
         * @param setTargetSpeedResultCode                       characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Target Speed result)
         * @param setTargetInclinationResultCode                 characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Target Inclination result)
         * @param setTargetResistanceLevelResultCode             characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Target Power result)
         * @param setTargetPowerResultCode                       characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Target Power result)
         * @param setTargetHeartRateResultCode                   characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Target Heart Rate result)
         * @param startOrResumeResultCode                        characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Start or Resume result)
         * @param stopOrPauseResultCode                          characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Stop or Pause result)
         * @param setTargetedExpendedEnergyResultCode            characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Expended Energy result)
         * @param setTargetedNumberOfStepsResultCode             characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Number of Steps result)
         * @param setTargetedNumberOfStridesResultCode           characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Number of Strides result)
         * @param setTargetedDistanceResultCode                  characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Distance result)
         * @param setTargetedTrainingTimeResultCode              characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Training Time result)
         * @param setTargetedTimeInTwoHeartRateZonesResultCode   characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Timein Two Heart Rate Zones result)
         * @param setTargetedTimeInThreeHeartRateZonesResultCode characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Timein Three Heart Rate Zones result)
         * @param setTargetedTimeInFiveHeartRateZonesResultCode  characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Timein Five Heart Rate Zones result)
         * @param setIndoorBikeSimulationParametersResultCode    characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Indoor Bike Simulation Parameters result)
         * @param setWheelCircumferenceResultCode                characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Wheel Circumference result)
         * @param spinDownControlResultCode                      characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Spin Down Control result)
         * @param spinDownControlResultParameter                 characteristic result data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Spin Down Control result)
         * @param setTargetedCadenceResultCode                   characteristic result code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Targeted Cadence result)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFitnessMachineControlPoint(long characteristicDelay
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue
                , int requestControlResultCode
                , int resetResultCode
                , int setTargetSpeedResultCode
                , int setTargetInclinationResultCode
                , int setTargetResistanceLevelResultCode
                , int setTargetPowerResultCode
                , int setTargetHeartRateResultCode
                , int startOrResumeResultCode
                , int stopOrPauseResultCode
                , int setTargetedExpendedEnergyResultCode
                , int setTargetedNumberOfStepsResultCode
                , int setTargetedNumberOfStridesResultCode
                , int setTargetedDistanceResultCode
                , int setTargetedTrainingTimeResultCode
                , int setTargetedTimeInTwoHeartRateZonesResultCode
                , int setTargetedTimeInThreeHeartRateZonesResultCode
                , int setTargetedTimeInFiveHeartRateZonesResultCode
                , int setIndoorBikeSimulationParametersResultCode
                , int setWheelCircumferenceResultCode
                , int spinDownControlResultCode
                , @NonNull byte[] spinDownControlResultParameter
                , int setTargetedCadenceResultCode) {
            mFitnessMachineControlPointData = new FitnessMachineControlPointCharacteristicData(Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicDelay
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
            return this;
        }

        /**
         * remove Fitness Machine Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFitnessMachineControlPoint() {
            mFitnessMachineControlPointData = null;
            return this;
        }

        /**
         * add Fitness Machine Status characteristic
         *
         * @param spinDownStatusValue    Spin Down Status Value
         * @param descriptorResponseCode descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay        descritptor response delay(millis)
         * @param descriptorValue        descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addFitnessMachineStatus(int spinDownStatusValue
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mFitnessMachineStatusData = new FitnessMachineStatusCharacteristicData(Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , spinDownStatusValue);
            return this;
        }

        /**
         * remove Fitness Machine Status characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeFitnessMachineStatus() {
            mFitnessMachineStatusData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mFitnessMachineFeatureData == null) {
                throw new RuntimeException("no Fitness Machine Feature data");
            } else {
                characteristicList.add(mFitnessMachineFeatureData);
            }

            FitnessMachineFeature fitnessMachineFeature = new FitnessMachineFeature(mFitnessMachineFeatureData.getBytes());

            if (mTreadmillDataData != null) {
                TreadmillData treadmillData = new TreadmillData(new TreadmillDataPacket(mTreadmillDataData.getBytes()));
                if (fitnessMachineFeature.isFitnessMachineFeaturesAverageSpeedNotSupported() && TreadmillDataUtils.isFlagsAverageSpeedPresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Average Speed not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesTotalDistanceNotSupported() && TreadmillDataUtils.isFlagsTotalDistancePresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Total Distance not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesInclinationNotSupported() && TreadmillDataUtils.isFlagsInclinationAndRampAngleSettingPresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Inclination not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElevationGainNotSupported() && TreadmillDataUtils.isFlagsElevationGainPresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Elevation Gain not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPaceNotSupported() && TreadmillDataUtils.isFlagsInstantaneousPacePresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Pace not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPaceNotSupported() && TreadmillDataUtils.isFlagsAveragePacePresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Pace not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesExpendedEnergyNotSupported() && TreadmillDataUtils.isFlagsExpendedEnergyPresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Expended Energy not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesHeartRateMeasurementNotSupported() && TreadmillDataUtils.isFlagsHeartRatePresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Heart Rate Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesMetabolicEquivalentNotSupported() && TreadmillDataUtils.isFlagsMetabolicEquivalentPresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Metabolic Equivalent not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeNotSupported() && TreadmillDataUtils.isFlagsElapsedTimePresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Elapsed Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeNotSupported() && TreadmillDataUtils.isFlagsRemainingTimePresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Remaining Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesForceOnBeltAndPowerOutputNotSupported() && TreadmillDataUtils.isFlagsForceOnBeltAndPowerOutputPresent(treadmillData.getFlags())) {
                    throw new RuntimeException("Force on Belt and Power Output not Supported");
                }
                characteristicList.add(mTreadmillDataData);
            }

            if (mCrossTrainerDataData != null) {
                CrossTrainerData crossTrainerData = new CrossTrainerData(new CrossTrainerDataPacket(mCrossTrainerDataData.getBytes()));
                if (fitnessMachineFeature.isFitnessMachineFeaturesAverageSpeedNotSupported() && CrossTrainerDataUtils.isFlagsAverageSpeedPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Average Speed not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesTotalDistanceNotSupported() && CrossTrainerDataUtils.isFlagsTotalDistancePresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Total Distance not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesStepCountNotSupported() && CrossTrainerDataUtils.isFlagsStepCountPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Step Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesStrideCountNotSupported() && CrossTrainerDataUtils.isFlagsStrideCountPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Stride Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElevationGainNotSupported() && CrossTrainerDataUtils.isFlagsElevationGainPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Elevation Gain not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesInclinationNotSupported() && CrossTrainerDataUtils.isFlagsInclinationAndRampAngleSettingPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Inclination not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesResistanceLevelNotSupported() && CrossTrainerDataUtils.isFlagsResistanceLevelPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Resistance Level not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPowerMeasurementNotSupported() && CrossTrainerDataUtils.isFlagsInstantaneousPowerPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Power Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPowerMeasurementNotSupported() && CrossTrainerDataUtils.isFlagsAveragePowerPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Power Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesExpendedEnergyNotSupported() && CrossTrainerDataUtils.isFlagsExpendedEnergyPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Expended Energy not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesHeartRateMeasurementNotSupported() && CrossTrainerDataUtils.isFlagsHeartRatePresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Heart Rate Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesMetabolicEquivalentNotSupported() && CrossTrainerDataUtils.isFlagsMetabolicEquivalentPresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Metabolic Equivalent not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeNotSupported() && CrossTrainerDataUtils.isFlagsElapsedTimePresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Elapsed Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeNotSupported() && CrossTrainerDataUtils.isFlagsRemainingTimePresent(crossTrainerData.getFlags())) {
                    throw new RuntimeException("Remaining Time not Supported");
                }
                characteristicList.add(mCrossTrainerDataData);
            }

            if (mStepClimberDataData != null) {
                StepClimberData stepClimberData = new StepClimberData(new StepClimberDataPacket(mStepClimberDataData.getBytes()));
                if (fitnessMachineFeature.isFitnessMachineFeaturesStepCountNotSupported() && StepClimberDataUtils.isFlagsStepPerMinutePresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Step Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesStepCountNotSupported() && StepClimberDataUtils.isFlagsAverageStepRatePresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Step Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElevationGainNotSupported() && StepClimberDataUtils.isFlagsPositiveElevationGainPresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Elevation Gain not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesExpendedEnergyNotSupported() && StepClimberDataUtils.isFlagsExpendedEnergyPresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Expended Energy not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesHeartRateMeasurementNotSupported() && StepClimberDataUtils.isFlagsHeartRatePresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Heart Rate Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesMetabolicEquivalentNotSupported() && StepClimberDataUtils.isFlagsMetabolicEquivalentPresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Metabolic Equivalent not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeNotSupported() && StepClimberDataUtils.isFlagsElapsedTimePresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Elapsed Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeNotSupported() && StepClimberDataUtils.isFlagsRemainingTimePresent(stepClimberData.getFlags())) {
                    throw new RuntimeException("Remaining Time not Supported");
                }
                characteristicList.add(mStepClimberDataData);
            }

            if (mStairClimberDataData != null) {
                StairClimberData stairClimberData = new StairClimberData(new StairClimberDataPacket(mStairClimberDataData.getBytes()));
                if (fitnessMachineFeature.isFitnessMachineFeaturesStepCountNotSupported() && StairClimberDataUtils.isFlagsStepPerMinutePresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Step Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesStepCountNotSupported() && StairClimberDataUtils.isFlagsAverageStepRatePresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Step Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElevationGainNotSupported() && StairClimberDataUtils.isFlagsPositiveElevationGainPresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Elevation Gain not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesStrideCountNotSupported() && StairClimberDataUtils.isFlagsStrideCountPresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Stride Count not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesExpendedEnergyNotSupported() && StairClimberDataUtils.isFlagsExpendedEnergyPresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Expended Energy not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesHeartRateMeasurementNotSupported() && StairClimberDataUtils.isFlagsHeartRatePresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Heart Rate Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesMetabolicEquivalentNotSupported() && StairClimberDataUtils.isFlagsMetabolicEquivalentPresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Metabolic Equivalent not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeNotSupported() && StairClimberDataUtils.isFlagsElapsedTimePresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Elapsed Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeNotSupported() && StairClimberDataUtils.isFlagsRemainingTimePresent(stairClimberData.getFlags())) {
                    throw new RuntimeException("Remaining Time not Supported");
                }
                characteristicList.add(mStairClimberDataData);
            }

            if (mRowerDataData != null) {
                RowerData rowerData = new RowerData(new RowerDataPacket(mRowerDataData.getBytes()));
                if (fitnessMachineFeature.isFitnessMachineFeaturesCadenceNotSupported() && RowerDataUtils.isFlagsAverageStrokePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Cadence not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesTotalDistanceNotSupported() && RowerDataUtils.isFlagsTotalDistancePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Total Distance not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPaceNotSupported() && RowerDataUtils.isFlagsInstantaneousPacePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Pace not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPaceNotSupported() && RowerDataUtils.isFlagsAveragePacePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Pace not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPowerMeasurementNotSupported() && RowerDataUtils.isFlagsInstantaneousPowerPresent(rowerData.getFlags())) {
                    throw new RuntimeException("Power Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPowerMeasurementNotSupported() && RowerDataUtils.isFlagsAveragePowerPresent(rowerData.getFlags())) {
                    throw new RuntimeException("Power Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesResistanceLevelNotSupported() && RowerDataUtils.isFlagsResistanceLevelPresent(rowerData.getFlags())) {
                    throw new RuntimeException("Resistance Level not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesExpendedEnergyNotSupported() && RowerDataUtils.isFlagsExpendedEnergyPresent(rowerData.getFlags())) {
                    throw new RuntimeException("Expended Energy not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesHeartRateMeasurementNotSupported() && RowerDataUtils.isFlagsHeartRatePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Heart Rate Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesMetabolicEquivalentNotSupported() && RowerDataUtils.isFlagsMetabolicEquivalentPresent(rowerData.getFlags())) {
                    throw new RuntimeException("Metabolic Equivalent not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeNotSupported() && RowerDataUtils.isFlagsElapsedTimePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Elapsed Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeNotSupported() && RowerDataUtils.isFlagsRemainingTimePresent(rowerData.getFlags())) {
                    throw new RuntimeException("Remaining Time not Supported");
                }
                characteristicList.add(mRowerDataData);
            }

            if (mIndoorBikeDataData != null) {
                IndoorBikeData indoorBikeData = new IndoorBikeData(new IndoorBikeDataPacket(mIndoorBikeDataData.getBytes()));
                if (fitnessMachineFeature.isFitnessMachineFeaturesAverageSpeedNotSupported() && IndoorBikeDataUtils.isFlagsAverageSpeedPresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Average Speed not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesCadenceNotSupported() && IndoorBikeDataUtils.isFlagsInstantaneousCadencePresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Cadence not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesCadenceNotSupported() && IndoorBikeDataUtils.isFlagsAverageCandencePresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Cadence not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesTotalDistanceNotSupported() && IndoorBikeDataUtils.isFlagsTotalDistancePresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Total Distance not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesResistanceLevelNotSupported() && IndoorBikeDataUtils.isFlagsResistanceLevelPresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Resistance Level not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPowerMeasurementNotSupported() && IndoorBikeDataUtils.isFlagsInstantaneousPowerPresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Power Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesPowerMeasurementNotSupported() && IndoorBikeDataUtils.isFlagsAveragePowerPresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Power Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesExpendedEnergyNotSupported() && IndoorBikeDataUtils.isFlagsExpendedEnergyPresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Expended Energy not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesHeartRateMeasurementNotSupported() && IndoorBikeDataUtils.isFlagsHeartRatePresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Heart Rate Measurement not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesMetabolicEquivalentNotSupported() && IndoorBikeDataUtils.isFlagsMetabolicEquivalentPresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Metabolic Equivalent not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeNotSupported() && IndoorBikeDataUtils.isFlagsElapsedTimePresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Elapsed Time not Supported");
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeNotSupported() && IndoorBikeDataUtils.isFlagsRemainingTimePresent(indoorBikeData.getFlags())) {
                    throw new RuntimeException("Remaining Time not Supported");
                }
                characteristicList.add(mIndoorBikeDataData);
            }

            if (mTrainingStatusData != null) {
                characteristicList.add(mTrainingStatusData);
            }

            if (mSupportedSpeedRangeData == null) {
                if (fitnessMachineFeature.isTargetSettingFeaturesSpeedTargetSettingSupported()) {
                    throw new RuntimeException("no Supported Speed Range data");
                }
            } else {
                characteristicList.add(mSupportedSpeedRangeData);
            }

            if (mSupportedInclinationRangeData == null) {
                if (fitnessMachineFeature.isTargetSettingFeaturesInclinationTargetSettingSupported()) {
                    throw new RuntimeException("no Supported Inclination Range data");
                }
            } else {
                characteristicList.add(mSupportedInclinationRangeData);
            }

            if (mSupportedResistanceLevelRangeData == null) {
                if (fitnessMachineFeature.isTargetSettingFeaturesResistanceTargetSettingSupported()) {
                    throw new RuntimeException("no Supported Resistance Level Range data");
                }
            } else {
                characteristicList.add(mSupportedResistanceLevelRangeData);
            }

            if (mSupportedPowerRangeData == null) {
                if (fitnessMachineFeature.isTargetSettingFeaturesPowerTargetSettingSupported()) {
                    throw new RuntimeException("no Supported Power Range data");
                }
            } else {
                characteristicList.add(mSupportedPowerRangeData);
            }

            if (mSupportedHeartRateRangeData == null) {
                if (fitnessMachineFeature.isTargetSettingFeaturesHeartRateTargetSettingSupported()) {
                    throw new RuntimeException("no Supported Heart Rate Range data");
                }
            } else {
                characteristicList.add(mSupportedHeartRateRangeData);
            }

            if (mFitnessMachineControlPointData != null) {
                characteristicList.add(mFitnessMachineControlPointData);
            }

            if (mFitnessMachineStatusData == null) {
                if (mFitnessMachineControlPointData != null) {
                    throw new RuntimeException("no Fitness Machine Control Point data");
                }
            } else {
                if (FitnessMachineStatus.SPIN_DOWN_STATUS_SPIN_DOWN_REQUESTED != mFitnessMachineStatusData.spinDownStatusValue
                        && FitnessMachineStatus.SPIN_DOWN_STATUS_SUCCESS != mFitnessMachineStatusData.spinDownStatusValue
                        && FitnessMachineStatus.SPIN_DOWN_STATUS_ERROR != mFitnessMachineStatusData.spinDownStatusValue
                        && FitnessMachineStatus.SPIN_DOWN_STATUS_STOP_PEDALING != mFitnessMachineStatusData.spinDownStatusValue) {
                    throw new RuntimeException("Spin Down Status not matched");
                } else {
                    characteristicList.add(mFitnessMachineStatusData);
                }
            }

            ServiceData serviceData = new ServiceData(FITNESS_MACHINE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public FitnessMachineServiceMockCallback build() {
            return new FitnessMachineServiceMockCallback(createMockData(), false);
        }

    }

    protected BluetoothDevice mCurrentControlDevice;

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public FitnessMachineServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStarted() {
        super.onServerStarted();
        mCurrentControlDevice = null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStopped() {
        mCurrentControlDevice = null;
        super.onServerStopped();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void onDeviceDisconnected(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device) {
        super.onDeviceDisconnected(bleServerConnection, device);
        if (device.equals(mCurrentControlDevice)) {
            mCurrentControlDevice = null;
            CharacteristicData fitnessMachineStatusCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, FITNESS_MACHINE_STATUS_CHARACTERISTIC, CharacteristicData.class);
            if (fitnessMachineStatusCharacteristicData != null) {
                fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_CONTROL_PERMISSION_LOST, new byte[0]).getBytes();
                notifyFitnessMachineStatus(bleServerConnection);
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            long now = SystemClock.elapsedRealtime();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap == null) {
                if (force && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            } else {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    delay(now, characteristicData.delay);

                    if (FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                        int responseCode = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED;

                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(FITNESS_MACHINE_CONTROL_POINT_CHARACTERISTIC, characteristicInstanceId));
                        if (characteristicData instanceof FitnessMachineControlPointCharacteristicData && descriptorDataMap != null) {
                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)
                                        && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorDataEntry.getValue().getBytes())) {
                                    responseCode = BluetoothGatt.GATT_SUCCESS;

                                    FitnessMachineControlPointCharacteristicData fitnessMachineControlPointCharacteristicData = (FitnessMachineControlPointCharacteristicData) characteristicData;
                                    fitnessMachineControlPointCharacteristicData.highPriorityResponseData = null;

                                    FitnessMachineControlPoint requestFitnessMachineControlPoint = new FitnessMachineControlPoint(value);

                                    FitnessMachineFeature fitnessMachineFeature = null;
                                    CharacteristicData fitnessMachineFeatureCharacteristicData = findCharacteristicData(characteristicMap, FITNESS_MACHINE_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (fitnessMachineFeatureCharacteristicData != null) {
                                        fitnessMachineFeature = new FitnessMachineFeature(fitnessMachineFeatureCharacteristicData.getBytes());
                                    }

                                    FitnessMachineStatusCharacteristicData fitnessMachineStatusCharacteristicData = findCharacteristicData(characteristicMap, FITNESS_MACHINE_STATUS_CHARACTERISTIC, FitnessMachineStatusCharacteristicData.class);

                                    boolean notifyFitnessMachineStatus = false;
                                    if (requestFitnessMachineControlPoint.isOpCodeRequestControl(requestFitnessMachineControlPoint.getOpCode())) {
                                        if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.requestControlResultCode) {
                                            if (mCurrentControlDevice == null) {
                                                mCurrentControlDevice = device;
                                            } else {
                                                fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_REQUEST_CONTROL, FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, new byte[0]).getBytes();
                                            }
                                        }
                                    } else {
                                        if (device.equals(mCurrentControlDevice)) {
                                            if (requestFitnessMachineControlPoint.isOpCodeReset(requestFitnessMachineControlPoint.getOpCode())
                                                    && FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.resetResultCode) {
                                                reset(fitnessMachineFeature);

                                                if (fitnessMachineStatusCharacteristicData != null) {
                                                    fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_RESET, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                    notifyFitnessMachineStatus = true;
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetSpeed(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetSpeedResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesSpeedTargetSettingNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        SupportedSpeedRange supportedSpeedRange = null;
                                                        CharacteristicData supportedSpeedRangeCharacteristicData = findCharacteristicData(characteristicMap, SUPPORTED_SPEED_RANGE_CHARACTERISTIC, CharacteristicData.class);
                                                        if (supportedSpeedRangeCharacteristicData != null) {
                                                            supportedSpeedRange = new SupportedSpeedRange(supportedSpeedRangeCharacteristicData.getBytes());
                                                        }

                                                        if (supportedSpeedRange == null) {
                                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                        } else {
                                                            int target = requestFitnessMachineControlPoint.getTargetSpeed();
                                                            if (supportedSpeedRange.getMinimumSpeed() <= target && supportedSpeedRange.getMaximumSpeed() >= target) {
                                                                if (fitnessMachineStatusCharacteristicData != null) {
                                                                    fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGET_SPEED_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                                    notifyFitnessMachineStatus = true;
                                                                }
                                                            } else {
                                                                fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_SPEED, FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, new byte[0]).getBytes();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetInclination(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetInclinationResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesInclinationTargetSettinNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        SupportedInclinationRange supportedInclinationRange = null;
                                                        CharacteristicData supportedInclinationRangeCharacteristicData = findCharacteristicData(characteristicMap, SUPPORTED_INCLINATION_RANGE_CHARACTERISTIC, CharacteristicData.class);
                                                        if (supportedInclinationRangeCharacteristicData != null) {
                                                            supportedInclinationRange = new SupportedInclinationRange(supportedInclinationRangeCharacteristicData.getBytes());
                                                        }

                                                        if (supportedInclinationRange == null) {
                                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                        } else {
                                                            int target = requestFitnessMachineControlPoint.getTargetInclination();
                                                            if (supportedInclinationRange.getMinimumInclination() <= target && supportedInclinationRange.getMaximumInclination() >= target) {
                                                                if (fitnessMachineStatusCharacteristicData != null) {
                                                                    fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGET_INCLINE_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                                    notifyFitnessMachineStatus = true;
                                                                }
                                                            } else {
                                                                fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_INCLINATION, FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, new byte[0]).getBytes();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetResistanceLevel(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetResistanceLevelResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesResistanceTargetSettingNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        SupportedResistanceLevelRange supportedResistanceLevelRange = null;
                                                        CharacteristicData supportedResistanceLevelCharacteristicData = findCharacteristicData(characteristicMap, SUPPORTED_RESISTANCE_LEVEL_RANGE_CHARACTERISTIC, CharacteristicData.class);
                                                        if (supportedResistanceLevelCharacteristicData != null) {
                                                            supportedResistanceLevelRange = new SupportedResistanceLevelRange(supportedResistanceLevelCharacteristicData.getBytes());
                                                        }

                                                        if (supportedResistanceLevelRange == null) {
                                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                        } else {
                                                            int target = requestFitnessMachineControlPoint.getTargetResistanceLevel();
                                                            if (supportedResistanceLevelRange.getMinimumResistanceLevel() <= target && supportedResistanceLevelRange.getMaximumResistanceLevel() >= target) {
                                                                if (fitnessMachineStatusCharacteristicData != null) {
                                                                    fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGET_RESISTANCE_LEVEL_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                                    notifyFitnessMachineStatus = true;
                                                                }
                                                            } else {
                                                                fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_RESISTANCE_LEVEL, FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, new byte[0]).getBytes();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetPower(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetPowerResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesPowerTargetSettingNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        SupportedPowerRange supportedPowerRange = null;
                                                        CharacteristicData supportedPowerRangeCharacteristicData = findCharacteristicData(characteristicMap, SUPPORTED_POWER_RANGE_CHARACTERISTIC, CharacteristicData.class);
                                                        if (supportedPowerRangeCharacteristicData != null) {
                                                            supportedPowerRange = new SupportedPowerRange(supportedPowerRangeCharacteristicData.getBytes());
                                                        }

                                                        if (supportedPowerRange == null) {
                                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                        } else {
                                                            int target = requestFitnessMachineControlPoint.getTargetPower();
                                                            if (supportedPowerRange.getMinimumPower() <= target && supportedPowerRange.getMaximumPower() >= target) {
                                                                if (fitnessMachineStatusCharacteristicData != null) {
                                                                    fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGET_POWER_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                                    notifyFitnessMachineStatus = true;
                                                                }
                                                            } else {
                                                                fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_POWER, FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, new byte[0]).getBytes();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetHeartRate(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetHeartRateResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesHeartRateTargetSettingNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        SupportedHeartRateRange supportedHeartRateRange = null;
                                                        CharacteristicData supportedHeartRateRangeCharacteristicData = findCharacteristicData(characteristicMap, SUPPORTED_HEART_RATE_RANGE_CHARACTERISTIC, CharacteristicData.class);
                                                        if (supportedHeartRateRangeCharacteristicData != null) {
                                                            supportedHeartRateRange = new SupportedHeartRateRange(supportedHeartRateRangeCharacteristicData.getBytes());
                                                        }

                                                        if (supportedHeartRateRange == null) {
                                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                        } else {
                                                            int target = requestFitnessMachineControlPoint.getTargetHeartRate();
                                                            if (supportedHeartRateRange.getMinimumHeartRate() <= target && supportedHeartRateRange.getMaximumHeartRate() >= target) {
                                                                if (fitnessMachineStatusCharacteristicData != null) {
                                                                    fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGET_HEART_RATE_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                                    notifyFitnessMachineStatus = true;
                                                                }
                                                            } else {
                                                                fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGET_HEART_RATE, FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, new byte[0]).getBytes();
                                                            }
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeStartOrResume(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.startOrResumeResultCode) {
                                                    reset(fitnessMachineFeature);

                                                    if (fitnessMachineStatusCharacteristicData != null) {
                                                        fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STARTED_OR_RESUMED_BY_THE_USER, new byte[0]).getBytes();
                                                        notifyFitnessMachineStatus = true;
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeStopOrPause(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.stopOrPauseResultCode) {
                                                    reset(fitnessMachineFeature);

                                                    if (fitnessMachineStatusCharacteristicData != null) {
                                                        FitnessMachineStatus fitnessMachineStatus = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER, requestFitnessMachineControlPoint.getParameter());
                                                        if (fitnessMachineStatus.isStopOrPauseStop() || fitnessMachineStatus.isStopOrPausePause()) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_FITNESS_MACHINE_STOPPED_OR_PAUSED_BY_THE_USER, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        } else {
                                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_STOP_OR_PAUSE, FitnessMachineControlPoint.RESULT_CODE_INVALID_PARAMETER, new byte[0]).getBytes();
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedExpendedEnergy(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedExpendedEnergyResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedExpendedEnergyConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_EXPENDED_ENERGY, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_EXPENDED_ENERGY_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedNumberOfSteps(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedNumberOfStepsResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedStepNumberConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STEPS, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_NUMBER_OF_STEPS_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedNumberOfStrides(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedNumberOfStridesResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedStrideNumberConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_NUMBER_OF_STRIDES, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_NUMBER_OF_STRIDES_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedDistance(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedDistanceResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedDistanceConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_DISTANCE, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_DISTANCE_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedTrainingTime(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedTrainingTimeResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedTrainingTimeConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TRAINING_TIME, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_TRAINING_TIME_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedTimeInTwoHeartRateZones(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedTimeInTwoHeartRateZonesResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedTimeInTwoHeartRateZonesConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_TWO_HEART_RATE_ZONES_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedTimeInThreeHeartRateZones(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedTimeInThreeHeartRateZonesResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedTimeInThreeHeartRateZonesConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_THREE_HEART_RATE_ZONES_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedTimeInFiveHeartRateZones(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedTimeInFiveHeartRateZonesResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedTimeInFiveHeartRateZonesConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_TIME_IN_FIVE_HEART_RATE_ZONES_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetIndoorBikeSimulationParameters(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setIndoorBikeSimulationParametersResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesIndoorBikeSimulationParametersNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_INDOOR_BIKE_SIMULATION_PARAMETERES, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_INDOOR_BIKE_SIMULATION_PARAMETERS_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetWheelCircumference(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setWheelCircumferenceResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesWheelCircumferenceConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_WHEEL_CICUMFERENCE, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_WHEEL_CIRCUMFERENCE_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSpinDownControl(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.spinDownControlResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesSpinDownControlNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SPIN_DOWN_CONTROL, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_SPIN_DOWN_STATUS, new byte[]{(byte) fitnessMachineStatusCharacteristicData.spinDownStatusValue}).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            } else if (requestFitnessMachineControlPoint.isOpCodeSetTargetedCadence(requestFitnessMachineControlPoint.getOpCode())) {
                                                if (FitnessMachineControlPoint.RESULT_CODE_SUCCESS == fitnessMachineControlPointCharacteristicData.setTargetedCadenceResultCode) {
                                                    if (fitnessMachineFeature == null || fitnessMachineFeature.isTargetSettingFeaturesTargetedCadenceConfigurationNotSupported()) {
                                                        fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], FitnessMachineControlPoint.OP_CODE_SET_TARGETED_CADENCE, FitnessMachineControlPoint.RESULT_CODE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                                    } else {
                                                        if (fitnessMachineStatusCharacteristicData != null) {
                                                            fitnessMachineStatusCharacteristicData.currentData = new FitnessMachineStatus(FitnessMachineStatus.OP_CODE_TARGETED_CADENCE_CHANGED, requestFitnessMachineControlPoint.getParameter()).getBytes();
                                                            notifyFitnessMachineStatus = true;
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            fitnessMachineControlPointCharacteristicData.highPriorityResponseData = new FitnessMachineControlPoint(FitnessMachineControlPoint.OP_CODE_RESPONSE_CODE, new byte[0], requestFitnessMachineControlPoint.getOpCode(), FitnessMachineControlPoint.RESULT_CODE_CONTROL_NOT_PERMITTED, new byte[0]).getBytes();
                                        }
                                    }
                                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);
                                    if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                                        characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);

                                        BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                        if (bluetoothGattDescriptor != null) {
                                            int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);
                                            startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, characteristicData.delay, 1, null);
                                        }

                                        if (notifyFitnessMachineStatus) {
                                            notifyFitnessMachineStatus(bleServerConnection);
                                        }
                                    }

                                    break;
                                }
                            }
                        } else {
                            result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);
                        }
                    } else {
                        if (responseNeeded) {
                            result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, preparedWrite ? value : null);
                        } else {
                            result = true;
                        }

                        if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                            mIsReliable |= preparedWrite;

                            if (mIsReliable) {
                                characteristicData.temporaryData.put(offset, value);
                            } else {
                                characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);
                            }
                        }
                    }
                }

                if (force && !result && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        }
        return result;
    }

    protected void reset(@Nullable FitnessMachineFeature fitnessMachineFeature) {
        if (fitnessMachineFeature != null) {
            TreadmillData treadmillData = null;
            CharacteristicData treadMillDataCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, TREADMILL_DATA_CHARACTERISTIC, CharacteristicData.class);
            if (treadMillDataCharacteristicData != null) {
                treadmillData = new TreadmillData(new TreadmillDataPacket(treadMillDataCharacteristicData.getBytes()));
            }

            CrossTrainerData crossTrainerData = null;
            CharacteristicData crossTrainerDataCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, CROSS_TRAINER_DATA_CHARACTERISTIC, CharacteristicData.class);
            if (crossTrainerDataCharacteristicData != null) {
                crossTrainerData = new CrossTrainerData(new CrossTrainerDataPacket(crossTrainerDataCharacteristicData.getBytes()));
            }

            StepClimberData stepClimberData = null;
            CharacteristicData stepClimberDataCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, STEP_CLIMBER_DATA_CHARACTERISTIC, CharacteristicData.class);
            if (stepClimberDataCharacteristicData != null) {
                stepClimberData = new StepClimberData(new StepClimberDataPacket(stepClimberDataCharacteristicData.getBytes()));
            }

            StairClimberData stairClimberData = null;
            CharacteristicData stairClimberDataCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, STAIR_CLIMBER_DATA_CHARACTERISTIC, CharacteristicData.class);
            if (stairClimberDataCharacteristicData != null) {
                stairClimberData = new StairClimberData(new StairClimberDataPacket(stairClimberDataCharacteristicData.getBytes()));
            }

            RowerData rowerData = null;
            CharacteristicData rowerDataCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, ROWER_DATA_CHARACTERISTIC, CharacteristicData.class);
            if (rowerDataCharacteristicData != null) {
                rowerData = new RowerData(new RowerDataPacket(rowerDataCharacteristicData.getBytes()));
            }

            IndoorBikeData indoorBikeData = null;
            CharacteristicData indoorBikeDataCharacteristicData = findCharacteristicData(FITNESS_MACHINE_SERVICE, INDOOR_BIKE_DATA_CHARACTERISTIC, CharacteristicData.class);
            if (indoorBikeDataCharacteristicData != null) {
                indoorBikeData = new IndoorBikeData(new IndoorBikeDataPacket(indoorBikeDataCharacteristicData.getBytes()));
            }

            if (treadmillData != null) {
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeSupported()) {
                    treadmillData = new TreadmillData(treadmillData.getFlags()
                            , treadmillData.getInstantaneousSpeed()
                            , treadmillData.getAverageSpeed()
                            , treadmillData.getTotalDistance()
                            , treadmillData.getInclination()
                            , treadmillData.getRampAngleSetting()
                            , treadmillData.getPositiveElevationGain()
                            , treadmillData.getNegativeElevationGain()
                            , treadmillData.getInstantaneousPace()
                            , treadmillData.getAveragePace()
                            , treadmillData.getTotalEnergy()
                            , treadmillData.getEnergyPerHour()
                            , treadmillData.getEnergyPerMinute()
                            , treadmillData.getHeartRate()
                            , treadmillData.getMetabolicEquivalent()
                            , treadmillData.getElapsedTime()
                            , 0
                            , treadmillData.getForceOnBelt()
                            , treadmillData.getPowerOutput());
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeSupported()) {
                    treadmillData = new TreadmillData(treadmillData.getFlags()
                            , treadmillData.getInstantaneousSpeed()
                            , treadmillData.getAverageSpeed()
                            , treadmillData.getTotalDistance()
                            , treadmillData.getInclination()
                            , treadmillData.getRampAngleSetting()
                            , treadmillData.getPositiveElevationGain()
                            , treadmillData.getNegativeElevationGain()
                            , treadmillData.getInstantaneousPace()
                            , treadmillData.getAveragePace()
                            , treadmillData.getTotalEnergy()
                            , treadmillData.getEnergyPerHour()
                            , treadmillData.getEnergyPerMinute()
                            , treadmillData.getHeartRate()
                            , treadmillData.getMetabolicEquivalent()
                            , 0
                            , treadmillData.getRemainingTime()
                            , treadmillData.getForceOnBelt()
                            , treadmillData.getPowerOutput());
                }
                treadMillDataCharacteristicData.currentData = treadmillData.getBytes();
            }

            if (crossTrainerData != null) {
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeSupported()) {
                    crossTrainerData = new CrossTrainerData(crossTrainerData.getFlags()
                            , crossTrainerData.getInstantaneousSpeed()
                            , crossTrainerData.getAverageSpeed()
                            , crossTrainerData.getTotalDistance()
                            , crossTrainerData.getStepPerMinute()
                            , crossTrainerData.getAverageStepRate()
                            , crossTrainerData.getStrideCount()
                            , crossTrainerData.getPositiveElevationGain()
                            , crossTrainerData.getNegativeElevationGain()
                            , crossTrainerData.getInclination()
                            , crossTrainerData.getRampAngleSetting()
                            , crossTrainerData.getResistanceLevel()
                            , crossTrainerData.getInstantaneousPower()
                            , crossTrainerData.getAveragePower()
                            , crossTrainerData.getTotalEnergy()
                            , crossTrainerData.getEnergyPerHour()
                            , crossTrainerData.getEnergyPerMinute()
                            , crossTrainerData.getHeartRate()
                            , crossTrainerData.getMetabolicEquivalent()
                            , crossTrainerData.getElapsedTime()
                            , 0);
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeSupported()) {
                    crossTrainerData = new CrossTrainerData(crossTrainerData.getFlags()
                            , crossTrainerData.getInstantaneousSpeed()
                            , crossTrainerData.getAverageSpeed()
                            , crossTrainerData.getTotalDistance()
                            , crossTrainerData.getStepPerMinute()
                            , crossTrainerData.getAverageStepRate()
                            , crossTrainerData.getStrideCount()
                            , crossTrainerData.getPositiveElevationGain()
                            , crossTrainerData.getNegativeElevationGain()
                            , crossTrainerData.getInclination()
                            , crossTrainerData.getRampAngleSetting()
                            , crossTrainerData.getResistanceLevel()
                            , crossTrainerData.getInstantaneousPower()
                            , crossTrainerData.getAveragePower()
                            , crossTrainerData.getTotalEnergy()
                            , crossTrainerData.getEnergyPerHour()
                            , crossTrainerData.getEnergyPerMinute()
                            , crossTrainerData.getHeartRate()
                            , crossTrainerData.getMetabolicEquivalent()
                            , 0
                            , crossTrainerData.getRemainingTime());
                }
                crossTrainerDataCharacteristicData.currentData = crossTrainerData.getBytes();
            }

            if (stepClimberData != null) {
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeSupported()) {
                    stepClimberData = new StepClimberData(stepClimberData.getFlags()
                            , stepClimberData.getFloors()
                            , stepClimberData.getStepCount()
                            , stepClimberData.getAverageStepRate()
                            , stepClimberData.getAverageStepRate()
                            , stepClimberData.getPositiveElevationGain()
                            , stepClimberData.getTotalEnergy()
                            , stepClimberData.getEnergyPerHour()
                            , stepClimberData.getEnergyPerMinute()
                            , stepClimberData.getHeartRate()
                            , stepClimberData.getMetabolicEquivalent()
                            , stepClimberData.getElapsedTime()
                            , 0);
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeSupported()) {
                    stepClimberData = new StepClimberData(stepClimberData.getFlags()
                            , stepClimberData.getFloors()
                            , stepClimberData.getStepCount()
                            , stepClimberData.getAverageStepRate()
                            , stepClimberData.getAverageStepRate()
                            , stepClimberData.getPositiveElevationGain()
                            , stepClimberData.getTotalEnergy()
                            , stepClimberData.getEnergyPerHour()
                            , stepClimberData.getEnergyPerMinute()
                            , stepClimberData.getHeartRate()
                            , stepClimberData.getMetabolicEquivalent()
                            , 0
                            , stepClimberData.getRemainingTime());
                }
                stepClimberDataCharacteristicData.currentData = stepClimberData.getBytes();
            }

            if (stairClimberData != null) {
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeSupported()) {
                    stairClimberData = new StairClimberData(stairClimberData.getFlags()
                            , stairClimberData.getFloors()
                            , stairClimberData.getStepPerMinute()
                            , stairClimberData.getAverageStepRate()
                            , stairClimberData.getPositiveElevationGain()
                            , stairClimberData.getStrideCount()
                            , stairClimberData.getTotalEnergy()
                            , stairClimberData.getEnergyPerHour()
                            , stairClimberData.getEnergyPerMinute()
                            , stairClimberData.getHeartRate()
                            , stairClimberData.getMetabolicEquivalent()
                            , stairClimberData.getElapsedTime()
                            , 0);
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeSupported()) {
                    stairClimberData = new StairClimberData(stairClimberData.getFlags()
                            , stairClimberData.getFloors()
                            , stairClimberData.getStepPerMinute()
                            , stairClimberData.getAverageStepRate()
                            , stairClimberData.getPositiveElevationGain()
                            , stairClimberData.getStrideCount()
                            , stairClimberData.getTotalEnergy()
                            , stairClimberData.getEnergyPerHour()
                            , stairClimberData.getEnergyPerMinute()
                            , stairClimberData.getHeartRate()
                            , stairClimberData.getMetabolicEquivalent()
                            , 0
                            , stairClimberData.getRemainingTime());
                }
                stairClimberDataCharacteristicData.currentData = stairClimberData.getBytes();
            }

            if (rowerData != null) {
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeSupported()) {
                    rowerData = new RowerData(rowerData.getFlags()
                            , rowerData.getStrokeRate()
                            , rowerData.getStrokeCount()
                            , rowerData.getAverageStrokeRate()
                            , rowerData.getTotalDistance()
                            , rowerData.getInstantaneousPace()
                            , rowerData.getAveragePace()
                            , rowerData.getInstantaneousPower()
                            , rowerData.getAveragePower()
                            , rowerData.getResistanceLevel()
                            , rowerData.getTotalEnergy()
                            , rowerData.getEnergyPerHour()
                            , rowerData.getEnergyPerMinute()
                            , rowerData.getHeartRate()
                            , rowerData.getMetabolicEquivalent()
                            , rowerData.getElapsedTime()
                            , 0);
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeSupported()) {
                    rowerData = new RowerData(rowerData.getFlags()
                            , rowerData.getStrokeRate()
                            , rowerData.getStrokeCount()
                            , rowerData.getAverageStrokeRate()
                            , rowerData.getTotalDistance()
                            , rowerData.getInstantaneousPace()
                            , rowerData.getAveragePace()
                            , rowerData.getInstantaneousPower()
                            , rowerData.getAveragePower()
                            , rowerData.getResistanceLevel()
                            , rowerData.getTotalEnergy()
                            , rowerData.getEnergyPerHour()
                            , rowerData.getEnergyPerMinute()
                            , rowerData.getHeartRate()
                            , rowerData.getMetabolicEquivalent()
                            , 0
                            , rowerData.getRemainingTime());
                }
                rowerDataCharacteristicData.currentData = rowerData.getBytes();
            }

            if (indoorBikeData != null) {
                if (fitnessMachineFeature.isFitnessMachineFeaturesRemainingTimeSupported()) {
                    indoorBikeData = new IndoorBikeData(indoorBikeData.getFlags()
                            , indoorBikeData.getInstantaneousSpeed()
                            , indoorBikeData.getAverageSpeed()
                            , indoorBikeData.getInstantaneousCadence()
                            , indoorBikeData.getAverageCadence()
                            , indoorBikeData.getTotalDistance()
                            , indoorBikeData.getResistanceLevel()
                            , indoorBikeData.getInstantaneousPower()
                            , indoorBikeData.getAveragePower()
                            , indoorBikeData.getTotalEnergy()
                            , indoorBikeData.getEnergyPerHour()
                            , indoorBikeData.getEnergyPerMinute()
                            , indoorBikeData.getHeartRate()
                            , indoorBikeData.getMetabolicEquivalent()
                            , indoorBikeData.getElapsedTime()
                            , 0);
                }
                if (fitnessMachineFeature.isFitnessMachineFeaturesElapsedTimeSupported()) {
                    indoorBikeData = new IndoorBikeData(indoorBikeData.getFlags()
                            , indoorBikeData.getInstantaneousSpeed()
                            , indoorBikeData.getAverageSpeed()
                            , indoorBikeData.getInstantaneousCadence()
                            , indoorBikeData.getAverageCadence()
                            , indoorBikeData.getTotalDistance()
                            , indoorBikeData.getResistanceLevel()
                            , indoorBikeData.getInstantaneousPower()
                            , indoorBikeData.getAveragePower()
                            , indoorBikeData.getTotalEnergy()
                            , indoorBikeData.getEnergyPerHour()
                            , indoorBikeData.getEnergyPerMinute()
                            , indoorBikeData.getHeartRate()
                            , indoorBikeData.getMetabolicEquivalent()
                            , 0
                            , indoorBikeData.getRemainingTime());
                }
                indoorBikeDataCharacteristicData.currentData = indoorBikeData.getBytes();
            }
        }
    }

    /**
     * notify Fitness Machine Status
     *
     * @param bleServerConnection bleServerConnection {@link BLEServerConnection} instance
     */
    protected void notifyFitnessMachineStatus(@NonNull BLEServerConnection bleServerConnection) {
        for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, CharacteristicData>> serviceEntry : mRemappedServiceCharacteristicMap.entrySet()) {
            if (FITNESS_MACHINE_SERVICE.equals(serviceEntry.getKey().first)) {
                for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicEntry : serviceEntry.getValue().entrySet()) {
                    if (FITNESS_MACHINE_STATUS_CHARACTERISTIC.equals(characteristicEntry.getKey().first)) {
                        Map<Pair<UUID, Integer>, DescriptorData> descriptorMap = mRemappedCharacteristicDescriptorMap.get(characteristicEntry.getKey());
                        if (descriptorMap != null) {
                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorEntry : descriptorMap.entrySet()) {
                                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorEntry.getKey().first)) {
                                    for (BluetoothDevice connectedBluetoothDevice : mConnectedDeviceSet) {
                                        if (!connectedBluetoothDevice.equals(mCurrentControlDevice)) {
                                            startNotification(null
                                                    , bleServerConnection
                                                    , connectedBluetoothDevice
                                                    , FITNESS_MACHINE_SERVICE
                                                    , serviceEntry.getKey().second
                                                    , FITNESS_MACHINE_STATUS_CHARACTERISTIC
                                                    , characteristicEntry.getKey().second
                                                    , descriptorEntry.getKey().second
                                                    , characteristicEntry.getValue().delay
                                                    , 1
                                                    , null);
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
                }
                break;
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {
        // do nothing
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {
        // do nothing
    }

}
