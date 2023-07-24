package org.im97mori.ble.service.cps.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.CYCLING_POWER_VECTOR_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ServiceUUID.CYCLING_POWER_SERVICE;

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
import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.NotificationData;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.characteristic.u2a63.CyclingPowerMeasurement;
import org.im97mori.ble.characteristic.u2a64.CyclingPowerVector;
import org.im97mori.ble.characteristic.u2a65.CyclingPowerFeature;
import org.im97mori.ble.characteristic.u2a66.CyclingPowerControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;
import org.im97mori.ble.task.NotifyTask;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Cycling Power Service (Service UUID: 0x1818) for Peripheral
 * (Cycling Power Measurement Broadcast Feature is not supported)
 */
public class CyclingPowerServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link CyclingPowerServiceMockCallback}
     *
     * @param <T> subclass of {@link CyclingPowerServiceMockCallback}
     */
    public static class Builder<T extends CyclingPowerServiceMockCallback> extends AbstractServiceMockCallback.Builder<CyclingPowerServiceMockCallback, ServiceData> {

        /**
         * Cycling Power Feature data
         */
        protected CharacteristicData mCyclingPowerFeatureData;

        /**
         * Cycling Power Measurement data
         */
        protected CharacteristicData mCyclingPowerMeasurementData;

        /**
         * Sensor Location data
         */
        protected CharacteristicData mSensorLocationData;

        /**
         * Cycling Power Control Point data
         */
        protected CyclingPowerControlPointCharacteristicData mCyclingPowerControlPoint;

        /**
         * Cycling Power Vector data
         */
        protected CharacteristicData mCyclingPowerVectorData;

        /**
         * @see #addCyclingPowerFeature(byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerFeature(@NonNull CyclingPowerFeature cyclingPowerFeature) {
            return addCyclingPowerFeature(cyclingPowerFeature.getBytes());
        }

        /**
         * @see #addCyclingPowerFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerFeature(@NonNull byte[] value) {
            return addCyclingPowerFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Cycling Power Feature characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCyclingPowerFeature(int responseCode, long delay, @NonNull byte[] value) {
            mCyclingPowerFeatureData = new CharacteristicData(CYCLING_POWER_FEATURE_CHARACTERISTIC
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
         * remove Cycling Power Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCyclingPowerFeature() {
            mCyclingPowerFeatureData = null;
            return this;
        }

        /**
         * @see #addCyclingPowerMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerMeasurement(@NonNull CyclingPowerMeasurement cyclingPowerMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCyclingPowerMeasurement(BluetoothGatt.GATT_SUCCESS, 0, cyclingPowerMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Cycling Power Measurement characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCyclingPowerMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCyclingPowerMeasurementData = new CharacteristicData(CYCLING_POWER_MEASUREMENT_CHARACTERISTIC
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
         * remove Cycling Power Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCyclingPowerMeasurement() {
            mCyclingPowerMeasurementData = null;
            return this;
        }

        /**
         * @see #addSensorLocation(byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(@NonNull SensorLocation sensorLocation) {
            return addSensorLocation(sensorLocation.getBytes());
        }

        /**
         * @see #addSensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(@NonNull byte[] value) {
            return addSensorLocation(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Sensor Location characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
            mSensorLocationData = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
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
         * remove Sensor Location characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSensorLocation() {
            mSensorLocationData = null;
            return this;
        }

        /**
         * add Cycling Power Control Point characteristic
         *
         * @param characteristicResponseCode                                    characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay                                           characteristic response delay(millis)
         * @param descriptorResponseCode                                        descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                                               descriptor response delay(millis)
         * @param descriptorValue                                               descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param setCumulativeValueResponseValue                               characteristic response code (Set Cumulative Value response)
         * @param updateSensorLocationResponseValue                             characteristic response code (Update Sensor Location response)
         * @param requestSupportedSensorLocationsResponseValue                  characteristic response code (Request Supported Sensor Locations response)
         * @param requestSupportedSensorLocationsResponseParameter              part of characteristic data array (Request Supported Sensor Locations response)
         * @param setCrankLengthResponseValue                                   characteristic response code (Set Crank Length response)
         * @param requestCrankLengthResponseValue                               characteristic response code (Request Crank Length response)
         * @param requestCrankLengthResponseParameter                           characteristic response parameter (Request Crank Length response)
         * @param setChainLengthResponseValue                                   characteristic response code (Set Chain Length response)
         * @param requestChainLengthResponseValue                               characteristic response code (Request Chain Length response)
         * @param requestChainLengthResponseParameter                           characteristic response parameter (Request Chain Length response)
         * @param setChainWeightResponseValue                                   characteristic response code (Set Chain Weight response)
         * @param requestChainWeightResponseValue                               characteristic response code (Request Chain Weight response)
         * @param requestChainWeightResponseParameter                           characteristic response parameter (Request Chain Weight response)
         * @param setSpanLengthResponseValue                                    characteristic response code (Set Span Length response)
         * @param requestSpanLengthResponseValue                                characteristic response code (Request Span Length response)
         * @param requestSpanLengthResponseParameter                            characteristic response parameter (Request Span Length response)
         * @param startOffsetCompensationResponseValue                          characteristic response code (Start Offset Compensation response)
         * @param startOffsetCompensationResponseParameter                      characteristic response parameter (Start Offset Compensation response)
         * @param maskCyclingPowerMeasurementCharacteristicContentResponseValue characteristic response code (Mask Cycling Power Measurement Characteristic Content response)
         * @param requestSamplingRateResponseValue                              characteristic response code (Request Sampling Rate response)
         * @param requestSamplingRateResponseParameter                          characteristic response parameter (Request Sampling Rate response)
         * @param requestFactoryCalibrationDateResponseValue                    characteristic response code (Request Factory Calibration Date response)
         * @param requestFactoryCalibrationDateResponseParameter                part of characteristic data array (Request Factory Calibration Date response)
         * @param startEnhancedOffsetCompensationResponseValue                  characteristic response code (Start Enhanced Offset Compensation response)
         * @param startEnhancedOffsetCompensationResponseParameter              characteristic response parameter (Start Enhanced Offset Compensation response)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCyclingPowerControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue
                , int setCumulativeValueResponseValue
                , int updateSensorLocationResponseValue
                , int requestSupportedSensorLocationsResponseValue
                , @NonNull byte[] requestSupportedSensorLocationsResponseParameter
                , int setCrankLengthResponseValue
                , int requestCrankLengthResponseValue
                , @NonNull byte[] requestCrankLengthResponseParameter
                , int setChainLengthResponseValue
                , int requestChainLengthResponseValue
                , @NonNull byte[] requestChainLengthResponseParameter
                , int setChainWeightResponseValue
                , int requestChainWeightResponseValue
                , @NonNull byte[] requestChainWeightResponseParameter
                , int setSpanLengthResponseValue
                , int requestSpanLengthResponseValue
                , @NonNull byte[] requestSpanLengthResponseParameter
                , int startOffsetCompensationResponseValue
                , @NonNull byte[] startOffsetCompensationResponseParameter
                , int maskCyclingPowerMeasurementCharacteristicContentResponseValue
                , int requestSamplingRateResponseValue
                , @NonNull byte[] requestSamplingRateResponseParameter
                , int requestFactoryCalibrationDateResponseValue
                , @NonNull byte[] requestFactoryCalibrationDateResponseParameter
                , int startEnhancedOffsetCompensationResponseValue
                , @NonNull byte[] startEnhancedOffsetCompensationResponseParameter) {
            mCyclingPowerControlPoint = new CyclingPowerControlPointCharacteristicData(Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , setCumulativeValueResponseValue
                    , updateSensorLocationResponseValue
                    , requestSupportedSensorLocationsResponseValue
                    , requestSupportedSensorLocationsResponseParameter
                    , setCrankLengthResponseValue
                    , requestCrankLengthResponseValue
                    , requestCrankLengthResponseParameter
                    , setChainLengthResponseValue
                    , requestChainLengthResponseValue
                    , requestChainLengthResponseParameter
                    , setChainWeightResponseValue
                    , requestChainWeightResponseValue
                    , requestChainWeightResponseParameter
                    , setSpanLengthResponseValue
                    , requestSpanLengthResponseValue
                    , requestSpanLengthResponseParameter
                    , startOffsetCompensationResponseValue
                    , startOffsetCompensationResponseParameter
                    , maskCyclingPowerMeasurementCharacteristicContentResponseValue
                    , requestSamplingRateResponseValue
                    , requestSamplingRateResponseParameter
                    , requestFactoryCalibrationDateResponseValue
                    , requestFactoryCalibrationDateResponseParameter
                    , startEnhancedOffsetCompensationResponseValue
                    , startEnhancedOffsetCompensationResponseParameter);
            return this;
        }

        /**
         * remove Cycling Power Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCyclingPowerControlPoint() {
            mCyclingPowerControlPoint = null;
            return this;
        }

        /**
         * @see #addCyclingPowerVector(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCyclingPowerVector(@NonNull CyclingPowerVector cyclingPowerVector, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCyclingPowerVector(BluetoothGatt.GATT_SUCCESS, 0, cyclingPowerVector.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Cycling Power Vector characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCyclingPowerVector(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCyclingPowerVectorData = new CharacteristicData(CYCLING_POWER_VECTOR_CHARACTERISTIC
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
         * remove Cycling Power Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCyclingPowerVector() {
            mCyclingPowerVectorData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData createData() {
            if (mCyclingPowerFeatureData == null) {
                throw new RuntimeException("no Cycling Power Feature data");
            }
            CyclingPowerFeature cyclingPowerFeature = new CyclingPowerFeature(mCyclingPowerFeatureData.getBytes());

            if (mCyclingPowerMeasurementData == null) {
                throw new RuntimeException("no Cycling Power Measurement data");
            } else {
                CyclingPowerMeasurement cyclingPowerMeasurement = new CyclingPowerMeasurement(mCyclingPowerMeasurementData.getBytes());
                if (cyclingPowerFeature.isCyclingPowerFeaturePedalPowerBalanceNotSupported() && cyclingPowerMeasurement.isFlagsPedalPowerBalancePresent()) {
                    throw new RuntimeException("Pedal Power Balance not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureAccumulatedTorqueNotSupported() && cyclingPowerMeasurement.isFlagsAccumulatedTorquePresent()) {
                    throw new RuntimeException("Accumulated Torque not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureWheelRevolutionDataNotSupported() && cyclingPowerMeasurement.isFlagsWheelRevolutionDataPresent()) {
                    throw new RuntimeException("Wheel Revolution Data not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureCrankRevolutionDataNotSupported() && cyclingPowerMeasurement.isFlagsCrankRevolutionDataPresent()) {
                    throw new RuntimeException("Crank Revolution Data not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureExtremeMagnitudesNotSupported()
                        && (cyclingPowerMeasurement.isFlagsExtremeForceMagnitudesPresent()
                        || cyclingPowerMeasurement.isFlagsExtremeTorqueMagnitudesPresent())) {
                    throw new RuntimeException("Extreme Magnitudes not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureExtremeAnglesNotSupported() && cyclingPowerMeasurement.isFlagsExtremeAnglesPresent()) {
                    throw new RuntimeException("Extreme Angles not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureTopAndBottomDeadSpotAnglesNotSupported()
                        && (cyclingPowerMeasurement.isFlagsBottomDeadSpotAnglePresent()
                        || cyclingPowerMeasurement.isFlagsTopDeadSpotAnglePresent())) {
                    throw new RuntimeException("Top and Bottom Dead Spot Angles not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureAccumulatedEnergyNotSupported() && cyclingPowerMeasurement.isFlagsAccumulatedEnergyPresent()) {
                    throw new RuntimeException("Accumulated Energy not Supported");
                }
                if (cyclingPowerFeature.isCyclingPowerFeatureOffsetCompensationIndicatorNotSupported() && cyclingPowerMeasurement.isFlagsOffsetCompensationIndicator()) {
                    throw new RuntimeException("Offset Compensation Indicator not Supported");
                }
            }

            if (mSensorLocationData == null) {
                throw new RuntimeException("no Sensor Location data");
            }

            if (mCyclingPowerControlPoint == null) {
                if (cyclingPowerFeature.isCyclingPowerFeatureWheelRevolutionDataSupported()
                        || cyclingPowerFeature.isCyclingPowerFeatureCyclingMultipleSensorLocationsSupported()
                        || cyclingPowerFeature.isCyclingPowerFeatureCrankLengthAdjustmentSupported()
                        || cyclingPowerFeature.isCyclingPowerFeatureOffsetCompensationSupported()
                        || cyclingPowerFeature.isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingSupported()
                        || mCyclingPowerVectorData != null
                        || cyclingPowerFeature.isCyclingPowerFeatureFactoryCalibrationDateSupported()
                        || cyclingPowerFeature.isCyclingPowerFeatureEnhancedOffsetCompensationSupported()) {
                    throw new RuntimeException("no Cycling Power Control Point data");
                }
            }

            if (mCyclingPowerVectorData != null) {
                CyclingPowerVector cyclingPowerVector = new CyclingPowerVector(mCyclingPowerVectorData.getBytes());
                if (cyclingPowerFeature.isCyclingPowerFeatureCrankRevolutionDataNotSupported() && cyclingPowerVector.isFlagsCrankRevolutionDataPresent()) {
                    throw new RuntimeException("Crank Revolution Data not Supported");
                } else if (cyclingPowerFeature.isCyclingPowerFeatureExtremeAnglesNotSupported() && cyclingPowerVector.isFlagsFirstCrankMeasurementAnglePresent()) {
                    throw new RuntimeException("Extreme Angles not Supported");
                } else if (cyclingPowerFeature.isCyclingPowerFeatureSensorMeasurementContextTorqueBased() && cyclingPowerVector.isFlagsInstantaneousForceMagnitudeArrayPresent()) {
                    throw new RuntimeException("Sensor Measurement Context Torque based");
                } else if (cyclingPowerFeature.isCyclingPowerFeatureSensorMeasurementContextForceBased() && cyclingPowerVector.isFlagsInstantaneousTorqueMagnitudeArrayPresent()) {
                    throw new RuntimeException("Sensor Measurement Context Force based");
                } else if (cyclingPowerFeature.isCyclingPowerFeatureInstantaneousMeasurementDirectionNotSupported() && !cyclingPowerVector.isFlagsInstantaneousMeasurementDirectionUnknown()) {
                    throw new RuntimeException("Instantaneous Measurement Direction not Supported");
                }
            }

            return new CyclingPowerServiceData(mCyclingPowerFeatureData
                    , mCyclingPowerMeasurementData
                    , mSensorLocationData
                    , mCyclingPowerControlPoint
                    , mCyclingPowerVectorData);
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CyclingPowerServiceMockCallback build() {
            return new CyclingPowerServiceMockCallback(createData(), false);
        }

    }

    /**
     * Mask Cycling Power Measurement Characteristic Content status map
     */
    private final Map<Integer, Boolean> mMaskMap = new HashMap<>();

    /**
     * @param serviceData {@link ServiceData} instance
     * @param isFallback  fallback flag
     */
    public CyclingPowerServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
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

                            if (CYCLING_POWER_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID) && characteristicData instanceof CyclingPowerControlPointCharacteristicData) {
                                CyclingPowerControlPointCharacteristicData cyclingPowerControlPointCharacteristicData = (CyclingPowerControlPointCharacteristicData) characteristicData;
                                cyclingPowerControlPointCharacteristicData.highPriorityResponseData = null;

                                CyclingPowerControlPoint requestCyclingPowerControlPoint = new CyclingPowerControlPoint(value);

                                if (requestCyclingPowerControlPoint.isOpCodesSetCumulativeValue(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.setCumulativeValueResponseValue) {

                                    CharacteristicData cyclingPowerMeasurementCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_MEASUREMENT_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerMeasurementCharacteristicData != null) {
                                        CyclingPowerMeasurement currentCyclingPowerMeasurement = new CyclingPowerMeasurement(cyclingPowerMeasurementCharacteristicData.getBytes());
                                        cyclingPowerMeasurementCharacteristicData.currentData = new CyclingPowerMeasurement(currentCyclingPowerMeasurement.getFlags()
                                                , currentCyclingPowerMeasurement.getInstantaneousPower()
                                                , currentCyclingPowerMeasurement.getPedalPowerBalance()
                                                , currentCyclingPowerMeasurement.getAccumulatedTorque()
                                                , BLEUtils.createUInt32(requestCyclingPowerControlPoint.getParameterValue(), 0)
                                                , currentCyclingPowerMeasurement.getWheelRevolutionDataLastWheelEventTime()
                                                , currentCyclingPowerMeasurement.getCrankRevolutionDataCumulativeCrankRevolutions()
                                                , currentCyclingPowerMeasurement.getCrankRevolutionDataLastCrankEventTime()
                                                , currentCyclingPowerMeasurement.getExtremeForceMagnitudesMaximumForceMagnitude()
                                                , currentCyclingPowerMeasurement.getExtremeForceMagnitudesMinimumForceMagnitude()
                                                , currentCyclingPowerMeasurement.getExtremeTorqueMagnitudesMaximumTorqueMagnitude()
                                                , currentCyclingPowerMeasurement.getExtremeTorqueMagnitudesMinimumTorqueMagnitude()
                                                , currentCyclingPowerMeasurement.getExtremeAnglesMaximumAngle()
                                                , currentCyclingPowerMeasurement.getExtremeAnglesMinimumAngle()
                                                , currentCyclingPowerMeasurement.getTopDeadSpotAngle()
                                                , currentCyclingPowerMeasurement.getBottomDeadSpotAngle()
                                                , currentCyclingPowerMeasurement.getAccumulatedEnergy())
                                                .getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesUpdateSensorLocation(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.updateSensorLocationResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureCyclingMultipleSensorLocationsSupported()) {
                                        int sensorLocation = BLEUtils.createUInt8(requestCyclingPowerControlPoint.getParameterValue(), 0);
                                        if (Arrays.binarySearch(cyclingPowerControlPointCharacteristicData.requestSupportedSensorLocationsResponseParameter, (byte) sensorLocation) < 0) {
                                            cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION, CyclingPowerControlPoint.RESPONSE_VALUE_INVALID_PARAMETER, new byte[0]).getBytes();
                                        } else {
                                            CharacteristicData sensorLocationCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, SENSOR_LOCATION_CHARACTERISTIC, CharacteristicData.class);
                                            if (sensorLocationCharacteristicData != null) {
                                                sensorLocationCharacteristicData.currentData = new SensorLocation(sensorLocation).getBytes();
                                            }
                                        }
                                    } else {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_UPDATE_SENSOR_LOCATION, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesRequestSupportedSensorLocations(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.requestSupportedSensorLocationsResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureCyclingMultipleSensorLocationsNotSupported()) {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_SUPPORTED_SENSOR_LOCATION, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesSetCrankLength(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.setCrankLengthResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureCrankLengthAdjustmentSupported()) {
                                        cyclingPowerControlPointCharacteristicData.requestCrankLengthResponseParameter = requestCyclingPowerControlPoint.getParameterValue();
                                    } else {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesSetChainLength(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.setChainLengthResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureChainLengthAdjustmentSupported()) {
                                        cyclingPowerControlPointCharacteristicData.requestChainLengthResponseParameter = requestCyclingPowerControlPoint.getParameterValue();
                                    } else {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesSetChainWeight(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.setChainWeightResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureChainWeightAdjustmentSupported()) {
                                        cyclingPowerControlPointCharacteristicData.requestChainWeightResponseParameter = requestCyclingPowerControlPoint.getParameterValue();
                                    } else {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesSetSpanLength(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.setSpanLengthResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureSpanLengthAdjustmentSupported()) {
                                        cyclingPowerControlPointCharacteristicData.requestSpanLengthResponseParameter = requestCyclingPowerControlPoint.getParameterValue();
                                    } else {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesStartOffsetCompensation(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.startOffsetCompensationResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData == null || new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureOffsetCompensationNotSupported()) {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_SET_CRANK_LENGTH, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesMaskCyclingPowerMeasurementCharacteristicContent(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.maskCyclingPowerMeasurementCharacteristicContentResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureCyclingPowerMeasurementCharacteristicContentMaskingNotSupported()) {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_MASK_CYCLING_POWER_MEASUREMENT_CHARACTERISTIC_CONTENT, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    } else {
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentPedalPowerBalanceTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedTorqueTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentWheelRevolutionDataTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentCrankRevolutionDataTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeMagnitudesTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentExtremeAnglesTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentTopDeadSpotAngleTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentBottomDeadSpotAngleTurnOff());
                                        mMaskMap.put(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_MASK
                                                , requestCyclingPowerControlPoint.isParameterValueMaskCyclingPowerMeasurementCharacteristicContentAccumulatedEnergyTurnOff());
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesRequestFactoryCalibrationDate(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.requestFactoryCalibrationDateResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureFactoryCalibrationDateNotSupported()) {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_REQUEST_FACTORY_CALIBRATION_DATE, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestCyclingPowerControlPoint.isOpCodesStartEnhancedOffsetCompensation(requestCyclingPowerControlPoint.getOpCodes())
                                        && CyclingPowerControlPoint.RESPONSE_VALUE_SUCCESS == cyclingPowerControlPointCharacteristicData.startEnhancedOffsetCompensationResponseValue) {
                                    CharacteristicData cyclingPowerFeatureCharacteristicData = findCharacteristicData(CYCLING_POWER_SERVICE, CYCLING_POWER_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                    if (cyclingPowerFeatureCharacteristicData != null && new CyclingPowerFeature(cyclingPowerFeatureCharacteristicData.getBytes()).isCyclingPowerFeatureEnhancedOffsetCompensationNotSupported()) {
                                        cyclingPowerControlPointCharacteristicData.highPriorityResponseData = new CyclingPowerControlPoint(CyclingPowerControlPoint.OP_CODES_RESPONSE_CODE, new byte[0], CyclingPowerControlPoint.OP_CODES_START_ENHANCED_OFFSET_COMPENSATION, CyclingPowerControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                }
                                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                if (bluetoothGattDescriptor != null) {
                                    int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);

                                    startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, characteristicData.delay, 1, null);
                                }
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

    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void startNotification(@Nullable Integer taskId, @NonNull BLEServerConnection bleServerConnection, @Nullable BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, int descriptorInstanceId, long delay, @Nullable Integer notificationCount, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null) {
                int targetNotificationCount = notificationCount == null ? characteristicData.notificationCount : notificationCount;
                if (targetNotificationCount != 0) {
                    Bundle bundle = new Bundle();
                    bundle.putInt(KEY_NOTIFICATION_COUNT, notificationCount == null ? characteristicData.notificationCount : notificationCount);
                    bundle.putInt(KEY_DESCRIPTOR_INSTANCE_ID, descriptorInstanceId);
                    if (argument != null) {
                        bundle.putBundle(KEY_ORIGINAL_ARGUMENT, argument);
                    }

                    Boolean isConfirm = null;
                    Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (descriptorDataMap != null) {
                        DescriptorData descriptorData = descriptorDataMap.get(Pair.create(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, descriptorInstanceId));
                        if (descriptorData != null) {
                            if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = false;
                            } else if ((characteristicData.property & BluetoothGattCharacteristic.PROPERTY_INDICATE) != 0 && Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorData.getBytes())) {
                                isConfirm = true;
                            }
                        }
                    }

                    if (isConfirm != null) {
                        NotificationData notificationData;
                        if (CYCLING_POWER_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                            CyclingPowerMeasurement originalCyclingPowerMeasurement = new CyclingPowerMeasurement(characteristicData.getBytes());
                            int flags = BLEUtils.createUInt16(originalCyclingPowerMeasurement.getFlags(), 0);

                            Boolean mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_PEDAL_POWER_BALANCE_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsPedalPowerBalancePresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_PEDAL_POWER_BALANCE_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_ACCUMULATED_TORQUE_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsAccumulatedTorquePresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_ACCUMULATED_TORQUE_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_WHEEL_REVOLUTION_DATA_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsWheelRevolutionDataPresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_WHEEL_REVOLUTION_DATA_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_CRANK_REVOLUTION_DATA_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsCrankRevolutionDataPresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_CRANK_REVOLUTION_DATA_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_CONTENT_EXTREME_MAGNITUDES_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsExtremeForceMagnitudesPresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_EXTREME_FORCE_MAGNITUDES_PRESENT_MASK;
                            }
                            if (originalCyclingPowerMeasurement.isFlagsExtremeTorqueMagnitudesPresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_EXTREME_TORQUE_MAGNITUDES_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_EXTREME_ANGLES_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsExtremeAnglesPresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_EXTREME_ANGLES_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_TOP_DEAD_SPOT_ANGLE_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsTopDeadSpotAnglePresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_TOP_DEAD_SPOT_ANGLE_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_BOTTOM_DEAD_SPOT_ANGLE_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsBottomDeadSpotAnglePresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_BOTTOM_DEAD_SPOT_ANGLE_PRESENT_MASK;
                            }
                            mask = mMaskMap.get(CyclingPowerControlPoint.PARAMETER_VALUE_MASK_CYCLING_POWER_MEASURMENT_CHARACTERISTIC_ACCUMULATED_ENERGY_MASK);
                            if (originalCyclingPowerMeasurement.isFlagsAccumulatedEnergyPresent() && Boolean.TRUE.equals(mask)) {
                                flags &= ~CyclingPowerMeasurement.FLAGS_ACCUMULATED_ENERGY_PRESENT_MASK;
                            }

                            CyclingPowerMeasurement modifiedCyclingPowerMeasurement = new CyclingPowerMeasurement(new byte[]{(byte) flags, (byte) ((0xff00 & flags) >> 8)}
                                    , originalCyclingPowerMeasurement.getInstantaneousPower()
                                    , originalCyclingPowerMeasurement.getPedalPowerBalance()
                                    , originalCyclingPowerMeasurement.getAccumulatedTorque()
                                    , originalCyclingPowerMeasurement.getWheelRevolutionDataCumulativeWheelRevolutions()
                                    , originalCyclingPowerMeasurement.getWheelRevolutionDataLastWheelEventTime()
                                    , originalCyclingPowerMeasurement.getCrankRevolutionDataCumulativeCrankRevolutions()
                                    , originalCyclingPowerMeasurement.getCrankRevolutionDataLastCrankEventTime()
                                    , originalCyclingPowerMeasurement.getExtremeForceMagnitudesMaximumForceMagnitude()
                                    , originalCyclingPowerMeasurement.getExtremeForceMagnitudesMinimumForceMagnitude()
                                    , originalCyclingPowerMeasurement.getExtremeTorqueMagnitudesMaximumTorqueMagnitude()
                                    , originalCyclingPowerMeasurement.getExtremeTorqueMagnitudesMinimumTorqueMagnitude()
                                    , originalCyclingPowerMeasurement.getExtremeAnglesMaximumAngle()
                                    , originalCyclingPowerMeasurement.getExtremeAnglesMinimumAngle()
                                    , originalCyclingPowerMeasurement.getTopDeadSpotAngle()
                                    , originalCyclingPowerMeasurement.getBottomDeadSpotAngle()
                                    , originalCyclingPowerMeasurement.getAccumulatedEnergy());

                            if (device == null) {
                                for (BluetoothDevice bluetoothDevice : mConnectedDeviceMap.keySet()) {
                                    notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                    if (!mActivatedNotificationMap.containsKey(notificationData)) {
                                        Integer newTaskId = bleServerConnection.createNotifyTask(bluetoothDevice
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , modifiedCyclingPowerMeasurement
                                                , isConfirm
                                                , NotifyTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                        if (newTaskId != null) {
                                            mActivatedNotificationMap.put(notificationData, newTaskId);
                                        }
                                    }
                                }
                            } else {
                                notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                if (mConnectedDeviceMap.containsKey(device)) {
                                    Integer currentTaskId = mActivatedNotificationMap.get(notificationData);
                                    if (currentTaskId == null || currentTaskId.equals(taskId)) {
                                        Integer newTaskId = bleServerConnection.createNotifyTask(device
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , modifiedCyclingPowerMeasurement
                                                , isConfirm
                                                , NotifyTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                        if (newTaskId != null) {
                                            mActivatedNotificationMap.put(notificationData, newTaskId);
                                        }
                                    }
                                } else {
                                    mActivatedNotificationMap.remove(notificationData);
                                }
                            }
                        } else {
                            if (device == null) {
                                for (BluetoothDevice bluetoothDevice : mConnectedDeviceMap.keySet()) {
                                    notificationData = new NotificationData(bluetoothDevice, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                    if (!mActivatedNotificationMap.containsKey(notificationData)) {
                                        Integer newTaskId = bleServerConnection.createNotifyTask(bluetoothDevice
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , characteristicData
                                                , isConfirm
                                                , NotifyTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                        if (newTaskId != null) {
                                            mActivatedNotificationMap.put(notificationData, newTaskId);
                                        }
                                    }
                                }
                            } else {
                                notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                                if (mConnectedDeviceMap.containsKey(device)) {
                                    Integer currentTaskId = mActivatedNotificationMap.get(notificationData);
                                    if (currentTaskId == null || currentTaskId.equals(taskId)) {
                                        Integer newTaskId = bleServerConnection.createNotifyTask(device
                                                , serviceUUID
                                                , serviceInstanceId
                                                , characteristicUUID
                                                , characteristicInstanceId
                                                , characteristicData
                                                , isConfirm
                                                , NotifyTask.TIMEOUT_MILLIS
                                                , delay
                                                , bundle
                                                , this);
                                        if (newTaskId != null) {
                                            mActivatedNotificationMap.put(notificationData, newTaskId);
                                        }
                                    }
                                } else {
                                    mActivatedNotificationMap.remove(notificationData);
                                }
                            }
                        }
                    }
                }
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
