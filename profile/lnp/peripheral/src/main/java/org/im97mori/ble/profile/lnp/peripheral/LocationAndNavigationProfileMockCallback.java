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
        public Builder<T> addManufacturerNameString(int responceCode, long delay, @NonNull byte[] value) {
            mDeviceInformationServiceMockCallbackBuilder.addManufacturerNameString(responceCode, delay, value);
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
        public Builder<T> addModelNumberString(int responceCode, long delay, @NonNull byte[] value) {
            mDeviceInformationServiceMockCallbackBuilder.addModelNumberString(responceCode, delay, value);
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
        public Builder<T> addBatteryLevel(int index, int property, int responceCode, long delay, @NonNull byte[] value, int notificationCount) {
            mBatteryServiceMockCallbackBuilder.addBatteryLevel(index, property, responceCode, delay, value, notificationCount);
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
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeBatteryLevel(int)
         */
        @NonNull
        public Builder<T> setBatteryLevelCharacteristicPresentationFormat(int index, int responceCode, long delay, @NonNull byte[] value) {
            mBatteryServiceMockCallbackBuilder.setCharacteristicPresentationFormat(index, responceCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeCharacteristicPresentationFormat(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevelCharacteristicPresentationFormat(int index) {
            mBatteryServiceMockCallbackBuilder.removeCharacteristicPresentationFormat(index);
            return this;
        }

        /**
         * @see #setBatteryLevelClientCharacteristicConfiguration(int, int, long, byte[])
         */
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return setBatteryLevelClientCharacteristicConfiguration(index, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#setClientCharacteristicConfiguration(int, int, long, byte[])
         */
        @NonNull
        public Builder<T> setBatteryLevelClientCharacteristicConfiguration(int index, int responceCode, long delay, @NonNull byte[] value) {
            mBatteryServiceMockCallbackBuilder.setClientCharacteristicConfiguration(index, responceCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bas.peripheral.BatteryServiceMockCallback.Builder#removeClientCharacteristicConfiguration(int)
         */
        @NonNull
        public Builder<T> removeBatteryLevelClientCharacteristicConfiguration(int index) {
            mBatteryServiceMockCallbackBuilder.removeClientCharacteristicConfiguration(index);
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
        public Builder<T> addLNFeature(int responceCode, long delay, @NonNull byte[] value) {
            mLocationAndNavigationServiceMockCallbackBuilder.addLNFeature(responceCode, delay, value);
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
        public Builder<T> addLocationAndSpeed(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mLocationAndNavigationServiceMockCallbackBuilder.addLocationAndSpeed(characteristicResponceCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponceCode, descriptorDelay, descriptorValue);
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
        public Builder<T> addPositionQuality(int responceCode, long delay, @NonNull byte[] value) {
            mLocationAndNavigationServiceMockCallbackBuilder.addPositionQuality(responceCode, delay, value);
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
         * @see org.im97mori.ble.service.lns.peripheral.LocationAndNavigationServiceMockCallback.Builder#addLNControlPoint(int, long, byte[], int, int, int, int, byte[], int, byte[], int, int, int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addLNControlPoint(int characteristicResponceCode
                , long characteristicDelay
                , @NonNull byte[] characteristicValue
                , int setCumulativeValueResponceValue
                , int maskLocationAndSpeedCharacteristicContentResponceValue
                , int navigationControlResponceValue
                , int requestNumberOfRoutesResponceValue
                , @NonNull byte[] requestNumberOfRoutesResponceParameter
                , int requestNameOfRouteResponceValue
                , @NonNull byte[] requestNameOfRouteResponceParameter
                , int selectRouteResponceValue
                , int setFixRateResponceValue
                , int setElevationResponceValue
                , int descriptorResponceCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mLocationAndNavigationServiceMockCallbackBuilder.addLNControlPoint(characteristicResponceCode
                    , characteristicDelay
                    , characteristicValue
                    , setCumulativeValueResponceValue
                    , maskLocationAndSpeedCharacteristicContentResponceValue
                    , navigationControlResponceValue
                    , requestNumberOfRoutesResponceValue
                    , requestNumberOfRoutesResponceParameter
                    , requestNameOfRouteResponceValue
                    , requestNameOfRouteResponceParameter
                    , selectRouteResponceValue
                    , setFixRateResponceValue
                    , setElevationResponceValue
                    , descriptorResponceCode
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
        public Builder<T> addNavigation(int characteristicResponceCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponceCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
            mLocationAndNavigationServiceMockCallbackBuilder.addNavigation(characteristicResponceCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponceCode, descriptorDelay, descriptorValue);
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
