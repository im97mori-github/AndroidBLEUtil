package org.im97mori.ble.characteristic.u2b9d;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_TRACK_OBJECT_ID_CHARACTERISTIC;

/**
 * Current Track Object ID (Characteristics UUID: 0x2B9D)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CurrentTrackObjectIdAndroid extends CurrentTrackObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CurrentTrackObjectIdAndroid> CREATOR = new ByteArrayCreator<CurrentTrackObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTrackObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new CurrentTrackObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentTrackObjectIdAndroid[] newArray(int size) {
            return new CurrentTrackObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentTrackObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CURRENT_TRACK_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CurrentTrackObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9D
     */
    public CurrentTrackObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentTrackObjectIdAndroid(@NonNull Parcel in) {
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
