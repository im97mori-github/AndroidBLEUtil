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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ALTITUDE_CHARACTERISTIC;

/**
 * Altitude (Characteristics UUID: 0x2AB3)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Altitude implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Altitude> CREATOR = new ByteArrayCreater<Altitude>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Altitude createFromParcel(@NonNull Parcel in) {
            return new Altitude(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Altitude[] newArray(int size) {
            return new Altitude[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Altitude createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ALTITUDE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Altitude(bluetoothGattCharacteristic);
        }

    };

    /**
     * Altitude
     */
    private final int mAltitude;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AB3
     */
    public Altitude(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAltitude = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Altitude(@NonNull Parcel in) {
        mAltitude = in.readInt();
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
        dest.writeInt(mAltitude);
    }

    /**
     * @return Altitude
     */
    public int getAltitude() {
        return mAltitude;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mAltitude);
        return data;
    }

}
