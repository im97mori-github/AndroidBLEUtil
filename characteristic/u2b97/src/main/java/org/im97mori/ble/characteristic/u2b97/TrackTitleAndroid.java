package org.im97mori.ble.characteristic.u2b97;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TRACK_TITLE_CHARACTERISTIC;

/**
 * Track Title (Characteristics UUID: 0x2B97)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackTitleAndroid extends TrackTitle implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackTitleAndroid> CREATOR = new ByteArrayCreator<TrackTitleAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackTitleAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackTitleAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackTitleAndroid[] newArray(int size) {
            return new TrackTitleAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackTitleAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRACK_TITLE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrackTitleAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B97
     */
    public TrackTitleAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackTitleAndroid(@NonNull Parcel in) {
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
