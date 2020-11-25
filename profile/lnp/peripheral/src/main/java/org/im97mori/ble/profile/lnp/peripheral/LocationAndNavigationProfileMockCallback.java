package org.im97mori.ble.profile.lnp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.u2a19.BatteryLevel;
import org.im97mori.ble.characteristic.u2a24.ModelNumberString;
import org.im97mori.ble.characteristic.u2a29.ManufacturerNameString;
import org.im97mori.ble.characteristic.u2a67.LocationAndSpeed;
import org.im97mori.ble.characteristic.u2a68.Navigation;
import org.im97mori.ble.characteristic.u2a69.PositionQuality;
import org.im97mori.ble.characteristic.u2a6a.LNFeature;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.descriptor.u2904.CharacteristicPresentationFormat;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback;
import org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback;
import org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback;

import java.util.UUID;

import static org.im97mori.ble.BLEConstants.ServiceUUID.LOCATION_AND_NAVIGATION_SERVICE;

/**
 * Location and Navigation Profile for Peripheral
 */
public class LocationAndNavigationProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link LocationAndNavigationProfileMockCallback}
     *
     * @param <T> subclass of {@link LocationAndNavigationProfileMockCallback}
     */
    public static class Builder<T extends LocationAndNavigationProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         */
        protected final DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> mDeviceInformationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         */
        protected final BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> mBatteryServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback} instance
         */
        protected final LocationAndNavigationServiceMockCallback.Builder<? extends LocationAndNavigationServiceMockCallback> mLocationAndNavigationServiceMockCallbackBuilder;

        /**
         * @param context                                         {@link Context} instance
         * @param deviceInformationServiceMockCallbackBuilder     {@link org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder} instance
         * @param batteryServiceMockCallbackBuilder               {@link org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder} instance
         * @param locationAndNavigationServiceMockCallbackBuilder {@link org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull DeviceInformationServiceMockCallback.Builder<? extends DeviceInformationServiceMockCallback> deviceInformationServiceMockCallbackBuilder
                , @NonNull BatteryServiceMockCallback.Builder<? extends BatteryServiceMockCallback> batteryServiceMockCallbackBuilder
                , @NonNull LocationAndNavigationServiceMockCallback.Builder<? extends LocationAndNavigationServiceMockCallback> locationAndNavigationServiceMockCallbackBuilder) {
            mContext = context;
            mDeviceInformationServiceMockCallbackBuilder = deviceInformationServiceMockCallbackBuilder;
            mBatteryServiceMockCallbackBuilder = batteryServiceMockCallbackBuilder;
            mLocationAndNavigationServiceMockCallbackBuilder = locationAndNavigationServiceMockCallbackBuilder;
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
            mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeManufacturerNameString()
         */
        @NonNull
        public Builder<T> removeManufacturerNameString() {
            mDeviceInformationServiceMockCallbackBuilder.removeManufacturerNameString();
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
            mDeviceInformationServiceMockCallbackBuilder.addModelNumberString(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.dis.peripheral.DeviceInformationServiceMockCallback.Builder#removeModelNumberString()
         */
        @NonNull
        public Builder<T> removeModelNumberString() {
            mDeviceInformationServiceMockCallbackBuilder.removeModelNumberString();
            return this;
        }

        /**
         * @see #addBatteryLevel(int, int, int, long, byte[], int)
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, @NonNull BatteryLevel batteryLevel) {
            return addBatteryLevel(index, BluetoothGattCharacteristic.PROPERTY_READ, BluetoothGatt.GATT_SUCCESS, 0, batteryLevel.getBytes(), -1);
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#addBatteryLevel(int, int, int, long, byte[], int)
         */
        @NonNull
        public Builder<T> addBatteryLevel(int index, int property, int responseCode, long delay, @NonNull byte[] value, int notificationCount) {
            mBatteryServiceMockCallbackBuilder.addBatteryLevel(index, property, responseCode, delay, value, notificationCount);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevel(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevel(int index) {
            mBatteryServiceMockCallbackBuilder.removeBatteryLevel(index);
            return this;
        }

        /**
         * @see #setBatteryLevelCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelCharacteristicPresentationFormat(int index, @NonNull CharacteristicPresentationFormat characteristicPresentationFormat) {
            return setBatteryLevelCharacteristicPresentationFormat(index, BluetoothGatt.GATT_SUCCESS, 0, characteristicPresentationFormat.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#setBatteryLevelCharacteristicPresentationFormat(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelCharacteristicPresentationFormat(int index, int responseCode, long delay, @NonNull byte[] value) {
            mBatteryServiceMockCallbackBuilder.setBatteryLevelCharacteristicPresentationFormat(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevelCharacteristicPresentationFormat(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevelCharacteristicPresentationFormat(int index) {
            mBatteryServiceMockCallbackBuilder.removeBatteryLevelCharacteristicPresentationFormat(index);
            return this;
        }

        /**
         * @see #setBatteryLevelClientCharacteristicConfiguration(int, int, long, byte[])
         */
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return setBatteryLevelClientCharacteristicConfiguration(index, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#setBatteryLevelClientCharacteristicConfiguration(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, int responseCode, long delay, @NonNull byte[] value) {
            mBatteryServiceMockCallbackBuilder.setBatteryLevelClientCharacteristicConfiguration(index, responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevelClientCharacteristicConfiguration(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevelClientCharacteristicConfiguration(int index) {
            mBatteryServiceMockCallbackBuilder.removeBatteryLevelClientCharacteristicConfiguration(index);
            return this;
        }

        /**
         * @see #addLNFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLNFeature(@NonNull LNFeature lnFeature) {
            return addLNFeature(BluetoothGatt.GATT_SUCCESS, 0, lnFeature.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#addLNFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addLNFeature(int responseCode, long delay, @NonNull byte[] value) {
            mLocationAndNavigationServiceMockCallbackBuilder.addLNFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#removeLNFeature()
         */
        @NonNull
        public Builder<T> removeLNFeature() {
            mLocationAndNavigationServiceMockCallbackBuilder.removeLNFeature();
            return this;
        }

        /**
         * @see #addLocationAndSpeed(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocationAndSpeed(@NonNull LocationAndSpeed locationAndSpeed, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addLocationAndSpeed(BluetoothGatt.GATT_SUCCESS, 0, locationAndSpeed.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#addLocationAndSpeed(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLocationAndSpeed(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mLocationAndNavigationServiceMockCallbackBuilder.addLocationAndSpeed(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#removeLocationAndSpeed()
         */
        @NonNull
        public Builder<T> removeLocationAndSpeed() {
            mLocationAndNavigationServiceMockCallbackBuilder.removeLocationAndSpeed();
            return this;
        }

        /**
         * @see #addPositionQuality(int, long, byte[])
         */
        @NonNull
        public Builder<T> addPositionQuality(@NonNull PositionQuality positionQuality) {
            return addPositionQuality(BluetoothGatt.GATT_SUCCESS, 0, positionQuality.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#addPositionQuality(int, long, byte[])
         */
        @NonNull
        public Builder<T> addPositionQuality(int responseCode, long delay, @NonNull byte[] value) {
            mLocationAndNavigationServiceMockCallbackBuilder.addPositionQuality(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#removePositionQuality()
         */
        @NonNull
        public Builder<T> removePositionQuality() {
            mLocationAndNavigationServiceMockCallbackBuilder.removePositionQuality();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#addLNControlPoint(int, long, int, int, int, int, byte[], int, byte[], int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLNControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int setCumulativeValueResponseValue
                , int maskLocationAndSpeedCharacteristicContentResponseValue
                , int navigationControlResponseValue
                , int requestNumberOfRoutesResponseValue
                , @NonNull byte[] requestNumberOfRoutesResponseParameter
                , int requestNameOfRouteResponseValue
                , @NonNull byte[] requestNameOfRouteResponseParameter
                , int selectRouteResponseValue
                , int setFixRateResponseValue
                , int setElevationResponseValue
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mLocationAndNavigationServiceMockCallbackBuilder.addLNControlPoint(characteristicResponseCode
                    , characteristicDelay
                    , setCumulativeValueResponseValue
                    , maskLocationAndSpeedCharacteristicContentResponseValue
                    , navigationControlResponseValue
                    , requestNumberOfRoutesResponseValue
                    , requestNumberOfRoutesResponseParameter
                    , requestNameOfRouteResponseValue
                    , requestNameOfRouteResponseParameter
                    , selectRouteResponseValue
                    , setFixRateResponseValue
                    , setElevationResponseValue
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#removeLNControlPoint()
         */
        @NonNull
        public Builder<T> removeLNControlPoint() {
            mLocationAndNavigationServiceMockCallbackBuilder.removeLNControlPoint();
            return this;
        }

        /**
         * @see #addNavigation(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addNavigation(@NonNull Navigation navigation, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addNavigation(BluetoothGatt.GATT_SUCCESS, 0, navigation.getBytes(), -1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#addNavigation(int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addNavigation(int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mLocationAndNavigationServiceMockCallbackBuilder.addNavigation(characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#removeNavigation()
         */
        @NonNull
        public Builder<T> removeNavigation() {
            mLocationAndNavigationServiceMockCallbackBuilder.removeNavigation();
            return this;
        }

        /**
         * @return {@link LocationAndNavigationProfileMockCallback} instance
         */
        public LocationAndNavigationProfileMockCallback build() {
            return new LocationAndNavigationProfileMockCallback(mContext, mDeviceInformationServiceMockCallbackBuilder.build(), mBatteryServiceMockCallbackBuilder.build(), mLocationAndNavigationServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                                  {@link Context} instance
     * @param deviceInformationServiceMockCallback     {@link DeviceInformationServiceMockCallback} instance
     * @param batteryServiceMockCallback               {@link BatteryServiceMockCallback} instance
     * @param locationAndNavigationServiceMockCallback {@link LocationAndNavigationServiceMockCallback} instance
     */
    public LocationAndNavigationProfileMockCallback(@NonNull Context context
            , @NonNull DeviceInformationServiceMockCallback deviceInformationServiceMockCallback
            , @NonNull BatteryServiceMockCallback batteryServiceMockCallback
            , @NonNull LocationAndNavigationServiceMockCallback locationAndNavigationServiceMockCallback) {
        super(context, true, deviceInformationServiceMockCallback, batteryServiceMockCallback, locationAndNavigationServiceMockCallback);
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return LOCATION_AND_NAVIGATION_SERVICE;
    }

}
