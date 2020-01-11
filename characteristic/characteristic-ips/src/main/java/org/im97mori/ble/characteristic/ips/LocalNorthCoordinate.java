package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_NORTH_COORDINATE_CHARACTERISTIC;

/**
 * Local North Coordinate (Characteristics UUID: 0x2AB0)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LocalNorthCoordinate implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocalNorthCoordinate> CREATOR = new ByteArrayCreater<LocalNorthCoordinate>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalNorthCoordinate createFromParcel(@NonNull Parcel in) {
            return new LocalNorthCoordinate(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalNorthCoordinate[] newArray(int size) {
            return new LocalNorthCoordinate[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocalNorthCoordinate createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCAL_NORTH_COORDINATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocalNorthCoordinate(bluetoothGattCharacteristic);
        }

    };

    /**
     * Local North Coordinate
     */
    private final int mLocalNorthCoordinate;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB0
     */
    public LocalNorthCoordinate(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLocalNorthCoordinate = BLEUtils.createSInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocalNorthCoordinate(@NonNull Parcel in) {
        mLocalNorthCoordinate = in.readInt();
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
        dest.writeInt(mLocalNorthCoordinate);
    }

    /**
     * @return Local North Coordinate
     */
    public int getLocalNorthCoordinate() {
        return mLocalNorthCoordinate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mLocalNorthCoordinate);
        return data;
    }

}
