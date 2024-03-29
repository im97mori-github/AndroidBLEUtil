package org.im97mori.ble.service.bcs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.BODY_COMPOSITION_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.BODY_COMPOSITION_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a9b.BodyCompositionFeature;
import org.im97mori.ble.characteristic.u2a9c.BodyCompositionMeasurement;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Body Composition Service (Service UUID: 0x181B) for Peripheral
 */
public class BodyCompositionServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link BodyCompositionServiceMockCallback}
     *
     * @param <T> subclass of {@link BodyCompositionServiceMockCallback}
     */
    public static class Builder<T extends BodyCompositionServiceMockCallback> extends AbstractServiceMockCallback.Builder<BodyCompositionServiceMockCallback, ServiceData> {

        /**
         * Body Composition Feature data
         */
        protected CharacteristicData mBodyCompositionFeatureData;

        /**
         * Body Composition Measurement data
         */
        protected CharacteristicData mBodyCompositionMeasurementData;

        /**
         * @see #addBodyCompositionFeature(byte[])
         */
        @NonNull
        public Builder<T> addBodyCompositionFeature(@NonNull BodyCompositionFeature bodyCompositionFeature) {
            return addBodyCompositionFeature(bodyCompositionFeature.getBytes());
        }

        /**
         * @see #addBodyCompositionFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBodyCompositionFeature(@NonNull byte[] value) {
            return addBodyCompositionFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Body Composition Feature characteristic
         *
         * @param responseCode response code, {@link BluetoothGatt#GATT_SUCCESS} or etc
         * @param delay        response delay(millis)
         * @param value        data for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBodyCompositionFeature(int responseCode, long delay, @NonNull byte[] value) {
            mBodyCompositionFeatureData = new CharacteristicData(BODY_COMPOSITION_FEATURE_CHARACTERISTIC
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
         * remove Body Composition Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBodyCompositionFeature() {
            mBodyCompositionFeatureData = null;
            return this;
        }

        /**
         * @see #addBodyCompositionMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addBodyCompositionMeasurement(@NonNull BodyCompositionMeasurement bodyCompositionMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addBodyCompositionMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bodyCompositionMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Intermediate Cuff Pressure characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Intermediate Cuff Pressure notification count
         * @param descriptorResponseCode     descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addBodyCompositionMeasurement(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mBodyCompositionMeasurementData = new CharacteristicData(BODY_COMPOSITION_MEASUREMENT_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_INDICATE
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
         * remove Intermediate Cuff Pressure characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeBodyCompositionMeasurement() {
            mBodyCompositionMeasurementData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mBodyCompositionFeatureData == null) {
                throw new RuntimeException("no Body Composition Feature data");
            } else {
                characteristicList.add(mBodyCompositionFeatureData);
            }
            if (mBodyCompositionMeasurementData == null) {
                throw new RuntimeException("no Body Composition Measurement data");
            } else {
                characteristicList.add(mBodyCompositionMeasurementData);
            }
            return new ServiceData(BODY_COMPOSITION_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionServiceMockCallback build() {
            return new BodyCompositionServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData   {@link ServiceData} instance
     * @param isFallback fallback flag
     */
    public BodyCompositionServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
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
