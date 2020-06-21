package org.im97mori.ble.service.bls.peripheral;

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
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a35.BloodPressureMeasurement;
import org.im97mori.ble.characteristic.u2a36.IntermediateCuffPressure;
import org.im97mori.ble.characteristic.u2a49.BloodPressureFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.CharacteristicUUID.INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.BLEConstants.ServiceUUID.BLOOD_PRESSURE_SERVICE;

/**
 * Device Information Service (Service UUID: 0x1810) for Peripheral
 */
public class BloodPressureServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link BloodPressureServiceMockCallback}
     *
     * @param <T> subclass of {@link BloodPressureServiceMockCallback}
     */
    public static class Builder<T extends BloodPressureServiceMockCallback> extends AbstractServiceMockCallback.Builder<BloodPressureServiceMockCallback> {

        /**
         * Blood Pressure Measurement data
         */
        private CharacteristicData mBloodPressureMeasurementData;

        /**
         * Intermediate Cuff Pressure data
         */
        private CharacteristicData mIntermediateCuffPressure;

        /**
         * Blood Pressure Feature data
         */
        private CharacteristicData mBloodPressureFeature;

        /**
         * @see #addBloodPressureMeasurement(int, long, byte[], int, int, long, byte[])
         */
        public Builder<T> addBloodPressureMeasurement(@NonNull BloodPressureMeasurement bloodPressureMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addBloodPressureMeasurement(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Blood Pressure Measurement characteristic
         *
         * @param characteristicResponceCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for  for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Blood Pressure Measurement indication count
         * @param descriptorResponceCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            characteristic response delay(millis)
         * @param descriptorValue            descriptor data array for  for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addBloodPressureMeasurement(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mBloodPressureMeasurementData = new CharacteristicData(BLOOD_PRESSURE_MEASUREMENT_CHARACTERISTIC
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
         * remove Blood Pressure Measurement characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeBloodPressureMeasurement() {
            mBloodPressureMeasurementData = null;
            return this;
        }

        /**
         * @see #addIntermediateCuffPressure(int, long, byte[], int, int, long, byte[])
         */
        public Builder<T> addIntermediateCuffPressure(@NonNull IntermediateCuffPressure intermediateCuffPressure, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addIntermediateCuffPressure(BluetoothGatt.GATT_SUCCESS, 0, intermediateCuffPressure.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Intermediate Cuff Pressure characteristic
         *
         * @param characteristicResponceCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for  for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Blood Pressure Measurement indication count
         * @param descriptorResponceCode     descritptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            characteristic response delay(millis)
         * @param descriptorValue            descriptor data array for  for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addIntermediateCuffPressure(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mIntermediateCuffPressure = new CharacteristicData(INTERMEDIATE_CUFF_PRESSURE_CHARACTERISTIC
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
         * remove Intermediate Cuff Pressure characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeIntermediateCuffPressure() {
            mIntermediateCuffPressure = null;
            return this;
        }

        /**
         * @see #addBloodPressureFeature(int, long, byte[])
         */
        public Builder<T> addBloodPressureFeature(@NonNull BloodPressureFeature bloodPressureFeature) {
            return addBloodPressureFeature(BluetoothGatt.GATT_SUCCESS, 0, bloodPressureFeature.getBytes());
        }

        /**
         * add Blood Pressure Feature characteristic
         *
         * @param responceCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for  for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        public Builder<T> addBloodPressureFeature(int responceCode, long delay, @NonNull byte[] value) {
            mBloodPressureFeature = new CharacteristicData(BLOOD_PRESSURE_FEATURE_CHARACTERISTIC
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
         * remove Blood Pressure Feature characteristic
         *
         * @return {@link Builder} instance
         */
        public Builder<T> removeBloodPressureFeature() {
            mBloodPressureFeature = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mBloodPressureMeasurementData == null) {
                throw new RuntimeException("no Blood Pressure Measurement data");
            } else {
                characteristicList.add(mBloodPressureMeasurementData);
            }
            if (mIntermediateCuffPressure != null) {
                characteristicList.add(mIntermediateCuffPressure);
            }
            if (mBloodPressureFeature == null) {
                throw new RuntimeException("no Blood Pressure Feature data");
            } else {
                characteristicList.add(mBloodPressureFeature);
            }
            ServiceData serviceData = new ServiceData(BLOOD_PRESSURE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BloodPressureServiceMockCallback build() {
            return new BloodPressureServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public BloodPressureServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
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
    public void onDeviceConnected(BluetoothDevice device) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onDeviceDisconnected(BluetoothDevice device) {

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
