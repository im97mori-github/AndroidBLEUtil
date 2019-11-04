package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.im97mori.ble.advertising.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.im97mori.ble.advertising.AdvertisingDataConstants.PHYSICAL_CHANNEL_INDICES_MAP;

/**
 * <p>
 * Channel Map Update Indication
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ChannelMapUpdateIndication extends AbstractAdvertisingData {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ChannelMapUpdateIndication> CREATOR = new ByteArrayCreater<ChannelMapUpdateIndication>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChannelMapUpdateIndication createFromParcel(@NonNull Parcel in) {
            return new ChannelMapUpdateIndication(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChannelMapUpdateIndication[] newArray(int size) {
            return new ChannelMapUpdateIndication[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ChannelMapUpdateIndication createFromByteArray(@NonNull byte[] values) {
            return new ChannelMapUpdateIndication(values, 0, values.length - 1);
        }

    };

    /**
     * ChM list
     */
    private final List<Integer> mChmList;

    /**
     * unused PHY Channel list
     */
    private final List<Integer> mUnusedChannelList;

    /**
     * unused RF Center Frequency(MHz)
     */
    private final List<Integer> mUnusedChannelListRfCenterFrequencyList;

    /**
     * Instant
     */
    private final int mInstant;


    /**
     * Constructor for Channel Map Update Indication
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ChannelMapUpdateIndication(@NonNull byte[] data
            , int offset
            , int length) {
        super(length);

        List<Integer> chmList = new ArrayList<>();
        chmList.add(data[offset + 2] & 0xff);
        chmList.add(data[offset + 3] & 0xff);
        chmList.add(data[offset + 4] & 0xff);
        chmList.add(data[offset + 5] & 0xff);
        chmList.add(data[offset + 6] & 0xff);
        mChmList = Collections.synchronizedList(Collections.unmodifiableList(chmList));

        // create index
        List<Integer> channelList = new ArrayList<>();
        List<Integer> frequencyList = new ArrayList<>();
        int phyChannel, channelIndex, listIndex, bitmask;
        for (Map.Entry<Integer, Integer> entry : PHYSICAL_CHANNEL_INDICES_MAP.entrySet()) {
            phyChannel = entry.getKey();
            channelIndex = entry.getValue();
            listIndex = channelIndex / 8;
            bitmask = 1 << (channelIndex % 8);
            if ((mChmList.get(listIndex) & bitmask) == 0) {
                channelList.add(phyChannel);
                frequencyList.add(2400 + (phyChannel + 1) * 2);
            }
        }
        Collections.sort(channelList);
        Collections.sort(frequencyList);
        mUnusedChannelList = Collections.synchronizedList(Collections.unmodifiableList(channelList));
        mUnusedChannelListRfCenterFrequencyList = Collections.synchronizedList(Collections.unmodifiableList(frequencyList));

        int instant = data[offset + 7] & 0xff;
        instant |= (data[offset + 8] & 0xff) << 8;
        mInstant = instant;
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChannelMapUpdateIndication(@NonNull Parcel in) {
        super(in.readInt());

        List<Integer> list = new ArrayList<>();
        in.readList(list, this.getClass().getClassLoader());
        mChmList = Collections.synchronizedList(Collections.unmodifiableList(list));

        list = new ArrayList<>();
        in.readList(list, this.getClass().getClassLoader());
        mUnusedChannelList = Collections.synchronizedList(Collections.unmodifiableList(list));

        list = new ArrayList<>();
        in.readList(list, this.getClass().getClassLoader());
        mUnusedChannelListRfCenterFrequencyList = Collections.synchronizedList(Collections.unmodifiableList(list));

        mInstant = in.readInt();
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
        dest.writeList(mChmList);
        dest.writeList(mUnusedChannelList);
        dest.writeList(mUnusedChannelListRfCenterFrequencyList);
        dest.writeInt(mInstant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getDataType() {
        return DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
    }

    /**
     * @return ChM list
     */
    @NonNull
    public List<Integer> getChmList() {
        return mChmList;
    }

    /**
     * @return unused PHY Channel list
     */
    @NonNull
    public List<Integer> getUnusedPhyChannelList() {
        return mUnusedChannelList;
    }

    /**
     * @return unused RF Center Frequency(MHz)
     */
    @NonNull
    public List<Integer> getUnusedPhyChannelRfCenterFrequencyList() {
        return mUnusedChannelListRfCenterFrequencyList;
    }

    /**
     * @return Instant
     */
    public int getInstant() {
        return mInstant;
    }

}
