package org.im97mori.ble.characteristic.u2b7a;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_INPUT_STATUS_CHARACTERISTIC;

/**
 * Audio Input Status (Characteristics UUID: 0x2B7A)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioInputStatusAndroid extends AudioInputStatus implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AudioInputStatusAndroid> CREATOR = new ByteArrayCreater<AudioInputStatusAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputStatusAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioInputStatusAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputStatusAndroid[] newArray(int size) {
            return new AudioInputStatusAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioInputStatusAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_INPUT_STATUS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioInputStatusAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B7A
     */
    public AudioInputStatusAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioInputStatusAndroid(@NonNull Parcel in) {
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
