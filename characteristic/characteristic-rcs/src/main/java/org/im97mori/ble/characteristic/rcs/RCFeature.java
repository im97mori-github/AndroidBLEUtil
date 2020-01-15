package org.im97mori.ble.characteristic.rcs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.R_C_FEATURE_CHARACTERISTIC;

/**
 * RC Feature (Characteristics UUID: 0x2B1D)
 */
@SuppressWarnings("WeakerAccess")
public class RCFeature implements ByteArrayInterface, Parcelable {

    /**
     * 0xFFFF: device does not support E2E-safety
     */
    public static final int E2E_CRC_NOT_SUPPORTED = 0xffff;

    /**
     * @see #RC_FEATURES_E2E_CRC_SUPPORTED_FALSE
     * @see #RC_FEATURES_E2E_CRC_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_E2E_CRC_SUPPORTED_MASK = 0b00000000_00000000_00000001;

    /**
     * E2E-CRC Supported False
     */
    public static final int RC_FEATURES_E2E_CRC_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * E2E-CRC Supported True
     */
    public static final int RC_FEATURES_E2E_CRC_SUPPORTED_TRUE = 0b00000000_00000000_00000001;

    /**
     * @see #RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_FALSE
     * @see #RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_MASK = 0b00000000_00000000_00000010;

    /**
     * 0: Enable Disconnect Supported False
     */
    public static final int RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Enable Disconnect Supported True
     */
    public static final int RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE = 0b00000000_00000000_00000010;

    /**
     * @see #RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_FALSE
     * @see #RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_MASK = 0b00000000_00000000_00000100;

    /**
     * 0: Ready for Disconnect Supported False
     */
    public static final int RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Ready for Disconnect Supported True
     */
    public static final int RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE = 0b00000000_00000000_00000100;

    /**
     * @see #RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_MASK = 0b00000000_00000000_00001000;

    /**
     * 0: Propose Reconnection Timeout Supported False
     */
    public static final int RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Reconnection Timeout Supported True
     */
    public static final int RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE = 0b00000000_00000000_00001000;

    /**
     * @see #RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_MASK = 0b00000000_00000000_00010000;

    /**
     * 0: Propose Connection Interval Supported False
     */
    public static final int RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Connection Interval Supported True
     */
    public static final int RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE = 0b00000000_00000000_00010000;

    /**
     * @see #RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_MASK = 0b00000000_00000000_00100000;

    /**
     * 0: Propose Slave Latency Supported False
     */
    public static final int RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Slave Latency Supported True
     */
    public static final int RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_TRUE = 0b00000000_00000000_00100000;

    /**
     * @see #RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_MASK = 0b00000000_00000000_01000000;

    /**
     * 0: Propose Supervision Timeout Supported False
     */
    public static final int RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Supervision Timeout Supported True
     */
    public static final int RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE = 0b00000000_00000000_01000000;

    /**
     * @see #RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_MASK = 0b00000000_00000000_10000000;

    /**
     * 0: Propose Advertisement Interval Supported False
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Advertisement Interval Supported True
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE = 0b00000000_00000000_10000000;

    /**
     * @see #RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_MASK = 0b00000000_00000001_00000000;

    /**
     * 0: Propose Advertisement Count Supported False
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Advertisement Count Supported True
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE = 0b00000000_00000001_00000000;

    /**
     * @see #RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_FALSE
     * @see #RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_MASK = 0b00000000_00000010_00000000;

    /**
     * 0: Propose Advertisement Repetition Time Supported False
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Propose Advertisement Repetition Time Supported True
     */
    public static final int RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_TRUE = 0b00000000_00000010_00000000;

