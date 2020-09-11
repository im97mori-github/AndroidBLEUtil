package org.im97mori.ble.service.hts.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.DateUtils;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEConstants;
import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.NotificationData;
import org.im97mori.ble.characteristic.u2a1c.TemperatureMeasurement;
import org.im97mori.ble.characteristic.u2a1d.TemperatureType;
import org.im97mori.ble.characteristic.u2a1e.IntermediateTemperature;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_TEMPERATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MEASUREMENT_INTERVAL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_TYPE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.VALID_RANGE_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ErrorCodes.APPLICATION_ERROR_9F;
import static org.im97mori.ble.BLEConstants.ServiceUUID.HEALTH_THERMOMETER_SERVICE;

/**
 * Health Thermometer Service (Service UUID: 0x1809) for Peripheral
 */
public class HealthThermometerServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link HealthThermometerServiceMockCallback}
     *
     * @param <T> subclass of {@link HealthThermometerServiceMockCallback}
     */
    public static class Builder<T extends HealthThermometerServiceMockCallback> extends AbstractServiceMockCallback.Builder<HealthThermometerServiceMockCallback> {

        /**
         * Temperature Measurement data
         */
        protected CharacteristicData mTemperatureMeasurement;

        /**
         * Temperature Type data
         */
        protected CharacteristicData mTemperatureType;

        /**
         * Intermediate Temperature data
         */
        protected CharacteristicData mIntermediateTemperature;

        /**
         * Measurement Interval data
         */
        protected CharacteristicData mMeasurementInterval;

        /**
         * @see #addTemperatureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperatureMeasurement(@NonNull TemperatureMeasurement temperatureMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addTemperatureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, temperatureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Temperature Measurement characteristic
         *
         * @param characteristicResponceCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param descriptorResponceCode     descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTemperatureMeasurement(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mTemperatureMeasurement = new CharacteristicData(TEMPERATURE_MEASUREMENT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_INDICATE
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponceCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponceCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Temperature Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureMeasurement() {
            mTemperatureMeasurement = null;
            return this;
        }

        /**
         * @see #addTemperatureType(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperatureType(@NonNull TemperatureType temperatureType) {
            return addTemperatureType(BluetoothGatt.GATT_SUCCESS, 0, temperatureType.getBytes());
        }

        /**
         * add Temperature Type characteristic
         *
         * @param responceCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTemperatureType(int responceCode, long delay, @NonNull byte[] value) {
            mTemperatureType = new CharacteristicData(TEMPERATURE_TYPE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_READ
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , Collections.<DescriptorData>emptyList()
                    , responceCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Temperature Type characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTemperatureType() {
            mTemperatureType = null;
            return this;
        }

        /**
         * @see #addTemperatureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIntermediateTemperature(@NonNull IntermediateTemperature intermediateTemperature, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addIntermediateTemperature(BluetoothGatt.GATT_SUCCESS, 0, intermediateTemperature.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Intermediate Temperature characteristic
         *
         * @param characteristicResponceCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          TIntermediate Temperature notification count
         * @param descriptorResponceCode     descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descritptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addIntermediateTemperature(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mIntermediateTemperature = new CharacteristicData(INTERMEDIATE_TEMPERATURE_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_NOTIFY
                    , 0
                    , Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponceCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponceCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove Intermediate Temperature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeIntermediateTemperature() {
            mIntermediateTemperature = null;
            return this;
        }

        /**
         * @see #addMeasurementInterval(int, long, byte[], boolean, boolean, int, long, byte[], int, long, byte[])
         */
        @NonNull
        public Builder<T> addMeasurementInterval(@NonNull MeasurementInterval measurementInterval, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration, @NonNull ValidRange validRange) {
            return addMeasurementInterval(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , measurementInterval.getBytes()
                    , true
                    , true
                    , BluetoothGatt.GATT_SUCCESS
                    , 0
                    , clientCharacteristicConfiguration.getBytes()
                    , BluetoothGatt.GATT_SUCCESS
                    , 0
                    , validRange.getBytes());
        }

        /**
         * add Measurement Interval characteristic
         *
         * @param measurementIntervalResponceCode               characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param measurementIntervalDelay                      characteristic response delay(millis)
         * @param measurementIntervalValue                      characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param isMeasurementIntervalIndicatable              indicatable flag for Measurement Interval characteristic
         * @param isMeasurementIntervalWritable                 writable flag for Measurement Interval characteristic
         * @param clientCharacteristicConfigurationResponceCode Client Characteristic Configuration descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param clientCharacteristicConfigurationDelay        Client Characteristic Configuration descritptor response delay(millis)
         * @param clientCharacteristicConfigurationValue        Client Characteristic Configuration descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param validRangeResponceCode                        Valid Range descritptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param validRangeDelay                               Valid Range descritptor response delay(millis)
         * @param validRangeValue                               Valid Range descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addMeasurementInterval(int measurementIntervalResponceCode
                , long measurementIntervalDelay
                , @NonNull byte[] measurementIntervalValue
                , boolean isMeasurementIntervalIndicatable
                , boolean isMeasurementIntervalWritable
                , int clientCharacteristicConfigurationResponceCode
                , long clientCharacteristicConfigurationDelay
                , @NonNull byte[] clientCharacteristicConfigurationValue
                , int validRangeResponceCode
                , long validRangeDelay
                , @NonNull byte[] validRangeValue) {
            int property = BluetoothGattCharacteristic.PROPERTY_READ;
            int permission = BluetoothGattCharacteristic.PERMISSION_READ;
            List<DescriptorData> descriptorDataList = new ArrayList<>();
            if (isMeasurementIntervalIndicatable) {
                property |= BluetoothGattCharacteristic.PROPERTY_INDICATE;
                descriptorDataList.add(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE, clientCharacteristicConfigurationResponceCode, clientCharacteristicConfigurationDelay, clientCharacteristicConfigurationValue));
            }
            if (isMeasurementIntervalWritable) {
                property |= BluetoothGattCharacteristic.PROPERTY_WRITE;
                permission |= BluetoothGattCharacteristic.PERMISSION_WRITE;
                descriptorDataList.add(new DescriptorData(VALID_RANGE_DESCRIPTOR, BluetoothGattDescriptor.PERMISSION_READ, validRangeResponceCode, validRangeDelay, validRangeValue));
            }
            mMeasurementInterval = new CharacteristicData(MEASUREMENT_INTERVAL_CHARACTERISTIC
                    , property
                    , permission
                    , descriptorDataList
                    , measurementIntervalResponceCode
                    , measurementIntervalDelay
                    , measurementIntervalValue
                    , 1);
            return this;
        }

        /**
         * remove Measurement Interval characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeMeasurementInterval() {
            mMeasurementInterval = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mTemperatureMeasurement == null) {
                throw new RuntimeException("no Temperature Measurement data");
            } else {
                characteristicList.add(mTemperatureMeasurement);
            }

            if (mTemperatureType != null) {
                characteristicList.add(mTemperatureType);
            }

            if (mIntermediateTemperature != null) {
                characteristicList.add(mIntermediateTemperature);
            }

            if (mMeasurementInterval != null) {
                MeasurementInterval measurementInterval = new MeasurementInterval(mMeasurementInterval.data);
                if ((mMeasurementInterval.property & BluetoothGattCharacteristic.PROPERTY_WRITE) != 0) {
                    int measurementIntervalSec = measurementInterval.getMeasurementInterval();
                    for (DescriptorData descriptorData : mMeasurementInterval.descriptorDataList) {
                        if (VALID_RANGE_DESCRIPTOR.equals(descriptorData.uuid)) {
                            ValidRange validRange = new ValidRange(descriptorData.data);
                            int lowerInclusiveValue = validRange.getLowerInclusiveValueUint16();
                            if (lowerInclusiveValue == 0) {
                                throw new RuntimeException("A value of 0 is not valid for the lower inclusive value");
                            } else if (!measurementInterval.isMeasurementIntevalNoPeriodicMeasurement()
                                    && (measurementIntervalSec < lowerInclusiveValue || measurementIntervalSec > validRange.getUpperInclusiveValueUint16())) {
                                throw new RuntimeException("Out of Range");
                            }
                            break;
                        }
                    }
                }
                characteristicList.add(mMeasurementInterval);
            }

            ServiceData serviceData = new ServiceData(HEALTH_THERMOMETER_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public HealthThermometerServiceMockCallback build() {
            return new HealthThermometerServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public HealthThermometerServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
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
                if (force) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            } else {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    long delay = characteristicData.delay;
                    do {
                        long delta = SystemClock.elapsedRealtime() - now;
                        if (delta < delay) {
                            try {
                                Thread.sleep(delay - delta);
                            } catch (InterruptedException e) {
                                BLEPeripheralLogUtils.stackLog(e);
                            }
                        }
                    } while (now + delay > SystemClock.elapsedRealtime());

                    int responseCode = characteristicData.responseCode;
                    MeasurementInterval measurementInterval = new MeasurementInterval(value);

                    if (!measurementInterval.isMeasurementIntevalNoPeriodicMeasurement()) {
                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                        if (descriptorDataMap != null) {
                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                                if (VALID_RANGE_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                    ValidRange validRange = new ValidRange(descriptorDataEntry.getValue().getBytes());
                                    int measurementIntervalSec = measurementInterval.getMeasurementInterval();
                                    if (measurementIntervalSec < validRange.getLowerInclusiveValueSint16() || measurementIntervalSec > validRange.getUpperInclusiveValueUint16()) {
                                        responseCode = BLEConstants.ErrorCodes.OUT_OF_RANGE;
                                    }
                                    break;
                                }
                            }
                        }
                    }

                    result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, null);

                    if (result && BluetoothGatt.GATT_SUCCESS == responseCode) {
                        characteristicData.currentData = value;

                        if (!measurementInterval.isMeasurementIntevalNoPeriodicMeasurement()) {
                            for (Map.Entry<Pair<UUID, Integer>, Map<Pair<UUID, Integer>, DescriptorData>> remappedCharacteristicDescriptorMapEntry : mRemappedCharacteristicDescriptorMap.entrySet()) {
                                if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(remappedCharacteristicDescriptorMapEntry.getKey().first)) {
                                    for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : remappedCharacteristicDescriptorMapEntry.getValue().entrySet()) {
                                        if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                            if (Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorDataEntry.getValue().getBytes())) {
                                                startNotification(null
                                                        , bleServerConnection
                                                        , null
                                                        , HEALTH_THERMOMETER_SERVICE
                                                        , serviceInstanceId
                                                        , TEMPERATURE_MEASUREMENT_CHARACTERISTIC
                                                        , remappedCharacteristicDescriptorMapEntry.getKey().second
                                                        , descriptorDataEntry.getKey().second
                                                        , 0
                                                        , null
                                                );
                                            }
                                            break;
                                        }
                                    }
                                    break;
                                }
                            }
                        }

                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                        if (descriptorDataMap != null) {
                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                    startNotification(null
                                            , bleServerConnection
                                            , null
                                            , HEALTH_THERMOMETER_SERVICE
                                            , serviceInstanceId
                                            , MEASUREMENT_INTERVAL_CHARACTERISTIC
                                            , characteristicInstanceId
                                            , descriptorDataEntry.getKey().second
                                            , 0
                                            , null
                                    );
                                    break;
                                }
                            }
                        }
                    }
                }

                if (force && !result) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        }
        return result;
    }

    /**
     * repeat notification or indication with Temperature Measurement's interval control
     */
    @Override
    protected synchronized void repeatNotification(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothDevice device, @NonNull UUID serviceUUID, int serviceInstanceId, @NonNull UUID characteristicUUID, int characteristicInstanceId, @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount > 0) {
                    notificationCount--;
                }

                NotificationData notificationData = new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId);
                if (notificationCount == 0) {
                    mActivatedNotificationMap.remove(notificationData);
                } else {
                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    if (TEMPERATURE_MEASUREMENT_CHARACTERISTIC.equals(characteristicUUID)) {
                        for (Map.Entry<Pair<UUID, Integer>, CharacteristicData> characteristicDataMap : characteristicMap.entrySet()) {
                            if (MEASUREMENT_INTERVAL_CHARACTERISTIC.equals(characteristicDataMap.getKey().first)) {
                                MeasurementInterval measurementInterval = new MeasurementInterval(characteristicDataMap.getValue().getBytes());
                                if (measurementInterval.isMeasurementIntevalNoPeriodicMeasurement()) {
                                    mActivatedNotificationMap.remove(notificationData);
                                } else {
                                    startNotification(taskId
                                            , bleServerConnection
                                            , device
                                            , serviceUUID
                                            , serviceInstanceId
                                            , characteristicUUID
                                            , characteristicInstanceId
                                            , descriptorInstanceId
                                            , measurementInterval.getMeasurementInterval() * DateUtils.SECOND_IN_MILLIS
                                            , notificationCount);
                                }
                                break;
                            }
                        }
                    } else {
                        startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, notificationCount);
                    }
                }
            }
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServerStarted() {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceAddTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveFailed(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, int status, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onServiceRemoveTimeout(@NonNull Integer taskId, @NonNull BLEServerConnection bleServerConnection, @NonNull BluetoothGattService bluetoothGattService, long timeout, @Nullable Bundle argument) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartSuccess(@NonNull AdvertiseSettings advertiseSettings) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingStartFailed(@Nullable Integer errorCode) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onAdvertisingFinished() {

    }

}
