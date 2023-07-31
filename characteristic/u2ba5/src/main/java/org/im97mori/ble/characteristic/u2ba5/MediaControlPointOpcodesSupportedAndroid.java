package org.im97mori.ble.characteristic.u2ba5;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Media Control Point Opcodes Supported (Characteristics UUID: 0x2BA5)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class MediaControlPointOpcodesSupportedAndroid extends MediaControlPointOpcodesSupported implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MediaControlPointOpcodesSupportedAndroid> CREATOR = new ByteArrayCreator<MediaControlPointOpcodesSupportedAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaControlPointOpcodesSupportedAndroid createFromParcel(@NonNull Parcel in) {
            return new MediaControlPointOpcodesSupportedAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MediaControlPointOpcodesSupportedAndroid[] newArray(int size) {
            return new MediaControlPointOpcodesSupportedAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MediaControlPointOpcodesSupportedAndroid createFromByteArray(@NonNull byte[] values) {
            return new MediaControlPointOpcodesSupportedAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BA5
     */
    @Deprecated
    public MediaControlPointOpcodesSupportedAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MediaControlPointOpcodesSupportedAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MediaControlPointOpcodesSupportedAndroid(@NonNull Parcel in) {
        super(Objects.requireNonNull(in.createByteArray()));
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
