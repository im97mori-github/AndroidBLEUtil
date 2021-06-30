package org.im97mori.ble.characteristic.u2b7b;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.constants.CharacteristicUUID.AUDIO_INPUT_CONTROL_POINT_CHARACTERISTIC;

/**
 * Audio Input Control Point (Characteristics UUID: 0x2B7B)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class AudioInputControlPointAndroid extends AudioInputControlPoint implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<AudioInputControlPointAndroid> CREATOR = new ByteArrayCreater<AudioInputControlPointAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputControlPointAndroid createFromParcel(@NonNull Parcel in) {
            return new AudioInputControlPointAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public AudioInputControlPointAndroid[] newArray(int size) {
            return new AudioInputControlPointAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public AudioInputControlPointAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AUDIO_INPUT_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new AudioInputControlPointAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B7B
     */
    public AudioInputControlPointAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private AudioInputControlPointAndroid(@NonNull Parcel in) {
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
