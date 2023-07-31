package org.im97mori.ble.characteristic.u2aff;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Luminous Flux (Characteristics UUID: 0x2AFF)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousFluxAndroid extends LuminousFlux implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousFluxAndroid> CREATOR = new ByteArrayCreator<LuminousFluxAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousFluxAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxAndroid[] newArray(int size) {
            return new LuminousFluxAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousFluxAndroid createFromByteArray(@NonNull byte[] values) {
            return new LuminousFluxAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AFF
     */
    @Deprecated
    public LuminousFluxAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LuminousFluxAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param luminousFlux Luminous Flux
     */
    public LuminousFluxAndroid(int luminousFlux) {
        super(luminousFlux);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousFluxAndroid(@NonNull Parcel in) {
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
