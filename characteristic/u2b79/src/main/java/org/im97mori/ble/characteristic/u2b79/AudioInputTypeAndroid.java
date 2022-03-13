package org.im97mori.ble.characteristic.u2b79;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_INPUT_TYPE_CHARACTERISTIC;

/**
 * Audio Input Type (Characteristics UUID: 0x2B79)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioInputTypeAndroid extends AudioInputType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AudioInputTypeAndroid> CREATOR = new ByteArrayCreator<AudioInputTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioInputTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputTypeAndroid[] newArray(int size) {
            return new AudioInputTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioInputTypeAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_INPUT_TYPE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioInputTypeAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B79
     */
    public AudioInputTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioInputTypeAndroid(@NonNull Parcel in) {
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
