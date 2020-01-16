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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ELEVATION_CHARACTERISTIC;

/**
 * Elevation (Characteristics UUID: 0x2A6C)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Elevation implements ByteArrayInterface, Parcelable {

    /**
     * Elevation Unit 0.01 meters
     */
    public static final double ELEVATION_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Elevation> CREATOR = new ByteArrayCreater<Elevation>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Elevation createFromParcel(@NonNull Parcel in) {
            return new Elevation(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Elevation[] newArray(int size) {
            return new Elevation[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Elevation createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ELEVATION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Elevation(bluetoothGattCharacteristic);
        }

    };

    /**
     * Elevation
     */
    private final int mElevation;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6C
     */
    public Elevation(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mElevation = BLEUtils.createSInt24(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Elevation(@NonNull Parcel in) {
        mElevation = in.readInt();
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
        dest.writeInt(mElevation);
    }

    /**
     * @return Elevation
     */
    public int getElevation() {
        return mElevation;
    }

    /**
     * @return Elevation(meters)
     */
    public double getElevationMeters() {
        return ELEVATION_RESOLUTION * mElevation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[3];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mElevation);
        byteBuffer.put((byte) (mElevation >> 8));
        byteBuffer.put((byte) (mElevation >> 16));
        return data;
    }

}
