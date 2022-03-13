package org.im97mori.ble.service.scps.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.SCAN_INTERVAL_WINDOW_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.SCAN_REFRESH_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ServiceUUID.SCAN_PARAMETERS_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a31.ScanRefresh;
import org.im97mori.ble.characteristic.u2a4f.ScanIntervalWindow;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Scan Parameters Service (Service UUID: 0x1813) for Peripheral
 */
public class ScanParametersServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link ScanParametersServiceMockCallback}
     *
     * @param <T> subclass of {@link ScanParametersServiceMockCallback}
     */
    public static class Builder<T extends ScanParametersServiceMockCallback> extends AbstractServiceMockCallback.Builder<ScanParametersServiceMockCallback, ServiceData> {

        /**
         * Scan Interval Window data
         */
        protected CharacteristicData mScanIntervalWindowData;

        /**
         * Scan Refresh data
         */
        protected CharacteristicData mScanRefreshData;

        /**
         * @see #addScanIntervalWindow(byte[])
         */
        @NonNull
        public Builder<T> addScanIntervalWindow(@NonNull ScanIntervalWindow scanIntervalWindow) {
            return addScanIntervalWindow(scanIntervalWindow.getBytes());
        }

        /**
         * @see #addScanIntervalWindow(int, long, byte[])
         */
        @NonNull
        public Builder<T> addScanIntervalWindow(@NonNull byte[] value) {
            return addScanIntervalWindow(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * add Scan Interval Window characteristic
         *
         * @param responseCode response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addScanIntervalWindow(int responseCode, long delay, @NonNull byte[] value) {
            mScanIntervalWindowData = new CharacteristicData(SCAN_INTERVAL_WINDOW_CHARACTERISTIC
                    , BluetoothGattCharacteristic.PROPERTY_WRITE_NO_RESPONSE
                    , BluetoothGattCharacteristic.PERMISSION_WRITE
                    , Collections.emptyList()
                    , responseCode
                    , delay
                    , value
                    , 0);
            return this;
        }

        /**
         * remove Scan Interval Window characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeScanIntervalWindow() {
            mScanIntervalWindowData = null;
            return this;
        }

        /**
         * @see #addScanRefresh(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addScanRefresh(@NonNull ScanRefresh scanRefresh, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addScanRefresh(BluetoothGatt.GATT_SUCCESS, 0, scanRefresh.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * add Scan Interval Window characteristic
         *
         * @param characteristicResponseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          Cycling Power Measurement notification count
         * @param descriptorResponseCode     descriptor response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addScanRefresh(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mScanRefreshData = new CharacteristicData(SCAN_REFRESH_CHARACTERISTIC
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
         * remove Scan Interval Window characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeScanRefresh() {
            mScanRefreshData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData createData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mScanIntervalWindowData == null) {
                throw new RuntimeException("no Scan Interval Window data");
            } else {
                characteristicList.add(mScanIntervalWindowData);
            }

            if (mScanRefreshData != null) {
                characteristicList.add(mScanRefreshData);
            }

            return new ServiceData(SCAN_PARAMETERS_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ScanParametersServiceMockCallback build() {
            return new ScanParametersServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData   {@link ServiceData} instance
     * @param isFallback fallback flag
     */
    public ScanParametersServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
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
