package org.im97mori.ble.profile.blp.peripheral;

import static org.im97mori.ble.constants.ServiceUUID.BLOOD_PRESSURE_SERVICE;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2a23.SystemId;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a35.BloodPressureMeasurement;
import org.im97mori.ble.characteristic.u2a36.IntermediateCuffPressure;
import org.im97mori.ble.characteristic.u2a49.BloodPressureFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

/**
 * Blood Pressure Profile for Peripheral
 */
public class BloodPressureProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link BloodPressureProfileMockCallback}
     *
     * @param <T> subclass of {@link BloodPressureProfileMockCallback}
     */
    public static class Builder<T extends BloodPressureProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder} instance
         */
        protected final BloodPressureServiceMockCallback.Builder<? extends BloodPressureServiceMockCallback> mBloodPressureServiceMockCallbackBuilder;

        /**
         * flag for Manufacturer Name String data
         */
        protected boolean mHasManufacturerNameString;

        /**
         * flag for Model Number String data
         */
        protected boolean mHasModelNumberString;

        /**
         * @param context                                     {@link Context} instance
         * @param bloodPressureServiceMockCallbackBuilder     {@link org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull BloodPressureServiceMockCallback.Builder<? extends BloodPressureServiceMockCallback> bloodPressureServiceMockCallbackBuilder
                , @Nullable DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder) {
            mContext = context;
            mBloodPressureServiceMockCallbackBuilder = bloodPressureServiceMockCallbackBuilder;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
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
         * @see #addSystemId(SystemId)
         */
        @NonNull
        public Builder<T> addSystemId(long manufacturerIdentifier, int organizationallyUniqueIdentifier) {
            return addSystemId(new SystemId(manufacturerIdentifier, organizationallyUniqueIdentifier));
        }

        /**
         * @see #addSystemId(byte[])
         */
        @NonNull
        public Builder<T> addSystemId(SystemId systemId) {
            return addSystemId(systemId.getBytes());
        }

        /**
         * @see #addSystemId(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSystemId(@NonNull byte[] value) {
            return addSystemId(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addSystemId(int, long, byte[])
         */
        @NonNull
        public Builder<T> addSystemId(int responseCode, long delay, @NonNull byte[] value) {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mDeviceInformationServiceMockCallbackBuilder.addSystemId(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeSystemId()
         */
        @NonNull
        public Builder<T> removeSystemId() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                mDeviceInformationServiceMockCallbackBuilder.removeSystemId();
            }
            return this;
        }

        /**
         * @see #addBloodPressureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addBloodPressureMeasurement(@NonNull BloodPressureMeasurement bloodPressureMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder#addBloodPressureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addBloodPressureMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mBloodPressureServiceMockCallbackBuilder.addBloodPressureMeasurement(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder#removeBloodPressureMeasurement()
         */
        @NonNull
        public Builder<T> removeBloodPressureMeasurement() {
            mBloodPressureServiceMockCallbackBuilder.removeBloodPressureMeasurement();
            return this;
        }

        /**
         * @see #addIntermediateCuffPressure(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIntermediateCuffPressure(@NonNull IntermediateCuffPressure intermediateCuffPressure, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addIntermediateCuffPressure(BluetoothGatt.GATT_SUCCESS, 0, intermediateCuffPressure.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder#addIntermediateCuffPressure(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addIntermediateCuffPressure(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mBloodPressureServiceMockCallbackBuilder.addIntermediateCuffPressure(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder#removeIntermediateCuffPressure()
         */
        @NonNull
        public Builder<T> removeIntermediateCuffPressure() {
            mBloodPressureServiceMockCallbackBuilder.removeIntermediateCuffPressure();
            return this;
        }

        /**
         * @see #addBloodPressureFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBloodPressureFeature(@NonNull BloodPressureFeature bloodPressureFeature) {
            return addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder#addBloodPressureFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBloodPressureFeature(int responseCode, long delay, @NonNull byte[] value) {
            mBloodPressureServiceMockCallbackBuilder.addBloodPressureFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bls.peripheral.BloodPressureServiceMockCallback.Builder#removeBloodPressureFeature()
         */
        @NonNull
        public Builder<T> removeBloodPressureFeature() {
            mBloodPressureServiceMockCallbackBuilder.removeBloodPressureFeature();
            return this;
        }

        /**
         * @return {@link BloodPressureProfileMockCallback} instance
         */
        public BloodPressureProfileMockCallback build() {
            if (mDeviceInformationServiceMockCallbackBuilder != null) {
                if (!mHasManufacturerNameString) {
                    throw new RuntimeException("no Manufacturer Name String data");
                }
                if (!mHasModelNumberString) {
                    throw new RuntimeException("no Model Number String data");
                }
            }
            return new BloodPressureProfileMockCallback(mContext
                    , mBloodPressureServiceMockCallbackBuilder.build()
                    , mDeviceInformationServiceMockCallbackBuilder == null ? null : mDeviceInformationServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param bloodPressureServiceMockCallback     {@link BloodPressureServiceMockCallback} instance
     * @param deviceInformationServiceMockCallback {@link DeviceInformationServiceMockCallback} instance
     * @param bleServerCallbacks                   callback array
     */
    public BloodPressureProfileMockCallback(@NonNull Context context
            , @NonNull BloodPressureServiceMockCallback bloodPressureServiceMockCallback
            , @Nullable DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(bloodPressureServiceMockCallback, deviceInformationServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return BLOOD_PRESSURE_SERVICE;
    }

}
