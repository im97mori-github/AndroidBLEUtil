package org.im97mori.ble.characteristic.u2b9e;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.NEXT_TRACK_OBJECT_ID_CHARACTERISTIC;

/**
 * Next Track Object ID (Characteristics UUID: 0x2B9E)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class NextTrackObjectIdAndroid extends NextTrackObjectId implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<NextTrackObjectIdAndroid> CREATOR = new ByteArrayCreator<NextTrackObjectIdAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NextTrackObjectIdAndroid createFromParcel(@NonNull Parcel in) {
            return new NextTrackObjectIdAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public NextTrackObjectIdAndroid[] newArray(int size) {
            return new NextTrackObjectIdAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public NextTrackObjectIdAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(NEXT_TRACK_OBJECT_ID_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new NextTrackObjectIdAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B9E
     */
    public NextTrackObjectIdAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private NextTrackObjectIdAndroid(@NonNull Parcel in) {
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
