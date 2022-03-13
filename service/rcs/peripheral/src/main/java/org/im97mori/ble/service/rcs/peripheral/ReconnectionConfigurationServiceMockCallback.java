package org.im97mori.ble.service.rcs.peripheral;

import static org.im97mori.ble.constants.CharacteristicUUID.RC_FEATURE_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RC_SETTINGS_CHARACTERISTIC;
import static org.im97mori.ble.constants.CharacteristicUUID.RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC;
import static org.im97mori.ble.constants.DescriptorUUID.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_80;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_81;
import static org.im97mori.ble.constants.ErrorCode.APPLICATION_ERROR_9F;
import static org.im97mori.ble.constants.ErrorCode.CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattServer;
import android.bluetooth.BluetoothGattService;
import android.bluetooth.le.AdvertiseSettings;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Pair;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.BLEServerConnection;
import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.BLEUtilsAndroid;
import org.im97mori.ble.CharacteristicData;
import org.im97mori.ble.DescriptorData;
import org.im97mori.ble.ServiceData;
import org.im97mori.ble.callback.NotificationData;
import org.im97mori.ble.characteristic.u2b1d.RCFeature;
import org.im97mori.ble.characteristic.u2b1e.RCSettings;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.peripheral.AbstractServiceMockCallback;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Reconnection Configuration Service (Service UUID: 0x1829) for Peripheral
 */
public class ReconnectionConfigurationServiceMockCallback extends AbstractServiceMockCallback {

    /**
     * KEY:CLIENT_PARAMETER_INDICATION
     */
    protected static final String KEY_CLIENT_PARAMETER_INDICATION = "KEY_CLIENT_PARAMETER_INDICATION";

    /**
     * Builder for {@link ReconnectionConfigurationServiceMockCallback}
     *
     * @param <T> subclass of {@link ReconnectionConfigurationServiceMockCallback}
     */
    public static class Builder<T extends ReconnectionConfigurationServiceMockCallback> extends AbstractServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback, ServiceData> {

        /**
         * RC Feature data
         */
        protected CharacteristicData mRCFeatureData;

        /**
         * RC Settings data
         */
        protected CharacteristicData mRCSettingsData;

        /**
         * Reconnection Configuration Control Point data
         */
        protected ReconnectionConfigurationControlPointCharacteristicData mReconnectionConfigurationControlPointData;

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
         * add RC Feature characteristic
         *
         * @param responseCode response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param delay        response delay(millis)
         * @param value        data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> addRCFeature(int responseCode, long delay, @NonNull byte[] value) {
            mRCFeatureData = new CharacteristicData(RC_FEATURE_CHARACTERISTIC
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
         * remove RC Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRCFeature() {
            mRCFeatureData = null;
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
         * add RC Settings characteristic
         *
         * @param isNotificatable            {@code true}:RC Settings is notificatable, {@code false}:not notificatable
         * @param characteristicResponseCode characteristic response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay        characteristic response delay(millis)
         * @param characteristicValue        characteristic data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param notificationCount          RC Settings notification count
         * @param descriptorResponseCode     descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay            descriptor response delay(millis)
         * @param descriptorValue            descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @return {@link Builder} instance
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
            int property = BluetoothGattCharacteristic.PROPERTY_READ;
            List<DescriptorData> descriptorDataList;
            if (isNotificatable) {
                property |= BluetoothGattCharacteristic.PROPERTY_NOTIFY;
                descriptorDataList = Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                        , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                        , descriptorResponseCode
                        , descriptorDelay
                        , descriptorValue));
            } else {
                descriptorDataList = Collections.emptyList();
            }
            mRCSettingsData = new CharacteristicData(RC_SETTINGS_CHARACTERISTIC
                    , property
                    , BluetoothGattCharacteristic.PERMISSION_READ
                    , descriptorDataList
                    , characteristicResponseCode
                    , characteristicDelay
                    , characteristicValue
                    , notificationCount);
            return this;
        }

