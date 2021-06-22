package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.im97mori.ble.constants.DataType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.im97mori.ble.constants.DataType.DATA_TYPE_ADVERTISING_INTERVAL;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_APPEARANCE;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_BIG_INFO;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_COMPLETE_LOCAL_NAME;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_FLAGS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_INDOOR_POSITIONING;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_LE_SUPPORTED_FEATURES;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_MANUFACTURER_SPECIFIC_DATA;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_PUBLIC_TARGET_ADDRESS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_RANDOM_TARGET_ADDRESS;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_SERVICE_DATA_128_BIT_UUID;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_SERVICE_DATA_16_BIT_UUID;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_SERVICE_DATA_32_BIT_UUID;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_SHORTENED_LOCAL_NAME;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_TX_POWER_LEVEL;
import static org.im97mori.ble.constants.DataType.DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER;

/**
 * Parser for {@link ScanRecord#getBytes()}
 */
public class AdvertisingDataParser {

    /**
     * Builder for {@link AdvertisingDataParser}
     */
    public static class Builder {

        /**
         * <p>
         * All Advertising Data Type set
         *
         * @see DataType
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
            set.add(DATA_TYPE_TRANSPORT_DISCOVERY_DATA);
            set.add(DATA_TYPE_LE_SUPPORTED_FEATURES);
            set.add(DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION);
            set.add(DATA_TYPE_BIG_INFO);

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
         * @param advertisingDataTypes one of {@link DataType}
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
         * @param advertisingDataTypes one of {@link DataType}
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
        private final List<AdvertisingDataInterfaceAndroid> mResultList;

        /**
         * Latest Incomplete List of 16-bit Service Class UUIDs
         */
        private IncompleteListOf16BitServiceUUIDsAndroid mIncompleteListOf16BitServiceUUIDs;

        /**
         * All Incomplete List of 16-bit Service Class UUIDs List
         */
        private final List<IncompleteListOf16BitServiceUUIDsAndroid> mIncompleteListOf16BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Complete List of 16-bit Service Class UUIDs
         */
        private CompleteListOf16BitServiceUUIDsAndroid mCompleteListOf16BitServiceUUIDs;

        /**
         * All Complete List of 16-bit Service Class UUIDs List
         */
        private final List<CompleteListOf16BitServiceUUIDsAndroid> mCompleteListOf16BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Incomplete List of 32-bit Service Class UUIDs
         */
        private IncompleteListOf32BitServiceUUIDsAndroid mIncompleteListOf32BitServiceUUIDs;

        /**
         * All Incomplete List of 32-bit Service Class UUIDs List
         */
        private final List<IncompleteListOf32BitServiceUUIDsAndroid> mIncompleteListOf32BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Complete List of 32-bit Service Class UUIDs
         */
        private CompleteListOf32BitServiceUUIDsAndroid mCompleteListOf32BitServiceUUIDs;

        /**
         * All Complete List of 32-bit Service Class UUIDs List
         */
        private final List<CompleteListOf32BitServiceUUIDsAndroid> mCompleteListOf32BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Incomplete List of 128-bit Service Class UUIDs
         */
        private IncompleteListOf128BitServiceUUIDsAndroid mIncompleteListOf128BitServiceUUIDs;

        /**
         * All Incomplete List of 128-bit Service Class UUIDs List
         */
        private final List<IncompleteListOf128BitServiceUUIDsAndroid> mIncompleteListOf128BitServiceUUIDsList = new ArrayList<>();

        /**
         * Latest Complete List of 128-bit Service Class UUIDs
         */
        private CompleteListOf128BitServiceUUIDsAndroid mCompleteListOf128BitServiceUUIDs;

        /**
         * All Complete List of 128-bit Service Class UUIDs List
         */
        private final List<CompleteListOf128BitServiceUUIDsAndroid> mCompleteListOf128BitServiceUUIDsList = new ArrayList<>();

        /**
         * Shortened Local Name
         */
        private ShortenedLocalNameAndroid mShortenedLocalName;

        /**
         * Complete Local Name
         */
        private CompleteLocalNameAndroid mCompleteLocalName;

