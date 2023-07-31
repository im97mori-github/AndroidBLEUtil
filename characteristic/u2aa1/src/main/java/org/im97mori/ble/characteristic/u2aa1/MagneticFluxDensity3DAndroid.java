package org.im97mori.ble.characteristic.u2aa1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreator;

import java.util.Objects;

/**
 * Magnetic Flux Density - 3D (Characteristics UUID: 0x2AA1)
 */
@SuppressWarnings({"WeakerAccess"})
public class MagneticFluxDensity3DAndroid extends MagneticFluxDensity3D implements Parcelable {

    /**
     * @see ByteArrayCreator
     */
    public static final ByteArrayCreator<MagneticFluxDensity3DAndroid> CREATOR = new ByteArrayCreator<MagneticFluxDensity3DAndroid>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity3DAndroid createFromParcel(@NonNull Parcel in) {
            return new MagneticFluxDensity3DAndroid(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity3DAndroid[] newArray(int size) {
            return new MagneticFluxDensity3DAndroid[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticFluxDensity3DAndroid createFromByteArray(@NonNull byte[] values) {
            return new MagneticFluxDensity3DAndroid(values);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA1
     */
    @Deprecated
    public MagneticFluxDensity3DAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
    }

    /**
     * Constructor from byte array
     *
     * @param values byte array from <a href="https://developer.android.com/reference/android/bluetooth/BluetoothGattCharacteristic#getValue()">BluetoothGattCharacteristic#getValue()</a>
     */
    public MagneticFluxDensity3DAndroid(@NonNull byte[] values) {
        super(values);
    }

    /**
     * Constructor from parameters
     *
     * @param magneticFluxDensityXAxis Magnetic Flux Density: X-Axis
     * @param magneticFluxDensityYAxis Magnetic Flux Density: Y-Axis
     * @param magneticFluxDensityZAxis Magnetic Flux Density: Z-Axis
     */
    public MagneticFluxDensity3DAndroid(int magneticFluxDensityXAxis, int magneticFluxDensityYAxis, int magneticFluxDensityZAxis) {
        super(magneticFluxDensityXAxis, magneticFluxDensityYAxis, magneticFluxDensityZAxis);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticFluxDensity3DAndroid(@NonNull Parcel in) {
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
