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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LONGITUDE_CHARACTERISTIC;

/**
 * Longitude (Characteristics UUID: 0x2AAF)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Longitude implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Longitude> CREATOR = new ByteArrayCreater<Longitude>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Longitude createFromParcel(@NonNull Parcel in) {
            return new Longitude(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Longitude[] newArray(int size) {
            return new Longitude[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Longitude createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LONGITUDE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Longitude(bluetoothGattCharacteristic);
        }

    };

    /**
     * Longitude
     */
    private final int mLongitude;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAF
     */
    public Longitude(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLongitude = BLEUtils.createSInt32(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Longitude(@NonNull Parcel in) {
        mLongitude = in.readInt();
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
        dest.writeInt(mLongitude);
    }

    /**
     * @return Longitude
     */
    public int getLongitude() {
        return mLongitude;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(mLongitude);
        return data;
    }

}
