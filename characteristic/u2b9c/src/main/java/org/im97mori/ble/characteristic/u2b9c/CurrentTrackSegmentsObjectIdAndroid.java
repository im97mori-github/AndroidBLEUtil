package org.im97mori.ble.characteristic.u2b9c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Current Track Segments Object ID (Characteristics UUID: 0x2B9C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CurrentTrackSegmentsObjectIdAndroid extends CurrentTrackSegmentsObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CurrentTrackSegmentsObjectIdAndroid> CREATOR = new ByteArrayCreator<CurrentTrackSegmentsObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTrackSegmentsObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new CurrentTrackSegmentsObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTrackSegmentsObjectIdAndroid[] newArray(int size) {
            return new CurrentTrackSegmentsObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentTrackSegmentsObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            return new CurrentTrackSegmentsObjectIdAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9C
     */
    @Deprecated
    public CurrentTrackSegmentsObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public CurrentTrackSegmentsObjectIdAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentTrackSegmentsObjectIdAndroid(@NonNull Parcel in) {
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
