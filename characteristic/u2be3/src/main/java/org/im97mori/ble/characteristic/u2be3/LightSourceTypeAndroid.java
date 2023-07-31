package org.im97mori.ble.characteristic.u2be3;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Light Source Type (Characteristics UUID: 0x2BE3)
 */
// TODO
@SuppressWarnings({"WeakerAccess"})
public class LightSourceTypeAndroid extends LightSourceType implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LightSourceTypeAndroid> CREATOR = new ByteArrayCreator<LightSourceTypeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightSourceTypeAndroid createFromParcel(@NonNull Parcel in) {
            return new LightSourceTypeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LightSourceTypeAndroid[] newArray(int size) {
            return new LightSourceTypeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LightSourceTypeAndroid createFromByteArray(@NonNull byte[] values) {
            return new LightSourceTypeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2BE3
     */
    @Deprecated
    public LightSourceTypeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LightSourceTypeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LightSourceTypeAndroid(@NonNull Parcel in) {
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
