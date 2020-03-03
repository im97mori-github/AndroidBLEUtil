package org.im97mori.ble.advertising;

import android.bluetooth.le.ScanRecord;
import android.os.Parcel;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

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
    @SuppressWarnings("ConstantConditions")
    private ChannelMapUpdateIndicationAndroid(@NonNull Parcel in) {
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
