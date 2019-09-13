package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_ANTENNA_SWITCHING_DURING_CTE_RECEPTION_AOA;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_ANTENNA_SWITCHING_DURING_CTE_TRANSMISSION_AOD;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_CHANNEL_SELCTION_ALGORITHM_2;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_CONNECTIONLESS_CTE_RECEIVER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_CONNECTIONLESS_CTE_TRANSMITTER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_CONNECTION_CTE_REQUEST;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_CONNECTION_CTE_RESPONSE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_CONNECTION_PARAMETERS_REQUEST_PROCEDURE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_EXTENDED_REJECT_INDICATION;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_EXTENDED_SCANNER_FILTER_POLICIES;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_2M_PHY;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_CODED_PHY;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_DATA_PACKET_LENGTH_EXTENSION;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_EXTENDED_ADVERTISING;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_PERIODIC_ADVERTISING;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_PING;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LE_POWER_CLASS_1;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_LL_PRIVACY;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_MINIMUM_NUMBER_OF_USED_CHANNELS_PROCEDURE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_PERIODIC_ADVERTISING_SYNC_TRANSFER_RECIPIENT;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_PERIODIC_ADVERTISING_SYNC_TRANSFER_SENDER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_RECEIVING_CONSTANT_TONE_EXTENSIONS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_REMOTE_PUBLIC_KEY_VALIDATION;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_SLAVE_INITIATED_FEATURES_EXCHANGE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_SLEEP_CLOCK_ACCURACY_UPDATES;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_STABLE_MODULATION_INDEX_RECEIVER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_STABLE_MODULATION_INDEX_TRANSMITTER;
import static org.im97mori.ble.ad.AdvertisingDataConstants.LeSupportedFeatures.FEATURE_SUPPORTED_FEATURE_LE_ENCRYPTION;

