package org.im97mori.ble.characteristic.ess;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC;

/**
 * Magnetic Flux Density - 3D (Characteristics UUID: 0x2AA1)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class MagneticFluxDensity3D implements ByteArrayInterface, Parcelable {

    /**
     * Magnetic Flux Density: X-Axis Unit 10^-7 Tesla
     */
    public static final double MAGNETIC_FLUX_DENSITY_X_AXIS_RESOLUTION = 0.000001d;

    /**
     * Magnetic Flux Density: Y-Axis Unit 10^-7 Tesla
     */
    public static final double MAGNETIC_FLUX_DENSITY_Y_AXIS_RESOLUTION = 0.000001d;

    /**
     * Magnetic Flux Density: Z-Axis Unit 10^-7 Tesla
     */
    public static final double MAGNETIC_FLUX_DENSITY_Z_AXIS_RESOLUTION = 0.000001d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<MagneticFluxDensity3D> CREATOR = new ByteArrayCreater<MagneticFluxDensity3D>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity3D createFromParcel(@NonNull Parcel in) {
            return new MagneticFluxDensity3D(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public MagneticFluxDensity3D[] newArray(int size) {
            return new MagneticFluxDensity3D[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public MagneticFluxDensity3D createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(MAGNETIC_FLUX_DENSITY_3D_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new MagneticFluxDensity3D(bluetoothGattCharacteristic);
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
     * Magnetic Flux Density: Z-Axis
     */
    private final int mMagneticFluxDensityZAxis;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AA1
     */
    public MagneticFluxDensity3D(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mMagneticFluxDensityXAxis = BLEUtils.createSInt16(values, 0);
        mMagneticFluxDensityYAxis = BLEUtils.createSInt16(values, 2);
        mMagneticFluxDensityZAxis = BLEUtils.createSInt16(values, 4);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private MagneticFluxDensity3D(@NonNull Parcel in) {
        mMagneticFluxDensityXAxis = in.readInt();
        mMagneticFluxDensityYAxis = in.readInt();
        mMagneticFluxDensityZAxis = in.readInt();
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
        dest.writeInt(mMagneticFluxDensityZAxis);
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
     * @return Magnetic Flux Density: Z-Axis
     */
    public int getMagneticFluxDensityZAxis() {
        return mMagneticFluxDensityZAxis;
    }

    /**
     * @return Magnetic Flux Density: Z-Axis(Tesla)
     */
    public double getMagneticFluxDensityZAxisTesla() {
        return MAGNETIC_FLUX_DENSITY_Z_AXIS_RESOLUTION * mMagneticFluxDensityZAxis;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[6];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mMagneticFluxDensityXAxis);
        byteBuffer.putShort((short) mMagneticFluxDensityYAxis);
        byteBuffer.putShort((short) mMagneticFluxDensityZAxis);
        return data;
    }

}
