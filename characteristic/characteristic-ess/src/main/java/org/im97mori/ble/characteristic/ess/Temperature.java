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

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.TEMPERATURE_CHARACTERISTIC;

/**
 * Temperature (Characteristics UUID: 0x2A6E)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Temperature implements ByteArrayInterface, Parcelable {

    /**
     * Temperature Unit 0.01 degrees Celsius
     */
    public static double TEMPERATURE_RESOLUTION = 0.01d;

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Temperature> CREATOR = new ByteArrayCreater<Temperature>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature createFromParcel(@NonNull Parcel in) {
            return new Temperature(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Temperature[] newArray(int size) {
            return new Temperature[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Temperature createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(TEMPERATURE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Temperature(bluetoothGattCharacteristic);
        }

    };

    /**
     * Temperature
     */
    private final int mTemperature;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A6E
     */
    public Temperature(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mTemperature = BLEUtils.createSInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Temperature(@NonNull Parcel in) {
        mTemperature = in.readInt();
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
        dest.writeInt(mTemperature);
    }

    /**
     * @return Temperature
     */
    public int getTemperature() {
        return mTemperature;
    }

    /**
     * @return Temperature(degrees Celsius)
     */
    public double getTemperatureDegreesCelsius() {
        return TEMPERATURE_RESOLUTION * mTemperature;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mTemperature);
        return data;
    }

}
