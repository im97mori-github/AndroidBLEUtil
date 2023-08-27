package org.im97mori.ble.profile.rcp.peripheral;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.test.core.app.ApplicationProvider;

import org.im97mori.ble.characteristic.u2aa5.BondManagementFeatures;
import org.im97mori.ble.characteristic.u2b1d.RCFeature;
import org.im97mori.ble.characteristic.u2b1e.RCSettings;
import org.im97mori.ble.characteristic.u2b1f.ReconnectionConfigurationControlPoint;
import org.im97mori.ble.descriptor.u2902.ClientCharacteristicConfiguration;
import org.im97mori.ble.service.bms.peripheral.BondManagementServiceMockCallback;
import org.im97mori.ble.service.rcs.peripheral.ReconnectionConfigurationServiceMockCallback;
import org.im97mori.ble.test.TestBase;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class ReconnectionConfigurationProfileMockCallbackBuilderTest extends TestBase {

    @Test
    public void test_constructor_00001() {
        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);

        assertEquals(context, baseBuilder.mContext);
        assertEquals(reconnectionConfigurationServiceMockCallbackBuilder, baseBuilder.mReconnectionConfigurationServiceMockCallbackBuilder);
        assertEquals(bondManagementServiceMockCallbackBuilder, baseBuilder.mBondManagementServiceMockCallbackBuilder);
    }

    @Test
    public void test_addRCFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                , 0
                , 0
                , 0});

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> addRCFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(rcFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRCFeature(responseCode, delay, value);
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRCFeature(rcFeature));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRCFeature_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                , 0
                , 0
                , 0});

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> addRCFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(rcFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRCFeature(responseCode, delay, value);
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRCFeature(rcFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRCFeature_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final RCFeature rcFeature = new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                , 0
                , 0
                , 0});

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> addRCFeature(int responseCode, long delay, @NonNull byte[] value) {
                assertEquals(originalResponseCode, responseCode);
                assertEquals(originalDelay, delay);
                assertArrayEquals(rcFeature.getBytes(), value);
                atomicBoolean.set(true);
                return super.addRCFeature(responseCode, delay, value);
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRCFeature(originalResponseCode, originalDelay, rcFeature.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRCFeature_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> removeRCFeature() {
                atomicBoolean.set(true);
                return super.removeRCFeature();
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeRCFeature());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRCSettings_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final RCSettings rcSettings = new RCSettings(new byte[]{3, 0, 0});

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> addRCSettings(boolean canNotify, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertArrayEquals(rcSettings.getBytes(), characteristicValue);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addRCSettings(canNotify, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRCSettings(rcSettings, clientCharacteristicConfiguration));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addRCSettings_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final boolean canNotify = false;
        final int originalCharacteristicResponseCode = 38;
        final long originalCharacteristicDelay = 39;
        final int originalNotificationCount = 40;
        final int originalDescriptorResponseCode = 41;
        final long originalDescriptorDelay = 42;

        final RCSettings rcSettings = new RCSettings(new byte[]{3, 0, 0});

        byte[] descriptorValue = BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE;
        final ClientCharacteristicConfiguration clientCharacteristicConfiguration = new ClientCharacteristicConfiguration(descriptorValue);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> addRCSettings(boolean canNotify, int characteristicResponseCode, long characteristicDelay, @NonNull byte[] characteristicValue, int notificationCount, int descriptorResponseCode, long descriptorDelay, @NonNull byte[] descriptorValue) {
                assertEquals(canNotify, canNotify);
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertArrayEquals(rcSettings.getBytes(), characteristicValue);
                assertEquals(originalNotificationCount, notificationCount);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(clientCharacteristicConfiguration.getBytes(), descriptorValue);
                atomicBoolean.set(true);
                return super.addRCSettings(canNotify, characteristicResponseCode, characteristicDelay, characteristicValue, notificationCount, descriptorResponseCode, descriptorDelay, descriptorValue);
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addRCSettings(canNotify, originalCharacteristicResponseCode, originalCharacteristicDelay, rcSettings.getBytes(), originalNotificationCount, originalDescriptorResponseCode, originalDescriptorDelay, clientCharacteristicConfiguration.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeRCSettings_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> removeRCSettings() {
                atomicBoolean.set(true);
                return super.removeRCFeature();
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeRCSettings());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addReconnectionConfigurationControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final int originalCharacteristicResponseCode = 1;
        final long originalCharacteristicDelay = 2;
        final int originalDescriptorResponseCode = 3;
        final long originalDescriptorDelay = 4;
        final byte[] originalDescriptorValue = new byte[]{5};
        final int originalEnableDisconnectResultCodes = 6;
        final int originalGetActualCommunicationParametersResultCodes = 7;
        final int originalProposeSettingsResultCodes = 8;
        final int originalProposeSettingsError = 9;
        final int originalActivateStoredSettingsResultCodes = 10;
        final int originalGetMaxValuesResultCodes = 11;
        final byte[] originalMaxValues = new byte[]{12};
        final int originalGetMinValuesResultCodes = 13;
        final byte[] originalMinValues = new byte[]{14};
        final int originalGetStoredValuesResultCodes = 15;
        final byte[] originalGetStoredValuesOperand = new byte[]{16};
        final int originalSetWhiteListTimerResultCodes = 17;
        final int originalGetWhiteListTimerResultCodes = 18;
        final byte[] originalGetWhiteListTimerOperand = new byte[]{19};
        final int originalSetAdvertisementConfigurationResultCodes = 20;
        final int originalUpgradeToLescOnlyResultCodes = 21;
        final int originalSwitchOobPairingResultCodes = 22;
        final int originalLimitedAccessResultCodes = 23;
        final byte[] originalCurrentSetting = new byte[]{24};
        final boolean originalIsRcFeaturesE2eCrcSupported = false;

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> addReconnectionConfigurationControlPoint(int characteristicResponseCode
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
                assertEquals(originalCharacteristicResponseCode, characteristicResponseCode);
                assertEquals(originalCharacteristicDelay, characteristicDelay);
                assertEquals(originalDescriptorResponseCode, descriptorResponseCode);
                assertEquals(originalDescriptorDelay, descriptorDelay);
                assertArrayEquals(originalDescriptorValue, descriptorValue);
                assertEquals(originalEnableDisconnectResultCodes, enableDisconnectResultCodes);
                assertEquals(originalGetActualCommunicationParametersResultCodes, getActualCommunicationParametersResultCodes);
                assertEquals(originalProposeSettingsResultCodes, proposeSettingsResultCodes);
                assertEquals(originalProposeSettingsError, proposeSettingsError);
                assertEquals(originalActivateStoredSettingsResultCodes, activateStoredSettingsResultCodes);
                assertEquals(originalGetMaxValuesResultCodes, getMaxValuesResultCodes);
                assertArrayEquals(originalMaxValues, maxValues);
                assertEquals(originalGetMinValuesResultCodes, getMinValuesResultCodes);
                assertArrayEquals(originalMinValues, minValues);
                assertEquals(originalGetStoredValuesResultCodes, getStoredValuesResultCodes);
                assertArrayEquals(originalGetStoredValuesOperand, getStoredValuesOperand);
                assertEquals(originalSetWhiteListTimerResultCodes, setWhiteListTimerResultCodes);
                assertEquals(originalGetWhiteListTimerResultCodes, getWhiteListTimerResultCodes);
                assertArrayEquals(originalGetWhiteListTimerOperand, getWhiteListTimerOperand);
                assertEquals(originalSetAdvertisementConfigurationResultCodes, setAdvertisementConfigurationResultCodes);
                assertEquals(originalUpgradeToLescOnlyResultCodes, upgradeToLescOnlyResultCodes);
                assertEquals(originalSwitchOobPairingResultCodes, switchOobPairingResultCodes);
                assertEquals(originalLimitedAccessResultCodes, limitedAccessResultCodes);
                assertArrayEquals(originalCurrentSetting, currentSetting);
                assertEquals(originalIsRcFeaturesE2eCrcSupported, isRcFeaturesE2eCrcSupported);
                atomicBoolean.set(true);
                return super.addReconnectionConfigurationControlPoint(characteristicResponseCode, characteristicDelay, descriptorResponseCode, descriptorDelay, descriptorValue, enableDisconnectResultCodes, getActualCommunicationParametersResultCodes, proposeSettingsResultCodes, proposeSettingsError, activateStoredSettingsResultCodes, getMaxValuesResultCodes, maxValues, getMinValuesResultCodes, minValues, getStoredValuesResultCodes, getStoredValuesOperand, setWhiteListTimerResultCodes, getWhiteListTimerResultCodes, getWhiteListTimerOperand, setAdvertisementConfigurationResultCodes, upgradeToLescOnlyResultCodes, switchOobPairingResultCodes, limitedAccessResultCodes, currentSetting, isRcFeaturesE2eCrcSupported);
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addReconnectionConfigurationControlPoint(originalCharacteristicResponseCode
                , originalCharacteristicDelay
                , originalDescriptorResponseCode
                , originalDescriptorDelay
                , originalDescriptorValue
                , originalEnableDisconnectResultCodes
                , originalGetActualCommunicationParametersResultCodes
                , originalProposeSettingsResultCodes
                , originalProposeSettingsError
                , originalActivateStoredSettingsResultCodes
                , originalGetMaxValuesResultCodes
                , originalMaxValues
                , originalGetMinValuesResultCodes
                , originalMinValues
                , originalGetStoredValuesResultCodes
                , originalGetStoredValuesOperand
                , originalSetWhiteListTimerResultCodes
                , originalGetWhiteListTimerResultCodes
                , originalGetWhiteListTimerOperand
                , originalSetAdvertisementConfigurationResultCodes
                , originalUpgradeToLescOnlyResultCodes
                , originalSwitchOobPairingResultCodes
                , originalLimitedAccessResultCodes
                , originalCurrentSetting
                , originalIsRcFeaturesE2eCrcSupported));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeReconnectionConfigurationControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback>() {

            @NonNull
            @Override
            public ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> removeReconnectionConfigurationControlPoint() {
                atomicBoolean.set(true);
                return super.removeRCFeature();
            }

        };
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<>();
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeReconnectionConfigurationControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBondManagementControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        final long originalDelay = 0;
        final int originalDeleteBondOfRequestingDeviceBrEdrLeResponseCode = 1;
        final String originalDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode = "2";
        final int originalDeleteBondOfRequestingDeviceBrEdrResponseCode = 3;
        final String originalDeleteBondOfRequestingDeviceBrEdrAuthorizationCode = "4";
        final int originalDeleteBondOfRequestingDeviceLeResponseCode = 5;
        final String originalDeleteBondOfRequestingDeviceLeAuthorizationCode = "6";
        final int originalDeleteAllBondsOnServerBrEdrLeResponseCode = 7;
        final String originalDeleteAllBondsOnServerBrEdrLeAuthorizationCode = "8";
        final int originalDeleteAllBondsOnServerBrEdrResponseCode = 9;
        final String originalDeleteAllBondsOnServerBrEdrAuthorizationCode = "10";
        final int originalDeleteAllBondsOnServerLeResponseCode = 11;
        final String originalDeleteAllBondsOnServerLeAuthorizationCode = "12";
        final int originalDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode = 13;
        final String originalDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode = "14";
        final int originalDeleteAllButTheActiveBondOnServerBrEdrResponseCode = 15;
        final String originalDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode = "16";
        final int originalDeleteAllButTheActiveBondOnServerLeResponseCode = 17;
        final String originalDeleteAllButTheActiveBondOnServerLeAuthorizationCode = "18";

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback>() {

            @NonNull
            @Override
            public BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> addBondManagementControlPoint(long delay
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
                assertEquals(originalDelay, delay);
                assertEquals(originalDeleteBondOfRequestingDeviceBrEdrLeResponseCode, deleteBondOfRequestingDeviceBrEdrLeResponseCode);
                assertEquals(originalDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode, deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode);
                assertEquals(originalDeleteBondOfRequestingDeviceBrEdrResponseCode, deleteBondOfRequestingDeviceBrEdrResponseCode);
                assertEquals(originalDeleteBondOfRequestingDeviceBrEdrAuthorizationCode, deleteBondOfRequestingDeviceBrEdrAuthorizationCode);
                assertEquals(originalDeleteBondOfRequestingDeviceLeResponseCode, deleteBondOfRequestingDeviceLeResponseCode);
                assertEquals(originalDeleteBondOfRequestingDeviceLeAuthorizationCode, deleteBondOfRequestingDeviceLeAuthorizationCode);
                assertEquals(originalDeleteAllBondsOnServerBrEdrLeResponseCode, deleteAllBondsOnServerBrEdrLeResponseCode);
                assertEquals(originalDeleteAllBondsOnServerBrEdrLeAuthorizationCode, deleteAllBondsOnServerBrEdrLeAuthorizationCode);
                assertEquals(originalDeleteAllBondsOnServerBrEdrResponseCode, deleteAllBondsOnServerBrEdrResponseCode);
                assertEquals(originalDeleteAllBondsOnServerBrEdrAuthorizationCode, deleteAllBondsOnServerBrEdrAuthorizationCode);
                assertEquals(originalDeleteAllBondsOnServerLeResponseCode, deleteAllBondsOnServerLeResponseCode);
                assertEquals(originalDeleteAllBondsOnServerLeAuthorizationCode, deleteAllBondsOnServerLeAuthorizationCode);
                assertEquals(originalDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode, deleteAllButTheActiveBondOnServerBrEdrLeResponseCode);
                assertEquals(originalDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode, deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode);
                assertEquals(originalDeleteAllButTheActiveBondOnServerBrEdrResponseCode, deleteAllButTheActiveBondOnServerBrEdrResponseCode);
                assertEquals(originalDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode, deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode);
                assertEquals(originalDeleteAllButTheActiveBondOnServerLeResponseCode, deleteAllButTheActiveBondOnServerLeResponseCode);
                assertEquals(originalDeleteAllButTheActiveBondOnServerLeAuthorizationCode, deleteAllButTheActiveBondOnServerLeAuthorizationCode);
                atomicBoolean.set(true);
                return super.addBondManagementControlPoint(delay, deleteBondOfRequestingDeviceBrEdrLeResponseCode, deleteBondOfRequestingDeviceBrEdrLeAuthorizationCode, deleteBondOfRequestingDeviceBrEdrResponseCode, deleteBondOfRequestingDeviceBrEdrAuthorizationCode, deleteBondOfRequestingDeviceLeResponseCode, deleteBondOfRequestingDeviceLeAuthorizationCode, deleteAllBondsOnServerBrEdrLeResponseCode, deleteAllBondsOnServerBrEdrLeAuthorizationCode, deleteAllBondsOnServerBrEdrResponseCode, deleteAllBondsOnServerBrEdrAuthorizationCode, deleteAllBondsOnServerLeResponseCode, deleteAllBondsOnServerLeAuthorizationCode, deleteAllButTheActiveBondOnServerBrEdrLeResponseCode, deleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode, deleteAllButTheActiveBondOnServerBrEdrResponseCode, deleteAllButTheActiveBondOnServerBrEdrAuthorizationCode, deleteAllButTheActiveBondOnServerLeResponseCode, deleteAllButTheActiveBondOnServerLeAuthorizationCode);
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBondManagementControlPoint(originalDelay
                , originalDeleteBondOfRequestingDeviceBrEdrLeResponseCode
                , originalDeleteBondOfRequestingDeviceBrEdrLeAuthorizationCode
                , originalDeleteBondOfRequestingDeviceBrEdrResponseCode
                , originalDeleteBondOfRequestingDeviceBrEdrAuthorizationCode
                , originalDeleteBondOfRequestingDeviceLeResponseCode
                , originalDeleteBondOfRequestingDeviceLeAuthorizationCode
                , originalDeleteAllBondsOnServerBrEdrLeResponseCode
                , originalDeleteAllBondsOnServerBrEdrLeAuthorizationCode
                , originalDeleteAllBondsOnServerBrEdrResponseCode
                , originalDeleteAllBondsOnServerBrEdrAuthorizationCode
                , originalDeleteAllBondsOnServerLeResponseCode
                , originalDeleteAllBondsOnServerLeAuthorizationCode
                , originalDeleteAllButTheActiveBondOnServerBrEdrLeResponseCode
                , originalDeleteAllButTheActiveBondOnServerBrEdrLeAuthorizationCode
                , originalDeleteAllButTheActiveBondOnServerBrEdrResponseCode
                , originalDeleteAllButTheActiveBondOnServerBrEdrAuthorizationCode
                , originalDeleteAllButTheActiveBondOnServerLeResponseCode
                , originalDeleteAllButTheActiveBondOnServerLeAuthorizationCode)
        );

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBondManagementControlPoint_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback>() {
            @NonNull
            @Override
            public BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> removeBondManagementControlPoint() {
                atomicBoolean.set(true);
                return super.removeBondManagementControlPoint();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBondManagementControlPoint());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBondManagementFeatures_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(new byte[]{1, 2, 3});

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback>() {
            @NonNull
            @Override
            public BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> addBondManagementFeatures(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(bondManagementFeatures.getBytes(), value);
                atomicBoolean.set(true);
                return super.addBondManagementFeatures(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBondManagementFeatures(bondManagementFeatures));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBondManagementFeatures_00002() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(new byte[]{1, 2, 3});

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback>() {
            @NonNull
            @Override
            public BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> addBondManagementFeatures(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(bondManagementFeatures.getBytes(), value);
                atomicBoolean.set(true);
                return super.addBondManagementFeatures(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBondManagementFeatures(bondManagementFeatures.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_addBondManagementFeatures_00003() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        final int originalResponseCode = 1;
        final long originalDelay = 2;
        final BondManagementFeatures bondManagementFeatures = new BondManagementFeatures(new byte[]{1, 2, 3});

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback>() {
            @NonNull
            @Override
            public BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> addBondManagementFeatures(int responseCode, long delay, @NonNull byte[] value) {
                assertArrayEquals(bondManagementFeatures.getBytes(), value);
                atomicBoolean.set(true);
                return super.addBondManagementFeatures(responseCode, delay, value);
            }
        };
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.addBondManagementFeatures(originalResponseCode, originalDelay, bondManagementFeatures.getBytes()));

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_removeBondManagementFeatures_00001() {
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);

        Context context = ApplicationProvider.getApplicationContext();
        ReconnectionConfigurationServiceMockCallback.Builder<ReconnectionConfigurationServiceMockCallback> reconnectionConfigurationServiceMockCallbackBuilder = new ReconnectionConfigurationServiceMockCallback.Builder<>();
        BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> bondManagementServiceMockCallbackBuilder = new BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback>() {
            @NonNull
            @Override
            public BondManagementServiceMockCallback.Builder<BondManagementServiceMockCallback> removeBondManagementFeatures() {
                atomicBoolean.set(true);
                return super.removeBondManagementControlPoint();
            }

        };
        BaseBuilder baseBuilder = new BaseBuilder(context, reconnectionConfigurationServiceMockCallbackBuilder, bondManagementServiceMockCallbackBuilder);
        assertEquals(baseBuilder, baseBuilder.removeBondManagementFeatures());

        assertTrue(atomicBoolean.get());
    }

    @Test
    public void test_build_00001() {
        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 8;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new ReconnectionConfigurationServiceMockCallback.Builder<>(), null)
                    .addRCFeature(new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                            , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                            , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE)
                            , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE) >> 8)
                            , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE) >> 16)
                    }))
                    .addRCSettings(false
                            , 0
                            , 0
                            , new RCSettings(new byte[]{3
                                    , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                                    , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1 >> 8}).getBytes()
                            , 0
                            , 0
                            , 0
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE).getBytes())
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
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
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Service", exception.getMessage());
    }

    @Test
    public void test_build_00002() {
        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 8;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new ReconnectionConfigurationServiceMockCallback.Builder<>(), null)
                    .addRCFeature(new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                            , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                            , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE)
                            , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE) >> 8)
                            , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE) >> 16)
                    }))
                    .addRCSettings(false
                            , 0
                            , 0
                            , new RCSettings(new byte[]{3
                                    , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                                    , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1 >> 8}).getBytes()
                            , 0
                            , 0
                            , 0
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE).getBytes())
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
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
                            , isRcFeaturesE2eCrcSupported)
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNotNull(exception);
        assertEquals("no Bond Management Service", exception.getMessage());
    }

    @Test
    public void test_build_00003() {
        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new ReconnectionConfigurationServiceMockCallback.Builder<>(), null)
                    .addRCFeature(new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                            , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                            , 0
                            , 0
                            , 0
                    }))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00004() {
        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 8;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        Exception exception = null;
        try {
            new BaseBuilder(ApplicationProvider.getApplicationContext(), new ReconnectionConfigurationServiceMockCallback.Builder<>(), new BondManagementServiceMockCallback.Builder<>())
                    .addRCFeature(new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                            , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                            , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE)
                            , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE) >> 8)
                            , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE) >> 16)
                    }))
                    .addRCSettings(false
                            , 0
                            , 0
                            , new RCSettings(new byte[]{3
                                    , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                                    , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1 >> 8}).getBytes()
                            , 0
                            , 0
                            , 0
                            , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE).getBytes())
                    .addReconnectionConfigurationControlPoint(characteristicResponseCode
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
                            , isRcFeaturesE2eCrcSupported)
                    .addBondManagementControlPoint(0
                            , 1
                            , "2"
                            , 3
                            , "4"
                            , 5
                            , "6"
                            , 7
                            , "8"
                            , 9
                            , "11"
                            , 12
                            , "13"
                            , 14
                            , "15"
                            , 16
                            , "17"
                            , 18
                            , "19")
                    .addBondManagementFeatures(new BondManagementFeatures(new byte[3]))
                    .build();
        } catch (Exception e) {
            exception = e;
        }

        assertNull(exception);
    }

    @Test
    public void test_build_00005() {
        int characteristicResponseCode = BluetoothGatt.GATT_SUCCESS;
        long characteristicDelay = 0;
        int descriptorResponseCode = BluetoothGatt.GATT_SUCCESS;
        long descriptorDelay = 0;
        byte[] descriptorValue = BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE;
        int enableDisconnectResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getActualCommunicationParametersResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int proposeSettingsError = 8;
        int activateStoredSettingsResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getMaxValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] maxValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getMinValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] minValues = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        int getStoredValuesResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getStoredValuesOperand = new byte[16];
        int setWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int getWhiteListTimerResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] getWhiteListTimerOperand = new byte[]{(byte) ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 8)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 16)
                , (byte) (ReconnectionConfigurationControlPoint.WHITE_LIST_TIMER_DISABLED >> 24)
                , 2, 0, 0, 0
                , 3, 0, 0, 0
        };
        int setAdvertisementConfigurationResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int upgradeToLescOnlyResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int switchOobPairingResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        int limitedAccessResultCodes = ReconnectionConfigurationControlPoint.RESULT_CODE_DEVICE_BUSY;
        byte[] currentSetting = new byte[]{1, 0
                , (byte) 0x80, 0x0c
                , (byte) 0x7f, 0x0c
                , (byte) 0xf3, 0x01
                , (byte) 0x7e, 0x0c
                , 0x00, 0x40
                , (byte) 0xe8, 0x03
                , 0x10, 0x27};
        boolean isRcFeaturesE2eCrcSupported = false;

        ReconnectionConfigurationProfileMockCallback callback = new BaseBuilder(ApplicationProvider.getApplicationContext(), new ReconnectionConfigurationServiceMockCallback.Builder<>(), new BondManagementServiceMockCallback.Builder<>())
                .addRCFeature(new RCFeature(new byte[]{(byte) RCFeature.E2E_CRC_NOT_SUPPORTED
                        , (byte) (RCFeature.E2E_CRC_NOT_SUPPORTED >> 8)
                        , (byte) (RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE)
                        , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE) >> 8)
                        , (byte) ((RCFeature.RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE | RCFeature.RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE) >> 16)
                }))
                .addRCSettings(false
                        , 0
                        , 0
                        , new RCSettings(new byte[]{3
                                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1
                                , RCSettings.SETTINGS_ADVERTISEMENT_MODE_CONFIGURATION_1 >> 8}).getBytes()
                        , 0
                        , 0
                        , 0
                        , new ClientCharacteristicConfiguration(BluetoothGattDescriptor.DISABLE_NOTIFICATION_VALUE).getBytes())
                .addReconnectionConfigurationControlPoint(characteristicResponseCode
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
                        , isRcFeaturesE2eCrcSupported)
                .addBondManagementControlPoint(0
                        , 1
                        , "2"
                        , 3
                        , "4"
                        , 5
                        , "6"
                        , 7
                        , "8"
                        , 9
                        , "11"
                        , 12
                        , "13"
                        , 14
                        , "15"
                        , 16
                        , "17"
                        , 18
                        , "19")
                .addBondManagementFeatures(new BondManagementFeatures(new byte[3]))
                .build();

        assertNotNull(callback);
    }

}
