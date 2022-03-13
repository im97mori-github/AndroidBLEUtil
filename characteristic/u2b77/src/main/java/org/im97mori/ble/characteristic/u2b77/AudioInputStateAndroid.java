package org.im97mori.ble.characteristic.u2b77;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_INPUT_STATE_CHARACTERISTIC;

/**
 * Audio Input State (Characteristics UUID: 0x2B77)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioInputStateAndroid extends AudioInputState implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AudioInputStateAndroid> CREATOR = new ByteArrayCreator<AudioInputStateAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputStateAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioInputStateAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputStateAndroid[] newArray(int size) {
            return new AudioInputStateAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioInputStateAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_INPUT_STATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioInputStateAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B77
     */
    public AudioInputStateAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioInputStateAndroid(@NonNull Parcel in) {
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
