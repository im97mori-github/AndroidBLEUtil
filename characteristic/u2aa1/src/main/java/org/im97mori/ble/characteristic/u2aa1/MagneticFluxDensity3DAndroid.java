package org.im97mori.ble.characteristic.u2aa1;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;

/**
 * Magnetic Flux Density - 3D (Characteristics UUID: 0x2AA1)
 */
@SuppressWarnings({"WeakerAccess"})
public class MagneticFluxDensity3DAndroid extends MagneticFluxDensity3D implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MagneticFluxDensity3DAndroid> CREATOR = new ByteArrayCreater<MagneticFluxDensity3DAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MagneticFluxDensity3DAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA1
     */
    public MagneticFluxDensity3DAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
    @SuppressWarnings("ConstantConditions")
    private MagneticFluxDensity3DAndroid(@NonNull Parcel in) {
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
