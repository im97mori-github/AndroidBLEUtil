package org.im97mori.ble.characteristic.rtus;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC;

/**
 * Time Update Control Point (Characteristics UUID: 0x2A16)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class TimeUpdateControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 1: Get Reference Update
     */
    public static final int TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE = 1;

    /**
     * 2: Cancel Reference Update
     */
    public static final int TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE = 2;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<TimeUpdateControlPoint> CREATOR = new ByteArrayCreater<TimeUpdateControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateControlPoint createFromParcel(@NonNull Parcel in) {
            return new TimeUpdateControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public TimeUpdateControlPoint[] newArray(int size) {
            return new TimeUpdateControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public TimeUpdateControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TIME_UPDATE_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new TimeUpdateControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Time Update Control Point
     */
    private final int mTimeUpdateControlPoint;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A16
     */
    public TimeUpdateControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTimeUpdateControlPoint = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private TimeUpdateControlPoint(@NonNull Parcel in) {
        mTimeUpdateControlPoint = in.readInt();
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
        dest.writeInt(mTimeUpdateControlPoint);
    }

    /**
     * @return Time Update Control Point
     */
    public int getTimeUpdateControlPoint() {
        return mTimeUpdateControlPoint;
    }

    /**
     * @return {@code true}:Get Reference Update, {@code false}:Cancel Reference Update
     */
    public boolean isTimeUpdateControlPointGetReferenceUpdate() {
        return TIME_UPDATE_CONTROL_POINT_GET_REFERENCE_UPDATE == mTimeUpdateControlPoint;
    }

    /**
     * @return {@code true}:Cancel Reference Update, {@code false}:Get Reference Update
     */
    public boolean isTimeUpdateControlPointCancelReferenceUpdate() {
        return TIME_UPDATE_CONTROL_POINT_CANCEL_REFERENCE_UPDATE == mTimeUpdateControlPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mTimeUpdateControlPoint);
        return data;
    }

}