/**
 * <p>
 * LE Supported Features
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * Core Specification v5.1 Vol 6 Part B 4.6
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class LeSupportedFeatures extends AbstractAdvertisingData {

    /**
     * @see android.os.Parcelable.Creator
     */
    public static final Parcelable.Creator<LeSupportedFeatures> CREATOR = new Parcelable.Creator<LeSupportedFeatures>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public LeSupportedFeatures createFromParcel(Parcel in) {
            return new LeSupportedFeatures(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public LeSupportedFeatures[] newArray(int size) {
            return new LeSupportedFeatures[size];
        }

    };

    /**
     * LE Supported Features list
     */
    private final List<Integer> mLeSupportedFeaturesList;

    /**
     * Constructor for LE Supported Features
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public LeSupportedFeatures(byte[] data, int offset, int length) {
        super(length);

        List<Integer> leSupportedFeaturesList = new ArrayList<>();
        for (int i = offset + 2; i < offset + length + 1; i++) {
            leSupportedFeaturesList.add(data[i] & 0xff);
        }
        mLeSupportedFeaturesList = Collections.synchronizedList(Collections.unmodifiableList(leSupportedFeaturesList));
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LeSupportedFeatures(Parcel in) {
        super(in.readInt());

        List<Integer> list = new ArrayList<>();
        in.readList(list, this.getClass().getClassLoader());
        mLeSupportedFeaturesList = Collections.synchronizedList(list);
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
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mLength);
        dest.writeList(mLeSupportedFeaturesList);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_LE_SUPPORTED_FEATURES;
    }

    /**
     * @return LE Supported Features list
     */
    public List<Integer> getLeSupportedFeaturesList() {
        return mLeSupportedFeaturesList;
    }

    /**
     * check LE Encryption
     *
     * @return {@code true}:LE Encryption bit is 1, {@code false}:bit is 0;
     */
    public boolean isLeEncryptionSupported() {
        return check(FEATURE_SUPPORTED_FEATURE_LE_ENCRYPTION);
    }

    /**
     * check Connection Parameters Request Procedure
     *
     * @return {@code true}:Connection Parameters Request Procedure bit is 1, {@code false}:bit is 0;
     */
    public boolean isConnectionParametersRequestProcedureSupported() {
        return check(FEATURE_CONNECTION_PARAMETERS_REQUEST_PROCEDURE);
    }

    /**
     * check Extended Reject Indication
     *
     * @return {@code true}:Extended Reject Indication bit is 1, {@code false}:bit is 0;
     */
    public boolean isExtendedRejectIndicationSupported() {
        return check(FEATURE_EXTENDED_REJECT_INDICATION);
    }

    /**
     * check Slave-initiated Features Exchange
     *
     * @return {@code true}:Slave-initiated Features Exchange bit is 1, {@code false}:bit is 0;
     */
    public boolean isSlaveInitiatedFeaturesExchangeSupported() {
        return check(FEATURE_SLAVE_INITIATED_FEATURES_EXCHANGE);
    }

    /**
     * check LE Ping
     *
     * @return {@code true}:LE Ping bit is 1, {@code false}:bit is 0;
     */
    public boolean isLePingSupported() {
        return check(FEATURE_LE_PING);
    }

    /**
     * check LE Data Packet Length Extension
     *
     * @return {@code true}:LE Data Packet Length Extension bit is 1, {@code false}:bit is 0;
     */
    public boolean isLeDataPacketLengthExtensionSupported() {
        return check(FEATURE_LE_DATA_PACKET_LENGTH_EXTENSION);
    }

    /**
     * check LL Privacy
     *
     * @return {@code true}:LL Privacy bit is 1, {@code false}:bit is 0;
     */
    public boolean isLlPrivacySupported() {
        return check(FEATURE_LL_PRIVACY);
    }

    /**
     * check Extended Scanner Filter Policies
     *
     * @return {@code true}:Extended Scanner Filter Policies bit is 1, {@code false}:bit is 0;
     */
    public boolean isExtendedScannerFilterPoliciesSupported() {
        return check(FEATURE_EXTENDED_SCANNER_FILTER_POLICIES);
    }

    /**
     * check LE 2M PHY
     *
     * @return {@code true}:LE 2M PHY bit is 1, {@code false}:bit is 0;
     */
    public boolean isLe2mPhySupported() {
        return check(FEATURE_LE_2M_PHY);
    }

    /**
     * check Stable Modulation Index - Transmitter
     *
     * @return {@code true}:Stable Modulation Index - Transmitter bit is 1, {@code false}:bit is 0;
     */
    public boolean isStableModulationIndexTransmitterSupported() {
        return check(FEATURE_STABLE_MODULATION_INDEX_TRANSMITTER);
    }

    /**
     * check Stable Modulation Index - Receiver
     *
     * @return {@code true}:Stable Modulation Index - Receiver bit is 1, {@code false}:bit is 0;
     */
    public boolean isStableModulationIndexReceiverSupported() {
        return check(FEATURE_STABLE_MODULATION_INDEX_RECEIVER);
    }

    /**
     * check LE Coded PHY
     *
     * @return {@code true}:LE Coded PHY bit is 1, {@code false}:bit is 0;
     */
    public boolean isLeCodedPhySupported() {
        return check(FEATURE_LE_CODED_PHY);
    }

    /**
     * check LE Extended Advertising
     *
     * @return {@code true}:LE Extended Advertising bit is 1, {@code false}:bit is 0;
     */
    public boolean isLeExtendedAdvertisingSupported() {
        return check(FEATURE_LE_EXTENDED_ADVERTISING);
    }

    /**
     * check LE Periodic Advertising
     *
     * @return {@code true}:LE Periodic Advertising bit is 1, {@code false}:bit is 0;
     */
    public boolean isLePeriodicAdvertisingSupported() {
        return check(FEATURE_LE_PERIODIC_ADVERTISING);
    }

    /**
     * check Channel Selection Algorithm #2
     *
     * @return {@code true}:Channel Selection Algorithm #2 bit is 1, {@code false}:bit is 0;
     */
    public boolean isChannelSelectionAlgorithm2Supported() {
        return check(FEATURE_CHANNEL_SELCTION_ALGORITHM_2);
    }

    /**
     * check LE Power Class 1
     *
     * @return {@code true}:LE Power Class 1 bit is 1, {@code false}:bit is 0;
     */
    public boolean isLePowerClass1Supported() {
        return check(FEATURE_LE_POWER_CLASS_1);
    }

    /**
     * check Minimum Number of Used Channels Procedure
     *
     * @return {@code true}:Minimum Number of Used Channels Procedure bit is 1, {@code false}:bit is 0;
     */
    public boolean isMinimumNumberOfUsedChannelsProcedureSupported() {
        return check(FEATURE_MINIMUM_NUMBER_OF_USED_CHANNELS_PROCEDURE);
    }

    /**
     * check Connection CTE Request
     *
     * @return {@code true}:Connection CTE Request bit is 1, {@code false}:bit is 0;
     */
    public boolean isConnectionCteRequestSupported() {
        return check(FEATURE_CONNECTION_CTE_REQUEST);
    }

    /**
     * check Connection CTE Response
     *
     * @return {@code true}:Connection CTE Response bit is 1, {@code false}:bit is 0;
     */
    public boolean isConnectionCteResponseSupported() {
        return check(FEATURE_CONNECTION_CTE_RESPONSE);
    }

    /**
     * check Connectionless CTE Transmitter
     *
     * @return {@code true}:Connectionless CTE Transmitter bit is 1, {@code false}:bit is 0;
     */
    public boolean isConnectionlessCteTransmitterSupported() {
        return check(FEATURE_CONNECTIONLESS_CTE_TRANSMITTER);
    }

    /**
     * check Connectionless CTE Receiver
     *
     * @return {@code true}:Connectionless CTE Receiver bit is 1, {@code false}:bit is 0;
     */
    public boolean isConnectionlessCteReceiverSupported() {
        return check(FEATURE_CONNECTIONLESS_CTE_RECEIVER);
    }

    /**
     * check Antenna Switching During CTE Transmission (AoD)
     *
     * @return {@code true}:Antenna Switching During CTE Transmission (AoD) bit is 1, {@code false}:bit is 0;
     */
    public boolean isAntennaSwitchingDuringCteTransmissionAodSupported() {
        return check(FEATURE_ANTENNA_SWITCHING_DURING_CTE_TRANSMISSION_AOD);
    }

    /**
     * check Antenna Switching During CTE Reception (AoA)
     *
     * @return {@code true}:Antenna Switching During CTE Transmission (AoD) bit is 1, {@code false}:bit is 0;
     */
    public boolean isAntennaSwitchingDuringCteReceptionAoaSupported() {
        return check(FEATURE_ANTENNA_SWITCHING_DURING_CTE_RECEPTION_AOA);
    }

    /**
     * check Receiving Constant Tone Extensions
     *
     * @return {@code true}:Receiving Constant Tone Extensions bit is 1, {@code false}:bit is 0;
     */
    public boolean isReceivingConstantToneExtensionsSupported() {
        return check(FEATURE_RECEIVING_CONSTANT_TONE_EXTENSIONS);
    }

    /**
     * check Periodic Advertising Sync Transfer - Sender
     *
     * @return {@code true}:Periodic Advertising Sync Transfer - Sender bit is 1, {@code false}:bit is 0;
     */
    public boolean isPeriodicAdvertisingSyncTransferSenderSupported() {
        return check(FEATURE_PERIODIC_ADVERTISING_SYNC_TRANSFER_SENDER);
    }

    /**
     * check Periodic Advertising Sync Transfer - Recipient
     *
     * @return {@code true}:Periodic Advertising Sync Transfer - Recipient bit is 1, {@code false}:bit is 0;
     */
    public boolean isPeriodicAdvertisingSyncTransferRecipientSupported() {
        return check(FEATURE_PERIODIC_ADVERTISING_SYNC_TRANSFER_RECIPIENT);
    }

    /**
     * check Sleep Clock Accuracy Updates
     *
     * @return {@code true}:Sleep Clock Accuracy Updates bit is 1, {@code false}:bit is 0;
     */
    public boolean isSleepClockAccuracyUpdatesSupported() {
        return check(FEATURE_SLEEP_CLOCK_ACCURACY_UPDATES);
    }

    /**
     * check Remote Public Key Validation
     *
     * @return {@code true}:Remote Public Key Validation bit is 1, {@code false}:bit is 0;
     */
    public boolean isRemotePublicKeyValidationSupported() {
        return check(FEATURE_REMOTE_PUBLIC_KEY_VALIDATION);
    }

    /**
     * check flag
     *
     * @param target one of {@link AdvertisingDataConstants.LeSupportedFeatures}
     * @return {@code true}:target bit is 1, {@code false}:target bit is 0
     */
    private boolean check(Pair<Integer, Integer> target) {
        boolean result;
        int index = target.first;
        if (mLeSupportedFeaturesList.size() > target.first) {
            result = (mLeSupportedFeaturesList.get(index) & target.second) != 0;
        } else {
            result = false;
        }
        return result;
    }

}
