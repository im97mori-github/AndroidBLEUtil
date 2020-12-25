package org.im97mori.ble.profile.rscp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a53.RSCMeasurement;
import org.im97mori.ble.characteristic.u2a54.RSCFeature;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.RUNNING_SPEED_AND_CADENCE_SERVICE;

/**
 * Running Speed and Cadence Profile for Peripheral
 */
public class RunningSpeedAndCadenceProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link RunningSpeedAndCadenceProfileMockCallback}
     *
     * @param <T> subclass of {@link RunningSpeedAndCadenceProfileMockCallback}
     */
    public static class Builder<T extends RunningSpeedAndCadenceProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder} instance
         */
        protected final RunningSpeedAndCadenceServiceMockCallback.Builder<? extends RunningSpeedAndCadenceServiceMockCallback> mRunningSpeedAndCadenceServiceMockCallback;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * flag for Manufacturer Name String data
         */
        protected boolean mHasManufacturerNameString;

        /**
         * flag for Model Number String data
         */
        protected boolean mHasModelNumberString;

        /**
         * @param context                                          {@link Context} instance
         * @param runningSpeedAndCadenceServiceMockCallbackBuilder {@link org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder      {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull RunningSpeedAndCadenceServiceMockCallback.Builder<? extends RunningSpeedAndCadenceServiceMockCallback> runningSpeedAndCadenceServiceMockCallbackBuilder
                , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
            mContext = context;
            mRunningSpeedAndCadenceServiceMockCallback = runningSpeedAndCadenceServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
        }

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
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#addRSCFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRSCFeature(int responseCode, long delay, @NonNull byte[] value) {
            mRunningSpeedAndCadenceServiceMockCallback.addRSCFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#removeRSCFeature()
         */
        @NonNull
        public Builder<T> removeRSCFeature() {
            mRunningSpeedAndCadenceServiceMockCallback.removeRSCFeature();
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
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#addRSCMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRSCMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mRunningSpeedAndCadenceServiceMockCallback.addRSCMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#removeRSCMeasurement()
         */
        @NonNull
        public Builder<T> removeRSCMeasurement() {
            mRunningSpeedAndCadenceServiceMockCallback.removeRSCMeasurement();
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
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#addSensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
            mRunningSpeedAndCadenceServiceMockCallback.addSensorLocation(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#removeSensorLocation()
         */
        @NonNull
        public Builder<T> removeSensorLocation() {
            mRunningSpeedAndCadenceServiceMockCallback.removeSensorLocation();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#addSCControlPoint(int, long, int, long, byte[], int, int, int, int, byte[])
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
            mRunningSpeedAndCadenceServiceMockCallback.addSCControlPoint(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, setCumulativeValueResponseValue, startSensorCalibrationResponseValue, updateSensorLocationResponseValue, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback.Builder#removeSCControlPoint()
         */
        @NonNull
        public Builder<T> removeSCControlPoint() {
            mRunningSpeedAndCadenceServiceMockCallback.removeSCControlPoint();
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
                mHasManufacturerNameString = true;
                mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeManufacturerNameString()
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mHasManufacturerNameString = false;
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
                mHasModelNumberString = true;
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
                mHasModelNumberString = false;
                mDeviceInformationServiceMockCallbackBuilder.removeModelNumberString();
            }
            return this;
        }

        /**
         * @return {@link RunningSpeedAndCadenceProfileMockCallback} instance
         */
        public RunningSpeedAndCadenceProfileMockCallback build() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                if (!mHasManufacturerNameString) {
                    throw new RuntimeException("no Manufacturer Name String data");
                }
                if (!mHasModelNumberString) {
                    throw new RuntimeException("no Model Number String data");
                }
            }
            return new RunningSpeedAndCadenceProfileMockCallback(mContext
                    , mRunningSpeedAndCadenceServiceMockCallback.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                                   {@link Context} instance
     * @param runningSpeedAndCadenceServiceMockCallback {@link org.im97mori.ble.service.rscs.peripheral.RunningSpeedAndCadenceServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback      {@link DeviceInformationServiceMockCallback} instance
     */
    public RunningSpeedAndCadenceProfileMockCallback(@NonNull Context context
            , @NonNull RunningSpeedAndCadenceServiceMockCallback runningSpeedAndCadenceServiceMockCallback
            , @Nullable DeviceInformationServiceMockCallback deviceInformationServiceMockCallback) {
        super(context, true, runningSpeedAndCadenceServiceMockCallback, deviceInformationServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return RUNNING_SPEED_AND_CADENCE_SERVICE;
    }

}
