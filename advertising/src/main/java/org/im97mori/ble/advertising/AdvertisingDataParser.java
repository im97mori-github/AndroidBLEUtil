package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_ADVERTISING_INTERVAL;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_APPEARANCE;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_COMPLETE_LOCAL_NAME;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_FLAGS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_INDOOR_POSITIONING;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_PUBLIC_TARGET_ADDRESS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_RANDOM_TARGET_ADDRESS;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SHORTENED_LOCAL_NAME;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TX_POWER_LEVEL;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;

/**
 * Parser for {@link ScanRecord#getBytes()}
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class AdvertisingDataParser {

    /**
     * Builder for {@link AdvertisingDataParser}
     */
    public static class Builder {

        /**
         * <p>
         * All Advertising Data Type set
         *
         * @see AdvertisingDataTypes
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
            set.add(DATA_TYPE_INDOOR_POSITIONING);
            set.add(DATA_TYPE_LE_SUPPORTED_FEATURES);
            set.add(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);

            ALL_DATA_TYPE_SET = Collections.unmodifiableSet(Collections.synchronizedSet(set));
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
        @NonNull
        public Builder includeAll() {
            mTypeSet.addAll(ALL_DATA_TYPE_SET);
            return this;
        }

        /**
         * include Advertising Data Type
         *
         * @param advertisingDataTypes one of {@link AdvertisingDataTypes}
         * @return myself
         */
        @NonNull
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
        @NonNull
        public Builder excludeAll() {
            mTypeSet.clear();
            return this;
        }

        /**
         * exclude Advertising Data Type
         *
         * @param advertisingDataTypes one of {@link AdvertisingDataTypes}
         * @return myself
         */
        @NonNull
        public Builder exclude(int advertisingDataTypes) {
            mTypeSet.remove(advertisingDataTypes);
            return this;
        }

        /**
         * build {@link AdvertisingDataParser}instance
         *
         * @return {@link AdvertisingDataParser}
         */
        @NonNull
        public AdvertisingDataParser build() {
            return new AdvertisingDataParser(mTypeSet);
        }
    }

    /**
     * parse result for Advertising Data
     */
    public static class AdvertisingDataParseResult implements Parcelable {

        /**
         * @see android.os.Parcelable.Creator
         */
        public static final Creator<AdvertisingDataParseResult> CREATOR = new Creator<AdvertisingDataParseResult>() {

            /**
             * {@inheritDoc}
             */
            @Override
            public AdvertisingDataParseResult createFromParcel(Parcel in) {
                return new AdvertisingDataParseResult(in);
            }

            /**
             * {@inheritDoc}
             */
            @Override
            public AdvertisingDataParseResult[] newArray(int size) {
                return new AdvertisingDataParseResult[size];
            }

        };
        /**
         * all parsed data list
         */
        private final List<AbstractAdvertisingData> mResultList;

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
         * Indoor Positioning
         */
        private IndoorPositioning mIndoorPositioning;

        /**
         * LE Supported Features
         */
        private LeSupportedFeatures mLeSupportedFeatures;

        /**
         * Channel Map Update Indication
         */
        private ChannelMapUpdateIndication mChannelMapUpdateIndication;

        /**
         * Constructor from {@link #parse(byte[], int, int)}
         *
         * @param resultList all parsed data list
         */
        private AdvertisingDataParseResult(@NonNull List<AbstractAdvertisingData> resultList) {
            mResultList = Collections.unmodifiableList(resultList);
            toMember();
        }

        /**
         * Constructor from {@link Parcel}
         *
         * @param in Parcel
         */
        private AdvertisingDataParseResult(@NonNull Parcel in) {
            int size = in.readInt();
            List<AbstractAdvertisingData> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                AbstractAdvertisingData data = in.readParcelable(this.getClass().getClassLoader());
                list.add(data);
            }
            mResultList = Collections.unmodifiableList(list);
            toMember();
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
            dest.writeInt(mResultList.size());
            for (AbstractAdvertisingData data : mResultList) {
                dest.writeParcelable(data, flags);
            }
        }

        /**
         * @return all parsed data list
         */
        @NonNull
        public List<AbstractAdvertisingData> getResultList() {
            return mResultList;
        }

        /**
         * @return Latest Incomplete List of 16-bit Service Class UUIDs
         */
        @Nullable
        public IncompleteListOf16BitServiceUUIDs getIncompleteListOf16BitServiceUUIDs() {
            return mIncompleteListOf16BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 16-bit Service Class UUIDs List
         */
        @NonNull
        public List<IncompleteListOf16BitServiceUUIDs> getIncompleteListOf16BitServiceUUIDsList() {
            return mIncompleteListOf16BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 16-bit Service Class UUIDs
         */
        @Nullable
        public CompleteListOf16BitServiceUUIDs getCompleteListOf16BitServiceUUIDs() {
            return mCompleteListOf16BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 16-bit Service Class UUIDs List
         */
        @NonNull
        public List<CompleteListOf16BitServiceUUIDs> getCompleteListOf16BitServiceUUIDsList() {
            return mCompleteListOf16BitServiceUUIDsList;
        }

        /**
         * @return Latest Incomplete List of 32-bit Service Class UUIDs
         */
        @Nullable
        public IncompleteListOf32BitServiceUUIDs getIncompleteListOf32BitServiceUUIDs() {
            return mIncompleteListOf32BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 32-bit Service Class UUIDs List
         */
        @NonNull
        public List<IncompleteListOf32BitServiceUUIDs> getIncompleteListOf32BitServiceUUIDsList() {
            return mIncompleteListOf32BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 32-bit Service Class UUIDs
         */
        @Nullable
        public CompleteListOf32BitServiceUUIDs getCompleteListOf32BitServiceUUIDs() {
            return mCompleteListOf32BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 32-bit Service Class UUIDs List
         */
        @NonNull
        public List<CompleteListOf32BitServiceUUIDs> getCompleteListOf32BitServiceUUIDsList() {
            return mCompleteListOf32BitServiceUUIDsList;
        }

        /**
         * @return Latest Incomplete List of 128-bit Service Class UUIDs
         */
        @Nullable
        public IncompleteListOf128BitServiceUUIDs getIncompleteListOf128BitServiceUUIDs() {
            return mIncompleteListOf128BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 128-bit Service Class UUIDs List
         */
        @NonNull
        public List<IncompleteListOf128BitServiceUUIDs> getIncompleteListOf128BitServiceUUIDsList() {
            return mIncompleteListOf128BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 128-bit Service Class UUIDs
         */
        @Nullable
        public CompleteListOf128BitServiceUUIDs getCompleteListOf128BitServiceUUIDs() {
            return mCompleteListOf128BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 128-bit Service Class UUIDs List
         */
        @NonNull
        public List<CompleteListOf128BitServiceUUIDs> getCompleteListOf128BitServiceUUIDsList() {
            return mCompleteListOf128BitServiceUUIDsList;
        }

        /**
         * @return Shortened Local Name
         */
        @Nullable
        public ShortenedLocalName getShortenedLocalName() {
            return mShortenedLocalName;
        }

        /**
         * @return Complete Local Name
         */
        @Nullable
        public CompleteLocalName getCompleteLocalName() {
            return mCompleteLocalName;
        }

        /**
         * @return Flags
         */
        @Nullable
        public Flags getFlags() {
            return mFlags;
        }

        /**
         * @return Latest Manufacturer Specific Data
         */
        @Nullable
        public ManufacturerSpecificData getManufacturerSpecificData() {
            return mManufacturerSpecificData;
        }

        /**
         * @return All Manufacturer Specific Datas List
         */
        @NonNull
        public List<ManufacturerSpecificData> getManufacturerSpecificDataList() {
            return mManufacturerSpecificDataList;
        }

        /**
         * @return Latest Tx Power Level
         */
        @Nullable
        public TxPowerLevel getTxPowerLevel() {
            return mTxPowerLevel;
        }

        /**
         * @return All Tx Power Level List
         */
        @NonNull
        public List<TxPowerLevel> getTxPowerLevelList() {
            return mTxPowerLevelList;
        }

        /**
         * @return Latest Slave Connection Interval Range
         */
        @Nullable
        public SlaveConnectionIntervalRange getSlaveConnectionIntervalRange() {
            return mSlaveConnectionIntervalRange;
        }

        /**
         * @return All All Slave Connection Interval Range List List
         */
        @NonNull
        public List<SlaveConnectionIntervalRange> getSlaveConnectionIntervalRangeList() {
            return mSlaveConnectionIntervalRangeList;
        }

        /**
         * @return Latest List of 16-bit Service Solicitation UUIDs
         */
        @Nullable
        public ListOf16BitServiceSolicitationUUIDs getListOf16BitServiceSolicitationUUIDs() {
            return mListOf16BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 16-bit Service Solicitation UUIDs List
         */
        @NonNull
        public List<ListOf16BitServiceSolicitationUUIDs> getListOf16BitServiceSolicitationUUIDsList() {
            return mListOf16BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest List of 32-bit Service Solicitation UUIDs
         */
        @Nullable
        public ListOf32BitServiceSolicitationUUIDs getListOf32BitServiceSolicitationUUIDs() {
            return mListOf32BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 16-bit Service Solicitation UUIDs List
         */
        @NonNull
        public List<ListOf32BitServiceSolicitationUUIDs> getListOf32BitServiceSolicitationUUIDsList() {
            return mListOf32BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest List of 128-bit Service Solicitation UUIDs
         */
        @Nullable
        public ListOf128BitServiceSolicitationUUIDs getListOf128BitServiceSolicitationUUIDs() {
            return mListOf128BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 128-bit Service Solicitation UUIDs List
         */
        @NonNull
        public List<ListOf128BitServiceSolicitationUUIDs> getListOf128BitServiceSolicitationUUIDsList() {
            return mListOf128BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest Service Data - 16-bit UUID
         */
        @Nullable
        public ServiceData16BitUUID getServiceData16BitUUID() {
            return mServiceData16BitUUID;
        }

        /**
         * @return All Service Data - 16-bit UUID List
         */
        @NonNull
        public List<ServiceData16BitUUID> getServiceData16BitUUIDList() {
            return mServiceData16BitUUIDList;
        }

        /**
         * @return Latest Service Data - 32-bit UUID
         */
        @Nullable
        public ServiceData32BitUUID getServiceData32BitUUID() {
            return mServiceData32BitUUID;
        }

        /**
         * @return All Service Data - 32-bit UUID List
         */
        @NonNull
        public List<ServiceData32BitUUID> getServiceData32BitUUIDList() {
            return mServiceData32BitUUIDList;
        }

        /**
         * @return Latest Service Data - 128-bit UUID
         */
        @Nullable
        public ServiceData128BitUUID getServiceData128BitUUID() {
            return mServiceData128BitUUID;
        }

        /**
         * @return All Service Data - 128-bit UUID List
         */
        @NonNull
        public List<ServiceData128BitUUID> getServiceData128BitUUIDList() {
            return mServiceData128BitUUIDList;
        }

        /**
         * @return Appearance
         */
        @Nullable
        public Appearance getAppearance() {
            return mAppearance;
        }

        /**
         * @return Public Target Address
         */
        @Nullable
        public PublicTargetAddress getPublicTargetAddress() {
            return mPublicTargetAddress;
        }

        /**
         * @return Random Target Address
         */
        @Nullable
        public RandomTargetAddress getRandomTargetAddress() {
            return mRandomTargetAddress;
        }

        /**
         * @return Advertising Interval
         */
        @Nullable
        public AdvertisingInterval getAdvertisingInterval() {
            return mAdvertisingInterval;
        }

        /**
         * @return Latest URI
         */
        @Nullable
        public UniformRsourceIdentifier getUniformRsourceIdentifier() {
            return mUniformRsourceIdentifier;
        }

        /**
         * @return All URI List
         */
        @NonNull
        public List<UniformRsourceIdentifier> getUniformRsourceIdentifierList() {
            return mUniformRsourceIdentifierList;
        }

        /**
         * @return Indoor Positioning
         */
        @Nullable
        public IndoorPositioning getIndoorPositioning() {
            return mIndoorPositioning;
        }

        /**
         * @return LE Supported Features
         */
        @Nullable
        public LeSupportedFeatures getLeSupportedFeatures() {
            return mLeSupportedFeatures;
        }

        /**
         * @return Channel Map Update Indication
         */
        @Nullable
        public ChannelMapUpdateIndication getChannelMapUpdateIndication() {
            return mChannelMapUpdateIndication;
        }

        /**
         * list to member
         */
        private void toMember() {
            for (AbstractAdvertisingData data : mResultList) {
                if (data instanceof IncompleteListOf16BitServiceUUIDs) {
                    mIncompleteListOf16BitServiceUUIDs = (IncompleteListOf16BitServiceUUIDs) data;
                    mIncompleteListOf16BitServiceUUIDsList.add(mIncompleteListOf16BitServiceUUIDs);
                } else if (data instanceof CompleteListOf16BitServiceUUIDs) {
                    mCompleteListOf16BitServiceUUIDs = (CompleteListOf16BitServiceUUIDs) data;
                    mCompleteListOf16BitServiceUUIDsList.add(mCompleteListOf16BitServiceUUIDs);
                } else if (data instanceof IncompleteListOf32BitServiceUUIDs) {
                    mIncompleteListOf32BitServiceUUIDs = (IncompleteListOf32BitServiceUUIDs) data;
                    mIncompleteListOf32BitServiceUUIDsList.add(mIncompleteListOf32BitServiceUUIDs);
                } else if (data instanceof CompleteListOf32BitServiceUUIDs) {
                    mCompleteListOf32BitServiceUUIDs = (CompleteListOf32BitServiceUUIDs) data;
                    mCompleteListOf32BitServiceUUIDsList.add(mCompleteListOf32BitServiceUUIDs);
                } else if (data instanceof IncompleteListOf128BitServiceUUIDs) {
                    mIncompleteListOf128BitServiceUUIDs = (IncompleteListOf128BitServiceUUIDs) data;
                    mIncompleteListOf128BitServiceUUIDsList.add(mIncompleteListOf128BitServiceUUIDs);
                } else if (data instanceof CompleteListOf128BitServiceUUIDs) {
                    mCompleteListOf128BitServiceUUIDs = (CompleteListOf128BitServiceUUIDs) data;
                    mCompleteListOf128BitServiceUUIDsList.add(mCompleteListOf128BitServiceUUIDs);
                } else if (data instanceof ShortenedLocalName) {
                    mShortenedLocalName = (ShortenedLocalName) data;
                } else if (data instanceof CompleteLocalName) {
                    mCompleteLocalName = (CompleteLocalName) data;
                } else if (data instanceof Flags) {
                    mFlags = (Flags) data;
                } else if (data instanceof ManufacturerSpecificData) {
                    mManufacturerSpecificData = (ManufacturerSpecificData) data;
                    mManufacturerSpecificDataList.add(mManufacturerSpecificData);
                } else if (data instanceof TxPowerLevel) {
                    mTxPowerLevel = (TxPowerLevel) data;
                    mTxPowerLevelList.add(mTxPowerLevel);
                } else if (data instanceof SlaveConnectionIntervalRange) {
                    mSlaveConnectionIntervalRange = (SlaveConnectionIntervalRange) data;
                    mSlaveConnectionIntervalRangeList.add(mSlaveConnectionIntervalRange);
                } else if (data instanceof ListOf16BitServiceSolicitationUUIDs) {
                    mListOf16BitServiceSolicitationUUIDs = (ListOf16BitServiceSolicitationUUIDs) data;
                    mListOf16BitServiceSolicitationUUIDsList.add(mListOf16BitServiceSolicitationUUIDs);
                } else if (data instanceof ListOf32BitServiceSolicitationUUIDs) {
                    mListOf32BitServiceSolicitationUUIDs = (ListOf32BitServiceSolicitationUUIDs) data;
                    mListOf32BitServiceSolicitationUUIDsList.add(mListOf32BitServiceSolicitationUUIDs);
                } else if (data instanceof ListOf128BitServiceSolicitationUUIDs) {
                    mListOf128BitServiceSolicitationUUIDs = (ListOf128BitServiceSolicitationUUIDs) data;
                    mListOf128BitServiceSolicitationUUIDsList.add(mListOf128BitServiceSolicitationUUIDs);
                } else if (data instanceof ServiceData16BitUUID) {
                    mServiceData16BitUUID = (ServiceData16BitUUID) data;
                    mServiceData16BitUUIDList.add(mServiceData16BitUUID);
                } else if (data instanceof ServiceData32BitUUID) {
                    mServiceData32BitUUID = (ServiceData32BitUUID) data;
                    mServiceData32BitUUIDList.add(mServiceData32BitUUID);
                } else if (data instanceof ServiceData128BitUUID) {
                    mServiceData128BitUUID = (ServiceData128BitUUID) data;
                    mServiceData128BitUUIDList.add(mServiceData128BitUUID);
                } else if (data instanceof Appearance) {
                    mAppearance = (Appearance) data;
                } else if (data instanceof PublicTargetAddress) {
                    mPublicTargetAddress = (PublicTargetAddress) data;
                } else if (data instanceof RandomTargetAddress) {
                    mRandomTargetAddress = (RandomTargetAddress) data;
                } else if (data instanceof AdvertisingInterval) {
                    mAdvertisingInterval = (AdvertisingInterval) data;
                } else if (data instanceof UniformRsourceIdentifier) {
                    mUniformRsourceIdentifier = (UniformRsourceIdentifier) data;
                    mUniformRsourceIdentifierList.add(mUniformRsourceIdentifier);
                } else if (data instanceof IndoorPositioning) {
                    mIndoorPositioning = (IndoorPositioning) data;
                } else if (data instanceof LeSupportedFeatures) {
                    mLeSupportedFeatures = (LeSupportedFeatures) data;
                } else if (data instanceof ChannelMapUpdateIndication) {
                    mChannelMapUpdateIndication = (ChannelMapUpdateIndication) data;
                }
            }
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
    private AdvertisingDataParser(@NonNull Set<Integer> targetDataTypeSet) {
        mTargetDataTypeSet = targetDataTypeSet;
    }

    /**
     * @see #parse(byte[], int, int)
     */
    @NonNull
    public AdvertisingDataParseResult parse(@NonNull byte[] data) {
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
    @NonNull
    public AdvertisingDataParseResult parse(@NonNull byte[] data
            , int offset
            , int totalLength) {
        List<AbstractAdvertisingData> resultList = new ArrayList<>();
        for (int i = offset; i < offset + totalLength; i++) {
            int dataLength = data[i];
            if (dataLength > 0) {
                int dataType = data[i + 1] & 0xff;

                // parse only target data type
                if (mTargetDataTypeSet.contains(dataType)) {
                    if (DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new IncompleteListOf16BitServiceUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new CompleteListOf16BitServiceUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new IncompleteListOf32BitServiceUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new CompleteListOf32BitServiceUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new IncompleteListOf128BitServiceUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new CompleteListOf128BitServiceUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_SHORTENED_LOCAL_NAME == dataType) {
                        resultList.add(new ShortenedLocalName(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LOCAL_NAME == dataType) {
                        resultList.add(new CompleteLocalName(data, i, dataLength));
                    } else if (DATA_TYPE_FLAGS == dataType) {
                        resultList.add(new Flags(data, i, dataLength));
                    } else if (DATA_TYPE_MANUFACTURER_SPECIFIC_DATA == dataType) {
                        resultList.add(new ManufacturerSpecificData(data, i, dataLength));
                    } else if (DATA_TYPE_TX_POWER_LEVEL == dataType) {
                        resultList.add(new TxPowerLevel(data, i, dataLength));
                    } else if (DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE == dataType) {
                        resultList.add(new SlaveConnectionIntervalRange(data, i, dataLength));
                    } else if (DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        resultList.add(new ListOf16BitServiceSolicitationUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        resultList.add(new ListOf32BitServiceSolicitationUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        resultList.add(new ListOf128BitServiceSolicitationUUIDs(data, i, dataLength));
                    } else if (DATA_TYPE_SERVICE_DATA_16_BIT_UUID == dataType) {
                        resultList.add(new ServiceData16BitUUID(data, i, dataLength));
                    } else if (DATA_TYPE_SERVICE_DATA_32_BIT_UUID == dataType) {
                        resultList.add(new ServiceData32BitUUID(data, i, dataLength));
                    } else if (DATA_TYPE_SERVICE_DATA_128_BIT_UUID == dataType) {
                        resultList.add(new ServiceData128BitUUID(data, i, dataLength));
                    } else if (DATA_TYPE_APPEARANCE == dataType) {
                        resultList.add(new Appearance(data, i, dataLength));
                    } else if (DATA_TYPE_PUBLIC_TARGET_ADDRESS == dataType) {
                        resultList.add(new PublicTargetAddress(data, i, dataLength));
                    } else if (DATA_TYPE_RANDOM_TARGET_ADDRESS == dataType) {
                        resultList.add(new RandomTargetAddress(data, i, dataLength));
                    } else if (DATA_TYPE_ADVERTISING_INTERVAL == dataType) {
                        resultList.add(new AdvertisingInterval(data, i, dataLength));
                    } else if (DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER == dataType) {
                        resultList.add(new UniformRsourceIdentifier(data, i, dataLength));
                    } else if (DATA_TYPE_INDOOR_POSITIONING == dataType) {
                        resultList.add(new IndoorPositioning(data, i, dataLength));
                    } else if (DATA_TYPE_LE_SUPPORTED_FEATURES == dataType) {
                        resultList.add(new LeSupportedFeatures(data, i, dataLength));
                    } else if (DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION == dataType) {
                        resultList.add(new ChannelMapUpdateIndication(data, i, dataLength));
                    }
                }
                i += dataLength;
            }
        }
        return new AdvertisingDataParseResult(resultList);
    }

}
