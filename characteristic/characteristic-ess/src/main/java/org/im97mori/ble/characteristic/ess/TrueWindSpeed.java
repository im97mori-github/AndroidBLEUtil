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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TRUE_WIND_SPEED_CHARACTERISTIC;

/**
 * True Wind Speed (Characteristics UUID: 0x2A70)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TrueWindSpeed implements ByteArrayInterface, Parcelable {

    /**
     * True Wind Speed Unit 0.01 meters per second
     */
    public static final double TRUE_WIND_SPEED_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TrueWindSpeed> CREATOR = new ByteArrayCreater<TrueWindSpeed>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindSpeed createFromParcel(@NonNull Parcel in) {
            return new TrueWindSpeed(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TrueWindSpeed[] newArray(int size) {
            return new TrueWindSpeed[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TrueWindSpeed createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TRUE_WIND_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TrueWindSpeed(bluetoothGattCharacteristic);
        }

    };

    /**
     * True Wind Speed
     */
    private final int mTrueWindSpeed;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A70
     */
    public TrueWindSpeed(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTrueWindSpeed = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TrueWindSpeed(@NonNull Parcel in) {
        mTrueWindSpeed = in.readInt();
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
        dest.writeInt(mTrueWindSpeed);
    }

    /**
     * @return True Wind Speed
     */
    public int getTrueWindSpeed() {
        return mTrueWindSpeed;
    }

    /**
     * @return True Wind Speed(meters per second)
     */
    public double getTrueWindSpeedMetersPerSecond() {
        return TRUE_WIND_SPEED_RESOLUTION * mTrueWindSpeed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mTrueWindSpeed);
        return data;
    }

}
