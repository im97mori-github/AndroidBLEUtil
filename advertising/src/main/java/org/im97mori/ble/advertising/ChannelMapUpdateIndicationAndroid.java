package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import java.util.List;

/**
 * <p>
 * Channel Map Update Indication
 * <p>
 * https://www.bluetooth.com/specifications/assigned-numbers/generic-access-profile/
 * </p>
 */
public class ChannelMapUpdateIndicationAndroid extends ChannelMapUpdateIndication implements AdvertisingDataInterfaceAndroid {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ChannelMapUpdateIndicationAndroid> CREATOR = new ByteArrayCreater<ChannelMapUpdateIndicationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChannelMapUpdateIndicationAndroid createFromParcel(@NonNull Parcel in) {
            return new ChannelMapUpdateIndicationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ChannelMapUpdateIndicationAndroid[] newArray(int size) {
            return new ChannelMapUpdateIndicationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public ChannelMapUpdateIndicationAndroid createFromByteArray(@NonNull byte[] values) {
            return new ChannelMapUpdateIndicationAndroid(values, 0, values.length - 1);
        }

    };

    /**
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @see #ChannelMapUpdateIndicationAndroid(byte[], int, int)
     */
    public ChannelMapUpdateIndicationAndroid(@NonNull byte[] data, int offset) {
        this(data, offset, data[offset]);
    }

    /**
     * Constructor from parameters
     *
     * @param chmList	ChM list
     * @param instant	Instant
     */
    public ChannelMapUpdateIndicationAndroid(@NonNull List<Integer> chmList, int instant) {
        super(chmList, instant);
    }

    /**
     * Constructor for Channel Map Update Indication
     *
     * @param data   byte array from {@link ScanRecord#getBytes()}
     * @param offset data offset
     * @param length 1st octed of Advertising Data
     */
    public ChannelMapUpdateIndicationAndroid(@NonNull byte[] data
            , int offset
            , int length) {
        super(data, offset, length);
    }


    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ChannelMapUpdateIndicationAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray(), 0, in.readInt());
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
        dest.writeByteArray(getBytes());
        dest.writeInt(getLength());
    }

}
