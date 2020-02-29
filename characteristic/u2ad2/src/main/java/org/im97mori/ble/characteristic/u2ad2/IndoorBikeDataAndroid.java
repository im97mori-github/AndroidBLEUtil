package org.im97mori.ble.characteristic.u2ad2;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Indoor Bike Data (Characteristics UUID: 0x2AD2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class IndoorBikeDataAndroid extends IndoorBikeData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<IndoorBikeDataAndroid, IndoorBikeDataPacketAndroid> CREATOR = new MultiplePacketCreater<IndoorBikeDataAndroid, IndoorBikeDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataAndroid createFromParcel(@NonNull Parcel in) {
            return new IndoorBikeDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public IndoorBikeDataAndroid[] newArray(int size) {
            return new IndoorBikeDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public IndoorBikeDataAndroid createFromMultiplePacketArray(@NonNull IndoorBikeDataPacketAndroid[] multiplePacketArray) {
            return new IndoorBikeDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link IndoorBikeDataPacket} array
     *
     * @param indoorBikeDataPackets 1 or more Indoor Bike Data packet array
     */
    public IndoorBikeDataAndroid(@NonNull IndoorBikeDataPacketAndroid[] indoorBikeDataPackets) {
        super(indoorBikeDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private IndoorBikeDataAndroid(@NonNull Parcel in) {
        super(new IndoorBikeDataPacketAndroid[]{IndoorBikeDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
