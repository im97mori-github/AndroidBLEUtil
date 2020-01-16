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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.APPARENT_WIND_SPEED_CHARACTERISTIC;

/**
 * Apparent Wind Speed (Characteristics UUID: 0x2A72)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class ApparentWindSpeed implements ByteArrayInterface, Parcelable {

    /**
     * Apparent Wind Speed Unit 0.01 meters per second
     */
    public static final double APPARENT_WIND_SPEED_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<ApparentWindSpeed> CREATOR = new ByteArrayCreater<ApparentWindSpeed>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindSpeed createFromParcel(@NonNull Parcel in) {
            return new ApparentWindSpeed(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public ApparentWindSpeed[] newArray(int size) {
            return new ApparentWindSpeed[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public ApparentWindSpeed createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(APPARENT_WIND_SPEED_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new ApparentWindSpeed(bluetoothGattCharacteristic);
        }

    };

    /**
     * Apparent Wind Speed
     */
    private final int mApparentWindSpeed;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A72
     */
    public ApparentWindSpeed(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mApparentWindSpeed = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private ApparentWindSpeed(@NonNull Parcel in) {
        mApparentWindSpeed = in.readInt();
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
        dest.writeInt(mApparentWindSpeed);
    }

    /**
     * @return Apparent Wind Speed
     */
    public int getApparentWindSpeed() {
        return mApparentWindSpeed;
    }

    /**
     * @return Apparent Wind Speed(meters per second)
     */
    public double getApparentWindSpeedMetersPerSecond() {
        return APPARENT_WIND_SPEED_RESOLUTION * mApparentWindSpeed;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mApparentWindSpeed);
        return data;
    }

}
