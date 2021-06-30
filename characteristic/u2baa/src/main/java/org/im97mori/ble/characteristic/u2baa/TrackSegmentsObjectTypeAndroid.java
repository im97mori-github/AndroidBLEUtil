package org.im97mori.ble.characteristic.u2baa;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TRACK_SEGMENTS_OBJECT_TYPE_CHARACTERISTIC;

/**
 * Track Segments Object Type (Characteristics UUID: 0x2BAA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackSegmentsObjectTypeAndroid extends TrackSegmentsObjectType implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrackSegmentsObjectTypeAndroid> CREATOR = new ByteArrayCreater<TrackSegmentsObjectTypeAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRACK_SEGMENTS_OBJECT_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrackSegmentsObjectTypeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAA
     */
    public TrackSegmentsObjectTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackSegmentsObjectTypeAndroid(@NonNull Parcel in) {
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
