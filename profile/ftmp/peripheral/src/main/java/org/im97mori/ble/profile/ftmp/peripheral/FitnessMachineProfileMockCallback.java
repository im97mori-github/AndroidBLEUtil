package org.im97mori.ble.profile.ftmp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a80.Age;
import org.im97mori.ble.characteristic.u2a85.DateOfBirth;
import org.im97mori.ble.characteristic.u2a8a.FirstName;
import org.im97mori.ble.characteristic.u2a8b.FiveZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a8c.Gender;
import org.im97mori.ble.characteristic.u2a8d.HeartRateMax;
import org.im97mori.ble.characteristic.u2a8e.Height;
import org.im97mori.ble.characteristic.u2a91.MaximumRecommendedHeartRate;
import org.im97mori.ble.characteristic.u2a92.RestingHeartRate;
import org.im97mori.ble.characteristic.u2a94.ThreeZoneHeartRateLimits;
import org.im97mori.ble.characteristic.u2a95.TwoZoneHeartRateLimit;
import org.im97mori.ble.characteristic.u2a96.VO2Max;
import org.im97mori.ble.characteristic.u2a98.Weight;
import org.im97mori.ble.characteristic.u2a9f.UserControlPoint;
import org.im97mori.ble.characteristic.u2aa2.Language;
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
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback;
import org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import static org.im97mori.ble.constants.ServiceUUID.FITNESS_MACHINE_SERVICE;

/**
 * Fitness Machine Profile for Peripheral
 */
