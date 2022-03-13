package org.im97mori.ble.characteristic.u2bcc;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SOURCE_AUDIO_LOCATIONS_CHARACTERISTIC;

/**
 * Source Audio Locations (Characteristics UUID: 0x2BCC)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SourceAudioLocationsAndroid extends SourceAudioLocations implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SourceAudioLocationsAndroid> CREATOR = new ByteArrayCreator<SourceAudioLocationsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourceAudioLocationsAndroid createFromParcel(@NonNull Parcel in) {
            return new SourceAudioLocationsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SourceAudioLocationsAndroid[] newArray(int size) {
            return new SourceAudioLocationsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SourceAudioLocationsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SOURCE_AUDIO_LOCATIONS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SourceAudioLocationsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCC
     */
    public SourceAudioLocationsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SourceAudioLocationsAndroid(@NonNull Parcel in) {
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