    /**
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_FALSE
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_MASK = 0b00000000_00000100_00000000;

    /**
     * 0: Advertisement Configuration 1 Supported False
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Advertisement Configuration 1 Supported True
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE = 0b00000000_00000100_00000000;

    /**
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_FALSE
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_MASK = 0b00000000_00001000_00000000;

    /**
     * 0: Advertisement Configuration 2 Supported False
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Advertisement Configuration 2 Supported True
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE = 0b00000000_00001000_00000000;

    /**
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_FALSE
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_MASK = 0b00000000_00010000_00000000;

    /**
     * 0: Advertisement Configuration 3 Supported False
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Advertisement Configuration 3 Supported True
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE = 0b00000000_00010000_00000000;

    /**
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_FALSE
     * @see #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_MASK = 0b00000000_00100000_00000000;

    /**
     * 0: Advertisement Configuration 4 Supported False
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Advertisement Configuration 4 Supported True
     */
    public static final int RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE = 0b00000000_00100000_00000000;

    /**
     * @see #RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_FALSE
     * @see #RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_MASK = 0b00000000_01000000_00000000;

    /**
     * 0: Upgrade to LESC Only Supported False
     */
    public static final int RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Upgrade to LESC Only Supported True
     */
    public static final int RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE = 0b00000000_01000000_00000000;

    /**
     * @see #RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_FALSE
     * @see #RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_MASK = 0b00000000_10000000_00000000;

    /**
     * 0: Next Pairing OOB Supported False
     */
    public static final int RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Next Pairing OOB Supported True
     */
    public static final int RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE = 0b00000000_10000000_00000000;

    /**
     * @see #RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_FALSE
     * @see #RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_MASK = 0b00000001_00000000_00000000;

    /**
     * 0: Use of White List Supported False
     */
    public static final int RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Use of White List Supported True
     */
    public static final int RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_TRUE = 0b00000001_00000000_00000000;

    /**
     * @see #RC_FEATURES_LIMITED_ACCESS_SUPPORTED_FALSE
     * @see #RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE
     */
    public static final int RC_FEATURES_LIMITED_ACCESS_SUPPORTED_MASK = 0b00000010_00000000_00000000;

    /**
     * 0: Limited Access Supported False
     */
    public static final int RC_FEATURES_LIMITED_ACCESS_SUPPORTED_FALSE = 0b00000000_00000000_00000000;

    /**
     * 1: Limited Access Supported True
     */
    public static final int RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE = 0b00000010_00000000_00000000;

