package org.im97mori.ble.characteristic.u2aa0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Magnetic Flux Density - 2D (Characteristics UUID: 0x2AA0)
 */
@SuppressWarnings({"WeakerAccess"})
public class MagneticFluxDensity2DAndroid extends MagneticFluxDensity2D implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MagneticFluxDensity2DAndroid> CREATOR = new ByteArrayCreator<MagneticFluxDensity2DAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity2DAndroid createFromParcel(@NonNull Parcel in) {
            return new MagneticFluxDensity2DAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity2DAndroid[] newArray(int size) {
            return new MagneticFluxDensity2DAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticFluxDensity2DAndroid createFromByteArray(@NonNull byte[] values) {
            return new MagneticFluxDensity2DAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA0
     */
    @Deprecated
    public MagneticFluxDensity2DAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MagneticFluxDensity2DAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param magneticFluxDensityXAxis Magnetic Flux Density: X-Axis
     * @param magneticFluxDensityYAxis Magnetic Flux Density: Y-Axis
     */
    public MagneticFluxDensity2DAndroid(int magneticFluxDensityXAxis, int magneticFluxDensityYAxis) {
        super(magneticFluxDensityXAxis, magneticFluxDensityYAxis);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticFluxDensity2DAndroid(@NonNull Parcel in) {
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
