package org.im97mori.ble.characteristic.u2b95;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.MEDIA_PLAYER_ICON_URL_CHARACTERISTIC;

/**
 * Media Player Icon URL (Characteristics UUID: 0x2B95)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaPlayerIconUrlAndroid extends MediaPlayerIconUrl implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MediaPlayerIconUrlAndroid> CREATOR = new ByteArrayCreater<MediaPlayerIconUrlAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerIconUrlAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaPlayerIconUrlAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerIconUrlAndroid[] newArray(int size) {
            return new MediaPlayerIconUrlAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaPlayerIconUrlAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MEDIA_PLAYER_ICON_URL_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MediaPlayerIconUrlAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B95
     */
    public MediaPlayerIconUrlAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaPlayerIconUrlAndroid(@NonNull Parcel in) {
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
