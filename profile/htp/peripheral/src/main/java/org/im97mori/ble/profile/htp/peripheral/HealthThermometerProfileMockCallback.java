package org.im97mori.ble.profile.htp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.u2a1c.TemperatureMeasurement;
import org.im97mori.ble.characteristic.u2a1d.TemperatureType;
import org.im97mori.ble.characteristic.u2a1e.IntermediateTemperature;
import org.im97mori.ble.characteristic.u2a21.MeasurementInterval;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2906.ValidRange;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.constants.ServiceUUID.HEALTH_THERMOMETER_SERVICE;

/**
 * Health Thermometer Profile for Peripheral
 */
public class HealthThermometerProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link HealthThermometerProfileMockCallback}
     *
     * @param <T> subclass of {@link HealthThermometerProfileMockCallback}
     */
    public static class Builder<T extends HealthThermometerProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link  org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder} instance
         */
        protected final HealthThermometerServiceMockCallback.Builder<? extends HealthThermometerServiceMockCallback> mHealthThermometerServiceMockCallback;

        /**
         * flag for Manufacturer Name String data
         */
        protected boolean mHasManufacturerNameString;

        /**
         * flag for Model Number String data
         */
        protected boolean mHasModelNumberNameString;

        /**
         * flag for System ID data
         */
        protected boolean mHasSystemIdString;

        /**
         * @param context                                     {@link Context} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         * @param healthThermometerServiceMockCallback        {@link org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
                , @NonNull HealthThermometerServiceMockCallback.Builder<? extends HealthThermometerServiceMockCallback> healthThermometerServiceMockCallback) {
            mContext = context;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
            mHealthThermometerServiceMockCallback = healthThermometerServiceMockCallback;
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
            mHasManufacturerNameString = true;
            mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeManufacturerNameString()
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            mHasManufacturerNameString = false;
            mDeviceInformationServiceMockCallbackBuilder.removeManufacturerNameString();
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
            mHasModelNumberNameString = true;
            mDeviceInformationServiceMockCallbackBuilder.addModelNumberString(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeModelNumberString()
         */
        @NonNull
        public Builder<T> removeModelNumberString() {
            mHasModelNumberNameString = false;
            mDeviceInformationServiceMockCallbackBuilder.removeModelNumberString();
            return this;
        }

        /**
         * @see #addSystemId(SystemId)
         */
        public Builder<T> addSystemId(long manufacturerIdentifier, int organizationallyUniqueIdentifier) {
            return addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));
        }

        /**
         * @see #addSystemId(byte[])
         */
        public Builder<T> addSystemId(SystemId systemId) {
            return addSystemId(systemId.getBytes());
        }

        /**
         * @see #addSystemId(int, long, byte[])
         */
        public Builder<T> addSystemId(@NonNull byte[] value) {
            return addSystemId(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addSystemId(int, long, byte[])
         */
        public Builder<T> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
            mHasSystemIdString = true;
            mDeviceInformationServiceMockCallbackBuilder.addSystemId(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeSystemId()
         */
        public Builder<T> removeSystemId() {
            mHasSystemIdString = false;
            mDeviceInformationServiceMockCallbackBuilder.removeSystemId();
            return this;
        }

        /**
         * @see #addTemperatureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperatureMeasurement(@NonNull TemperatureMeasurement temperatureMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addTemperatureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, temperatureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#addTemperatureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperatureMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mHealthThermometerServiceMockCallback.addTemperatureMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#removeTemperatureMeasurement()
         */
        @NonNull
        public Builder<T> removeTemperatureMeasurement() {
            mHealthThermometerServiceMockCallback.removeTemperatureMeasurement();
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
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#addTemperatureType(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTemperatureType(int responseCode, long delay, @NonNull byte[] value) {
            mHealthThermometerServiceMockCallback.addTemperatureType(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#removeTemperatureType()
         */
        @NonNull
        public Builder<T> removeTemperatureType() {
            mHealthThermometerServiceMockCallback.removeTemperatureType();
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
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#addIntermediateTemperature(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIntermediateTemperature(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mHealthThermometerServiceMockCallback.addIntermediateTemperature(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#removeIntermediateTemperature()
         */
        @NonNull
        public Builder<T> removeIntermediateTemperature() {
            mHealthThermometerServiceMockCallback.removeIntermediateTemperature();
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
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#addMeasurementInterval(int, long, byte[], boolean, boolean, int, long, byte[], int, long, byte[])
         */
        @NonNull
        public Builder<T> addMeasurementInterval(int measurementIntervalResponseCode
                , long measurementIntervalDelay
                , @NonNull byte[] measurementIntervalValue
                , boolean isMeasurementIntervalIndicatable
                , boolean isMeasurementIntervalWritable
                , int clientCharacteristicConfigurationResponseCode
                , long clientCharacteristicConfigurationDelay
                , @NonNull byte[] clientCharacteristicConfigurationValue
                , int validRangeResponseCode
                , long validRangeDelay
                , @NonNull byte[] validRangeValue) {
            mHealthThermometerServiceMockCallback.addMeasurementInterval(measurementIntervalResponseCode, measurementIntervalDelay, measurementIntervalValue, isMeasurementIntervalIndicatable, isMeasurementIntervalWritable, clientCharacteristicConfigurationResponseCode, clientCharacteristicConfigurationDelay, clientCharacteristicConfigurationValue, validRangeResponseCode, validRangeDelay, validRangeValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback.Builder#removeMeasurementInterval()
         */
        @NonNull
        public Builder<T> removeMeasurementInterval() {
            mHealthThermometerServiceMockCallback.removeMeasurementInterval();
            return this;
        }

        /**
         * @return {@link HealthThermometerProfileMockCallback} instance
         */
        public HealthThermometerProfileMockCallback build() {
            if (!mHasManufacturerNameString) {
                throw new RuntimeException("no Manufacturer Name String data");
            }
            if (!mHasModelNumberNameString) {
                throw new RuntimeException("no Model Number String data");
            }
            if (!mHasSystemIdString) {
                throw new RuntimeException("no System ID data");
            }
            return new HealthThermometerProfileMockCallback(mContext, mDeviceInformationServiceMockCallbackBuilder.build(), mHealthThermometerServiceMockCallback.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param deviceInformationServiceMockCallback {@link DeviceInformationServiceMockCallback} instance
     * @param healthThermometerServiceMockCallback {@link org.im97mori.ble.service.hts.peripheral.HealthThermometerServiceMockCallback} instance
     */
    public HealthThermometerProfileMockCallback(@NonNull Context context, @NonNull DeviceInformationServiceMockCallback deviceInformationServiceMockCallback, @NonNull HealthThermometerServiceMockCallback healthThermometerServiceMockCallback) {
        super(context, true, deviceInformationServiceMockCallback, healthThermometerServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return HEALTH_THERMOMETER_SERVICE;
    }

}
