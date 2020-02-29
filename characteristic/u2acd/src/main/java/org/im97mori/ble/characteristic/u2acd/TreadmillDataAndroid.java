package org.im97mori.ble.characteristic.u2acd;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Treadmill Data (Characteristics UUID: 0x2ACD)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TreadmillDataAndroid extends TreadmillData implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<TreadmillDataAndroid, TreadmillDataPacketAndroid> CREATOR = new MultiplePacketCreater<TreadmillDataAndroid, TreadmillDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataAndroid createFromParcel(@NonNull Parcel in) {
            return new TreadmillDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TreadmillDataAndroid[] newArray(int size) {
            return new TreadmillDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public TreadmillDataAndroid createFromMultiplePacketArray(@NonNull TreadmillDataPacketAndroid[] multiplePacketArray) {
            return new TreadmillDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link TreadmillDataPacket} array
     *
     * @param treadmillDataPackets 1 or more Treadmill Data packet array
     */
    public TreadmillDataAndroid(@NonNull TreadmillDataPacketAndroid[] treadmillDataPackets) {
        super(treadmillDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private TreadmillDataAndroid(@NonNull Parcel in) {
        super(new TreadmillDataPacketAndroid[]{TreadmillDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
    }

}