    /**
     * Feature Extension bit
     */
    public static final int RC_FEATURES_FEATURE_EXTENSION_BIT = 0b10000000;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RCFeature> CREATOR = new ByteArrayCreater<RCFeature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCFeature createFromParcel(@NonNull Parcel in) {
            return new RCFeature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RCFeature[] newArray(int size) {
            return new RCFeature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RCFeature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(R_C_FEATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RCFeature(bluetoothGattCharacteristic);
        }

    };

    /**
     * E2E-CRC
     */
    private final int mE2eCrc;

    /**
     * RC Features
     */
    private final byte[] mRcFeatures;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B1D
     */
    public RCFeature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mE2eCrc = BLEUtils.createUInt16(values, 0);
        int lastFeaturesIndex = 4;
        while (lastFeaturesIndex < values.length) {
            if ((values[lastFeaturesIndex] & RC_FEATURES_FEATURE_EXTENSION_BIT) == RC_FEATURES_FEATURE_EXTENSION_BIT) {
                lastFeaturesIndex++;
            } else {
                break;
            }
        }
        mRcFeatures = Arrays.copyOfRange(values, 2, lastFeaturesIndex + 1);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RCFeature(@NonNull Parcel in) {
        mE2eCrc = in.readInt();
        mRcFeatures = in.createByteArray();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(mE2eCrc);
        dest.writeByteArray(mRcFeatures);
    }

    /**
     * @return E2E-CRC
     */
    public int getE2eCrc() {
        return mE2eCrc;
    }

    /**
     * @return {@code true}:device does not support E2E-safety, {@code false}:device support E2E-safety
     */
    public boolean isE2eCrcNotSupported() {
        return E2E_CRC_NOT_SUPPORTED == mE2eCrc;
    }

    /**
     * @return RC Features
     */
    @NonNull
    public byte[] getRcFeatures() {
        return mRcFeatures;
    }

    /**
     * @return {@code true}:E2E-CRC not Supported, {@code false}:E2E-CRC Supported
     */
    public boolean isRcFeaturesE2eCrcNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_E2E_CRC_SUPPORTED_MASK, RC_FEATURES_E2E_CRC_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:E2E-CRC Supported, {@code false}:E2E-CRC not Supported
     */
    public boolean isRcFeaturesE2eCrcSupported() {
        return isRCFeaturesMatched(RC_FEATURES_E2E_CRC_SUPPORTED_MASK, RC_FEATURES_E2E_CRC_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Enable Disconnect not Supported, {@code false}:Enable Disconnect Supported
     */
    public boolean isRcFeaturesEnableDisconnectNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_MASK, RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Enable Disconnect Supported, {@code false}:Enable Disconnect not Supported
     */
    public boolean isRcFeaturesEnableDisconnectSupported() {
        return isRCFeaturesMatched(RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_MASK, RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Ready for Disconnect not Supported, {@code false}:Ready for Disconnect Supported
     */
    public boolean isRcFeaturesReadyForDisconnectNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_MASK, RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Ready for Disconnect Supported, {@code false}:Ready for Disconnect not Supported
     */
    public boolean isRcFeaturesReadyForDisconnectSupported() {
        return isRCFeaturesMatched(RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_MASK, RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Reconnection Timeout not Supported, {@code false}:Propose Reconnection Timeout Supported
     */
    public boolean isRcFeaturesProposeReconnectionTimeoutNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_MASK, RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Reconnection Timeout Supported, {@code false}:Propose Reconnection Timeout not Supported
     */
    public boolean isRcFeaturesProposeReconnectionTimeoutSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_MASK, RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Connection Interval not Supported, {@code false}:Propose Connection Interval Supported
     */
    public boolean isRcFeaturesProposeConnectionIntervalNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_MASK, RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Connection Interval Supported, {@code false}:Propose Connection Interval not Supported
     */
    public boolean isRcFeaturesProposeConnectionIntervalSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_MASK, RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Slave Latency not Supported, {@code false}:Propose Slave Latency Supported
     */
    public boolean isRcFeaturesProposeSlaveLatencyNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_MASK, RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Slave Latency Supported, {@code false}:Propose Slave Latency not Supported
     */
    public boolean isRcFeaturesProposeSlaveLatencySupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_MASK, RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Supervision Timeout not Supported, {@code false}:Propose Supervision Timeout Supported
     */
    public boolean isRcFeaturesProposeSupervisionTimeoutNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_MASK, RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Supervision Timeout Supported, {@code false}:Propose Supervision Timeout not Supported
     */
    public boolean isRcFeaturesProposeSupervisionTimeoutSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_MASK, RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Advertisement Interval not Supported, {@code false}:Propose Advertisement Interval Supported
     */
    public boolean isRcFeaturesProposeAdvertisementIntervalNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_MASK, RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Advertisement Interval Supported, {@code false}:Propose Advertisement Interval not Supported
     */
    public boolean isRcFeaturesProposeAdvertisementIntervalSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_MASK, RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Advertisement Count not Supported, {@code false}:Propose Advertisement Count Supported
     */
    public boolean isRcFeaturesProposeAdvertisementCountNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_MASK, RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Advertisement Count Supported, {@code false}:Propose Advertisement Count not Supported
     */
    public boolean isRcFeaturesProposeAdvertisementCountSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_MASK, RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Propose Advertisement Repetition Time not Supported, {@code false}:Propose Advertisement Repetition Time Supported
     */
    public boolean isRcFeaturesProposeAdvertisementRepetitionTimeNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_MASK, RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Propose Advertisement Repetition Time Supported, {@code false}:Propose Advertisement Repetition Time not Supported
     */
    public boolean isRcFeaturesProposeAdvertisementRepetitionTimeSupported() {
        return isRCFeaturesMatched(RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_MASK, RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 1 not Supported, {@code false}:Advertisement Configuration 1 Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration1NotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 1 Supported, {@code false}:Advertisement Configuration 1 not Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration1Supported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 2 not Supported, {@code false}:Advertisement Configuration 2 Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration2NotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 2 Supported, {@code false}:Advertisement Configuration 2 not Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration2Supported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 3 not Supported, {@code false}:Advertisement Configuration 3 Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration3NotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 3 Supported, {@code false}:Advertisement Configuration 3 not Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration3Supported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 4 not Supported, {@code false}:Advertisement Configuration 4 Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration4NotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Advertisement Configuration 4 Supported, {@code false}:Advertisement Configuration 4 not Supported
     */
    public boolean isRcFeaturesAdvertisementConfiguration4Supported() {
        return isRCFeaturesMatched(RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_MASK, RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Upgrade to LESC Only not Supported, {@code false}:Upgrade to LESC Only Supported
     */
    public boolean isRcFeaturesUpgradeToLescOnlyNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_MASK, RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Upgrade to LESC Only Supported, {@code false}:Upgrade to LESC Only not Supported
     */
    public boolean isRcFeaturesUpgradeToLescOnlySupported() {
        return isRCFeaturesMatched(RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_MASK, RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Next Pairing OOB not Supported, {@code false}:Next Pairing OOB Supported
     */
    public boolean isRcFeaturesNextPairingOobNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_MASK, RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Next Pairing OOB Supported, {@code false}:Next Pairing OOB not Supported
     */
    public boolean isRcFeaturesNextPairingOobSupported() {
        return isRCFeaturesMatched(RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_MASK, RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Use of White List not Supported, {@code false}:Use of White List Supported
     */
    public boolean isRcFeaturesUseOfWhiteListNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_MASK, RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Use of White List Supported, {@code false}:Use of White List not Supported
     */
    public boolean isRcFeaturesUseOfWhiteListSupported() {
        return isRCFeaturesMatched(RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_MASK, RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_TRUE);
    }

    /**
     * @return {@code true}:Limited Access Supported, {@code false}:Limited Access Supported
     */
    public boolean isRcFeaturesLimitedAccessNotSupported() {
        return isRCFeaturesMatched(RC_FEATURES_LIMITED_ACCESS_SUPPORTED_MASK, RC_FEATURES_LIMITED_ACCESS_SUPPORTED_FALSE);
    }

    /**
     * @return {@code true}:Limited Access Supported, {@code false}:Limited Access Supported
     */
    public boolean isRcFeaturesLimitedAccessSupported() {
        return isRCFeaturesMatched(RC_FEATURES_LIMITED_ACCESS_SUPPORTED_MASK, RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2 + mRcFeatures.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mE2eCrc);
        byteBuffer.put(mRcFeatures);
        return data;
    }

    /**
     * check Flags
     *
     * @param mask   bitmask for expect
     * @param expect one of {@link #RC_FEATURES_E2E_CRC_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_E2E_CRC_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_ENABLE_DISCONNECT_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_READY_FOR_DISCONNECT_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_RECONNECTION_TIMEOUT_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_CONNECTION_INTERVAL_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_SLAVE_LATENCY_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_SUPERVISION_TIMEOUT_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_ADVERTISEMENT_INTERVAL_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_ADVERTISEMENT_COUNT_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_PROPOSE_ADVERTISEMENT_REPETITION_TIME_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_1_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_2_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_3_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_ADVERTISEMENT_CONFIGURATION_4_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_UPGRADE_TO_LESC_ONLY_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_NEXT_PAIRING_OOB_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_USE_OF_WHILE_LIST_SUPPORTED_TRUE}
     *               , {@link #RC_FEATURES_LIMITED_ACCESS_SUPPORTED_FALSE}
     *               , {@link #RC_FEATURES_LIMITED_ACCESS_SUPPORTED_TRUE}
     * @return {@code true}:same as expect, {@code false}:not match
     */
    private boolean isRCFeaturesMatched(int mask, int expect) {
        return (mask & BLEUtils.createSInt24(mRcFeatures, 0)) == expect;
    }

}
