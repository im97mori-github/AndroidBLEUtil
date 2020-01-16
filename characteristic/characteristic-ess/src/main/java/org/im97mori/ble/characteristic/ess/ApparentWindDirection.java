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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_DIRECTION_CHARACTERISTIC;

/**
 * Apparent Wind Direction (Characteristics UUID: 0x2A73)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ApparentWindDirection implements ByteArrayInterface, Parcelable {

    /**
     * Apparent Wind Direction Unit 0.01 degrees
     */
    public static final double APPARENT_WIND_DIRECTION_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ApparentWindDirection> CREATOR = new ByteArrayCreater<ApparentWindDirection>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindDirection createFromParcel(@NonNull Parcel in) {
            return new ApparentWindDirection(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindDirection[] newArray(int size) {
            return new ApparentWindDirection[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentWindDirection createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_DIRECTION_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApparentWindDirection(bluetoothGattCharacteristic);
        }

    };

    /**
     * Apparent Wind Direction
     */
    private final int mApparentWindDirection;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A73
     */
    public ApparentWindDirection(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mApparentWindDirection = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentWindDirection(@NonNull Parcel in) {
        mApparentWindDirection = in.readInt();
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
        dest.writeInt(mApparentWindDirection);
    }

    /**
     * @return Apparent Wind Direction
     */
    public int getApparentWindDirection() {
        return mApparentWindDirection;
    }

    /**
     * @return Apparent Wind Direction(degrees)
     */
    public double getApparentWindDirectionDegrees() {
        return APPARENT_WIND_DIRECTION_RESOLUTION * mApparentWindDirection;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mApparentWindDirection);
        return data;
    }

}
