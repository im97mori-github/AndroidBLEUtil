package org.im97mori.ble.profile.hrp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a37.HeartRateMeasurement;
import org.im97mori.ble.characteristic.u2a38.BodySensorLocation;
import org.im97mori.ble.characteristic.u2a39.HeartRateControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.HEART_RATE_SERVICE;

/**
 * Heart Rate Profile for Peripheral
 */
public class HeartRateProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link HeartRateProfileMockCallback}
     *
     * @param <T> subclass of {@link HeartRateProfileMockCallback}
     */
    public static class Builder<T extends HeartRateProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder} instance
         */
        protected final HeartRateServiceMockCallback.Builder<? extends HeartRateServiceMockCallback> mHeartRateServiceMockCallbackBuilder;

        /**
         * flag for Manufacturer Name String data
         */
        protected boolean mHasManufacturerNameString;

        /**
         * @param context                                     {@link Context} instance
         * @param deviceInformationServiceMockCallbackBuilder {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         * @param heartRateProfileMockCallbackBuilder         {@link org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
                , @NonNull HeartRateServiceMockCallback.Builder<? extends HeartRateServiceMockCallback> heartRateProfileMockCallbackBuilder) {
            mContext = context;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
            mHeartRateServiceMockCallbackBuilder = heartRateProfileMockCallbackBuilder;
        }

        /**
         * @see #addManufacturerNameString(ManufacturerNameString)
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull String manufacturerName) {
            mHasManufacturerNameString = true;
            return addManufacturerNameString(new ManufacturerNameString(manufacturerName));
        }

        /**
         * @see #addManufacturerNameString(byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull ManufacturerNameString manufacturerNameString) {
            mHasManufacturerNameString = true;
            return addManufacturerNameString(manufacturerNameString.getBytes());
        }

        /**
         * @see #addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(@NonNull byte[] value) {
            mHasManufacturerNameString = true;
            return addManufacturerNameString(BluetoothGatt.GATT_SUCCESS
                    , 0
                    , value);
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#addManufacturerNameString(int, long, byte[])
         */
        @NonNull
        public Builder<T> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
            mHasManufacturerNameString = true;
            mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responceCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeManufacturerNameString()
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            mHasManufacturerNameString = false;
            mDeviceInformationServiceMockCallbackBuilder.removeManufacturerNameString();
            return this;
        }

        /**
         * @see #addHeartRateMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMeasurement(@NonNull HeartRateMeasurement heartRateMeasurement, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            addHeartRateMeasurement(BluetoothGatt.GATT_SUCCESS, 0, heartRateMeasurement.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder#addHeartRateMeasurement(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateMeasurement(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mHeartRateServiceMockCallbackBuilder.addHeartRateMeasurement(characteristicResponceCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponceCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder#removeHeartRateMeasurement()
         */
        @NonNull
        public Builder<T> removeHeartRateMeasurement() {
            mHeartRateServiceMockCallbackBuilder.removeHeartRateMeasurement();
            return this;
        }

        /**
         * @see #addBodySensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBodySensorLocation(@NonNull BodySensorLocation bodySensorLocation) {
            return addBodySensorLocation(BluetoothGatt.GATT_SUCCESS, 0, bodySensorLocation.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder#addBodySensorLocation(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBodySensorLocation(int responceCode, long delay, @NonNull byte[] value) {
            mHeartRateServiceMockCallbackBuilder.addBodySensorLocation(responceCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder#removeBodySensorLocation()
         */
        @NonNull
        public Builder<T> removeBodySensorLocation() {
            mHeartRateServiceMockCallbackBuilder.removeBodySensorLocation();
            return this;
        }

        /**
         * @see #addHeartRateControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateControlPoint(@NonNull HeartRateControlPoint heartRateControlPoint) {
            return addHeartRateControlPoint(BluetoothGatt.GATT_SUCCESS, 0, heartRateControlPoint.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder#addHeartRateControlPoint(int, long, byte[])
         */
        @NonNull
        public Builder<T> addHeartRateControlPoint(int responceCode, long delay, @NonNull byte[] value) {
            mHeartRateServiceMockCallbackBuilder.addHeartRateControlPoint(responceCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback.Builder#removeHeartRateControlPoint()
         */
        @NonNull
        public Builder<T> removeHeartRateControlPoint() {
            mHeartRateServiceMockCallbackBuilder.removeHeartRateControlPoint();
            return this;
        }

        /**
         * @return {@link HeartRateProfileMockCallback} instance
         */
        public HeartRateProfileMockCallback build() {
            if (!mHasManufacturerNameString) {
                throw new RuntimeException("no Manufacturer Name String data");
            }
            return new HeartRateProfileMockCallback(mContext, mDeviceInformationServiceMockCallbackBuilder.build(), mHeartRateServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                              {@link Context} instance
     * @param deviceInformationServiceMockCallback {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback} instance
     * @param heartRateServiceMockCallback         {@link org.im97mori.ble.service.hrs.peripheral.HeartRateServiceMockCallback} instance
     */
    public HeartRateProfileMockCallback(@NonNull Context context, @NonNull DeviceInformationServiceMockCallback deviceInformationServiceMockCallback, @NonNull HeartRateServiceMockCallback heartRateServiceMockCallback) {
        super(context, true, deviceInformationServiceMockCallback, heartRateServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return HEART_RATE_SERVICE;
    }

}
