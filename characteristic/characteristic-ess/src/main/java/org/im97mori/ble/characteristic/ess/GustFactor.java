package org.im97mori.ble.characteristic.ess;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.GUST_FACTOR_CHARACTERISTIC;

/**
 * Gust Factor (Characteristics UUID: 0x2A74)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class GustFactor implements ByteArrayInterface, Parcelable {

    /**
     * Gust Facter Unit 0.1
     */
    public static final double GUST_FACTOR_RESOLUTION = 0.1d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<GustFactor> CREATOR = new ByteArrayCreater<GustFactor>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GustFactor createFromParcel(@NonNull Parcel in) {
            return new GustFactor(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public GustFactor[] newArray(int size) {
            return new GustFactor[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public GustFactor createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(GUST_FACTOR_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new GustFactor(bluetoothGattCharacteristic);
        }

    };

    /**
     * Gust Factor
     */
    private final int mGustFactor;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A74
     */
    public GustFactor(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mGustFactor = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private GustFactor(@NonNull Parcel in) {
        mGustFactor = in.readInt();
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
        dest.writeInt(mGustFactor);
    }

    /**
     * @return Gust Factor
     */
    public int getGustFactor() {
        return mGustFactor;
    }

    /**
     * @return Gust Factor with Unit
     */
    public double getGustFactorWithUnit() {
        return GUST_FACTOR_RESOLUTION * mGustFactor;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mGustFactor);
        return data;
    }

}
