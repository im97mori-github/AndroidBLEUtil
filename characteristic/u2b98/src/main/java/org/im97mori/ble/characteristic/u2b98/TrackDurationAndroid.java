package org.im97mori.ble.characteristic.u2b98;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.TRACK_DURATION_CHARACTERISTIC;

/**
 * Track Duration (Characteristics UUID: 0x2B98)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackDurationAndroid extends TrackDuration implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrackDurationAndroid> CREATOR = new ByteArrayCreater<TrackDurationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackDurationAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackDurationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackDurationAndroid[] newArray(int size) {
            return new TrackDurationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackDurationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRACK_DURATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrackDurationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B98
     */
    public TrackDurationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackDurationAndroid(@NonNull Parcel in) {
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
