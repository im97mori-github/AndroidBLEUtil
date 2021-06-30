package org.im97mori.ble.characteristic.u2ba2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.PLAYING_ORDERS_SUPPORTED_CHARACTERISTIC;

/**
 * Playing Orders Supported (Characteristics UUID: 0x2BA2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class PlayingOrdersSupportedAndroid extends PlayingOrdersSupported implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<PlayingOrdersSupportedAndroid> CREATOR = new ByteArrayCreater<PlayingOrdersSupportedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlayingOrdersSupportedAndroid createFromParcel(@NonNull Parcel in) {
            return new PlayingOrdersSupportedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public PlayingOrdersSupportedAndroid[] newArray(int size) {
            return new PlayingOrdersSupportedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public PlayingOrdersSupportedAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PLAYING_ORDERS_SUPPORTED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new PlayingOrdersSupportedAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA2
     */
    public PlayingOrdersSupportedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private PlayingOrdersSupportedAndroid(@NonNull Parcel in) {
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
