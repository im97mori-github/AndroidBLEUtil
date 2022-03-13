package org.im97mori.ble.characteristic.u2b44;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.CURRENT_SESSION_CHARACTERISTIC;

/**
 * Current Session (Characteristics UUID: 0x2B44)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class CurrentSessionAndroid extends CurrentSession implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<CurrentSessionAndroid> CREATOR = new ByteArrayCreator<CurrentSessionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentSessionAndroid createFromParcel(@NonNull Parcel in) {
            return new CurrentSessionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public CurrentSessionAndroid[] newArray(int size) {
            return new CurrentSessionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public CurrentSessionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(CURRENT_SESSION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new CurrentSessionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B44
     */
    public CurrentSessionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private CurrentSessionAndroid(@NonNull Parcel in) {
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
