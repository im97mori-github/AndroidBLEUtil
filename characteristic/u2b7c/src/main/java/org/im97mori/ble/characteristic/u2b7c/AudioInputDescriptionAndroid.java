package org.im97mori.ble.characteristic.u2b7c;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_INPUT_DESCRIPTION_CHARACTERISTIC;

/**
 * Audio Input Description (Characteristics UUID: 0x2B7C)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioInputDescriptionAndroid extends AudioInputDescription implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AudioInputDescriptionAndroid> CREATOR = new ByteArrayCreater<AudioInputDescriptionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputDescriptionAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioInputDescriptionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputDescriptionAndroid[] newArray(int size) {
            return new AudioInputDescriptionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioInputDescriptionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_INPUT_DESCRIPTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioInputDescriptionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B7C
     */
    public AudioInputDescriptionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioInputDescriptionAndroid(@NonNull Parcel in) {
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
