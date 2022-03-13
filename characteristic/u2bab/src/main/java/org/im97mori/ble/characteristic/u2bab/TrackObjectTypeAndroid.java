package org.im97mori.ble.characteristic.u2bab;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.TRACK_OBJECT_TYPE_CHARACTERISTIC;

/**
 * Track Object Type  (Characteristics UUID: 0x2BAB)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class TrackObjectTypeAndroid extends TrackObjectType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<TrackObjectTypeAndroid> CREATOR = new ByteArrayCreator<TrackObjectTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackObjectTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new TrackObjectTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrackObjectTypeAndroid[] newArray(int size) {
            return new TrackObjectTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrackObjectTypeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRACK_OBJECT_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrackObjectTypeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BAB
     */
    public TrackObjectTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrackObjectTypeAndroid(@NonNull Parcel in) {
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
