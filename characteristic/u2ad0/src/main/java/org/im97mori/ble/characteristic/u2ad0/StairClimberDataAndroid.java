package org.im97mori.ble.characteristic.u2ad0;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Stair Climber Data (Characteristics UUID: 0x2AD0)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class StairClimberDataAndroid extends StairClimberData implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final MultiplePacketCreater<StairClimberDataAndroid, StairClimberDataPacketAndroid> CREATOR = new MultiplePacketCreater<StairClimberDataAndroid, StairClimberDataPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StairClimberDataAndroid createFromParcel(@NonNull Parcel in) {
            return new StairClimberDataAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public StairClimberDataAndroid[] newArray(int size) {
            return new StairClimberDataAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public StairClimberDataAndroid createFromMultiplePacketArray(@NonNull StairClimberDataPacketAndroid[] multiplePacketArray) {
            return new StairClimberDataAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link StairClimberDataPacket} array
     *
     * @param stairClimberDataPackets 1 or more Stair Climber Data packet array
     */
    public StairClimberDataAndroid(@NonNull StairClimberDataPacketAndroid[] stairClimberDataPackets) {
        super(stairClimberDataPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private StairClimberDataAndroid(@NonNull Parcel in) {
        super(new StairClimberDataPacketAndroid[]{StairClimberDataPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
