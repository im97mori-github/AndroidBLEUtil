package org.im97mori.ble.characteristic.u2b93;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MEDIA_PLAYER_NAME_CHARACTERISTIC;

/**
 * Media Player Name (Characteristics UUID: 0x2B93)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaPlayerNameAndroid extends MediaPlayerName implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MediaPlayerNameAndroid> CREATOR = new ByteArrayCreater<MediaPlayerNameAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerNameAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaPlayerNameAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerNameAndroid[] newArray(int size) {
            return new MediaPlayerNameAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaPlayerNameAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MEDIA_PLAYER_NAME_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MediaPlayerNameAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B93
     */
    public MediaPlayerNameAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaPlayerNameAndroid(@NonNull Parcel in) {
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
