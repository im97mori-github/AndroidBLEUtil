package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.BLEUtils;
import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LOCAL_EAST_COORDINATE_CHARACTERISTIC;

/**
 * Local East Coordinate (Characteristics UUID: 0x2AB1)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class LocalEastCoordinate implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<LocalEastCoordinate> CREATOR = new ByteArrayCreater<LocalEastCoordinate>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalEastCoordinate createFromParcel(@NonNull Parcel in) {
            return new LocalEastCoordinate(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public LocalEastCoordinate[] newArray(int size) {
            return new LocalEastCoordinate[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public LocalEastCoordinate createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LOCAL_EAST_COORDINATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new LocalEastCoordinate(bluetoothGattCharacteristic);
        }

    };

    /**
     * Local East Coordinate
     */
    private final int mLocalEastCoordinate;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB1
     */
    public LocalEastCoordinate(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLocalEastCoordinate = BLEUtils.createSInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private LocalEastCoordinate(@NonNull Parcel in) {
        mLocalEastCoordinate = in.readInt();
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
        dest.writeInt(mLocalEastCoordinate);
    }

    /**
     * @return Local East Coordinate
     */
    public int getLocalEastCoordinate() {
        return mLocalEastCoordinate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mLocalEastCoordinate);
        return data;
    }

}
