package org.im97mori.ble.characteristic.aios;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.AGGREGATE_CHARACTERISTIC;

/**
 * Aggregate (Characteristics UUID: 0x2A5A)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Aggregate implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Aggregate> CREATOR = new ByteArrayCreater<Aggregate>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Aggregate createFromParcel(@NonNull Parcel in) {
            return new Aggregate(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Aggregate[] newArray(int size) {
            return new Aggregate[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Aggregate createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(AGGREGATE_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Aggregate(bluetoothGattCharacteristic);
        }

    };

    /**
     * Input Bits and Analog Input
     */
    private final byte[] mInput;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A5A
     */
    public Aggregate(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        mInput = bluetoothGattCharacteristic.getValue();
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Aggregate(@NonNull Parcel in) {
        mInput = in.createByteArray();
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
        dest.writeByteArray(mInput);
    }

    /**
     * @param analogOffset start of analog data index
     * @return Input Bits
     */
    @NonNull
    public byte[] getInputBits(int analogOffset) {
        return Arrays.copyOfRange(mInput, 0, analogOffset);
    }

    /**
     * @param analogOffset start of analog data index
     * @return Analog Input
     */
    @NonNull
    public byte[] getAnalogInput(int analogOffset) {
        return Arrays.copyOfRange(mInput, analogOffset, mInput.length);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[mInput.length];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.put(mInput);
        return data;
    }

}
