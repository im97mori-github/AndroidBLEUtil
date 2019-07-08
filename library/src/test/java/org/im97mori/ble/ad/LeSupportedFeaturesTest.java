package org.im97mori.ble.ad;

import org.junit.Test;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LeSupportedFeaturesTest {

    @Test
    public void constructTest1() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000001;

        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertTrue(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest2() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000010;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertTrue(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest3() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000100;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertTrue(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest4() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00001000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertTrue(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest5() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00010000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertTrue(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest6() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00100000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertTrue(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest7() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b01000000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertTrue(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest8() {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = (byte) 0b10000000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(2, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(1, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertTrue(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest9() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000001;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertTrue(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest10() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000010;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertTrue(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest11() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000100;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertTrue(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest12() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00001000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertTrue(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest13() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00010000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertTrue(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest14() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00100000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertTrue(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest15() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b01000000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertTrue(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest16() {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = (byte) 0b10000000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(3, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(2, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertTrue(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest17() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000001;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertTrue(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest18() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000010;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertTrue(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest19() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000100;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertTrue(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest20() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00001000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertTrue(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest21() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00010000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertTrue(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest22() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00100000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertTrue(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest23() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b01000000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertTrue(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest24() {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = (byte) 0b10000000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(4, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(3, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertTrue(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest25() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000001;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(4, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertTrue(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest26() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000010;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(4, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertTrue(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest27() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000100;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(4, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertTrue(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest28() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000100;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(4, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertTrue(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest29() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00001000;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(4, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertTrue(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest30() {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(5, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(4, result.getLeSupportedFeaturesList().size());
        assertTrue(result.isLeEncryptionSupported());
        assertTrue(result.isConnectionParametersRequestProcedureSupported());
        assertTrue(result.isExtendedRejectIndicationSupported());
        assertTrue(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertTrue(result.isLePingSupported());
        assertTrue(result.isLeDataPacketLengthExtensionSupported());
        assertTrue(result.isLlPrivacySupported());
        assertTrue(result.isExtendedScannerFilterPoliciesSupported());
        assertTrue(result.isLe2mPhySupported());
        assertTrue(result.isStableModulationIndexTransmitterSupported());
        assertTrue(result.isStableModulationIndexReceiverSupported());
        assertTrue(result.isLeCodedPhySupported());
        assertTrue(result.isLeExtendedAdvertisingSupported());
        assertTrue(result.isLePeriodicAdvertisingSupported());
        assertTrue(result.isChannelSelectionAlgorithm2Supported());
        assertTrue(result.isLePowerClass1Supported());
        assertTrue(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertTrue(result.isConnectionCteRequestSupported());
        assertTrue(result.isConnectionCteResponseSupported());
        assertTrue(result.isConnectionlessCteTransmitterSupported());
        assertTrue(result.isConnectionlessCteReceiverSupported());
        assertTrue(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertTrue(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertTrue(result.isReceivingConstantToneExtensionsSupported());
        assertTrue(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertTrue(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertTrue(result.isSleepClockAccuracyUpdatesSupported());
        assertTrue(result.isRemotePublicKeyValidationSupported());
    }

    @Test
    public void constructTest31() {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = DATA_TYPE_LE_SUPPORTED_FEATURES;
        LeSupportedFeatures result = new LeSupportedFeatures(data, 0, data[0]);
        assertEquals(1, result.getLength());
        assertEquals(DATA_TYPE_LE_SUPPORTED_FEATURES, result.getDataType());
        assertEquals(0, result.getLeSupportedFeaturesList().size());
        assertFalse(result.isLeEncryptionSupported());
        assertFalse(result.isConnectionParametersRequestProcedureSupported());
        assertFalse(result.isExtendedRejectIndicationSupported());
        assertFalse(result.isSlaveInitiatedFeaturesExchangeSupported());
        assertFalse(result.isLePingSupported());
        assertFalse(result.isLeDataPacketLengthExtensionSupported());
        assertFalse(result.isLlPrivacySupported());
        assertFalse(result.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result.isLe2mPhySupported());
        assertFalse(result.isStableModulationIndexTransmitterSupported());
        assertFalse(result.isStableModulationIndexReceiverSupported());
        assertFalse(result.isLeCodedPhySupported());
        assertFalse(result.isLeExtendedAdvertisingSupported());
        assertFalse(result.isLePeriodicAdvertisingSupported());
        assertFalse(result.isChannelSelectionAlgorithm2Supported());
        assertFalse(result.isLePowerClass1Supported());
        assertFalse(result.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result.isConnectionCteRequestSupported());
        assertFalse(result.isConnectionCteResponseSupported());
        assertFalse(result.isConnectionlessCteTransmitterSupported());
        assertFalse(result.isConnectionlessCteReceiverSupported());
        assertFalse(result.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result.isReceivingConstantToneExtensionsSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result.isRemotePublicKeyValidationSupported());
    }
}
