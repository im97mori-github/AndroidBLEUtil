package org.im97mori.ble.profile.pasp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.characteristic.u2a3f.AlertStatus;
import org.im97mori.ble.characteristic.u2a40.RingerControlPoint;
import org.im97mori.ble.characteristic.u2a41.RingerSetting;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.PHONE_ALERT_STATUS_SERVICE;

/**
 * Phone Alert Status Profile for Peripheral
 */
public class PhoneAlertStatusProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link PhoneAlertStatusProfileMockCallback}
     *
     * @param <T> subclass of {@link PhoneAlertStatusProfileMockCallback}
     */
    public static class Builder<T extends PhoneAlertStatusProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder} instance
         */
        protected final PhoneAlertStatusServiceMockCallback.Builder<? extends PhoneAlertStatusServiceMockCallback> mPhoneAlertStatusServiceMockCallback;

        /**
         * @param context                             {@link Context} instance
         * @param phoneAlertStatusServiceMockCallback {@link org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull PhoneAlertStatusServiceMockCallback.Builder<? extends PhoneAlertStatusServiceMockCallback> phoneAlertStatusServiceMockCallback) {
            mContext = context;
            mPhoneAlertStatusServiceMockCallback = phoneAlertStatusServiceMockCallback;
        }

        /**
         * @see #addAlertStatus(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addAlertStatus(@NonNull AlertStatus alertStatus, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addAlertStatus(BluetoothGatt.GATT_SUCCESS, 0, alertStatus.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder#onServiceAddSuccess(Integer, BLEServerConnection, BluetoothGattService, Bundle)
         */
        @NonNull
        public Builder<T> addAlertStatus(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mPhoneAlertStatusServiceMockCallback.addAlertStatus(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder#removeAlertStatus()
         */
        @NonNull
        public Builder<T> removeAlertStatus() {
            mPhoneAlertStatusServiceMockCallback.removeAlertStatus();
            return this;
        }

        /**
         * @see #addRingerSetting(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRingerSetting(@NonNull RingerSetting ringerSetting, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addRingerSetting(BluetoothGatt.GATT_SUCCESS, 0, ringerSetting.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder#addRingerControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRingerSetting(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mPhoneAlertStatusServiceMockCallback.addRingerSetting(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder#removeRingerSetting()
         */
        @NonNull
        public Builder<T> removeRingerSetting() {
            mPhoneAlertStatusServiceMockCallback.removeRingerSetting();
            return this;
        }

        /**
         * @see #addRingerControlPoint(byte[])
         */
        @NonNull
        public Builder<T> addRingerControlPoint(@NonNull RingerControlPoint ringerControlPoint) {
            return addRingerControlPoint(ringerControlPoint.getBytes());
        }

        /**
         * @see #addRingerControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRingerControlPoint(@NonNull byte[] value) {
            return addRingerControlPoint(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder#addRingerControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRingerControlPoint(int responseCode, long delay, @NonNull byte[] value) {
            mPhoneAlertStatusServiceMockCallback.addRingerControlPoint(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback.Builder#removeRingerControlPoint()
         */
        @NonNull
        public Builder<T> removeRingerControlPoint() {
            mPhoneAlertStatusServiceMockCallback.removeRingerControlPoint();
            return this;
        }

        /**
         * @return {@link PhoneAlertStatusServiceMockCallback} instance
         */
        public PhoneAlertStatusProfileMockCallback build() {
            return new PhoneAlertStatusProfileMockCallback(mContext
                    , mPhoneAlertStatusServiceMockCallback.build());
        }

    }

    /**
     * @param context                             {@link Context} instance
     * @param phoneAlertStatusServiceMockCallback {@link org.im97mori.ble.service.pass.peripheral.PhoneAlertStatusServiceMockCallback} instance
     */
    public PhoneAlertStatusProfileMockCallback(@NonNull Context context
            , @NonNull PhoneAlertStatusServiceMockCallback phoneAlertStatusServiceMockCallback) {
        super(context, true, phoneAlertStatusServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return PHONE_ALERT_STATUS_SERVICE;
    }

}
