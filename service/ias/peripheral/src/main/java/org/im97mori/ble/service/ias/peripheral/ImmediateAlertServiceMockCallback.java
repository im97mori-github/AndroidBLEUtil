package org.im97mori.ble.service.ias.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.ALERT_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.IMMEDIATE_ALERT_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEPeripheralLogUtils;
import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a06.AlertLevel;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Immediate Alert Service (Service UUID: 0x1802) for Peripheral
 */
public class ImmediateAlertServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link ImmediateAlertServiceMockCallback}
     *
     * @param <T> subclass of {@link ImmediateAlertServiceMockCallback}
     */
    public static class Builder<T extends ImmediateAlertServiceMockCallback> extends AbstractServiceMockCallback.Builder<ImmediateAlertServiceMockCallback, ServiceData> {

        /**
         * Alert Level data
         */
        protected CharacteristicData mAlertLevelCharacteristicData;

        /**
         * @see #addAlertLevel(AlertLevel)
         */
        @NonNull
        public Builder<T> addAlertLevel(int alertLevel) {
            return addAlertLevel(new AlertLevel(alertLevel));
        }

        /**
         * @see #addAlertLevel(byte[])
         */
        @NonNull
        public Builder<T> addAlertLevel(@NonNull AlertLevel alertLevel) {
            return addAlertLevel(alertLevel.getBytes());
        }

        /**
         * @see #addAlertLevel(int, long, byte[])
         */
        @NonNull
        public Builder<T> addAlertLevel(@NonNull byte[] value) {
            return addAlertLevel(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Alert Level characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addAlertLevel(int responseCode, long delay, @NonNull byte[] value) {
            mAlertLevelCharacteristicData = new CharacteristicData(ALERT_LEVEL_CHARACTERISTIC
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
         * remove Alert Level characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeAlertLevel() {
            mAlertLevelCharacteristicData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mAlertLevelCharacteristicData == null) {
                throw new RuntimeException("no Alert Level data");
            } else {
                characteristicList.add(mAlertLevelCharacteristicData);
            }

            return new ServiceData(IMMEDIATE_ALERT_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ImmediateAlertServiceMockCallback build() {
            return new ImmediateAlertServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData   {@link ServiceData} instance
     * @param isFallback fallback flag
     */
    public ImmediateAlertServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
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
        if (IMMEDIATE_ALERT_SERVICE.equals(serviceUUID) && ALERT_LEVEL_CHARACTERISTIC.equals(characteristicUUID)) {
            try {
                AlertLevel alertLevel = new AlertLevel(value);
                if (alertLevel.isAlertLevelHighAlert() || alertLevel.isAlertLevelMildAlert() || alertLevel.isAlertLevelNoAlert()) {
                    result = super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, force);
                }
            } catch (Exception e) {
                BLEPeripheralLogUtils.stackLog(e);
            }
        } else {
            result = super.onCharacteristicWriteRequest(bleServerConnection, device, requestId, bluetoothGattCharacteristic, preparedWrite, responseNeeded, offset, value, force);
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
