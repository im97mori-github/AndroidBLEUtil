package org.im97mori.ble.characteristic.u2bca;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import static org.im97mori.ble.constants.CharacteristicUUID.SINK_AUDIO_LOCATIONS_CHARACTERISTIC;

/**
 * Sink Audio Locations (Characteristics UUID: 0x2BCA)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class SinkAudioLocationsAndroid extends SinkAudioLocations implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<SinkAudioLocationsAndroid> CREATOR = new ByteArrayCreator<SinkAudioLocationsAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAudioLocationsAndroid createFromParcel(@NonNull Parcel in) {
            return new SinkAudioLocationsAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public SinkAudioLocationsAndroid[] newArray(int size) {
            return new SinkAudioLocationsAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public SinkAudioLocationsAndroid createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(SINK_AUDIO_LOCATIONS_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new SinkAudioLocationsAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BCA
     */
    public SinkAudioLocationsAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private SinkAudioLocationsAndroid(@NonNull Parcel in) {
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
