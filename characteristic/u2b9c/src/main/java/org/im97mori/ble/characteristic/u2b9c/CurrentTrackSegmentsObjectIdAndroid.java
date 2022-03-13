package org.im97mori.ble.characteristic.u2b9c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TRACK_SEGMENTS_OBJECT_ID_CHARACTERISTIC;

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CURRENT_TRACK_SEGMENTS_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CurrentTrackSegmentsObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9C
     */
    public CurrentTrackSegmentsObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentTrackSegmentsObjectIdAndroid(@NonNull Parcel in) {
        //noinspection ConstantConditions
        super(in.createByteArray());
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