        /**
         * Flags
         */
        private FlagsAndroid mFlags;

        /**
         * Latest Manufacturer Specific Data
         */
        private ManufacturerSpecificDataAndroid mManufacturerSpecificData;

        /**
         * All Manufacturer Specific Data List
         */
        private final List<ManufacturerSpecificDataAndroid> mManufacturerSpecificDataList = new ArrayList<>();

        /**
         * Latest Tx Power Level
         */
        private TxPowerLevelAndroid mTxPowerLevel;

        /**
         * All Tx Power Level List
         */
        private final List<TxPowerLevelAndroid> mTxPowerLevelList = new ArrayList<>();

        /**
         * Latest Slave Connection Interval Range
         */
        private SlaveConnectionIntervalRangeAndroid mSlaveConnectionIntervalRange;

        /**
         * All Slave Connection Interval Range List
         */
        private final List<SlaveConnectionIntervalRangeAndroid> mSlaveConnectionIntervalRangeList = new ArrayList<>();

        /**
         * Latest List of 16-bit Service Solicitation UUIDs
         */
        private ListOf16BitServiceSolicitationUUIDsAndroid mListOf16BitServiceSolicitationUUIDs;

        /**
         * All List of 16-bit Service Solicitation UUIDs List
         */
        private final List<ListOf16BitServiceSolicitationUUIDsAndroid> mListOf16BitServiceSolicitationUUIDsList = new ArrayList<>();

        /**
         * Latest List of 32-bit Service Solicitation UUIDs
         */
        private ListOf32BitServiceSolicitationUUIDsAndroid mListOf32BitServiceSolicitationUUIDs;

        /**
         * All List of 32-bit Service Solicitation UUIDs List
         */
        private final List<ListOf32BitServiceSolicitationUUIDsAndroid> mListOf32BitServiceSolicitationUUIDsList = new ArrayList<>();

        /**
         * Latest List of 128-bit Service Solicitation UUIDs
         */
        private ListOf128BitServiceSolicitationUUIDsAndroid mListOf128BitServiceSolicitationUUIDs;

        /**
         * All List of 128-bit Service Solicitation UUIDs List
         */
        private final List<ListOf128BitServiceSolicitationUUIDsAndroid> mListOf128BitServiceSolicitationUUIDsList = new ArrayList<>();

        /**
         * Latest Service Data - 16-bit UUID
         */
        private ServiceData16BitUUIDAndroid mServiceData16BitUUID;

        /**
         * All Service Data - 16-bit UUID List
         */
        private final List<ServiceData16BitUUIDAndroid> mServiceData16BitUUIDList = new ArrayList<>();

        /**
         * Latest Service Data - 32-bit UUID
         */
        private ServiceData32BitUUIDAndroid mServiceData32BitUUID;

        /**
         * All Service Data - 32-bit UUID List
         */
        private final List<ServiceData32BitUUIDAndroid> mServiceData32BitUUIDList = new ArrayList<>();

        /**
         * Latest Service Data - 128-bit UUID
         */
        private ServiceData128BitUUIDAndroid mServiceData128BitUUID;

        /**
         * All Service Data - 128-bit UUID List
         */
        private final List<ServiceData128BitUUIDAndroid> mServiceData128BitUUIDList = new ArrayList<>();

        /**
         * Appearance
         */
        private AppearanceAndroid mAppearance;

        /**
         * Public Target Address
         */
        private PublicTargetAddressAndroid mPublicTargetAddress;

        /**
         * Random Target Address
         */
        private RandomTargetAddressAndroid mRandomTargetAddress;

        /**
         * Advertising Interval
         */
        private AdvertisingInterval mAdvertisingInterval;

        /**
         * Latest URI
         */
        private UniformRsourceIdentifierAndroid mUniformRsourceIdentifier;

        /**
         * All URI List
         */
        private final List<UniformRsourceIdentifierAndroid> mUniformRsourceIdentifierList = new ArrayList<>();

        /**
         * Indoor Positioning
         */
        private IndoorPositioningAndroid mIndoorPositioning;

