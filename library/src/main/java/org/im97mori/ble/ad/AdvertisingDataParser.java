package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_ADVERTISING_INTERVAL;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_FLAGS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_PUBLIC_TARGET_ADDRESS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_RANDOM_TARGET_ADDRESS;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SHORTENED_LOCAL_NAME;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;
import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;

/**
 * Parser for {@link ScanRecord#getBytes()}
 */
@SuppressWarnings("WeakerAccess")
public class AdvertisingDataParser {

    /**
     * Builder for {@link AdvertisingDataParser}
     */
    @SuppressWarnings("UnusedReturnValue")
    public static class Builder {

        /**
         * <p>
         * All Advertising Data Type set
         *
         * @see AdvertisingDataConstants.AdvertisingDataTypes
         * </p>
         */
        private static final Set<Integer> ALL_DATA_TYPE_SET;

        static {
            Set<Integer> set = new HashSet<>();
            set.add(DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
            set.add(DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS);
            set.add(DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
            set.add(DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS);
            set.add(DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
            set.add(DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS);
            set.add(DATA_TYPE_SHORTENED_LOCAL_NAME);
            set.add(DATA_TYPE_COMPLETE_LOCAL_NAME);
            set.add(DATA_TYPE_FLAGS);
            set.add(DATA_TYPE_MANUFACTURER_SPECIFIC_DATA);
            set.add(DATA_TYPE_TX_POWER_LEVEL);
            set.add(DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE);
            set.add(DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS);
            set.add(DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS);
            set.add(DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS);
            set.add(DATA_TYPE_SERVICE_DATA_16_BIT_UUID);
            set.add(DATA_TYPE_SERVICE_DATA_32_BIT_UUID);
            set.add(DATA_TYPE_SERVICE_DATA_128_BIT_UUID);
            set.add(DATA_TYPE_APPEARANCE);
            set.add(DATA_TYPE_PUBLIC_TARGET_ADDRESS);
            set.add(DATA_TYPE_RANDOM_TARGET_ADDRESS);
            set.add(DATA_TYPE_ADVERTISING_INTERVAL);
            set.add(DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER);
            set.add(DATA_TYPE_LE_SUPPORTED_FEATURES);
            set.add(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);

            ALL_DATA_TYPE_SET = Collections.synchronizedSet(Collections.synchronizedSet(set));
        }

        /**
         * parse target Advertising Data Type set
         */
        private final Set<Integer> mTypeSet = new HashSet<>();

        /**
         * constructor
         *
         * @param isIncludeAll {@code true}:include all data type, {@code false}:exclude all data type
         */
        public Builder(boolean isIncludeAll) {
            if (isIncludeAll) {
                mTypeSet.addAll(ALL_DATA_TYPE_SET);
            }
        }

        /**
         * include All Advertising Data Type
         *
         * @return myself
         */
        public Builder includeAll() {
            mTypeSet.addAll(ALL_DATA_TYPE_SET);
            return this;
        }

        /**
         * include Advertising Data Type
         *
         * @param advertisingDataTypes one of {@link AdvertisingDataConstants.AdvertisingDataTypes}
         * @return myself
         */
        public Builder include(int advertisingDataTypes) {
            if (ALL_DATA_TYPE_SET.contains(advertisingDataTypes)) {
                mTypeSet.add(advertisingDataTypes);
            }
            return this;
        }

        /**
         * exclude All Advertising Data Type
         *
         * @return myself
         */
        public Builder excludeAll() {
            mTypeSet.clear();
            return this;
        }

        /**
         * exclude Advertising Data Type
         *
         * @param advertisingDataTypes one of {@link AdvertisingDataConstants.AdvertisingDataTypes}
         * @return myself
         */
        public Builder exclude(int advertisingDataTypes) {
            mTypeSet.remove(advertisingDataTypes);
            return this;
        }

        /**
         * build {@link AdvertisingDataParser}instance
         *
         * @return {@link AdvertisingDataParser}
         */
        public AdvertisingDataParser build() {
            return new AdvertisingDataParser(mTypeSet);
        }
    }

    /**
     * parse result for Advertising Data
     */
    public static class AdvertisingDataParseResult {

        /**
         * all parsed data list
         */
        private List<AbstractAdvertisingData> mResultList;

        /**
         * Latest Incomplete List of 16-bit Service Class UUIDs
         */
        private IncompleteListOf16BitServiceUUIDs mIncompleteListOf16BitServiceUUIDs;

        /**
         * All Incomplete List of 16-bit Service Class UUIDs List
         */
        private final List<IncompleteListOf16BitServiceUUIDs> mIncompleteListOf16BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Complete List of 16-bit Service Class UUIDs
         */
        private CompleteListOf16BitServiceUUIDs mCompleteListOf16BitServiceUUIDs;

        /**
         * All Complete List of 16-bit Service Class UUIDs List
         */
        private final List<CompleteListOf16BitServiceUUIDs> mCompleteListOf16BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Incomplete List of 32-bit Service Class UUIDs
         */
        private IncompleteListOf32BitServiceUUIDs mIncompleteListOf32BitServiceUUIDs;

        /**
         * All Incomplete List of 32-bit Service Class UUIDs List
         */
        private final List<IncompleteListOf32BitServiceUUIDs> mIncompleteListOf32BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Complete List of 32-bit Service Class UUIDs
         */
        private CompleteListOf32BitServiceUUIDs mCompleteListOf32BitServiceUUIDs;

        /**
         * All Complete List of 32-bit Service Class UUIDs List
         */
        private final List<CompleteListOf32BitServiceUUIDs> mCompleteListOf32BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Incomplete List of 128-bit Service Class UUIDs
         */
        private IncompleteListOf128BitServiceUUIDs mIncompleteListOf128BitServiceUUIDs;

        /**
         * All Incomplete List of 128-bit Service Class UUIDs List
         */
        private final List<IncompleteListOf128BitServiceUUIDs> mIncompleteListOf128BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Complete List of 128-bit Service Class UUIDs
         */
        private CompleteListOf128BitServiceUUIDs mCompleteListOf128BitServiceUUIDs;

        /**
         * All Complete List of 128-bit Service Class UUIDs List
         */
        private final List<CompleteListOf128BitServiceUUIDs> mCompleteListOf128BitServiceUUIDsList = new ArrayList<>();

        /**
         * Shortened Local Name
         */
        private ShortenedLocalName mShortenedLocalName;

        /**
         * Complete Local Name
         */
        private CompleteLocalName mCompleteLocalName;

        /**
         * Flags
         */
        private Flags mFlags;

        /**
         * Latest Manufacturer Specific Data
         */
        private ManufacturerSpecificData mManufacturerSpecificData;

        /**
         * All Manufacturer Specific Data List
         */
        private final List<ManufacturerSpecificData> mManufacturerSpecificDataList = new ArrayList<>();

        /**
         * Latest Tx Power Level
         */
        private TxPowerLevel mTxPowerLevel;

        /**
         * All Tx Power Level List
         */
        private final List<TxPowerLevel> mTxPowerLevelList = new ArrayList<>();

        /**
         * Latest Slave Connection Interval Range
         */
        private SlaveConnectionIntervalRange mSlaveConnectionIntervalRange;

        /**
         * All Slave Connection Interval Range List
         */
        private final List<SlaveConnectionIntervalRange> mSlaveConnectionIntervalRangeList = new ArrayList<>();

        /**
         * Latest List of 16-bit Service Solicitation UUIDs
         */
        private ListOf16BitServiceSolicitationUUIDs mListOf16BitServiceSolicitationUUIDs;

        /**
         * All List of 16-bit Service Solicitation UUIDs List
         */
        private final List<ListOf16BitServiceSolicitationUUIDs> mListOf16BitServiceSolicitationUUIDsList = new ArrayList<>();

        /**
         * Latest List of 32-bit Service Solicitation UUIDs
         */
        private ListOf32BitServiceSolicitationUUIDs mListOf32BitServiceSolicitationUUIDs;

        /**
         * All List of 32-bit Service Solicitation UUIDs List
         */
        private final List<ListOf32BitServiceSolicitationUUIDs> mListOf32BitServiceSolicitationUUIDsList = new ArrayList<>();

        /**
         * Latest List of 128-bit Service Solicitation UUIDs
         */
        private ListOf128BitServiceSolicitationUUIDs mListOf128BitServiceSolicitationUUIDs;

        /**
         * All List of 128-bit Service Solicitation UUIDs List
         */
        private final List<ListOf128BitServiceSolicitationUUIDs> mListOf128BitServiceSolicitationUUIDsList = new ArrayList<>();

        /**
         * Latest Service Data - 16-bit UUID
         */
        private ServiceData16BitUUID mServiceData16BitUUID;

        /**
         * All Service Data - 16-bit UUID List
         */
        private final List<ServiceData16BitUUID> mServiceData16BitUUIDList = new ArrayList<>();

        /**
         * Latest Service Data - 32-bit UUID
         */
        private ServiceData32BitUUID mServiceData32BitUUID;

        /**
         * All Service Data - 32-bit UUID List
         */
        private final List<ServiceData32BitUUID> mServiceData32BitUUIDList = new ArrayList<>();

        /**
         * Latest Service Data - 128-bit UUID
         */
        private ServiceData128BitUUID mServiceData128BitUUID;

        /**
         * All Service Data - 128-bit UUID List
         */
        private final List<ServiceData128BitUUID> mServiceData128BitUUIDList = new ArrayList<>();

        /**
         * Appearance
         */
        private Appearance mAppearance;

        /**
         * Public Target Address
         */
        private PublicTargetAddress mPublicTargetAddress;

        /**
         * Random Target Address
         */
        private RandomTargetAddress mRandomTargetAddress;

        /**
         * Advertising Interval
         */
        private AdvertisingInterval mAdvertisingInterval;

        /**
         * Latest URI
         */
        private UniformRsourceIdentifier mUniformRsourceIdentifier;

        /**
         * All URI List
         */
        private final List<UniformRsourceIdentifier> mUniformRsourceIdentifierList = new ArrayList<>();

        /**
         * LE Supported Features
         */
        private LeSupportedFeatures mLeSupportedFeatures;

        /**
         * Channel Map Update Indication
         */
        private ChannelMapUpdateIndication mChannelMapUpdateIndication;

        /**
         * @return all parsed data list
         */
        public List<AbstractAdvertisingData> getResultList() {
            return mResultList;
        }

        /**
         * @return Latest Incomplete List of 16-bit Service Class UUIDs
         */
        public IncompleteListOf16BitServiceUUIDs getIncompleteListOf16BitServiceUUIDs() {
            return mIncompleteListOf16BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 16-bit Service Class UUIDs List
         */
        public List<IncompleteListOf16BitServiceUUIDs> getIncompleteListOf16BitServiceUUIDsList() {
            return mIncompleteListOf16BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 16-bit Service Class UUIDs
         */
        public CompleteListOf16BitServiceUUIDs getCompleteListOf16BitServiceUUIDs() {
            return mCompleteListOf16BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 16-bit Service Class UUIDs List
         */
        public List<CompleteListOf16BitServiceUUIDs> getCompleteListOf16BitServiceUUIDsList() {
            return mCompleteListOf16BitServiceUUIDsList;
        }

        /**
         * @return Latest Incomplete List of 32-bit Service Class UUIDs
         */
        public IncompleteListOf32BitServiceUUIDs getIncompleteListOf32BitServiceUUIDs() {
            return mIncompleteListOf32BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 32-bit Service Class UUIDs List
         */
        public List<IncompleteListOf32BitServiceUUIDs> getIncompleteListOf32BitServiceUUIDsList() {
            return mIncompleteListOf32BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 32-bit Service Class UUIDs
         */
        public CompleteListOf32BitServiceUUIDs getCompleteListOf32BitServiceUUIDs() {
            return mCompleteListOf32BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 32-bit Service Class UUIDs List
         */
        public List<CompleteListOf32BitServiceUUIDs> getCompleteListOf32BitServiceUUIDsList() {
            return mCompleteListOf32BitServiceUUIDsList;
        }

        /**
         * @return Latest Incomplete List of 128-bit Service Class UUIDs
         */
        public IncompleteListOf128BitServiceUUIDs getIncompleteListOf128BitServiceUUIDs() {
            return mIncompleteListOf128BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 128-bit Service Class UUIDs List
         */
        public List<IncompleteListOf128BitServiceUUIDs> getIncompleteListOf128BitServiceUUIDsList() {
            return mIncompleteListOf128BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 128-bit Service Class UUIDs
         */
        public CompleteListOf128BitServiceUUIDs getCompleteListOf128BitServiceUUIDs() {
            return mCompleteListOf128BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 128-bit Service Class UUIDs List
         */
        public List<CompleteListOf128BitServiceUUIDs> getCompleteListOf128BitServiceUUIDsList() {
            return mCompleteListOf128BitServiceUUIDsList;
        }

        /**
         * @return Shortened Local Name
         */
        public ShortenedLocalName getShortenedLocalName() {
            return mShortenedLocalName;
        }

        /**
         * @return Complete Local Name
         */
        public CompleteLocalName getCompleteLocalName() {
            return mCompleteLocalName;
        }

        /**
         * @return Flags
         */
        public Flags getFlags() {
            return mFlags;
        }

        /**
         * @return Latest Manufacturer Specific Data
         */
        public ManufacturerSpecificData getManufacturerSpecificData() {
            return mManufacturerSpecificData;
        }

        /**
         * @return All Manufacturer Specific Datas List
         */
        public List<ManufacturerSpecificData> getManufacturerSpecificDataList() {
            return mManufacturerSpecificDataList;
        }

        /**
         * @return Latest Tx Power Level
         */
        public TxPowerLevel getTxPowerLevel() {
            return mTxPowerLevel;
        }

        /**
         * @return All Tx Power Level List
         */
        public List<TxPowerLevel> getTxPowerLevelList() {
            return mTxPowerLevelList;
        }

        /**
         * @return Latest Slave Connection Interval Range
         */
        public SlaveConnectionIntervalRange getSlaveConnectionIntervalRange() {
            return mSlaveConnectionIntervalRange;
        }

        /**
         * @return All All Slave Connection Interval Range List List
         */
        public List<SlaveConnectionIntervalRange> getSlaveConnectionIntervalRangeList() {
            return mSlaveConnectionIntervalRangeList;
        }

        /**
         * @return Latest List of 16-bit Service Solicitation UUIDs
         */
        public ListOf16BitServiceSolicitationUUIDs getListOf16BitServiceSolicitationUUIDs() {
            return mListOf16BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 16-bit Service Solicitation UUIDs List
         */
        public List<ListOf16BitServiceSolicitationUUIDs> getListOf16BitServiceSolicitationUUIDsList() {
            return mListOf16BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest List of 32-bit Service Solicitation UUIDs
         */
        public ListOf32BitServiceSolicitationUUIDs getListOf32BitServiceSolicitationUUIDs() {
            return mListOf32BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 16-bit Service Solicitation UUIDs List
         */
        public List<ListOf32BitServiceSolicitationUUIDs> getListOf32BitServiceSolicitationUUIDsList() {
            return mListOf32BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest List of 128-bit Service Solicitation UUIDs
         */
        public ListOf128BitServiceSolicitationUUIDs getListOf128BitServiceSolicitationUUIDs() {
            return mListOf128BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 128-bit Service Solicitation UUIDs List
         */
        public List<ListOf128BitServiceSolicitationUUIDs> getListOf128BitServiceSolicitationUUIDsList() {
            return mListOf128BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest Service Data - 16-bit UUID
         */
        public ServiceData16BitUUID getServiceData16BitUUID() {
            return mServiceData16BitUUID;
        }

        /**
         * @return All Service Data - 16-bit UUID List
         */
        public List<ServiceData16BitUUID> getServiceData16BitUUIDList() {
            return mServiceData16BitUUIDList;
        }

        /**
         * @return Latest Service Data - 32-bit UUID
         */
        public ServiceData32BitUUID getServiceData32BitUUID() {
            return mServiceData32BitUUID;
        }

        /**
         * @return All Service Data - 32-bit UUID List
         */
        public List<ServiceData32BitUUID> getServiceData32BitUUIDList() {
            return mServiceData32BitUUIDList;
        }

        /**
         * @return Latest Service Data - 128-bit UUID
         */
        public ServiceData128BitUUID getServiceData128BitUUID() {
            return mServiceData128BitUUID;
        }

        /**
         * @return All Service Data - 128-bit UUID List
         */
        public List<ServiceData128BitUUID> getServiceData128BitUUIDList() {
            return mServiceData128BitUUIDList;
        }

        /**
         * @return Appearance
         */
        public Appearance getAppearance() {
            return mAppearance;
        }

        /**
         * @return Public Target Address
         */
        public PublicTargetAddress getPublicTargetAddress() {
            return mPublicTargetAddress;
        }

        /**
         * @return Random Target Address
         */
        public RandomTargetAddress getRandomTargetAddress() {
            return mRandomTargetAddress;
        }

        /**
         * @return Advertising Interval
         */
        public AdvertisingInterval getAdvertisingInterval() {
            return mAdvertisingInterval;
        }

        /**
         * @return Latest URI
         */
        public UniformRsourceIdentifier getUniformRsourceIdentifier() {
            return mUniformRsourceIdentifier;
        }

        /**
         * @return All URI List
         */
        public List<UniformRsourceIdentifier> getUniformRsourceIdentifierList() {
            return mUniformRsourceIdentifierList;
        }

        /**
         * @return LE Supported Features
         */
        public LeSupportedFeatures getLeSupportedFeatures() {
            return mLeSupportedFeatures;
        }

        /**
         * @return Channel Map Update Indication
         */
        public ChannelMapUpdateIndication getChannelMapUpdateIndication() {
            return mChannelMapUpdateIndication;
        }

    }

    /**
     * parse target data type set
     */
    private final Set<Integer> mTargetDataTypeSet;

    /**
     * @param targetDataTypeSet parse target data type set
     * @see Builder#build()
     */
    private AdvertisingDataParser(Set<Integer> targetDataTypeSet) {
        mTargetDataTypeSet = targetDataTypeSet;
    }

    /**
     * @see #parse(byte[], int, int)
     */
    public AdvertisingDataParseResult parse(byte[] data) {
        return parse(data, 0, data.length);
    }

    /**
     * parse Advertising Data
     *
     * @param data        {@link ScanRecord#getBytes()}
     * @param offset      data offset
     * @param totalLength data length
     * @return {@link AdvertisingDataParseResult}
     */
    public AdvertisingDataParseResult parse(byte[] data, int offset, int totalLength) {
        AdvertisingDataParseResult result = new AdvertisingDataParseResult();
        result.mResultList = new ArrayList<>();
        for (int i = offset; i < offset + totalLength; i++) {
            int dataLength = data[i];
            if (dataLength > 0) {
                int dataType = data[i + 1] & 0xff;

                // parse only target data type
                if (mTargetDataTypeSet.contains(dataType)) {
                    if (DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS == dataType) {
                        result.mIncompleteListOf16BitServiceUUIDs = new IncompleteListOf16BitServiceUUIDs(data, i, dataLength);
                        result.mIncompleteListOf16BitServiceUUIDsList.add(result.mIncompleteListOf16BitServiceUUIDs);
                        result.mResultList.add(result.mIncompleteListOf16BitServiceUUIDs);
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS == dataType) {
                        result.mCompleteListOf16BitServiceUUIDs = new CompleteListOf16BitServiceUUIDs(data, i, dataLength);
                        result.mCompleteListOf16BitServiceUUIDsList.add(result.mCompleteListOf16BitServiceUUIDs);
                        result.mResultList.add(result.mCompleteListOf16BitServiceUUIDs);
                    } else if (DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS == dataType) {
                        result.mIncompleteListOf32BitServiceUUIDs = new IncompleteListOf32BitServiceUUIDs(data, i, dataLength);
                        result.mIncompleteListOf32BitServiceUUIDsList.add(result.mIncompleteListOf32BitServiceUUIDs);
                        result.mResultList.add(result.mIncompleteListOf32BitServiceUUIDs);
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS == dataType) {
                        result.mCompleteListOf32BitServiceUUIDs = new CompleteListOf32BitServiceUUIDs(data, i, dataLength);
                        result.mCompleteListOf32BitServiceUUIDsList.add(result.mCompleteListOf32BitServiceUUIDs);
                        result.mResultList.add(result.mCompleteListOf32BitServiceUUIDs);
                    } else if (DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS == dataType) {
                        result.mIncompleteListOf128BitServiceUUIDs = new IncompleteListOf128BitServiceUUIDs(data, i, dataLength);
                        result.mIncompleteListOf128BitServiceUUIDsList.add(result.mIncompleteListOf128BitServiceUUIDs);
                        result.mResultList.add(result.mIncompleteListOf128BitServiceUUIDs);
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS == dataType) {
                        result.mCompleteListOf128BitServiceUUIDs = new CompleteListOf128BitServiceUUIDs(data, i, dataLength);
                        result.mCompleteListOf128BitServiceUUIDsList.add(result.mCompleteListOf128BitServiceUUIDs);
                        result.mResultList.add(result.mCompleteListOf128BitServiceUUIDs);
                    } else if (DATA_TYPE_SHORTENED_LOCAL_NAME == dataType) {
                        result.mShortenedLocalName = new ShortenedLocalName(data, i, dataLength);
                        result.mResultList.add(result.mShortenedLocalName);
                    } else if (DATA_TYPE_COMPLETE_LOCAL_NAME == dataType) {
                        result.mCompleteLocalName = new CompleteLocalName(data, i, dataLength);
                        result.mResultList.add(result.mCompleteLocalName);
                    } else if (DATA_TYPE_FLAGS == dataType) {
                        result.mFlags = new Flags(data, i, dataLength);
                        result.mResultList.add(result.mFlags);
                    } else if (DATA_TYPE_MANUFACTURER_SPECIFIC_DATA == dataType) {
                        result.mManufacturerSpecificData = new ManufacturerSpecificData(data, i, dataLength);
                        result.mManufacturerSpecificDataList.add(result.mManufacturerSpecificData);
                        result.mResultList.add(result.mManufacturerSpecificData);
                    } else if (DATA_TYPE_TX_POWER_LEVEL == dataType) {
                        result.mTxPowerLevel = new TxPowerLevel(data, i, dataLength);
                        result.mTxPowerLevelList.add(result.mTxPowerLevel);
                        result.mResultList.add(result.mTxPowerLevel);
                    } else if (DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE == dataType) {
                        result.mSlaveConnectionIntervalRange = new SlaveConnectionIntervalRange(data, i, dataLength);
                        result.mSlaveConnectionIntervalRangeList.add(result.mSlaveConnectionIntervalRange);
                        result.mResultList.add(result.mSlaveConnectionIntervalRange);
                    } else if (DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        result.mListOf16BitServiceSolicitationUUIDs = new ListOf16BitServiceSolicitationUUIDs(data, i, dataLength);
                        result.mListOf16BitServiceSolicitationUUIDsList.add(result.mListOf16BitServiceSolicitationUUIDs);
                        result.mResultList.add(result.mListOf16BitServiceSolicitationUUIDs);
                    } else if (DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        result.mListOf32BitServiceSolicitationUUIDs = new ListOf32BitServiceSolicitationUUIDs(data, i, dataLength);
                        result.mListOf32BitServiceSolicitationUUIDsList.add(result.mListOf32BitServiceSolicitationUUIDs);
                        result.mResultList.add(result.mListOf32BitServiceSolicitationUUIDs);
                    } else if (DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        result.mListOf128BitServiceSolicitationUUIDs = new ListOf128BitServiceSolicitationUUIDs(data, i, dataLength);
                        result.mListOf128BitServiceSolicitationUUIDsList.add(result.mListOf128BitServiceSolicitationUUIDs);
                        result.mResultList.add(result.mListOf128BitServiceSolicitationUUIDs);
                    } else if (DATA_TYPE_SERVICE_DATA_16_BIT_UUID == dataType) {
                        result.mServiceData16BitUUID = new ServiceData16BitUUID(data, i, dataLength);
                        result.mServiceData16BitUUIDList.add(result.mServiceData16BitUUID);
                        result.mResultList.add(result.mServiceData16BitUUID);
                    } else if (DATA_TYPE_SERVICE_DATA_32_BIT_UUID == dataType) {
                        result.mServiceData32BitUUID = new ServiceData32BitUUID(data, i, dataLength);
                        result.mServiceData32BitUUIDList.add(result.mServiceData32BitUUID);
                        result.mResultList.add(result.mServiceData32BitUUID);
                    } else if (DATA_TYPE_SERVICE_DATA_128_BIT_UUID == dataType) {
                        result.mServiceData128BitUUID = new ServiceData128BitUUID(data, i, dataLength);
                        result.mServiceData128BitUUIDList.add(result.mServiceData128BitUUID);
                        result.mResultList.add(result.mServiceData128BitUUID);
                    } else if (DATA_TYPE_APPEARANCE == dataType) {
                        result.mAppearance = new Appearance(data, i, dataLength);
                        result.mResultList.add(result.mAppearance);
                    } else if (DATA_TYPE_PUBLIC_TARGET_ADDRESS == dataType) {
                        result.mPublicTargetAddress = new PublicTargetAddress(data, i, dataLength);
                        result.mResultList.add(result.mPublicTargetAddress);
                    } else if (DATA_TYPE_RANDOM_TARGET_ADDRESS == dataType) {
                        result.mRandomTargetAddress = new RandomTargetAddress(data, i, dataLength);
                        result.mResultList.add(result.mRandomTargetAddress);
                    } else if (DATA_TYPE_ADVERTISING_INTERVAL == dataType) {
                        result.mAdvertisingInterval = new AdvertisingInterval(data, i, dataLength);
                        result.mResultList.add(result.mAdvertisingInterval);
                    } else if (DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER == dataType) {
                        result.mUniformRsourceIdentifier = new UniformRsourceIdentifier(data, i, dataLength);
                        result.mUniformRsourceIdentifierList.add(result.mUniformRsourceIdentifier);
                        result.mResultList.add(result.mUniformRsourceIdentifier);
                    } else if (DATA_TYPE_LE_SUPPORTED_FEATURES == dataType) {
                        result.mLeSupportedFeatures = new LeSupportedFeatures(data, i, dataLength);
                        result.mResultList.add(result.mLeSupportedFeatures);
                    } else if (DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION == dataType) {
                        result.mChannelMapUpdateIndication = new ChannelMapUpdateIndication(data, i, dataLength);
                        result.mResultList.add(result.mChannelMapUpdateIndication);
                    }
                }
                i += dataLength;
            }
        }
        return result;
    }

}
