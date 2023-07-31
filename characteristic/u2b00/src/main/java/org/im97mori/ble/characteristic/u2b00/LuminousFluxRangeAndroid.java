package org.im97mori.ble.characteristic.u2b00;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Luminous Flux Range (Characteristics UUID: 0x2B00)
 */
@SuppressWarnings({"WeakerAccess"})
public class LuminousFluxRangeAndroid extends LuminousFluxRange implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<LuminousFluxRangeAndroid> CREATOR = new ByteArrayCreator<LuminousFluxRangeAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxRangeAndroid createFromParcel(@NonNull Parcel in) {
            return new LuminousFluxRangeAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LuminousFluxRangeAndroid[] newArray(int size) {
            return new LuminousFluxRangeAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LuminousFluxRangeAndroid createFromByteArray(@NonNull byte[] values) {
            return new LuminousFluxRangeAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2B00
     */
    @Deprecated
    public LuminousFluxRangeAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public LuminousFluxRangeAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param minimumLuminousFlux Minimum Luminous Flux
     * @param maximumLuminousFlux Maximum Luminous Flux
     */
    public LuminousFluxRangeAndroid(int minimumLuminousFlux, int maximumLuminousFlux) {
        super(minimumLuminousFlux, maximumLuminousFlux);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LuminousFluxRangeAndroid(@NonNull Parcel in) {
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
