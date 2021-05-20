package org.im97mori.ble.service.tps.peripheral;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.MockData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a07.TxPowerLevel;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TX_POWER_LEVEL_CHARACTERISTIC;
import static org.im97mori.ble.BLEConstants.ServiceUUID.TX_POWER_SERVICE;

/**
 * Tx Power Service (Service UUID: 0x1804) for Peripheral
 */
public class TxPowerServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link TxPowerServiceMockCallback}
     *
     * @param <T> subclass of {@link TxPowerServiceMockCallback}
     */
    public static class Builder<T extends TxPowerServiceMockCallback> extends AbstractServiceMockCallback.Builder<TxPowerServiceMockCallback> {

        /**
         * Tx Power Level data
         */
        protected CharacteristicData mTxPowerLevelCharacteristicData;

        /**
         * @see #addTxPowerLevel(TxPowerLevel)
         */
        @NonNull
        public Builder<T> addTxPowerLevel(int txPower) {
            return addTxPowerLevel(new TxPowerLevel(txPower));
        }

        /**
         * @see #addTxPowerLevel(byte[])
         */
        @NonNull
        public Builder<T> addTxPowerLevel(@NonNull TxPowerLevel txPowerLevel) {
            return addTxPowerLevel(txPowerLevel.getBytes());
        }

        /**
         * @see #addTxPowerLevel(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTxPowerLevel(@NonNull byte[] value) {
            return addTxPowerLevel(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Tx Power Level characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTxPowerLevel(int responseCode, long delay, @NonNull byte[] value) {
            mTxPowerLevelCharacteristicData = new CharacteristicData(TX_POWER_LEVEL_CHARACTERISTIC
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
         * remove Tx Power Level characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTxPowerLevel() {
            mTxPowerLevelCharacteristicData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mTxPowerLevelCharacteristicData == null) {
                throw new RuntimeException("no Tx Power Level data");
            } else {
                characteristicList.add(mTxPowerLevelCharacteristicData);
            }

            ServiceData serviceData = new ServiceData(TX_POWER_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TxPowerServiceMockCallback build() {
            return new TxPowerServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public TxPowerServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
        super(mockData, isFallback);
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