        /**
         * remove RC Feature characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeRCSettings() {
            mRCSettingsData = null;
            return this;
        }

        /**
         * add Reconnection Configuration Control Point characteristic
         *
         * @param characteristicResponseCode                  response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param characteristicDelay                         characteristic response delay(millis)
         * @param descriptorResponseCode                      descriptor response code for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 3rd parameter
         * @param descriptorDelay                             descriptor response delay(millis)
         * @param descriptorValue                             descriptor data array for {@link android.bluetooth.BluetoothGattServer#sendResponse(BluetoothDevice, int, int, int, byte[])} 5th parameter
         * @param enableDisconnectResultCodes                 characteristic response codes (Enable Disconnect response)
         * @param getActualCommunicationParametersResultCodes characteristic response codes (Get Actual Communication Parameters response), {@code 0}:Client Parameter Indication
         * @param proposeSettingsResultCodes                  characteristic response codes (Propose Settings response)
         * @param proposeSettingsError                        characteristic operand (Propose Setting response)
         * @param activateStoredSettingsResultCodes           characteristic response codes (Activate Stored Settings response)
         * @param getMaxValuesResultCodes                     characteristic response codes (Get Max Values response), {@code 0}:Communication Parameter Response
         * @param maxValues                                   characteristic operand (Get Max Values response)
         * @param getMinValuesResultCodes                     characteristic response codes (Get Min Values response), {@code 0}:Communication Parameter Response
         * @param minValues                                   characteristic operand (Get Min Values response)
         * @param getStoredValuesResultCodes                  characteristic response codes (Get Stored Values response), {@code 0}:Communication Parameter Response
         * @param getStoredValuesOperand                      characteristic operand (Get Stored Values response)
         * @param setWhiteListTimerResultCodes                characteristic response codes (Set White List Timer response)
         * @param getWhiteListTimerResultCodes                characteristic response codes (Get White List Timer response)
         * @param getWhiteListTimerOperand                    characteristic operand (Get White List Timer response), {@code 0}:White List Timer Response
         * @param setAdvertisementConfigurationResultCodes    characteristic response codes (Set Advertisement Configuration response)
         * @param upgradeToLescOnlyResultCodes                characteristic response codes (Upgrade to LESC Only response)
         * @param switchOobPairingResultCodes                 characteristic response codes (Switch OOB Pairing response)
         * @param limitedAccessResultCodes                    characteristic response codes (Limited Access response)
         * @param currentSetting                              current setting
         * @param isRcFeaturesE2eCrcSupported                 crc support flag
         * @return {@link Builder} instance
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
            mReconnectionConfigurationControlPointData = new ReconnectionConfigurationControlPointCharacteristicData(Collections.singletonList(new DescriptorData(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR
                    , BluetoothGattDescriptor.PERMISSION_READ | BluetoothGattDescriptor.PERMISSION_WRITE
                    , descriptorResponseCode
                    , descriptorDelay
                    , descriptorValue))
                    , characteristicResponseCode
                    , characteristicDelay
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
         * remove Reconnection Configuration Control Point characteristic
         *
         * @return {@link Builder} instance
         */
        @NonNull
        public Builder<T> removeReconnectionConfigurationControlPoint() {
            mReconnectionConfigurationControlPointData = null;
            return this;
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ServiceData createData() {
            RCFeature rcFeature;
            if (mRCFeatureData == null) {
                throw new RuntimeException("no RC Feature data");
            } else {
                rcFeature = new RCFeature(mRCFeatureData.getBytes());
                if (rcFeature.isRcFeaturesE2eCrcSupported()
                        && (rcFeature.isE2eCrcNotSupported()
                        || rcFeature.getE2eCrc() != BLEUtils.createCrc(rcFeature.getRcFeatures(), 0, rcFeature.getRcFeatures().length))) {
                    throw new RuntimeException("RC Feature CRC not matched");
                }
            }

            if (mRCSettingsData == null) {
                if (rcFeature.isRcFeaturesReadyForDisconnectSupported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration1Supported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration2Supported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration3Supported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration4Supported()
                        || rcFeature.isRcFeaturesUpgradeToLescOnlySupported()
                        || rcFeature.isRcFeaturesNextPairingOobSupported()
                        || rcFeature.isRcFeaturesLimitedAccessSupported()) {
                    throw new RuntimeException("no RC Settings data");
                }
            } else {
                if (rcFeature.isRcFeaturesReadyForDisconnectNotSupported()
                        && rcFeature.isRcFeaturesUpgradeToLescOnlyNotSupported()
                        && rcFeature.isRcFeaturesNextPairingOobNotSupported()
                        && rcFeature.isRcFeaturesLimitedAccessNotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration1NotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration2NotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration3NotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration4NotSupported()) {
                    throw new RuntimeException("RC Settings not supported");
                }

                if (rcFeature.isRcFeaturesEnableDisconnectSupported()) {
                    if (mRCSettingsData.descriptorDataList.isEmpty()
                            || (mRCSettingsData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) == 0) {
                        throw new RuntimeException("no RC Settings Client Characteristic Descriptor data");
                    }
                } else {
                    if (!mRCSettingsData.descriptorDataList.isEmpty()
                            || (mRCSettingsData.property & BluetoothGattCharacteristic.PROPERTY_NOTIFY) != 0) {
                        throw new RuntimeException("RC Settings notification not supported");
                    }
                }

                RCSettings rcSettings = new RCSettings(mRCSettingsData.getBytes());
                if (rcFeature.isRcFeaturesE2eCrcSupported()
                        && (rcSettings.getLength() != 5
                        || rcSettings.getE2eCrc() != BLEUtils.createCrc(rcSettings.getBytes(), 0, 3))) {
                    throw new RuntimeException("RC Settings CRC not matched");
                }

                if (rcFeature.isRcFeaturesUpgradeToLescOnlyNotSupported()
                        && rcSettings.isSettingsLescOnlyTrue()) {
                    throw new RuntimeException("Upgrade to LESC Only not Supported");
                } else if (rcFeature.isRcFeaturesNextPairingOobNotSupported()
                        && rcSettings.isSettingsUseOobPairingTrue()) {
                    throw new RuntimeException("Next Pairing OOB not Supported");
                } else if (rcFeature.isRcFeaturesReadyForDisconnectNotSupported()
                        && rcSettings.isSettingsReadyForDisconnectTrue()) {
                    throw new RuntimeException("Ready for Disconnect not Supported");
                } else if (rcFeature.isRcFeaturesLimitedAccessNotSupported()
                        && rcSettings.isSettingsLimitedAccessTrue()) {
                    throw new RuntimeException("Limited Access Supported");
                } else {
                    if (rcFeature.isRcFeaturesAdvertisementConfiguration1NotSupported()) {
                        if (rcSettings.isSettingsAdvertisementConfiguration1()) {
                            throw new RuntimeException("Advertisement Configuration 1 not Supported");
                        }
                    }
                    if (rcFeature.isRcFeaturesAdvertisementConfiguration2NotSupported()) {
                        if (rcSettings.isSettingsAdvertisementConfiguration2()) {
                            throw new RuntimeException("Advertisement Configuration 2 not Supported");
                        }
                    }
                    if (rcFeature.isRcFeaturesAdvertisementConfiguration3NotSupported()) {
                        if (rcSettings.isSettingsAdvertisementConfiguration3()) {
                            throw new RuntimeException("Advertisement Configuration 3 not Supported");
                        }
                    }
                    if (rcFeature.isRcFeaturesAdvertisementConfiguration4NotSupported()) {
                        if (rcSettings.isSettingsAdvertisementConfiguration4()) {
                            throw new RuntimeException("Advertisement Configuration 4 not Supported");
                        }
                    }
                }
            }

            if (mReconnectionConfigurationControlPointData == null) {
                if (rcFeature.isRcFeaturesEnableDisconnectSupported()
                        || rcFeature.isRcFeaturesProposeReconnectionTimeoutSupported()
                        || rcFeature.isRcFeaturesProposeConnectionIntervalSupported()
                        || rcFeature.isRcFeaturesProposeAdvertisementCountSupported()
                        || rcFeature.isRcFeaturesProposeSupervisionTimeoutSupported()
                        || rcFeature.isRcFeaturesProposeAdvertisementIntervalSupported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration1Supported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration2Supported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration3Supported()
                        || rcFeature.isRcFeaturesAdvertisementConfiguration4Supported()
                        || rcFeature.isRcFeaturesUpgradeToLescOnlySupported()
                        || rcFeature.isRcFeaturesNextPairingOobSupported()
                        || rcFeature.isRcFeaturesUseOfWhiteListSupported()
                        || rcFeature.isRcFeaturesLimitedAccessSupported()) {
                    throw new RuntimeException("no Reconnection Configuration Control Point data");
                }
            } else {
                if (rcFeature.isRcFeaturesEnableDisconnectNotSupported()
                        && rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration1NotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration2NotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration3NotSupported()
                        && rcFeature.isRcFeaturesAdvertisementConfiguration4NotSupported()
                        && rcFeature.isRcFeaturesUpgradeToLescOnlyNotSupported()
                        && rcFeature.isRcFeaturesNextPairingOobNotSupported()
                        && rcFeature.isRcFeaturesUseOfWhiteListNotSupported()
                        && rcFeature.isRcFeaturesLimitedAccessNotSupported()) {
                    throw new RuntimeException("Reconnection Configuration Control Point not supported");
                }

                int maxReconnectionTimeout = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 0);
                int maxMinimumConnectionInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 2);
                int maxMaximumConnectionInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 4);
                int maxSlaveLatency = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 6);
                int maxSupervisionTimeoutMultiplier = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 8);
                int maxAdvertisementInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 10);
                int maxAdvertisementCount = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 12);
                int maxAdvertisementRepetitionTime = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.maxValues, 14);

                if (maxReconnectionTimeout != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxReconnectionTimeout < 0 || maxReconnectionTimeout > 20000)) {
                    throw new RuntimeException("Reconnection Timeout is Out of Range");
                } else if (maxMinimumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxMinimumConnectionInterval < 0x0006 || maxMinimumConnectionInterval > 0x0c80)) {
                    throw new RuntimeException("Minimum Connection Interval is Out of Range");
                } else if (maxMaximumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxMaximumConnectionInterval < 0x0006 || maxMaximumConnectionInterval > 0x0c80)) {
                    throw new RuntimeException("Maximum Connection Interval is Out of Range");
                } else if (maxSlaveLatency != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxSlaveLatency < 0 || maxSlaveLatency > 499)) {
                    throw new RuntimeException("Slave Latency is Out of Range");
                } else if (maxSupervisionTimeoutMultiplier != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxSupervisionTimeoutMultiplier < 10 || maxSupervisionTimeoutMultiplier > 3200)) {
                    throw new RuntimeException("Supervision Timeout multiplier is Out of Range");
                } else if (maxAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxAdvertisementInterval < 0x0020 || maxAdvertisementInterval > 0x4000)) {
                    throw new RuntimeException("Advertisement Interval is Out of Range");
                } else if (maxAdvertisementCount != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxAdvertisementCount < 1 || maxAdvertisementCount > 1000)) {
                    throw new RuntimeException("Advertisement Count is Out of Range");
                } else if (maxAdvertisementRepetitionTime != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (maxAdvertisementRepetitionTime < 0 || maxAdvertisementRepetitionTime > 10000)) {
                    throw new RuntimeException("Advertisement Repetition Time is Out of Range");
                }

                int minReconnectionTimeout = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 0);
                int minMinimumConnectionInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 2);
                int minMaximumConnectionInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 4);
                int minSlaveLatency = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 6);
                int minSupervisionTimeoutMultiplier = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 8);
                int minAdvertisementInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 10);
                int minAdvertisementCount = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 12);
                int minAdvertisementRepetitionTime = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.minValues, 14);

                if (minReconnectionTimeout != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minReconnectionTimeout < 0 || minReconnectionTimeout > 20000)) {
                    throw new RuntimeException("Reconnection Timeout is Out of Range");
                } else if (minMinimumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minMinimumConnectionInterval < 0x0006 || minMinimumConnectionInterval > 0x0c80)) {
                    throw new RuntimeException("Minimum Connection Interval is Out of Range");
                } else if (minMaximumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minMaximumConnectionInterval < 0x0006 || minMaximumConnectionInterval > 0x0c80)) {
                    throw new RuntimeException("Maximum Connection Interval is Out of Range");
                } else if (minSlaveLatency != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minSlaveLatency < 0 || minSlaveLatency > 499)) {
                    throw new RuntimeException("Slave Latency is Out of Range");
                } else if (minSupervisionTimeoutMultiplier != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minSupervisionTimeoutMultiplier < 10 || minSupervisionTimeoutMultiplier > 3200)) {
                    throw new RuntimeException("Supervision Timeout multiplier is Out of Range");
                } else if (minAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minAdvertisementInterval < 0x0020 || minAdvertisementInterval > 0x4000)) {
                    throw new RuntimeException("Advertisement Interval is Out of Range");
                } else if (minAdvertisementCount != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minAdvertisementCount < 1 || minAdvertisementCount > 1000)) {
                    throw new RuntimeException("Advertisement Count is Out of Range");
                } else if (minAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minAdvertisementRepetitionTime < 0 || minAdvertisementRepetitionTime > 10000)) {
                    throw new RuntimeException("Advertisement Repetition Time is Out of Range");
                }

                if ((maxReconnectionTimeout == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minReconnectionTimeout != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxReconnectionTimeout != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minReconnectionTimeout == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Reconnection Timeout is Out of Range");
                } else if ((maxMinimumConnectionInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minMinimumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxMinimumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minMinimumConnectionInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Minimum Connection Interval is Out of Range");
                } else if ((maxMaximumConnectionInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minMaximumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxMaximumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minMaximumConnectionInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Maximum Connection Interval is Out of Range");
                } else if ((maxSlaveLatency == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minSlaveLatency != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxSlaveLatency != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minSlaveLatency == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Slave Latency is Out of Range");
                } else if ((maxSupervisionTimeoutMultiplier == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minSupervisionTimeoutMultiplier != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxSupervisionTimeoutMultiplier != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minSupervisionTimeoutMultiplier == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Supervision Timeout multiplier is Out of Range");
                } else if ((maxAdvertisementInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minAdvertisementInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Advertisement Interval is Out of Range");
                } else if ((maxAdvertisementCount == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minAdvertisementCount != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxAdvertisementCount != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minAdvertisementCount == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Advertisement Count is Out of Range");
                } else if ((maxAdvertisementRepetitionTime == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minAdvertisementRepetitionTime != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)
                        || (maxAdvertisementRepetitionTime != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && minAdvertisementRepetitionTime == ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED)) {
                    throw new RuntimeException("Advertisement Repetition Time is Out of Range");
                }

                int currentReconnectionTimeout = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 0);
                int currentMinimumConnectionInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 2);
                int currentMaximumConnectionInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 4);
                int currentSlaveLatency = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 6);
                int currentSupervisionTimeoutMultiplier = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 8);
                int currentAdvertisementInterval = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 10);
                int currentAdvertisementCount = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 12);
                int currentAdvertisementRepetitionTime = BLEUtils.createUInt16(mReconnectionConfigurationControlPointData.currentSetting, 14);

                if (maxReconnectionTimeout != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minReconnectionTimeout > currentReconnectionTimeout || maxReconnectionTimeout < currentReconnectionTimeout)) {
                    throw new RuntimeException("Reconnection Timeout is Out of Range");
                } else if (maxMinimumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minMinimumConnectionInterval > currentMinimumConnectionInterval || maxMinimumConnectionInterval < currentMinimumConnectionInterval)) {
                    throw new RuntimeException("Minimum Connection Interval is Out of Range");
                } else if (maxMaximumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minMaximumConnectionInterval > currentMaximumConnectionInterval || maxMaximumConnectionInterval < currentMaximumConnectionInterval)) {
                    throw new RuntimeException("Maximum Connection Interval is Out of Range");
                } else if (maxSlaveLatency != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minSlaveLatency > currentSlaveLatency || maxSlaveLatency < currentSlaveLatency)) {
                    throw new RuntimeException("Slave Latency is Out of Range");
                } else if (maxSupervisionTimeoutMultiplier != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minSupervisionTimeoutMultiplier > currentSupervisionTimeoutMultiplier || maxSupervisionTimeoutMultiplier < currentSupervisionTimeoutMultiplier)) {
                    throw new RuntimeException("Supervision Timeout multiplier is Out of Range");
                } else if (maxAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minAdvertisementInterval > currentAdvertisementInterval || maxAdvertisementInterval < currentAdvertisementInterval)) {
                    throw new RuntimeException("Advertisement Interval is Out of Range");
                } else if (maxAdvertisementCount != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minAdvertisementCount > currentAdvertisementCount || maxAdvertisementCount < currentAdvertisementCount)) {
                    throw new RuntimeException("Advertisement Count is Out of Range");
                } else if (maxAdvertisementRepetitionTime != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                        && (minAdvertisementRepetitionTime > currentAdvertisementRepetitionTime || maxAdvertisementRepetitionTime < currentAdvertisementRepetitionTime)) {
                    throw new RuntimeException("Advertisement Repetition Time is Out of Range");
                }

                long currentWhiteListTimer = BLEUtils.createUInt32(mReconnectionConfigurationControlPointData.getWhiteListTimerOperand, 0);
                long minWhiteListTimer = BLEUtils.createUInt32(mReconnectionConfigurationControlPointData.getWhiteListTimerOperand, 4);
                long maxWhiteListTimer = BLEUtils.createUInt32(mReconnectionConfigurationControlPointData.getWhiteListTimerOperand, 8);

                if (currentWhiteListTimer != ReconnectionConfigurationControlPoint.WHITE_LIST_DISABLED
                        && currentWhiteListTimer != ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                        && (currentWhiteListTimer < minWhiteListTimer || currentWhiteListTimer > maxWhiteListTimer)) {
                    throw new RuntimeException("White List Timer is Out of Range");
                }
            }

            return new ReconnectionConfigurationServiceData(mRCFeatureData
                    , mRCSettingsData
                    , mReconnectionConfigurationControlPointData);
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ReconnectionConfigurationServiceMockCallback build() {
            return new ReconnectionConfigurationServiceMockCallback(createData(), false);
        }

    }

    /**
     * @param serviceData {@link ServiceData} instance
     * @param isFallback  fallback flag
     */
    public ReconnectionConfigurationServiceMockCallback(@NonNull ServiceData serviceData, boolean isFallback) {
        super(serviceData, isFallback);
    }

    /**
     * create data with E2E-CRC
     *
     * @param isCrcSupported  {@code true}:add E2E-CRC, {@code false}:no E2E-CRC
     * @param operand         Operand
     * @param requestOpcodes  Request Opcode
     * @param resultCode      Result Codes
     * @param resultParameter Result Parameter
     * @return data with E2E-CRC
     */
    @NonNull
    protected byte[] createDataWithCrc(boolean isCrcSupported
            , @NonNull byte[] operand
            , int requestOpcodes
            , int resultCode
            , @NonNull byte[] resultParameter) {
        byte[] responseValue = new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_PROCEDURE_RESPONSE
                , operand
                , null
                , requestOpcodes
                , resultCode
                , resultParameter).getBytes();
        if (isCrcSupported) {
            ByteBuffer byteBuffer = ByteBuffer.allocate(responseValue.length + 2).order(ByteOrder.LITTLE_ENDIAN);
            byteBuffer.put(responseValue);
            byteBuffer.putShort((short) BLEUtils.createCrc(responseValue, 0, responseValue.length));
            responseValue = byteBuffer.array();
        }
        return responseValue;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressLint("MissingPermission")
    @Override
    public synchronized boolean onCharacteristicWriteRequest(@NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , int requestId
            , @NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic
            , boolean preparedWrite
            , boolean responseNeeded
            , int offset
            , @NonNull byte[] value
            , boolean force) {
        boolean result = false;
        BluetoothGattServer bluetoothGattServer = bleServerConnection.getBluetoothGattServer();

        if (bluetoothGattServer != null) {
            long now = SystemClock.elapsedRealtime();
            BluetoothGattService bluetoothGattService = bluetoothGattCharacteristic.getService();
            UUID serviceUUID = bluetoothGattService.getUuid();
            int serviceInstanceId = bluetoothGattService.getInstanceId();
            Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
            if (characteristicMap == null) {
                if (force && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            } else {
                UUID characteristicUUID = bluetoothGattCharacteristic.getUuid();
                int characteristicInstanceId = bluetoothGattCharacteristic.getInstanceId();
                CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
                if (characteristicData != null) {
                    delay(now, characteristicData.delay);

                    if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID)) {
                        int responseCode = CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR_IMPROPERLY_CONFIGURED;

                        Map<Pair<UUID, Integer>, DescriptorData> descriptorDataMap = mRemappedCharacteristicDescriptorMap.get(Pair.create(RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC, characteristicInstanceId));
                        if (characteristicData instanceof ReconnectionConfigurationControlPointCharacteristicData && descriptorDataMap != null) {
                            for (Map.Entry<Pair<UUID, Integer>, DescriptorData> descriptorDataEntry : descriptorDataMap.entrySet()) {
                                if (CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR.equals(descriptorDataEntry.getKey().first)) {
                                    if (Arrays.equals(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE, descriptorDataEntry.getValue().getBytes())) {
                                        byte[] valueWithOffset = Arrays.copyOfRange(value, offset, value.length);
                                        ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData = (ReconnectionConfigurationControlPointCharacteristicData) characteristicData;
                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = null;

                                        RCFeature rcFeature = null;
                                        CharacteristicData rcFeatureCharacteristicData = findCharacteristicData(characteristicMap, RC_FEATURE_CHARACTERISTIC, CharacteristicData.class);
                                        if (rcFeatureCharacteristicData != null) {
                                            rcFeature = new RCFeature(rcFeatureCharacteristicData.getBytes());
                                        }

                                        ReconnectionConfigurationControlPoint requestReconnectionConfigurationControlPoint = new ReconnectionConfigurationControlPoint(valueWithOffset);

                                        if (rcFeature == null) {
                                            responseCode = APPLICATION_ERROR_9F;
                                        } else if (rcFeature.isRcFeaturesE2eCrcSupported()) {
                                            Integer requestCrc = requestReconnectionConfigurationControlPoint.getE2eCrc();
                                            if (requestCrc == null) {
                                                responseCode = APPLICATION_ERROR_80;
                                            } else {
                                                if (valueWithOffset.length > 2) {
                                                    int calculatedCrc = BLEUtils.createCrc(valueWithOffset, 0, valueWithOffset.length - 2);
                                                    if (requestCrc == calculatedCrc) {
                                                        responseCode = reconnectionConfigurationControlPointCharacteristicData.responseCode;
                                                    } else {
                                                        responseCode = APPLICATION_ERROR_81;
                                                    }
                                                } else {
                                                    responseCode = APPLICATION_ERROR_9F;
                                                }
                                            }
                                        } else {
                                            responseCode = reconnectionConfigurationControlPointCharacteristicData.responseCode;
                                        }

                                        boolean additionalClientParameterIndication = false;
                                        if (BluetoothGatt.GATT_SUCCESS == responseCode) {
                                            if (requestReconnectionConfigurationControlPoint.isOpcodeEnableDisconnect(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesEnableDisconnectNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_ENABLE_DISCONNECT
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeGetActualCommunicationParameters(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else if (reconnectionConfigurationControlPointCharacteristicData.getActualCommunicationParametersResultCodes != 0) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_ACTUAL_COMMUNICATION_PARAMETERS
                                                            , reconnectionConfigurationControlPointCharacteristicData.getActualCommunicationParametersResultCodes
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeProposeSettings(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else {
                                                    int maxReconnectionTimeout = rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 0);
                                                    int maxMinimumConnectionInterval = rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 2);
                                                    int maxMaximumConnectionInterval = rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 4);
                                                    int maxSlaveLatency = rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 6);
                                                    int maxSupervisionTimeoutMultiplier = rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 8);
                                                    int maxAdvertisementInterval = rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 10);
                                                    int maxAdvertisementCount = rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 12);
                                                    int maxAdvertisementRepetitionTime = rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.maxValues, 14);

                                                    int minReconnectionTimeout = rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 0);
                                                    int minMinimumConnectionInterval = rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 2);
                                                    int minMaximumConnectionInterval = rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 4);
                                                    int minSlaveLatency = rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 6);
                                                    int minSupervisionTimeoutMultiplier = rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 8);
                                                    int minAdvertisementInterval = rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 10);
                                                    int minAdvertisementCount = rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 12);
                                                    int minAdvertisementRepetitionTime = rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()
                                                            ? ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED
                                                            : BLEUtils.createUInt16(reconnectionConfigurationControlPointCharacteristicData.minValues, 14);

                                                    int requestReconnectionTimeout = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 0);
                                                    int requestMinimumConnectionInterval = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 2);
                                                    int requestMaximumConnectionInterval = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 4);
                                                    int requestSlaveLatency = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 6);
                                                    int requestSupervisionTimeoutMultiplier = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 8);
                                                    int requestAdvertisementInterval = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 10);
                                                    int requestAdvertisementCount = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 12);
                                                    int requestAdvertisementRepetitionTime = BLEUtils.createUInt16(requestReconnectionConfigurationControlPoint.getOperand(), 14);

                                                    byte[] newData = new byte[16];
                                                    ByteBuffer byteBuffer = ByteBuffer.wrap(newData).order(ByteOrder.LITTLE_ENDIAN);

                                                    boolean isAdvertisingParameterChanged = false;
                                                    boolean isConnectionParameterChanged = false;
                                                    int outOfRangeResult = ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS;

                                                    if (maxReconnectionTimeout != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestReconnectionTimeout == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 0, 2);
                                                        } else {
                                                            if (requestReconnectionTimeout > maxReconnectionTimeout || requestReconnectionTimeout < minReconnectionTimeout) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_0_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestReconnectionTimeout);
                                                                isAdvertisingParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (maxMinimumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestMinimumConnectionInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 4, 2);
                                                        } else {
                                                            if (requestMinimumConnectionInterval > maxMinimumConnectionInterval || requestMinimumConnectionInterval < minMinimumConnectionInterval) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_1_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestMinimumConnectionInterval);
                                                                isConnectionParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (maxMaximumConnectionInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestMaximumConnectionInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 4, 2);
                                                        } else {
                                                            if (requestMaximumConnectionInterval > maxMaximumConnectionInterval || requestMaximumConnectionInterval < minMaximumConnectionInterval) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_2_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestMaximumConnectionInterval);
                                                                isConnectionParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if ((outOfRangeResult & ReconnectionConfigurationControlPoint.FIELD_NO_1_FAILED) != 0) {
                                                        outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_2_FAILED;
                                                    } else if ((outOfRangeResult & ReconnectionConfigurationControlPoint.FIELD_NO_2_FAILED) != 0) {
                                                        outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_1_FAILED;
                                                    }

                                                    if (maxSlaveLatency != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestSlaveLatency == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 6, 2);
                                                        } else {
                                                            if (requestSlaveLatency > maxSlaveLatency || requestSlaveLatency < minSlaveLatency) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_3_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestSlaveLatency);
                                                                isConnectionParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (maxSupervisionTimeoutMultiplier != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestSupervisionTimeoutMultiplier == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 8, 2);
                                                        } else {
                                                            if (requestSupervisionTimeoutMultiplier > maxSupervisionTimeoutMultiplier || requestSupervisionTimeoutMultiplier < minSupervisionTimeoutMultiplier) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_4_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestSupervisionTimeoutMultiplier);
                                                                isConnectionParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (maxAdvertisementInterval != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestAdvertisementInterval == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 10, 2);
                                                        } else {
                                                            if (requestAdvertisementInterval > maxAdvertisementInterval || requestAdvertisementInterval < minAdvertisementInterval) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_5_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestAdvertisementInterval);
                                                                isAdvertisingParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (maxAdvertisementCount != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestAdvertisementCount == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 12, 2);
                                                        } else {
                                                            if (requestAdvertisementCount > maxAdvertisementCount || requestAdvertisementCount < minAdvertisementCount) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_6_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestAdvertisementCount);
                                                                isAdvertisingParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (maxAdvertisementRepetitionTime != ReconnectionConfigurationControlPoint.PARAMETER_NOT_SUPPORTED) {
                                                        if (requestAdvertisementRepetitionTime == ReconnectionConfigurationControlPoint.PARAMETER_NOT_BE_CHANGED) {
                                                            byteBuffer.put(reconnectionConfigurationControlPointCharacteristicData.currentSetting, 14, 2);
                                                        } else {
                                                            if (requestAdvertisementRepetitionTime > maxAdvertisementRepetitionTime || requestAdvertisementRepetitionTime < minAdvertisementRepetitionTime) {
                                                                outOfRangeResult |= ReconnectionConfigurationControlPoint.FIELD_NO_7_FAILED;
                                                            } else {
                                                                byteBuffer.putShort((short) requestAdvertisementRepetitionTime);
                                                                isAdvertisingParameterChanged = true;
                                                            }
                                                        }
                                                    }

                                                    if (outOfRangeResult != (ReconnectionConfigurationControlPoint.FIELD_NO_0_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_1_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_2_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_3_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_4_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_5_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_6_SUCCESS
                                                            | ReconnectionConfigurationControlPoint.FIELD_NO_7_SUCCESS)) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_COMMUNICATION_PARAMETER_OUT_OF_RANGE
                                                                , new byte[]{(byte) outOfRangeResult});
                                                    } else if (isConnectionParameterChanged) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED
                                                                , new byte[0]);
                                                        reconnectionConfigurationControlPointCharacteristicData.currentSetting = newData;
                                                        additionalClientParameterIndication = true;
                                                    } else if (isAdvertisingParameterChanged) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_PROPOSE_SETTINGS
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS
                                                                , new byte[0]);
                                                        reconnectionConfigurationControlPointCharacteristicData.currentSetting = newData;
                                                    } else if (ReconnectionConfigurationControlPoint.RESULT_CODE_SUCCESS == reconnectionConfigurationControlPointCharacteristicData.activateStoredSettingsResultCodes) {
                                                        reconnectionConfigurationControlPointCharacteristicData.currentSetting = newData;
                                                    } else if (ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED == reconnectionConfigurationControlPointCharacteristicData.activateStoredSettingsResultCodes) {
                                                        reconnectionConfigurationControlPointCharacteristicData.currentSetting = newData;
                                                        additionalClientParameterIndication = true;
                                                    }
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeActivateStoredSettings(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_ACTIVATE_STORED_SETTINGS
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else if (ReconnectionConfigurationControlPoint.RESULT_CODE_PROPOSAL_ACCEPTED == reconnectionConfigurationControlPointCharacteristicData.activateStoredSettingsResultCodes) {
                                                    additionalClientParameterIndication = true;
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeGetMaxValues(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else if (reconnectionConfigurationControlPointCharacteristicData.getMaxValuesResultCodes != 0) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_MAX_VALUES
                                                            , reconnectionConfigurationControlPointCharacteristicData.getMaxValuesResultCodes
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeGetMinValues(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else if (reconnectionConfigurationControlPointCharacteristicData.getMinValuesResultCodes != 0) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_MIN_VALUES
                                                            , reconnectionConfigurationControlPointCharacteristicData.getMinValuesResultCodes
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeGetStoredValues(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesProposeReconnectionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeConnectionIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSlaveLatencyNotSupported()
                                                        && rcFeature.isRcFeaturesProposeSupervisionTimeoutNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementIntervalNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementCountNotSupported()
                                                        && rcFeature.isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else if (reconnectionConfigurationControlPointCharacteristicData.getStoredValuesResultCodes != 0) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_STORED_VALUES
                                                            , reconnectionConfigurationControlPointCharacteristicData.getStoredValuesResultCodes
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeSetWhiteListTimer(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesUseOfWhiteListNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_SET_WHITE_LIST_TIMER
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeGetWhiteListTimer(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesUseOfWhiteListNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else if (reconnectionConfigurationControlPointCharacteristicData.getWhiteListTimerResultCodes != 0) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_GET_WHITE_LIST_TIMER
                                                            , reconnectionConfigurationControlPointCharacteristicData.getWhiteListTimerResultCodes
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeSetAdvertisementConfiguration(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesAdvertisementConfiguration1NotSupported()
                                                        && rcFeature.isRcFeaturesAdvertisementConfiguration2NotSupported()
                                                        && rcFeature.isRcFeaturesAdvertisementConfiguration3NotSupported()
                                                        && rcFeature.isRcFeaturesAdvertisementConfiguration4NotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                } else {
                                                    int requestAdvertisementConfiguration = BLEUtils.createUInt8(requestReconnectionConfigurationControlPoint.getOperand(), 0);
                                                    if (ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_1 == requestAdvertisementConfiguration
                                                            && rcFeature.isRcFeaturesAdvertisementConfiguration1NotSupported()) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND
                                                                , new byte[0]);
                                                    } else if (ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_2 == requestAdvertisementConfiguration
                                                            && rcFeature.isRcFeaturesAdvertisementConfiguration2NotSupported()) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND
                                                                , new byte[0]);
                                                    } else if (ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_3 == requestAdvertisementConfiguration
                                                            && rcFeature.isRcFeaturesAdvertisementConfiguration3NotSupported()) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND
                                                                , new byte[0]);
                                                    } else if (ReconnectionConfigurationControlPoint.ADVERTISEMENT_CONFIGURATION_4 == requestAdvertisementConfiguration
                                                            && rcFeature.isRcFeaturesAdvertisementConfiguration4NotSupported()) {
                                                        reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                                , new byte[0]
                                                                , ReconnectionConfigurationControlPoint.OPCODE_SET_ADVERTISEMENT_CONFIGURATION
                                                                , ReconnectionConfigurationControlPoint.RESULT_CODE_INVALID_OPERAND
                                                                , new byte[0]);
                                                    }
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeUpgradeToLescOnly(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesUpgradeToLescOnlyNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_UPGRADE_TO_LESC_ONLY
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeSwitchOobPairing(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesNextPairingOobSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_SWITCH_OOB_PAIRING
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                }
                                            } else if (requestReconnectionConfigurationControlPoint.isOpcodeLimitedAccess(requestReconnectionConfigurationControlPoint.getOpcode())) {
                                                if (rcFeature.isRcFeaturesLimitedAccessNotSupported()) {
                                                    reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                            , new byte[0]
                                                            , ReconnectionConfigurationControlPoint.OPCODE_LIMITED_ACCESS
                                                            , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                            , new byte[0]);
                                                }
                                            } else {
                                                reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData = createDataWithCrc(rcFeature.isRcFeaturesE2eCrcSupported()
                                                        , new byte[0]
                                                        , requestReconnectionConfigurationControlPoint.getOpcode()
                                                        , ReconnectionConfigurationControlPoint.RESULT_CODE_OPCODE_NOT_SUPPORTED
                                                        , new byte[0]);
                                            }
                                        }

                                        result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);

                                        if (result && BluetoothGatt.GATT_SUCCESS == responseCode) {
                                            characteristicData.currentData = valueWithOffset;

                                            BluetoothGattDescriptor bluetoothGattDescriptor = bluetoothGattCharacteristic.getDescriptor(CLIENT_CHARACTERISTIC_CONFIGURATION_DESCRIPTOR);
                                            if (bluetoothGattDescriptor != null) {
                                                int descriptorInstanceId = BLEUtilsAndroid.getDescriptorInstanceId(bluetoothGattDescriptor);

                                                Bundle argument = null;
                                                if (additionalClientParameterIndication) {
                                                    argument = new Bundle();
                                                    argument.putBoolean(KEY_CLIENT_PARAMETER_INDICATION, true);
                                                }
                                                startNotification(null
                                                        , bleServerConnection
                                                        , null
                                                        , serviceUUID
                                                        , serviceInstanceId
                                                        , characteristicUUID
                                                        , characteristicInstanceId
                                                        , descriptorInstanceId
                                                        , characteristicData.delay
                                                        , 1
                                                        , argument);
                                            }
                                        }
                                    } else {
                                        result = bluetoothGattServer.sendResponse(device, requestId, responseCode, offset, preparedWrite ? value : null);
                                    }

                                    break;
                                }
                            }
                        }
                    } else {
                        if (responseNeeded) {
                            result = bluetoothGattServer.sendResponse(device, requestId, characteristicData.responseCode, offset, preparedWrite ? value : null);
                        } else {
                            result = true;
                        }

                        if (result && BluetoothGatt.GATT_SUCCESS == characteristicData.responseCode) {
                            mIsReliable |= preparedWrite;

                            if (mIsReliable) {
                                characteristicData.temporaryData.put(offset, value);
                            } else {
                                characteristicData.currentData = Arrays.copyOfRange(value, offset, value.length);
                            }
                        }
                    }
                }

                if (force && !result && responseNeeded) {
                    result = bluetoothGattServer.sendResponse(device, requestId, APPLICATION_ERROR_9F, offset, null);
                }
            }
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected synchronized void repeatNotification(@NonNull Integer taskId
            , @NonNull BLEServerConnection bleServerConnection
            , @NonNull BluetoothDevice device
            , @NonNull UUID serviceUUID
            , int serviceInstanceId
            , @NonNull UUID characteristicUUID
            , int characteristicInstanceId
            , @Nullable Bundle argument) {
        Map<Pair<UUID, Integer>, CharacteristicData> characteristicMap = mRemappedServiceCharacteristicMap.get(Pair.create(serviceUUID, serviceInstanceId));
        if (characteristicMap != null) {
            CharacteristicData characteristicData = characteristicMap.get(Pair.create(characteristicUUID, characteristicInstanceId));
            if (characteristicData != null && argument != null && argument.containsKey(KEY_NOTIFICATION_COUNT)) {
                int notificationCount = argument.getInt(KEY_NOTIFICATION_COUNT);
                if (notificationCount > 0) {
                    notificationCount--;
                }
                if (notificationCount == 0) {
                    mActivatedNotificationMap.remove(new NotificationData(device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId));

                    if (RECONNECTION_CONFIGURATION_CONTROL_POINT_CHARACTERISTIC.equals(characteristicUUID) && argument.containsKey(KEY_ORIGINAL_ARGUMENT)) {
                        Bundle originalArgument = argument.getBundle(KEY_ORIGINAL_ARGUMENT);
                        if (originalArgument != null && originalArgument.getBoolean(KEY_CLIENT_PARAMETER_INDICATION)) {
                            ReconnectionConfigurationControlPointCharacteristicData reconnectionConfigurationControlPointCharacteristicData =
                                    findCharacteristicData(serviceUUID, characteristicUUID, ReconnectionConfigurationControlPointCharacteristicData.class);
                            if (reconnectionConfigurationControlPointCharacteristicData != null) {
                                reconnectionConfigurationControlPointCharacteristicData.highPriorityResponseData =
                                        new ReconnectionConfigurationControlPoint(ReconnectionConfigurationControlPoint.OPCODE_CLIENT_PARAMETER_INDICATION
                                                , new byte[0]
                                                , null
                                                , 0
                                                , 0,
                                                reconnectionConfigurationControlPointCharacteristicData.currentSetting).getBytes();

                                int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                                startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, 1, null);
                            }
                        }
                    }
                } else {
                    int descriptorInstanceId = argument.getInt(KEY_DESCRIPTOR_INSTANCE_ID, -1);
                    startNotification(taskId, bleServerConnection, device, serviceUUID, serviceInstanceId, characteristicUUID, characteristicInstanceId, descriptorInstanceId, NOTIFICATION_INTERVAL, notificationCount, null);
                }
            }
        }
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
