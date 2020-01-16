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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_DIRECTION_CHARACTERISTIC;

/**
 * True Wind Direction (Characteristics UUID: 0x2A71)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TrueWindDirection implements ByteArrayInterface, Parcelable {

    /**
     * True Wind Direction Unit 0.01 degrees
     */
    public static final double TRUE_WIND_DIRECTION_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrueWindDirection> CREATOR = new ByteArrayCreater<TrueWindDirection>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindDirection createFromParcel(@NonNull Parcel in) {
            return new TrueWindDirection(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindDirection[] newArray(int size) {
            return new TrueWindDirection[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrueWindDirection createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrueWindDirection(bluetoothGattCharacteristic);
        }

    };

    /**
     * True Wind Direction
     */
    private final int mTrueWindDirection;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A71
     */
    public TrueWindDirection(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTrueWindDirection = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrueWindDirection(@NonNull Parcel in) {
        mTrueWindDirection = in.readInt();
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
        dest.writeInt(mTrueWindDirection);
    }

    /**
     * @return True Wind Direction
     */
    public int getTrueWindDirection() {
        return mTrueWindDirection;
    }

    /**
     * @return True Wind Direction(degrees)
     */
    public double getTrueWindDirectionDegrees() {
        return TRUE_WIND_DIRECTION_RESOLUTION * mTrueWindDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mTrueWindDirection);
        return data;
    }

}
