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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.LATITUDE_CHARACTERISTIC;

/**
 * Latitude (Characteristics UUID: 0x2AAE)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Latitude implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Latitude> CREATOR = new ByteArrayCreater<Latitude>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Latitude createFromParcel(@NonNull Parcel in) {
            return new Latitude(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Latitude[] newArray(int size) {
            return new Latitude[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Latitude createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(LATITUDE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Latitude(bluetoothGattCharacteristic);
        }

    };

    /**
     * Latitude
     */
    private final int mLatitude;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2AAE
     */
    public Latitude(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mLatitude = BLEUtils.createSInt32(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Latitude(@NonNull Parcel in) {
        mLatitude = in.readInt();
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
        dest.writeInt(mLatitude);
    }

    /**
     * @return Latitude
     */
    public int getLatitude() {
        return mLatitude;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[4];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(mLatitude);
        return data;
    }

}
