package org.im97mori.ble.characteristic.u2aa0;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;

/**
 * Magnetic Flux Density - 2D (Characteristics UUID: 0x2AA0)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MagneticFluxDensity2DAndroid extends MagneticFluxDensity2D implements Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MagneticFluxDensity2DAndroid> CREATOR = new ByteArrayCreater<MagneticFluxDensity2DAndroid>() {

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
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MagneticFluxDensity2DAndroid(bluetoothGattCharacteristic);
        }

    };

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA0
     */
    public MagneticFluxDensity2DAndroid(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        super(bluetoothGattCharacteristic.getValue());
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
    @SuppressWarnings("ConstantConditions")
    private MagneticFluxDensity2DAndroid(@NonNull Parcel in) {
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
