package org.im97mori.ble.characteristic.u2b83;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_OUTPUT_DESCRIPTION_CHARACTERISTIC;

/**
 * Audio Output Description (Characteristics UUID: 0x2B83)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioOutputDescriptionAndroid extends AudioOutputDescription implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<AudioOutputDescriptionAndroid> CREATOR = new ByteArrayCreator<AudioOutputDescriptionAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioOutputDescriptionAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioOutputDescriptionAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioOutputDescriptionAndroid[] newArray(int size) {
            return new AudioOutputDescriptionAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioOutputDescriptionAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_OUTPUT_DESCRIPTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioOutputDescriptionAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B83
     */
    public AudioOutputDescriptionAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioOutputDescriptionAndroid(@NonNull Parcel in) {
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
