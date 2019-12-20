package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HEIGHT_CHARACTERISTIC;

/**
 * Height (Characteristics UUID: 0x2A8E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Height implements ByteArrayInterface, Parcelable {

    /**
     * Height Unit 0.01 meters
     */
    public static final double HEIGHT_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Height> CREATOR = new ByteArrayCreater<Height>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Height createFromParcel(@NonNull Parcel in) {
            return new Height(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Height[] newArray(int size) {
            return new Height[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Height createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HEIGHT_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Height(bluetoothGattCharacteristic);
        }

    };

    /**
     * Height
     */
    private final int mHeight;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A8E
     */
    public Height(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHeight = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Height(@NonNull Parcel in) {
        mHeight = in.readInt();
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
        dest.writeInt(mHeight);
    }

    /**
     * @return Height
     */
    public int getHeight() {
        return mHeight;
    }

    /**
     * @return Height(meters)
     */
    public double getHeightMeters() {
        return HEIGHT_RESOLUTION * mHeight;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mHeight);
        return data;
    }

}
