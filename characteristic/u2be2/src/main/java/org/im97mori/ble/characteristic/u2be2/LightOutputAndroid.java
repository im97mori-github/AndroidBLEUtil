package org.im97mori.ble.characteristic.u2be2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Light Output (Characteristics UUID: 0x2BE2)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LightOutputAndroid extends LightOutput implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LightOutputAndroid> CREATOR = new ByteArrayCreator<LightOutputAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightOutputAndroid createFromParcel(@NonNull Parcel in) {
            return new LightOutputAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightOutputAndroid[] newArray(int size) {
            return new LightOutputAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LightOutputAndroid createFromByteArray(@NonNull byte[] values) {
            return new LightOutputAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE2
     */
    @Deprecated
    public LightOutputAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LightOutputAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LightOutputAndroid(@NonNull Parcel in) {
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
