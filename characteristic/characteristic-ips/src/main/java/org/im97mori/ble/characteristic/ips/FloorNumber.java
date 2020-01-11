package org.im97mori.ble.characteristic.ips;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.FLOOR_NUMBER_CHARACTERISTIC;

/**
 * Floor Number (Characteristics UUID: 0x2AB2)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class FloorNumber implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<FloorNumber> CREATOR = new ByteArrayCreater<FloorNumber>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FloorNumber createFromParcel(@NonNull Parcel in) {
            return new FloorNumber(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public FloorNumber[] newArray(int size) {
            return new FloorNumber[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public FloorNumber createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(FLOOR_NUMBER_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new FloorNumber(bluetoothGattCharacteristic);
        }

    };

    /**
     * Floor Number
     */
    private final int mFloorNumber;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB2
     */
    public FloorNumber(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mFloorNumber = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private FloorNumber(@NonNull Parcel in) {
        mFloorNumber = in.readInt();
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
        dest.writeInt(mFloorNumber);
    }

    /**
     * @return Floor Number
     */
    public int getFloorNumber() {
        return mFloorNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mFloorNumber);
        return data;
    }

}
