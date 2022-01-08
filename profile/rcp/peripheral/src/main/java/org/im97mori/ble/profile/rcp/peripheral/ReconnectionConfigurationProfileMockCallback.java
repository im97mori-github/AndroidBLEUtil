package org.im97mori.ble.profile.rcp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerCallback;
import org.im97mori.ble.characteristic.u2aa5.BondManagementFeatures;
import org.im97mori.ble.characteristic.u2b1d.RCFeature;
import org.im97mori.ble.characteristic.u2b1e.RCSettings;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.profile.peripheral.AbstractProfileMockCallback;
import org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback;
import org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import static org.im97mori.ble.constants.ServiceUUID.RECONNECTION_CONFIGURATION_SERVICE;

/**
 * Reconnection Configuration Profile for Peripheral
 */
public class ReconnectionConfigurationProfileMockCallback extends AbstractProfileMockCallback {

    /**
     * Builder for {@link ReconnectionConfigurationProfileMockCallback}
     *
     * @param <T> subclass of {@link ReconnectionConfigurationProfileMockCallback}
     */
    public static class Builder<T extends ReconnectionConfigurationProfileMockCallback> {

        /**
         * {@link Context} instance
         */
        protected final Context mContext;

        /**
         * {@link org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder} instance
         */
        protected final ReconnectionConfigurationServiceMockCallback.Builder<? extends ReconnectionConfigurationServiceMockCallback> mReconnectionConfigurationServiceMockCallbackBuilder;

        /**
         * {@link org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback.Builder} instance
         */
        protected final BondManagementServiceMockCallback.Builder<? extends BondManagementServiceMockCallback> mBondManagementServiceMockCallbackBuilder;

        /**
         * flag for Bond Management Servic
         */
        protected boolean mNeedBondManagementService = false;

        /**
         * @param context                                             {@link Context} instance
         * @param reconnectionConfigurationServiceMockCallbackBuilder {@link org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder} instance
         * @param bondManagementServiceMockCallbackBuilder            {@link org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback.Builder} instance
         */
        public Builder(@NonNull Context context
                , @NonNull ReconnectionConfigurationServiceMockCallback.Builder<? extends ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder
                , @Nullable BondManagementServiceMockCallback.Builder<? extends BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder) {
            mContext = context;
            mReconnectionConfigurationServiceMockCallbackBuilder = reconnectionConfigurationServiceMockCallbackBuilder;
            mBondManagementServiceMockCallbackBuilder = bondManagementServiceMockCallbackBuilder;
        }

        /**
         * @see #addRCFeature(byte[])
         */
        @NonNull
        public Builder<T> addRCFeature(@NonNull RCFeature rcFeature) {
            return addRCFeature(rcFeature.getBytes());
        }

