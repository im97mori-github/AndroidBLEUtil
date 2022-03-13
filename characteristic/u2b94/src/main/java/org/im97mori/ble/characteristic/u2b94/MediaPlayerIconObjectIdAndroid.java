package org.im97mori.ble.characteristic.u2b94;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.MEDIA_PLAYER_ICON_OBJECT_ID_CHARACTERISTIC;

/**
 * Media Player Icon Object ID (Characteristics UUID: 0x2B94)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaPlayerIconObjectIdAndroid extends MediaPlayerIconObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MediaPlayerIconObjectIdAndroid> CREATOR = new ByteArrayCreator<MediaPlayerIconObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerIconObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaPlayerIconObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaPlayerIconObjectIdAndroid[] newArray(int size) {
            return new MediaPlayerIconObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaPlayerIconObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MEDIA_PLAYER_ICON_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MediaPlayerIconObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B94
     */
    public MediaPlayerIconObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaPlayerIconObjectIdAndroid(@NonNull Parcel in) {
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