        /**
         * Transport Discovery Data
         */
        private TransportDiscoveryDataAndroid mTransportDiscoveryData;

        /**
         * LE Supported Features
         */
        private LeSupportedFeaturesAndroid mLeSupportedFeatures;

        /**
         * Channel Map Update Indication
         */
        private ChannelMapUpdateIndicationAndroid mChannelMapUpdateIndication;

        /**
         * BIGInfo
         */
        private BigInfoAndroid mBigInfo;

        /**
         * Constructor from {@link #parse(byte[], int, int)}
         *
         * @param resultList all parsed data list
         */
        private AdvertisingDataParseResult(@NonNull List<AdvertisingDataInterfaceAndroid> resultList) {
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
            List<AdvertisingDataInterfaceAndroid> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                AdvertisingDataInterfaceAndroid data = in.readParcelable(this.getClass().getClassLoader());
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
            for (AdvertisingDataInterfaceAndroid data : mResultList) {
                dest.writeParcelable(data, flags);
            }
        }

        /**
         * @return all parsed data list
         */
        @NonNull
        public List<AdvertisingDataInterfaceAndroid> getResultList() {
            return mResultList;
        }

        /**
         * @return Latest Incomplete List of 16-bit Service Class UUIDs
         */
        @Nullable
        public IncompleteListOf16BitServiceUUIDsAndroid getIncompleteListOf16BitServiceUUIDs() {
            return mIncompleteListOf16BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 16-bit Service Class UUIDs List
         */
        @NonNull
        public List<IncompleteListOf16BitServiceUUIDsAndroid> getIncompleteListOf16BitServiceUUIDsList() {
            return mIncompleteListOf16BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 16-bit Service Class UUIDs
         */
        @Nullable
        public CompleteListOf16BitServiceUUIDsAndroid getCompleteListOf16BitServiceUUIDs() {
            return mCompleteListOf16BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 16-bit Service Class UUIDs List
         */
        @NonNull
        public List<CompleteListOf16BitServiceUUIDsAndroid> getCompleteListOf16BitServiceUUIDsList() {
            return mCompleteListOf16BitServiceUUIDsList;
        }

        /**
         * @return Latest Incomplete List of 32-bit Service Class UUIDs
         */
        @Nullable
        public IncompleteListOf32BitServiceUUIDsAndroid getIncompleteListOf32BitServiceUUIDs() {
            return mIncompleteListOf32BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 32-bit Service Class UUIDs List
         */
        @NonNull
        public List<IncompleteListOf32BitServiceUUIDsAndroid> getIncompleteListOf32BitServiceUUIDsList() {
            return mIncompleteListOf32BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 32-bit Service Class UUIDs
         */
        @Nullable
        public CompleteListOf32BitServiceUUIDsAndroid getCompleteListOf32BitServiceUUIDs() {
            return mCompleteListOf32BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 32-bit Service Class UUIDs List
         */
        @NonNull
        public List<CompleteListOf32BitServiceUUIDsAndroid> getCompleteListOf32BitServiceUUIDsList() {
            return mCompleteListOf32BitServiceUUIDsList;
        }

        /**
         * @return Latest Incomplete List of 128-bit Service Class UUIDs
         */
        @Nullable
        public IncompleteListOf128BitServiceUUIDsAndroid getIncompleteListOf128BitServiceUUIDs() {
            return mIncompleteListOf128BitServiceUUIDs;
        }

        /**
         * @return All Incomplete List of 128-bit Service Class UUIDs List
         */
        @NonNull
        public List<IncompleteListOf128BitServiceUUIDsAndroid> getIncompleteListOf128BitServiceUUIDsList() {
            return mIncompleteListOf128BitServiceUUIDsList;
        }

        /**
         * @return Latest Complete List of 128-bit Service Class UUIDs
         */
        @Nullable
        public CompleteListOf128BitServiceUUIDsAndroid getCompleteListOf128BitServiceUUIDs() {
            return mCompleteListOf128BitServiceUUIDs;
        }

        /**
         * @return All Complete List of 128-bit Service Class UUIDs List
         */
        @NonNull
        public List<CompleteListOf128BitServiceUUIDsAndroid> getCompleteListOf128BitServiceUUIDsList() {
            return mCompleteListOf128BitServiceUUIDsList;
        }

        /**
         * @return Shortened Local Name
         */
        @Nullable
        public ShortenedLocalNameAndroid getShortenedLocalName() {
            return mShortenedLocalName;
        }

        /**
         * @return Complete Local Name
         */
        @Nullable
        public CompleteLocalNameAndroid getCompleteLocalName() {
            return mCompleteLocalName;
        }

        /**
         * @return Flags
         */
        @Nullable
        public FlagsAndroid getFlags() {
            return mFlags;
        }

        /**
         * @return Latest Manufacturer Specific Data
         */
        @Nullable
        public ManufacturerSpecificDataAndroid getManufacturerSpecificData() {
            return mManufacturerSpecificData;
        }

        /**
         * @return All Manufacturer Specific Datas List
         */
        @NonNull
        public List<ManufacturerSpecificDataAndroid> getManufacturerSpecificDataList() {
            return mManufacturerSpecificDataList;
        }

        /**
         * @return Latest Tx Power Level
         */
        @Nullable
        public TxPowerLevelAndroid getTxPowerLevel() {
            return mTxPowerLevel;
        }

        /**
         * @return All Tx Power Level List
         */
        @NonNull
        public List<TxPowerLevelAndroid> getTxPowerLevelList() {
            return mTxPowerLevelList;
        }

        /**
         * @return Latest Slave Connection Interval Range
         */
        @Nullable
        public SlaveConnectionIntervalRangeAndroid getSlaveConnectionIntervalRange() {
            return mSlaveConnectionIntervalRange;
        }

        /**
         * @return All All Slave Connection Interval Range List List
         */
        @NonNull
        public List<SlaveConnectionIntervalRangeAndroid> getSlaveConnectionIntervalRangeList() {
            return mSlaveConnectionIntervalRangeList;
        }

        /**
         * @return Latest List of 16-bit Service Solicitation UUIDs
         */
        @Nullable
        public ListOf16BitServiceSolicitationUUIDsAndroid getListOf16BitServiceSolicitationUUIDs() {
            return mListOf16BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 16-bit Service Solicitation UUIDs List
         */
        @NonNull
        public List<ListOf16BitServiceSolicitationUUIDsAndroid> getListOf16BitServiceSolicitationUUIDsList() {
            return mListOf16BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest List of 32-bit Service Solicitation UUIDs
         */
        @Nullable
        public ListOf32BitServiceSolicitationUUIDsAndroid getListOf32BitServiceSolicitationUUIDs() {
            return mListOf32BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 16-bit Service Solicitation UUIDs List
         */
        @NonNull
        public List<ListOf32BitServiceSolicitationUUIDsAndroid> getListOf32BitServiceSolicitationUUIDsList() {
            return mListOf32BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest List of 128-bit Service Solicitation UUIDs
         */
        @Nullable
        public ListOf128BitServiceSolicitationUUIDsAndroid getListOf128BitServiceSolicitationUUIDs() {
            return mListOf128BitServiceSolicitationUUIDs;
        }

        /**
         * @return All List of 128-bit Service Solicitation UUIDs List
         */
        @NonNull
        public List<ListOf128BitServiceSolicitationUUIDsAndroid> getListOf128BitServiceSolicitationUUIDsList() {
            return mListOf128BitServiceSolicitationUUIDsList;
        }

        /**
         * @return Latest Service Data - 16-bit UUID
         */
        @Nullable
        public ServiceData16BitUUIDAndroid getServiceData16BitUUID() {
            return mServiceData16BitUUID;
        }

        /**
         * @return All Service Data - 16-bit UUID List
         */
        @NonNull
        public List<ServiceData16BitUUIDAndroid> getServiceData16BitUUIDList() {
            return mServiceData16BitUUIDList;
        }

        /**
         * @return Latest Service Data - 32-bit UUID
         */
        @Nullable
        public ServiceData32BitUUIDAndroid getServiceData32BitUUID() {
            return mServiceData32BitUUID;
        }

        /**
         * @return All Service Data - 32-bit UUID List
         */
        @NonNull
        public List<ServiceData32BitUUIDAndroid> getServiceData32BitUUIDList() {
            return mServiceData32BitUUIDList;
        }

        /**
         * @return Latest Service Data - 128-bit UUID
         */
        @Nullable
        public ServiceData128BitUUIDAndroid getServiceData128BitUUID() {
            return mServiceData128BitUUID;
        }

        /**
         * @return All Service Data - 128-bit UUID List
         */
        @NonNull
        public List<ServiceData128BitUUIDAndroid> getServiceData128BitUUIDList() {
            return mServiceData128BitUUIDList;
        }

        /**
         * @return Appearance
         */
        @Nullable
        public AppearanceAndroid getAppearance() {
            return mAppearance;
        }

        /**
         * @return Public Target Address
         */
        @Nullable
        public PublicTargetAddressAndroid getPublicTargetAddress() {
            return mPublicTargetAddress;
        }

        /**
         * @return Random Target Address
         */
        @Nullable
        public RandomTargetAddressAndroid getRandomTargetAddress() {
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
        public UniformRsourceIdentifierAndroid getUniformRsourceIdentifier() {
            return mUniformRsourceIdentifier;
        }

        /**
         * @return All URI List
         */
        @NonNull
        public List<UniformRsourceIdentifierAndroid> getUniformRsourceIdentifierList() {
            return mUniformRsourceIdentifierList;
        }

        /**
         * @return Indoor Positioning
         */
        @Nullable
        public IndoorPositioningAndroid getIndoorPositioning() {
            return mIndoorPositioning;
        }

        /**
         * @return Transport Discovery Data
         */
        @Nullable
        public TransportDiscoveryDataAndroid getTransportDiscoveryData() {
            return mTransportDiscoveryData;
        }

        /**
         * @return LE Supported Features
         */
        @Nullable
        public LeSupportedFeaturesAndroid getLeSupportedFeatures() {
            return mLeSupportedFeatures;
        }

        /**
         * @return Channel Map Update Indication
         */
        @Nullable
        public ChannelMapUpdateIndicationAndroid getChannelMapUpdateIndication() {
            return mChannelMapUpdateIndication;
        }

        /**
         * @return BIGInfo
         */
        @Nullable
        public BigInfoAndroid getBigInfo() {
            return mBigInfo;
        }

        /**
         * list to member
         */
        private void toMember() {
            for (AdvertisingDataInterfaceAndroid data : mResultList) {
                if (data instanceof IncompleteListOf16BitServiceUUIDsAndroid) {
                    mIncompleteListOf16BitServiceUUIDs = (IncompleteListOf16BitServiceUUIDsAndroid) data;
                    mIncompleteListOf16BitServiceUUIDsList.add(mIncompleteListOf16BitServiceUUIDs);
                } else if (data instanceof CompleteListOf16BitServiceUUIDsAndroid) {
                    mCompleteListOf16BitServiceUUIDs = (CompleteListOf16BitServiceUUIDsAndroid) data;
                    mCompleteListOf16BitServiceUUIDsList.add(mCompleteListOf16BitServiceUUIDs);
                } else if (data instanceof IncompleteListOf32BitServiceUUIDsAndroid) {
                    mIncompleteListOf32BitServiceUUIDs = (IncompleteListOf32BitServiceUUIDsAndroid) data;
                    mIncompleteListOf32BitServiceUUIDsList.add(mIncompleteListOf32BitServiceUUIDs);
                } else if (data instanceof CompleteListOf32BitServiceUUIDsAndroid) {
                    mCompleteListOf32BitServiceUUIDs = (CompleteListOf32BitServiceUUIDsAndroid) data;
                    mCompleteListOf32BitServiceUUIDsList.add(mCompleteListOf32BitServiceUUIDs);
                } else if (data instanceof IncompleteListOf128BitServiceUUIDsAndroid) {
                    mIncompleteListOf128BitServiceUUIDs = (IncompleteListOf128BitServiceUUIDsAndroid) data;
                    mIncompleteListOf128BitServiceUUIDsList.add(mIncompleteListOf128BitServiceUUIDs);
                } else if (data instanceof CompleteListOf128BitServiceUUIDsAndroid) {
                    mCompleteListOf128BitServiceUUIDs = (CompleteListOf128BitServiceUUIDsAndroid) data;
                    mCompleteListOf128BitServiceUUIDsList.add(mCompleteListOf128BitServiceUUIDs);
                } else if (data instanceof ShortenedLocalNameAndroid) {
                    mShortenedLocalName = (ShortenedLocalNameAndroid) data;
                } else if (data instanceof CompleteLocalNameAndroid) {
                    mCompleteLocalName = (CompleteLocalNameAndroid) data;
                } else if (data instanceof FlagsAndroid) {
                    mFlags = (FlagsAndroid) data;
                } else if (data instanceof ManufacturerSpecificDataAndroid) {
                    mManufacturerSpecificData = (ManufacturerSpecificDataAndroid) data;
                    mManufacturerSpecificDataList.add(mManufacturerSpecificData);
                } else if (data instanceof TxPowerLevelAndroid) {
                    mTxPowerLevel = (TxPowerLevelAndroid) data;
                    mTxPowerLevelList.add(mTxPowerLevel);
                } else if (data instanceof SlaveConnectionIntervalRangeAndroid) {
                    mSlaveConnectionIntervalRange = (SlaveConnectionIntervalRangeAndroid) data;
                    mSlaveConnectionIntervalRangeList.add(mSlaveConnectionIntervalRange);
                } else if (data instanceof ListOf16BitServiceSolicitationUUIDsAndroid) {
                    mListOf16BitServiceSolicitationUUIDs = (ListOf16BitServiceSolicitationUUIDsAndroid) data;
                    mListOf16BitServiceSolicitationUUIDsList.add(mListOf16BitServiceSolicitationUUIDs);
                } else if (data instanceof ListOf32BitServiceSolicitationUUIDsAndroid) {
                    mListOf32BitServiceSolicitationUUIDs = (ListOf32BitServiceSolicitationUUIDsAndroid) data;
                    mListOf32BitServiceSolicitationUUIDsList.add(mListOf32BitServiceSolicitationUUIDs);
                } else if (data instanceof ListOf128BitServiceSolicitationUUIDsAndroid) {
                    mListOf128BitServiceSolicitationUUIDs = (ListOf128BitServiceSolicitationUUIDsAndroid) data;
                    mListOf128BitServiceSolicitationUUIDsList.add(mListOf128BitServiceSolicitationUUIDs);
                } else if (data instanceof ServiceData16BitUUIDAndroid) {
                    mServiceData16BitUUID = (ServiceData16BitUUIDAndroid) data;
                    mServiceData16BitUUIDList.add(mServiceData16BitUUID);
                } else if (data instanceof ServiceData32BitUUIDAndroid) {
                    mServiceData32BitUUID = (ServiceData32BitUUIDAndroid) data;
                    mServiceData32BitUUIDList.add(mServiceData32BitUUID);
                } else if (data instanceof ServiceData128BitUUIDAndroid) {
                    mServiceData128BitUUID = (ServiceData128BitUUIDAndroid) data;
                    mServiceData128BitUUIDList.add(mServiceData128BitUUID);
                } else if (data instanceof AppearanceAndroid) {
                    mAppearance = (AppearanceAndroid) data;
                } else if (data instanceof PublicTargetAddressAndroid) {
                    mPublicTargetAddress = (PublicTargetAddressAndroid) data;
                } else if (data instanceof RandomTargetAddressAndroid) {
                    mRandomTargetAddress = (RandomTargetAddressAndroid) data;
                } else if (data instanceof AdvertisingInterval) {
                    mAdvertisingInterval = (AdvertisingInterval) data;
                } else if (data instanceof UniformRsourceIdentifierAndroid) {
                    mUniformRsourceIdentifier = (UniformRsourceIdentifierAndroid) data;
                    mUniformRsourceIdentifierList.add(mUniformRsourceIdentifier);
                } else if (data instanceof IndoorPositioningAndroid) {
                    mIndoorPositioning = (IndoorPositioningAndroid) data;
                } else if (data instanceof TransportDiscoveryDataAndroid) {
                    mTransportDiscoveryData = (TransportDiscoveryDataAndroid) data;
                } else if (data instanceof LeSupportedFeaturesAndroid) {
                    mLeSupportedFeatures = (LeSupportedFeaturesAndroid) data;
                } else if (data instanceof ChannelMapUpdateIndicationAndroid) {
                    mChannelMapUpdateIndication = (ChannelMapUpdateIndicationAndroid) data;
                } else if (data instanceof BigInfoAndroid) {
                    mBigInfo = (BigInfoAndroid) data;
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
        List<AdvertisingDataInterfaceAndroid> resultList = new ArrayList<>();
        for (int i = offset; i < offset + totalLength; i++) {
            int dataLength = data[i];
            if (dataLength > 0) {
                int dataType = data[i + 1] & 0xff;

                // parse only target data type
                if (mTargetDataTypeSet.contains(dataType)) {
                    if (DATA_TYPE_INCOMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new IncompleteListOf16BitServiceUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_16_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new CompleteListOf16BitServiceUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_INCOMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new IncompleteListOf32BitServiceUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_32_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new CompleteListOf32BitServiceUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_INCOMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new IncompleteListOf128BitServiceUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LIST_OF_128_BIT_SERVICE_UUIDS == dataType) {
                        resultList.add(new CompleteListOf128BitServiceUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_SHORTENED_LOCAL_NAME == dataType) {
                        resultList.add(new ShortenedLocalNameAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_COMPLETE_LOCAL_NAME == dataType) {
                        resultList.add(new CompleteLocalNameAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_FLAGS == dataType) {
                        resultList.add(new FlagsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_MANUFACTURER_SPECIFIC_DATA == dataType) {
                        resultList.add(new ManufacturerSpecificDataAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_TX_POWER_LEVEL == dataType) {
                        resultList.add(new TxPowerLevelAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_SLAVE_CONNECTION_INTERVAL_RANGE == dataType) {
                        resultList.add(new SlaveConnectionIntervalRangeAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_LIST_OF_16_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        resultList.add(new ListOf16BitServiceSolicitationUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_LIST_OF_32_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        resultList.add(new ListOf32BitServiceSolicitationUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_LIST_OF_128_BIT_SERVICE_SOLICITATION_UUIDS == dataType) {
                        resultList.add(new ListOf128BitServiceSolicitationUUIDsAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_SERVICE_DATA_16_BIT_UUID == dataType) {
                        resultList.add(new ServiceData16BitUUIDAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_SERVICE_DATA_32_BIT_UUID == dataType) {
                        resultList.add(new ServiceData32BitUUIDAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_SERVICE_DATA_128_BIT_UUID == dataType) {
                        resultList.add(new ServiceData128BitUUIDAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_APPEARANCE == dataType) {
                        resultList.add(new AppearanceAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_PUBLIC_TARGET_ADDRESS == dataType) {
                        resultList.add(new PublicTargetAddressAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_RANDOM_TARGET_ADDRESS == dataType) {
                        resultList.add(new RandomTargetAddressAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_ADVERTISING_INTERVAL == dataType) {
                        resultList.add(new AdvertisingIntervalAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_UNIFORM_RESOURCE_IDENTIFIER == dataType) {
                        resultList.add(new UniformRsourceIdentifierAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_INDOOR_POSITIONING == dataType) {
                        resultList.add(new IndoorPositioningAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_TRANSPORT_DISCOVERY_DATA == dataType) {
                        resultList.add(new TransportDiscoveryDataAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_LE_SUPPORTED_FEATURES == dataType) {
                        resultList.add(new LeSupportedFeaturesAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION == dataType) {
                        resultList.add(new ChannelMapUpdateIndicationAndroid(data, i, dataLength));
                    } else if (DATA_TYPE_BIG_INFO == dataType) {
                        resultList.add(new BigInfoAndroid(data, i, dataLength));
                    }
                }
                i += dataLength;
            }
        }
        return new AdvertisingDataParseResult(resultList);
    }

}
