package org.im97mori.ble.characteristic.hrs;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEART_RATE_CONTROL_POINT_CHARACTERISTIC;

/**
 * Heart Rate Control Point (Characteristics UUID: 0x2A39)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class HeartRateControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 1: Reset Energy Expended: resets the value of the Energy Expended field in the Heart Rate Measurement characteristic to 0
     */
    public static final int HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED = 1;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<HeartRateControlPoint> CREATOR = new ByteArrayCreater<HeartRateControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateControlPoint createFromParcel(@NonNull Parcel in) {
            return new HeartRateControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public HeartRateControlPoint[] newArray(int size) {
            return new HeartRateControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public HeartRateControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEART_RATE_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new HeartRateControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Heart Rate Control Point
     */
    private final int mHeartRateControlPoint;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A39
     */
    public HeartRateControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHeartRateControlPoint = values[0];
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private HeartRateControlPoint(@NonNull Parcel in) {
        mHeartRateControlPoint = in.readInt();
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
        dest.writeInt(mHeartRateControlPoint);
    }

    /**
     * @return Heart Rate Control Point
     */
    public int getHeartRateControlPoint() {
        return mHeartRateControlPoint;
    }

    /**
     * @return {@code true}:Reset Energy Expended, {@code false}:not Reset Energy Expended
     */
    public boolean isHeartRateControlPointResetEnergyExpended() {
        return HEART_RATE_CONTROL_POINT_RESET_ENERGY_EXPENDED == mHeartRateControlPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mHeartRateControlPoint);
        return data;
    }

}
