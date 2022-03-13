package org.im97mori.ble.characteristic.u2bc3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.MUTE_CHARACTERISTIC;

/**
 * Mute (Characteristics UUID: 0x2BC3)
 */
@SuppressWarnings({"WeakerAccess"})
public class MuteAndroid extends Mute implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MuteAndroid> CREATOR = new ByteArrayCreator<MuteAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MuteAndroid createFromParcel(@NonNull Parcel in) {
            return new MuteAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MuteAndroid[] newArray(int size) {
            return new MuteAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MuteAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MUTE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MuteAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BC3
     */
    public MuteAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from parameters
     *
     * @param mute Appearance Value
     */
    public MuteAndroid(int mute) {
        super(mute);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MuteAndroid(@NonNull Parcel in) {
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
