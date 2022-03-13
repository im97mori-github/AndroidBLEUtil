package org.im97mori.ble.characteristic.u2b9a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PLAYBACK_SPEED_CHARACTERISTIC;

/**
 * Playback Speed (Characteristics UUID: 0x2B9A)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlaybackSpeedAndroid extends PlaybackSpeed implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PlaybackSpeedAndroid> CREATOR = new ByteArrayCreator<PlaybackSpeedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlaybackSpeedAndroid createFromParcel(@NonNull Parcel in) {
            return new PlaybackSpeedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlaybackSpeedAndroid[] newArray(int size) {
            return new PlaybackSpeedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlaybackSpeedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PLAYBACK_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PlaybackSpeedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9A
     */
    public PlaybackSpeedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlaybackSpeedAndroid(@NonNull Parcel in) {
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
