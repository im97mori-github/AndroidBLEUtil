package org.im97mori.ble.characteristic.u2b96;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TRACK_CHANGED_CHARACTERISTIC;

/**
 * Track Changed (Characteristics UUID: 0x2B96)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackChangedAndroid extends TrackChanged implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackChangedAndroid> CREATOR = new ByteArrayCreator<TrackChangedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackChangedAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackChangedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackChangedAndroid[] newArray(int size) {
            return new TrackChangedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackChangedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRACK_CHANGED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrackChangedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B96
     */
    public TrackChangedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackChangedAndroid(@NonNull Parcel in) {
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
