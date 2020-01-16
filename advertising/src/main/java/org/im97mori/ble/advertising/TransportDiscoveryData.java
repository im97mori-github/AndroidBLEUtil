package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_TRANSPORT_DISCOVERY_DATA;

/**
 * <p>
 * Transport Discovery Data
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class TransportDiscoveryData extends AbstractAdvertisingData {

    /**
     * @see #TDS_FLAGS_ROLE_NOT_SPECIFIED
     * @see #TDS_FLAGS_ROLE_SEEKER_ONLY
     * @see #TDS_FLAGS_ROLE_PROVIDER_ONLY
     * @see #TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER
     */
    public static final int TDS_FLAGS_ROLE_MASK = 0b00000011;

    /**
     * 0b00: Not specified
     */
    public static final int TDS_FLAGS_ROLE_NOT_SPECIFIED = 0b00000000;

    /**
     * 0b01: Seeker Only
     */
    public static final int TDS_FLAGS_ROLE_SEEKER_ONLY = 0b00000001;

    /**
     * 0b10: Provider Only
     */
    public static final int TDS_FLAGS_ROLE_PROVIDER_ONLY = 0b00000010;

    /**
     * 0b11: Both Seeker and Provider
     */
    public static final int TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER = 0b00000011;

    /**
     * @see #TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE
     * @see #TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE
     */
    public static final int TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_MASK = 0b00000100;

    /**
     * 0: TransportData Incomplete False
     */
    public static final int TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE = 0b00000000;

    /**
     * 1: TransportData Incomplete True
     */
    public static final int TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE = 0b00000100;

    /**
     * @see #TDS_FLSGS_TRANSPORT_STATE_OFF
     * @see #TDS_FLSGS_TRANSPORT_STATE_ON
     * @see #TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE
     */
    public static final int TDS_FLSGS_TRANSPORT_STATE_MASK = 0b00011000;

    /**
     * 0b00: Transport State Off
     */
    public static final int TDS_FLSGS_TRANSPORT_STATE_OFF = 0b00000000;

    /**
     * 0b01: Transport State On
     */
    public static final int TDS_FLSGS_TRANSPORT_STATE_ON = 0b00001000;

    /**
     * 0b10: Transport State TemporarilyUnavailable
     */
    public static final int TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE = 0b00010000;

    /**
     * TransportBlock
     */
    public static final class TransportBlock {

        /**
         * Organization ID
         */
        private final int mOrganizationId;

        /**
         * TDS Flags
         */
        private final int mTdsFlags;

        /**
         * Transport Data Length
         */
        private final int mTransportDataLength;

        /**
         * Transport Data
         */
        private final byte[] mTransportData;

        /**
         * @param organizationId      Organization ID
         * @param tdsFlags            TDS Flags
         * @param transportDataLength Transport Data Length
         * @param transportData       Transport Data
         */
        public TransportBlock(int organizationId, int tdsFlags, int transportDataLength, @NonNull byte[] transportData) {
            mOrganizationId = organizationId;
            mTdsFlags = tdsFlags;
            mTransportDataLength = transportDataLength;
            mTransportData = transportData;
        }

        /**
         * @return Organization ID
         */
        public int getOrganizationId() {
            return mOrganizationId;
        }

        /**
         * @return TDS Flags
         */
        public int getTdsFlags() {
            return mTdsFlags;
        }

        /**
         * @return {@code true}:Role Not specified, {@code false}:otherwise
         */
        public boolean isTdsFlagsRoleNotSpecified() {
            return isTdsFlagsMatched(TDS_FLAGS_ROLE_MASK, TDS_FLAGS_ROLE_NOT_SPECIFIED);
        }

        /**
         * @return {@code true}:Role Seeker Only, {@code false}:otherwise
         */
        public boolean isTdsFlagsRoleSeekerOnly() {
            return isTdsFlagsMatched(TDS_FLAGS_ROLE_MASK, TDS_FLAGS_ROLE_SEEKER_ONLY);
        }

        /**
         * @return {@code true}:Role Provider Only, {@code false}:otherwise
         */
        public boolean isTdsFlagsRoleProviderOnly() {
            return isTdsFlagsMatched(TDS_FLAGS_ROLE_MASK, TDS_FLAGS_ROLE_PROVIDER_ONLY);
        }

        /**
         * @return {@code true}:Role Both Seeker and Provider, {@code false}:otherwise
         */
        public boolean isTdsFlagsRoleBothSeekerAndProvider() {
            return isTdsFlagsMatched(TDS_FLAGS_ROLE_MASK, TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER);
        }

        /**
         * @return {@code true}:TransportData Incomplete False, {@code false}:TransportData Incomplete True
         */
        public boolean isTdsFlagsTransportDataIncompleteFalse() {
            return isTdsFlagsMatched(TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_MASK, TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE);
        }

        /**
         * @return {@code true}:TransportData Incomplete True, {@code false}:TransportData Incomplete False
         */
        public boolean isTdsFlagsTransportDataIncompleteTrue() {
            return isTdsFlagsMatched(TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_MASK, TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE);
        }

        /**
         * @return {@code true}:Transport State Off, {@code false}:otherwise
         */
        public boolean isTdsFlagsTransportStateOff() {
            return isTdsFlagsMatched(TDS_FLSGS_TRANSPORT_STATE_MASK, TDS_FLSGS_TRANSPORT_STATE_OFF);
        }

        /**
         * @return {@code true}:Transport State On, {@code false}:otherwise
         */
        public boolean isTdsFlagsTransportStateOn() {
            return isTdsFlagsMatched(TDS_FLSGS_TRANSPORT_STATE_MASK, TDS_FLSGS_TRANSPORT_STATE_ON);
        }

        /**
         * @return {@code true}:Transport State TemporarilyUnavailable, {@code false}:otherwise
         */
        public boolean isTdsFlagsTransportStateTemporarilyUnavailable() {
            return isTdsFlagsMatched(TDS_FLSGS_TRANSPORT_STATE_MASK, TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE);
        }


        /**
         * @return Transport Data Length
         */
        public int getTransportDataLength() {
            return mTransportDataLength;
        }

        /**
         * @return Transport Data
         */
        public byte[] getTransportData() {
            return mTransportData;
        }

        /**
         * check TDS Flags
         *
         * @param mask   bitmask for expect
         * @param expect one of {@link #TDS_FLAGS_ROLE_NOT_SPECIFIED}
         *               , {@link #TDS_FLAGS_ROLE_SEEKER_ONLY}
         *               , {@link #TDS_FLAGS_ROLE_PROVIDER_ONLY}
         *               , {@link #TDS_FLAGS_ROLE_BOTH_SEEKER_AND_PROVIDER}
         *               , {@link #TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_FALSE}
         *               , {@link #TDS_FLSGS_TRANSPORT_DATA_INCOMPLETE_TRUE}
         *               , {@link #TDS_FLSGS_TRANSPORT_STATE_OFF}
         *               , {@link #TDS_FLSGS_TRANSPORT_STATE_ON}
         *               , {@link #TDS_FLSGS_TRANSPORT_STATE_TEMPORARILY_UNAVAILABLE}
         * @return {@code true}:same as expect, {@code false}:not match
         */
        private boolean isTdsFlagsMatched(int mask, int expect) {
            return (mask & mTdsFlags) == expect;
        }

    }

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TransportDiscoveryData> CREATOR = new ByteArrayCreater<TransportDiscoveryData>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TransportDiscoveryData createFromParcel(@NonNull Parcel in) {
            return new TransportDiscoveryData(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TransportDiscoveryData[] newArray(int size) {
            return new TransportDiscoveryData[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TransportDiscoveryData createFromByteArray(@NonNull byte[] values) {
            return new TransportDiscoveryData(values, 0, values.length - 1);
        }

    };

    /**
     * Transport Block List
     */
    private final List<TransportBlock> mTransportBlockList;

    /**
     * Constructor for Advertising Interval
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public TransportDiscoveryData(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);

        List<TransportBlock> transportBlockList = new ArrayList<>();
        int index = offset + 2;
        do {
            int organizationId = data[index];
            int tdsFlags = data[index + 1];
            int transportDataLength = data[index + 2];
            transportBlockList.add(new TransportBlock(organizationId, tdsFlags, transportDataLength, Arrays.copyOfRange(data, index + 3, index + 3 + transportDataLength)));
            index += 3 + transportDataLength;
        } while (index < length);
        mTransportBlockList = Collections.unmodifiableList(Collections.synchronizedList(transportBlockList));
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TransportDiscoveryData(@NonNull Parcel in) {
        super(in.readInt());
        int size = in.readInt();
        List<TransportBlock> transportBlockList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            //noinspection ConstantConditions
            transportBlockList.add(new TransportBlock(in.readInt(), in.readInt(), in.readInt(), in.createByteArray()));
        }
        mTransportBlockList = Collections.unmodifiableList(Collections.synchronizedList(transportBlockList));
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
        dest.writeInt(mLength);
        dest.writeInt(mTransportBlockList.size());
        for (TransportBlock transportBlock : mTransportBlockList) {
            dest.writeInt(transportBlock.mOrganizationId);
            dest.writeInt(transportBlock.mTdsFlags);
            dest.writeInt(transportBlock.mTransportDataLength);
            dest.writeByteArray(transportBlock.mTransportData);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_TRANSPORT_DISCOVERY_DATA;
    }

    /**
     * @return Transport Block List
     */
    @NonNull
    public List<TransportBlock> getTransportBlockList() {
        return mTransportBlockList;
    }

}
