package org.im97mori.characteristiccharacteristic_aios;

import android.bluetooth.BluetoothGattCharacteristic;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import org.im97mori.ble.ByteArrayCreater;
import org.im97mori.ble.ByteArrayInterface;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import org.im97mori.ble.BLEUtils;

import static org.im97mori.ble.BLEConstants.CharacteristicUUID.ANALOG_CHARACTERISTIC;

/**
 * Analog (Characteristics UUID: 0x2A58)
 */
@SuppressWarnings({"WeakerAccess", "unused"})
public class Analog implements ByteArrayInterface, Parcelable {

    /**
     * @see ByteArrayCreater
     */
    public static final ByteArrayCreater<Analog> CREATOR = new ByteArrayCreater<Analog>() {

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Analog createFromParcel(@NonNull Parcel in) {
            return new Analog(in);
        }

        /**
         * {@inheritDoc}
         */
        @Override
        @NonNull
        public Analog[] newArray(int size) {
            return new Analog[size];
        }

        /**
         * {@inheritDoc}
         */
        @NonNull
        public Analog createFromByteArray(@NonNull byte[] values) {
            BluetoothGattCharacteristic bluetoothGattCharacteristic = new BluetoothGattCharacteristic(ANALOG_CHARACTERISTIC, 0, 0);
            bluetoothGattCharacteristic.setValue(values);
            return new Analog(bluetoothGattCharacteristic);
        }

    };

    /**
     * Analog
     */
    private final int mAnalog;

    /**
     * Constructor from {@link BluetoothGattCharacteristic}
     *
     * @param bluetoothGattCharacteristic Characteristics UUID: 0x2A58
     */
    public Analog(@NonNull BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        byte[] values = bluetoothGattCharacteristic.getValue();
        mAnalog = BLEUtils.createUInt16(values, 0);
    }

    /**
     * Constructor from {@link Parcel}
     *
     * @param in Parcel
     */
    private Analog(@NonNull Parcel in) {
        mAnalog = in.readInt();
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
        dest.writeInt(mAnalog);
    }

    /**
     * @return Analog
     */
    public int getAnalog() {
        return mAnalog;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @NonNull
    public byte[] getBytes() {
        byte[] data = new byte[2];
        ByteBuffer byteBuffer = ByteBuffer.wrap(data).order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putShort((short) mAnalog);
        return data;
    }

}
