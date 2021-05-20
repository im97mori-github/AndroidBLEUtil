package org.im97mori.ble.service.hrs.peripheral;

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
import org.im97mori.ble.characteristic.u2a37.HeartRateMeasurement;
import org.im97mori.ble.characteristic.u2a38.BodySensorLocation;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BODY_SENSOR_LOCATION_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.HEART_RATE_SERVICE;

/**
 * Heart Rate Service (Service UUID: 0x180D) for Peripheral
 */
public class HeartRateServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link HeartRateServiceMockCallback}
     *
     * @param <T> subclass of {@link HeartRateServiceMockCallback}
     */
    public static class Builder<T extends HeartRateServiceMockCallback> extends AbstractServiceMockCallback.Builder<HeartRateServiceMockCallback> {

        /**
         * Heart Rate Measurement data
         */
        protected CharacteristicData mHeartRateMeasurementData;

        /**
         * Body Sensor Location data
         */
        protected CharacteristicData mBodySensorLocation;

        /**
         * Heart Rate Control Point data
         */
        protected CharacteristicData mHeartRateControlPoint;

        /**
         * @see #addHeartRateMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMeasurement(@NonNull HeartRateMeasurement heartRateMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addHeartRateMeasurement(BluetoothGatt.GATT_SUCCESS, 0, heartRateMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Heart Rate Measurement characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Heart Rate Measurement notification count
         * @param descriptorResponseCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHeartRateMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mHeartRateMeasurementData = new CharacteristicData(HEART_RATE_MEASUREMENT_CHARACTERISTIC
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
         * remove Heart Rate Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeartRateMeasurement() {
            mHeartRateMeasurementData = null;
            return this;
        }

        /**
         * @see #addBodySensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBodySensorLocation(@NonNull BodySensorLocation bodySensorLocation) {
            return addBodySensorLocation(BluetoothGatt.GATT_SUCCESS, 0, bodySensorLocation.getBytes());
        }

        /**
         * add Body Sensor Location characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBodySensorLocation(int responseCode, long delay, @NonNull byte[] value) {
            mBodySensorLocation = new CharacteristicData(BODY_SENSOR_LOCATION_CHARACTERISTIC
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
         * remove Body Sensor Location characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBodySensorLocation() {
            mBodySensorLocation = null;
            return this;
        }

        /**
         * @see #addHeartRateControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateControlPoint(@NonNull HeartRateControlPoint heartRateControlPoint) {
            return addHeartRateControlPoint(BluetoothGatt.GATT_SUCCESS, 0, heartRateControlPoint.getBytes());
        }

        /**
         * add Heart Rate Control Point characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addHeartRateControlPoint(int responseCode, long delay, @NonNull byte[] value) {
            mHeartRateControlPoint = new CharacteristicData(HEART_RATE_CONTROL_POINT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_WRITE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Heart Rate Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeHeartRateControlPoint() {
            mHeartRateControlPoint = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mHeartRateMeasurementData == null) {
                throw new RuntimeException("no Heart Rate Measurement data");
            } else {
                characteristicList.add(mHeartRateMeasurementData);
            }

            if (mBodySensorLocation != null) {
                characteristicList.add(mBodySensorLocation);
            }

            HeartRateMeasurement heartRateMeasurement = new HeartRateMeasurement(mHeartRateMeasurementData.data);
            if (heartRateMeasurement.isFlagsEnergyExpendedStatusPresent()) {
                if (mHeartRateControlPoint == null) {
                    throw new RuntimeException("no Heart Rate Control Point data");
                } else {
                    characteristicList.add(mHeartRateControlPoint);
                }
            }

            ServiceData serviceData = new ServiceData(HEART_RATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public HeartRateServiceMockCallback build() {
            return new HeartRateServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public HeartRateServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, int requestId, @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic, boolean preparedWrite, boolean responseNeeded, int offset, @NonNull byte[] value, boolean force) {
        boolean result = false;

        BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
        UUID serviceUUID = bluetoothGattService.getUuid();
        UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
        if (HEART_RATE_SERVICE.equals(serviceUUID)) {
            BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

            if (bluetoothGattServer != null) {
                long now = SystemClock.elapsedRealtime();
                int serviceInstanceId = bluetoothGattService.getInstanceId();
                Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
                if (characteristicMap == null) {
                    if (force) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                } else {
                    int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                    CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                    if (characteristicData != null) {
                        delay(now, characteristicData.delay);

                        result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, null);

                        if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode && new HeartRateControlPoint(value).isHeartRateControlPointResetEnergyExpended()) {
                            characteristicData.currentData = value;

                            for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> entry : characteristicMap.entrySet()) {
                                Pair<UUID, Integer> key = entry.getKey();
                                if (HEART_RATE_MEASUREMENT_CHARACTERISTIC.equals(key.first)) {
                                    characteristicData = entry.getValue();
                                    HeartRateMeasurement current = new HeartRateMeasurement(characteristicData.getBytes());
                                    characteristicData.currentData = new HeartRateMeasurement(current.getFlags(), current.getHeartRateMeasurementValueUint8(), current.getHeartRateMeasurementValueUint16(), 0, current.getRrInterval()).getBytes();
                                }
                            }
                        }
                    }

                    if (force && !result) {
                        result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                    }
                }
            }
        } else {
            result = super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, false);
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
