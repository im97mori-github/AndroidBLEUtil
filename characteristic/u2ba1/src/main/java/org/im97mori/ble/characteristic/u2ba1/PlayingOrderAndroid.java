package org.im97mori.ble.characteristic.u2ba1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.PLAYING_ORDER_CHARACTERISTIC;

/**
 * Playing Order (Characteristics UUID: 0x2BA1)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlayingOrderAndroid extends PlayingOrder implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<PlayingOrderAndroid> CREATOR = new ByteArrayCreator<PlayingOrderAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlayingOrderAndroid createFromParcel(@NonNull Parcel in) {
            return new PlayingOrderAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlayingOrderAndroid[] newArray(int size) {
            return new PlayingOrderAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlayingOrderAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PLAYING_ORDER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PlayingOrderAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA1
     */
    public PlayingOrderAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlayingOrderAndroid(@NonNull Parcel in) {
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
