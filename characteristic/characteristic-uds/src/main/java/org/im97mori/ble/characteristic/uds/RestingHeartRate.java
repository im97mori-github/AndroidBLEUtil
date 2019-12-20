package org.im97mori.ble.characteristic.uds;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;


import static org.im97mori.ble.BLEConstants.CharacteristicUUID.RESTING_HEART_RATE_CHARACTERISTIC;

/**
 * Resting Heart Rate (Characteristics UUID: 0x2A92)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class RestingHeartRate implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<RestingHeartRate> CREATOR = new ByteArrayCreater<RestingHeartRate>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RestingHeartRate createFromParcel(@NonNull Parcel in) {
            return new RestingHeartRate(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public RestingHeartRate[] newArray(int size) {
            return new RestingHeartRate[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public RestingHeartRate createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(RESTING_HEART_RATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new RestingHeartRate(bluetoothGattCharacteristic);
        }

    };

    /**
     * Resting Heart Rate
     */
    private final int mRestingHeartRate;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A92
     */
    public RestingHeartRate(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mRestingHeartRate = (values[0] & 0xff);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private RestingHeartRate(@NonNull Parcel in) {
        mRestingHeartRate = in.readInt();
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
        dest.writeInt(mRestingHeartRate);
    }

    /**
     * @return Resting Heart Rate
     */
    public int getRestingHeartRate() {
        return mRestingHeartRate;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[1];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put((byte) mRestingHeartRate);
        return data;
    }

}