        /**
         * @see #addRCFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRCFeature(@NonNull byte[] value) {
            return addRCFeature(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder#addRCFeature(int, long, byte[])
         */
        @NonNull
        public Builder<T> addRCFeature(int responseCode, long delay, @NonNull byte[] value) {
            RCFeature rcFeature = new RCFeature(value);
            mNeedBondManagementService = rcFeature.isRcFeaturesUpgradeToLescOnlySupported() || rcFeature.isRcFeaturesNextPairingOobSupported();
            mReconnectionConfigurationServiceMockCallbackBuilder.addRCFeature(responseCode, delay, value);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder#removeRCFeature()
         */
        @NonNull
        public Builder<T> removeRCFeature() {
            mReconnectionConfigurationServiceMockCallbackBuilder.removeRCFeature();
            mNeedBondManagementService = false;
            return this;
        }

        /**
         * @see #addRCSettings(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRCSettings(@NonNull RCSettings rcSettings, @NonNull ClientCharacteristicConfiguration clientCharacteristicConfiguration) {
            return addRCSettings(true, BluetoothGatt.GATT_SUCCESS, 0, rcSettings.getBytes(), 1, BluetoothGatt.GATT_SUCCESS, 0, clientCharacteristicConfiguration.getBytes());
        }

        /**
         * @see org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder#addRCSettings(boolean, int, long, byte[], int, int, long, byte[])
         */
        @NonNull
        public Builder<T> addRCSettings(boolean isNotificatable
                , int characteristicResponseCode
                , long characteristicDelay
                , @NonNull byte[] characteristicValue
                , int notificationCount
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue) {
            mReconnectionConfigurationServiceMockCallbackBuilder.addRCSettings(isNotificatable, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder#removeRCSettings()
         */
        @NonNull
        public Builder<T> removeRCSettings() {
            mReconnectionConfigurationServiceMockCallbackBuilder.removeRCSettings();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder#addReconnectionConfigurationControlPoint(int, long, int, long, byte[], int, int, int, int, int, int, byte[], int, byte[], int, byte[], int, int, byte[], int, int, int, int, byte[], boolean)
         */
        @NonNull
        public Builder<T> addReconnectionConfigurationControlPoint(int characteristicResponseCode
                , long characteristicDelay
                , int descriptorResponseCode
                , long descriptorDelay
                , @NonNull byte[] descriptorValue
                , int enableDisconnectResultCodes
                , int getActualCommunicationParametersResultCodes
                , int proposeSettingsResultCodes
                , int proposeSettingsError
                , int activateStoredSettingsResultCodes
                , int getMaxValuesResultCodes
                , @NonNull byte[] maxValues
                , int getMinValuesResultCodes
                , @NonNull byte[] minValues
                , int getStoredValuesResultCodes
                , @NonNull byte[] getStoredValuesOperand
                , int setWhiteListTimerResultCodes
                , int getWhiteListTimerResultCodes
                , @NonNull byte[] getWhiteListTimerOperand
                , int setAdvertisementConfigurationResultCodes
                , int upgradeToLescOnlyResultCodes
                , int switchOobPairingResultCodes
                , int limitedAccessResultCodes
                , @NonNull byte[] currentSetting
                , boolean isRcFeaturesE2eCrcSupported) {
            mReconnectionConfigurationServiceMockCallbackBuilder.addReconnectionConfigurationControlPoint(characteristicResponseCode
                    , characteristicDelay
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue
                    , enableDisconnectResultCodes
                    , getActualCommunicationParametersResultCodes
                    , proposeSettingsResultCodes
                    , proposeSettingsError
                    , activateStoredSettingsResultCodes
                    , getMaxValuesResultCodes
                    , maxValues
                    , getMinValuesResultCodes
                    , minValues
                    , getStoredValuesResultCodes
                    , getStoredValuesOperand
                    , setWhiteListTimerResultCodes
                    , getWhiteListTimerResultCodes
                    , getWhiteListTimerOperand
                    , setAdvertisementConfigurationResultCodes
                    , upgradeToLescOnlyResultCodes
                    , switchOobPairingResultCodes
                    , limitedAccessResultCodes
                    , currentSetting
                    , isRcFeaturesE2eCrcSupported);
            return this;
        }

        /**
         * @see org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback.Builder#removeReconnectionConfigurationControlPoint()
         */
        @NonNull
        public Builder<T> removeReconnectionConfigurationControlPoint() {
            mReconnectionConfigurationServiceMockCallbackBuilder.removeReconnectionConfigurationControlPoint();
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback.Builder#addBondManagementControlPoint(long, int, String, int, String, int, String, int, String, int, String, int, String, int, String, int, String, int, String)
         */
        @NonNull
        public Builder<T> addBondManagementControlPoint(long delay
                , int deleteBondOfRequestingDeviceBrEdrLeResponseCode
                , @Nullable String deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , int deleteBondOfRequestingDeviceBrEdrResponseCode
                , @Nullable String deleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , int deleteBondOfRequestingDeviceLeResponseCode
                , @Nullable String deleteBondOfRequestingDeviceLeAuthorizationCode
                , int deleteAllBondsOnServerBrEdrLeResponseCode
                , @Nullable String deleteAllBondsOnServerBrEdrLeAuthorizationCode
                , int deleteAllBondsOnServerBrEdrResponseCode
                , @Nullable String deleteAllBondsOnServerBrEdrAuthorizationCode
                , int deleteAllBondsOnServerLeResponseCode
                , @Nullable String deleteAllBondsOnServerLeAuthorizationCode
                , int deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , @Nullable String deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , int deleteAllButTheActiveBondOnServerBrEdrResponseCode
                , @Nullable String deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , int deleteAllButTheActiveBondOnServerLeResponseCode
                , @Nullable String deleteAllButTheActiveBondOnServerLeAuthorizationCode) {
            if (mBondManagementServiceMockCallbackBuilder != null) {
                mBondManagementServiceMockCallbackBuilder.addBondManagementControlPoint(delay
                        , deleteBondOfRequestingDeviceBrEdrLeResponseCode
                        , deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                        , deleteBondOfRequestingDeviceBrEdrResponseCode
                        , deleteBondOfRequestingDeviceBrEdrAuthorizationCode
                        , deleteBondOfRequestingDeviceLeResponseCode
                        , deleteBondOfRequestingDeviceLeAuthorizationCode
                        , deleteAllBondsOnServerBrEdrLeResponseCode
                        , deleteAllBondsOnServerBrEdrLeAuthorizationCode
                        , deleteAllBondsOnServerBrEdrResponseCode
                        , deleteAllBondsOnServerBrEdrAuthorizationCode
                        , deleteAllBondsOnServerLeResponseCode
                        , deleteAllBondsOnServerLeAuthorizationCode
                        , deleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                        , deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                        , deleteAllButTheActiveBondOnServerBrEdrResponseCode
                        , deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                        , deleteAllButTheActiveBondOnServerLeResponseCode
                        , deleteAllButTheActiveBondOnServerLeAuthorizationCode);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback.Builder#removeBondManagementControlPoint()
         */
        @NonNull
        public Builder<T> removeBondManagementControlPoint() {
            if (mBondManagementServiceMockCallbackBuilder != null) {
                mBondManagementServiceMockCallbackBuilder.removeBondManagementControlPoint();
            }
            return this;
        }

        /**
         * @see #addBondManagementFeatures(byte[])
         */
        @NonNull
        public Builder<T> addBondManagementFeatures(@NonNull BondManagementFeatures bondManagementFeatures) {
            return addBondManagementFeatures(bondManagementFeatures.getBytes());
        }

        /**
         * @see #addBondManagementFeatures(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBondManagementFeatures(@NonNull byte[] value) {
            return addBondManagementFeatures(BluetoothGatt.GATT_SUCCESS, 0, value);
        }

        /**
         * @see org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback.Builder#addBondManagementFeatures(int, long, byte[])
         */
        @NonNull
        public Builder<T> addBondManagementFeatures(int responseCode, long delay, @NonNull byte[] value) {
            if (mBondManagementServiceMockCallbackBuilder != null) {
                mBondManagementServiceMockCallbackBuilder.addBondManagementFeatures(responseCode, delay, value);
            }
            return this;
        }

        /**
         * @see org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback.Builder#removeBondManagementFeatures()
         */
        @NonNull
        public Builder<T> removeBondManagementFeatures() {
            if (mBondManagementServiceMockCallbackBuilder != null) {
                mBondManagementServiceMockCallbackBuilder.removeBondManagementFeatures();
            }
            return this;
        }

        /**
         * @return {@link ReconnectionConfigurationProfileMockCallback} instance
         */
        public ReconnectionConfigurationProfileMockCallback build() {
            if (mNeedBondManagementService && mBondManagementServiceMockCallbackBuilder == null) {
                throw new RuntimeException("no Bond Management Service");
            }
            return new ReconnectionConfigurationProfileMockCallback(mContext, mReconnectionConfigurationServiceMockCallbackBuilder.build()
                    , mBondManagementServiceMockCallbackBuilder == null ? null : mBondManagementServiceMockCallbackBuilder.build());
        }

    }

    /**
     * @param context                                      {@link Context} instance
     * @param reconnectionConfigurationServiceMockCallback {@link ReconnectionConfigurationServiceMockCallback} instance
     * @param bondManagementServiceMockCallback            {@link BondManagementServiceMockCallback} instance
     * @param bleServerCallbacks                           callback array
     */
    public ReconnectionConfigurationProfileMockCallback(@NonNull Context context
            , @NonNull ReconnectionConfigurationServiceMockCallback reconnectionConfigurationServiceMockCallback
            , @Nullable BondManagementServiceMockCallback bondManagementServiceMockCallback
            , @NonNull BLEServerCallback... bleServerCallbacks) {
        super(context
                , true
                , Stream.concat(Arrays.stream(bleServerCallbacks)
                        , Stream.of(reconnectionConfigurationServiceMockCallback, bondManagementServiceMockCallback))
                        .toArray(BLEServerCallback[]::new));
    }

    /**
     * {@inheritDoc}
     */
    @NonNull
    @Override
    public UUID getServiceUUID() {
        return RECONNECTION_CONFIGURATION_SERVICE;
    }

}
