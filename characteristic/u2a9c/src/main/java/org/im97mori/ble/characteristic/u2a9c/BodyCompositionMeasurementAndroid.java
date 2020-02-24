package org.im97mori.ble.characteristic.u2a9c;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.characteristic.core.MultiplePacketCreater;

/**
 * Body Composition Measurement (Characteristics UUID: 0x2A9C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class BodyCompositionMeasurementAndroid extends BodyCompositionMeasurement implements Parcelable {

    /**
     * @see MultiplePacketCreater
     */
    public static final MultiplePacketCreater<BodyCompositionMeasurementAndroid, BodyCompositionMeasurementPacketAndroid> CREATOR = new MultiplePacketCreater<BodyCompositionMeasurementAndroid, BodyCompositionMeasurementPacketAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementAndroid createFromParcel(@NonNull Parcel in) {
            return new BodyCompositionMeasurementAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public BodyCompositionMeasurementAndroid[] newArray(int size) {
            return new BodyCompositionMeasurementAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        @Override
        public BodyCompositionMeasurementAndroid createFromMultiplePacketArray(@NonNull BodyCompositionMeasurementPacketAndroid[] multiplePacketArray) {
            return new BodyCompositionMeasurementAndroid(multiplePacketArray);
        }

    };

    /**
     * Constructor from {@link BodyCompositionMeasurementPacket} array
     *
     * @param bodyCompositionMeasurementPackets 1 or 2 Body Composition Measurement packet array
     */
    public BodyCompositionMeasurementAndroid(@NonNull BodyCompositionMeasurementPacketAndroid[] bodyCompositionMeasurementPackets) {
        super(bodyCompositionMeasurementPackets);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    @SuppressWarnings("ConstantConditions")
    private BodyCompositionMeasurementAndroid(@NonNull Parcel in) {
        super(new BodyCompositionMeasurementPacketAndroid[]{BodyCompositionMeasurementPacketAndroid.CREATOR.createFromByteArray(in.createByteArray())});
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
