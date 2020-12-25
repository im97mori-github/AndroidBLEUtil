package org.im97mori.ble.service.rscs.peripheral;

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
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a53.RSCMeasurement;
import org.im97mori.ble.characteristic.u2a54.RSCFeature;
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;

/**
 * Running Speed and Cadence Service (Service UUID: 0x1814) for Peripheral
 */
public class RunningSpeedAndCadenceServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link RunningSpeedAndCadenceServiceMockCallback}
     *
     * @param <T> subclass of {@link RunningSpeedAndCadenceServiceMockCallback}
     */
    public static class Builder<T extends RunningSpeedAndCadenceServiceMockCallback> extends AbstractServiceMockCallback.Builder<RunningSpeedAndCadenceServiceMockCallback> {

        /**
         * RSC Feature data
         */
        protected CharacteristicData mRSCFeatureData;

        /**
         * RSC Measurement data
         */
        protected CharacteristicData mRSCMeasurementData;

        /**
         * Sensor Location data
         */
        protected CharacteristicData mSensorLocationData;

        /**
         * SC Control Point data
         */
        protected SCControlPointCharacteristicData mSCControlPointCharacteristicData;

        /**
         * @see #addRSCFeature(byte[])
         */
        @NonNull
        public Builder<T> addRSCFeature(@NonNull RSCFeature rscFeature) {
            return addRSCFeature(rscFeature.getBytes());
        }

        /**
         * @see #addRSCFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRSCFeature(@NonNull byte[] value) {
            return addRSCFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add RSC Feature characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRSCFeature(int responseCode, long delay, @NonNull byte[] value) {
            mRSCFeatureData = new CharacteristicData(RSC_FEATURE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove RSC Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRSCFeature() {
            mRSCFeatureData = null;
            return this;
        }

        /**
         * @see #addRSCMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRSCMeasurement(@NonNull RSCMeasurement rscMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addRSCMeasurement(BluetoothGatt.GATT_SUCCESS, 0, rscMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add RSC Measurement characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRSCMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mRSCMeasurementData = new CharacteristicData(RSC_MEASUREMENT_CHARACTERISTIC
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
         * remove RSC Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRSCMeasurement() {
            mRSCMeasurementData = null;
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
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
            mSensorLocationData = new CharacteristicData(SENSOR_LOCATION_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
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
         * add SC Control Point characteristic
         *
         * @param characteristicResponseCode                       characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay                              characteristic response delay(millis)
         * @param descriptorResponseCode                           descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                                  descritptor response delay(millis)
         * @param descriptorValue                                  descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param setCumulativeValueResponseValue                  characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Cumulative Value response)
         * @param startSensorCalibrationResponseValue              characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Start Sensor Calibration response)
         * @param updateSensorLocationResponseValue                characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Update Sensor Location response)
         * @param requestSupportedSensorLocationsResponseValue     characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Supported Sensor Locations response)
         * @param requestSupportedSensorLocationsResponseParameter part of characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Supported Sensor Locations response)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSCControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue
                , int setCumulativeValueResponseValue
                , int startSensorCalibrationResponseValue
                , int updateSensorLocationResponseValue
                , int requestSupportedSensorLocationsResponseValue
                , @NonNull byte[] requestSupportedSensorLocationsResponseParameter) {
            mSCControlPointCharacteristicData = new SCControlPointCharacteristicData(Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
                    , setCumulativeValueResponseValue
                    , startSensorCalibrationResponseValue
                    , updateSensorLocationResponseValue
                    , requestSupportedSensorLocationsResponseValue
                    , requestSupportedSensorLocationsResponseParameter);
            return this;
        }

        /**
         * remove SC Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeSCControlPoint() {
            mSCControlPointCharacteristicData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mRSCFeatureData == null) {
                throw new RuntimeException("no RSC Feature data");
            } else {
                characteristicList.add(mRSCFeatureData);
            }
            RSCFeature rscFeature = new RSCFeature(mRSCFeatureData.getBytes());

            if (mRSCMeasurementData == null) {
                throw new RuntimeException("no RSC Measurement data");
            } else {
                RSCMeasurement rscMeasurement = new RSCMeasurement(mRSCMeasurementData.getBytes());
                if (rscFeature.isRscFeatureInstantaneousStrideLengthMeasurementNotSupported() && rscMeasurement.isFlagsInstantaneousStrideLengthPresent()) {
                    throw new RuntimeException("Instantaneous Stride Length Measurement not Supported");
                }
                if (rscFeature.isRscFeatureTotalDistanceMeasurementNotSupported() && rscMeasurement.isFlagsTotalDistancePresent()) {
                    throw new RuntimeException("Total Distance Measurement not Supported");
                }
                if (rscFeature.isRscFeatureWalkingOrRunningStatusNotSupported() && rscMeasurement.isFlagsWalkingOrRunningStatusBitsRunning()) {
                    throw new RuntimeException("Walking or Running Status not Supported");
                }
                characteristicList.add(mRSCMeasurementData);
            }

            if (mSensorLocationData == null) {
                if (rscFeature.isRscFeatureMultipleSensorLocationsSupported()) {
                    throw new RuntimeException("no Sensor Location data");
                }
            } else {
                characteristicList.add(mSensorLocationData);
            }

            if (mSCControlPointCharacteristicData == null) {
                if (rscFeature.isRscFeatureTotalDistanceMeasurementSupported() || rscFeature.isRscFeatureCalibrationProcedureSupported() || rscFeature.isRscFeatureMultipleSensorLocationsSupported()) {
                    throw new RuntimeException("no SC Control Point data");
                }
            } else {
                characteristicList.add(mSCControlPointCharacteristicData);
            }

            ServiceData serviceData = new ServiceData(RUNNING_SPEED_AND_CADENCE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public RunningSpeedAndCadenceServiceMockCallback build() {
            return new RunningSpeedAndCadenceServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public RunningSpeedAndCadenceServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
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
                        result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);
                    } else {
                        result = true;
                    }

                    if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                        mIsReliable |= preparedWrite;

                        if (mIsReliable) {
                            characteristicData.temporaryData = Arrays.copyOfRange(value, offset, value.length);
                        } else {
                            characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);

                            if (SC_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID) && characteristicData instanceof SCControlPointCharacteristicData) {
                                SCControlPointCharacteristicData scControlPointCharacteristicData = (SCControlPointCharacteristicData) characteristicData;
                                scControlPointCharacteristicData.highPriorityResponseData = null;

                                SCControlPoint requestScControlPoint = new SCControlPoint(value);
                                RSCFeature rscFeature = null;
                                CharacteristicData rscFeatureCharacteristicData = findCharacteristicData(RUNNING_SPEED_AND_CADENCE_SERVICE, RSC_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                if (rscFeatureCharacteristicData != null) {
                                    rscFeature = new RSCFeature(rscFeatureCharacteristicData.getBytes());
                                }

                                if (requestScControlPoint.isOpCodeSetCumulativeValue(requestScControlPoint.getOpCode())
                                        && SCControlPoint.RESPONSE_VALUE_SUCCESS == scControlPointCharacteristicData.setCumulativeValueResponseValue) {
                                    if (rscFeature == null || rscFeature.isRscFeatureTotalDistanceMeasurementNotSupported()) {
                                        scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    } else {
                                        CharacteristicData rscMeasurementCharacteristicData = findCharacteristicData(characteristicMap, RSC_MEASUREMENT_CHARACTERISTIC, CharacteristicData.class);
                                        if (rscMeasurementCharacteristicData != null) {
                                            RSCMeasurement currentRSCMeasurement = new RSCMeasurement(rscMeasurementCharacteristicData.getBytes());
                                            if (currentRSCMeasurement.isFlagsTotalDistanceNotPresent()) {
                                                scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                            } else {
                                                rscMeasurementCharacteristicData.currentData = new RSCMeasurement(currentRSCMeasurement.getFlags()
                                                        , currentRSCMeasurement.getInstantaneousSpeed()
                                                        , currentRSCMeasurement.getInstantaneousCadence()
                                                        , currentRSCMeasurement.getInstantaneousStrideLength()
                                                        , requestScControlPoint.getCumulativeValue())
                                                        .getBytes();
                                            }
                                        }
                                    }
                                } else if (requestScControlPoint.isOpCodeStartSensorCalibration(requestScControlPoint.getOpCode())
                                        && SCControlPoint.RESPONSE_VALUE_SUCCESS == scControlPointCharacteristicData.startSensorCalibrationResponseValue) {
                                    if (rscFeature == null || rscFeature.isRscFeatureCalibrationProcedureNotSupported()) {
                                        scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_START_SENSOR_CALIBRATION, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                } else if (requestScControlPoint.isOpCodeUpdateSensorLocation(requestScControlPoint.getOpCode())
                                        && SCControlPoint.RESPONSE_VALUE_SUCCESS == scControlPointCharacteristicData.updateSensorLocationResponseValue) {
                                    if (rscFeature == null || rscFeature.isRscFeatureMultipleSensorLocationsNotSupported()) {
                                        scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    } else {
                                        int sensorLocation = requestScControlPoint.getSensorLocationValue();
                                        if (Arrays.binarySearch(scControlPointCharacteristicData.requestSupportedSensorLocationsResponseParameter, (byte) sensorLocation) < 0) {
                                            scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION, SCControlPoint.RESPONSE_VALUE_INVALID_PARAMETER, new byte[0]).getBytes();
                                        } else {
                                            CharacteristicData sensorLocationCharacteristicData = findCharacteristicData(characteristicMap, SENSOR_LOCATION_CHARACTERISTIC, CharacteristicData.class);
                                            if (sensorLocationCharacteristicData != null) {
                                                sensorLocationCharacteristicData.currentData = new SensorLocation(sensorLocation).getBytes();
                                            }
                                        }
                                    }
                                } else if (requestScControlPoint.isOpCodeRequestSupportedSensorLocations(requestScControlPoint.getOpCode())
                                        && SCControlPoint.RESPONSE_VALUE_SUCCESS == scControlPointCharacteristicData.requestSupportedSensorLocationsResponseValue) {
                                    if (rscFeature == null || rscFeature.isRscFeatureMultipleSensorLocationsNotSupported()) {
                                        scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_REQUEST_SUPPORTED_SENSOR_LOCATIONS, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    }
                                }
                                BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                if (bluetoothGattDescriptor != null) {
                                    int descriptorInstanceId = getDescriptorInstanceId(bluetoothGattDescriptor);

                                    startNotification(null, bleServerConnection, null, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, characteristicData.delay, characteristicData.notificationCount, null);
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
