package org.im97mori.ble.advertising;

import android.os.Parcel;

import org.junit.Test;

import static org.im97mori.ble.constants.DataType.LE_SUPPORTED_FEATURES_DATA_TYPE;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SuppressWarnings("unused")
public class LeSupportedFeaturesTest {

    //@formatter:off
    private static final byte[] data_00001;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000001;
        data_00001 = data;
    }

    private static final byte[] data_00002;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000010;
        data_00002 = data;
    }

    private static final byte[] data_00003;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000100;
        data_00003 = data;
    }

    private static final byte[] data_00004;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00001000;
        data_00004 = data;
    }

    private static final byte[] data_00005;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00010000;
        data_00005 = data;
    }

    private static final byte[] data_00006;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00100000;
        data_00006 = data;
    }

    private static final byte[] data_00007;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b01000000;
        data_00007 = data;
    }

    private static final byte[] data_00008;
    static {
        byte[] data = new byte[3];
        data[0] = 2;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = (byte) 0b10000000;
        data_00008 = data;
    }

    private static final byte[] data_00009;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000001;
        data_00009 = data;
    }

    private static final byte[] data_00010;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000010;
        data_00010 = data;
    }

    private static final byte[] data_00011;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000100;
        data_00011 = data;
    }

    private static final byte[] data_00012;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00001000;
        data_00012 = data;
    }

    private static final byte[] data_00013;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00010000;
        data_00013 = data;
    }

    private static final byte[] data_00014;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00100000;
        data_00014 = data;
    }

    private static final byte[] data_00015;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b01000000;
        data_00015 = data;
    }

    private static final byte[] data_00016;
    static {
        byte[] data = new byte[4];
        data[0] = 3;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = (byte) 0b10000000;
        data_00016 = data;
    }

    private static final byte[] data_00017;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000001;
        data_00017 = data;
    }

    private static final byte[] data_00018;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000010;
        data_00018 = data;
    }

    private static final byte[] data_00019;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000100;
        data_00019 = data;
    }

    private static final byte[] data_00020;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00001000;
        data_00020 = data;
    }

    private static final byte[] data_00021;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00010000;
        data_00021 = data;
    }

    private static final byte[] data_00022;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00100000;
        data_00022 = data;
    }

    private static final byte[] data_00023;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b01000000;
        data_00023 = data;
    }

    private static final byte[] data_00024;
    static {
        byte[] data = new byte[5];
        data[0] = 4;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = (byte) 0b10000000;
        data_00024 = data;
    }

    private static final byte[] data_00025;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000001;
        data_00025 = data;
    }

    private static final byte[] data_00026;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000010;
        data_00026 = data;
    }

    private static final byte[] data_00027;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000100;
        data_00027 = data;
    }

    private static final byte[] data_00028;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000100;
        data_00028 = data;
    }

    private static final byte[] data_00029;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00001000;
        data_00029 = data;
    }

    private static final byte[] data_00030;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00010000;
        data_00030 = data;
    }

    private static final byte[] data_00031;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00100000;
        data_00031 = data;
    }

    private static final byte[] data_00032;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b01000000;
        data_00032 = data;
    }

    private static final byte[] data_00033;
    static {
        byte[] data = new byte[6];
        data[0] = 5;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = (byte) 0b10000000;
        data_00033 = data;
    }

    private static final byte[] data_00034;
    static {
        byte[] data = new byte[7];
        data[0] = 6;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000001;
        data_00034 = data;
    }

    private static final byte[] data_00035;
    static {
        byte[] data = new byte[7];
        data[0] = 6;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000010;
        data_00035 = data;
    }

    private static final byte[] data_00036;
    static {
        byte[] data = new byte[7];
        data[0] = 6;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00000100;
        data_00036 = data;
    }

    private static final byte[] data_00037;
    static {
        byte[] data = new byte[7];
        data[0] = 6;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = 0b00000000;
        data[3] = 0b00000000;
        data[4] = 0b00000000;
        data[5] = 0b00000000;
        data[6] = 0b00001000;
        data_00037 = data;
    }

    private static final byte[] data_00100;
    static {
        byte[] data = new byte[7];
        data[0] = 6;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data[2] = (byte) 0b11111111;
        data[3] = (byte) 0b11111111;
        data[4] = (byte) 0b11111111;
        data[5] = (byte) 0b11111111;
        data[6] = (byte) 0b11111111;
        data_00100 = data;
    }

    private static final byte[] data_00101;
    static {
        byte[] data = new byte[2];
        data[0] = 1;
        data[1] = LE_SUPPORTED_FEATURES_DATA_TYPE;
        data_00101 = data;
    }
    //@formatter:on

    private byte[] getData() {
        int index = -1;
        byte[] data = null;

        StackTraceElement[] stackTraceElementArray = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTraceElementArray.length; i++) {
            StackTraceElement stackTraceElement = stackTraceElementArray[i];
            if ("getData".equals(stackTraceElement.getMethodName())) {
                index = i + 1;
                break;
            }
        }
        if (index >= 0 && index < stackTraceElementArray.length) {
            StackTraceElement stackTraceElement = stackTraceElementArray[index];
            String[] splitted = stackTraceElement.getMethodName().split("_");
            try {
                data = (byte[]) this.getClass().getDeclaredField("data_" + splitted[splitted.length - 1]).get(null);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    @Test
    public void test_constructor_00001() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertTrue(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00002() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertTrue(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00003() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertTrue(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00004() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertTrue(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00005() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertTrue(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00006() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertTrue(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00007() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertTrue(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00008() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(2, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(1, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertTrue(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00009() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertTrue(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00010() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertTrue(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00011() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertTrue(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00012() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertTrue(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00013() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertTrue(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00014() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertTrue(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00015() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertTrue(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00016() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(3, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(2, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertTrue(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00017() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertTrue(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00018() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertTrue(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00019() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertTrue(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00020() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertTrue(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00021() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertTrue(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00022() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertTrue(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00023() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertTrue(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00024() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(4, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(3, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertTrue(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00025() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertTrue(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00026() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertTrue(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00027() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertTrue(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00028() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertTrue(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00029() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertTrue(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00030() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertTrue(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00031() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertTrue(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00032() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertTrue(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00033() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(5, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(4, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertTrue(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00034() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(6, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertTrue(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00035() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(6, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertTrue(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00036() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(6, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertTrue(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00037() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(6, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertTrue(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00100() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(6, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(5, result1.getLeSupportedFeaturesList().size());
        assertTrue(result1.isLeEncryptionSupported());
        assertTrue(result1.isConnectionParametersRequestProcedureSupported());
        assertTrue(result1.isExtendedRejectIndicationSupported());
        assertTrue(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertTrue(result1.isLePingSupported());
        assertTrue(result1.isLeDataPacketLengthExtensionSupported());
        assertTrue(result1.isLlPrivacySupported());
        assertTrue(result1.isExtendedScannerFilterPoliciesSupported());
        assertTrue(result1.isLe2mPhySupported());
        assertTrue(result1.isStableModulationIndexTransmitterSupported());
        assertTrue(result1.isStableModulationIndexReceiverSupported());
        assertTrue(result1.isLeCodedPhySupported());
        assertTrue(result1.isLeExtendedAdvertisingSupported());
        assertTrue(result1.isLePeriodicAdvertisingSupported());
        assertTrue(result1.isChannelSelectionAlgorithm2Supported());
        assertTrue(result1.isLePowerClass1Supported());
        assertTrue(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertTrue(result1.isConnectionCteRequestSupported());
        assertTrue(result1.isConnectionCteResponseSupported());
        assertTrue(result1.isConnectionlessCteTransmitterSupported());
        assertTrue(result1.isConnectionlessCteReceiverSupported());
        assertTrue(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertTrue(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertTrue(result1.isReceivingConstantToneExtensionsSupported());
        assertTrue(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertTrue(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertTrue(result1.isSleepClockAccuracyUpdatesSupported());
        assertTrue(result1.isRemotePublicKeyValidationSupported());
        assertTrue(result1.isConnectedIsochronousStreamCentralSupported());
        assertTrue(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertTrue(result1.isIsochronousBroadcasterSupported());
        assertTrue(result1.isSynchronizedReceiverSupported());
        assertTrue(result1.isIsochronousChannelsSupported());
        assertTrue(result1.isLePowerControlRequestSupported());
        assertTrue(result1.isLePowerChangeIndicationSupported());
        assertTrue(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_constructor_00101() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertEquals(1, result1.getLength());
        assertEquals(LE_SUPPORTED_FEATURES_DATA_TYPE, result1.getDataType());
        assertEquals(0, result1.getLeSupportedFeaturesList().size());
        assertFalse(result1.isLeEncryptionSupported());
        assertFalse(result1.isConnectionParametersRequestProcedureSupported());
        assertFalse(result1.isExtendedRejectIndicationSupported());
        assertFalse(result1.isPeripheralInitiatedFeaturesExchangeSupported());
        assertFalse(result1.isLePingSupported());
        assertFalse(result1.isLeDataPacketLengthExtensionSupported());
        assertFalse(result1.isLlPrivacySupported());
        assertFalse(result1.isExtendedScannerFilterPoliciesSupported());
        assertFalse(result1.isLe2mPhySupported());
        assertFalse(result1.isStableModulationIndexTransmitterSupported());
        assertFalse(result1.isStableModulationIndexReceiverSupported());
        assertFalse(result1.isLeCodedPhySupported());
        assertFalse(result1.isLeExtendedAdvertisingSupported());
        assertFalse(result1.isLePeriodicAdvertisingSupported());
        assertFalse(result1.isChannelSelectionAlgorithm2Supported());
        assertFalse(result1.isLePowerClass1Supported());
        assertFalse(result1.isMinimumNumberOfUsedChannelsProcedureSupported());
        assertFalse(result1.isConnectionCteRequestSupported());
        assertFalse(result1.isConnectionCteResponseSupported());
        assertFalse(result1.isConnectionlessCteTransmitterSupported());
        assertFalse(result1.isConnectionlessCteReceiverSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteTransmissionAodSupported());
        assertFalse(result1.isAntennaSwitchingDuringCteReceptionAoaSupported());
        assertFalse(result1.isReceivingConstantToneExtensionsSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferSenderSupported());
        assertFalse(result1.isPeriodicAdvertisingSyncTransferRecipientSupported());
        assertFalse(result1.isSleepClockAccuracyUpdatesSupported());
        assertFalse(result1.isRemotePublicKeyValidationSupported());
        assertFalse(result1.isConnectedIsochronousStreamCentralSupported());
        assertFalse(result1.isConnectedIsochronousStreamPeripheralSupported());
        assertFalse(result1.isIsochronousBroadcasterSupported());
        assertFalse(result1.isSynchronizedReceiverSupported());
        assertFalse(result1.isIsochronousChannelsSupported());
        assertFalse(result1.isLePowerControlRequestSupported());
        assertFalse(result1.isLePowerChangeIndicationSupported());
        assertFalse(result1.isLePathLossMonitoringSupported());
    }

    @Test
    public void test_parcelable_1_00001() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00002() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00003() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00004() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00005() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00006() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00007() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00008() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00009() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00010() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00011() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00012() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00013() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00014() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00015() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00016() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00017() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00018() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00019() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00020() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00021() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00022() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00023() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00024() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00025() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00026() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00027() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00028() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00029() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00030() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00031() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00032() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00033() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00034() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00035() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00036() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00037() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00100() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_1_00101() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        Parcel parcel = Parcel.obtain();
        result1.writeToParcel(parcel, 0);
        parcel.setDataPosition(0);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromParcel(parcel);
        assertEquals(result1.getLength(), result2.getLength());
        assertEquals(result1.getDataType(), result2.getDataType());
        assertArrayEquals(result1.getLeSupportedFeaturesList().toArray(), result2.getLeSupportedFeaturesList().toArray());
    }

    @Test
    public void test_parcelable_2_00001() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00002() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00003() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00004() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00005() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00006() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00007() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00008() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00009() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00010() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00011() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00012() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00013() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00014() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00015() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00016() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00017() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00018() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00019() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00020() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00021() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00022() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00023() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00024() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00025() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00026() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00027() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00028() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00029() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00030() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00031() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00032() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00033() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00034() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00035() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00036() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00037() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00100() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_2_00101() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        assertArrayEquals(data, result1.getBytes());
    }

    @Test
    public void test_parcelable_3_00001() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00002() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00003() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00004() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00005() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00006() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00007() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00008() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00009() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00010() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00011() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00012() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00013() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00014() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00015() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00016() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00017() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00018() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00019() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00020() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00021() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00022() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00023() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00024() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00025() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00026() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00027() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00028() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00029() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00030() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00031() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00032() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00033() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00034() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00035() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00036() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00037() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00100() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }

    @Test
    public void test_parcelable_3_00101() {
        byte[] data = getData();

        LeSupportedFeaturesAndroid result1 = new LeSupportedFeaturesAndroid(data, 0, data[0]);
        LeSupportedFeaturesAndroid result2 = LeSupportedFeaturesAndroid.CREATOR.createFromByteArray(data);
        assertArrayEquals(result1.getBytes(), result2.getBytes());
    }
}
