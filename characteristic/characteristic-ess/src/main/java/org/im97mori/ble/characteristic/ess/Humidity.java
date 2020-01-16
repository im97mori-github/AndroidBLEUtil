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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.HUMIDITY_CHARACTERISTIC;

/**
 * Humidity (Characteristics UUID: 0x2A6F)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Humidity implements ByteArrayInterface, Parcelable {

    /**
     * Humidity Unit 0.01 percent
     */
    public static final double HUMIDITY_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Humidity> CREATOR = new ByteArrayCreater<Humidity>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Humidity createFromParcel(@NonNull Parcel in) {
            return new Humidity(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Humidity[] newArray(int size) {
            return new Humidity[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Humidity createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(HUMIDITY_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Humidity(bluetoothGattCharacteristic);
        }

    };

    /**
     * Humidity
     */
    private final int mHumidity;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6F
     */
    public Humidity(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mHumidity = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Humidity(@NonNull Parcel in) {
        mHumidity = in.readInt();
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
        dest.writeInt(mHumidity);
    }

    /**
     * @return Humidity
     */
    public int getHumidity() {
        return mHumidity;
    }

    /**
     * @return Humidity(percent)
     */
    public double getHumidityPercent() {
        return HUMIDITY_RESOLUTION * mHumidity;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mHumidity);
        return data;
    }

}
