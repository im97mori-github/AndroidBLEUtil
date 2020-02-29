package org.im97mori.ble.characteristic.u2ad1;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Rower Data (Characteristics UUID: 0x2AD1)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RowerDataAndroid extends RowerData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<RowerDataAndroid, RowerDataPacketAndroid> CREATOR = new MultiplePacketCreater<RowerDataAndroid, RowerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataAndroid createFromParcel(@NonNull Parcel in) {
            return new RowerDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RowerDataAndroid[] newArray(int size) {
            return new RowerDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public RowerDataAndroid createFromMultiplePacketArray(@NonNull RowerDataPacketAndroid[] multiplePacketArray) {
            return new RowerDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link RowerDataPacket} array
     *
     * @param rowerDataPackets 1 or more Rower Data packet array
     */
    public RowerDataAndroid(@NonNull RowerDataPacketAndroid[] rowerDataPackets) {
        super(rowerDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private RowerDataAndroid(@NonNull Parcel in) {
        super(new RowerDataPacketAndroid[]{RowerDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
