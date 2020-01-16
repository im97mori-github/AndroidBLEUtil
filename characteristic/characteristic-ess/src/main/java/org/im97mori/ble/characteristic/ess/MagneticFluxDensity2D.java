package org.im97mori.ble.characteristic.ess;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC;

/**
 * Magnetic Flux Density - 2D (Characteristics UUID: 0x2AA0)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MagneticFluxDensity2D implements ByteArrayInterface, Parcelable {

    /**
     * Magnetic Flux Density: X-Axis Unit 10^-7 Tesla
     */
    public static final double MAGNETIC_FLUX_DENSITY_X_AXIS_RESOLUTION = 0.000001d;

    /**
     * Magnetic Flux Density: Y-Axis Unit 10^-7 Tesla
     */
    public static final double MAGNETIC_FLUX_DENSITY_Y_AXIS_RESOLUTION = 0.000001d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MagneticFluxDensity2D> CREATOR = new ByteArrayCreater<MagneticFluxDensity2D>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity2D createFromParcel(@NonNull Parcel in) {
            return new MagneticFluxDensity2D(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity2D[] newArray(int size) {
            return new MagneticFluxDensity2D[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticFluxDensity2D createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_2D_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MagneticFluxDensity2D(bluetoothGattCharacteristic);
        }

    };

    /**
     * Magnetic Flux Density: X-Axis
     */
    private final int mMagneticFluxDensityXAxis;

    /**
     * Magnetic Flux Density: Y-Axis
     */
    private final int mMagneticFluxDensityYAxis;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA0
     */
    public MagneticFluxDensity2D(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMagneticFluxDensityXAxis = BLEUtils.createSInt16(values, 0);
        mMagneticFluxDensityYAxis = BLEUtils.createSInt16(values, 2);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticFluxDensity2D(@NonNull Parcel in) {
        mMagneticFluxDensityXAxis = in.readInt();
        mMagneticFluxDensityYAxis = in.readInt();
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
        dest.writeInt(mMagneticFluxDensityXAxis);
        dest.writeInt(mMagneticFluxDensityYAxis);
    }

    /**
     * @return Magnetic Flux Density: X-Axis
     */
    public int getMagneticFluxDensityXAxis() {
        return mMagneticFluxDensityXAxis;
    }

    /**
     * @return Magnetic Flux Density: X-Axis(Tesla)
     */
    public double getMagneticFluxDensityXAxisTesla() {
        return MAGNETIC_FLUX_DENSITY_X_AXIS_RESOLUTION * mMagneticFluxDensityXAxis;
    }

    /**
     * @return Magnetic Flux Density: Y-Axis
     */
    public int getMagneticFluxDensityYAxis() {
        return mMagneticFluxDensityYAxis;
    }

    /**
     * @return Magnetic Flux Density: Y-Axis(Tesla)
     */
    public double getMagneticFluxDensityYAxisTesla() {
        return MAGNETIC_FLUX_DENSITY_Y_AXIS_RESOLUTION * mMagneticFluxDensityYAxis;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMagneticFluxDensityXAxis);
        byteBuffer.putShort((short) mMagneticFluxDensityYAxis);
        return data;
    }

}
