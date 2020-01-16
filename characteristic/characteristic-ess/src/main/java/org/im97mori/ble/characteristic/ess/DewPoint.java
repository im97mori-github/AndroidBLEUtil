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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.DEW_POINT_CHARACTERISTIC;

/**
 * Dew Point (Characteristics UUID: 0x2A7B)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class DewPoint implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<DewPoint> CREATOR = new ByteArrayCreater<DewPoint>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DewPoint createFromParcel(@NonNull Parcel in) {
            return new DewPoint(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public DewPoint[] newArray(int size) {
            return new DewPoint[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public DewPoint createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(DEW_POINT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new DewPoint(bluetoothGattCharacteristic);
        }

    };

    /**
     * Dew Point
     */
    private final int mDewPoint;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A7B
     */
    public DewPoint(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mDewPoint = BLEUtils.createSInt8(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private DewPoint(@NonNull Parcel in) {
        mDewPoint = in.readInt();
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
        dest.writeInt(mDewPoint);
    }

    /**
     * @return Dew Point
     */
    public int getDewPoint() {
        return mDewPoint;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mDewPoint);
        return data;
    }

}
