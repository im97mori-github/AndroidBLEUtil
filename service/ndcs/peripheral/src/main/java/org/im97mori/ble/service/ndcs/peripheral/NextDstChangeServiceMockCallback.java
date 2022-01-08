package org.im97mori.ble.service.ndcs.peripheral;

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
import org.im97mori.ble.characteristic.u2a11.TimeWithDst;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.constants.CharacteristicUUID.TIME_WITH_DST_CHARACTERISTIC;
import static org.im97mori.ble.constants.ServiceUUID.NEXT_DST_CHANGE_SERVICE;

/**
 * Next DST Change Service (Service UUID: 0x1807) for Peripheral
 */
public class NextDstChangeServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * Builder for {@link NextDstChangeServiceMockCallback}
     *
     * @param <T> subclass of {@link NextDstChangeServiceMockCallback}
     */
    public static class Builder<T extends NextDstChangeServiceMockCallback> extends AbstractServiceMockCallback.Builder<NextDstChangeServiceMockCallback> {

        /**
         * Time with DST data
         */
        protected CharacteristicData mTimeWithDstCharacteristicData;

        /**
         * @see #addTimeWithDst(byte[])
         */
        @NonNull
        public Builder<T> addTimeWithDst(@NonNull TimeWithDst timeWithDst) {
            return addTimeWithDst(timeWithDst.getBytes());
        }

        /**
         * @see #addTimeWithDst(int, long, byte[])
         */
        @NonNull
        public Builder<T> addTimeWithDst(@NonNull byte[] value) {
            return addTimeWithDst(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * add Time with DST characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addTimeWithDst(int responseCode, long delay, @NonNull byte[] value) {
            mTimeWithDstCharacteristicData = new CharacteristicData(TIME_WITH_DST_CHARACTERISTIC
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
         * remove Time with DST characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeTimeWithDst() {
            mTimeWithDstCharacteristicData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MockData createMockData() {
            List<CharacteristicData> characteristicList = new ArrayList<>();

            if (mTimeWithDstCharacteristicData == null) {
                throw new RuntimeException("no Time with DST data");
            } else {
                characteristicList.add(mTimeWithDstCharacteristicData);
            }

            ServiceData serviceData = new ServiceData(NEXT_DST_CHANGE_SERVICE, BluetoothGattService.SERVICE_TYPE_PRIMARY, characteristicList);
            return new MockData(Collections.singletonList(serviceData));
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NextDstChangeServiceMockCallback build() {
            return new NextDstChangeServiceMockCallback(createMockData(), false);
        }

    }

    /**
     * @param serviceData   {@link ServiceData} instance
     * @param isFallback fallback flag
     */
    public NextDstChangeServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(new MockData(Collections.singletonList(serviceData)), isFallback);
    }

    /**
     * @param mockData   {@link MockData} instance
     * @param isFallback fallback flag
     */
    public NextDstChangeServiceMockCallback(@NonNull MockData mockData, boolean isFallback) {
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
