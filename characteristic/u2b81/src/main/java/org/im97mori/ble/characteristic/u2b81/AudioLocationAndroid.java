package org.im97mori.ble.characteristic.u2b81;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_LOCATION_CHARACTERISTIC;

/**
 * Audio Location (Characteristics UUID: 0x2B81)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioLocationAndroid extends AudioLocation implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AudioLocationAndroid> CREATOR = new ByteArrayCreater<AudioLocationAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioLocationAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioLocationAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioLocationAndroid[] newArray(int size) {
            return new AudioLocationAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioLocationAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_LOCATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioLocationAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B81
     */
    public AudioLocationAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioLocationAndroid(@NonNull Parcel in) {
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
