package org.im97mori.ble.characteristic.u2baa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Track Segments Object Type (Characteristics UUID: 0x2BAA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackSegmentsObjectTypeAndroid extends TrackSegmentsObjectType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackSegmentsObjectTypeAndroid> CREATOR = new ByteArrayCreator<TrackSegmentsObjectTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackSegmentsObjectTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackSegmentsObjectTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackSegmentsObjectTypeAndroid[] newArray(int size) {
            return new TrackSegmentsObjectTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackSegmentsObjectTypeAndroid createFromByteArray(@NonNull byte[] values) {
            return new TrackSegmentsObjectTypeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAA
     */
    @Deprecated
    public TrackSegmentsObjectTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public TrackSegmentsObjectTypeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackSegmentsObjectTypeAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
