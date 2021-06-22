package org.im97mori.ble.profile.cscp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a5b.CSCMeasurement;
import org.im97mori.ble.characteristic.u2a5c.CSCFeature;
import org.im97mori.ble.characteristic.u2a5d.SensorLocation;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.constants.ServiceUUID.CYCLING_SPEED_AND_CADENCE_SERVICE;

/**
 * Cycling Speed and Cadence Profile for Peripheral
 */
public class CyclingSpeedAndCadenceProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link CyclingSpeedAndCadenceProfileMockCallback}
     *
     * @param <T> subclass of {@link CyclingSpeedAndCadenceProfileMockCallback}
     */
    public static class Builder<T extends CyclingSpeedAndCadenceProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder} instance
         */
        protected final CyclingSpeedAndCadenceServiceMockCallback.Builder<? extends CyclingSpeedAndCadenceServiceMockCallback> mCyclingSpeedAndCadenceServiceMockCallback;

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
         * @param cyclingSpeedAndCadenceServiceMockCallbackBuilder {@link org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder      {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull CyclingSpeedAndCadenceServiceMockCallback.Builder<? extends CyclingSpeedAndCadenceServiceMockCallback> cyclingSpeedAndCadenceServiceMockCallbackBuilder
                , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
            mContext = context;
            mCyclingSpeedAndCadenceServiceMockCallback = cyclingSpeedAndCadenceServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
        }

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
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#addCSCFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addCSCFeature(int responseCode, long delay, @NonNull byte[] value) {
            mCyclingSpeedAndCadenceServiceMockCallback.addCSCFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#removeCSCFeature()
         */
        @NonNull
        public Builder<T> removeCSCFeature() {
            mCyclingSpeedAndCadenceServiceMockCallback.removeCSCFeature();
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
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#addCSCMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addCSCMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mCyclingSpeedAndCadenceServiceMockCallback.addCSCMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#removeCSCMeasurement()
         */
        @NonNull
        public Builder<T> removeCSCMeasurement() {
            mCyclingSpeedAndCadenceServiceMockCallback.removeCSCMeasurement();
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
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#addSensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSensorLocation(int responseCode, long delay, @NonNull byte[] value) {
            mCyclingSpeedAndCadenceServiceMockCallback.addSensorLocation(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#removeSensorLocation()
         */
        @NonNull
        public Builder<T> removeSensorLocation() {
            mCyclingSpeedAndCadenceServiceMockCallback.removeSensorLocation();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#addSCControlPoint(int, long, int, long, byte[], int, int, int, byte[])
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
            mCyclingSpeedAndCadenceServiceMockCallback.addSCControlPoint(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, setCumulativeValueResponseValue, updateSensorLocationResponseValue, requestSupportedSensorLocationsResponseValue, requestSupportedSensorLocationsResponseParameter);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback.Builder#removeSCControlPoint()
         */
        @NonNull
        public Builder<T> removeSCControlPoint() {
            mCyclingSpeedAndCadenceServiceMockCallback.removeSCControlPoint();
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
         * @return {@link CyclingSpeedAndCadenceProfileMockCallback} instance
         */
        public CyclingSpeedAndCadenceProfileMockCallback build() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                if (!mHasManufacturerNameString) {
                    throw new RuntimeException("no Manufacturer Name String data");
                }
                if (!mHasModelNumberString) {
                    throw new RuntimeException("no Model Number String data");
                }
            }
            return new CyclingSpeedAndCadenceProfileMockCallback(mContext
                    , mCyclingSpeedAndCadenceServiceMockCallback.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                                   {@link Context} instance
     * @param cyclingSpeedAndCadenceServiceMockCallback {@link org.im97mori.ble.service.cscs.peripheral.CyclingSpeedAndCadenceServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback      {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback} instance
     */
    public CyclingSpeedAndCadenceProfileMockCallback(@NonNull Context context
            , @NonNull CyclingSpeedAndCadenceServiceMockCallback cyclingSpeedAndCadenceServiceMockCallback
            , @Nullable DeviceInformationServiceMockCallback deviceInformationServiceMockCallback) {
        super(context, true, cyclingSpeedAndCadenceServiceMockCallback, deviceInformationServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return CYCLING_SPEED_AND_CADENCE_SERVICE;
    }

}
