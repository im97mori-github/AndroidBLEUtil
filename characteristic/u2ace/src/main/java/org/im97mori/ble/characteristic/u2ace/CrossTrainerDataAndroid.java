package org.im97mori.ble.characteristic.u2ace;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Cross Trainer Data (Characteristics UUID: 0x2ACE)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class CrossTrainerDataAndroid extends CrossTrainerData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<CrossTrainerDataAndroid, CrossTrainerDataPacketAndroid> CREATOR = new MultiplePacketCreater<CrossTrainerDataAndroid, CrossTrainerDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataAndroid createFromParcel(@NonNull Parcel in) {
            return new CrossTrainerDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CrossTrainerDataAndroid[] newArray(int size) {
            return new CrossTrainerDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public CrossTrainerDataAndroid createFromMultiplePacketArray(@NonNull CrossTrainerDataPacketAndroid[] multiplePacketArray) {
            return new CrossTrainerDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link CrossTrainerDataPacket} array
     *
     * @param crossTrainerDataPackets 1 or more Cross Trainer Data packet array
     */
    public CrossTrainerDataAndroid(@NonNull CrossTrainerDataPacket[] crossTrainerDataPackets) {
        super(crossTrainerDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private CrossTrainerDataAndroid(@NonNull Parcel in) {
        super(new CrossTrainerDataPacketAndroid[]{CrossTrainerDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
