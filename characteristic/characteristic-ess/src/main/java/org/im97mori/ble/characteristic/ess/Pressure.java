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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.PRESSURE_CHARACTERISTIC;

/**
 * Pressure (Characteristics UUID: 0x2A6D)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Pressure implements ByteArrayInterface, Parcelable {

    /**
     * Pressure Unit 0.1 pascals
     */
    public static final double PRESSURE_RESOLUTION = 0.1d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Pressure> CREATOR = new ByteArrayCreater<Pressure>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Pressure createFromParcel(@NonNull Parcel in) {
            return new Pressure(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Pressure[] newArray(int size) {
            return new Pressure[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Pressure createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(PRESSURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Pressure(bluetoothGattCharacteristic);
        }

    };

    /**
     * Pressure
     */
    private final long mPressure;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6D
     */
    public Pressure(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mPressure = BLEUtils.createUInt32(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Pressure(@NonNull Parcel in) {
        mPressure = in.readLong();
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
        dest.writeLong(mPressure);
    }

    /**
     * @return Pressure
     */
    public long getPressure() {
        return mPressure;
    }

    /**
     * @return Pressure(pascals)
     */
    public double getPressurePascals() {
        return PRESSURE_RESOLUTION * mPressure;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt((int) mPressure);
        return data;
    }

}
