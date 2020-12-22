package org.im97mori.ble.service.cscs.peripheral;

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
import org.im97mori.ble.characteristic.u2a55.SCControlPoint;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurement;
import org.im97mori.ble.characteristic.u2a5c.CSCFeature;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CSC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.CSC_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SC_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;

/**
 * Cycling Speed and Cadence Service (Service UUID: 0x1816) for Peripheral
 */
public class CyclingSpeedAndCadenceServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link CyclingSpeedAndCadenceServiceMockCallback}
     *
     * @param <T> subclass of {@link CyclingSpeedAndCadenceServiceMockCallback}
     */
    public static class Builder<T extends CyclingSpeedAndCadenceServiceMockCallback> extends AbstractServiceMockCallback.Builder<CyclingSpeedAndCadenceServiceMockCallback> {

        /**
         * CSC Feature data
         */
        protected CharacteristicData mCSCFeatureData;

        /**
         * CSC Measurement data
         */
        protected CharacteristicData mCSCMeasurementData;

        /**
         * Sensor Location data
         */
        protected CharacteristicData mSensorLocationData;

        /**
         * SC Control Point data
         */
        protected SCControlPointCharacteristicData mSCControlPointCharacteristicData;

        /**
         * @see #addCSCFeature(byte[])
         */
        @NonNull
        public Builder<T> addCSCFeature(@NonNull CSCFeature cscFeature) {
            return addCSCFeature(cscFeature.getBytes());
        }

        /**
         * @see #addCSCFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addCSCFeature(@NonNull byte[] value) {
            return addCSCFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add CSC Feature characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addCSCFeature(int responseCode, long delay, @NonNull byte[] value) {
            mCSCFeatureData = new CharacteristicData(CSC_FEATURE_CHARACTERISTIC
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
         * remove CSC Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCSCFeature() {
            mCSCFeatureData = null;
            return this;
        }

        /**
         * @see #addCSCMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCSCMeasurement(@NonNull CSCMeasurement cscMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addCSCMeasurement(BluetoothGatt.GATT_SUCCESS, 0, cscMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add CSC Measurement characteristic
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
        public Builder<T> addCSCMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCSCMeasurementData = new CharacteristicData(CSC_MEASUREMENT_CHARACTERISTIC
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
         * remove CSC Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeCSCMeasurement() {
            mCSCMeasurementData = null;
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
         * @param characteristicResponseCode                       characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay                              characteristic response delay(millis)
         * @param descriptorResponseCode                           descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                                  descritptor response delay(millis)
         * @param descriptorValue                                  descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param setCumulativeValueResponseValue                  characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Set Cumulative Value response)
         * @param updateSensorLocationResponseValue                characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Update Sensor Location response)
         * @param requestSupportedSensorLocationsResponseValue     characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Supported Sensor Locations response)
         * @param requestSupportedSensorLocationsResponseParameter part of characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter(Request Supported Sensor Locations response)
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addSCControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue
                , int setCumulativeValueResponseValue
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

            if (mCSCFeatureData == null) {
                throw new RuntimeException("no CSC Feature data");
            } else {
                characteristicList.add(mCSCFeatureData);
            }
            CSCFeature cscFeature = new CSCFeature(mCSCFeatureData.getBytes());

            if (mCSCMeasurementData == null) {
                throw new RuntimeException("no CSC Measurement data");
            } else {
                CSCMeasurement cscMeasurement = new CSCMeasurement(mCSCMeasurementData.getBytes());
                if (cscFeature.isCscFeatureWheelRevolutionDataNotSupported() && cscMeasurement.isFlagsWheelRevolutionDataPresent()) {
                    throw new RuntimeException("Wheel Revolution Data not Supported");
                }
                if (cscFeature.isCscFeatureCrankRevolutionDataSupportedNotSupported() && cscMeasurement.isFlagsCrankRevolutionDataPresent()) {
                    throw new RuntimeException("Crank Revolution Data not Supported");
                }
                characteristicList.add(mCSCMeasurementData);
            }

            if (mSensorLocationData == null) {
                if (cscFeature.isCscFeatureMultipleSensorLocationsSupportedSupported()) {
                    throw new RuntimeException("no Sensor Location data");
                }
            } else {
                characteristicList.add(mSensorLocationData);
            }

            if (mSCControlPointCharacteristicData == null) {
                if (cscFeature.isCscFeatureWheelRevolutionDataSupported() || cscFeature.isCscFeatureMultipleSensorLocationsSupportedSupported()) {
                    throw new RuntimeException("no SC Control Point data");
                }
            } else {
                characteristicList.add(mSCControlPointCharacteristicData);
            }

            ServiceData serviceData = new ServiceData(CYCLING_SPEED_AND_CADENCE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CyclingSpeedAndCadenceServiceMockCallback build() {
            return new CyclingSpeedAndCadenceServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public CyclingSpeedAndCadenceServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
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
                                CSCFeature cscFeature = null;
                                CharacteristicData cscFeatureCharacteristicData = findCharacteristicData(CYCLING_SPEED_AND_CADENCE_SERVICE, CSC_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                if (cscFeatureCharacteristicData != null) {
                                    cscFeature = new CSCFeature(cscFeatureCharacteristicData.getBytes());
                                }

                                if (requestScControlPoint.isOpCodeSetCumulativeValue(requestScControlPoint.getOpCode())
                                        && SCControlPoint.RESPONSE_VALUE_SUCCESS == scControlPointCharacteristicData.setCumulativeValueResponseValue) {
                                    if (cscFeature == null || cscFeature.isCscFeatureWheelRevolutionDataNotSupported()) {
                                        scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    } else {
                                        CharacteristicData cyclingPowerMeasurementCharacteristicData = findCharacteristicData(characteristicMap, CSC_MEASUREMENT_CHARACTERISTIC, CharacteristicData.class);
                                        if (cyclingPowerMeasurementCharacteristicData != null) {
                                            CSCMeasurement currentCSCMeasurement = new CSCMeasurement(cyclingPowerMeasurementCharacteristicData.getBytes());
                                            if (currentCSCMeasurement.isFlagsWheelRevolutionDataNotPresent()) {
                                                scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_SET_CUMULATIVE_VALUE, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                            } else {
                                                cyclingPowerMeasurementCharacteristicData.currentData = new CSCMeasurement(currentCSCMeasurement.getFlags()
                                                        , requestScControlPoint.getCumulativeValue()
                                                        , currentCSCMeasurement.getLastWheelEventTime()
                                                        , currentCSCMeasurement.getCumulativeCrankRevolutions()
                                                        , currentCSCMeasurement.getLastCrankEventTime())
                                                        .getBytes();
                                            }
                                        }
                                    }
                                } else if (requestScControlPoint.isOpCodeUpdateSensorLocation(requestScControlPoint.getOpCode())
                                        && SCControlPoint.RESPONSE_VALUE_SUCCESS == scControlPointCharacteristicData.updateSensorLocationResponseValue) {
                                    if (cscFeature == null || cscFeature.isCscFeatureMultipleSensorLocationsSupportedNotSupported()) {
                                        scControlPointCharacteristicData.highPriorityResponseData = new SCControlPoint(SCControlPoint.OP_CODE_RESPONSE_CODE, 0, 0, SCControlPoint.OP_CODE_UPDATE_SENSOR_LOCATION, SCControlPoint.RESPONSE_VALUE_OP_CODE_NOT_SUPPORTED, new byte[0]).getBytes();
                                    } else {
                                        int sensorLocation = requestScControlPoint.getSensorLocationValue();
                                        if (Arrays.binarySearch(scControlPointCharacteristicData.requestSupportedSensorLocationsResponseParameter, (byte) sensorLocation) == -1) {
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
                                    if (cscFeature == null || cscFeature.isCscFeatureMultipleSensorLocationsSupportedNotSupported()) {
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
