package org.im97mori.ble.ad;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static org.im97mori.ble.ad.AdvertisingDataConstants.AdvertisingDataTypes.DATA_TYPE_CHANNEL_MAP_UPDATE_INDICATION;
import static org.im97mori.ble.ad.AdvertisingDataConstants.PHYSICAL_CHANNEL_INDICES_MAP;

/**
 * <p>
 * Channel Map Update Indication
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
@SuppressWarnings("WeakerAccess")
public class ChannelMapUpdateIndication extends AbstractAdvertisingData implements Parcelable {

    /**
     * @see Creator
     */
    public static final Creator<ChannelMapUpdateIndication> CREATOR = new Creator<ChannelMapUpdateIndication>() {

        /**
         * {@inheritDoc}
         */
        @Override
        public ChannelMapUpdateIndication createFromParcel(Parcel in) {
            return new ChannelMapUpdateIndication(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        public ChannelMapUpdateIndication[] newArray(int size) {
            return new ChannelMapUpdateIndication[size];
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
     * Channel Map Update Indication
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ChannelMapUpdateIndication(byte[] data, int offset, int length) {
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
    @SuppressWarnings("unchecked")
    private ChannelMapUpdateIndication(Parcel in) {
        super(in.readInt());
        mChmList = Collections.synchronizedList(in.readArrayList(this.getClass().getClassLoader()));
        mUnusedChannelList = Collections.synchronizedList(in.readArrayList(this.getClass().getClassLoader()));
        mUnusedChannelListRfCenterFrequencyList = Collections.synchronizedList(in.readArrayList(this.getClass().getClassLoader()));
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
    public void writeToParcel(Parcel dest, int flags) {
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
    public List<Integer> getChmList() {
        return mChmList;
    }

    /**
     * @return unused PHY Channel list
     */
    public List<Integer> getUnusedPhyChannelList() {
        return mUnusedChannelList;
    }

    /**
     * @return unused RF Center Frequency(MHz)
     */
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
