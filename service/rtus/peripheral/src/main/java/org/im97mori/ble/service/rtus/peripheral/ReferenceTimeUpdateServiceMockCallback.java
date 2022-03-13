package org.im97mori.ble.service.rtus.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.TIME_UPDATE_STATE_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.REFERENCE_TIME_UPDATE_SERVICE;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.characteristic.u2a16.TimeUpdateControlPoint;
import org.im97mori.ble.characteristic.u2a17.TimeUpdateState;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Reference Time Update Service (Service UUID: 0x1806) for Peripheral
 */
public class ReferenceTimeUpdateServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link ReferenceTimeUpdateServiceMockCallback}
     *
     * @param <T> subclass of {@link ReferenceTimeUpdateServiceMockCallback}
     */
    public static class Builder<T extends ReferenceTimeUpdateServiceMockCallback> extends AbstractServiceMockCallback.Builder<ReferenceTimeUpdateServiceMockCallback, ServiceData> {

        /**
         * Time Update Control Point data
         */
        protected CharacteristicData mTimeUpdateControlPointData;

        /**
         * Time Update State data
         */
        protected CharacteristicData mTimeUpdateStateData;

        /**
         * @see #addTimeUpdateControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeUpdateControlPoint(@NonNull TimeUpdateControlPoint timeUpdateControlPoint) {
            return addTimeUpdateControlPoint(BluetoothGatt.GATT_SUCCESS, 0, timeUpdateControlPoint.getBytes());
        }

        /**
         * add Time Update Control Point characteristic
         *
         * @param responseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        characteristic response delay(millis)
         * @param value        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTimeUpdateControlPoint(int responseCode, long delay, @NonNull byte[] value) {
            mTimeUpdateControlPointData = new CharacteristicData(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC
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
         * remove Time Update Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTimeUpdateControlPoint() {
            mTimeUpdateControlPointData = null;
            return this;
        }

        /**
         * @see #addTimeUpdateState(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeUpdateState(@NonNull TimeUpdateState timeUpdateState) {
            return addTimeUpdateState(BluetoothGatt.GATT_SUCCESS, 0, timeUpdateState.getBytes());
        }

        /**
         * add Time Update State characteristic
         *
         * @param responseCode characteristic response code for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        characteristic response delay(millis)
         * @param value        characteristic data array for {@link BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTimeUpdateState(int responseCode, long delay, @NonNull byte[] value) {
            mTimeUpdateStateData = new CharacteristicData(TIME_UPDATE_STATE_CHARACTERISTIC
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
         * remove Time Update State characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTimeUpdateState() {
            mTimeUpdateStateData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ServiceData createData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mTimeUpdateControlPointData == null) {
                throw new RuntimeException("no Time Update Control Point data");
            } else {
                characteristicList.add(mTimeUpdateControlPointData);
            }
            if (mTimeUpdateStateData == null) {
                throw new RuntimeException("no Time Update State data");
            } else {
                characteristicList.add(mTimeUpdateStateData);
            }

            return new ServiceData(REFERENCE_TIME_UPDATE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ReferenceTimeUpdateServiceMockCallback build() {
            return new ReferenceTimeUpdateServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData   {@link ServiceData} instance
     * @param isFallback fallback flag
     */
    public ReferenceTimeUpdateServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
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
