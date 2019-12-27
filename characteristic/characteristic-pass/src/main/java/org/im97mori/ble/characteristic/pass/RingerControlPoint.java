package org.im97mori.ble.characteristic.pass;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RINGER_CONTROL_POINT_CHARACTERISTIC;

/**
 * Ringer Control point (Characteristics UUID: 0x2A40)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RingerControlPoint implements ByteArrayInterface, Parcelable {

    /**
     * 1: Silent Mode
     */
    public static final int RINGER_CONTROL_POINT_SILENT_MODE = 1;

    /**
     * 2: Mute Once
     */
    public static final int RINGER_CONTROL_POINT_MUTE_ONCE = 2;

    /**
     * 3: Cancel Silent Mode
     */
    public static final int RINGER_CONTROL_POINT_CANCEL_SILENT_MODE = 3;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RingerControlPoint> CREATOR = new ByteArrayCreater<RingerControlPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerControlPoint createFromParcel(@NonNull Parcel in) {
            return new RingerControlPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RingerControlPoint[] newArray(int size) {
            return new RingerControlPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RingerControlPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RINGER_CONTROL_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RingerControlPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Ringer Control Point
     */
    private final int mRingerControlPoint;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A40
     */
    public RingerControlPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mRingerControlPoint = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RingerControlPoint(@NonNull Parcel in) {
        mRingerControlPoint = in.readInt();
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
        dest.writeInt(mRingerControlPoint);
    }

    /**
     * @return Ringer Control Point
     */
    public int getRingerControlPoint() {
        return mRingerControlPoint;
    }

    /**
     * @return {@code true}:Silent Mode, {@code false}:not Silent Mode
     */
    public boolean isRingerControlPointSilentMode() {
        return RINGER_CONTROL_POINT_SILENT_MODE == mRingerControlPoint;
    }

    /**
     * @return {@code true}:Mute Once, {@code false}:not Mute Once
     */
    public boolean isRingerControlPointMuteOnce() {
        return RINGER_CONTROL_POINT_MUTE_ONCE == mRingerControlPoint;
    }

    /**
     * @return {@code true}:Cancel Silent Mode, {@code false}:not Cancel Silent Mode
     */
    public boolean isRingerControlPointCancelSilentMode() {
        return RINGER_CONTROL_POINT_CANCEL_SILENT_MODE == mRingerControlPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mRingerControlPoint);
        return data;
    }

}