public class FitnessMachineProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link FitnessMachineProfileMockCallback}
     *
     * @param <T> subclass of {@link FitnessMachineProfileMockCallback}
     */
    public static class Builder<T extends FitnessMachineProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder} instance
         */
        protected final FitnessMachineServiceMockCallback.Builder<? extends FitnessMachineServiceMockCallback> mFitnessMachineServiceMockCallbackBuilder;

        /**
         * {@link FtmpUserDataServiceMockCallback.Builder} instance
         */
        protected final FtmpUserDataServiceMockCallback.Builder<? extends FtmpUserDataServiceMockCallback> mFtmpUserDataServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * @param context                                     {@link Context} instance
         * @param fitnessMachineServiceMockCallbackBuilder    {@link org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder} instance
         * @param ftmpUserDataServiceMockCallbackBuilder      {@link FtmpUserDataServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull FitnessMachineServiceMockCallback.Builder<? extends FitnessMachineServiceMockCallback> fitnessMachineServiceMockCallbackBuilder
                , @Nullable FtmpUserDataServiceMockCallback.Builder<? extends FtmpUserDataServiceMockCallback> ftmpUserDataServiceMockCallbackBuilder
                , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
            mContext = context;
            mFitnessMachineServiceMockCallbackBuilder = fitnessMachineServiceMockCallbackBuilder;
            mFtmpUserDataServiceMockCallbackBuilder = ftmpUserDataServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
        }

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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addFitnessMachineFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFitnessMachineFeature(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineServiceMockCallbackBuilder.addFitnessMachineFeature(responseCode, delay, value);
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.setFitnessMachineFeature(value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeFitnessMachineFeature()
         */
        @NonNull
        public Builder<T> removeFitnessMachineFeature() {
            mFitnessMachineServiceMockCallbackBuilder.removeFitnessMachineFeature();
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.setFitnessMachineFeature(null);
            }
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addTreadmillData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTreadmillData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addTreadmillData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeTreadmillData()
         */
        @NonNull
        public Builder<T> removeTreadmillData() {
            mFitnessMachineServiceMockCallbackBuilder.removeTreadmillData();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addCrossTrainerData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCrossTrainerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addCrossTrainerData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeCrossTrainerData()
         */
        @NonNull
        public Builder<T> removeCrossTrainerData() {
            mFitnessMachineServiceMockCallbackBuilder.removeCrossTrainerData();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addStepClimberData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addStepClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addStepClimberData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeStepClimberData()
         */
        @NonNull
        public Builder<T> removeStepClimberData() {
            mFitnessMachineServiceMockCallbackBuilder.removeStepClimberData();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addStairClimberData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addStairClimberData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addStairClimberData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeStairClimberData()
         */
        @NonNull
        public Builder<T> removeStairClimberData() {
            mFitnessMachineServiceMockCallbackBuilder.removeStairClimberData();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addRowerData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRowerData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addRowerData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeRowerData()
         */
        @NonNull
        public Builder<T> removeRowerData() {
            mFitnessMachineServiceMockCallbackBuilder.removeRowerData();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addIndoorBikeData(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIndoorBikeData(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addIndoorBikeData(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeIndoorBikeData()
         */
        @NonNull
        public Builder<T> removeIndoorBikeData() {
            mFitnessMachineServiceMockCallbackBuilder.removeIndoorBikeData();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addTrainingStatus(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTrainingStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addTrainingStatus(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeTrainingStatus()
         */
        @NonNull
        public Builder<T> removeTrainingStatus() {
            mFitnessMachineServiceMockCallbackBuilder.removeTrainingStatus();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addSupportedSpeedRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedSpeedRange(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineServiceMockCallbackBuilder.addSupportedSpeedRange(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeSupportedSpeedRange()
         */
        @NonNull
        public Builder<T> removeSupportedSpeedRange() {
            mFitnessMachineServiceMockCallbackBuilder.removeSupportedSpeedRange();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addSupportedInclinationRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedInclinationRange(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineServiceMockCallbackBuilder.addSupportedInclinationRange(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeSupportedInclinationRange()
         */
        @NonNull
        public Builder<T> removeSupportedInclinationRange() {
            mFitnessMachineServiceMockCallbackBuilder.removeSupportedInclinationRange();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addSupportedResistanceLevelRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedResistanceLevelRange(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineServiceMockCallbackBuilder.addSupportedResistanceLevelRange(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeSupportedResistanceLevelRange()
         */
        @NonNull
        public Builder<T> removeSupportedResistanceLevelRange() {
            mFitnessMachineServiceMockCallbackBuilder.removeSupportedResistanceLevelRange();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addSupportedPowerRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedPowerRange(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineServiceMockCallbackBuilder.addSupportedPowerRange(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeSupportedPowerRange()
         */
        @NonNull
        public Builder<T> removeSupportedPowerRange() {
            mFitnessMachineServiceMockCallbackBuilder.removeSupportedPowerRange();
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
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addSupportedHeartRateRange(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSupportedHeartRateRange(int responseCode, long delay, @NonNull byte[] value) {
            mFitnessMachineServiceMockCallbackBuilder.addSupportedHeartRateRange(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeSupportedHeartRateRange()
         */
        @NonNull
        public Builder<T> removeSupportedHeartRateRange() {
            mFitnessMachineServiceMockCallbackBuilder.removeSupportedHeartRateRange();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addFitnessMachineControlPoint(long, int, long, byte[], int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, int, byte[], int)
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
            mFitnessMachineServiceMockCallbackBuilder.addFitnessMachineControlPoint(characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, requestControlResultCode, resetResultCode, setTargetSpeedResultCode, setTargetInclinationResultCode, setTargetResistanceLevelResultCode, setTargetPowerResultCode, setTargetHeartRateResultCode, startOrResumeResultCode, stopOrPauseResultCode, setTargetedExpendedEnergyResultCode, setTargetedNumberOfStepsResultCode, setTargetedNumberOfStridesResultCode, setTargetedDistanceResultCode, setTargetedTrainingTimeResultCode, setTargetedTimeInTwoHeartRateZonesResultCode, setTargetedTimeInThreeHeartRateZonesResultCode, setTargetedTimeInFiveHeartRateZonesResultCode, setIndoorBikeSimulationParametersResultCode, setWheelCircumferenceResultCode, spinDownControlResultCode, spinDownControlResultParameter, setTargetedCadenceResultCode);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeFitnessMachineControlPoint()
         */
        @NonNull
        public Builder<T> removeFitnessMachineControlPoint() {
            mFitnessMachineServiceMockCallbackBuilder.removeFitnessMachineControlPoint();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#addFitnessMachineStatus(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addFitnessMachineStatus(int spinDownStatusValue
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mFitnessMachineServiceMockCallbackBuilder.addFitnessMachineStatus(spinDownStatusValue, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.ftms.peripheral.FitnessMachineServiceMockCallback.Builder#removeFitnessMachineStatus()
         */
        @NonNull
        public Builder<T> removeFitnessMachineStatus() {
            mFitnessMachineServiceMockCallbackBuilder.removeFitnessMachineStatus();
            return this;
        }

        /**
         * @see #addFirstName(FirstName)
         */
        @NonNull
        public Builder<T> addFirstName(@NonNull String firstName) {
            return addFirstName(new FirstName(firstName));
        }

        /**
         * @see #addFirstName(byte[])
         */
        @NonNull
        public Builder<T> addFirstName(@NonNull FirstName firstName) {
            return addFirstName(firstName.getBytes());
        }

        /**
         * @see #addFirstName(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFirstName(@NonNull byte[] value) {
            return addFirstName(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addFirstName(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFirstName(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addFirstName(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeFirstName()
         */
        @NonNull
        public Builder<T> removeFirstName() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeFirstName();
            }
            return this;
        }

        /**
         * @see #addWeight(Weight)
         */
        @NonNull
        public Builder<T> addWeight(int weight) {
            return addWeight(new Weight(weight));
        }

        /**
         * @see #addWeight(byte[])
         */
        @NonNull
        public Builder<T> addWeight(@NonNull Weight weight) {
            return addWeight(weight.getBytes());
        }

        /**
         * @see #addWeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeight(@NonNull byte[] value) {
            return addWeight(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addWeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addWeight(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addWeight(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeWeight()
         */
        @NonNull
        public Builder<T> removeWeight() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeWeight();
            }
            return this;
        }

        /**
         * @see #addGender(Gender)
         */
        @NonNull
        public Builder<T> addGender(int gender) {
            return addGender(new Gender(gender));
        }

        /**
         * @see #addGender(byte[])
         */
        @NonNull
        public Builder<T> addGender(@NonNull Gender gender) {
            return addGender(gender.getBytes());
        }

        /**
         * @see #addGender(int, long, byte[])
         */
        @NonNull
        public Builder<T> addGender(@NonNull byte[] value) {
            return addGender(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addGender(int, long, byte[])
         */
        @NonNull
        public Builder<T> addGender(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addGender(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeGender()
         */
        @NonNull
        public Builder<T> removeGender() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeGender();
            }
            return this;
        }

        /**
         * @see #addHeight(Height)
         */
        @NonNull
        public Builder<T> addHeight(int height) {
            return addHeight(new Height(height));
        }

        /**
         * @see #addHeight(byte[])
         */
        @NonNull
        public Builder<T> addHeight(@NonNull Height height) {
            return addHeight(height.getBytes());
        }

        /**
         * @see #addHeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeight(@NonNull byte[] value) {
            return addHeight(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addHeight(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeight(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addHeight(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeHeight()
         */
        @NonNull
        public Builder<T> removeHeight() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeHeight();
            }
            return this;
        }

        /**
         * @see #addAge(Age)
         */
        @NonNull
        public Builder<T> addAge(int age) {
            return addAge(new Age(age));
        }

        /**
         * @see #addAge(byte[])
         */
        @NonNull
        public Builder<T> addAge(@NonNull Age age) {
            return addAge(age.getBytes());
        }

        /**
         * @see #addAge(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAge(@NonNull byte[] value) {
            return addAge(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addAge(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAge(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addAge(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeAge()
         */
        @NonNull
        public Builder<T> removeAge() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeAge();
            }
            return this;
        }

        /**
         * @see #addDateOfBirth(DateOfBirth)
         */
        @NonNull
        public Builder<T> addDateOfBirth(int year, int month, int day) {
            return addDateOfBirth(new DateOfBirth(year, month, day));
        }

        /**
         * @see #addDateOfBirth(byte[])
         */
        @NonNull
        public Builder<T> addDateOfBirth(@NonNull DateOfBirth dateOfBirth) {
            return addDateOfBirth(dateOfBirth.getBytes());
        }

        /**
         * @see #addDateOfBirth(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDateOfBirth(@NonNull byte[] value) {
            return addDateOfBirth(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addDateOfBirth(int, long, byte[])
         */
        @NonNull
        public Builder<T> addDateOfBirth(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addDateOfBirth(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeDateOfBirth()
         */
        @NonNull
        public Builder<T> removeDateOfBirth() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeDateOfBirth();
            }
            return this;
        }

        /**
         * @see #addHeartRateMax(HeartRateMax)
         */
        @NonNull
        public Builder<T> addHeartRateMax(int heartRateMax) {
            return addHeartRateMax(new HeartRateMax(heartRateMax));
        }

        /**
         * @see #addHeartRateMax(byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMax(@NonNull HeartRateMax heartRateMax) {
            return addHeartRateMax(heartRateMax.getBytes());
        }

        /**
         * @see #addHeartRateMax(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMax(@NonNull byte[] value) {
            return addHeartRateMax(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addHeartRateMax(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMax(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addHeartRateMax(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeHeartRateMax()
         */
        @NonNull
        public Builder<T> removeHeartRateMax() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeHeartRateMax();
            }
            return this;
        }

        /**
         * @see #addRestingHeartRate(RestingHeartRate)
         */
        @NonNull
        public Builder<T> addRestingHeartRate(int restingHeartRate) {
            return addRestingHeartRate(new RestingHeartRate(restingHeartRate));
        }

        /**
         * @see #addRestingHeartRate(byte[])
         */
        @NonNull
        public Builder<T> addRestingHeartRate(@NonNull RestingHeartRate restingHeartRate) {
            return addRestingHeartRate(restingHeartRate.getBytes());
        }

        /**
         * @see #addRestingHeartRate(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRestingHeartRate(@NonNull byte[] value) {
            return addRestingHeartRate(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addRestingHeartRate(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRestingHeartRate(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addRestingHeartRate(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeRestingHeartRate()
         */
        @NonNull
        public Builder<T> removeRestingHeartRate() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeRestingHeartRate();
            }
            return this;
        }

        /**
         * @see #addMaximumRecommendedHeartRate(MaximumRecommendedHeartRate)
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(int maximumRecommendedHeartRate) {
            return addMaximumRecommendedHeartRate(new MaximumRecommendedHeartRate(maximumRecommendedHeartRate));
        }

        /**
         * @see #addMaximumRecommendedHeartRate(byte[])
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(@NonNull MaximumRecommendedHeartRate maximumRecommendedHeartRate) {
            return addMaximumRecommendedHeartRate(maximumRecommendedHeartRate.getBytes());
        }

        /**
         * @see #addMaximumRecommendedHeartRate(int, long, byte[])
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(@NonNull byte[] value) {
            return addMaximumRecommendedHeartRate(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addMaximumRecommendedHeartRate(int, long, byte[])
         */
        @NonNull
        public Builder<T> addMaximumRecommendedHeartRate(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addMaximumRecommendedHeartRate(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeMaximumRecommendedHeartRate()
         */
        @NonNull
        public Builder<T> removeMaximumRecommendedHeartRate() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeMaximumRecommendedHeartRate();
            }
            return this;
        }

        /**
         * @see #addVO2Max(VO2Max)
         */
        @NonNull
        public Builder<T> addVO2Max(int vo2Max) {
            return addVO2Max(new VO2Max(vo2Max));
        }

        /**
         * @see #addVO2Max(byte[])
         */
        @NonNull
        public Builder<T> addVO2Max(@NonNull VO2Max vo2Max) {
            return addVO2Max(vo2Max.getBytes());
        }

        /**
         * @see #addVO2Max(int, long, byte[])
         */
        @NonNull
        public Builder<T> addVO2Max(@NonNull byte[] value) {
            return addVO2Max(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addVO2Max(int, long, byte[])
         */
        @NonNull
        public Builder<T> addVO2Max(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addVO2Max(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeVO2Max()
         */
        @NonNull
        public Builder<T> removeVO2Max() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeVO2Max();
            }
            return this;
        }

        /**
         * @see #addLanguage(Language)
         */
        @NonNull
        public Builder<T> addLanguage(@NonNull String language) {
            return addLanguage(new Language(language));
        }

        /**
         * @see #addLanguage(byte[])
         */
        @NonNull
        public Builder<T> addLanguage(@NonNull Language language) {
            return addLanguage(language.getBytes());
        }

        /**
         * @see #addLanguage(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLanguage(@NonNull byte[] value) {
            return addLanguage(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addLanguage(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLanguage(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addLanguage(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeLanguage()
         */
        @NonNull
        public Builder<T> removeLanguage() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeLanguage();
            }
            return this;
        }

        /**
         * @see #addTwoZoneHeartRateLimit(TwoZoneHeartRateLimit)
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(int twoZoneHeartRateLimitFatBurnFitnessLimit) {
            return addTwoZoneHeartRateLimit(new TwoZoneHeartRateLimit(twoZoneHeartRateLimitFatBurnFitnessLimit));
        }

        /**
         * @see #addTwoZoneHeartRateLimit(byte[])
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(@NonNull TwoZoneHeartRateLimit twoZoneHeartRateLimit) {
            return addTwoZoneHeartRateLimit(twoZoneHeartRateLimit.getBytes());
        }

        /**
         * @see #addTwoZoneHeartRateLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(@NonNull byte[] value) {
            return addTwoZoneHeartRateLimit(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addTwoZoneHeartRateLimit(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTwoZoneHeartRateLimit(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addTwoZoneHeartRateLimit(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeTwoZoneHeartRateLimit()
         */
        @NonNull
        public Builder<T> removeTwoZoneHeartRateLimit() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeTwoZoneHeartRateLimit();
            }
            return this;
        }

        /**
         * @see #addThreeZoneHeartRateLimits(ThreeZoneHeartRateLimits)
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(int threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, int threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit) {
            return addThreeZoneHeartRateLimits(new ThreeZoneHeartRateLimits(threeZoneHeartRateLimitsLightFatBurnModerateAerobicLimit, threeZoneHeartRateLimitsModerateAerobicHardAnaerobicLimit));
        }

        /**
         * @see #addThreeZoneHeartRateLimits(byte[])
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(@NonNull ThreeZoneHeartRateLimits threeZoneHeartRateLimits) {
            return addThreeZoneHeartRateLimits(threeZoneHeartRateLimits.getBytes());
        }

        /**
         * @see #addThreeZoneHeartRateLimits(int, long, byte[])
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(@NonNull byte[] value) {
            return addThreeZoneHeartRateLimits(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addThreeZoneHeartRateLimits(int, long, byte[])
         */
        @NonNull
        public Builder<T> addThreeZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addThreeZoneHeartRateLimits(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeThreeZoneHeartRateLimits()
         */
        @NonNull
        public Builder<T> removeThreeZoneHeartRateLimits() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeThreeZoneHeartRateLimits();
            }
            return this;
        }

        /**
         * @see #addFiveZoneHeartRateLimits(FiveZoneHeartRateLimits)
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(int fiveZoneHeartRateLimitsVeryLightLightLimit
                , int fiveZoneHeartRateLimitsLightModerateLimit
                , int fiveZoneHeartRateLimitsModerateHardLimit
                , int fiveZoneHeartRateLimitsHardMaximumLimit) {
            return addFiveZoneHeartRateLimits(new FiveZoneHeartRateLimits(fiveZoneHeartRateLimitsVeryLightLightLimit
                    , fiveZoneHeartRateLimitsLightModerateLimit
                    , fiveZoneHeartRateLimitsModerateHardLimit
                    , fiveZoneHeartRateLimitsHardMaximumLimit));
        }

        /**
         * @see #addFiveZoneHeartRateLimits(byte[])
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(@NonNull FiveZoneHeartRateLimits fiveZoneHeartRateLimits) {
            return addFiveZoneHeartRateLimits(fiveZoneHeartRateLimits.getBytes());
        }

        /**
         * @see #addFiveZoneHeartRateLimits(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(@NonNull byte[] value) {
            return addFiveZoneHeartRateLimits(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addFiveZoneHeartRateLimits(int, long, byte[])
         */
        @NonNull
        public Builder<T> addFiveZoneHeartRateLimits(int responseCode, long delay, @NonNull byte[] value) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addFiveZoneHeartRateLimits(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeFiveZoneHeartRateLimits()
         */
        @NonNull
        public Builder<T> removeFiveZoneHeartRateLimits() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeFiveZoneHeartRateLimits();
            }
            return this;
        }

        /**
         * @see #addDatabaseChangeIncrement(int, long, boolean, int, long, byte[])
         */
        @NonNull
        public Builder<T> addDatabaseChangeIncrement(@NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addDatabaseChangeIncrement(BluetoothGatt.GATT_SUCCESS, 0, true, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addDatabaseChangeIncrement(ClientCharacteristicConfiguration)
         */
        @NonNull
        public Builder<T> addDatabaseChangeIncrement(int characteristicResponseCode, long characteristicDelay, boolean isNotificatable, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addDatabaseChangeIncrement(characteristicResponseCode, characteristicDelay, isNotificatable, descriptorResponseCode, descriptorDelay, descriptorValue);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeDatabaseChangeIncrement()
         */
        @NonNull
        public Builder<T> removeDatabaseChangeIncrement() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeDatabaseChangeIncrement();
            }
            return this;
        }

        /**
         * @see #addUserIndex()
         */
        @NonNull
        public Builder<T> addUserIndex() {
            return addUserIndex(BluetoothGatt.GATT_SUCCESS, 0);
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addUserIndex(int, long)
         */
        @NonNull
        public Builder<T> addUserIndex(int responseCode, long delay) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addUserIndex(responseCode, delay);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeUserIndex()
         */
        @NonNull
        public Builder<T> removeUserIndex() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeUserIndex();
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#addUserControlPoint(long, int, int, int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addUserControlPoint(long characteristicDelay
                , int registerNewUserResponseValue
                , int consentResponseValue
                , int deleteUserDataResponseValue
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.addUserControlPoint(characteristicDelay
                        , registerNewUserResponseValue
                        , consentResponseValue
                        , deleteUserDataResponseValue
                        , UserControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                        , UserControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED
                        , descriptorResponseCode
                        , descriptorDelay
                        , descriptorValue);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.uds.peripheral.UserDataServiceMockCallback.Builder#removeUserControlPoint()
         */
        @NonNull
        public Builder<T> removeUserControlPoint() {
            if (mFtmpUserDataServiceMockCallbackBuilder != null) {
                mFtmpUserDataServiceMockCallbackBuilder.removeUserControlPoint();
            }
            return this;
        }


        /**
         * @see #addManufacturerNameString(ManufacturerNameString)
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull String manufacturerName) {
            return addManufacturerNameString(new ManufacturerNameString(manufacturerName));
        }

        /**
         * @see #addManufacturerNameString(byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull ManufacturerNameString manufacturerNameString) {
            return addManufacturerNameString(manufacturerNameString.getBytes());
        }

        /**
         * @see #addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull byte[] value) {
            return addManufacturerNameString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(int responseCode, long delay, @NonNull byte[] value) {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responseCode, delay, value);
            }
            return this;
        }

        /**
         * remove Manufacturer Name String characteristic
         *
         * @return {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mDeviceInformationServiceMockCallbackBuilder.removeManufacturerNameString();
            }
            return this;
        }

        /**
         * @see #addModelNumberString(ModelNumberString)
         */
        @NonNull
        public Builder<T> addModelNumberString(@NonNull String modelNumber) {
            return addModelNumberString(new ModelNumberString(modelNumber));
        }

        /**
         * @see #addModelNumberString(byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(ModelNumberString modelNumberString) {
            return addModelNumberString(modelNumberString.getBytes());
        }

        /**
         * @see #addModelNumberString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(@NonNull byte[] value) {
            return addModelNumberString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addModelNumberString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addModelNumberString(int responseCode, long delay, @NonNull byte[] value) {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mDeviceInformationServiceMockCallbackBuilder.addModelNumberString(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeModelNumberString()
         */
        @NonNull
        public Builder<T> removeModelNumberString() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mDeviceInformationServiceMockCallbackBuilder.removeModelNumberString();
            }
            return this;
        }

        /**
         * @return {@link FitnessMachineProfileMockCallback} instance
         */
        public FitnessMachineProfileMockCallback build() {
            return new FitnessMachineProfileMockCallback(mContext
                    , mFitnessMachineServiceMockCallbackBuilder.build()
                    , mFtmpUserDataServiceMockCallbackBuilder == null ? null : mFtmpUserDataServiceMockCallbackBuilder.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param fitnessMachineServiceMockCallback    {@link FitnessMachineServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback {@link DeviceInformationServiceMockCallback} instance
     * @param userDataServiceMockCallback          {@link UserDataServiceMockCallback} instance
     * @param bleServerCallbacks                   callback array
     */
    public FitnessMachineProfileMockCallback(@NonNull Context context
            , @NonNull FitnessMachineServiceMockCallback fitnessMachineServiceMockCallback
            , @Nullable UserDataServiceMockCallback userDataServiceMockCallback
            , @Nullable DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(fitnessMachineServiceMockCallback, userDataServiceMockCallback, deviceInformationServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return FITNESS_MACHINE_SERVICE;
    }

}
