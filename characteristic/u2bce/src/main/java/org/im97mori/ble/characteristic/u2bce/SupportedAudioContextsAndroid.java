package org.im97mori.ble.characteristic.u2bce;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SUPPORTED_AUDIO_CONTEXTS_CHARACTERISTIC;

/**
 * Supported Audio Contexts  (Characteristics UUID: 0x2BCE)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SupportedAudioContextsAndroid extends SupportedAudioContexts implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SupportedAudioContextsAndroid> CREATOR = new ByteArrayCreator<SupportedAudioContextsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedAudioContextsAndroid createFromParcel(@NonNull Parcel in) {
            return new SupportedAudioContextsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SupportedAudioContextsAndroid[] newArray(int size) {
            return new SupportedAudioContextsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SupportedAudioContextsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SUPPORTED_AUDIO_CONTEXTS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SupportedAudioContextsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCE
     */
    public SupportedAudioContextsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SupportedAudioContextsAndroid(@NonNull Parcel in) {
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
